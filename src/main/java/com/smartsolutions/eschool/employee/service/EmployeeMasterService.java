package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
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
    public List<EmployeeMasterResponseDto> getAll() {
        try {
            log.info("Fetching all Employees from database");
            List<EmployeeMasterEntity> result = employeeRepository.findAll();
            log.info("Successfully fetched {} Employees", result.size());
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Employees", dae);
        } catch (MappingException me) {
            log.error("Error mapping EmployeeEntity to DTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Get employee by ID
    // -------------------------
    public EmployeeMasterResponseDto getById(Long id) {
        log.info("Fetching Employee with id: {}", id);
        EmployeeMasterEntity employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return MapperUtil.mapObject(employee, EmployeeMasterResponseDto.class);
    }

    // -------------------------
    // Get employee by employee code
    // -------------------------
    public EmployeeMasterResponseDto getByEmployeeCode(String code) {
        log.info("Fetching Employee with employeeCode: {}", code);
        EmployeeMasterEntity employee = employeeRepository.findByEmployeeCode(code).orElseThrow(() -> new ResourceNotFoundException("Employee not found with code: " + code));
        return MapperUtil.mapObject(employee, EmployeeMasterResponseDto.class);
    }

    // -------------------------
    // Search employees by name
    // -------------------------
    public List<EmployeeMasterResponseDto> searchByName(String name) {
        try {
            log.info("Searching Employees by name: {}", name);
            List<EmployeeMasterEntity> result = employeeRepository.searchByName(name);
            log.info("Found {} Employees matching name: {}", result.size(), name);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error searching employees by name", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by gender
    // -------------------------
    public List<EmployeeMasterResponseDto> getByGender(String gender) {
        try {
            log.info("Fetching Employees by gender: {}", gender);
            List<EmployeeMasterEntity> result = employeeRepository.findByGender(gender);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by gender", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by active status
    // -------------------------
    public List<EmployeeMasterResponseDto> getByActiveStatus(Boolean status) {
        try {
            log.info("Fetching Employees by active status: {}", status);
            List<EmployeeMasterEntity> result = employeeRepository.findByActiveStatus(status);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by active status", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by probation end date
    // -------------------------
    public List<EmployeeMasterResponseDto> getProbationEndedBefore(Date date) {
        try {
            log.info("Fetching Employees whose probation ended before: {}", date);
            List<EmployeeMasterEntity> result = employeeRepository.findProbationEndedBefore(date);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by probation end date", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Create new Employee
    // -------------------------
    @Transactional
    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto employeeDTO) {
        log.info("Creating new Employee: {}", employeeDTO);


        //TODO employee Code
        //TODO Probation Date
        EmployeeMasterEntity employeeEntity = MapperUtil.mapObject(employeeDTO, EmployeeMasterEntity.class);

        employeeEntity.setId(null);
        EmployeeMasterEntity savedEmployee = employeeRepository.save(employeeEntity);

        EmployeeMasterResponseDto responseDTO = MapperUtil.mapObject(savedEmployee, EmployeeMasterResponseDto.class);
        log.info("Successfully created Employee: {}", responseDTO);
        return responseDTO;
    }


    public String saveProfilePhoto(Long employeeId, String file) {
        EmployeeMasterEntity employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setProfilePicture(file);
        employeeRepository.save(employee);
        return employee.getProfilePicture();
    }

    // -------------------------
    // Count / Metrics
    // -------------------------
    public long countAllEmployees() {
        return employeeRepository.countAllEmployees();
    }

    public long countActiveEmployees() {
        return employeeRepository.countActiveEmployees();
    }

    public long countInactiveEmployees() {
        return employeeRepository.countInactiveEmployees();
    }

    public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        //String filePath = UploadUtil.saveEmployeeDocument(employeeId, docKey, file);
        String uploadDir = "uploads/employee_" + employeeId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        // Sanitize filename
        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
        String fileName = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;

        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        EmployeeDocumentEntity document = EmployeeDocumentEntity.builder().employeeId(employeeId).documentType(docKey).fileName(fileName).filePath(filePath.toString()).fileType(FilenameUtils.getExtension(fileName).toUpperCase()).build();
        employeeDocumentRepository.save(document);
    }

    public List<EmployeeDocumentResponseDto> getDocumentsByEmployeeId(Long employeeId) {
        try {
            log.info("Fetching documents for Employee with id: {}", employeeId);
            List<EmployeeDocumentEntity> documents = employeeDocumentRepository.findByEmployeeId(employeeId);
            if (documents.isEmpty()) {
                log.warn("No documents found for Employee with id: {}", employeeId);
                return Collections.emptyList();
            }
            // Map entity list to DTO list
            List<EmployeeDocumentResponseDto> dtoList = MapperUtil.mapList(documents, EmployeeDocumentResponseDto.class);
            log.info("Found {} documents for Employee with id: {}", dtoList.size(), employeeId);
            return dtoList;
        } catch (Exception e) {
            log.error("Error fetching documents for Employee with id: {}", employeeId, e);
            return Collections.emptyList();
        }
    }


    public Map<String, List<EmployeeDocumentResponseDto>> getGroupedDocuments(Long employeeId) {
        List<EmployeeDocumentResponseDto> documents = getDocumentsByEmployeeId(employeeId);

        if (documents.isEmpty()) {
            return Collections.emptyMap();
        }

        // Group documents by their human-readable type from config
        Map<String, List<EmployeeDocumentResponseDto>> groupedDocuments = documents.stream()
                .collect(Collectors.groupingBy(doc ->
                        feeConfig.getDocumentTypes().getOrDefault(doc.getDocumentType(), "Other")
                ));

        return groupedDocuments;
    }

    public Resource downloadDocument(Long documentId, Long employeeId) {
        // 1️⃣ Fetch document from database
        EmployeeDocumentEntity document = employeeDocumentRepository
                .findDocumentByIdAndEmployeeId(documentId, employeeId)
                .orElseThrow(() -> new RuntimeException(
                        "Document not found for employeeId=" + employeeId + " and documentId=" + documentId));
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

    @Transactional
    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto dto) {
        log.info("Updating Employee with id {} using DTO {}", id, dto);

        EmployeeMasterEntity entity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) {
            entity.setFirstName(dto.getFirstName());
        }
//        if (dto.getMiddleName() != null) {
//            entity.setMiddleName(dto.getMiddleName());
//        }
        if (dto.getLastName() != null && !dto.getLastName().isBlank()) {
            entity.setLastName(dto.getLastName());
        }
        if (dto.getDateOfBirth() != null) {
            entity.setDateOfBirth(dto.getDateOfBirth());
        }
        if (dto.getGender() != null) {
            entity.setGender(dto.getGender());
        }
//        if (dto.getCnic() != null) {
//            entity.setCnic(dto.getCnic());
//        }
//        if (dto.getPassportNumber() != null) {
//            entity.setPassportNumber(dto.getPassportNumber());
//        }
        if (dto.getPrimaryPhone() != null) {
            entity.setPrimaryPhone(dto.getPrimaryPhone());
        }
        if (dto.getSecondaryPhone() != null) {
            entity.setSecondaryPhone(dto.getSecondaryPhone());
        }
        if (dto.getWorkPhone() != null) {
            entity.setWorkPhone(dto.getWorkPhone());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getReligion() != null) {
            entity.setReligion(dto.getReligion());
        }
        if (dto.getNationality() != null) {
            entity.setNationality(dto.getNationality());
        }
        if (dto.getMaritalStatus() != null) {
            entity.setMaritalStatus(dto.getMaritalStatus());
        }
        if (dto.getBloodGroup() != null) {
            entity.setBloodGroup(dto.getBloodGroup());
        }
        if (dto.getBio() != null) {
            entity.setBio(dto.getBio());
        }
        if (dto.getJoiningDate() != null) {
            entity.setJoiningDate(dto.getJoiningDate());
        }

        // Optional: recompute fullName
        entity.setFullName(
                (entity.getFirstName() != null ? entity.getFirstName() : "") + " " +
                        (entity.getMiddleName() != null ? entity.getMiddleName() + " " : "") +
                        (entity.getLastName() != null ? entity.getLastName() : "")
        );

        // 3️⃣ Save entity
        EmployeeMasterEntity updated = employeeRepository.save(entity);

        // 4️⃣ Map to response DTO
        EmployeeMasterResponseDto response = MapperUtil.mapObject(updated, EmployeeMasterResponseDto.class);

        log.info("Employee updated successfully: {}", response.getId());
        return response;
    }


    public Map<String, Long> getEmployeeCountByGender() {
        List<Object[]> results = employeeRepository.countEmployeesByGender();
        Map<String, Long> genderCountMap = new HashMap<>();
        for (Object[] row : results) {
            String gender = (String) row[0];
            Long count = (Long) row[1];  // cast to Long
            genderCountMap.put(gender, count);
        }
        return genderCountMap;
    }
}

