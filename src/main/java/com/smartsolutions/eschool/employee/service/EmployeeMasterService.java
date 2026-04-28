package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeCreateRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.error.EmployeeErrors;
import com.smartsolutions.eschool.employee.mapper.EmployeeMapper;
import com.smartsolutions.eschool.employee.model.EmployeeAssignmentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeDocumentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeAssignmentRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeDocumentRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.configs.EmployeeDocumentConfig;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.school.repository.DesignationRepository;
import com.smartsolutions.eschool.util.MapperUtil;

import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
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
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeMasterService {

    private final EmployeeMasterRepository employeeRepository;
    private final EmployeeDocumentRepository employeeDocumentRepository;
    private final EmployeeAssignmentRepository assignmentRepository;
    private final CampusRepository campusRepository;
    private final DepartmentRepository departmentRepository;
    private final DesignationRepository designationRepository;
    private final com.smartsolutions.eschool.lookups.repository.CountryRepository countryRepository;
    private final EmployeeDocumentConfig feeConfig;

    public EmployeeMasterService(EmployeeMasterRepository employeeRepository,
                                 EmployeeDocumentRepository employeeDocumentRepository,
                                 EmployeeAssignmentRepository assignmentRepository,
                                 CampusRepository campusRepository,
                                 DepartmentRepository departmentRepository,
                                 DesignationRepository designationRepository,
                                 com.smartsolutions.eschool.lookups.repository.CountryRepository countryRepository,
                                 EmployeeDocumentConfig feeConfig) {
        this.employeeRepository = employeeRepository;
        this.employeeDocumentRepository = employeeDocumentRepository;
        this.assignmentRepository = assignmentRepository;
        this.campusRepository = campusRepository;
        this.departmentRepository = departmentRepository;
        this.designationRepository = designationRepository;
        this.countryRepository = countryRepository;
        this.feeConfig = feeConfig;
    }

    // ─────────────────────────────────────────────
    // READ
    // ─────────────────────────────────────────────

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<EmployeeMasterResponseDto> getAll() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getAll() called - org: {}", orgId);
        List<EmployeeMasterEntity> employees = employeeRepository.findAllNonDeleted(orgId);
        List<EmployeeMasterResponseDto> dtoList = employees.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        log.info("[Service:EmployeeMasterService] getAll() succeeded - Found {} employees", dtoList.size());
        return dtoList;
    }

    @Transactional
    public EmployeeMasterResponseDto getById(Long id) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getById() called - id: {}, org: {}", id, orgId);
        EmployeeMasterEntity employee = employeeRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("[Service:EmployeeMasterService] getById() succeeded - id: {}", id);
        return toDTO(employee);
    }

    public EmployeeMasterResponseDto getByEmployeeCode(String code) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getByEmployeeCode() called - code: '{}', org: {}", code, orgId);
        EmployeeMasterEntity employee = employeeRepository.findByEmployeeCodeAndOrganizationId(code, orgId)
                .orElseThrow(() -> new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("[Service:EmployeeMasterService] getByEmployeeCode() succeeded - code: '{}'", code);
        return toDTO(employee);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<EmployeeMasterResponseDto> searchByKeyword(String keyword) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:EmployeeMasterService] searchByKeyword() called - keyword: '{}', org: {}", searchKey, orgId);
        List<EmployeeMasterEntity> result = employeeRepository.searchByKeyword(searchKey, orgId);
        List<EmployeeMasterResponseDto> dtoList = result.stream().map(this::toDTO).collect(Collectors.toList());
        log.info("[Service:EmployeeMasterService] searchByKeyword() succeeded - Found {} employees", dtoList.size());
        return dtoList;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<EmployeeMasterResponseDto> getByGender(String gender) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getByGender() called - gender: '{}', org: {}", gender, orgId);
        List<EmployeeMasterEntity> result = employeeRepository.findByGender(gender, orgId);
        log.info("[Service:EmployeeMasterService] getByGender() succeeded - Found {} employees", result.size());
        return result.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<EmployeeMasterResponseDto> getByActiveStatus(Boolean status) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getByActiveStatus() called - status: {}, org: {}", status, orgId);
        List<EmployeeMasterEntity> result = employeeRepository.findByActiveStatus(status, orgId);
        log.info("[Service:EmployeeMasterService] getByActiveStatus() succeeded - Found {} employees", result.size());
        return result.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<EmployeeMasterResponseDto> getProbationEndedBefore(Date date) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] getProbationEndedBefore() called - date: {}, org: {}", date, orgId);
        List<EmployeeMasterEntity> result = employeeRepository.findProbationEndedBefore(date, orgId);
        log.info("[Service:EmployeeMasterService] getProbationEndedBefore() succeeded - Found {} employees", result.size());
        return result.stream().map(this::toDTO).collect(Collectors.toList());
    }

    // ─────────────────────────────────────────────
    // CREATE
    // ─────────────────────────────────────────────

    @Transactional
    public EmployeeMasterResponseDto createEmployee(EmployeeCreateRequestDto requestDto) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] createEmployee(create) called - org: {}", orgId);

        EmployeeMasterEntity employeeEntity = MapperUtil.mapObject(requestDto, EmployeeMasterEntity.class);
        employeeEntity.setEmployeeCode(generateEmployeeCode());
        employeeEntity.setId(null);
        employeeEntity.setDeleted(false);
        employeeEntity.setOrganizationId(orgId);

        if (requestDto.getCountryId() != null) {
            employeeEntity.setCountry(countryRepository.getReferenceById(requestDto.getCountryId()));
        }

        EmployeeMasterEntity savedEmployee = employeeRepository.save(employeeEntity);

        // Create initial primary assignment
        EmployeeAssignmentEntity assignment = EmployeeAssignmentEntity.builder()
                .employee(savedEmployee)
                .campus(campusRepository.getReferenceById(requestDto.getCampusId()))
                .department(departmentRepository.getReferenceById(requestDto.getDepartmentId()))
                .designation(designationRepository.getReferenceById(requestDto.getDesignationId()))
                .startDate(requestDto.getAssignmentStartDate() != null ? requestDto.getAssignmentStartDate() : new Date())
                .isPrimary(true)
                .build();
        assignment.setOrganizationId(orgId);
        assignmentRepository.save(assignment);

        log.info("[Service:EmployeeMasterService] createEmployee(create) succeeded - id: {}", savedEmployee.getId());
        return toDTO(savedEmployee);
    }

    @Transactional
    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto requestDto) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] createEmployee(master) called - org: {}", orgId);

        EmployeeMasterEntity employeeEntity = MapperUtil.mapObject(requestDto, EmployeeMasterEntity.class);
        employeeEntity.setEmployeeCode(generateEmployeeCode());
        employeeEntity.setId(null);
        employeeEntity.setDeleted(false);
        employeeEntity.setOrganizationId(orgId);

        EmployeeMasterEntity savedEmployee = employeeRepository.save(employeeEntity);
        log.info("[Service:EmployeeMasterService] createEmployee(master) succeeded - id: {}", savedEmployee.getId());
        return toDTO(savedEmployee);
    }

    // ─────────────────────────────────────────────
    // UPDATE
    // ─────────────────────────────────────────────

    @Transactional
    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto dto) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] updateEmployee() called - id: {}, org: {}", id, orgId);

        EmployeeMasterEntity entity = employeeRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null && !dto.getLastName().isBlank()) entity.setLastName(dto.getLastName());
        if (dto.getDateOfBirth() != null) entity.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getGender() != null) entity.setGender(dto.getGender());
        if (dto.getPrimaryPhone() != null) entity.setPrimaryPhone(dto.getPrimaryPhone());
        if (dto.getSecondaryPhone() != null) entity.setSecondaryPhone(dto.getSecondaryPhone());
        if (dto.getWorkPhone() != null) entity.setWorkPhone(dto.getWorkPhone());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getReligion() != null) entity.setReligion(dto.getReligion());
        if (dto.getCountryId() != null) {
            entity.setCountry(countryRepository.getReferenceById(dto.getCountryId()));
        }
        if (dto.getMaritalStatus() != null) entity.setMaritalStatus(dto.getMaritalStatus());
        if (dto.getNationalId() != null) entity.setNationalId(dto.getNationalId());
        if (dto.getPassportNumber() != null) entity.setPassportNumber(dto.getPassportNumber());
        if (dto.getBloodGroup() != null) entity.setBloodGroup(dto.getBloodGroup());
        if (dto.getBio() != null) entity.setBio(dto.getBio());
        if (dto.getJoiningDate() != null) entity.setJoiningDate(dto.getJoiningDate());

        entity.setFullName(
                (entity.getFirstName() != null ? entity.getFirstName() : "") + " " +
                (entity.getMiddleName() != null ? entity.getMiddleName() + " " : "") +
                (entity.getLastName() != null ? entity.getLastName() : "")
        );

        // Track Assignment History if IDs are provided
        if (dto.getCampusId() != null && dto.getDepartmentId() != null && dto.getDesignationId() != null) {
            Optional<EmployeeAssignmentEntity> currentPrimaryOpt = assignmentRepository.findPrimaryAssignmentByEmployeeId(entity.getId());
            boolean needsNewAssignment = false;

            if (currentPrimaryOpt.isPresent()) {
                EmployeeAssignmentEntity currentPrimary = currentPrimaryOpt.get();
                if (!currentPrimary.getCampus().getId().equals(dto.getCampusId()) ||
                    !currentPrimary.getDepartment().getId().equals(dto.getDepartmentId()) ||
                    !currentPrimary.getDesignation().getId().equals(dto.getDesignationId())) {
                    // Close the old assignment
                    currentPrimary.setIsPrimary(false);
                    currentPrimary.setEndDate(dto.getAssignmentStartDate() != null ? dto.getAssignmentStartDate() : new Date());
                    assignmentRepository.save(currentPrimary);
                    needsNewAssignment = true;
                }
            } else {
                needsNewAssignment = true;
            }

            if (needsNewAssignment) {
                EmployeeAssignmentEntity newAssignment = EmployeeAssignmentEntity.builder()
                        .employee(entity)
                        .campus(campusRepository.getReferenceById(dto.getCampusId()))
                        .department(departmentRepository.getReferenceById(dto.getDepartmentId()))
                        .designation(designationRepository.getReferenceById(dto.getDesignationId()))
                        .startDate(dto.getAssignmentStartDate() != null ? dto.getAssignmentStartDate() : new Date())
                        .isPrimary(true)
                        .build();
                newAssignment.setOrganizationId(orgId);
                assignmentRepository.save(newAssignment);
            }
        }

        EmployeeMasterEntity updated = employeeRepository.save(entity);
        log.info("[Service:EmployeeMasterService] updateEmployee() succeeded - id: {}", updated.getId());
        return toDTO(updated);
    }

    @Transactional
    public String saveProfilePhoto(Long employeeId, String file) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] saveProfilePhoto() called - employeeId: {}", employeeId);
        EmployeeMasterEntity employee = employeeRepository.findByIdAndOrganizationId(employeeId, orgId)
                .orElseThrow(() -> new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));
        employee.setProfilePicture(file);
        employeeRepository.save(employee);
        log.info("[Service:EmployeeMasterService] saveProfilePhoto() succeeded - employeeId: {}", employeeId);
        return employee.getProfilePicture();
    }

    // ─────────────────────────────────────────────
    // DELETE
    // ─────────────────────────────────────────────

    @Transactional
    public void delete(Long id) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        if (orgId == null) throw new ApiException(EmployeeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        log.info("[Service:EmployeeMasterService] delete() called - id: {}, org: {}", id, orgId);
        int affected = employeeRepository.softDeleteByIdAndOrganizationId(id, orgId);
        if (affected == 0) throw new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND);
        log.info("[Service:EmployeeMasterService] delete() succeeded - id: {}", id);
    }

    // ─────────────────────────────────────────────
    // DOCUMENTS
    // ─────────────────────────────────────────────

    @Transactional
    public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        log.info("[Service:EmployeeMasterService] saveEmployeeDocument() called - employeeId: {}, docKey: {}", employeeId, docKey);
        String uploadDir = "uploads/employee_" + employeeId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
        String fileName = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;

        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        EmployeeDocumentEntity document = EmployeeDocumentEntity.builder()
                .employeeId(employeeId)
                .documentType(docKey)
                .fileName(fileName)
                .filePath(filePath.toString())
                .fileType(FilenameUtils.getExtension(fileName).toUpperCase())
                .build();
        employeeDocumentRepository.save(document);
        log.info("[Service:EmployeeMasterService] saveEmployeeDocument() succeeded - employeeId: {}", employeeId);
    }

    public List<EmployeeDocumentResponseDto> getDocumentsByEmployeeId(Long employeeId) {
        log.info("[Service:EmployeeMasterService] getDocumentsByEmployeeId() called - employeeId: {}", employeeId);
        List<EmployeeDocumentEntity> documents = employeeDocumentRepository.findByEmployeeId(employeeId);
        log.info("[Service:EmployeeMasterService] getDocumentsByEmployeeId() succeeded - Found {} documents", documents.size());
        return MapperUtil.mapList(documents, EmployeeDocumentResponseDto.class);
    }

    public Map<String, List<EmployeeDocumentResponseDto>> getGroupedDocuments(Long employeeId) {
        log.info("[Service:EmployeeMasterService] getGroupedDocuments() called - employeeId: {}", employeeId);
        List<EmployeeDocumentResponseDto> documents = getDocumentsByEmployeeId(employeeId);
        if (documents.isEmpty()) return Collections.emptyMap();
        Map<String, List<EmployeeDocumentResponseDto>> grouped = documents.stream()
                .collect(Collectors.groupingBy(doc ->
                        feeConfig.getDocumentTypes().getOrDefault(doc.getDocumentType(), "Other")
                ));
        log.info("[Service:EmployeeMasterService] getGroupedDocuments() succeeded - {} types", grouped.size());
        return grouped;
    }

    public Resource downloadDocument(Long documentId, Long employeeId) {
        log.info("[Service:EmployeeMasterService] downloadDocument() called - documentId: {}, employeeId: {}", documentId, employeeId);
        EmployeeDocumentEntity document = employeeDocumentRepository
                .findDocumentByIdAndEmployeeId(documentId, employeeId)
                .orElseThrow(() -> new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, "Document not found for employee", HttpStatus.NOT_FOUND));
        try {
            Path path = Paths.get(document.getFilePath());
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, "File not found or not readable: " + document.getFilePath(), HttpStatus.NOT_FOUND);
            }
            log.info("[Service:EmployeeMasterService] downloadDocument() succeeded - {}", document.getFileName());
            return resource;
        } catch (ApiException e) {
            throw e;
        } catch (Exception e) {
            log.error("[Service:EmployeeMasterService] downloadDocument() failed - documentId: {}", documentId, e);
            throw new ApiException(EmployeeErrors.EMPLOYEE_NOT_FOUND, "Failed to download document", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ─────────────────────────────────────────────
    // STATISTICS & COUNTS
    // ─────────────────────────────────────────────

    public long countAllEmployees() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countAllEmployees(orgId);
    }

    public long countActiveEmployees() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countActiveEmployees(orgId);
    }

    public long countInactiveEmployees() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countInactiveEmployees(orgId);
    }

    public Map<String, Long> getEmployeeCountByGender() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:EmployeeMasterService] getEmployeeCountByGender() called - org: {}", orgId);
        List<Object[]> results = employeeRepository.countEmployeesByGender(orgId);
        Map<String, Long> genderCountMap = new HashMap<>();
        for (Object[] row : results) {
            genderCountMap.put((String) row[0], (Long) row[1]);
        }
        log.info("[Service:EmployeeMasterService] getEmployeeCountByGender() succeeded");
        return genderCountMap;
    }

    public List<EmployeeTypeCountDTO> getEmployeeCountByType() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:EmployeeMasterService] getEmployeeCountByType() called - org: {}", orgId);
        List<EmployeeTypeCountDTO> counts = employeeRepository.countEmployeesByType(orgId);
        log.info("[Service:EmployeeMasterService] getEmployeeCountByType() succeeded - {} types", counts.size());
        return counts;
    }

    // ─────────────────────────────────────────────
    // PRIVATE HELPERS
    // ─────────────────────────────────────────────

    private EmployeeMasterResponseDto toDTO(EmployeeMasterEntity entity) {
        EmployeeMasterResponseDto dto = EmployeeMapper.toBaseDTO(entity);
        assignmentRepository.findPrimaryAssignmentByEmployeeId(entity.getId())
                .ifPresent(assignment -> EmployeeMapper.enrichWithAssignment(dto, assignment));
        return dto;
    }

    private String generateEmployeeCode() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "EMP" + formattedDate + randomNum;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public long countEmployees(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:EmployeeMasterService] countEmployees() called - orgId: {}", orgId);
        long count = employeeRepository.countEmployeesByFilters(filter.getCampusIds(), orgId);
        log.info("[Service:EmployeeMasterService] countEmployees() succeeded - count: {}", count);
        return count;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Map<String, Long> getStaffCountByType(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:EmployeeMasterService] getStaffCountByType() called - orgId: {}", orgId);
        List<Object[]> results = employeeRepository.countEmployeesByTypeDistribution(filter.getCampusIds(), orgId);
        Map<String, Long> distribution = new HashMap<>();
        for (Object[] row : results) {
            distribution.put(row[0] != null ? row[0].toString() : "Unknown", (Long) row[1]);
        }
        log.info("[Service:EmployeeMasterService] getStaffCountByType() succeeded - found types: {}", distribution.size());
        return distribution;
    }
}
