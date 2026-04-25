package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.student.repository.FeeDao;
import com.smartsolutions.eschool.student.repository.StudentFeeAssignmentRepository;
import com.smartsolutions.eschool.student.repository.StudentFeePaymentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class FeeService {

    private final FeeDao feeDao;
    private final StudentFeePaymentsRepository paymentsRepository;
    private final StudentFeeAssignmentRepository assignmentRepository;

    public FeeService(FeeDao pFeeDao, 
                      StudentFeePaymentsRepository paymentsRepository, 
                      StudentFeeAssignmentRepository assignmentRepository) {
        this.feeDao = pFeeDao;
        this.paymentsRepository = paymentsRepository;
        this.assignmentRepository = assignmentRepository;
    }

    private Long getOrgId() {
        return com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Double getTotalCollection(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getTotalCollection() called - orgId: {}", orgId);
        Double total = paymentsRepository.sumCollectionByFilters(
                filter.getCampusIds(), 
                filter.getAcademicYearId(), 
                filter.getFromDate(), 
                filter.getToDate(), 
                orgId
        );
        log.info("[Service:FeeService] getTotalCollection() succeeded - total: {}", total);
        return total;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Double getPendingDues(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getPendingDues() called - orgId: {}", orgId);
        Double dues = assignmentRepository.sumPendingDuesByFilters(
                filter.getCampusIds(), 
                filter.getAcademicYearId(), 
                orgId
        );
        log.info("[Service:FeeService] getPendingDues() succeeded - dues: {}", dues);
        return dues;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.Map<String, Double> getCollectionByFeeType(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getCollectionByFeeType() called - orgId: {}", orgId);
        java.util.List<Object[]> results = paymentsRepository.collectionByFeeTypeDistribution(filter.getCampusIds(), orgId);
        java.util.Map<String, Double> distribution = new java.util.HashMap<>();
        for (Object[] row : results) {
            distribution.put(row[0] != null ? row[0].toString() : "Other", (Double) row[1]);
        }
        log.info("[Service:FeeService] getCollectionByFeeType() succeeded - found types: {}", distribution.size());
        return distribution;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.Map<String, Double> getPendingByStandard(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getPendingByStandard() called - orgId: {}", orgId);
        java.util.List<Object[]> results = assignmentRepository.pendingDuesByStandardDistribution(filter.getCampusIds(), orgId);
        java.util.Map<String, Double> distribution = new java.util.HashMap<>();
        for (Object[] row : results) {
            distribution.put(row[0] != null ? row[0].toString() : "N/A", (Double) row[1]);
        }
        log.info("[Service:FeeService] getPendingByStandard() succeeded - found entries: {}", distribution.size());
        return distribution;
    }

    public List<FeeEntity> getAll() {
        return feeDao.findAll();
    }

    public FeeEntity getById(Long id) {
        return feeDao.findById(id);
    }
    public List<FeeEntity> getByStudent(Long std_id) {
        return feeDao.findByStudent(std_id);
    }


    public String create(FeeEntity pFeeEntity) {
        return feeDao.save(pFeeEntity) == 1 ? "Fee created" : "Error creating Fee";
    }

    public String update(FeeEntity pFeeEntity) {
        return feeDao.update(pFeeEntity) == 1 ? "Fee updated" : "Error updating Fee";
    }

    public String delete(Long id) {
        return feeDao.delete(id) == 1 ? "Fee deleted" : "Error deleting Fee";
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.List<Object[]> getRevenueTrend(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getRevenueTrend() called - orgId: {}", orgId);
        LocalDate from = filter.getFromDate() != null ? filter.getFromDate() : LocalDate.now().minusMonths(1);
        LocalDate to = filter.getToDate() != null ? filter.getToDate() : LocalDate.now();
        java.util.List<Object[]> results = paymentsRepository.getRevenueTrend(from, to, filter.getCampusIds(), orgId);
        log.info("[Service:FeeService] getRevenueTrend() succeeded - found entries: {}", results.size());
        return results;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.List<Object[]> getFeeStatusDistribution(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getFeeStatusDistribution() called - orgId: {}", orgId);
        java.util.List<Object[]> results = assignmentRepository.getFeeStatusDistribution(filter.getCampusIds(), orgId);
        log.info("[Service:FeeService] getFeeStatusDistribution() succeeded");
        return results;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public java.util.List<Object[]> getCampusCollectionChart(com.smartsolutions.eschool.dashboard.dtos.DashboardFilter filter, Long orgId) {
        log.info("[Service:FeeService] getCampusCollectionChart() called - orgId: {}", orgId);
        java.util.List<Object[]> results = paymentsRepository.getCollectionByCampus(orgId);
        log.info("[Service:FeeService] getCampusCollectionChart() succeeded");
        return results;
    }
}
