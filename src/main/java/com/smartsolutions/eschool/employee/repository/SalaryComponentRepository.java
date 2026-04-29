package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryComponentRepository extends JpaRepository<SalaryComponentEntity, Long> {

    @Query("""
            SELECT s
            FROM SalaryComponentEntity s
            WHERE s.id = :id
              AND s.deleted = false
            """)
    Optional<SalaryComponentEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT s
            FROM SalaryComponentEntity s
            WHERE s.deleted = false
            ORDER BY s.name ASC
            """)
    List<SalaryComponentEntity> findAllNotDeleted();

    @Query("""
            SELECT s
            FROM SalaryComponentEntity s
            WHERE s.organizationId = :organizationId
              AND s.deleted = false
            ORDER BY s.name ASC
            """)
    List<SalaryComponentEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("""
            SELECT s
            FROM SalaryComponentEntity s
            WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
              AND s.deleted = false
            ORDER BY s.name ASC
            """)
    List<SalaryComponentEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE SalaryComponentEntity s
            SET s.deleted = true,
                s.deletedAt = CURRENT_TIMESTAMP
            WHERE s.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(s) FROM SalaryComponentEntity s WHERE s.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT (COUNT(s) > 0) FROM SalaryComponentEntity s WHERE s.name = :name AND s.organizationId = :organizationId AND s.deleted = false")
    boolean existsByNameAndOrganizationId(@Param("name") String name, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(s) > 0) FROM SalaryComponentEntity s WHERE s.name = :name AND s.organizationId = :organizationId AND s.id <> :id AND s.deleted = false")
    boolean existsByNameAndOrganizationIdAndIdNot(@Param("name") String name, @Param("organizationId") Long organizationId, @Param("id") Long id);
}
