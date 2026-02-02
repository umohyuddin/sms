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
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(p.permissionName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.module) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<PermissionEntity> searchByKeyword(@Param("keyword") String keyword);
}
