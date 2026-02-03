package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("""
            SELECT r FROM RoleEntity r
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<RoleEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("""
        SELECT r
        FROM RoleEntity r
        WHERE r.organizationId = :organizationId
          AND r.deleted = false
          AND r.active = true
        ORDER BY r.name ASC
    """)
    List<RoleEntity> findByOrganizationId(@Param("organizationId") Long organizationId);
}
