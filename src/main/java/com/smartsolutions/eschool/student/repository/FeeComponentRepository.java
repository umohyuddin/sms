package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FeeComponentRepository extends JpaRepository<FeeComponentEntity, Long> {

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.chargeType ct
        LEFT JOIN FETCH catalog.recurrenceRule rr
        JOIN FETCH catalog.institute inst
        LEFT JOIN FETCH fc.feeRates rates
        ORDER BY fc.componentName
    """)
    List<FeeComponentEntity> findAllWithDetails();


    // ============================
    // GET COMPONENT BY ID WITH DETAILS
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.chargeType ct
        LEFT JOIN FETCH catalog.recurrenceRule rr
        JOIN FETCH catalog.institute inst
        LEFT JOIN FETCH fc.feeRates rates
        WHERE fc.id = :id
        AND fc.deleted = false
    """)
    Optional<FeeComponentEntity> findByIdWithDetails(@Param("id") Long id);


    // ============================
    // GET COMPONENTS BY CATALOG
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.chargeType ct
        LEFT JOIN FETCH catalog.recurrenceRule rr
        LEFT JOIN FETCH fc.feeRates rates
        WHERE catalog.id = :catalogId
        AND fc.deleted = false
        AND catalog.deleted = false
        ORDER BY fc.componentName
    """)
    List<FeeComponentEntity> findByCatalogIdWithDetails(@Param("catalogId") Long catalogId);



    // ============================
    // GET COMPONENTS BY ORGANIZATION
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.institute inst
        JOIN FETCH catalog.chargeType ct
        LEFT JOIN FETCH catalog.recurrenceRule rr
        WHERE inst.id = :organizationId
        AND fc.deleted = false
        AND catalog.deleted = false
        ORDER BY fc.componentName
    """)
    List<FeeComponentEntity> findByOrganization(@Param("organizationId") Long organizationId);


    // ============================
    // SEARCH COMPONENT
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.chargeType ct
        LEFT JOIN FETCH catalog.recurrenceRule rr
        WHERE fc.deleted = false
        AND catalog.deleted = false
        AND (:catalogId IS NULL OR catalog.id = :catalogId)
        AND (
            :keyword IS NULL OR :keyword = '' OR
            LOWER(fc.componentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
            LOWER(fc.componentCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
        )
        ORDER BY fc.componentName
    """)
    List<FeeComponentEntity> searchComponents(
            @Param("catalogId") Long catalogId,
            @Param("keyword") String keyword
    );


    // ============================
    // FILTER BY CHARGE TYPE
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        JOIN FETCH catalog.chargeType ct
        WHERE ct.id = :chargeTypeId
        AND fc.deleted = false
        AND catalog.deleted = false
    """)
    List<FeeComponentEntity> findByChargeType(@Param("chargeTypeId") Long chargeTypeId);

    // ============================
    // FILTER BY RECURRENCE RULE
    // ============================

    @Query("""
        SELECT DISTINCT fc
        FROM FeeComponentEntity fc
        JOIN FETCH fc.feeCatalog catalog
        LEFT JOIN FETCH catalog.recurrenceRule rr
        WHERE rr.id = :ruleId
        AND fc.deleted = false
        AND catalog.deleted = false
    """)
    List<FeeComponentEntity> findByRecurrenceRule(@Param("ruleId") Long ruleId);


    // JPQL query to find duplicate component code in the same catalog
    @Query("SELECT f FROM FeeComponentEntity f WHERE f.componentCode = :code AND f.feeCatalog.id = :catalogId AND f.deleted = false")
    Optional<FeeComponentEntity> findByComponentCodeAndCatalogId(
            @Param("code") String componentCode,
            @Param("catalogId") Long feeCatalogId
    );
}



