package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.ExamTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamTypeEntity, Long> {

    @Query("SELECT et FROM ExamTypeEntity et WHERE et.organizationId = :orgId AND et.deleted = false")
    List<ExamTypeEntity> findAllActiveByOrg(@Param("orgId") Long orgId);

    @Modifying
    @Query("UPDATE ExamTypeEntity et SET et.deleted = true, et.deletedAt = CURRENT_TIMESTAMP WHERE et.id = :id")
    void softDeleteById(@Param("id") Long id);
}
