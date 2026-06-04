package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.AccountingModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountingModuleRepository extends JpaRepository<AccountingModuleEntity, Long> {

    List<AccountingModuleEntity> findAllByOrganizationId(Long organizationId);

    Optional<AccountingModuleEntity> findByIdAndOrganizationId(Long id, Long organizationId);

    boolean existsByOrganizationIdAndCode(Long organizationId, String code);

    boolean existsByOrganizationIdAndCodeAndIdNot(Long organizationId, String code, Long id);

    @Modifying
    @Query("UPDATE AccountingModuleEntity a SET a.deleted = true, a.deletedAt = CURRENT_TIMESTAMP WHERE a.id = ?1 AND a.organizationId = ?2")
    int softDeleteByIdAndOrganizationId(Long id, Long organizationId);

    @Query("SELECT a FROM AccountingModuleEntity a WHERE a.organizationId = :organizationId AND " +
           "(LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(a.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<AccountingModuleEntity> searchByKeywordAndOrganizationId(String keyword, Long organizationId);
}
