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
                        WHERE c.institute.id = :instituteId AND s.deleted = false
                        """)
        List<SectionEntity> findByInstituteIdAndDeletedFalse(@Param("instituteId") Long instituteId);

        @Query("SELECT s FROM SectionEntity s " +
                        "LEFT JOIN FETCH s.standard st " +
                        "LEFT JOIN FETCH st.campus c " +
                        "WHERE st.id = :id AND c.institute.id = :instituteId AND s.deleted = false")
        List<SectionEntity> findByStandardIdAndInstituteIdAndDeletedFalse(@Param("id") Long id,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT s FROM SectionEntity s " +
                        "LEFT JOIN FETCH s.standard st " +
                        "LEFT JOIN FETCH st.campus c " +
                        "WHERE s.id = :id AND c.institute.id = :instituteId AND s.deleted = false")
        Optional<SectionEntity> findByIdAndInstituteIdAndDeletedFalse(@Param("id") Long id,
                        @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE s.id = :id AND s.standard.campus.institute.id = :instituteId")
        int softDeleteByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE s.standard.id = :standardId AND s.standard.campus.institute.id = :instituteId")
        int softDeleteByStandardIdAndInstituteId(@Param("standardId") Long standardId,
                        @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("UPDATE SectionEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE s.standard.campus.institute.id = :instituteId")
        int softDeleteByInstituteId(@Param("instituteId") Long instituteId);

        // Search by sectionName or sectionCode with instituteId
        @Query("SELECT sec FROM SectionEntity sec " +
                        "JOIN sec.standard st " +
                        "JOIN st.campus c " +
                        "WHERE (sec.sectionName LIKE %:keyword% OR sec.sectionCode LIKE %:keyword%) " +
                        "AND c.institute.id = :instituteId " +
                        "AND sec.deleted = false")
        List<SectionEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("""
                        SELECT s FROM SectionEntity s
                        JOIN FETCH s.standard st
                        JOIN FETCH st.campus c
                        WHERE (:campusId IS NULL OR c.id = :campusId)
                          AND (:standardId IS NULL OR st.id = :standardId)
                          AND c.institute.id = :instituteId
                          AND (
                                :search IS NULL
                                OR LOWER(s.sectionName) LIKE LOWER(CONCAT('%', :search, '%'))
                                OR LOWER(s.sectionCode) LIKE LOWER(CONCAT('%', :search, '%'))
                              )
                          AND s.deleted = false
                        ORDER BY s.sectionName ASC
                        """)
        List<SectionEntity> searchSectionsWithOrg(
                        @Param("campusId") Long campusId,
                        @Param("standardId") Long standardId,
                        @Param("instituteId") Long instituteId,
                        @Param("search") String search);
}
