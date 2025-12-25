package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.SalaryStructureComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryStructureComponentRepository extends JpaRepository<SalaryStructureComponentEntity, Long> {

    // -------------------------
    // Find all active components
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.deleted = false")
    List<SalaryStructureComponentEntity> findAllActive();

    // -------------------------
    // Find by ID if not deleted
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.id = :id AND ssc.deleted = false")
    Optional<SalaryStructureComponentEntity> findByIdActive(Long id);

    // -------------------------
    // Find all components by salary structure
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND ssc.deleted = false")
    List<SalaryStructureComponentEntity> findBySalaryStructureId(Long salaryStructureId);

    // -------------------------
    // Find all components by component
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.component.id = :componentId AND ssc.deleted = false")
    List<SalaryStructureComponentEntity> findByComponentId(Long componentId);

    // -------------------------
    // Find specific component in salary structure
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND ssc.component.id = :componentId AND ssc.deleted = false")
    Optional<SalaryStructureComponentEntity> findBySalaryStructureIdAndComponentId(Long salaryStructureId, Long componentId);

    // -------------------------
    // Soft delete by ID
    // -------------------------
    @Modifying
    @Query("UPDATE SalaryStructureComponentEntity ssc SET ssc.deleted = true WHERE ssc.id = :id")
    int softDeleteById(Long id);

    // -------------------------
    // Soft delete all components for a salary structure
    // -------------------------
    @Modifying
    @Query("UPDATE SalaryStructureComponentEntity ssc SET ssc.deleted = true WHERE ssc.salaryStructure.id = :salaryStructureId")
    int softDeleteBySalaryStructureId(Long salaryStructureId);

    // -------------------------
    // Search by component name within salary structure
    // -------------------------
    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND ssc.component.name LIKE %:keyword% AND ssc.deleted = false")
    List<SalaryStructureComponentEntity> searchByComponentName(Long salaryStructureId, String keyword);

    // -------------------------
    // Count active components for a salary structure
    // -------------------------
    @Query("SELECT COUNT(ssc) FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND ssc.deleted = false")
    Long countActiveBySalaryStructureId(Long salaryStructureId);

}