package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentExamAttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamAttendanceRepository extends JpaRepository<StudentExamAttendanceEntity, StudentExamAttendanceId> {

    @Query("SELECT sea FROM StudentExamAttendanceEntity sea JOIN FETCH sea.student " +
           "WHERE sea.id.examSubjectId = :examSubjectId AND sea.deleted = false")
    List<StudentExamAttendanceEntity> findByExamSubjectId(@Param("examSubjectId") Long examSubjectId);

    @Modifying
    @Query("UPDATE StudentExamAttendanceEntity sea SET sea.deleted = true, sea.deletedAt = CURRENT_TIMESTAMP WHERE sea.id = :id")
    void softDeleteById(@Param("id") StudentExamAttendanceId id);
}
