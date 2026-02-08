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

    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE sc.id = :id")
    Optional<SalaryComponentEntity> findById(@Param("id") Long id);

    @Query("SELECT sc FROM SalaryComponentEntity sc ORDER BY sc.name ASC")
    List<SalaryComponentEntity> findAllNonDeleted();

    @Query("SELECT sc FROM SalaryComponentEntity sc WHERE LOWER(sc.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SalaryComponentEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT s FROM SalaryComponentEntity s " +
            "WHERE (:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:type IS NULL OR s.type = :type) " +
            "AND (:isPercentage IS NULL OR s.isPercentage = :isPercentage)")
    List<SalaryComponentEntity> search(
            @Param("name") String name,
            @Param("type") ComponentType type,
            @Param("isPercentage") Boolean isPercentage
    );

    @Modifying
    @Query("UPDATE SalaryComponentEntity sc SET sc.deleted = true WHERE sc.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(sc) FROM SalaryComponentEntity sc")
    Long countAll();
}
