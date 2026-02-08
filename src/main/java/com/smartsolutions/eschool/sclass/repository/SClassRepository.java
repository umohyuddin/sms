package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SClassRepository extends JpaRepository<SClassEntity, Integer> {

    @Query("SELECT s FROM SClassEntity s WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SClassEntity> searchByKeyword(@Param("keyword") String keyword);

    // Placeholder methods for what was in Dao if they are still needed
    // In a real scenario, these would involve joins with other tables
    
    @Query(value = "SELECT * FROM sclass s WHERE s.id IN (SELECT class_id FROM teacher_subject_assignment WHERE teacher_id = :teacherId)", nativeQuery = true)
    List<SClassEntity> findByTeacherId(@Param("teacherId") Long teacherId);

    @Query(value = "SELECT * FROM sclass s WHERE s.id IN (SELECT class_id FROM student_class_assignment WHERE student_id = :studentId)", nativeQuery = true)
    List<SClassEntity> findByStudentId(@Param("studentId") Long studentId);

    @Query(value = "SELECT * FROM sclass s WHERE s.id IN (SELECT class_id FROM course_class_assignment WHERE course_id = :courseId)", nativeQuery = true)
    List<SClassEntity> findByCourseId(@Param("courseId") Long courseId);
}
