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
            """)
    Optional<InstituteSocialLinkEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            """)
    List<InstituteSocialLinkEntity> findAllJpql();

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            WHERE s.institute.id = :instituteId
            """)
    List<InstituteSocialLinkEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT s FROM InstituteSocialLinkEntity s
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(s.platform) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(s.url) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteSocialLinkEntity> searchByKeyword(@Param("keyword") String keyword);
}
