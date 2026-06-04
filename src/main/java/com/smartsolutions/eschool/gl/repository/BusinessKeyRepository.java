package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.BusinessKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessKeyRepository extends JpaRepository<BusinessKeyEntity, Long> {

    List<BusinessKeyEntity> findAllByOrganizationId(Long organizationId);

    Optional<BusinessKeyEntity> findByIdAndOrganizationId(Long id, Long organizationId);

    boolean existsByOrganizationIdAndCode(Long organizationId, String code);

    boolean existsByOrganizationIdAndCodeAndIdNot(Long organizationId, String code, Long id);

    @Modifying
    @Query("UPDATE BusinessKeyEntity b SET b.deleted = true, b.deletedAt = CURRENT_TIMESTAMP WHERE b.id = ?1 AND b.organizationId = ?2")
    int softDeleteByIdAndOrganizationId(Long id, Long organizationId);

    @Query("SELECT b FROM BusinessKeyEntity b WHERE b.organizationId = :organizationId AND " +
           "(LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(b.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(b.module) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<BusinessKeyEntity> searchByKeywordAndOrganizationId(String keyword, Long organizationId);
}
