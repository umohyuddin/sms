package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentTermResultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTermResultRepository extends JpaRepository<StudentTermResultEntity, StudentTermResultId> {

    @Query("SELECT str FROM StudentTermResultEntity str WHERE str.id.studentId = :studentId " +
           "AND str.id.academicYearId = :academicYearId AND str.deleted = false")
    List<StudentTermResultEntity> findResultsByStudentAndYear(@Param("student_id") Long studentId, 
                                                            @Param("academic_year_id") Long academicYearId);

    @Modifying
    @Query("UPDATE StudentTermResultEntity str SET str.deleted = true, str.deletedAt = CURRENT_TIMESTAMP WHERE str.id = :id")
    void softDeleteById(@Param("id") StudentTermResultId id);
}
