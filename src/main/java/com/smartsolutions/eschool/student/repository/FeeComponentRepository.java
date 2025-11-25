package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
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

    @Query("SELECT fc FROM FeeComponentEntity fc " +
            "WHERE fc.deleted = false")
    List<FeeComponentEntity> findByDeletedFalse();

    @Query("SELECT fc FROM FeeComponentEntity fc " +
            "WHERE fc.deleted = false AND fc.id=:id")
    Optional<FeeComponentEntity> findByIdAndDeletedFalse(@Param("id") Long id);


    @Query("SELECT f FROM FeeComponentEntity f " +
            "WHERE (" +
            "LOWER(f.componentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.componentCode) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            ") AND f.deleted = false")
    List<FeeComponentEntity> searchFeeComponent(@Param("keyword") String keyword);


    @Query("SELECT fc FROM FeeComponentEntity fc " +
            "WHERE fc.feeCatalog.id = :catalogId " +
            "AND fc.feeCatalog.deleted = false")
    List<FeeComponentEntity> findFeeComponentsByCatalogId(@Param("catalogId") Long catalogId);
}


