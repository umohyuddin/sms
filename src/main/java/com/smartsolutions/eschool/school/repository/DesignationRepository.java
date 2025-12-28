package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity, Long> {

    /* =========================
       BASIC FETCH
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.id = :id
                  AND d.deleted = false
            """)
    Optional<DesignationEntity> findByIdActive(@Param("id") Long id);

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.designationCode = :code
                  AND d.deleted = false
            """)
    Optional<DesignationEntity> findByCode(@Param("code") String code);

    /* =========================
       LIST ALL
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.deleted = false
                ORDER BY d.designationName
            """)
    List<DesignationEntity> findAllActive();

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.active = true
                  AND d.deleted = false
                ORDER BY d.designationName
            """)
    List<DesignationEntity> findAllEnabled();

    /* =========================
       EMPLOYEE TYPE
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.employeeType.id = :employeeTypeId
                  AND d.deleted = false
            """)
    List<DesignationEntity> findByEmployeeType(@Param("employeeTypeId") Long employeeTypeId);

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.employeeType.id = :employeeTypeId
                  AND d.active = true
                  AND d.deleted = false
            """)
    List<DesignationEntity> findActiveByEmployeeType(@Param("employeeTypeId") Long employeeTypeId);

    /* =========================
       DEPARTMENT
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.department.id = :departmentId
                  AND d.deleted = false
            """)
    List<DesignationEntity> findByDepartment(@Param("departmentId") Long departmentId);

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.department.id = :departmentId
                  AND d.active = true
                  AND d.deleted = false
            """)
    List<DesignationEntity> findActiveByDepartment(@Param("departmentId") Long departmentId);

    /* =========================
       EMPLOYEE TYPE + DEPARTMENT
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.employeeType.id = :employeeTypeId
                  AND d.department.id = :departmentId
                  AND d.deleted = false
            """)
    List<DesignationEntity> findByEmployeeTypeAndDepartment(@Param("employeeTypeId") Long employeeTypeId, @Param("departmentId") Long departmentId);

    /* =========================
       GLOBAL DESIGNATIONS
       (No Department)
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.department IS NULL
                  AND d.deleted = false
            """)
    List<DesignationEntity> findGlobalDesignations();

    /* =========================
       SEARCH
       ========================= */

    @Query("""
                SELECT d FROM DesignationEntity d
                WHERE d.deleted = false
                  AND (
                        LOWER(d.designationName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                     OR LOWER(d.designationCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
            """)
    List<DesignationEntity> search(@Param("keyword") String keyword);

    /* =========================
       EXISTENCE / VALIDATION
       ========================= */

    @Query("""
                SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END
                FROM DesignationEntity d
                WHERE d.designationCode = :code
                  AND d.deleted = false
            """)
    boolean existsByCode(@Param("code") String code);

    @Query("""
                SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END
                FROM DesignationEntity d
                WHERE d.designationName = :name
                  AND d.employeeType.id = :employeeTypeId
                  AND d.deleted = false
            """)
    boolean existsByNameAndEmployeeType(@Param("name") String name, @Param("employeeTypeId") Long employeeTypeId);

    /* =========================
       COUNT / REPORTING
       ========================= */

    @Query("""
                SELECT COUNT(d)
                FROM DesignationEntity d
                WHERE d.employeeType.id = :employeeTypeId
                  AND d.deleted = false
            """)
    long countByEmployeeType(@Param("employeeTypeId") Long employeeTypeId);

    @Query("""
                SELECT COUNT(d)
                FROM DesignationEntity d
                WHERE d.department.id = :departmentId
                  AND d.deleted = false
            """)
    long countByDepartment(@Param("departmentId") Long departmentId);

    /* =========================
       DROPDOWN
       ========================= */

    @Query("""
                SELECT d
                FROM DesignationEntity d
                WHERE d.active = true
                  AND d.deleted = false
                ORDER BY d.designationName
            """)
    List<DesignationEntity> findForDropdown();

}