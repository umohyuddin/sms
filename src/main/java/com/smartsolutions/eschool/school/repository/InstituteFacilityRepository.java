package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteFacilityRepository extends JpaRepository<InstituteFacilityEntity, Long> {

    @Query("""
            SELECT f FROM InstituteFacilityEntity f
            WHERE f.id = :id
            """)
    Optional<InstituteFacilityEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT f FROM InstituteFacilityEntity f
            """)
    List<InstituteFacilityEntity> findAllJpql();

    @Query("""
            SELECT f FROM InstituteFacilityEntity f
            WHERE f.institute.id = :instituteId
            """)
    List<InstituteFacilityEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT f FROM InstituteFacilityEntity f
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(f.facilityType) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteFacilityEntity> searchByKeyword(@Param("keyword") String keyword);
}
