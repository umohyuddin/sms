package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserAccountDeactivationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountDeactivationLogRepository extends JpaRepository<UserAccountDeactivationLogEntity, Long> {

    List<UserAccountDeactivationLogEntity> findBySystemUserIdAndOrganizationId(Long systemUserId, Long organizationId);
}
