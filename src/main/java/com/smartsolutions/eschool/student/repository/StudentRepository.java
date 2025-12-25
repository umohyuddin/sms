package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.id = :id AND s.deleted = false")
    Optional<StudentEntity> findByIdAndDeletedFalse(Long id);


    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.deleted = false")
    List<StudentEntity> findByDeletedFalse();

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.campus.id = :campusId AND s.deleted = false")
    List<StudentEntity> findByCampusId(@Param("campusId") Long campusId);

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.standard.id = :standardId AND s.deleted = false")
    List<StudentEntity> findByStandardId(@Param("standardId") Long standardId);

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.section.id = :sectionId AND s.deleted = false")
    List<StudentEntity> findBySectionId(@Param("sectionId") Long sectionId);


    @Query("SELECT s FROM StudentEntity s " +
            "WHERE (s.firstName LIKE %:keyword% OR s.lastName LIKE %:keyword% OR s.fullName LIKE %:keyword%) " +
            "AND s.deleted = false")
    List<StudentEntity> searchStudentsByName(@Param("keyword") String keyword);

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.studentCode = :studentCode AND s.deleted = false")
    Optional<StudentEntity> findByStudentCode(@Param("studentCode") String studentCode);


    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.campus " +
            "LEFT JOIN FETCH s.standard " +
            "LEFT JOIN FETCH s.section " +
            "WHERE s.campus.id = :campusId AND s.standard.id = :standardId AND s.deleted = false")
    List<StudentEntity> findByCampusAndStandard(@Param("campusId") Long campusId,
                                                @Param("standardId") Long standardId);


    // Total active students (not deleted)
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.deleted = false")
    Long countAllActiveStudents();

    // Total students by campus
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.deleted = false AND s.campus.id = :campusId")
    Long countByCampus(@Param("campusId") Long campusId);

    // Total students by standard
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.deleted = false AND s.standard.id = :standardId")
    Long countByStandard(@Param("standardId") Long standardId);

    // Total students by section
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.deleted = false AND s.section.id = :sectionId")
    Long countBySection(@Param("sectionId") Long sectionId);

    // total students by gender
    @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.deleted = false AND s.gender = :gender")
    Long countByGender(@Param("gender") String gender);


    @Query("SELECT COUNT(s) FROM StudentEntity s " +
            "WHERE s.enrollmentDate BETWEEN :startDate AND :endDate")
    Long countStudentsRegisteredBetween(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

//
//    @Query("""
//                SELECT s FROM StudentEntity s
//                LEFT JOIN FETCH s.campus c
//                LEFT JOIN FETCH s.standard st
//                LEFT JOIN FETCH s.section sec
//                LEFT JOIN FETCH s.academicYear ay
//                WHERE s.deleted = false
//                  AND (:campusId IS NULL OR c.id = :campusId)
//                  AND (:standardId IS NULL OR st.id = :standardId)
//                  AND (:studentId IS NULL OR s.id = :studentId)
//                  AND (:academicYearId IS NULL OR ay.id = :academicYearId)
//            """)
//    List<StudentEntity> searchStudents(
//            @Param("campusId") Long campusId,
//            @Param("standardId") Long standardId,
//            @Param("studentId") Long studentId,
//            @Param("academicYearId") Long academicYearId
//    );

//    @Query("""
//            SELECT s FROM StudentEntity s
//            LEFT JOIN FETCH s.campus c
//            LEFT JOIN FETCH s.standard st
//            LEFT JOIN FETCH s.section sec
//            LEFT JOIN FETCH s.academicYear ay
//            WHERE s.deleted = false
//              AND (:campusId IS NULL OR c.id = :campusId)
//              AND (:standardId IS NULL OR st.id = :standardId)
//              AND (:sectionId IS NULL OR sec.id = :sectionId)
//              AND (:studentId IS NULL OR s.id = :studentId)
//              AND (:academicYearId IS NULL OR ay.id = :academicYearId)
//              AND (:keyword IS NULL OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
//                   OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
//                   OR LOWER(s.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')))
//            """)
//@Query("""
//    SELECT DISTINCT s FROM StudentEntity s
//    LEFT JOIN FETCH s.campus c
//    LEFT JOIN FETCH s.standard st
//    LEFT JOIN FETCH s.section sec
//    LEFT JOIN FETCH s.academicYear ay
//    WHERE s.deleted = false
//      AND (:campusId IS NULL OR c.id = :campusId)
//      AND (:standardId IS NULL OR st.id = :standardId)
//      AND (:sectionId IS NULL OR sec.id = :sectionId)
//      AND (:studentId IS NULL OR s.id = :studentId)
//      AND (:academicYearId IS NULL OR ay.id = :academicYearId)
//      AND (
//            :keyword IS NULL
//            OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
//            OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
//            OR LOWER(s.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
//          )
//""")

    @EntityGraph(attributePaths = {
            "campus",
            "standard",
            "section",
            "academicYear"
    })
    @Query("""
                SELECT s FROM StudentEntity s
                WHERE s.deleted = false
                  AND (:campusId IS NULL OR s.campus.id = :campusId)
                  AND (:standardId IS NULL OR s.standard.id = :standardId)
                  AND (:sectionId IS NULL OR s.section.id = :sectionId)
                  AND (:studentId IS NULL OR s.id = :studentId)
                  AND (:academicYearId IS NULL OR s.academicYear.id = :academicYearId)
                  AND (
                        :keyword IS NULL
                        OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                        OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                        OR LOWER(s.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                      )
            """)
    List<StudentEntity> searchStudents(
            @Param("campusId") Long campusId,
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("keyword") String keyword
    );
}

