package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeEntity, Long> {

    @Query("""
            SELECT e
            FROM EmployeeTypeEntity e
            WHERE e.id = :id
              AND e.deleted = false
            """)
    Optional<EmployeeTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT e
            FROM EmployeeTypeEntity e
            WHERE e.active = true
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllActive();

    @Query("""
            SELECT e
            FROM EmployeeTypeEntity e
            WHERE e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> findAllNotDeleted();

    @Query("""
            SELECT e
            FROM EmployeeTypeEntity e
            WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EmployeeTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE EmployeeTypeEntity e
            SET e.deleted = true,
                e.deletedAt = CURRENT_TIMESTAMP
            WHERE e.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = true AND e.deleted = false")
    Long countByActiveTrue();

    @Query("SELECT COUNT(e) FROM EmployeeTypeEntity e WHERE e.active = false AND e.deleted = false")
    Long countByActiveFalse();

    @Query("SELECT (COUNT(e) > 0) FROM EmployeeTypeEntity e WHERE e.name = :name AND e.deleted = false")
    boolean existsByName(@Param("name") String name);

    @Query("SELECT (COUNT(e) > 0) FROM EmployeeTypeEntity e WHERE e.name = :name AND e.id <> :id AND e.deleted = false")
    boolean existsByNameAndIdNot(@Param("name") String name, @Param("id") Long id);
}
