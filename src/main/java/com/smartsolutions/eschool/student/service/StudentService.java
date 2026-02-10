package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.model.EmployeeDocumentEntity;
import com.smartsolutions.eschool.global.configs.EmployeeDocumentConfig;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.mapper.StudentMapper;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.model.StudentDocumentEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.AdmissionTypeRepository;
import com.smartsolutions.eschool.student.repository.StudentDocumentRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
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

    public StudentService(EmployeeDocumentConfig feeConfig, StudentRepository studentRepository, CampusRepository campusRepository, StandardRepository standardRepository, SectionRepository sectionRepository, AcademicYearRepository academicYearRepository, AdmissionTypeRepository admissionTypeRepository, StudentDocumentRepository studentDocumentRepository) {
        this.feeConfig = feeConfig;
        this.studentRepository = studentRepository;
        this.campusRepository = campusRepository;
        this.standardRepository = standardRepository;
        this.sectionRepository = sectionRepository;
        this.academicYearRepository = academicYearRepository;
        this.admissionTypeRepository = admissionTypeRepository;
        this.studentDocumentRepository = studentDocumentRepository;
    }

    public List<StudentDTO> getAll() {
        try {
            log.info("Fetching all Students from database");

            AcademicYearEntity academicYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> new ResourceNotFoundException("Academic year not found"));

            List<StudentEntity> result = studentRepository.findAllWithAssignments(academicYear.getId());
            result.forEach(StudentEntity::calculateFeeAssigned);

            log.info("Successfully fetched {} Students", result.size());
            List<StudentDTO> studentDTOList = StudentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students", dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        try {
            log.info("Fetching all Students by Campus from database");
            List<StudentEntity> result = studentRepository.findByCampusId(campusId);
            log.info("Successfully fetched {} Students by Campus", result.size());
            List<StudentDTO> studentDTOList = StudentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Campus", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Campus", dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Campus", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByName(String studentName) {
        try {
            log.info("Fetching all Students by Name from database");
            List<StudentEntity> result = studentRepository.searchStudentsByName(studentName);
            log.info("Successfully fetched {} Students by Name", result.size());
            List<StudentDTO> studentDTOList = StudentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Name", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Name", dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Name", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByStandard(Long standardId) {
        try {
            log.info("Fetching all Students by Standard from database");
            List<StudentEntity> result = studentRepository.findByStandardId(standardId);
            log.info("Successfully fetched {} Students by Standard", result.size());
            List<StudentDTO> studentDTOList = StudentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Standard", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Standard", dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Standard", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsBySection(Long sectionId) {
        try {
            log.info("Fetching all Students by Section from database");
            List<StudentEntity> result = studentRepository.findBySectionId(sectionId);
            log.info("Successfully fetched {} Students by Section", result.size());
            List<StudentDTO> studentDTOList = StudentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Section", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Section", dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Section", e);
        }
        return Collections.emptyList();
    }

    public StudentResponseDTO getById(Long id) {
        log.info("Fetching Student with id: {}", id);
        StudentEntity studentEntity = studentRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Student with id: {}", id);
            return new ResourceNotFoundException("Student not found with id: " + id);
        });
        StudentResponseDTO studentDTO = StudentMapper.toResponseDTO(studentEntity);
        log.info("Successfully fetched student: id={}", studentDTO.getId());
        return studentDTO;
    }

    public StudentDTO getByStudentCode(String studentCode) {
        log.info("Fetching Student with studentCode: {}", studentCode);
        StudentEntity studentEntity = studentRepository.findByStudentCode(studentCode).orElseThrow(() -> {
            log.info("Fetching Student with studentCode: {}", studentCode);
            return new ResourceNotFoundException("Student not found with id: " + studentCode);
        });
        StudentDTO studentDTO = StudentMapper.toDTO(studentEntity);
        log.info("Successfully fetched student: id={}", studentDTO.getStudentCode());
        return studentDTO;
    }

    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO studentDTO) {
        log.info("Creating new Student: {}", studentDTO);

        // Fetch related entities from DB
        CampusEntity campus = campusRepository.findById(studentDTO.getCampusId()).orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + studentDTO.getCampusId()));
        StandardEntity standard = standardRepository.findById(studentDTO.getStandardId()).orElseThrow(() -> new ResourceNotFoundException("Standard not found with id: " + studentDTO.getStandardId()));
        SectionEntity section = sectionRepository.findById(studentDTO.getSectionId()).orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + studentDTO.getSectionId()));
        AdmissionTypeEntity admissionType = admissionTypeRepository.findById(studentDTO.getAdmissionTypeId()).orElseThrow(() -> new ResourceNotFoundException("Admission Type not found with id: " + studentDTO.getAdmissionTypeId()));
        AcademicYearEntity academicYear = academicYearRepository.findById(studentDTO.getAcademicYearId()).orElseThrow(() -> new ResourceNotFoundException("Academic Year not found with id: " + studentDTO.getAcademicYearId()));

        // Manual mapping from DTO to Entity
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setMiddleName(studentDTO.getMiddleName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setFullName(studentDTO.getFullName());
        studentEntity.setStudentCode(studentDTO.getStudentCode());
        studentEntity.setDateOfBirth(studentDTO.getDateOfBirth());
        studentEntity.setGender(studentDTO.getGender());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhone(studentDTO.getPhone());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setCnic(studentDTO.getCnic());
        studentEntity.setPassportNumber(studentDTO.getPassportNumber());
        studentEntity.setReligion(studentDTO.getReligion());
        studentEntity.setNationality(studentDTO.getNationality());
        studentEntity.setBloodGroup(studentDTO.getBloodGroup());
        studentEntity.setEnrollmentDate(studentDTO.getEnrollmentDate());
        studentEntity.setIsActive(studentDTO.getIsActive() != null ? studentDTO.getIsActive() : true);
        studentEntity.setStatus(studentDTO.getStatus());
        studentEntity.setDeleted(false);

        // Assign existing related entities
        studentEntity.setCampus(campus);
        studentEntity.setStandard(standard);
        studentEntity.setSection(section);
        studentEntity.setAdmissionType(admissionType);
        studentEntity.setAcademicYear(academicYear);

        // Save entity
        StudentEntity savedStudent = studentRepository.save(studentEntity);

        String year = String.valueOf(LocalDate.now().getYear());
        String identity = "STU"; // default identity
        String regNo = String.format("REG%s-%s-%03d", year, identity.toUpperCase(), savedStudent.getId());

        savedStudent.setStudentCode(regNo);
        savedStudent = studentRepository.save(studentEntity);

        // Map back to DTO for response
        StudentResponseDTO responseDTO = StudentMapper.toResponseDTO(savedStudent);

        log.info("Successfully created Student: {}", responseDTO);
        return responseDTO;
    }


    public Long getTotalStudents() {
        return studentRepository.countAllActiveStudents();
    }

    public Long getTotalStudentsByCampus(Long campusId) {
        return studentRepository.countByCampus(campusId);
    }

    public Long getTotalStudentsByStandard(Long standardId) {
        return studentRepository.countByStandard(standardId);
    }

    public Long getTotalStudentsBySection(Long sectionId) {
        return studentRepository.countBySection(sectionId);
    }

    public Long getTotalStudentsByGender(String gender) {
        return studentRepository.countByGender(gender);
    }


    public Long getStudentsRegisteredThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        return studentRepository.countStudentsRegisteredBetween(start, end);
    }


    public void saveStudentDocument(Long studentId, String docKey, MultipartFile file) throws IOException {
        String uploadDir = "uploads/students_" + studentId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();


        // Sanitize filename
        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
        String fileName = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;

        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        StudentDocumentEntity document = StudentDocumentEntity.builder().studentId(studentId).documentType(docKey).fileName(fileName).filePath(filePath.toString()).fileType(FilenameUtils.getExtension(fileName).toUpperCase()).build();
        studentDocumentRepository.save(document);
    }

    public List<StudentDTO> searchStudents(Long campusId, Long standardId, Long sectionId, Long studentId, Long academicYearId, String kw) {
        try {
            log.info("Searching students with filters → campusId={}, standardId={}, studentId={}, academicYearId={},kw={}", campusId, standardId, studentId, academicYearId, kw);

            List<StudentEntity> result = studentRepository.searchStudents(campusId, standardId, sectionId, studentId, academicYearId, kw);

            log.info("Student search returned {} results", result.size());

            // Convert entity → DTO
            return StudentMapper.toDTOList(result);

        } catch (Exception e) {
            log.error("Error searching students", e);
            return Collections.emptyList();
        }
    }

    public List<StudentDocumentResponseDto> getDocumentsByStudentId(Long employeeId) {
        try {
            log.info("Fetching documents for Student with id: {}", employeeId);
            List<StudentDocumentEntity> documents = studentDocumentRepository.findByStudentId(employeeId);
            if (documents.isEmpty()) {
                log.warn("No documents found for Student with id: {}", employeeId);
                return Collections.emptyList();
            }
            // Map entity list to DTO list
            List<StudentDocumentResponseDto> dtoList = MapperUtil.mapList(documents, StudentDocumentResponseDto.class);
            log.info("Found {} documents for Employee with id: {}", dtoList.size(), employeeId);
            return dtoList;
        } catch (Exception e) {
            log.error("Error fetching documents for Employee with id: {}", employeeId, e);
            return Collections.emptyList();
        }
    }


    public Map<String, List<StudentDocumentResponseDto>> getGroupedDocuments(Long employeeId) {
        List<StudentDocumentResponseDto> documents = getDocumentsByStudentId(employeeId);

        if (documents.isEmpty()) {
            return Collections.emptyMap();
        }

        // Group documents by their human-readable type from config
        Map<String, List<StudentDocumentResponseDto>> groupedDocuments = documents.stream().collect(Collectors.groupingBy(doc -> feeConfig.getDocumentTypes().getOrDefault(doc.getDocumentType(), "Other")));

        return groupedDocuments;
    }

    public Resource downloadDocument(Long documentId, Long employeeId) {
        // 1️⃣ Fetch document from database
        StudentDocumentEntity document = studentDocumentRepository.findDocumentByIdAndStudentId(documentId, employeeId).orElseThrow(() -> new RuntimeException("Document not found for employeeId=" + employeeId + " and documentId=" + documentId));
        Path path = Paths.get(document.getFilePath());
        try {
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new FileNotFoundException("File not found or not readable: " + document.getFilePath());
            }
            return resource;
        } catch (Exception e) {
            throw new RuntimeException("Error while reading document file: " + e.getMessage(), e);
        }
    }


    public StudentResponseDTO updateStudent(Long studentId, @Valid StudentRequestDTO requestDTO) {
        log.info("Updating Student with id {} using DTO {}", studentId, requestDTO);

        // Fetch the existing student or throw if not found
        StudentEntity entity = studentRepository.findByIdAndDeletedFalse(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        // Update optional fields if provided
        if (requestDTO.getFirstName() != null && !requestDTO.getFirstName().isBlank()) {
            entity.setFirstName(requestDTO.getFirstName());
        }

        if (requestDTO.getMiddleName() != null) {
            entity.setMiddleName(requestDTO.getMiddleName());
        }

        if (requestDTO.getLastName() != null && !requestDTO.getLastName().isBlank()) {
            entity.setLastName(requestDTO.getLastName());
        }

        // Update full name
        StringBuilder fullName = new StringBuilder(entity.getFirstName());
        if (entity.getMiddleName() != null && !entity.getMiddleName().isBlank()) {
            fullName.append(" ").append(entity.getMiddleName());
        }
        fullName.append(" ").append(entity.getLastName());
        entity.setFullName(fullName.toString());

        if (requestDTO.getCnic() != null) {
            entity.setCnic(requestDTO.getCnic());
        }

        if (requestDTO.getPassportNumber() != null) {
            entity.setPassportNumber(requestDTO.getPassportNumber());
        }

        if (requestDTO.getPhone() != null) {
            entity.setPhone(requestDTO.getPhone());
        }

        if (requestDTO.getEmail() != null) {
            entity.setEmail(requestDTO.getEmail());
        }

        if (requestDTO.getDateOfBirth() != null) {
            entity.setDateOfBirth(requestDTO.getDateOfBirth());
        }

        if (requestDTO.getGender() != null) {
            entity.setGender(requestDTO.getGender());
        }

        if (requestDTO.getReligion() != null) {
            entity.setReligion(requestDTO.getReligion());
        }

        if (requestDTO.getNationality() != null) {
            entity.setNationality(requestDTO.getNationality());
        }

        if (requestDTO.getBloodGroup() != null) {
            entity.setBloodGroup(requestDTO.getBloodGroup());
        }

        if (requestDTO.getAddress() != null) {
            entity.setAddress(requestDTO.getAddress());
        }

        if (requestDTO.getStatus() != null) {
            entity.setStatus(requestDTO.getStatus());
        }

        if (requestDTO.getIsActive() != null) {
            entity.setIsActive(requestDTO.getIsActive());
        }

        if (requestDTO.getEnrollmentDate() != null) {
            entity.setEnrollmentDate(requestDTO.getEnrollmentDate());
        }

        // Save updated entity
        StudentEntity updated = studentRepository.save(entity);

        // Map to Response DTO
        StudentResponseDTO response = StudentMapper.toResponseDTO(updated);
        log.info("Student updated successfully: {}", response.getId());
        return response;
    }
}

