package com.smartsolutions.eschool.employee.repository;


import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.global.enums.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryComponentRepository extends JpaRepository<SalaryComponentEntity, Long> {

    /* =========================
       FIND BY ID (ACTIVE ONLY)
       ========================= */
    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.id = :id AND sc.deleted = false")
    Optional<SalaryComponentEntity> findByIdActive(Long id);

    /* =========================
       FIND ALL ACTIVE
       ========================= */
    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.deleted = false ORDER BY sc.name ASC")
    List<SalaryComponentEntity> findAllActive();

    /* =========================
       FIND ALL INACTIVE
       ========================= */
    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.deleted = true ORDER BY sc.name ASC")
    List<SalaryComponentEntity> findAllInactive();

    /* =========================
       SEARCH BY NAME
       ========================= */
    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.deleted = false AND LOWER(sc.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SalaryComponentEntity> searchByName(String keyword);

    /* =========================
       FIND BY TYPE
       ========================= */
//    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.deleted = false AND sc.type = :type")
//    List<SalaryComponentEntity> findByType(ComponentType type);

    /* =========================
       SOFT DELETE
       ========================= */
    @Modifying
    @Query("UPDATE SalaryComponentEntity sc SET sc.deleted = true WHERE sc.id = :id")
    int softDeleteById(Long id);

    /* =========================
       COUNT ACTIVE / INACTIVE
       ========================= */
    @Query("SELECT COUNT(sc) FROM SalaryComponentEntity sc WHERE sc.deleted = false")
    Long countActive();

    @Query("SELECT COUNT(sc) FROM SalaryComponentEntity sc WHERE sc.deleted = true")
    Long countInactive();

    @Query("SELECT s FROM SalaryComponentEntity s " +
            "WHERE s.deleted = false " +
            "AND (:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:type IS NULL OR s.type = :type) " +
            "AND (:isPercentage IS NULL OR s.isPercentage = :isPercentage)")
    List<SalaryComponentEntity> search(
            @Param("name") String name,
            @Param("type") ComponentType type,
            @Param("isPercentage") Boolean isPercentage
    );
}
