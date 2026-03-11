package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.EducationBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationBoardRepository extends JpaRepository<EducationBoardEntity, Long> {

    @Query("""
            SELECT e
            FROM EducationBoardEntity e
            WHERE e.id = :id
              AND e.deleted = false
            """)
    Optional<EducationBoardEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT e
            FROM EducationBoardEntity e
            WHERE e.isActive = true
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationBoardEntity> findAllActive();

    @Query("""
            SELECT e
            FROM EducationBoardEntity e
            WHERE e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationBoardEntity> findAllNotDeleted();

    @Query("""
            SELECT e
            FROM EducationBoardEntity e
            WHERE (LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) 
               OR LOWER(e.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationBoardEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE EducationBoardEntity e
            SET e.deleted = true,
                e.deletedAt = CURRENT_TIMESTAMP
            WHERE e.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(e) FROM EducationBoardEntity e WHERE e.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(e) FROM EducationBoardEntity e WHERE e.isActive = true AND e.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(e) FROM EducationBoardEntity e WHERE e.isActive = false AND e.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(e) > 0) FROM EducationBoardEntity e WHERE e.name = :name AND e.deleted = false")
    boolean existsByName(@Param("name") String name);

    @Query("SELECT (COUNT(e) > 0) FROM EducationBoardEntity e WHERE e.name = :name AND e.id <> :id AND e.deleted = false")
    boolean existsByNameAndIdNot(@Param("name") String name, @Param("id") Long id);
}
