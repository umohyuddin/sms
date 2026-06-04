package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

    @org.springframework.data.jpa.repository.Query("SELECT r FROM ResultEntity r WHERE r.classId = :classId")
    List<ResultEntity> findByClsId(@org.springframework.data.repository.query.Param("classId") Integer classId);
    
    List<ResultEntity> findBySubjectId(Integer subjectId);

    List<ResultEntity> findByStudentId(Long studentId);
}
