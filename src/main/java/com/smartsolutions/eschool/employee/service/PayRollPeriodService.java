package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request.PayrollPeriodRequestDTO;
import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response.PayrollPeriodResponseDTO;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import com.smartsolutions.eschool.employee.repository.PayRollPeriodRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PayRollPeriodService {
    private final PayRollPeriodRepository payrollRepository;

    public PayRollPeriodService(PayRollPeriodRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    /* =========================
       CREATE
       ========================= */
    @Transactional
    public PayrollPeriodResponseDTO createPayrollPeriod(PayrollPeriodRequestDTO requestDTO) {
        log.info("Creating new PayrollPeriod in database: {} to {}", requestDTO.getStartDate(), requestDTO.getEndDate());
        try {
            PayrollPeriodEntity entity = MapperUtil.mapObject(requestDTO, PayrollPeriodEntity.class);
            entity.setDeleted(false);
            PayrollPeriodEntity saved = payrollRepository.save(entity);
            log.info("Successfully created PayrollPeriod: id={}", saved.getId());
            return MapperUtil.mapObject(saved, PayrollPeriodResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while creating PayrollPeriod", e);
            throw new CustomServiceException("Failed to create Payroll Period");
        }
    }

    @Transactional
    public PayrollPeriodResponseDTO updatePayrollPeriod(Long id, PayrollPeriodRequestDTO requestDTO) {
        log.info("Updating PayrollPeriod ID: {} in database", id);
        try {
            PayrollPeriodEntity existing = payrollRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Payroll period not found with id: " + id));

            existing.setStartDate(requestDTO.getStartDate());
            existing.setEndDate(requestDTO.getEndDate());
            existing.setStatus(requestDTO.getStatus());
            existing.setDescription(requestDTO.getDescription());

            PayrollPeriodEntity updated = payrollRepository.save(existing);
            log.info("Successfully updated PayrollPeriod: id={}", updated.getId());
            return MapperUtil.mapObject(updated, PayrollPeriodResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating PayrollPeriod ID: {}", id, e);
            throw new CustomServiceException("Failed to update Payroll Period");
        }
    }

    public PayrollPeriodResponseDTO getPayrollPeriodById(Long id) {
        log.info("Fetching PayrollPeriod ID: {} from database", id);
        try {
            PayrollPeriodEntity entity = payrollRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Payroll period not found with id: " + id));
            log.info("Successfully fetched PayrollPeriod: id={}", entity.getId());
            return MapperUtil.mapObject(entity, PayrollPeriodResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching PayrollPeriod ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Payroll Period");
        }
    }

    public List<PayrollPeriodResponseDTO> getAllPayrollPeriods() {
        log.info("Fetching all non-deleted PayrollPeriods from database");
        try {
            List<PayrollPeriodEntity> entities = payrollRepository.findAllNonDeleted();
            List<PayrollPeriodResponseDTO> dtoList = entities.stream()
                    .map(e -> MapperUtil.mapObject(e, PayrollPeriodResponseDTO.class))
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} PayrollPeriods", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching PayrollPeriods", e);
            throw new CustomServiceException("Failed to fetch Payroll Periods");
        }
    }

    public List<PayrollPeriodResponseDTO> getPayrollPeriodsByStatus(PayrollPeriodEntity.PayrollStatus status) {
        log.info("Fetching PayrollPeriods by status: {}", status);
        try {
            List<PayrollPeriodEntity> entities = payrollRepository.findAllByStatus(status);
            log.info("Successfully fetched {} PayrollPeriods for status: {}", entities.size(), status);
            return entities.stream().map(e -> MapperUtil.mapObject(e, PayrollPeriodResponseDTO.class)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching PayrollPeriods by status", e);
            throw new CustomServiceException("Failed to fetch Payroll Periods by status");
        }
    }

    public List<PayrollPeriodResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching PayrollPeriods with keyword: '{}' in database", searchKey);
        try {
            List<PayrollPeriodEntity> result = payrollRepository.searchByKeyword(searchKey);
            log.info("Successfully fetched {} PayrollPeriods based on search", result.size());
            return result.stream().map(e -> MapperUtil.mapObject(e, PayrollPeriodResponseDTO.class)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while searching PayrollPeriods", e);
            throw new CustomServiceException("Failed to search Payroll Periods");
        }
    }

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting PayrollPeriod ID: {} from database", id);
        try {
            int affected = payrollRepository.softDeleteById(id);
            if (affected == 0) {
                log.warn("PayrollPeriod not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Payroll period not found with id: " + id);
            }
            log.info("Successfully soft deleted PayrollPeriod: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting PayrollPeriod ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Payroll Period");
        }
    }
}
