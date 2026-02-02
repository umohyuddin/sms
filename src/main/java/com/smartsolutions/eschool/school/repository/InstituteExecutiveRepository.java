package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteExecutiveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteExecutiveRepository extends JpaRepository<InstituteExecutiveEntity, Long> {

    @Query("""
            SELECT e FROM InstituteExecutiveEntity e
            WHERE e.id = :id
            """)
    Optional<InstituteExecutiveEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT e FROM InstituteExecutiveEntity e
            """)
    Page<InstituteExecutiveEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT e FROM InstituteExecutiveEntity e
            WHERE e.institute.id = :instituteId
            """)
    Page<InstituteExecutiveEntity> findByInstituteId(@Param("instituteId") Long instituteId, Pageable pageable);

    @Query("""
            SELECT e FROM InstituteExecutiveEntity e
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(e.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(e.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteExecutiveEntity> searchByKeyword(@Param("keyword") String keyword);
}
