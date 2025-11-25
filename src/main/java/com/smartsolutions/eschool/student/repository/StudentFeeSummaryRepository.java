package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StudentFeeSummaryRepository extends JpaRepository<StudentFeeSummaryEntity, Long> {
    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "WHERE s.student.id = :studentId")
    Optional<StudentFeeSummaryEntity> findByStudentId(
            @Param("studentId") Long studentId
    );
}


