package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.AssessmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssessmentTypeRepository extends JpaRepository<AssessmentTypeEntity, Long> {

    @Query("SELECT at FROM AssessmentTypeEntity at WHERE at.id = :id AND at.deleted = false")
    Optional<AssessmentTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("SELECT at FROM AssessmentTypeEntity at WHERE at.organizationId = :orgId AND at.deleted = false")
    List<AssessmentTypeEntity> findAllActiveByOrg(@Param("orgId") Long orgId);

    @Query("SELECT at FROM AssessmentTypeEntity at WHERE at.organizationId = :orgId AND at.deleted = false " +
            "AND (LOWER(at.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(at.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<AssessmentTypeEntity> searchByKeyword(@Param("keyword") String keyword, @Param("orgId") Long orgId);

    @Modifying
    @Query("UPDATE AssessmentTypeEntity at SET at.deleted = true, at.deletedAt = CURRENT_TIMESTAMP WHERE at.id = :id")
    void softDeleteById(@Param("id") Long id);
}
