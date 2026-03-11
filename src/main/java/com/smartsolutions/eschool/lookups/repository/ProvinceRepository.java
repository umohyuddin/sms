package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {

    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.id = :id
              AND p.deleted = false
            """)
    Optional<ProvinceEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> findAllNotDeleted();

    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.isActive = true
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> findAllActive();

    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE p.country.id = :countryId
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> findByCountryId(@Param("countryId") Long countryId);

    @Query("""
            SELECT p
            FROM ProvinceEntity p
            WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND p.deleted = false
            ORDER BY p.name ASC
            """)
    List<ProvinceEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE ProvinceEntity p
            SET p.deleted = true,
                p.deletedAt = CURRENT_TIMESTAMP
            WHERE p.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.isActive = true AND p.deleted = false")
    Long countByActiveTrue();

    @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.isActive = false AND p.deleted = false")
    Long countByActiveFalse();

    @Query("SELECT (COUNT(p) > 0) FROM ProvinceEntity p WHERE p.country.id = :countryId AND p.name = :name AND p.deleted = false")
    boolean existsByCountryIdAndName(@Param("countryId") Long countryId, @Param("name") String name);

    @Query("SELECT (COUNT(p) > 0) FROM ProvinceEntity p WHERE p.country.id = :countryId AND p.name = :name AND p.id <> :id AND p.deleted = false")
    boolean existsByCountryIdAndNameAndIdNot(@Param("countryId") Long countryId, @Param("name") String name, @Param("id") Long id);
}
