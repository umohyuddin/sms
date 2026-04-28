package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteBillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteBillingRepository extends JpaRepository<InstituteBillingEntity, Long> {

    @Query("""
            SELECT b FROM InstituteBillingEntity b
            WHERE b.id = :id
            """)
    Optional<InstituteBillingEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT b FROM InstituteBillingEntity b
            WHERE b.institute.id = :instituteId
            """)
    Optional<InstituteBillingEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT b FROM InstituteBillingEntity b
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(b.billingEmail) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.taxNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.currency) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.subscriptionPlan) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.paymentCycle) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteBillingEntity> searchByKeyword(@Param("keyword") String keyword);
}
