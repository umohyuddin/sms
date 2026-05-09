package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.TransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Long> {

    List<TransactionTypeEntity> findAllByOrganizationId(Long organizationId);

    Optional<TransactionTypeEntity> findByIdAndOrganizationId(Long id, Long organizationId);

    boolean existsByOrganizationIdAndCode(Long organizationId, String code);

    boolean existsByOrganizationIdAndCodeAndIdNot(Long organizationId, String code, Long id);

    @Modifying
    @Query("UPDATE TransactionTypeEntity t SET t.deleted = true, t.deletedAt = CURRENT_TIMESTAMP WHERE t.id = ?1 AND t.organizationId = ?2")
    int softDeleteByIdAndOrganizationId(Long id, Long organizationId);

    @Query("SELECT t FROM TransactionTypeEntity t WHERE t.organizationId = :organizationId AND " +
           "(LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<TransactionTypeEntity> searchByKeywordAndOrganizationId(String keyword, Long organizationId);
}
