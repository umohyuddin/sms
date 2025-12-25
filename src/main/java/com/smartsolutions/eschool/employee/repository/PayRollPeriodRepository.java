package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PayRollPeriodRepository extends JpaRepository<PayrollPeriodEntity, Long> {

    /* =========================
       FIND BY ID ACTIVE
       ========================= */
    @Query("SELECT p FROM PayrollPeriodEntity p WHERE p.id = :id AND p.deleted = false")
    Optional<PayrollPeriodEntity> findByIdActive(Long id);

    /* =========================
       FIND ALL ACTIVE
       ========================= */
    @Query("SELECT p FROM PayrollPeriodEntity p WHERE p.deleted = false")
    List<PayrollPeriodEntity> findAllActive();

    /* =========================
       FIND BY STATUS
       ========================= */
    @Query("SELECT p FROM PayrollPeriodEntity p WHERE p.status = :status AND p.deleted = false")
    List<PayrollPeriodEntity> findAllByStatus(PayrollPeriodEntity.PayrollStatus status);

    /* =========================
       SOFT DELETE
       ========================= */
    @Modifying
    @Query("UPDATE PayrollPeriodEntity p SET p.deleted = true WHERE p.id = :id")
    void softDeleteById(Long id);
}