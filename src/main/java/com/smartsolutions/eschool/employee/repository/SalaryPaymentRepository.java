package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.SalaryPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface SalaryPaymentRepository extends JpaRepository<SalaryPaymentEntity, Long> {

    /* =========================
       FIND ACTIVE BY ID
       ========================= */
    @Query("SELECT sp FROM SalaryPaymentEntity sp WHERE sp.id = :id AND sp.deleted = false")
    Optional<SalaryPaymentEntity> findByIdActive(Long id);

    /* =========================
       FIND ALL ACTIVE
       ========================= */
    @Query("SELECT sp FROM SalaryPaymentEntity sp WHERE sp.deleted = false")
    List<SalaryPaymentEntity> findAllActive();

    /* =========================
       FIND ALL ACTIVE BY EMPLOYEE SALARY
       ========================= */
    @Query("SELECT sp FROM SalaryPaymentEntity sp WHERE sp.employeeSalary.id = :employeeSalaryId AND sp.deleted = false")
    List<SalaryPaymentEntity> findAllByEmployeeSalaryIdActive(Long employeeSalaryId);

    /* =========================
       SOFT DELETE
       ========================= */
    @Modifying
    @Query("UPDATE SalaryPaymentEntity sp SET sp.deleted = true WHERE sp.id = :id")
    void softDeleteById(Long id);
}
