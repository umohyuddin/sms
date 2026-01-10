package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    // 1. Find all active departments
    @Query("""
                SELECT d
                FROM DepartmentEntity d
                LEFT JOIN FETCH d.headEmployee e
                WHERE d.deleted = false
            """)
    List<DepartmentEntity> findAllActiveDepartments();

    // 2. Find by department code
    @Query("SELECT d FROM DepartmentEntity d WHERE d.departmentCode = :code AND d.deleted = false")
    Optional<DepartmentEntity> findByDepartmentCode(@Param("code") String code);

    // 3. Find departments by parent department
    @Query("SELECT d FROM DepartmentEntity d WHERE d.parentDepartment.id = :parentId AND d.deleted = false")
    List<DepartmentEntity> findByParentDepartmentId(@Param("parentId") Long parentId);

    // 4. Find department by head employee
    @Query("SELECT d FROM DepartmentEntity d WHERE d.headEmployee.id = :employeeId AND d.deleted = false")
    Optional<DepartmentEntity> findByHeadEmployeeId(@Param("employeeId") Long employeeId);

    // 5. Search departments by name (partial match)
    @Query("SELECT d FROM DepartmentEntity d WHERE LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :name, '%')) AND d.deleted = false")
    List<DepartmentEntity> searchByDepartmentName(@Param("name") String name);

    @Query("""
        SELECT d
        FROM DepartmentEntity d
        LEFT JOIN d.parentDepartment p
        LEFT JOIN d.headEmployee h
        WHERE d.deleted = false
          AND (
              LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
              LOWER(d.departmentCode) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
              LOWER(d.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
              LOWER(p.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
              LOWER(h.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
              LOWER(h.employeeCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
          )
        ORDER BY d.departmentName ASC
    """)
    List<DepartmentEntity> searchDepartments(@Param("keyword") String keyword);
}
