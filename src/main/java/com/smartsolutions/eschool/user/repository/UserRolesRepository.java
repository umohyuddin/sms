package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserRolesEntity;
import com.smartsolutions.eschool.user.model.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, UserRoleId> {
    List<UserRolesEntity> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
