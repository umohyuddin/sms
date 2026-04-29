package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteProfileRepository extends JpaRepository<InstituteProfileEntity, Long> {

    @Query("""
            SELECT p FROM InstituteProfileEntity p
            WHERE p.id = :id
            """)
    Optional<InstituteProfileEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT p FROM InstituteProfileEntity p
            WHERE p.institute.id = :instituteId
            """)
    Optional<InstituteProfileEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT p FROM InstituteProfileEntity p
            WHERE (:keyword IS NULL OR :keyword = ''
                                OR p.description LIKE CONCAT('%', :keyword, '%')
                                OR p.mission LIKE CONCAT('%', :keyword, '%')
                                OR p.vision LIKE CONCAT('%', :keyword, '%')
                                OR p.values LIKE CONCAT('%', :keyword, '%')
                                OR p.aboutChairperson LIKE CONCAT('%', :keyword, '%')
                                OR LOWER(p.organizationEmail) LIKE CONCAT('%', LOWER(:keyword), '%'))
            """)
    List<InstituteProfileEntity> searchByKeyword(@Param("keyword") String keyword);
}
