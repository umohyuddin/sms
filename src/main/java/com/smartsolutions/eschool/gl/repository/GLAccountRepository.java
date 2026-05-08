package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.GLAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GLAccountRepository extends JpaRepository<GLAccountEntity, Long> {
    Optional<GLAccountEntity> findByOrganizationIdAndAccountCode(Long organizationId, String accountCode);
    List<GLAccountEntity> findAllByOrganizationIdAndIsActiveTrue(Long organizationId);
    List<GLAccountEntity> findAllByOrganizationIdAndParentIdIsNull(Long organizationId);
}
