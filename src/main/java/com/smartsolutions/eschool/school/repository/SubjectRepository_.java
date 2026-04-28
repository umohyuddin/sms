package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.AcademicSubjectEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository_ extends JpaRepository<AcademicSubjectEntity, Long> {

    Optional<AcademicSubjectEntity> findByIdAndDeletedFalse(Long id);

    List<AcademicSubjectEntity> findByDeletedFalse();

    List<AcademicSubjectEntity> findByNameContainingAndDeletedFalse(String name);

    List<AcademicSubjectEntity> findByCodeContainingAndDeletedFalse(String code);

    @Modifying
    @Transactional
    @Query("UPDATE AcademicSubjectEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT s FROM AcademicSubjectEntity s WHERE (s.name LIKE %:keyword% OR s.code LIKE %:keyword%) AND s.deleted = false")
    List<AcademicSubjectEntity> searchByKeyword(@Param("keyword") String keyword);
}
