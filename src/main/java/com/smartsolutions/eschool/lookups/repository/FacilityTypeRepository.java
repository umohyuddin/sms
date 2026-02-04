package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
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
public interface FacilityTypeRepository extends JpaRepository<FacilityTypeEntity, Long> {

    @Query("""
            SELECT f
            FROM FacilityTypeEntity f
            WHERE f.id = :id
              AND f.deleted = false
            """)
    Optional<FacilityTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT f
            FROM FacilityTypeEntity f
            WHERE f.isActive = true
              AND f.deleted = false
            ORDER BY f.name ASC
            """)
    List<FacilityTypeEntity> findAllActive();

    @Modifying
    @Transactional
    @Query("""
            UPDATE FacilityTypeEntity f
            SET f.deleted = true,
                f.deletedAt = CURRENT_TIMESTAMP
            WHERE f.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
