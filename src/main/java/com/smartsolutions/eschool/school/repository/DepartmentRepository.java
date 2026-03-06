package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query("""
            SELECT d
            FROM DepartmentEntity d
            LEFT JOIN FETCH d.headEmployee e
            LEFT JOIN FETCH d.parentDepartment p
            WHERE d.organizationId = :organizationId
            """)
    List<DepartmentEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("""
            SELECT d
            FROM DepartmentEntity d
            LEFT JOIN FETCH d.headEmployee e
            LEFT JOIN FETCH d.parentDepartment p
            WHERE d.id = :id AND d.organizationId = :organizationId
            """)
    Optional<DepartmentEntity> findByIdAndOrganizationId(@Param("id") Long id,
            @Param("organizationId") Long organizationId);

    @Query("""
            SELECT d
            FROM DepartmentEntity d
            LEFT JOIN FETCH d.headEmployee e
            LEFT JOIN FETCH d.parentDepartment p
            WHERE d.active = true AND d.organizationId = :organizationId
            """)
    List<DepartmentEntity> findAllActive(@Param("organizationId") Long organizationId);

    @Query("""
                SELECT d
                FROM DepartmentEntity d
                LEFT JOIN FETCH d.parentDepartment p
                LEFT JOIN FETCH d.headEmployee h
                WHERE d.organizationId = :organizationId
                  AND (
                      :keyword IS NULL OR
                      LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                      LOWER(d.departmentCode) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                      LOWER(d.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                      LOWER(p.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                      LOWER(h.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                      LOWER(h.employeeCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
                ORDER BY d.departmentName ASC
            """)
    List<DepartmentEntity> searchDepartments(@Param("organizationId") Long organizationId,
            @Param("keyword") String keyword);

    boolean existsByOrganizationIdAndDepartmentCode(Long organizationId, String departmentCode);

    boolean existsByOrganizationIdAndDepartmentCodeAndIdNot(Long organizationId, String departmentCode, Long id);

    boolean existsByOrganizationIdAndDepartmentName(Long organizationId, String departmentName);

    boolean existsByOrganizationIdAndDepartmentNameAndIdNot(Long organizationId, String departmentName, Long id);
}
