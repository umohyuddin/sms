package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteAccreditationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteAccreditationRepository extends JpaRepository<InstituteAccreditationEntity, Long> {

    @Query("""
            SELECT a FROM InstituteAccreditationEntity a
            WHERE a.id = :id
            """)
    Optional<InstituteAccreditationEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT a FROM InstituteAccreditationEntity a
            """)
    Page<InstituteAccreditationEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT a FROM InstituteAccreditationEntity a
            WHERE a.institute.id = :instituteId
            """)
    Page<InstituteAccreditationEntity> findByInstituteId(@Param("instituteId") Long instituteId, Pageable pageable);

    @Query("""
            SELECT a FROM InstituteAccreditationEntity a
            WHERE a.isActive = true
            """)
    List<InstituteAccreditationEntity> findAllActive();

    @Query("""
            SELECT a FROM InstituteAccreditationEntity a
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(a.authorityName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(a.licenseNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteAccreditationEntity> searchByKeyword(@Param("keyword") String keyword);
}
