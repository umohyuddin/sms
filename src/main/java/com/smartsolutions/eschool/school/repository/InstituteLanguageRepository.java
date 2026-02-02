package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteLanguageEntity;
import com.smartsolutions.eschool.school.model.InstituteLanguageId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteLanguageRepository extends JpaRepository<InstituteLanguageEntity, InstituteLanguageId> {

    @Query("""
            SELECT il FROM InstituteLanguageEntity il
            WHERE il.id.instituteId = :instituteId
              AND il.id.languageId = :languageId
            """)
    Optional<InstituteLanguageEntity> findByIdJpql(@Param("instituteId") Long instituteId, @Param("languageId") Long languageId);

    @Query("""
            SELECT il FROM InstituteLanguageEntity il
            WHERE il.institute.id = :instituteId
            """)
    Page<InstituteLanguageEntity> findByInstituteId(@Param("instituteId") Long instituteId, Pageable pageable);
}
