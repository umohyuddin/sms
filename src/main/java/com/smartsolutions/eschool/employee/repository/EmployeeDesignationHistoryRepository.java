package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeDesignationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDesignationHistoryRepository extends JpaRepository<EmployeeDesignationHistoryEntity, Long> {

    Optional<EmployeeDesignationHistoryEntity> findByEmployeeIdAndIsCurrentTrue(Long employeeId);
}