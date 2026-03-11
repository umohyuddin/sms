package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EmployeeTypeErrors;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.mapper.EmployeeTypeMapper;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmployeeTypeService {
    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    public List<EmployeeTypeResponseDTO> getAll() {
        log.info("[Service:EmployeeTypeService] getAll() called - Fetching all employee types");
        List<EmployeeTypeEntity> result = employeeTypeRepository.findAllNotDeleted();
        List<EmployeeTypeResponseDTO> responseDTOs = EmployeeTypeMapper.toResponseDTOList(result);
        log.info("[Service:EmployeeTypeService] getAll() succeeded - Found {} employee types", responseDTOs.size());
        return responseDTOs;
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        log.info("[Service:EmployeeTypeService] getAllActive() called - Fetching active employee types");
        List<EmployeeTypeEntity> result = employeeTypeRepository.findAllActive();
        List<EmployeeTypeResponseDTO> responseDTOs = EmployeeTypeMapper.toResponseDTOList(result);
        log.info("[Service:EmployeeTypeService] getAllActive() succeeded - Found {} active employee types", responseDTOs.size());
        return responseDTOs;
    }

    public EmployeeTypeResponseDTO getById(Long id) {
        log.info("[Service:EmployeeTypeService] getById() called - id: {}", id);
        EmployeeTypeEntity entity = employeeTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EmployeeTypeErrors.EMPLOYEE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        EmployeeTypeResponseDTO responseDTO = EmployeeTypeMapper.toResponseDTO(entity);
        log.info("[Service:EmployeeTypeService] getById() succeeded - Found employee type: {}", id);
        return responseDTO;
    }

    public List<EmployeeTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:EmployeeTypeService] searchByKeyword() called - keyword: {}", keyword);
        List<EmployeeTypeEntity> result = employeeTypeRepository.searchByKeyword(keyword);
        List<EmployeeTypeResponseDTO> responseDTOs = EmployeeTypeMapper.toResponseDTOList(result);
        log.info("[Service:EmployeeTypeService] searchByKeyword() succeeded - Found {} employee types", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:EmployeeTypeService] softDeleteById() called - id: {}", id);

        int result = employeeTypeRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(EmployeeTypeErrors.EMPLOYEE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:EmployeeTypeService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public EmployeeTypeResponseDTO create(EmployeeTypeRequestDTO requestDTO) {
        log.info("[Service:EmployeeTypeService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (employeeTypeRepository.existsByName(requestDTO.getName().trim())) {
                throw new ApiException(EmployeeTypeErrors.DUPLICATE_EMPLOYEE_TYPE_NAME, "Employee type name already exists", HttpStatus.CONFLICT);
            }
        }

        EmployeeTypeEntity entity = EmployeeTypeMapper.toEntity(requestDTO);
        EmployeeTypeEntity saved = employeeTypeRepository.save(entity);

        log.info("[Service:EmployeeTypeService] create() succeeded - Created with id: {}", saved.getId());
        return EmployeeTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public EmployeeTypeResponseDTO update(Long id, EmployeeTypeRequestDTO requestDTO) {
        log.info("[Service:EmployeeTypeService] update() called - id: {}", id);

        EmployeeTypeEntity existing = employeeTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EmployeeTypeErrors.EMPLOYEE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (employeeTypeRepository.existsByNameAndIdNot(requestDTO.getName().trim(), id)) {
                throw new ApiException(EmployeeTypeErrors.DUPLICATE_EMPLOYEE_TYPE_NAME, "Employee type name already exists", HttpStatus.CONFLICT);
            }
        }

        EmployeeTypeMapper.updateEntityFromDTO(existing, requestDTO);
        EmployeeTypeEntity updated = employeeTypeRepository.save(existing);

        log.info("[Service:EmployeeTypeService] update() succeeded - id: {}", id);
        return EmployeeTypeMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:EmployeeTypeService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalEmployeeTypes", employeeTypeRepository.countAllNotDeleted());
        stats.put("activeEmployeeTypes", employeeTypeRepository.countByActiveTrue());
        stats.put("inactiveEmployeeTypes", employeeTypeRepository.countByActiveFalse());

        log.info("[Service:EmployeeTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
