package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableEntity, Long> {

    List<TimeTableEntity> findByTeacherId(Long teacherId);

    @Query("SELECT t FROM TimeTableEntity t WHERE t.classId = :classId")
    List<TimeTableEntity> findByClsId(@Param("classId") Integer classId);
}
