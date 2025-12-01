package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
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
public interface CityRepository extends JpaRepository<CityEntity,Long>  {
    // Fetch all non-deleted cities
    @Query("SELECT c FROM CityEntity c WHERE c.deleted = false")
    List<CityEntity> findAllActive();

    // Fetch all soft-deleted cities
    @Query("SELECT c FROM CityEntity c WHERE c.deleted = true")
    List<CityEntity> findAllDeleted();

    // Fetch city by ID (non-deleted)
    @Query("SELECT c FROM CityEntity c WHERE c.id = :id AND c.deleted = false")
    Optional<CityEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    // Fetch city by ID (including deleted)
    @Query("SELECT c FROM CityEntity c WHERE c.id = :id")
    Optional<CityEntity> findByIdIncludingDeleted(@Param("id") Long id);

    // Search by name or code (non-deleted)
    @Query("SELECT c FROM CityEntity c WHERE (c.name LIKE %:keyword% OR c.code LIKE %:keyword%) AND c.deleted = false")
    List<CityEntity> searchByKeyword(@Param("keyword") String keyword);

    // Fetch all cities of a province (non-deleted)
    @Query("SELECT c FROM CityEntity c WHERE c.province.id = :provinceId AND c.deleted = false order by  c.name")
    List<CityEntity> findByProvinceId(@Param("provinceId") Long provinceId);

    // Fetch all active cities of a province
    @Query("SELECT c FROM CityEntity c WHERE c.province.id = :provinceId AND c.isActive = true AND c.deleted = false")
    List<CityEntity> findActiveByProvinceId(@Param("provinceId") Long provinceId);

    // Soft delete city by ID
    @Modifying
    @Query("UPDATE CityEntity c SET c.deleted = true, c.deletedAt = CURRENT_TIMESTAMP WHERE c.id = :id")
    int softDeleteById(@Param("id") Long id);

    // Soft delete all cities of a province
    @Modifying
    @Query("UPDATE CityEntity c SET c.deleted = true, c.deletedAt = CURRENT_TIMESTAMP WHERE c.province.id = :provinceId")
    int softDeleteByProvinceId(@Param("provinceId") Long provinceId);

    // Activate / deactivate a city
    @Modifying
    @Query("UPDATE CityEntity c SET c.isActive = :status WHERE c.id = :id AND c.deleted = false")
    int setActiveStatus(@Param("id") Long id, @Param("status") boolean status);

    // Count cities in a province
    @Query("SELECT COUNT(c) FROM CityEntity c WHERE c.province.id = :provinceId AND c.deleted = false")
    long countByProvinceId(@Param("provinceId") Long provinceId);

    // Check if city name exists in a province (non-deleted)
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM CityEntity c " +
            "WHERE c.name = :name AND c.province.id = :provinceId AND c.deleted = false")
    boolean existsByNameInProvince(@Param("name") String name, @Param("provinceId") Long provinceId);
}

