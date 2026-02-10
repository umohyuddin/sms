package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StandardSubjectEntity;
import com.smartsolutions.eschool.academic.entity.embeddable.StandardSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardSubjectRepository extends JpaRepository<StandardSubjectEntity, StandardSubjectId> {

    @Query("SELECT ss FROM StandardSubjectEntity ss JOIN FETCH ss.subject JOIN FETCH ss.standard JOIN FETCH ss.academicYear " +
           "WHERE ss.id.standardId = :standardId AND ss.id.academicYearId = :academicYearId AND ss.deleted = false AND ss.active = true")
    List<StandardSubjectEntity> findSubjectsByStandardAndAcademicYear(
            @Param("standardId") Long standardId,
            @Param("academicYearId") Long academicYearId);

    @Modifying
    @Query("UPDATE StandardSubjectEntity ss SET ss.deleted = true, ss.deletedAt = CURRENT_TIMESTAMP WHERE ss.id = :id")
    void softDeleteById(@Param("id") StandardSubjectId id);
}
