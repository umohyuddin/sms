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


    @Query("SELECT e FROM EmployeeMasterEntity e LEFT JOIN FETCH e.employeeType WHERE e.organizationId = :organizationId")
    List<EmployeeMasterEntity> findAllNonDeleted(@Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.id = :id AND e.organizationId = :organizationId")
    Optional<EmployeeMasterEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.employeeCode = :code AND e.organizationId = :organizationId")
    Optional<EmployeeMasterEntity> findByEmployeeCodeAndOrganizationId(@Param("code") String code, @Param("organizationId") Long organizationId);

    @Query("""
        SELECT e FROM EmployeeMasterEntity e
        WHERE e.organizationId = :organizationId
          AND (LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.employeeCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(e.primaryPhone) LIKE LOWER(CONCAT('%', :keyword, '%')))
    """)
    List<EmployeeMasterEntity> searchByKeyword(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.gender = :gender AND e.organizationId = :organizationId")
    List<EmployeeMasterEntity> findByGender(@Param("gender") String gender, @Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.active = :status AND e.organizationId = :organizationId")
    List<EmployeeMasterEntity> findByActiveStatus(@Param("status") Boolean status, @Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId AND e.joiningDate BETWEEN :start AND :end")
    List<EmployeeMasterEntity> findByJoiningDateBetween(@Param("start") Date start, @Param("end") Date end, @Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId AND e.probationEndDate < :date")
    List<EmployeeMasterEntity> findProbationEndedBefore(@Param("date") Date date, @Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId")
    long countAllEmployees(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = TRUE AND e.organizationId = :organizationId")
    long countActiveEmployees(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(e) FROM EmployeeMasterEntity e WHERE e.active = FALSE AND e.organizationId = :organizationId")
    long countInactiveEmployees(@Param("organizationId") Long organizationId);

    @Query("SELECT e.gender, COUNT(e) FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId GROUP BY e.gender")
    List<Object[]> countEmployeesByGender(@Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId ORDER BY e.joiningDate DESC")
    List<EmployeeMasterEntity> findAllOrderByJoiningDateDesc(@Param("organizationId") Long organizationId);

    @Query("SELECT e FROM EmployeeMasterEntity e WHERE e.organizationId = :organizationId ORDER BY e.dateOfBirth ASC")
    List<EmployeeMasterEntity> findAllOrderByDateOfBirthAsc(@Param("organizationId") Long organizationId);

    @Query("""
        SELECT 
            et.id AS employeeTypeId,
            et.name AS employeeTypeName,
            COUNT(e.id) AS totalEmployees
        FROM EmployeeMasterEntity e
        JOIN e.employeeType et
        WHERE e.active = true AND e.organizationId = :organizationId
        GROUP BY et.id, et.name
    """)
    List<EmployeeTypeCountDTO> countEmployeesByType(@Param("organizationId") Long organizationId);

    @org.springframework.data.jpa.repository.Modifying
    @Query("UPDATE EmployeeMasterEntity e SET e.deleted = true WHERE e.id = :id AND e.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);
}


