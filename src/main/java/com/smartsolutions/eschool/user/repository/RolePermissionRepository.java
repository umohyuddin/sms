package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.RolePermissionEntity;
import com.smartsolutions.eschool.user.model.RolePermissionId;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, RolePermissionId> {

    @Query("""
            SELECT p FROM RolePermissionEntity rp
            JOIN rp.permission p
            JOIN FETCH p.module
            JOIN FETCH p.resource
            JOIN FETCH p.action
            WHERE rp.id.roleId = :roleId
            """)
    List<PermissionEntity> findPermissionsByRoleId(@Param("roleId") Long roleId);


    @Query("""
            SELECT rp FROM RolePermissionEntity rp
            JOIN FETCH rp.permission p
            JOIN FETCH p.module
            JOIN FETCH p.resource
            JOIN FETCH p.action
            WHERE rp.role.id = :roleId
            """)
    List<RolePermissionEntity> findByRoleIdWithAll(@Param("roleId") Long roleId);

    @Modifying
    @Query("DELETE FROM RolePermissionEntity rp WHERE rp.id.roleId = :roleId")
    void deleteByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT COUNT(rp) > 0 FROM RolePermissionEntity rp WHERE rp.id.roleId = :roleId AND rp.id.permissionId = :permissionId")
    boolean existsByRoleIdAndPermissionId(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    @Modifying
    @Query("DELETE FROM RolePermissionEntity rp WHERE rp.id.roleId = :roleId AND rp.id.permissionId = :permissionId")
    void deleteByRoleIdAndPermissionId(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
}
