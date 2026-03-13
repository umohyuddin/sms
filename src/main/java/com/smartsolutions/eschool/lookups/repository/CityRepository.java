package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

        @Query("""
                        SELECT c
                        FROM CityEntity c
                        WHERE c.id = :id
                          AND c.deletedAt IS NULL
                        """)
        Optional<CityEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("""
                        SELECT c
                        FROM CityEntity c
                        WHERE c.deletedAt IS NULL
                        ORDER BY c.name ASC
                        """)
        List<CityEntity> findAllNotDeleted();

        @Query("""
                        SELECT c
                        FROM CityEntity c
                        WHERE c.isActive = true
                          AND c.deletedAt IS NULL
                        ORDER BY c.name ASC
                        """)
        List<CityEntity> findAllActive();

        @Query("""
                        SELECT c
                        FROM CityEntity c
                        WHERE c.province.id = :provinceId
                          AND c.deletedAt IS NULL
                        ORDER BY c.name ASC
                        """)
        List<CityEntity> findByProvinceId(@Param("provinceId") Long provinceId);

        @Query("""
                        SELECT c
                        FROM CityEntity c
                        WHERE (LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                            OR LOWER(c.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
                          AND c.deletedAt IS NULL
                        ORDER BY c.name ASC
                        """)
        List<CityEntity> searchByKeyword(@Param("keyword") String keyword);

        @Modifying
        @Transactional
        @Query("""
                        UPDATE CityEntity c
                        SET c.deletedAt = CURRENT_TIMESTAMP
                        WHERE c.id = :id
                        """)
        int softDeleteById(@Param("id") Long id);

        @Query("SELECT COUNT(c) FROM CityEntity c WHERE c.deletedAt IS NULL")
        Long countAllNotDeleted();

        @Query("SELECT COUNT(c) FROM CityEntity c WHERE c.isActive = true AND c.deletedAt IS NULL")
        Long countByActiveTrue();

        @Query("SELECT COUNT(c) FROM CityEntity c WHERE c.isActive = false AND c.deletedAt IS NULL")
        Long countByActiveFalse();

        @Query("SELECT (COUNT(c) > 0) FROM CityEntity c WHERE c.province.id = :provinceId AND c.name = :name AND c.deletedAt IS NULL")
        boolean existsByProvinceIdAndName(@Param("provinceId") Long provinceId, @Param("name") String name);

        @Query("SELECT (COUNT(c) > 0) FROM CityEntity c WHERE c.province.id = :provinceId AND c.name = :name AND c.id <> :id AND c.deletedAt IS NULL")
        boolean existsByProvinceIdAndNameAndIdNot(@Param("provinceId") Long provinceId, @Param("name") String name,
                        @Param("id") Long id);
}
