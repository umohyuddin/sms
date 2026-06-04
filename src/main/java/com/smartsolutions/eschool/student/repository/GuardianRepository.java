package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.GuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianEntity, Long> {

    @Query("SELECT g FROM GuardianEntity g WHERE g.organizationId = :organizationId")
    List<GuardianEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.isActive = true")
    List<GuardianEntity> findAllByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.isActive = false")
    List<GuardianEntity> findAllByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianEntity g WHERE g.id = :id AND g.organizationId = :organizationId")
    Optional<GuardianEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT g FROM GuardianEntity g WHERE (g.fullName LIKE %:keyword% OR g.cnic LIKE %:keyword% OR g.phone LIKE %:keyword%) AND g.organizationId = :organizationId")
    List<GuardianEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE GuardianEntity g SET g.deleted = true, g.deletedAt = CURRENT_TIMESTAMP "
            + "WHERE g.id = :id AND g.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianEntity g WHERE g.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.isActive = true")
    Long countByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(g) FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.isActive = false")
    Long countByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(g) > 0) FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.cnic = :cnic")
    boolean existsByOrganizationIdAndCnic(@Param("organizationId") Long organizationId, @Param("cnic") String cnic);

    @Query("SELECT (COUNT(g) > 0) FROM GuardianEntity g WHERE g.organizationId = :organizationId AND g.cnic = :cnic AND g.id <> :id")
    boolean existsByOrganizationIdAndCnicAndIdNot(@Param("organizationId") Long organizationId, @Param("cnic") String cnic, @Param("id") Long id);
}
