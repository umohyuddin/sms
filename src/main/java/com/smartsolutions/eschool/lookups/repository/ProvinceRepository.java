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
                          AND p.deletedAt IS NULL
                        """)
        Optional<ProvinceEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("""
                        SELECT p
                        FROM ProvinceEntity p
                        WHERE p.deletedAt IS NULL
                        ORDER BY p.name ASC
                        """)
        List<ProvinceEntity> findAllNotDeleted();

        @Query("""
                        SELECT p
                        FROM ProvinceEntity p
                        WHERE p.isActive = true
                          AND p.deletedAt IS NULL
                        ORDER BY p.name ASC
                        """)
        List<ProvinceEntity> findAllActive();

        @Query("""
                        SELECT p
                        FROM ProvinceEntity p
                        WHERE p.country.id = :countryId
                          AND p.deletedAt IS NULL
                        ORDER BY p.name ASC
                        """)
        List<ProvinceEntity> findByCountryId(@Param("countryId") Long countryId);

        @Query("""
                        SELECT p
                        FROM ProvinceEntity p
                        WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                            OR LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
                          AND p.deletedAt IS NULL
                        ORDER BY p.name ASC
                        """)
        List<ProvinceEntity> searchByKeyword(@Param("keyword") String keyword);

        @Modifying
        @Transactional
        @Query("""
                        UPDATE ProvinceEntity p
                        SET p.deletedAt = CURRENT_TIMESTAMP
                        WHERE p.id = :id
                        """)
        int softDeleteById(@Param("id") Long id);

        @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.deletedAt IS NULL")
        Long countAllNotDeleted();

        @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.isActive = true AND p.deletedAt IS NULL")
        Long countByActiveTrue();

        @Query("SELECT COUNT(p) FROM ProvinceEntity p WHERE p.isActive = false AND p.deletedAt IS NULL")
        Long countByActiveFalse();

        @Query("SELECT (COUNT(p) > 0) FROM ProvinceEntity p WHERE p.country.id = :countryId AND p.name = :name AND p.deletedAt IS NULL")
        boolean existsByCountryIdAndName(@Param("countryId") Long countryId, @Param("name") String name);

        @Query("SELECT (COUNT(p) > 0) FROM ProvinceEntity p WHERE p.country.id = :countryId AND p.name = :name AND p.id <> :id AND p.deletedAt IS NULL")
        boolean existsByCountryIdAndNameAndIdNot(@Param("countryId") Long countryId, @Param("name") String name,
                        @Param("id") Long id);
}
