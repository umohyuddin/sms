package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteAcademicOfferingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteAcademicOfferingRepository extends JpaRepository<InstituteAcademicOfferingEntity, Long> {

    @Query("""
            SELECT a FROM InstituteAcademicOfferingEntity a
            WHERE a.id = :id
            """)
    Optional<InstituteAcademicOfferingEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT a FROM InstituteAcademicOfferingEntity a
            """)
    List<InstituteAcademicOfferingEntity> findAllJpql();

    @Query("""
            SELECT a FROM InstituteAcademicOfferingEntity a
            WHERE a.institute.id = :instituteId
            """)
    List<InstituteAcademicOfferingEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT a FROM InstituteAcademicOfferingEntity a
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(a.educationLevel) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(a.curriculum) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(a.board) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteAcademicOfferingEntity> searchByKeyword(@Param("keyword") String keyword);
}
