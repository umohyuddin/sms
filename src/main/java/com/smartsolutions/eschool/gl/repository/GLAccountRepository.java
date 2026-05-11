package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.GLAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GLAccountRepository extends JpaRepository<GLAccountEntity, Long> {

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE a.organizationId = :organizationId")
    List<GLAccountEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE a.id = :id AND a.organizationId = :organizationId")
    Optional<GLAccountEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE a.organizationId = :organizationId AND a.accountCode = :accountCode")
    Optional<GLAccountEntity> findByOrganizationIdAndAccountCode(@Param("organizationId") Long organizationId, @Param("accountCode") String accountCode);

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE a.organizationId = :organizationId AND a.isActive = true")
    List<GLAccountEntity> findAllByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE a.organizationId = :organizationId AND a.parent IS NULL")
    List<GLAccountEntity> findAllByOrganizationIdAndParentIdIsNull(@Param("organizationId") Long organizationId);

    @Query("SELECT a FROM GLAccountEntity a LEFT JOIN FETCH a.parent WHERE (a.accountName LIKE %:keyword% OR a.accountCode LIKE %:keyword%) AND a.organizationId = :organizationId")
    List<GLAccountEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE GLAccountEntity a SET a.deleted = true, a.deletedAt = CURRENT_TIMESTAMP WHERE a.id = :id AND a.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(a) > 0) FROM GLAccountEntity a WHERE a.organizationId = :organizationId AND a.accountCode = :accountCode")
    boolean existsByOrganizationIdAndAccountCode(@Param("organizationId") Long organizationId, @Param("accountCode") String accountCode);

    @Query("SELECT (COUNT(a) > 0) FROM GLAccountEntity a WHERE a.organizationId = :organizationId AND a.accountCode = :accountCode AND a.id <> :id")
    boolean existsByOrganizationIdAndAccountCodeAndIdNot(@Param("organizationId") Long organizationId, @Param("accountCode") String accountCode, @Param("id") Long id);

    @Query("SELECT COUNT(a) FROM GLAccountEntity a WHERE a.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(a) FROM GLAccountEntity a WHERE a.organizationId = :organizationId AND a.isActive = true")
    Long countByOrganizationIdAndActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(a) FROM GLAccountEntity a WHERE a.organizationId = :organizationId AND a.isActive = false")
    Long countByOrganizationIdAndActiveFalse(@Param("organizationId") Long organizationId);
}
