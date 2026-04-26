package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

  @Query("SELECT s FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.isActive = true AND s.deleted = false")
  List<StudentEntity> findAllByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.isActive = false AND s.deleted = false")
  List<StudentEntity> findAllByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "LEFT JOIN FETCH s.admissionType " +
      "LEFT JOIN FETCH s.academicYear " +
      "WHERE s.id = :id AND s.organizationId = :organizationId AND s.deleted = false")
  Optional<StudentEntity> findByIdAndOrganizationId(@Param("id") Long id,
      @Param("organizationId") Long organizationId);

  @Query("SELECT DISTINCT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "LEFT JOIN FETCH s.feeAssignments fa " +
      "LEFT JOIN FETCH fa.feeRate fr " +
      "LEFT JOIN FETCH fr.feeComponent fc " +
      "WHERE s.organizationId = :organizationId AND s.deleted = false AND (fr.academicYear.id = :academicYearId OR fr.academicYear.id IS NULL)")
  List<StudentEntity> findAllWithAssignments(@Param("academicYearId") Long academicYearId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "WHERE s.campus.id = :campusId AND s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> findByCampusIdAndOrganizationId(@Param("campusId") Long campusId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "WHERE s.standard.id = :standardId AND s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> findByStandardIdAndOrganizationId(@Param("standardId") Long standardId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "WHERE s.section.id = :sectionId AND s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> findBySectionIdAndOrganizationId(@Param("sectionId") Long sectionId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "WHERE (s.firstName LIKE %:keyword% OR s.lastName LIKE %:keyword% OR s.fullName LIKE %:keyword% OR s.studentCode LIKE %:keyword%) "
      +
      "AND s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "WHERE s.studentCode = :studentCode AND s.organizationId = :organizationId AND s.deleted = false")
  Optional<StudentEntity> findByStudentCodeAndOrganizationId(@Param("studentCode") String studentCode,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s FROM StudentEntity s " +
      "LEFT JOIN FETCH s.campus " +
      "LEFT JOIN FETCH s.standard " +
      "LEFT JOIN FETCH s.section " +
      "WHERE s.campus.id = :campusId AND s.standard.id = :standardId AND s.organizationId = :organizationId AND s.deleted = false")
  List<StudentEntity> findByCampusAndStandardAndOrganizationId(@Param("campusId") Long campusId,
      @Param("standardId") Long standardId, @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.deleted = false")
  Long countAllActiveStudents(@Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.campus.id = :campusId AND s.organizationId = :organizationId AND s.deleted = false")
  Long countByCampusAndOrganizationId(@Param("campusId") Long campusId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.standard.id = :standardId AND s.organizationId = :organizationId AND s.deleted = false")
  Long countByStandardAndOrganizationId(@Param("standardId") Long standardId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.section.id = :sectionId AND s.organizationId = :organizationId AND s.deleted = false")
  Long countBySectionAndOrganizationId(@Param("sectionId") Long sectionId,
      @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.gender = :gender AND s.organizationId = :organizationId AND s.deleted = false")
  Long countByGenderAndOrganizationId(@Param("gender") String gender,
      @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s " +
      "WHERE s.enrollmentDate BETWEEN :startDate AND :endDate AND s.organizationId = :organizationId")
  Long countStudentsRegisteredBetweenAndOrganizationId(@Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate, @Param("organizationId") Long organizationId);

  @EntityGraph(attributePaths = {
      "campus",
      "standard",
      "section",
      "academicYear"
  })
  @Query("""
          SELECT s FROM StudentEntity s
          WHERE s.deleted = false AND s.organizationId = :organizationId
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
  List<StudentEntity> searchStudentsWithFilters(
      @Param("campusId") Long campusId,
      @Param("standardId") Long standardId,
      @Param("sectionId") Long sectionId,
      @Param("studentId") Long studentId,
      @Param("academicYearId") Long academicYearId,
      @Param("keyword") String keyword,
      @Param("organizationId") Long organizationId);

  @Query("SELECT s.campus.id, COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.deleted = false GROUP BY s.campus.id")
  List<Object[]> countStudentsPerCampus(@Param("organizationId") Long organizationId);

  @Query("SELECT s.standard.id, COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.campus.id = :campusId AND s.deleted = false GROUP BY s.standard.id")
  List<Object[]> countStudentsPerStandard(@Param("organizationId") Long organizationId,
      @Param("campusId") Long campusId);

  @Query("SELECT s.section.id, COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.standard.id = :standardId AND s.deleted = false GROUP BY s.section.id")
  List<Object[]> countStudentsPerSection(@Param("organizationId") Long organizationId,
      @Param("standardId") Long standardId);

  @Modifying
  @Transactional
  @Query("UPDATE StudentEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP "
      + "WHERE s.id = :id AND s.organizationId = :organizationId")
  int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.isActive = true AND s.deleted = false")
  Long countByOrganizationIdAndIsActiveTrue(@Param("organizationId") Long organizationId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.isActive = false AND s.deleted = false")
  Long countByOrganizationIdAndIsActiveFalse(@Param("organizationId") Long organizationId);

  @Query("SELECT (COUNT(s) > 0) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.studentCode = :studentCode AND s.deleted = false")
  boolean existsByOrganizationIdAndStudentCode(@Param("organizationId") Long organizationId,
      @Param("studentCode") String studentCode);

  @Query("SELECT (COUNT(s) > 0) FROM StudentEntity s WHERE s.organizationId = :organizationId AND s.studentCode = :studentCode AND s.id <> :id AND s.deleted = false")
  boolean existsByOrganizationIdAndStudentCodeAndIdNot(@Param("organizationId") Long organizationId,
      @Param("studentCode") String studentCode, @Param("id") Long id);

  // --- Legacy Backwards Compatibility Methods for Academic/Fee/Discount Modules
  // --- //
  @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.campus LEFT JOIN FETCH s.standard LEFT JOIN FETCH s.section WHERE s.id = :id AND s.deleted = false")
  Optional<StudentEntity> findByIdAndDeletedFalse(@Param("id") Long id);

  @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.campus LEFT JOIN FETCH s.standard LEFT JOIN FETCH s.section WHERE s.section.id = :sectionId AND s.deleted = false")
  List<StudentEntity> findBySectionId(@Param("sectionId") Long sectionId);

  @Query("SELECT s FROM StudentEntity s WHERE (s.firstName LIKE %:keyword% OR s.lastName LIKE %:keyword% OR s.fullName LIKE %:keyword%) AND s.deleted = false")
  List<StudentEntity> searchStudentsByName(@Param("keyword") String keyword);

  @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.campus LEFT JOIN FETCH s.standard LEFT JOIN FETCH s.section WHERE s.studentCode = :studentCode AND s.deleted = false")
  Optional<StudentEntity> findByStudentCode(@Param("studentCode") String studentCode);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.campus.id = :campusId AND s.deleted = false")
  Long countByCampus(@Param("campusId") Long campusId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.standard.id = :standardId AND s.deleted = false")
  Long countByStandard(@Param("standardId") Long standardId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.section.id = :sectionId AND s.deleted = false")
  Long countBySection(@Param("sectionId") Long sectionId);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.gender = :gender AND s.deleted = false")
  Long countByGender(@Param("gender") String gender);

  @Query("SELECT COUNT(s) FROM StudentEntity s WHERE s.enrollmentDate BETWEEN :startDate AND :endDate")
  Long countStudentsRegisteredBetween(@Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate);

  // -------------------------------------------------------------------------- //
  @Query("""
          SELECT COUNT(s) FROM StudentEntity s
          WHERE s.organizationId = :organizationId AND s.deleted = false
            AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
            AND (:academicYearId IS NULL OR s.academicYear.id = :academicYearId)
            AND (:standardId IS NULL OR s.standard.id = :standardId)
            AND (:sectionId IS NULL OR s.section.id = :sectionId)
            AND (:fromDate IS NULL OR s.enrollmentDate >= :fromDate)
            AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
      """)
  Long countByFilters(
      @Param("campusIds") List<Long> campusIds,
      @Param("academicYearId") Long academicYearId,
      @Param("standardId") Long standardId,
      @Param("sectionId") Long sectionId,
      @Param("fromDate") java.time.LocalDate fromDate,
      @Param("toDate") java.time.LocalDate toDate,
      @Param("organizationId") Long organizationId);

  @Query("""
          SELECT COUNT(s) FROM StudentEntity s
          WHERE s.organizationId = :organizationId AND s.isActive = true AND s.deleted = false
            AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
            AND (:academicYearId IS NULL OR s.academicYear.id = :academicYearId)
            AND (:standardId IS NULL OR s.standard.id = :standardId)
            AND (:sectionId IS NULL OR s.section.id = :sectionId)
            AND (:fromDate IS NULL OR s.enrollmentDate >= :fromDate)
            AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
      """)
  Long countActiveByFilters(
      @Param("campusIds") List<Long> campusIds,
      @Param("academicYearId") Long academicYearId,
      @Param("standardId") Long standardId,
      @Param("sectionId") Long sectionId,
      @Param("fromDate") java.time.LocalDate fromDate,
      @Param("toDate") java.time.LocalDate toDate,
      @Param("organizationId") Long organizationId);

  @Query("""
          SELECT COUNT(s) FROM StudentEntity s
          WHERE s.organizationId = :organizationId AND s.deleted = false
            AND s.enrollmentDate BETWEEN :fromDate AND :toDate
            AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
            AND (:standardId IS NULL OR s.standard.id = :standardId)
            AND (:sectionId IS NULL OR s.section.id = :sectionId)
      """)
  Long countNewAdmissions(
      @Param("fromDate") LocalDate fromDate,
      @Param("toDate") LocalDate toDate,
      @Param("campusIds") List<Long> campusIds,
      @Param("standardId") Long standardId,
      @Param("sectionId") Long sectionId,
      @Param("organizationId") Long organizationId);

    @Query("""
            SELECT s.gender, COUNT(s) FROM StudentEntity s
            WHERE s.organizationId = :organizationId AND s.deleted = false
              AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
              AND (:standardId IS NULL OR s.standard.id = :standardId)
              AND (:sectionId IS NULL OR s.section.id = :sectionId)
              AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
            GROUP BY s.gender
        """)
    List<Object[]> countByGenderDistribution(
        @Param("campusIds") List<Long> campusIds,
        @Param("standardId") Long standardId,
        @Param("sectionId") Long sectionId,
        @Param("toDate") java.time.LocalDate toDate,
        @Param("organizationId") Long organizationId);

    @Query("""
            SELECT s.standard.standardName, COUNT(s) FROM StudentEntity s
            WHERE s.organizationId = :organizationId AND s.deleted = false
              AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
              AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
            GROUP BY s.standard.standardName
        """)
    List<Object[]> countByStandardDistribution(@Param("campusIds") java.util.List<Long> campusIds,
        @Param("toDate") java.time.LocalDate toDate, 
        @Param("organizationId") Long organizationId);

    @Query("""
            SELECT s.gender, COUNT(s)
            FROM StudentEntity s
            WHERE s.campus.institute.id = :organizationId
              AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
              AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
              AND s.deleted = false
            GROUP BY s.gender
        """)
    java.util.List<Object[]> getGenderDistribution(
        @Param("campusIds") java.util.List<Long> campusIds,
        @Param("toDate") java.time.LocalDate toDate,
        @Param("organizationId") Long organizationId);

    @Query("""
            SELECT s.standard.standardName, COUNT(s)
            FROM StudentEntity s
            WHERE s.campus.institute.id = :organizationId
              AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
              AND (:toDate IS NULL OR s.enrollmentDate <= :toDate)
              AND s.deleted = false
            GROUP BY s.standard.standardName
        """)
    java.util.List<Object[]> getStudentStrengthByStandard(
        @Param("campusIds") java.util.List<Long> campusIds,
        @Param("toDate") java.time.LocalDate toDate,
        @Param("organizationId") Long organizationId);

  @Query("""
          SELECT s.enrollmentDate, COUNT(s)
          FROM StudentEntity s
          WHERE s.campus.institute.id = :organizationId
            AND (:campusIds IS NULL OR s.campus.id IN :campusIds)
            AND s.enrollmentDate BETWEEN :fromDate AND :toDate
            AND s.deleted = false
          GROUP BY s.enrollmentDate
          ORDER BY s.enrollmentDate
      """)
  java.util.List<Object[]> getAdmissionsTrend(
      @Param("fromDate") java.time.LocalDate fromDate,
      @Param("toDate") java.time.LocalDate toDate,
      @Param("campusIds") java.util.List<Long> campusIds,
      @Param("organizationId") Long organizationId);
}
