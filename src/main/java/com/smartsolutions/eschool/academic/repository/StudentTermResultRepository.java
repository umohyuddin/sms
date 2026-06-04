package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StudentTermResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentTermResultRepository extends JpaRepository<StudentTermResultEntity, Long> {

       @Query("SELECT str FROM StudentTermResultEntity str WHERE str.student.id = :studentId " +
                     "AND str.academicYear.id = :academicYearId AND str.deleted = false")
       List<StudentTermResultEntity> findResultsByStudentAndYear(@Param("studentId") Long studentId,
                     @Param("academicYearId") Long academicYearId);

       @Query("SELECT str FROM StudentTermResultEntity str " +
                     "JOIN FETCH str.student s " +
                     "JOIN FETCH str.academicYear ay " +
                     "JOIN FETCH str.examTerm et " +
                     "WHERE s.standard.id = :standardId " +
                     "AND s.section.id = :sectionId " +
                     "AND str.examTerm.id = :examTermId " +
                     "AND str.deleted = false")
       List<StudentTermResultEntity> findBySectionIdAndExamTerm(@Param("standardId") Long standardId,
                     @Param("sectionId") Long sectionId,
                     @Param("examTermId") Long examTermId);

       @Query("SELECT str FROM StudentTermResultEntity str " +
                     "JOIN FETCH str.student s " +
                     "JOIN FETCH str.academicYear ay " +
                     "JOIN FETCH str.examTerm et " +
                     "WHERE str.student.id = :studentId " +
                     "AND str.examTerm.id = :examTermId " +
                     "AND str.deleted = false")
       Optional<StudentTermResultEntity> findByStudentIdAndExamTerm(@Param("studentId") Long studentId,
                     @Param("examTermId") Long examTermId);

       @Modifying
       @Query("UPDATE StudentTermResultEntity str SET str.deleted = true, str.deletedAt = CURRENT_TIMESTAMP WHERE str.id = :id")
       void softDeleteById(@Param("id") Long id);
}
