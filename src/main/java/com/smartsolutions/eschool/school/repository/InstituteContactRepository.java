package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteContactRepository extends JpaRepository<InstituteContactEntity, Long> {

    // Fetch by ID (global, not recommended for multi-tenant, use scoped version)
    @Query("""
            SELECT c FROM InstituteContactEntity c
            WHERE c.id = :id
          """)
    Optional<InstituteContactEntity> findByIdJpql(@Param("id") Long id);

    // Fetch by ID and institute (multi-tenant safe)
    @Query("""
            SELECT c FROM InstituteContactEntity c
            JOIN FETCH c.institute
            JOIN FETCH c.role
            WHERE c.id = :id
              AND c.institute.id = :instituteId
          """)
    Optional<InstituteContactEntity> findByIdAndInstituteId(
            @Param("id") Long id,
            @Param("instituteId") Long instituteId
    );

    // Fetch all contacts for all institutes (use with caution, multi-tenant)
    @Query("""
            SELECT c FROM InstituteContactEntity c
            JOIN FETCH c.institute
            JOIN FETCH c.role
          """)
    List<InstituteContactEntity> findAllJpql();

    // Fetch all contacts for a specific institute (multi-tenant safe)
    @Query("""
            SELECT c FROM InstituteContactEntity c
            JOIN FETCH c.institute
            JOIN FETCH c.role
            WHERE c.institute.id = :instituteId
          """)
    List<InstituteContactEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    // Search contacts by keyword within a specific institute (multi-tenant safe)
    @Query("""
            SELECT c FROM InstituteContactEntity c
            JOIN FETCH c.institute
            JOIN FETCH c.role
            WHERE c.institute.id = :instituteId
              AND (
                :keyword IS NULL OR :keyword = ''
                OR LOWER(c.contactPersonName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.role.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :keyword, '%'))
              )
          """)
    List<InstituteContactEntity> searchByKeyword(
            @Param("instituteId") Long instituteId,
            @Param("keyword") String keyword
    );

    @Query("""
    SELECT c FROM InstituteContactEntity c
    JOIN FETCH c.institute
    JOIN FETCH c.role
    WHERE c.institute.id = :instituteId
      AND c.role.id = :roleId
""")
    List<InstituteContactEntity> findByInstituteAndRole(
            @Param("instituteId") Long instituteId,
            @Param("roleId") Long roleId
    );

    @Query("""
    SELECT COUNT(c) FROM InstituteContactEntity c
    WHERE c.institute.id = :instituteId
      AND c.isDeleted = false
""")
    Long countByInstitute(@Param("instituteId") Long instituteId);

    @Query("""
    SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END
    FROM InstituteContactEntity c
    WHERE c.institute.id = :instituteId
      AND LOWER(c.email) = LOWER(:email)
      AND c.isDeleted = false
""")
    Boolean existsByEmail(@Param("instituteId") Long instituteId, @Param("email") String email);

    @Query("""
    SELECT c FROM InstituteContactEntity c
    JOIN FETCH c.institute
    JOIN FETCH c.role
    WHERE c.institute.id = :instituteId
      AND c.updatedAt >= :since
""")
    List<InstituteContactEntity> findUpdatedSince(
            @Param("instituteId") Long instituteId,
            @Param("since") LocalDateTime since
    );

    @Query("""
    SELECT c FROM InstituteContactEntity c
    JOIN FETCH c.institute
    JOIN FETCH c.role
    WHERE c.institute.id = :instituteId
      AND c.role.id IN :roleIds
""")
    List<InstituteContactEntity> findByInstituteAndRoles(
            @Param("instituteId") Long instituteId,
            @Param("roleIds") List<Long> roleIds
    );

    @Query("""
    SELECT c FROM InstituteContactEntity c
    JOIN FETCH c.institute
    JOIN FETCH c.role
    WHERE c.institute.id = :instituteId
      AND c.isDeleted = true
""")
    List<InstituteContactEntity> findDeletedContacts(@Param("instituteId") Long instituteId);


    //Always include JOIN FETCH c.role and c.institute.id = :instituteId for multi-tenant safety.


    @Query("SELECT c FROM InstituteContactEntity c JOIN FETCH c.role WHERE c.id = :contactId AND c.institute.id = :instituteId")
    Optional<InstituteContactEntity> findByIdAndInstituteIdWithRole(@Param("contactId") Long contactId,
                                                                    @Param("instituteId") Long instituteId);

}