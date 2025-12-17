package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeDocumentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocumentEntity, Long> {

    List<EmployeeDocumentEntity> findByEmployeeId(Long employeeId);

    @Query("SELECT e FROM EmployeeDocumentEntity e WHERE e.id = :id AND e.employeeId = :employeeId")
    Optional<EmployeeDocumentEntity> findDocumentByIdAndEmployeeId(
            @Param("id") Long id,
            @Param("employeeId") Long employeeId
    );
}
