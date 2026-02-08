package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.SalaryStructureComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryStructureComponentRepository extends JpaRepository<SalaryStructureComponentEntity, Long> {

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.id = :id")
    Optional<SalaryStructureComponentEntity> findById(@Param("id") Long id);

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc")
    List<SalaryStructureComponentEntity> findAllNonDeleted();

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId")
    List<SalaryStructureComponentEntity> findBySalaryStructureId(@Param("salaryStructureId") Long salaryStructureId);

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.component.id = :componentId")
    List<SalaryStructureComponentEntity> findByComponentId(@Param("componentId") Long componentId);

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND ssc.component.id = :componentId")
    Optional<SalaryStructureComponentEntity> findBySalaryStructureIdAndComponentId(@Param("salaryStructureId") Long salaryStructureId, @Param("componentId") Long componentId);

    @Modifying
    @Query("UPDATE SalaryStructureComponentEntity ssc SET ssc.deleted = true WHERE ssc.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE SalaryStructureComponentEntity ssc SET ssc.deleted = true WHERE ssc.salaryStructure.id = :salaryStructureId")
    int softDeleteBySalaryStructureId(@Param("salaryStructureId") Long salaryStructureId);

    @Query("SELECT ssc FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId AND LOWER(ssc.component.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SalaryStructureComponentEntity> searchByKeyword(@Param("salaryStructureId") Long salaryStructureId, @Param("keyword") String keyword);

    @Query("SELECT COUNT(ssc) FROM SalaryStructureComponentEntity ssc WHERE ssc.salaryStructure.id = :salaryStructureId")
    Long countBySalaryStructureId(@Param("salaryStructureId") Long salaryStructureId);
}
