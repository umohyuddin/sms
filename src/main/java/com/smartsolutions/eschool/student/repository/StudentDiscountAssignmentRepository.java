package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentDiscountAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDiscountAssignmentRepository extends JpaRepository<StudentDiscountAssignmentEntity, Long> {

    // -------------------------------------------------------------------------
    // GET ALL NOT DELETED
    // -------------------------------------------------------------------------
    @Query("SELECT sda FROM StudentDiscountAssignmentEntity sda WHERE sda.deleted = false ORDER BY sda.id ASC")
    List<StudentDiscountAssignmentEntity> findAllDeletedFalse();

    // -------------------------------------------------------------------------
    // GET BY ID AND NOT DELETED
    // -------------------------------------------------------------------------
    @Query("SELECT sda FROM StudentDiscountAssignmentEntity sda WHERE sda.id = :id AND sda.deleted = false")
    java.util.Optional<StudentDiscountAssignmentEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    // -------------------------------------------------------------------------
    // GET ALL ASSIGNMENTS FOR A STUDENT
    // -------------------------------------------------------------------------
    @Query("SELECT sda FROM StudentDiscountAssignmentEntity sda WHERE sda.student.id = :studentId AND sda.deleted = false")
    List<StudentDiscountAssignmentEntity> findAllByStudent(@Param("studentId") Long studentId);

    // -------------------------------------------------------------------------
    // SOFT DELETE BY ID
    // -------------------------------------------------------------------------
    @Modifying
    @Query("UPDATE StudentDiscountAssignmentEntity sda SET sda.deleted = true WHERE sda.id = :id")
    int softDeleteById(@Param("id") Long id);

    // -------------------------------------------------------------------------
    // SOFT DELETE ALL
    // -------------------------------------------------------------------------
    @Modifying
    @Query("UPDATE StudentDiscountAssignmentEntity sda SET sda.deleted = true WHERE sda.deleted = false")
    int softDeleteAll();

    // -------------------------------------------------------------------------
    // MARK AS ACTIVE
    // -------------------------------------------------------------------------
    @Modifying
    @Query("UPDATE StudentDiscountAssignmentEntity sda SET sda.isActive = true WHERE sda.id = :id")
    int markAsActive(@Param("id") Long id);

    // -------------------------------------------------------------------------
    // MARK AS INACTIVE
    // -------------------------------------------------------------------------
    @Modifying
    @Query("UPDATE StudentDiscountAssignmentEntity sda SET sda.isActive = false WHERE sda.id = :id")
    int markAsInactive(@Param("id") Long id);


    @Query("""
        SELECT sda
        FROM StudentDiscountAssignmentEntity sda
        JOIN FETCH sda.student st
        JOIN FETCH sda.campus c
        JOIN FETCH sda.discountRate dr
        JOIN FETCH dr.discountSubType dst
        JOIN FETCH dst.discountType dt
        JOIN FETCH sda.academicYear ay
        WHERE st.id = :studentId
          AND ay.id = :academicYearId
          AND sda.deleted = false
    """)
    List<StudentDiscountAssignmentEntity> findByStudentAndAcademicYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );

    @Query("SELECT s FROM StudentDiscountAssignmentEntity s " +
            "WHERE s.student.id = :studentId " +
            "AND s.academicYear.id = :academicYearId " +
            "AND s.campus.id = :campusId " +
            "AND s.deleted = false")
    Optional<StudentDiscountAssignmentEntity> findDiscountByAcademic_Campus_stundentId(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("campusId") Long campusId);
//    // -------------------------------------------------------------------------
//    // SEARCH BY KEYWORD (STUDENT NAME, CODE, OR OTHER FIELDS)
//    // -------------------------------------------------------------------------
//    @Query("""
//            SELECT sda
//            FROM StudentDiscountAssignmentEntity sda
//            WHERE sda.deleted = false
//            AND (
//                LOWER(sda.student.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//                OR LOWER(sda.student.rollNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
//            )
//            ORDER BY sda.id ASC
//            """)
//    List<StudentDiscountAssignmentEntity> searchByKeyword(@Param("keyword") String keyword);
}
