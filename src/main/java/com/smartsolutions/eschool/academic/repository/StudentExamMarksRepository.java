package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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

    @Query("""
       SELECT s FROM StudentExamMarksEntity s
       JOIN FETCH s.student
       JOIN FETCH s.examSubject
       """)
     List<StudentExamMarksEntity> findStudentAll();


@Query("""
    SELECT sem FROM StudentExamMarksEntity sem
    JOIN FETCH sem.student st
    JOIN FETCH sem.examSubject es
    JOIN FETCH es.exam e
    JOIN FETCH e.section sec
    JOIN FETCH sec.standard std
    JOIN FETCH std.campus c
    WHERE sem.deleted = false
    AND (:campusId IS NULL OR c.id = :campusId)
    AND (:standardId IS NULL OR std.id = :standardId)
    AND (:sectionId IS NULL OR sec.id = :sectionId)
    AND (:examId IS NULL OR e.id = :examId)
    AND (:keyword IS NULL OR LOWER(st.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(st.studentCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
    """)
List<StudentExamMarksEntity> searchMarks(
        @Param("campusId") Long campusId,
        @Param("standardId") Long standardId,
        @Param("sectionId") Long sectionId,
        @Param("examId") Long examId,
        @Param("keyword") String keyword);

}
