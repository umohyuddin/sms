package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.BoardMemberRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardMemberRoleRepository extends JpaRepository<BoardMemberRoleEntity, Long> {

    @Query("SELECT b FROM BoardMemberRoleEntity b WHERE b.organizationId = :orgId AND b.deleted = false")
    List<BoardMemberRoleEntity> findByOrganizationId(@Param("orgId") Long orgId);

    @Query("SELECT b FROM BoardMemberRoleEntity b WHERE b.id = :id AND b.organizationId = :orgId AND b.deleted = false")
    Optional<BoardMemberRoleEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("orgId") Long orgId);

    @Query("SELECT b FROM BoardMemberRoleEntity b " +
           "WHERE b.organizationId = :orgId AND b.deleted = false " +
           "AND (LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<BoardMemberRoleEntity> searchByKeyword(@Param("orgId") Long orgId, @Param("keyword") String keyword);

    boolean existsByCodeAndOrganizationIdAndDeletedFalse(String code, Long orgId);
}
