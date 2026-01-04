package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FeeCatalogRepository extends JpaRepository<FeeCatalogEntity, Long> {

    @Query("SELECT fc FROM FeeCatalogEntity fc " +
            "WHERE fc.deleted = false")
    List<FeeCatalogEntity> findByDeletedFalse();

    @Query("SELECT fc FROM FeeCatalogEntity fc " +
            "WHERE fc.deleted = false AND fc.id=:id")
    Optional<FeeCatalogEntity> findByIdAndDeletedFalse(@Param("id") Long id);


    @Query("SELECT f FROM FeeCatalogEntity f " +
            "WHERE (" +
            "LOWER(f.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            ") AND f.deleted = false")
    List<FeeCatalogEntity> searchFeeCatalog(@Param("keyword") String keyword);


    @Query("SELECT fc FROM FeeCatalogEntity fc " +
            "WHERE fc.deleted = false AND " +
            "(LOWER(fc.code) = LOWER(:code) OR LOWER(fc.name) = LOWER(:name))")
    Optional<FeeCatalogEntity> findByCodeOrNameIgnoreCase(
            @Param("code") String code,
            @Param("name") String name
    );

//    @Query("SELECT s FROM StudentEntity s " +
//            "LEFT JOIN FETCH s.campus " +
//            "LEFT JOIN FETCH s.standard " +
//            "LEFT JOIN FETCH s.section " +
//            "WHERE s.campus.id = :campusId AND s.deleted = false")
//    List<StudentEntity> findByCampusId(@Param("campusId") Long campusId);
//
//    @Query("SELECT s FROM StudentEntity s " +
//            "LEFT JOIN FETCH s.campus " +
//            "LEFT JOIN FETCH s.standard " +
//            "LEFT JOIN FETCH s.section " +
//            "WHERE s.standard.id = :standardId AND s.deleted = false")
//    List<StudentEntity> findByStandardId(@Param("standardId") Long standardId);
//
//    @Query("SELECT s FROM StudentEntity s " +
//            "LEFT JOIN FETCH s.campus " +
//            "LEFT JOIN FETCH s.standard " +
//            "LEFT JOIN FETCH s.section " +
//            "WHERE s.section.id = :sectionId AND s.deleted = false")
//    List<StudentEntity> findBySectionId(@Param("sectionId") Long sectionId);
//
//
//    @Query("SELECT s FROM StudentEntity s " +
//            "WHERE (s.firstName LIKE %:keyword% OR s.lastName LIKE %:keyword% OR s.fullName LIKE %:keyword%) " +
//            "AND s.deleted = false")
//    List<StudentEntity> searchStudentsByName(@Param("keyword") String keyword);
//
//    @Query("SELECT s FROM StudentEntity s " +
//            "LEFT JOIN FETCH s.campus " +
//            "LEFT JOIN FETCH s.standard " +
//            "LEFT JOIN FETCH s.section " +
//            "WHERE s.studentCode = :studentCode AND s.deleted = false")
//    Optional<StudentEntity> findByStudentCode(@Param("studentCode") String studentCode);
//
//
//    @Query("SELECT s FROM StudentEntity s " +
//            "LEFT JOIN FETCH s.campus " +
//            "LEFT JOIN FETCH s.standard " +
//            "LEFT JOIN FETCH s.section " +
//            "WHERE s.campus.id = :campusId AND s.standard.id = :standardId AND s.deleted = false")
//    List<StudentEntity> findByCampusAndStandard(@Param("campusId") Long campusId,
//                                                @Param("standardId") Long standardId);

}
