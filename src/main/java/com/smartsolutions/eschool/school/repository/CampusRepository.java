package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampusRepository extends JpaRepository<CampusEntity, Long> {

        @Query("SELECT c FROM CampusEntity c JOIN FETCH c.institute i JOIN FETCH i.country JOIN FETCH c.province JOIN FETCH c.city WHERE i.id = :instituteId")
        List<CampusEntity> findByInstituteId(@Param("instituteId") Long instituteId);

        @Query("SELECT c FROM CampusEntity c JOIN FETCH c.institute i JOIN FETCH i.country JOIN FETCH c.province JOIN FETCH c.city WHERE c.campusName LIKE %:campusName%")
        List<CampusEntity> findByCampusNameContaining(@Param("campusName") String campusName);

        @Modifying
        @Transactional
        @Query("UPDATE CampusEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP "
                        + "WHERE s.id = :id AND s.institute.id = :instituteId")
        int softDeleteByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Query("SELECT c FROM CampusEntity c JOIN FETCH c.institute i JOIN FETCH i.country JOIN FETCH c.province JOIN FETCH c.city WHERE (c.campusName LIKE %:keyword% OR c.campusCode LIKE %:keyword%) AND i.id = :instituteId")
        List<CampusEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT c FROM CampusEntity c JOIN FETCH c.institute i JOIN FETCH i.country JOIN FETCH c.province JOIN FETCH c.city WHERE c.id = :id AND i.id = :instituteId")
        Optional<CampusEntity> findByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(c) FROM CampusEntity c WHERE c.institute.id = :instituteId")
        Long countByInstituteId(@Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(c) FROM CampusEntity c WHERE c.institute.id = :instituteId AND c.active = true")
        Long countByInstituteIdAndActiveTrue(@Param("instituteId") Long instituteId);

        @Query("SELECT COUNT(c) FROM CampusEntity c WHERE c.institute.id = :instituteId AND c.active = false")
        Long countByInstituteIdAndActiveFalse(@Param("instituteId") Long instituteId);

        @Query("SELECT (COUNT(c) > 0) FROM CampusEntity c WHERE c.institute.id = :instituteId AND c.campusCode = :campusCode")
        boolean existsByInstituteIdAndCampusCode(@Param("instituteId") Long instituteId,
                        @Param("campusCode") String campusCode);

        @Query("SELECT (COUNT(c) > 0) FROM CampusEntity c WHERE c.institute.id = :instituteId AND c.campusCode = :campusCode AND c.id <> :id")
        boolean existsByInstituteIdAndCampusCodeAndIdNot(@Param("instituteId") Long instituteId,
                        @Param("campusCode") String campusCode, @Param("id") Long id);
}
