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

    @Query("""
        SELECT h.designation.id as designationId, 
               h.designation.designationName as designationName, 
               COUNT(h.employee.id) as totalEmployees
        FROM EmployeeDesignationHistoryEntity h
        WHERE h.isCurrent = true 
          AND h.designation.organizationId = :organizationId
        GROUP BY h.designation.id, h.designation.designationName
    """)
    List<com.smartsolutions.eschool.school.dtos.designations.response.DesignationCountDTO> getStaffCountByDesignation(@Param("organizationId") Long organizationId);
}
