package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.GLAccountMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GLAccountMappingRepository extends JpaRepository<GLAccountMappingEntity, Long> {

    @Query("SELECT m FROM GLAccountMappingEntity m " +
           "JOIN FETCH m.accountingModule " +
           "JOIN FETCH m.transactionType " +
           "JOIN FETCH m.businessKey " +
           "JOIN FETCH m.postingKey " +
           "JOIN FETCH m.glAccount " +
           "WHERE m.organizationId = :organizationId")
    List<GLAccountMappingEntity> findAllByOrganizationId(Long organizationId);

    @Query("SELECT m FROM GLAccountMappingEntity m " +
           "JOIN FETCH m.accountingModule " +
           "JOIN FETCH m.transactionType " +
           "JOIN FETCH m.businessKey " +
           "JOIN FETCH m.postingKey " +
           "JOIN FETCH m.glAccount " +
           "WHERE m.id = :id AND m.organizationId = :organizationId")
    Optional<GLAccountMappingEntity> findByIdAndOrganizationId(Long id, Long organizationId);

    @Modifying
    @Query("UPDATE GLAccountMappingEntity m SET m.deleted = true, m.deletedAt = CURRENT_TIMESTAMP WHERE m.id = ?1 AND m.organizationId = ?2")
    int softDeleteByIdAndOrganizationId(Long id, Long organizationId);

    @Query("SELECT m FROM GLAccountMappingEntity m " +
           "JOIN FETCH m.accountingModule " +
           "JOIN FETCH m.transactionType " +
           "JOIN FETCH m.businessKey " +
           "JOIN FETCH m.postingKey " +
           "JOIN FETCH m.glAccount " +
           "WHERE m.organizationId = :organizationId AND " +
           "(LOWER(m.accountingModule.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(m.transactionType.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(m.businessKey.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(m.glAccount.accountName) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<GLAccountMappingEntity> searchByKeywordAndOrganizationId(String keyword, Long organizationId);
}
