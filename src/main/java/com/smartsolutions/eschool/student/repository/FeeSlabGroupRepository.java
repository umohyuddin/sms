package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeSlabGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FeeSlabGroupRepository extends JpaRepository<FeeSlabGroupEntity, Long> {

    @Query("""
            SELECT fsg FROM FeeSlabGroupEntity fsg
            LEFT JOIN FETCH fsg.feeComponent fc
            WHERE fsg.deleted = false
            """)
    List<FeeSlabGroupEntity> findByDeletedFalse();

    @Query("SELECT fsg FROM FeeSlabGroupEntity fsg LEFT JOIN FETCH fsg.feeComponent fc WHERE fsg.deleted = false AND fsg.id=:id")
    Optional<FeeSlabGroupEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT fsg FROM FeeSlabGroupEntity fsg
            LEFT JOIN FETCH fsg.feeComponent fc
            WHERE fsg.deleted = false
              AND (:keyword IS NULL OR
                   LOWER(fsg.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                   LOWER(fsg.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                   LOWER(fc.componentName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                  )
            """)
    List<FeeSlabGroupEntity> searchFeeSlabGroups(@Param("keyword") String keyword);
}
