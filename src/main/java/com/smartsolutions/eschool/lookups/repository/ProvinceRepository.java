package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Long>  {
    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.id = :id
              AND p.deleted = false
            ORDER BY p.id
            """)
    Optional<ProvinceEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    // Find all active provinces
    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.isActive = true
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> findAllActive();


    // Find all non-active provinces
    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.isActive = false
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> findAllNonActive();

    // Search provinces by name or code
    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE (p.name LIKE %:keyword% OR p.code LIKE %:keyword%)
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> searchByKeyword(@Param("keyword") String keyword);

    // Soft delete one record
    @Modifying
    @Transactional
    @Query("""
            UPDATE ProvinceEntity p
            SET p.deleted = true,
                p.deletedAt = CURRENT_TIMESTAMP
            WHERE p.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    // Soft delete all provinces
    @Modifying
    @Transactional
    @Query("""
            UPDATE ProvinceEntity p
            SET p.deleted = true,
                p.deletedAt = CURRENT_TIMESTAMP
            """)
    int softDeleteAll();

    @Query("""
            SELECT p FROM ProvinceEntity p
             WHERE p.country.id = :countryId
              AND p.isActive = true
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> getByProvinceByCountry( @Param("countryId") Long countryId);
}
