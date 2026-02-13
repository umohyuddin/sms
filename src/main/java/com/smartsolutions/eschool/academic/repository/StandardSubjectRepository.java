package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StandardSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StandardSubjectRepository extends JpaRepository<StandardSubjectEntity, Long> {

        @Query("SELECT ss FROM StandardSubjectEntity ss JOIN FETCH ss.subject JOIN FETCH ss.standard JOIN FETCH ss.academicYear "
                        +
                        "WHERE ss.standard.id = :standardId AND ss.academicYear.id = :academicYearId AND ss.deleted = false AND ss.active = true")
        List<StandardSubjectEntity> findSubjectsByStandardAndAcademicYear(
                        @Param("standardId") Long standardId,
                        @Param("academicYearId") Long academicYearId);

        @Query("SELECT ss FROM StandardSubjectEntity ss WHERE ss.standard.id = :standardId AND ss.subject.id = :subjectId AND ss.academicYear.id = :academicYearId AND ss.deleted = false")
        Optional<StandardSubjectEntity> findByStandardSubjectAndYear(
                        @Param("standardId") Long standardId,
                        @Param("subjectId") Long subjectId,
                        @Param("academicYearId") Long academicYearId);

        @Modifying
        @Query("UPDATE StandardSubjectEntity ss SET ss.deleted = true, ss.deletedAt = CURRENT_TIMESTAMP WHERE ss.standard.id = :standardId AND ss.academicYear.id = :academicYearId AND ss.subject.id IN :subjectIds AND ss.deleted = false")
        void bulkSoftDelete(@Param("standardId") Long standardId, @Param("subjectIds") List<Long> subjectIds,
                        @Param("academicYearId") Long academicYearId);

        @Modifying
        @Query("UPDATE StandardSubjectEntity ss SET ss.deleted = true, ss.deletedAt = CURRENT_TIMESTAMP WHERE ss.id = :id")
        void softDeleteById(@Param("id") Long id);
}
