package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.model.EmployeeDocumentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeDocumentRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.configs.EmployeeDocumentConfig;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
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
    private final EmployeeDocumentConfig feeConfig;

    public EmployeeMasterService(EmployeeMasterRepository employeeRepository, EmployeeDocumentRepository employeeDocumentRepository, EmployeeDocumentConfig feeConfig) {
        this.employeeRepository = employeeRepository;
        this.employeeDocumentRepository = employeeDocumentRepository;
        this.feeConfig = feeConfig;
    }

    // -------------------------
    // Get all employees
    // -------------------------
// -------------------------
// Get all employees with Employee Type
// -------------------------
    public List<EmployeeMasterResponseDto> getAll() {
        log.info("Fetching all non-deleted Employees from database");
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeMasterEntity> employees = employeeRepository.findAllNonDeleted(orgId);
            List<EmployeeMasterResponseDto> dtoList = employees.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} Employees", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Unable to fetch Employees");
        }
    }

    @Transactional
    public EmployeeMasterResponseDto getById(Long id) {
        log.info("Fetching Employee with id {} from database", id);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            EmployeeMasterEntity employee = employeeRepository.findByIdAndOrganizationId(id, orgId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
            log.info("Successfully fetched Employee: id={}", employee.getId());
            return toDTO(employee);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employee ID: {}", id, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch Employee by ID");
        }
    }

    public EmployeeMasterResponseDto getByEmployeeCode(String code) {
        log.info("Fetching Employee with code '{}' from database", code);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            EmployeeMasterEntity employee = employeeRepository.findByEmployeeCodeAndOrganizationId(code, orgId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with code: " + code));
            log.info("Successfully fetched Employee: code={}", code);
            return toDTO(employee);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employee code: {}", code, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch Employee by code");
        }
    }

    public List<EmployeeMasterResponseDto> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching Employees with keyword: '{}' in database", searchKey);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeMasterEntity> result = employeeRepository.searchByKeyword(searchKey, orgId);
            List<EmployeeMasterResponseDto> dtoList = result.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} Employees based on search", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while searching Employees", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to search Employees");
        }
    }

    public List<EmployeeMasterResponseDto> getByGender(String gender) {
        log.info("Fetching Employees by gender: '{}'", gender);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeMasterEntity> result = employeeRepository.findByGender(gender, orgId);
            log.info("Successfully fetched {} Employees for gender: '{}'", result.size(), gender);
            return result.stream().map(this::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees by gender", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch Employees by gender");
        }
    }

    public List<EmployeeMasterResponseDto> getByActiveStatus(Boolean status) {
        log.info("Fetching Employees by active status: {}", status);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeMasterEntity> result = employeeRepository.findByActiveStatus(status, orgId);
            log.info("Successfully fetched {} Employees for active status: {}", result.size(), status);
            return result.stream().map(this::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees by active status", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch Employees by active status");
        }
    }

    public List<EmployeeMasterResponseDto> getProbationEndedBefore(Date date) {
        log.info("Fetching Employees probation ended before: {}", date);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeMasterEntity> result = employeeRepository.findProbationEndedBefore(date, orgId);
            log.info("Successfully fetched {} Employees with probation ended", result.size());
            return result.stream().map(this::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees by probation end date", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch Employees by probation end date");
        }
    }

    @Transactional
    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto employeeDTO) {
        log.info("Creating new Employee: {} {} in database", employeeDTO.getFirstName(), employeeDTO.getLastName());
        try {
            EmployeeMasterEntity employeeEntity = MapperUtil.mapObject(employeeDTO, EmployeeMasterEntity.class);
            employeeEntity.setEmployeeCode(generateEmployeeCode());
            employeeEntity.setId(null);
            employeeEntity.setDeleted(false);
            
            EmployeeMasterEntity savedEmployee = employeeRepository.save(employeeEntity);
            log.info("Successfully created Employee: id={}, code={}", savedEmployee.getId(), savedEmployee.getEmployeeCode());
            return toDTO(savedEmployee);
        } catch (Exception e) {
            log.error("Unexpected error while creating Employee: {}", employeeDTO.getFirstName(), e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to create Employee");
        }
    }

    @Transactional
    public String saveProfilePhoto(Long employeeId, String file) {
        log.info("Saving profile photo path for Employee ID: {}", employeeId);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            EmployeeMasterEntity employee = employeeRepository.findByIdAndOrganizationId(employeeId, orgId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
            employee.setProfilePicture(file);
            employeeRepository.save(employee);
            log.info("Successfully updated profile photo for Employee ID: {}", employeeId);
            return employee.getProfilePicture();
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while saving profile photo for Employee ID: {}", employeeId, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to save profile photo");
        }
    }

    public long countAllEmployees() {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countAllEmployees(orgId);
    }

    public long countActiveEmployees() {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countActiveEmployees(orgId);
    }

    public long countInactiveEmployees() {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        return employeeRepository.countInactiveEmployees(orgId);
    }

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Employee ID: {} from database", id);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            int affected = employeeRepository.softDeleteByIdAndOrganizationId(id, orgId);
            if (affected == 0) {
                log.warn("Employee not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Employee not found with id: " + id);
            }
            log.info("Successfully soft deleted Employee: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting Employee ID: {}", id, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to delete Employee");
        }
    }

    @Transactional
    public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        log.info("Saving document '{}' for Employee ID: {}", docKey, employeeId);
        try {
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
            log.info("Successfully saved document for Employee ID: {}", employeeId);
        } catch (Exception e) {
            log.error("Unexpected error while saving employee document", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to save employee document");
        }
    }

    public List<EmployeeDocumentResponseDto> getDocumentsByEmployeeId(Long employeeId) {
        log.info("Fetching documents for Employee ID: {}", employeeId);
        try {
            List<EmployeeDocumentEntity> documents = employeeDocumentRepository.findByEmployeeId(employeeId);
            log.info("Successfully fetched {} documents for Employee ID: {}", documents.size(), employeeId);
            return MapperUtil.mapList(documents, EmployeeDocumentResponseDto.class);
        } catch (Exception e) {
            log.error("Unexpected error while fetching documents for Employee ID: {}", employeeId, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch employee documents");
        }
    }

    public Map<String, List<EmployeeDocumentResponseDto>> getGroupedDocuments(Long employeeId) {
        log.info("Fetching and grouping documents for Employee ID: {}", employeeId);
        try {
            List<EmployeeDocumentResponseDto> documents = getDocumentsByEmployeeId(employeeId);
            if (documents.isEmpty()) return Collections.emptyMap();

            Map<String, List<EmployeeDocumentResponseDto>> grouped = documents.stream()
                    .collect(Collectors.groupingBy(doc ->
                            feeConfig.getDocumentTypes().getOrDefault(doc.getDocumentType(), "Other")
                    ));
            log.info("Successfully grouped documents into {} types", grouped.size());
            return grouped;
        } catch (Exception e) {
            log.error("Unexpected error while grouping documents for Employee ID: {}", employeeId, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to group employee documents");
        }
    }

    public Resource downloadDocument(Long documentId, Long employeeId) {
        log.info("Downloading document ID {} for Employee ID {}", documentId, employeeId);
        try {
            EmployeeDocumentEntity document = employeeDocumentRepository
                    .findDocumentByIdAndEmployeeId(documentId, employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Document not found for employeeId=" + employeeId + " and documentId=" + documentId));
            Path path = Paths.get(document.getFilePath());
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                log.warn("Document file not found or not readable: {}", document.getFilePath());
                throw new FileNotFoundException("File not found or not readable: " + document.getFilePath());
            }
            log.info("Successfully prepared document for download: {}", document.getFileName());
            return resource;
        } catch (ResourceNotFoundException | FileNotFoundException e) {
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException(e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error while downloading document", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to download document");
        }
    }

    @Transactional
    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto dto) {
        log.info("Updating Employee ID: {} in database", id);
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            EmployeeMasterEntity entity = employeeRepository.findByIdAndOrganizationId(id, orgId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

            if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) entity.setFirstName(dto.getFirstName());
            if (dto.getLastName() != null && !dto.getLastName().isBlank()) entity.setLastName(dto.getLastName());
            if (dto.getDateOfBirth() != null) entity.setDateOfBirth(dto.getDateOfBirth());
            if (dto.getGender() != null) entity.setGender(dto.getGender());
            if (dto.getPrimaryPhone() != null) entity.setPrimaryPhone(dto.getPrimaryPhone());
            if (dto.getSecondaryPhone() != null) entity.setSecondaryPhone(dto.getSecondaryPhone());
            if (dto.getWorkPhone() != null) entity.setWorkPhone(dto.getWorkPhone());
            if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
            if (dto.getReligion() != null) entity.setReligion(dto.getReligion());
            if (dto.getNationality() != null) entity.setNationality(dto.getNationality());
            if (dto.getMaritalStatus() != null) entity.setMaritalStatus(dto.getMaritalStatus());
            if (dto.getBloodGroup() != null) entity.setBloodGroup(dto.getBloodGroup());
            if (dto.getBio() != null) entity.setBio(dto.getBio());
            if (dto.getJoiningDate() != null) entity.setJoiningDate(dto.getJoiningDate());

            entity.setFullName(
                    (entity.getFirstName() != null ? entity.getFirstName() : "") + " " +
                    (entity.getMiddleName() != null ? entity.getMiddleName() + " " : "") +
                    (entity.getLastName() != null ? entity.getLastName() : "")
            );

            EmployeeMasterEntity updated = employeeRepository.save(entity);
            log.info("Successfully updated Employee: id={}", updated.getId());
            return toDTO(updated);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating Employee ID: {}", id, e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to update Employee");
        }
    }

    public Map<String, Long> getEmployeeCountByGender() {
        log.info("Fetching employee count by gender");
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<Object[]> results = employeeRepository.countEmployeesByGender(orgId);
            Map<String, Long> genderCountMap = new HashMap<>();
            for (Object[] row : results) {
                genderCountMap.put((String) row[0], (Long) row[1]);
            }
            log.info("Successfully fetched employee count by gender: {}", genderCountMap.size());
            return genderCountMap;
        } catch (Exception e) {
            log.error("Unexpected error while fetching employee count by gender", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch count by gender");
        }
    }

    EmployeeMasterResponseDto toDTO(EmployeeMasterEntity entity) {
        if (entity == null) return null;

        return EmployeeMasterResponseDto.builder()
                .id(entity.getId())
                .employeeCode(entity.getEmployeeCode())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .dateOfBirth(entity.getDateOfBirth())
                .maritalStatus(entity.getMaritalStatus())
                .religion(entity.getReligion())
                .nationality(entity.getNationality())
                .bloodGroup(entity.getBloodGroup())
                .email(entity.getEmail())
                .primaryPhone(entity.getPrimaryPhone())
                .secondaryPhone(entity.getSecondaryPhone())
                .workPhone(entity.getWorkPhone())
                .joiningDate(entity.getJoiningDate())
                .probationEndDate(entity.getProbationEndDate())
                .employeeTypeId(entity.getEmployeeType() != null ? entity.getEmployeeType().getId() : null)
                .employeeTypeName(entity.getEmployeeType() != null ? entity.getEmployeeType().getName() : null)
                .profilePicture(entity.getProfilePicture())
                .bio(entity.getBio())
                .active(entity.getActive())
                .build();
    }

    private String generateEmployeeCode() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd")); 
        int randomNum = new Random().nextInt(9000) + 1000; 
        return "EMP" + formattedDate + randomNum; 
    }

    public List<EmployeeTypeCountDTO> getEmployeeCountByType() {
        log.info("Fetching employee count by type");
        try {
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeTypeCountDTO> counts = employeeRepository.countEmployeesByType(orgId);
            log.info("Successfully fetched employee count by type: {}", counts.size());
            return counts;
        } catch (Exception e) {
            log.error("Unexpected error while fetching employee count by type", e);
            throw new com.smartsolutions.eschool.global.exception.CustomServiceException("Failed to fetch count by type");
        }
    }
}

