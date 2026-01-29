package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.TeacherSubjectAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherSubjectAssignmentRepository
        extends JpaRepository<TeacherSubjectAssignmentEntity, Long> {

    boolean existsByEmployee_IdAndStandard_IdAndSection_IdAndSubject_IdAndAcademicYear_Id(
            Long employeeId,
            Long standardId,
            Long sectionId,
            Long subjectId,
            Long academicYearId
    );

    List<TeacherSubjectAssignmentEntity> findByEmployee_Id(Long employeeId);

    List<TeacherSubjectAssignmentEntity> findByStandard_IdAndSection_IdAndAcademicYear_Id(
            Long standardId,
            Long sectionId,
            Long academicYearId
    );

    Optional<TeacherSubjectAssignmentEntity> findByEmployee_IdAndStandard_IdAndSection_IdAndSubject_IdAndAcademicYear_Id(
            Long employeeId,
            Long standardId,
            Long sectionId,
            Long subjectId,
            Long academicYearId
    );
}