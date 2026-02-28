package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteAccreditationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
                          AND a.deleted = false
                        """)
        Optional<InstituteAccreditationEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE a.deleted = false
                        """)
        List<InstituteAccreditationEntity> findAllActiveJpql();

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE a.institute.id = :instituteId
                          AND a.deleted = false
                        """)
        List<InstituteAccreditationEntity> findByInstituteIdAndDeletedFalse(@Param("instituteId") Long instituteId);

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE a.isActive = true
                          AND a.deleted = false
                        """)
        List<InstituteAccreditationEntity> findAllActiveAndNotDeleted();

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE (a.deleted = false)
                          AND (:keyword IS NULL OR :keyword = ''
                            OR LOWER(a.authorityName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                            OR LOWER(a.licenseNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))
                        """)
        List<InstituteAccreditationEntity> searchByKeyword(@Param("keyword") String keyword);

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE a.id = :id
                          AND a.institute.id = :instituteId
                          AND a.deleted = false
                        """)
        Optional<InstituteAccreditationEntity> findByIdAndInstituteIdAndDeletedFalse(@Param("id") Long id,
                        @Param("instituteId") Long instituteId);

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE a.isActive = true
                          AND a.institute.id = :instituteId
                          AND a.deleted = false
                        """)
        List<InstituteAccreditationEntity> findAllActiveByInstituteId(@Param("instituteId") Long instituteId);

        @Query("""
                        SELECT a FROM InstituteAccreditationEntity a
                        WHERE (a.deleted = false)
                          AND a.institute.id = :instituteId
                          AND (:keyword IS NULL OR :keyword = ''
                            OR LOWER(a.authorityName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                            OR LOWER(a.licenseNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))
                        """)
        List<InstituteAccreditationEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("""
                        SELECT COUNT(a) > 0 FROM InstituteAccreditationEntity a
                        WHERE a.institute.id = :instituteId
                          AND a.licenseNumber = :licenseNumber
                          AND a.deleted = false
                        """)
        boolean existsByInstituteIdAndLicenseNumber(@Param("instituteId") Long instituteId,
                        @Param("licenseNumber") String licenseNumber);

        @Query("""
                        SELECT COUNT(a) > 0 FROM InstituteAccreditationEntity a
                        WHERE a.institute.id = :instituteId
                          AND a.licenseNumber = :licenseNumber
                          AND a.id != :id
                          AND a.deleted = false
                        """)
        boolean existsByInstituteIdAndLicenseNumberAndIdNot(@Param("instituteId") Long instituteId,
                        @Param("licenseNumber") String licenseNumber, @Param("id") Long id);

        @Query("""
                        SELECT COUNT(a) > 0 FROM InstituteAccreditationEntity a
                        WHERE a.id = :id
                          AND a.institute.id = :instituteId
                          AND a.deleted = false
                        """)
        boolean existsByIdAndInstituteIdAndDeletedFalse(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("""
                        UPDATE InstituteAccreditationEntity a
                        SET a.deleted = true,
                            a.deletedAt = CURRENT_TIMESTAMP
                        WHERE a.id = :id
                        """)
        int softDeleteById(@Param("id") Long id);
}
