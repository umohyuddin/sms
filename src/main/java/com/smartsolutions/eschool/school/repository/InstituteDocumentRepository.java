package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteDocumentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteDocumentRepository extends JpaRepository<InstituteDocumentEntity, Long> {

    @Query("""
            SELECT d FROM InstituteDocumentEntity d
            WHERE d.id = :id
            """)
    Optional<InstituteDocumentEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT d FROM InstituteDocumentEntity d
            """)
    Page<InstituteDocumentEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT d FROM InstituteDocumentEntity d
            WHERE d.institute.id = :instituteId
            """)
    Page<InstituteDocumentEntity> findByInstituteId(@Param("instituteId") Long instituteId, Pageable pageable);

    @Query("""
            SELECT d FROM InstituteDocumentEntity d
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(d.documentType) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(d.fileName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(d.fileUrl) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteDocumentEntity> searchByKeyword(@Param("keyword") String keyword);
}
