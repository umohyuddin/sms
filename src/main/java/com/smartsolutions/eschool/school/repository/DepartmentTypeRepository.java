package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentTypeRepository extends JpaRepository<DepartmentTypeEntity, Long> {

    @Query("SELECT d FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId")
    List<DepartmentTypeEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DepartmentTypeEntity d WHERE d.id = :id AND d.organizationId = :organizationId")
    Optional<DepartmentTypeEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DepartmentTypeEntity d WHERE (d.name LIKE %:keyword% OR d.code LIKE %:keyword%) AND d.organizationId = :organizationId")
    List<DepartmentTypeEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE DepartmentTypeEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP WHERE d.id = :id AND d.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(d) > 0) FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId AND d.code = :code")
    boolean existsByOrganizationIdAndCode(@Param("organizationId") Long organizationId, @Param("code") String code);

    @Query("SELECT (COUNT(d) > 0) FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId AND d.code = :code AND d.id <> :id")
    boolean existsByOrganizationIdAndCodeAndIdNot(@Param("organizationId") Long organizationId, @Param("code") String code, @Param("id") Long id);

    @Query("SELECT COUNT(d) FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(d) FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId AND d.active = true")
    Long countByOrganizationIdAndActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(d) FROM DepartmentTypeEntity d WHERE d.organizationId = :organizationId AND d.active = false")
    Long countByOrganizationIdAndActiveFalse(@Param("organizationId") Long organizationId);
}
