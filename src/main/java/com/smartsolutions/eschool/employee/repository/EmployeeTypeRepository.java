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

    Optional<EmployeeTypeEntity> findByIdAndDeletedFalse(Long id);

    Optional<EmployeeTypeEntity> findByNameIgnoreCaseAndDeletedFalse(String name);

    boolean existsByNameIgnoreCaseAndDeletedFalse(String name);

    /* =========================
       LISTING
       ========================= */

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.deleted = false
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllNonDeleted();

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.active = true AND e.deleted = false
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllActive();

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.active = false AND e.deleted = false
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllInactive();

    /* =========================
       SEARCH
       ========================= */

    @Query("""
                SELECT e FROM EmployeeTypeEntity e
                WHERE e.deleted = false
                  AND (
                    LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(e.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
                ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    /* =========================
       COUNTING
       ========================= */

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.deleted = false")
    long countAll();

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = true AND e.deleted = false")
    long countActive();

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = false AND e.deleted = false")
    long countInactive();

    /* =========================
       SOFT DELETE
       ========================= */

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.deleted = true
                WHERE e.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    /* =========================
       ACTIVATE / DEACTIVATE
       ========================= */

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.active = true
                WHERE e.id = :id AND e.deleted = false
            """)
    int activateById(@Param("id") Long id);

    @Modifying
    @Query("""
                UPDATE EmployeeTypeEntity e
                SET e.active = false
                WHERE e.id = :id AND e.deleted = false
            """)
    int deactivateById(@Param("id") Long id);
}