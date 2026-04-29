package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDocumentRepository extends JpaRepository<StudentDocumentEntity, Long> {

    // Fetch all documents of a student
    List<StudentDocumentEntity> findByStudentId(Long studentId);

    // Fetch specific document of a student (for secure download)
    @Query("SELECT s FROM StudentDocumentEntity s WHERE s.id = :id AND s.studentId = :studentId")
    Optional<StudentDocumentEntity> findDocumentByIdAndStudentId(
            @Param("id") Long id,
            @Param("studentId") Long studentId
    );
}
