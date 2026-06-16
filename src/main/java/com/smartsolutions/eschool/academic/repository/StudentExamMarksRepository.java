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

    @Query("SELECT sem FROM StudentExamMarksEntity sem " +
           "JOIN FETCH sem.student s " +
           "JOIN FETCH sem.examSubject es " +
           "JOIN FETCH es.exam e " +
           "JOIN FETCH e.examTerm et " +
           "WHERE sem.id = :id AND sem.deleted = false")
    java.util.Optional<StudentExamMarksEntity> findByIdWithRelations(@Param("id") Long id);

    @Query("SELECT sem FROM StudentExamMarksEntity sem " +
           "WHERE sem.student.id = :studentId AND sem.examSubject.id = :examSubjectId AND sem.deleted = false")
    java.util.Optional<StudentExamMarksEntity> findByStudentIdAndExamSubjectId(
            @Param("studentId") Long studentId, @Param("examSubjectId") Long examSubjectId);

    /**
     * Finds a mark record by studentId + examSubjectId regardless of soft-delete status.
     * Used in upsert logic to prevent duplicate-key constraint violations when a record was
     * previously soft-deleted and the same student/subject combination is submitted again.
     */
    @Query(value = "SELECT * FROM student_exam_marks " +
            "WHERE student_id = :studentId " +
            "AND exam_subject_id = :examSubjectId " +
            "LIMIT 1",
            nativeQuery = true)
    java.util.Optional<StudentExamMarksEntity> findByStudentIdAndExamSubjectIdIncludeDeleted(
            @Param("studentId") Long studentId, @Param("examSubjectId") Long examSubjectId);

    @Query("""
    SELECT sem FROM StudentExamMarksEntity sem
    JOIN FETCH sem.student st
    JOIN FETCH sem.examSubject es
    JOIN FETCH es.exam e
    WHERE e.id       = :examId
    AND st.campus.id = :campusId
    AND sem.deleted  = false
""")
    List<StudentExamMarksEntity> findMarksForPromotion(
            @Param("examId")   Long examId,
            @Param("campusId") Long campusId
    );


    @Query("""
        SELECT sem FROM StudentExamMarksEntity sem
        JOIN FETCH sem.student st
        JOIN FETCH sem.examSubject es
        JOIN FETCH es.subject subj
        LEFT JOIN FETCH st.campus c
        LEFT JOIN FETCH st.standard std
        LEFT JOIN FETCH st.section sec
        WHERE sem.deleted = false
        AND (:studentId IS NULL OR st.id = :studentId)
        AND (:campusId IS NULL OR c.id = :campusId)
        AND (:standardId IS NULL OR std.id = :standardId)
        AND (:sectionId IS NULL OR sec.id = :sectionId)
        """)
    List<StudentExamMarksEntity> findMarksByFilters(
            @Param("studentId") Long studentId,
            @Param("campusId") Long campusId,
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId);
}

