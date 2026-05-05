package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserAccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountInfoRepository extends JpaRepository<UserAccountInfoEntity, Long> {

    Optional<UserAccountInfoEntity> findBySystemUserIdAndOrganizationId(Long systemUserId, Long organizationId);
}
