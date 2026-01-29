package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeDesignationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface
EmployeeDesignationHistoryRepository extends JpaRepository<EmployeeDesignationHistoryEntity, Long> {

    Optional<EmployeeDesignationHistoryEntity> findByEmployeeIdAndIsCurrentTrue(Long employeeId);

    @Query("""
        SELECT e FROM EmployeeDesignationHistoryEntity e
        WHERE e.employee.id = :employeeId
          AND e.isCurrent = true
    """)
    Optional<EmployeeDesignationHistoryEntity> findCurrentByEmployeeId(
            @Param("employeeId") Long employeeId
    );


    List<EmployeeDesignationHistoryEntity> findByEmployee_IdOrderByStartDateDesc(Long employeeId);
}