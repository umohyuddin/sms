package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.master.StudentActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivityEntity, Long> {

    @Query("SELECT sa FROM StudentActivityEntity sa WHERE sa.student.id = :studentId AND sa.deleted = false")
    List<StudentActivityEntity> findByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Query("UPDATE StudentActivityEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id")
    void softDeleteById(@Param("id") Long id);
}
