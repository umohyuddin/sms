package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteSocialLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteSocialLinkRepository extends JpaRepository<InstituteSocialLinkEntity, Long> {

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            WHERE s.id = :id
              AND s.institute.id = :instituteId
            """)
    Optional<InstituteSocialLinkEntity> findByIdAndInstituteId(@Param("id") Long id,
            @Param("instituteId") Long instituteId);

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            WHERE s.institute.id = :instituteId
            """)
    List<InstituteSocialLinkEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            WHERE s.institute.id = :instituteId
                    AND (:keyword IS NULL OR :keyword = ''
                            OR LOWER(s.platform) LIKE LOWER(CONCAT('%', :keyword, '%'))
                            OR LOWER(s.url) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteSocialLinkEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
            @Param("instituteId") Long instituteId);

    // For each institute, it enforces a 1-to-1 relationship between a Platform name
    // and a URL.
    @Query("""
            SELECT COUNT(s) > 0 FROM InstituteSocialLinkEntity s
            WHERE s.institute.id = :instituteId
              AND (s.platform = :platform OR s.url = :url)
            """)
    boolean existsByInstituteIdAndPlatformOrUrl(@Param("instituteId") Long instituteId,
            @Param("platform") String platform,
            @Param("url") String url);

    @Query("""
            SELECT COUNT(s) > 0 FROM InstituteSocialLinkEntity s
            WHERE s.institute.id = :instituteId
              AND s.id != :id
              AND (s.platform = :platform OR s.url = :url)
            """)
    boolean existsByInstituteIdAndPlatformOrUrlAndIdNot(@Param("instituteId") Long instituteId,
            @Param("platform") String platform,
            @Param("url") String url,
            @Param("id") Long id);

    @Query("""
            SELECT COUNT(s) > 0 FROM InstituteSocialLinkEntity s
            WHERE s.id = :id
              AND s.institute.id = :instituteId
            """)
    boolean existsByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);
}
