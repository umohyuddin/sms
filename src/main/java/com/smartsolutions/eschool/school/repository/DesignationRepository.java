package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity, Long> {

    @Query("SELECT d FROM DesignationEntity d WHERE d.id = :id AND d.organizationId = :organizationId")
    Optional<DesignationEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DesignationEntity d WHERE d.organizationId = :organizationId ORDER BY d.designationName")
    List<DesignationEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DesignationEntity d WHERE d.active = true AND d.organizationId = :organizationId ORDER BY d.designationName")
    List<DesignationEntity> findAllEnabled(@Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DesignationEntity d WHERE (LOWER(d.designationName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(d.designationCode) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND d.organizationId = :organizationId")
    List<DesignationEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(d) > 0) FROM DesignationEntity d WHERE d.organizationId = :organizationId AND d.designationCode = :code")
    boolean existsByCodeAndOrganizationId(@Param("code") String code, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(d) > 0) FROM DesignationEntity d WHERE d.organizationId = :organizationId AND d.designationCode = :code AND d.id <> :id")
    boolean existsByCodeAndOrganizationIdAndIdNot(@Param("code") String code, @Param("organizationId") Long organizationId, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE DesignationEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP WHERE d.id = :id AND d.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);
}
