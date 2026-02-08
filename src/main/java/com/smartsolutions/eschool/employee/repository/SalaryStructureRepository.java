package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.model.SalaryStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryStructureRepository extends JpaRepository<SalaryStructureEntity, Long> {

    @Query("SELECT s FROM SalaryStructureEntity s WHERE s.id = :id")
    Optional<SalaryStructureEntity> findById(@Param("id") Long id);

    @Query("SELECT s FROM SalaryStructureEntity s")
    List<SalaryStructureEntity> findAllNonDeleted();

    @Query("SELECT s FROM SalaryStructureEntity s WHERE s.employeeType = :employeeType")
    List<SalaryStructureEntity> findByEmployeeType(@Param("employeeType") EmployeeTypeEntity employeeType);

    @Query("SELECT s FROM SalaryStructureEntity s JOIN FETCH s.employeeType WHERE s.id = :id")
    Optional<SalaryStructureEntity> findActiveById(@Param("id") Long id);

    @Query("SELECT s FROM SalaryStructureEntity s " + "WHERE s.effectiveFrom <= :date " + "AND (s.effectiveTo IS NULL OR s.effectiveTo >= :date)")
    List<SalaryStructureEntity> findEffectiveOn(@Param("date") LocalDate date);

    @Query("SELECT s FROM SalaryStructureEntity s " + "WHERE s.employeeType = :employeeType " + "ORDER BY s.effectiveFrom DESC")
    List<SalaryStructureEntity> findLatestByEmployeeType(@Param("employeeType") EmployeeTypeEntity employeeType);

    @Modifying
    @Query("UPDATE SalaryStructureEntity s SET s.deleted = true WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT s FROM SalaryStructureEntity s " + "WHERE s.effectiveFrom >= :startDate AND (s.effectiveTo <= :endDate OR s.effectiveTo IS NULL)")
    List<SalaryStructureEntity> findWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT COUNT(s) FROM SalaryStructureEntity s WHERE s.employeeType = :employeeType")
    Long countByEmployeeType(@Param("employeeType") EmployeeTypeEntity employeeType);

    @Query("SELECT s FROM SalaryStructureEntity s WHERE (LOWER(s.employeeType.name) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<SalaryStructureEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("""
                SELECT s FROM SalaryStructureEntity s
                LEFT JOIN FETCH s.employeeType e
                WHERE (:employeeTypeId IS NULL OR e.id = :employeeTypeId)
                  AND (:employeeTypeName IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :employeeTypeName, '%')))
                  AND (:minSalary IS NULL OR s.baseSalary >= :minSalary)
                  AND (:maxSalary IS NULL OR s.baseSalary <= :maxSalary)
                  AND (:fromDate IS NULL OR s.effectiveFrom >= :fromDate)
                  AND (:toDate IS NULL OR s.effectiveTo <= :toDate)
                  AND (:isCurrent IS NULL OR s.isCurrent = :isCurrent)
            """)
    List<SalaryStructureEntity> searchSalaryStructures(
            @Param("employeeTypeId") Long employeeTypeId,
            @Param("employeeTypeName") String employeeTypeName,
            @Param("minSalary") BigDecimal minSalary,
            @Param("maxSalary") BigDecimal maxSalary,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("isCurrent") Boolean isCurrent
    );

    @Query("SELECT DISTINCT ss FROM SalaryStructureEntity ss " +
            "JOIN FETCH ss.employeeType et " +
            "LEFT JOIN FETCH ss.components ssc " +
            "LEFT JOIN FETCH ssc.component " +
            "WHERE ss.isCurrent = TRUE")
    List<SalaryStructureEntity> findSalaryDetail();

    @Query("""
                SELECT ss
                FROM SalaryStructureEntity ss
                JOIN FETCH ss.employeeType et
                LEFT JOIN FETCH ss.components ssc
                LEFT JOIN FETCH ssc.component c
                WHERE et.id = :employeeTypeId
                  AND ss.isCurrent = TRUE
            """)
    SalaryStructureEntity findCurrentSalaryByEmployeeType(
            @Param("employeeTypeId") Long employeeTypeId
    );

    @Query("""
                SELECT ss
                FROM SalaryStructureEntity ss
                WHERE ss.employeeType.id = :employeeTypeId
                  AND ss.isCurrent = true
            """)
    Optional<SalaryStructureEntity> findByEmployeeTypeId(
            @Param("employeeTypeId") Long employeeTypeId
    );
}
