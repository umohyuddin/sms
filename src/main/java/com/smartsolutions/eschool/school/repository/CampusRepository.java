package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}