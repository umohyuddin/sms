package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.StudentAcademicHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAcademicHistoryRepository extends JpaRepository<StudentAcademicHistoryEntity, Long> {

    @Query("SELECT sah FROM StudentAcademicHistoryEntity sah WHERE sah.student.id = :studentId AND sah.deleted = false")
    List<StudentAcademicHistoryEntity> findByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Query("UPDATE StudentAcademicHistoryEntity sah SET sah.deleted = true, sah.deletedAt = CURRENT_TIMESTAMP WHERE sah.id = :id")
    void softDeleteById(@Param("id") Long id);
}
