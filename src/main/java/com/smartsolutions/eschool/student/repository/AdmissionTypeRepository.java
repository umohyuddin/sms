package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdmissionTypeRepository extends JpaRepository<AdmissionTypeEntity, Long> {

    @Query("SELECT a FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId AND a.deleted = false")
    List<AdmissionTypeEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT a FROM AdmissionTypeEntity a WHERE a.id = :id AND a.organizationId = :organizationId AND a.deleted = false")
    Optional<AdmissionTypeEntity> findByIdAndOrganizationId(@Param("id") Long id,
            @Param("organizationId") Long organizationId);

    @Query("SELECT a FROM AdmissionTypeEntity a WHERE (a.name LIKE %:keyword% OR a.code LIKE %:keyword%) "
            + "AND a.organizationId = :organizationId AND a.deleted = false")
    List<AdmissionTypeEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword,
            @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE AdmissionTypeEntity a SET a.deleted = true, a.deletedAt = CURRENT_TIMESTAMP "
            + "WHERE a.id = :id AND a.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(a) FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId AND a.deleted = false")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(a) FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId "
            + "AND a.isActive = true AND a.deleted = false")
    Long countByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(a) FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId "
            + "AND a.isActive = false AND a.deleted = false")
    Long countByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(a) > 0) FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId "
            + "AND a.code = :code AND a.deleted = false")
    boolean existsByOrganizationIdAndCode(@Param("organizationId") Long organizationId,
            @Param("code") String code);

    @Query("SELECT (COUNT(a) > 0) FROM AdmissionTypeEntity a WHERE a.organizationId = :organizationId "
            + "AND a.code = :code AND a.id <> :id AND a.deleted = false")
    boolean existsByOrganizationIdAndCodeAndIdNot(@Param("organizationId") Long organizationId,
            @Param("code") String code, @Param("id") Long id);
}
