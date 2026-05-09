package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.PostingKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostingKeyRepository extends JpaRepository<PostingKeyEntity, Long> {

    List<PostingKeyEntity> findAllByOrganizationId(Long organizationId);

    Optional<PostingKeyEntity> findByIdAndOrganizationId(Long id, Long organizationId);

    boolean existsByOrganizationIdAndCode(Long organizationId, String code);

    boolean existsByOrganizationIdAndCodeAndIdNot(Long organizationId, String code, Long id);

    @Modifying
    @Query("UPDATE PostingKeyEntity p SET p.deleted = true, p.deletedAt = CURRENT_TIMESTAMP WHERE p.id = ?1 AND p.organizationId = ?2")
    int softDeleteByIdAndOrganizationId(Long id, Long organizationId);

    @Query("SELECT p FROM PostingKeyEntity p WHERE p.organizationId = :organizationId AND " +
           "(LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<PostingKeyEntity> searchByKeywordAndOrganizationId(String keyword, Long organizationId);
}
