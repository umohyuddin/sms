package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeTypeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeTypeHistoryRepository extends JpaRepository<EmployeeTypeHistoryEntity, Long> {

    Optional<EmployeeTypeHistoryEntity> findByEmployeeIdAndIsCurrentTrue(Long employeeId);
}
