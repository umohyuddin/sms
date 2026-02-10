package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

    @Query("SELECT s FROM SubjectEntity s JOIN FETCH s.subjectGroup WHERE s.id = :id AND s.deleted = false")
    Optional<SubjectEntity> findActiveById(@Param("id") Long id);

    @Query("SELECT s FROM SubjectEntity s JOIN FETCH s.subjectGroup WHERE s.organizationId = :orgId AND s.deleted = false AND s.active = true")
    List<SubjectEntity> findAllActiveByOrg(@Param("orgId") Long orgId);

    @Query("SELECT s FROM SubjectEntity s JOIN FETCH s.subjectGroup sg WHERE sg.id = :groupId AND s.deleted = false")
    List<SubjectEntity> findByGroupId(@Param("groupId") Long groupId);

    @Modifying
    @Query("UPDATE SubjectEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP WHERE s.id = :id")
    void softDeleteById(@Param("id") Long id);
}
