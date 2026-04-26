package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.configs.EmployeeDocumentConfig;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentBasicInfoUpdateDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.error.StudentErrors;
import com.smartsolutions.eschool.student.mapper.StudentMapper;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.model.StudentDocumentEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.AdmissionTypeRepository;
import com.smartsolutions.eschool.student.repository.StudentDocumentRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final EmployeeDocumentConfig feeConfig;
    private final StudentRepository studentRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final AcademicYearRepository academicYearRepository;
    private final AdmissionTypeRepository admissionTypeRepository;
    private final StudentDocumentRepository studentDocumentRepository;

    private Long getOrgId() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, "Organization ID not found in security context", HttpStatus.FORBIDDEN);
        }
        return orgId;
    }

    public List<StudentDTO> getAll() {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getAll() called - fetching all students for org: {}", orgId);
        try {
            AcademicYearEntity academicYear = academicYearRepository.findByIsCurrentTrue()
                    .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Current academic year not found", HttpStatus.NOT_FOUND));

            List<StudentEntity> result = studentRepository.findAllWithAssignments(academicYear.getId(), orgId);
            result.forEach(StudentEntity::calculateFeeAssigned);
            return StudentMapper.toDTOList(result);
        } catch (DataAccessException dae) {
            log.error("[Service:StudentService] Database error while fetching Students", dae);
            return Collections.emptyList();
        }
    }

    public List<StudentDTO> getActive() {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getActive() called for org: {}", orgId);
        return StudentMapper.toDTOList(studentRepository.findAllByOrganizationIdAndIsActiveTrue(orgId));
    }

    public List<StudentDTO> getInactive() {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getInactive() called for org: {}", orgId);
        return StudentMapper.toDTOList(studentRepository.findAllByOrganizationIdAndIsActiveFalse(orgId));
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getStudentsByCampus() called for campus: {} org: {}", campusId, orgId);
        return StudentMapper.toDTOList(studentRepository.findByCampusIdAndOrganizationId(campusId, orgId));
    }

    public List<StudentDTO> getStudentsByName(String studentName) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getStudentsByName() called for name: {} org: {}", studentName, orgId);
        return StudentMapper.toDTOList(studentRepository.searchByKeywordAndOrganizationId(studentName, orgId));
    }

    public List<StudentDTO> getStudentsByStandard(Long standardId) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getStudentsByStandard() called for standard: {} org: {}", standardId, orgId);
        return StudentMapper.toDTOList(studentRepository.findByStandardIdAndOrganizationId(standardId, orgId));
    }

    public List<StudentDTO> getStudentsBySection(Long sectionId) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getStudentsBySection() called for section: {} org: {}", sectionId, orgId);
        return StudentMapper.toDTOList(studentRepository.findBySectionIdAndOrganizationId(sectionId, orgId));
    }

    public StudentResponseDTO getById(Long id) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getById() called for ID: {} org: {}", id, orgId);
        StudentEntity studentEntity = studentRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with id: " + id, HttpStatus.NOT_FOUND));
        return StudentMapper.toResponseDTO(studentEntity);
    }

    public StudentDTO getByStudentCode(String studentCode) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] getByStudentCode() called for code: {} org: {}", studentCode, orgId);
        StudentEntity studentEntity = studentRepository.findByStudentCodeAndOrganizationId(studentCode, orgId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with code: " + studentCode, HttpStatus.NOT_FOUND));
        return StudentMapper.toDTO(studentEntity);
    }

    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO studentDTO) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] createStudent() called for org: {} DTO: {}", orgId, studentDTO);

        if (studentDTO.getStudentCode() != null && !studentDTO.getStudentCode().trim().isEmpty() &&
                studentRepository.existsByOrganizationIdAndStudentCode(orgId, studentDTO.getStudentCode())) {
            throw new ApiException(StudentErrors.DUPLICATE_STUDENT_CODE, "Student code already exists in this organization", HttpStatus.CONFLICT);
        }

        CampusEntity campus = campusRepository.findById(studentDTO.getCampusId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Campus not found", HttpStatus.BAD_REQUEST));
        StandardEntity standard = standardRepository.findById(studentDTO.getStandardId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Standard not found", HttpStatus.BAD_REQUEST));
        SectionEntity section = sectionRepository.findById(studentDTO.getSectionId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Section not found", HttpStatus.BAD_REQUEST));
        AdmissionTypeEntity admissionType = admissionTypeRepository.findById(studentDTO.getAdmissionTypeId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Admission Type not found", HttpStatus.BAD_REQUEST));
        AcademicYearEntity academicYear = academicYearRepository.findById(studentDTO.getAcademicYearId() != null ? studentDTO.getAcademicYearId() : 0L)
                .orElseGet(() -> academicYearRepository.findByIsCurrentTrue()
                        .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Academic Year not found", HttpStatus.BAD_REQUEST)));

        StudentEntity studentEntity = StudentMapper.toEntity(studentDTO);
        studentEntity.setCampus(campus);
        studentEntity.setStandard(standard);
        studentEntity.setSection(section);
        studentEntity.setAdmissionType(admissionType);
        studentEntity.setAcademicYear(academicYear);

        StudentEntity savedStudent = studentRepository.save(studentEntity);
        log.info("[Service:StudentService] Successfully created Student: {}", savedStudent.getId());
        return StudentMapper.toResponseDTO(savedStudent);
    }

    @Transactional
    public StudentResponseDTO updateStudent(Long studentId, StudentRequestDTO requestDTO) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] updateStudent() called for id: {} org: {}", studentId, orgId);

        StudentEntity entity = studentRepository.findByIdAndOrganizationId(studentId, orgId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with id: " + studentId, HttpStatus.NOT_FOUND));

        if (requestDTO.getStudentCode() != null && !requestDTO.getStudentCode().equals(entity.getStudentCode()) &&
                studentRepository.existsByOrganizationIdAndStudentCodeAndIdNot(orgId, requestDTO.getStudentCode(), studentId)) {
            throw new ApiException(StudentErrors.DUPLICATE_STUDENT_CODE, "Student code already exists", HttpStatus.CONFLICT);
        }

        if (requestDTO.getCampusId() != null && !requestDTO.getCampusId().equals(entity.getCampus().getId())) {
             entity.setCampus(campusRepository.findById(requestDTO.getCampusId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Campus not found", HttpStatus.BAD_REQUEST)));
        }
        if (requestDTO.getStandardId() != null && !requestDTO.getStandardId().equals(entity.getStandard().getId())) {
             entity.setStandard(standardRepository.findById(requestDTO.getStandardId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Standard not found", HttpStatus.BAD_REQUEST)));
        }
        if (requestDTO.getSectionId() != null && !requestDTO.getSectionId().equals(entity.getSection().getId())) {
             entity.setSection(sectionRepository.findById(requestDTO.getSectionId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Section not found", HttpStatus.BAD_REQUEST)));
        }
        if (requestDTO.getAdmissionTypeId() != null && (entity.getAdmissionType() == null || !requestDTO.getAdmissionTypeId().equals(entity.getAdmissionType().getId()))) {
             entity.setAdmissionType(admissionTypeRepository.findById(requestDTO.getAdmissionTypeId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Admission Type not found", HttpStatus.BAD_REQUEST)));
        }
        if (requestDTO.getAcademicYearId() != null && !requestDTO.getAcademicYearId().equals(entity.getAcademicYear().getId())) {
             entity.setAcademicYear(academicYearRepository.findById(requestDTO.getAcademicYearId())
                .orElseThrow(() -> new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Academic Year not found", HttpStatus.BAD_REQUEST)));
        }

        StudentMapper.updateEntityFromDTO(entity, requestDTO);
        StudentEntity updated = studentRepository.save(entity);
        log.info("[Service:StudentService] Successfully updated Student: {}", updated.getId());
        return StudentMapper.toResponseDTO(updated);
    }

    @Transactional
    public StudentResponseDTO updateStudentBasicInfo(Long studentId, StudentBasicInfoUpdateDTO basicInfoDTO) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] updateStudentBasicInfo() called for id: {} org: {}", studentId, orgId);

        StudentEntity entity = studentRepository.findByIdAndOrganizationId(studentId, orgId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with id: " + studentId, HttpStatus.NOT_FOUND));

        // Update only basic info fields
        entity.setFirstName(basicInfoDTO.getFirstName());
        entity.setMiddleName(basicInfoDTO.getMiddleName());
        entity.setLastName(basicInfoDTO.getLastName());
        entity.setFullName(basicInfoDTO.getFullName());
        entity.setDateOfBirth(basicInfoDTO.getDateOfBirth());
        entity.setGender(basicInfoDTO.getGender());
        entity.setCnic(basicInfoDTO.getCnic());
        entity.setPassportNumber(basicInfoDTO.getPassportNumber());
        entity.setPhone(basicInfoDTO.getPhone());
        entity.setEmail(basicInfoDTO.getEmail());
        entity.setReligion(basicInfoDTO.getReligion());
        entity.setNationality(basicInfoDTO.getNationality());
        entity.setBloodGroup(basicInfoDTO.getBloodGroup());

        StudentEntity updated = studentRepository.save(entity);
        log.info("[Service:StudentService] Successfully updated basic info for Student: {}", updated.getId());
        return StudentMapper.toResponseDTO(updated);
    }

    @Transactional
    public void softDeleteStudent(Long studentId) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] softDeleteStudent() called for id: {} org: {}", studentId, orgId);
        int updated = studentRepository.softDeleteByIdAndOrganizationId(studentId, orgId);
        if (updated == 0) {
            throw new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with id: " + studentId, HttpStatus.NOT_FOUND);
        }
    }

    public List<StudentDTO> searchStudents(Long campusId, Long standardId, Long sectionId, Long studentId, Long academicYearId, String kw) {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] searchStudents() called for org: {}", orgId);
        try {
            List<StudentEntity> result = studentRepository.searchStudentsWithFilters(campusId, standardId, sectionId, studentId, academicYearId, kw, orgId);
            return StudentMapper.toDTOList(result);
        } catch (Exception e) {
            log.error("[Service:StudentService] Error searching students", e);
            return Collections.emptyList();
        }
    }

    public void saveStudentDocument(Long studentId, String docKey, MultipartFile file) throws IOException {
        Long orgId = getOrgId();
        log.info("[Service:StudentService] saveStudentDocument() called for student: {} org: {}", studentId, orgId);
        
        // Verify student belongs to org
        studentRepository.findByIdAndOrganizationId(studentId, orgId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Student not found with id: " + studentId, HttpStatus.NOT_FOUND));

        String uploadDir = "uploads/org_" + orgId + "/students_" + studentId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
        String fileName = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        StudentDocumentEntity document = StudentDocumentEntity.builder()
                .studentId(studentId)
                .documentType(docKey)
                .fileName(fileName)
                .filePath(filePath.toString())
                .fileType(FilenameUtils.getExtension(fileName).toUpperCase())
                .build();
        studentDocumentRepository.save(document);
    }

    public List<StudentDocumentResponseDto> getDocumentsByStudentId(Long studentId) {
        log.info("[Service:StudentService] getDocumentsByStudentId() called for student: {}", studentId);
        List<StudentDocumentEntity> documents = studentDocumentRepository.findByStudentId(studentId);
        if (documents.isEmpty()) {
            return Collections.emptyList();
        }
        return MapperUtil.mapList(documents, StudentDocumentResponseDto.class);
    }

    public Map<String, List<StudentDocumentResponseDto>> getGroupedDocuments(Long studentId) {
        List<StudentDocumentResponseDto> documents = getDocumentsByStudentId(studentId);
        if (documents.isEmpty()) return Collections.emptyMap();
        return documents.stream().collect(Collectors.groupingBy(doc -> 
                feeConfig.getDocumentTypes().getOrDefault(doc.getDocumentType(), "Other")));
    }

    public Resource downloadDocument(Long documentId, Long studentId) {
        StudentDocumentEntity document = studentDocumentRepository.findDocumentByIdAndStudentId(documentId, studentId)
                .orElseThrow(() -> new ApiException(StudentErrors.STUDENT_NOT_FOUND, "Document not found", HttpStatus.NOT_FOUND));
        Path path = Paths.get(document.getFilePath());
        try {
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new FileNotFoundException("File not found: " + document.getFilePath());
            }
            return resource;
        } catch (Exception e) {
            throw new ApiException(StudentErrors.INVALID_STUDENT_DATA, "Error reading document file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Long getTotalStudents() {
        return studentRepository.countAllActiveStudents(getOrgId());
    }

    public Long getTotalStudentsByCampus(Long campusId) {
        return studentRepository.countByCampusAndOrganizationId(campusId, getOrgId());
    }

    public Long getTotalStudentsByStandard(Long standardId) {
        return studentRepository.countByStandardAndOrganizationId(standardId, getOrgId());
    }

    public Long getTotalStudentsBySection(Long sectionId) {
        return studentRepository.countBySectionAndOrganizationId(sectionId, getOrgId());
    }

    public Long getTotalStudentsByGender(String gender) {
        return studentRepository.countByGenderAndOrganizationId(gender, getOrgId());
    }

    public Long getStudentsRegisteredThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();
        return studentRepository.countStudentsRegisteredBetweenAndOrganizationId(start, end, getOrgId());
    }

    public Long countStudents(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] countStudents() - orgId: {}, campusIds: {}, to: {}", 
                 orgId, filter.getCampusIds(), filter.getToDate());
        Long count = studentRepository.countByFilters(filter.getCampusIds(), filter.getAcademicYearId(), filter.getFromDate(), filter.getToDate(), orgId);
        log.info("[Service:StudentService] countStudents() succeed - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Long countActiveStudents(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] countActiveStudents() called - orgId: {}", orgId);
        Long count = studentRepository.countActiveByFilters(filter.getCampusIds(), filter.getAcademicYearId(), filter.getFromDate(), filter.getToDate(), orgId);
        log.info("[Service:StudentService] countActiveStudents() succeeded - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Long countInactiveStudents(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] countInactiveStudents() called - orgId: {}", orgId);
        Long count = studentRepository.countInactiveByFilters(filter.getCampusIds(), filter.getAcademicYearId(), filter.getFromDate(), filter.getToDate(), orgId);
        log.info("[Service:StudentService] countInactiveStudents() succeeded - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Long countWithdrawals(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        LocalDate from = filter.getFromDate() != null ? filter.getFromDate() : LocalDate.now().minusMonths(1);
        LocalDate to = filter.getToDate() != null ? filter.getToDate() : LocalDate.now();
        java.time.LocalDateTime fromDateTime = from.atStartOfDay();
        java.time.LocalDateTime toDateTime = to.atTime(java.time.LocalTime.MAX);
        
        log.info("[Service:StudentService] countWithdrawals() - orgId: {}, from: {}, to: {}", orgId, fromDateTime, toDateTime);
        Long count = studentRepository.countWithdrawals(fromDateTime, toDateTime, filter.getCampusIds(), orgId);
        log.info("[Service:StudentService] countWithdrawals() succeeded - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Long countNewAdmissions(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        LocalDate from = filter.getFromDate() != null ? filter.getFromDate() : LocalDate.now().minusMonths(1);
        LocalDate to = filter.getToDate() != null ? filter.getToDate() : LocalDate.now();
        log.info("[Service:StudentService] countNewAdmissions() - orgId: {}, campusIds: {}, from: {}, to: {}", 
                 orgId, filter.getCampusIds(), from, to);
        Long count = studentRepository.countNewAdmissions(from, to, filter.getCampusIds(), filter.getStandardId(), filter.getSectionId(), orgId);
        log.info("[Service:StudentService] countNewAdmissions() succeeded - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.Map<String, Long> getGenderDistribution(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] getGenderDistribution() called - orgId: {}", orgId);
        java.util.List<Object[]> results = studentRepository.countByGenderDistribution(filter.getCampusIds(), filter.getFromDate(), filter.getToDate(), orgId);
        Map<String, Long> distribution = new HashMap<>();
        for (Object[] row : results) {
            String gender = row[0] != null ? row[0].toString() : "Unknown";
            distribution.put(gender, (Long) row[1]);
        }
        log.info("[Service:StudentService] getGenderDistribution() succeeded - found distributions: {}", distribution.size());
        return distribution;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Map<String, Long> getStudentsByStandardDistribution(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] getStudentsByStandardDistribution() called - orgId: {}", orgId);
        List<Object[]> results = studentRepository.countByStandardDistribution(filter.getCampusIds(), filter.getToDate(), orgId);
        Map<String, Long> distribution = new HashMap<>();
        for (Object[] row : results) {
            String standard = row[0] != null ? row[0].toString() : "N/A";
            distribution.put(standard, (Long) row[1]);
        }
        log.info("[Service:StudentService] getStudentsByStandardDistribution() succeeded - found distributions: {}", distribution.size());
        return distribution;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Object[]> getAdmissionsTrend(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] getAdmissionsTrend() called - orgId: {}", orgId);
        LocalDate from = filter.getFromDate() != null ? filter.getFromDate() : LocalDate.now().minusMonths(1);
        LocalDate to = filter.getToDate() != null ? filter.getToDate() : LocalDate.now();
        List<Object[]> results = studentRepository.getAdmissionsTrend(from, to, filter.getCampusIds(), orgId);
        log.info("[Service:StudentService] getAdmissionsTrend() succeeded - found entries: {}", results.size());
        return results;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Object[]> getGenderDistributionChart(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] getGenderDistributionChart() called - orgId: {}", orgId);
        List<Object[]> results = studentRepository.getGenderDistribution(filter.getCampusIds(), filter.getToDate(), orgId);
        log.info("[Service:StudentService] getGenderDistributionChart() succeeded");
        return results;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Object[]> getClassStrengthChart(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:StudentService] getClassStrengthChart() called - orgId: {}", orgId);
        List<Object[]> results = studentRepository.getStudentStrengthByStandard(filter.getCampusIds(), filter.getToDate(), orgId);
        log.info("[Service:StudentService] getClassStrengthChart() succeeded");
        return results;
    }
}
