package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamMarksRepository extends JpaRepository<StudentExamMarksEntity, Long> {

    @Query("SELECT sem FROM StudentExamMarksEntity sem JOIN FETCH sem.student " +
           "WHERE sem.examSubject.id = :examSubjectId AND sem.deleted = false")
    List<StudentExamMarksEntity> findByExamSubjectId(@Param("examSubjectId") Long examSubjectId);

    @Query("SELECT sem FROM StudentExamMarksEntity sem " +
           "JOIN FETCH sem.student s " +
           "JOIN FETCH sem.examSubject es " +
           "JOIN FETCH es.subject subj " +
           "WHERE sem.student.id = :studentId " +
           "AND es.exam.id = :examId " +
           "AND sem.deleted = false")
    List<StudentExamMarksEntity> findByStudentIdAndExamId(@Param("studentId") Long studentId,
                                                           @Param("examId") Long examId);

    @Modifying
    @Query("UPDATE StudentExamMarksEntity sem SET sem.deleted = true, sem.deletedAt = CURRENT_TIMESTAMP WHERE sem.id = :id")
    void softDeleteById(@Param("id") Long id);
}
