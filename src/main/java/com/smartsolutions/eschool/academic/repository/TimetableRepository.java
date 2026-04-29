package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {

    @Query("SELECT t FROM TimetableEntity t JOIN FETCH t.subject JOIN FETCH t.teacher JOIN FETCH t.standard JOIN FETCH t.section " +
           "WHERE t.id = :id AND t.deleted = false")
    List<TimetableEntity> findActiveById(@Param("id") Long id);

    @Query("SELECT t FROM TimetableEntity t JOIN FETCH t.subject JOIN FETCH t.teacher " +
           "WHERE t.standard.id = :standardId AND t.section.id = :sectionId AND t.deleted = false")
    List<TimetableEntity> findByStandardAndSection(@Param("standardId") Long standardId, @Param("sectionId") Long sectionId);

    @Query("SELECT t FROM TimetableEntity t JOIN FETCH t.subject JOIN FETCH t.standard JOIN FETCH t.section " +
           "WHERE t.teacher.id = :teacherId AND t.dayOfWeek = :day AND t.deleted = false")
    List<TimetableEntity> findTeacherTimetableByDay(@Param("teacherId") Long teacherId, @Param("day") TimetableEntity.DayOfWeek day);

    @Modifying
    @Query("UPDATE TimetableEntity t SET t.deleted = true, t.deletedAt = CURRENT_TIMESTAMP WHERE t.id = :id")
    void softDeleteById(@Param("id") Long id);
}
