package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeeCatalogRepository extends JpaRepository<FeeCatalogEntity, Long> {

        @Query("SELECT fc FROM FeeCatalogEntity fc " +
                        "JOIN FETCH fc.institute i " +
                        "JOIN FETCH fc.chargeType ct " +
                        "LEFT JOIN FETCH fc.recurrenceRule rr " +
                        "WHERE i.id = :instituteId AND fc.deleted = false")
        List<FeeCatalogEntity> findByInstituteId(@Param("instituteId") Long instituteId);

        @Query("SELECT fc FROM FeeCatalogEntity fc " +
                        "JOIN FETCH fc.institute i " +
                        "JOIN FETCH fc.chargeType ct " +
                        "LEFT JOIN FETCH fc.recurrenceRule rr " +
                        "WHERE fc.id = :id AND i.id = :instituteId AND fc.deleted = false")
        Optional<FeeCatalogEntity> findByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Query("SELECT fc FROM FeeCatalogEntity fc " +
                        "JOIN FETCH fc.institute i " +
                        "JOIN FETCH fc.chargeType ct " +
                        "LEFT JOIN FETCH fc.recurrenceRule rr " +
                        "WHERE (LOWER(fc.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(fc.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(fc.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
                        "AND i.id = :instituteId AND fc.deleted = false")
        List<FeeCatalogEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT fc FROM FeeCatalogEntity fc " +
                        "JOIN FETCH fc.institute i " +
                        "JOIN FETCH fc.chargeType ct " +
                        "LEFT JOIN FETCH fc.recurrenceRule rr " +
                        "WHERE (LOWER(fc.code) = LOWER(:code) OR LOWER(fc.name) = LOWER(:name)) " +
                        "AND i.id = :instituteId AND fc.deleted = false")
        Optional<FeeCatalogEntity> findByCodeOrNameAndInstituteId(@Param("code") String code,
                        @Param("name") String name, @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("UPDATE FeeCatalogEntity fc SET fc.deleted = true, fc.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE fc.id = :id AND fc.institute.id = :instituteId")
        int softDeleteByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(fc) FROM FeeCatalogEntity fc WHERE fc.institute.id = :instituteId AND fc.deleted = false")
        Long countByInstituteId(@Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(fc) FROM FeeCatalogEntity fc WHERE fc.institute.id = :instituteId AND fc.active = true AND fc.deleted = false")
        Long countByInstituteIdAndActiveTrue(@Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(fc) FROM FeeCatalogEntity fc WHERE fc.institute.id = :instituteId AND fc.active = false AND fc.deleted = false")
        Long countByInstituteIdAndActiveFalse(@Param("instituteId") Long instituteId);
}
