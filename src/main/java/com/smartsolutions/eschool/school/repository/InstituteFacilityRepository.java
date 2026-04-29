package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteFacilityRepository extends JpaRepository<InstituteFacilityEntity, Long> {

    /*
     * ===============================
     * Find by ID (with Facility Type)
     * ===============================
     */
    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN FETCH f.facilityType ft
                WHERE f.id = :id
                  AND f.institute.id = :instituteId
            """)
    Optional<InstituteFacilityEntity> findByIdAndInstituteIdJpql(@Param("id") Long id,
            @Param("instituteId") Long instituteId);

    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN FETCH f.facilityType ft
                WHERE f.institute.id = :instituteId
            """)
    List<InstituteFacilityEntity> findAllByInstituteIdJpql(@Param("instituteId") Long instituteId);

    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN FETCH f.facilityType ft
                WHERE f.institute.id = :instituteId
            """)
    List<InstituteFacilityEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN f.facilityType ft
                WHERE f.institute.id = :instituteId
                  AND (
                    :keyword IS NULL OR :keyword = ''
                    OR LOWER(ft.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(ft.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
                )
            """)
    List<InstituteFacilityEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
            @Param("instituteId") Long instituteId);

    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN f.facilityType ft
                WHERE (
                    :keyword IS NULL OR :keyword = ''
                    OR LOWER(ft.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(ft.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                    OR LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
                )
            """)
    List<InstituteFacilityEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("""
                SELECT f
                FROM InstituteFacilityEntity f
                JOIN f.facilityType ft
                WHERE f.institute.id = :instituteId
                  AND (
                      :keyword IS NULL OR :keyword = ''
                      OR LOWER(ft.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                      OR LOWER(ft.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                      OR LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
            """)
    List<InstituteFacilityEntity> searchByInstituteAndKeyword(
            @Param("instituteId") Long instituteId,
            @Param("keyword") String keyword);

    @Modifying
    @Query("""
                DELETE FROM InstituteFacilityEntity f
                WHERE f.institute.id = :instituteId
            """)
    void deleteByInstituteId(@Param("instituteId") Long instituteId);
}
