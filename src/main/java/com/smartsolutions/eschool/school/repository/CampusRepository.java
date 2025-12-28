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
    Optional<CampusEntity> findByIdAndDeletedFalse(Long id);

    List<CampusEntity> findByDeletedFalse();

    List<CampusEntity> findByInstituteIdAndDeletedFalse(Long instituteId);

    // Find all campuses by institute ID
    List<CampusEntity> findByInstituteId(Long instituteId);

    // Find a campus by its name WHERE campus_name LIKE %?%
    List<CampusEntity> findByCampusNameContainingAndDeletedFalse(String campusName);

    @Modifying
    @Transactional
    @Query("UPDATE CampusEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " + "WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);

    Long id(Long id);


    @Query("""
            SELECT c FROM CampusEntity c WHERE (c.campusName LIKE %:keyword% OR c.campusCode LIKE %:keyword%) AND c.deleted = false""")
    List<CampusEntity> searchByKeyword(@Param("keyword") String keyword);


    @Query("SELECT COUNT(c) FROM CampusEntity c WHERE c.institute.id = :instituteId AND c.deleted = false")
    Long countByInstituteId(@Param("instituteId") Long instituteId);
}