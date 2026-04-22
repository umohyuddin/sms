package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query("SELECT d FROM DepartmentEntity d WHERE d.organizationId = :orgId AND d.campus.id = :campusId")
    List<DepartmentEntity> findByOrganizationAndCampus(@Param("orgId") Long orgId, @Param("campusId") Long campusId);

    @Query("SELECT d FROM DepartmentEntity d WHERE d.id = :id AND d.organizationId = :orgId AND d.campus.id = :campusId")
    Optional<DepartmentEntity> findByIdAndOrganizationAndCampus(@Param("id") Long id, @Param("orgId") Long orgId, @Param("campusId") Long campusId);

    @Query("SELECT d FROM DepartmentEntity d WHERE d.id = :id AND d.organizationId = :orgId")
    Optional<DepartmentEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("orgId") Long orgId);

    @Query("SELECT d FROM DepartmentEntity d WHERE d.organizationId = :orgId AND d.campus.id = :campusId AND d.active = true")
    List<DepartmentEntity> findAllActive(@Param("orgId") Long orgId, @Param("campusId") Long campusId);

    @Query("SELECT d FROM DepartmentEntity d WHERE d.organizationId = :orgId AND d.campus.id = :campusId " +
           "AND (LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(d.departmentCode) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<DepartmentEntity> searchByKeyword(@Param("keyword") String keyword, @Param("orgId") Long orgId, @Param("campusId") Long campusId);

    @Query("SELECT COUNT(d) > 0 FROM DepartmentEntity d WHERE d.departmentCode = :code AND d.organizationId = :orgId AND d.campus.id = :campusId")
    boolean existsByCodeAndOrganizationAndCampus(@Param("code") String code, @Param("orgId") Long orgId, @Param("campusId") Long campusId);

    @Query("SELECT COUNT(d) > 0 FROM DepartmentEntity d WHERE d.departmentCode = :code AND d.organizationId = :orgId AND d.campus.id = :campusId AND d.id <> :id")
    boolean existsByCodeAndOrganizationAndCampusAndIdNot(@Param("code") String code, @Param("orgId") Long orgId, @Param("campusId") Long campusId, @Param("id") Long id);

    @Query("SELECT d FROM DepartmentEntity d WHERE d.parentDepartment.id = :parentId AND d.organizationId = :orgId AND d.campus.id = :campusId")
    List<DepartmentEntity> findByParentDepartmentId(@Param("parentId") Long parentId, @Param("orgId") Long orgId, @Param("campusId") Long campusId);
}
