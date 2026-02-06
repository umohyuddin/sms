package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    @Query("""
            SELECT p FROM PermissionEntity p
            WHERE p.organizationId = :organizationId
              AND (:keyword IS NULL OR :keyword = ''
                OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.module.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.module.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<PermissionEntity> searchByKeyword(@Param("organizationId") Long organizationId, @Param("keyword") String keyword);

    @Query("""
        SELECT p
        FROM PermissionEntity p
        WHERE p.organizationId = :organizationId
          AND p.deleted = false
          AND p.active = true
        ORDER BY p.name ASC
    """)
    List<PermissionEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    java.util.Optional<PermissionEntity> findByIdAndOrganizationId(Long id, Long organizationId);
}
