package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignmentEntity, Long> {

    @Query("SELECT e FROM EmployeeAssignmentEntity e LEFT JOIN FETCH e.campus LEFT JOIN FETCH e.department LEFT JOIN FETCH e.designation WHERE e.employee.id = :employeeId AND e.isPrimary = true AND e.deleted = false")
    Optional<EmployeeAssignmentEntity> findPrimaryAssignmentByEmployeeId(@Param("employeeId") Long employeeId);

    @Query("""
        SELECT a.designation.id as designationId, 
               a.designation.designationName as designationName, 
               COUNT(a.employee.id) as totalEmployees
        FROM EmployeeAssignmentEntity a
        WHERE a.isPrimary = true 
          AND a.designation.organizationId = :organizationId
          AND a.deleted = false
        GROUP BY a.designation.id, a.designation.designationName
    """)
    List<com.smartsolutions.eschool.school.dtos.designations.response.DesignationCountDTO> getStaffCountByDesignation(@Param("organizationId") Long organizationId);

    @Query("""
        SELECT a.department.id as departmentId, 
               a.department.departmentName as departmentName, 
               COUNT(a.employee.id) as totalEmployees
        FROM EmployeeAssignmentEntity a
        WHERE a.isPrimary = true 
          AND a.department.campus.id = :campusId
          AND a.deleted = false
        GROUP BY a.department.id, a.department.departmentName
    """)
    List<com.smartsolutions.eschool.school.dtos.departments.response.DepartmentCountDTO> getStaffCountByDepartment(@Param("campusId") Long campusId);

    @Query("SELECT e FROM EmployeeAssignmentEntity e WHERE e.employee.id = :employeeId AND e.deleted = false ORDER BY e.startDate DESC")
    List<EmployeeAssignmentEntity> findByEmployeeId(@Param("employeeId") Long employeeId);
}
