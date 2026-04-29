package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.GuardianRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuardianRelationRepository extends JpaRepository<GuardianRelationEntity, Long> {

    @Query("SELECT g FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId")
    List<GuardianRelationEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.isActive = true")
    List<GuardianRelationEntity> findAllByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.isActive = false")
    List<GuardianRelationEntity> findAllByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianRelationEntity g WHERE g.id = :id AND g.organizationId = :organizationId")
    Optional<GuardianRelationEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianRelationEntity g WHERE (g.name LIKE %:keyword% OR g.code LIKE %:keyword%) AND g.organizationId = :organizationId")
    List<GuardianRelationEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE GuardianRelationEntity g SET g.deleted = true, g.deletedAt = CURRENT_TIMESTAMP "
            + "WHERE g.id = :id AND g.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.isActive = true")
    Long countByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.isActive = false")
    Long countByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(g) > 0) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.code = :code")
    boolean existsByOrganizationIdAndCode(@Param("organizationId") Long organizationId, @Param("code") String code);

    @Query("SELECT (COUNT(g) > 0) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.code = :code AND g.id <> :id")
    boolean existsByOrganizationIdAndCodeAndIdNot(@Param("organizationId") Long organizationId, @Param("code") String code, @Param("id") Long id);
    
    @Query("SELECT (COUNT(g) > 0) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.name = :name")
    boolean existsByOrganizationIdAndName(@Param("organizationId") Long organizationId, @Param("name") String name);

    @Query("SELECT (COUNT(g) > 0) FROM GuardianRelationEntity g WHERE g.organizationId = :organizationId AND g.name = :name AND g.id <> :id")
    boolean existsByOrganizationIdAndNameAndIdNot(@Param("organizationId") Long organizationId, @Param("name") String name, @Param("id") Long id);
}
