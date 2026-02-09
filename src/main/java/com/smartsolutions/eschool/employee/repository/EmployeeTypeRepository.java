package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeEntity, Long> {

    /* =========================
       BASIC FINDS
       ========================= */

    Optional<EmployeeTypeEntity> findByIdAndOrganizationIdAndDeletedFalse(Long id, Long organizationId);

    Optional<EmployeeTypeEntity> findByNameIgnoreCaseAndOrganizationIdAndDeletedFalse(String name, Long organizationId);

    boolean existsByNameIgnoreCaseAndOrganizationIdAndDeletedFalse(String name, Long organizationId);

    /* =========================
       LISTING
       ========================= */

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.deleted = false AND e.organizationId = :organizationId
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllNonDeleted(@Param("organizationId") Long organizationId);

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.active = true AND e.deleted = false AND e.organizationId = :organizationId
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllActive(@Param("organizationId") Long organizationId);

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.active = false AND e.deleted = false AND e.organizationId = :organizationId
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllInactive(@Param("organizationId") Long organizationId);

    /* =========================
       SEARCH
       ========================= */

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.deleted = false AND e.organizationId = :organizationId
                  AND (
                    LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(e.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> searchByKeyword(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    /* =========================
       COUNTING
       ========================= */

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.deleted = false AND e.organizationId = :organizationId")
    long countAll(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = true AND e.deleted = false AND e.organizationId = :organizationId")
    long countActive(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = false AND e.deleted = false AND e.organizationId = :organizationId")
    long countInactive(@Param("organizationId") Long organizationId);

    /* =========================
       SOFT DELETE
       ========================= */

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.deleted = true
                WHERE e.id = :id AND e.organizationId = :organizationId
            """)
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    /* =========================
       ACTIVATE / DEACTIVATE
       ========================= */

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.active = true
                WHERE e.id = :id AND e.organizationId = :organizationId AND e.deleted = false
            """)
    int activateByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.active = false
                WHERE e.id = :id AND e.organizationId = :organizationId AND e.deleted = false
            """)
    int deactivateByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);
}