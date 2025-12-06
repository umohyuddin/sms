package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {
    @Query("""
            SELECT s FROM SectionEntity s
            LEFT JOIN FETCH s.standard st
            LEFT JOIN FETCH st.campus c
            WHERE s.deleted = false
            """)
    List<SectionEntity> findByDeletedFalse();

    @Query("SELECT s FROM SectionEntity s " +
            "LEFT JOIN FETCH s.standard st " +
            "LEFT JOIN FETCH st.campus c " +
            "WHERE st.id = :id AND s.deleted = false")
    List<SectionEntity> findByStandardIdAndDeletedFalse(@Param("id") Long id);

    @Query("SELECT s FROM SectionEntity s " +
            "LEFT JOIN FETCH s.standard st " +
            "LEFT JOIN FETCH st.campus c " +
            "WHERE s.id = :id AND s.deleted = false")
    Optional<SectionEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
            "WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
            "WHERE s.standard.id = :standardId")
    int softDeleteByStandardId(@Param("standardId") Long standardId);


    @Modifying
    @Transactional
    @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP")
    int softDeleteAll();

    // Search by sectionName or sectionCode
    @Query("SELECT sec FROM SectionEntity sec " +
            "WHERE (sec.sectionName LIKE %:keyword% OR sec.sectionCode LIKE %:keyword%) " +
            "AND sec.deleted = false")
    List<SectionEntity> searchByKeyword(@Param("keyword") String keyword);


    @Query("""
            SELECT s FROM SectionEntity s
            JOIN FETCH s.standard st
            JOIN FETCH st.campus c
            WHERE (:campusId IS NULL OR c.id = :campusId)
              AND (:standardId IS NULL OR st.id = :standardId)
              AND (
                    :search IS NULL
                    OR LOWER(s.sectionName) LIKE LOWER(CONCAT('%', :search, '%'))
                    OR LOWER(s.sectionCode) LIKE LOWER(CONCAT('%', :search, '%'))
                  )
              AND s.deleted = false
            ORDER BY s.sectionName ASC
            """)
    List<SectionEntity> searchSections(
            @Param("campusId") Long campusId,
            @Param("standardId") Long standardId,
            @Param("search") String search
    );
}

