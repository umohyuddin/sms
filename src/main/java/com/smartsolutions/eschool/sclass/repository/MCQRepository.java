package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.MCQEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MCQRepository extends JpaRepository<MCQEntity, Long> {

    @Query("SELECT m FROM MCQEntity m WHERE m.subjectId = :subjectId AND m.chapter = :chapter")
    List<MCQEntity> findByChapter(@Param("subjectId") Integer subjectId, @Param("chapter") Integer chapter);

    List<MCQEntity> findBySubjectId(Integer subjectId);
}
