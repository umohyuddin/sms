package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserRolesEntity;
import com.smartsolutions.eschool.user.model.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, UserRoleId> {

    @Query("SELECT ur FROM UserRolesEntity ur WHERE ur.id.userId = :userId")
    List<UserRolesEntity> findByUserId(@Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE user_roles SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE user_id = :userId AND deleted = false", nativeQuery = true)
    void deleteByUserId(@Param("userId") Long userId);

    @Query("SELECT ur.id.roleId FROM UserRolesEntity ur WHERE ur.id.userId = :userId")
    Set<Long> findRoleIdsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM user_roles WHERE user_id = :userId AND role_id = :roleId AND deleted = true LIMIT 1", nativeQuery = true)
    Optional<UserRolesEntity> findDeletedByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Modifying
    @Query(value = "UPDATE user_roles SET deleted = false, deleted_at = null WHERE user_id = :userId AND role_id = :roleId", nativeQuery = true)
    void restoreRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
}