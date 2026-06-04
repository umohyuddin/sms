package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentGuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentGuardianRepository extends JpaRepository<StudentGuardianEntity, Long> {

    List<StudentGuardianEntity> findByStudentIdAndOrganizationId(Long studentId, Long organizationId);

    List<StudentGuardianEntity> findByGuardianIdAndOrganizationId(Long guardianId, Long organizationId);

    Optional<StudentGuardianEntity> findByStudentIdAndGuardianIdAndOrganizationId(Long studentId, Long guardianId, Long organizationId);

    boolean existsByStudentIdAndGuardianIdAndOrganizationId(Long studentId, Long guardianId, Long organizationId);

    @Query("SELECT sg FROM StudentGuardianEntity sg WHERE sg.studentId = :studentId AND sg.organizationId = :organizationId AND sg.deleted = false")
    List<StudentGuardianEntity> findActiveByStudentIdAndOrganizationId(@Param("studentId") Long studentId, @Param("organizationId") Long organizationId);

    @Query("SELECT sg FROM StudentGuardianEntity sg WHERE sg.guardianId = :guardianId AND sg.organizationId = :organizationId AND sg.deleted = false")
    List<StudentGuardianEntity> findActiveByGuardianIdAndOrganizationId(@Param("guardianId") Long guardianId, @Param("organizationId") Long organizationId);
}