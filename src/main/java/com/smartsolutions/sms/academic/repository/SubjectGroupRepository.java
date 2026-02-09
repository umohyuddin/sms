package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.master.SubjectGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectGroupRepository extends JpaRepository<SubjectGroupEntity, Long> {

    @Query("SELECT sg FROM SubjectGroupEntity sg WHERE sg.id = :id AND sg.deleted = false")
    Optional<SubjectGroupEntity> findActiveById(@Param("id") Long id);

    @Query("SELECT sg FROM SubjectGroupEntity sg WHERE sg.organizationId = :orgId AND sg.deleted = false AND sg.active = true")
    List<SubjectGroupEntity> findAllActiveByOrg(@Param("orgId") Long orgId);

    @Modifying
    @Query("UPDATE SubjectGroupEntity sg SET sg.deleted = true, sg.deletedAt = CURRENT_TIMESTAMP WHERE sg.id = :id")
    void softDeleteById(@Param("id") Long id);
}
