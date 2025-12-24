package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeBonusEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeBonusRepository extends JpaRepository<EmployeeBonusEntity, Long> {

    // -------------------------
    // Find by ID
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.id = :id")
    Optional<EmployeeBonusEntity> findById(@Param("id") Long id);

    // -------------------------
    // Find by employee code
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.employeeCode = :code")
    Optional<EmployeeMasterEntity> findByEmployeeCode(@Param("code") String code);

    // -------------------------
    // Search by  name
    // -------------------------

    @Query("SELECT e FROM EmployeeMasterEntity e " +
            "WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "OR LOWER(e.fullName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<EmployeeMasterEntity> searchByName(@Param("name") String name);

    // -------------------------
    // Filter by gender
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.gender = :gender")
    List<EmployeeMasterEntity> findByGender(@Param("gender") String gender);

    // -------------------------
    // Filter by active status
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.active = :status")
    List<EmployeeMasterEntity> findByActiveStatus(@Param("status") Boolean status);

    // -------------------------
    // Filter by joining date range
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.joiningDate BETWEEN :start AND :end")
    List<EmployeeMasterEntity> findByJoiningDateBetween(@Param("start") Date start, @Param("end") Date end);

    // -------------------------
    // Filter by probation end date
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.probationEndDate < :date")
    List<EmployeeMasterEntity> findProbationEndedBefore(@Param("date") Date date);


    // -------------------------
    // Count queries
    // -------------------------
    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e")
    long countAllEmployees();

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = TRUE")
    long countActiveEmployees();

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = FALSE")
    long countInactiveEmployees();

    @Query("SELECT e.gender, COUNT(e) FROM EmployeeMasterEntity e GROUP BY e.gender")
    List<Object[]> countEmployeesByGender();

    // -------------------------
    // Ordering / Sorting
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterEntity e ORDER BY e.joiningDate DESC")
    List<EmployeeMasterEntity> findAllOrderByJoiningDateDesc();

    @Query("SELECT e FROM EmployeeMasterEntity e ORDER BY e.dateOfBirth ASC")
    List<EmployeeMasterEntity> findAllOrderByDateOfBirthAsc();



}
