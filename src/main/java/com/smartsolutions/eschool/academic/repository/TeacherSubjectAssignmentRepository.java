package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherSubjectAssignmentRepository extends JpaRepository<TeacherSubjectAssignmentEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(tsa) > 0 THEN true ELSE false END FROM TeacherSubjectAssignmentEntity tsa " +
           "WHERE tsa.teacher.id = :employeeId AND tsa.standard.id = :standardId " +
           "AND tsa.section.id = :sectionId AND tsa.subject.id = :subjectId " +
           "AND tsa.academicYear.id = :academicYearId AND tsa.deleted = false")
    boolean existsByTeacherAndAssignment(@Param("employeeId") Long employeeId,
                                         @Param("standardId") Long standardId,
                                         @Param("sectionId") Long sectionId,
                                         @Param("subjectId") Long subjectId,
                                         @Param("academicYearId") Long academicYearId);

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa " +
           "JOIN FETCH tsa.teacher " +
           "JOIN FETCH tsa.subject " +
           "JOIN FETCH tsa.standard " +
           "JOIN FETCH tsa.section " +
           "JOIN FETCH tsa.academicYear " +
           "WHERE tsa.id = :id AND tsa.deleted = false")
    Optional<TeacherSubjectAssignmentEntity> findByIdWithDetails(@Param("id") Long id);

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa JOIN FETCH tsa.teacher JOIN FETCH tsa.subject JOIN FETCH tsa.standard JOIN FETCH tsa.section " +
           "WHERE tsa.teacher.id = :employeeId AND tsa.deleted = false AND tsa.active = true")
    List<TeacherSubjectAssignmentEntity> findByTeacherId(@Param("employeeId") Long employeeId);

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa JOIN FETCH tsa.teacher JOIN FETCH tsa.subject " +
           "WHERE tsa.standard.id = :standardId AND tsa.section.id = :sectionId AND tsa.academicYear.id = :academicYearId AND tsa.deleted = false")
    List<TeacherSubjectAssignmentEntity> findByStandardSectionAndAcademicYear(
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("academicYearId") Long academicYearId);

    @Query("SELECT tsa FROM TeacherSubjectAssignmentEntity tsa WHERE tsa.teacher.id = :employeeId AND tsa.standard.id = :standardId " +
           "AND tsa.section.id = :sectionId AND tsa.subject.id = :subjectId AND tsa.academicYear.id = :academicYearId " +
           "AND tsa.effectiveFrom = :effectiveFrom AND tsa.deleted = false")
    Optional<TeacherSubjectAssignmentEntity> findByTeacherStandardSectionSubjectAndYear(
            @Param("employeeId") Long employeeId,
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("subjectId") Long subjectId,
            @Param("academicYearId") Long academicYearId,
            @Param("effectiveFrom") java.time.LocalDate effectiveFrom);

    @Modifying
    @Query("UPDATE TeacherSubjectAssignmentEntity tsa SET tsa.deleted = true, tsa.deletedAt = CURRENT_TIMESTAMP WHERE tsa.id = :id")
    void softDeleteById(@Param("id") Long id);
}
