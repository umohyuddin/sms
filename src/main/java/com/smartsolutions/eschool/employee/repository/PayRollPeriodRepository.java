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

    @Query("SELECT p FROM PayrollPeriodEntity p WHERE p.id = :id")
    Optional<PayrollPeriodEntity> findById(@Param("id") Long id);

    @Query("SELECT p FROM PayrollPeriodEntity p")
    List<PayrollPeriodEntity> findAllNonDeleted();

    @Query("SELECT p FROM PayrollPeriodEntity p WHERE p.status = :status")
    List<PayrollPeriodEntity> findAllByStatus(@Param("status") PayrollPeriodEntity.PayrollStatus status);

    @Query("SELECT p FROM PayrollPeriodEntity p WHERE LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PayrollPeriodEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Query("UPDATE PayrollPeriodEntity p SET p.deleted = true WHERE p.id = :id")
    int softDeleteById(@Param("id") Long id);
}