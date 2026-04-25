package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteBoardMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteBoardMemberRepository extends JpaRepository<InstituteBoardMemberEntity, Long> {

    @Query("SELECT b FROM InstituteBoardMemberEntity b LEFT JOIN FETCH b.role r WHERE b.organizationId = :orgId AND b.deleted = false")
    List<InstituteBoardMemberEntity> findByOrganizationId(@Param("orgId") Long orgId);

    @Query("SELECT b FROM InstituteBoardMemberEntity b LEFT JOIN FETCH b.role r WHERE b.id = :id AND b.organizationId = :orgId AND b.deleted = false")
    Optional<InstituteBoardMemberEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("orgId") Long orgId);

    @Query("SELECT b FROM InstituteBoardMemberEntity b LEFT JOIN FETCH b.role r " +
           "WHERE b.organizationId = :orgId AND b.deleted = false " +
           "AND (LOWER(b.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.email) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<InstituteBoardMemberEntity> searchByKeyword(@Param("orgId") Long orgId, @Param("keyword") String keyword);
}
