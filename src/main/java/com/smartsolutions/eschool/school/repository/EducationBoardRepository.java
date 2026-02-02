package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.EducationBoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationBoardRepository extends JpaRepository<EducationBoardEntity, Long> {

    @Query("""
            SELECT e FROM EducationBoardEntity e
            WHERE e.id = :id
            """)
    Optional<EducationBoardEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT e FROM EducationBoardEntity e
            """)
    Page<EducationBoardEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT e FROM EducationBoardEntity e
            WHERE e.isActive = true
            """)
    List<EducationBoardEntity> findAllActive();

    @Query("""
            SELECT e FROM EducationBoardEntity e
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(e.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(e.countryCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(e.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<EducationBoardEntity> searchByKeyword(@Param("keyword") String keyword);
}
