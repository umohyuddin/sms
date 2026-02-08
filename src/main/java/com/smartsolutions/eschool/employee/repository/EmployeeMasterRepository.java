package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.model.EmployeeAddressEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMasterEntity, Long> {


    @Query("SELECT e FROM EmployeeMasterEntity e LEFT JOIN FETCH e.employeeType")
    List<EmployeeMasterEntity> findAllNonDeleted();

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.id = :id")
    Optional<EmployeeMasterEntity> findById(@Param("id") Long id);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.employeeCode = :code")
    Optional<EmployeeMasterEntity> findByEmployeeCode(@Param("code") String code);

    @Query("""
        SELECT e FROM EmployeeMasterEntity e
        WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.employeeCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.primaryPhone) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<EmployeeMasterEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.gender = :gender")
    List<EmployeeMasterEntity> findByGender(@Param("gender") String gender);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.active = :status")
    List<EmployeeMasterEntity> findByActiveStatus(@Param("status") Boolean status);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.joiningDate BETWEEN :start AND :end")
    List<EmployeeMasterEntity> findByJoiningDateBetween(@Param("start") Date start, @Param("end") Date end);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.probationEndDate < :date")
    List<EmployeeMasterEntity> findProbationEndedBefore(@Param("date") Date date);

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e")
    long countAllEmployees();

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = TRUE")
    long countActiveEmployees();

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = FALSE")
    long countInactiveEmployees();

    @Query("SELECT e.gender, COUNT(e) FROM EmployeeMasterEntity e GROUP BY e.gender")
    List<Object[]> countEmployeesByGender();

    @Query("SELECT e FROM EmployeeMasterEntity e ORDER BY e.joiningDate DESC")
    List<EmployeeMasterEntity> findAllOrderByJoiningDateDesc();

    @Query("SELECT e FROM EmployeeMasterEntity e ORDER BY e.dateOfBirth ASC")
    List<EmployeeMasterEntity> findAllOrderByDateOfBirthAsc();

    @Query("""
        SELECT 
            et.id AS employeeTypeId,
            et.name AS employeeTypeName,
            COUNT(e.id) AS totalEmployees
        FROM EmployeeMasterEntity e
        JOIN e.employeeType et
        WHERE e.active = true
        GROUP BY et.id, et.name
    """)
    List<EmployeeTypeCountDTO> countEmployeesByType();

    @org.springframework.data.jpa.repository.Modifying
    @Query("UPDATE EmployeeMasterEntity e SET e.deleted = true WHERE e.id = :id")
    int softDeleteById(@Param("id") Long id);
}


