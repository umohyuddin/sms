package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityTypeEntity, Long> {

    @Query("""
            SELECT f
            FROM FacilityTypeEntity f
            WHERE f.isActive = true
            ORDER BY f.name ASC
            """)
    List<FacilityTypeEntity> findAllActive();

    @Query("""
            SELECT f
            FROM FacilityTypeEntity f
            WHERE (LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(f.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
            ORDER BY f.name ASC
            """)
    List<FacilityTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE FacilityTypeEntity f
            SET f.deleted = true,
                f.deletedAt = CURRENT_TIMESTAMP
            WHERE f.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(f) FROM FacilityTypeEntity f WHERE f.isActive = true")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(f) FROM FacilityTypeEntity f WHERE f.isActive = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(f) > 0) FROM FacilityTypeEntity f WHERE f.code = :code")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(f) > 0) FROM FacilityTypeEntity f WHERE f.code = :code AND f.id <> :id")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}

