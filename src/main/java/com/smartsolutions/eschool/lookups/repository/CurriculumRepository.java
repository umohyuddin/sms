package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CurriculumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurriculumRepository extends JpaRepository<CurriculumEntity, Long> {

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE c.id = :id
              AND c.deleted = false
            """)
    Optional<CurriculumEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE c.isActive = true
              AND c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurriculumEntity> findAllActive();

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurriculumEntity> findAllNotDeleted();

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE (LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(c.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurriculumEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE CurriculumEntity c
            SET c.deleted = true,
                c.deletedAt = CURRENT_TIMESTAMP
            WHERE c.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(c) FROM CurriculumEntity c WHERE c.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(c) FROM CurriculumEntity c WHERE c.isActive = true AND c.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(c) FROM CurriculumEntity c WHERE c.isActive = false AND c.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(c) > 0) FROM CurriculumEntity c WHERE c.code = :code AND c.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(c) > 0) FROM CurriculumEntity c WHERE c.code = :code AND c.id <> :id AND c.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
