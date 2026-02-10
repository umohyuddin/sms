package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import com.smartsolutions.eschool.academic.entity.embeddable.TeacherSubjectAssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherSubjectAssignmentRepository extends JpaRepository<TeacherSubjectAssignmentEntity, TeacherSubjectAssignmentId> {

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa JOIN FETCH tsa.teacher JOIN FETCH tsa.subject JOIN FETCH tsa.standard JOIN FETCH tsa.section " +
           "WHERE tsa.id.employeeId = :employeeId AND tsa.deleted = false AND tsa.active = true")
    List<TeacherSubjectAssignmentEntity> findByTeacherId(@Param("employeeId") Long employeeId);

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa JOIN FETCH tsa.teacher JOIN FETCH tsa.subject " +
           "WHERE tsa.id.standardId = :standardId AND tsa.id.sectionId = :sectionId AND tsa.id.academicYearId = :academicYearId AND tsa.deleted = false")
    List<TeacherSubjectAssignmentEntity> findByStandardSectionAndAcademicYear(
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("academicYearId") Long academicYearId);

    @Modifying
    @Query("UPDATE TeacherSubjectAssignmentEntity tsa SET tsa.deleted = true, tsa.deletedAt = CURRENT_TIMESTAMP WHERE tsa.id = :id")
    void softDeleteById(@Param("id") TeacherSubjectAssignmentId id);
}
