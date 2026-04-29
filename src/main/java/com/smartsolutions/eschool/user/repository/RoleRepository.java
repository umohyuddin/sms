package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("""
            SELECT r FROM RoleEntity r
            WHERE r.organizationId = :organizationId
              AND r.deleted = false
            ORDER BY r.name ASC
            """)
    List<RoleEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("""
            SELECT r FROM RoleEntity r
            WHERE r.id = :id
              AND r.organizationId = :organizationId
              AND r.deleted = false
            """)
    Optional<RoleEntity> findByIdAndOrganizationId(@Param("id") Long id,
            @Param("organizationId") Long organizationId);

    @Query("""
            SELECT r FROM RoleEntity r
            WHERE r.organizationId = :organizationId
              AND r.deleted = false
              AND (LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            ORDER BY r.name ASC
            """)
    List<RoleEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword,
            @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE RoleEntity r SET r.deleted = true, r.deletedAt = CURRENT_TIMESTAMP "
            + "WHERE r.id = :id AND r.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.organizationId = :organizationId AND r.deleted = false")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.organizationId = :organizationId AND r.active = true AND r.deleted = false")
    Long countByOrganizationIdAndActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.organizationId = :organizationId AND r.active = false AND r.deleted = false")
    Long countByOrganizationIdAndActiveFalse(@Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(r) > 0) FROM RoleEntity r WHERE r.organizationId = :organizationId AND r.code = :code AND r.deleted = false")
    boolean existsByOrganizationIdAndCode(@Param("organizationId") Long organizationId,
            @Param("code") String code);

    @Query("SELECT (COUNT(r) > 0) FROM RoleEntity r WHERE r.organizationId = :organizationId AND r.code = :code AND r.id <> :id AND r.deleted = false")
    boolean existsByOrganizationIdAndCodeAndIdNot(@Param("organizationId") Long organizationId,
            @Param("code") String code, @Param("id") Long id);
}
