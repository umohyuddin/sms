package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentExamMarksId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamMarksRepository extends JpaRepository<StudentExamMarksEntity, StudentExamMarksId> {

    @Query("SELECT sem FROM StudentExamMarksEntity sem JOIN FETCH sem.student " +
           "WHERE sem.id.examSubjectId = :examSubjectId AND sem.deleted = false")
    List<StudentExamMarksEntity> findByExamSubjectId(@Param("examSubjectId") Long examSubjectId);

    @Modifying
    @Query("UPDATE StudentExamMarksEntity sem SET sem.deleted = true, sem.deletedAt = CURRENT_TIMESTAMP WHERE sem.id = :id")
    void softDeleteById(@Param("id") StudentExamMarksId id);
}
