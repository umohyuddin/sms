package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query("SELECT d FROM DepartmentEntity d JOIN FETCH d.campus c JOIN FETCH d.departmentType dt LEFT JOIN FETCH d.parent p LEFT JOIN FETCH d.headEmployee h WHERE d.organizationId = :organizationId")
    List<DepartmentEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DepartmentEntity d JOIN FETCH d.campus c JOIN FETCH d.departmentType dt LEFT JOIN FETCH d.parent p LEFT JOIN FETCH d.headEmployee h WHERE d.campus.id = :campusId AND d.organizationId = :organizationId")
    List<DepartmentEntity> findByCampusIdAndOrganizationId(@Param("campusId") Long campusId, @Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DepartmentEntity d JOIN FETCH d.campus c JOIN FETCH d.departmentType dt LEFT JOIN FETCH d.parent p LEFT JOIN FETCH d.headEmployee h WHERE d.id = :id AND d.organizationId = :organizationId")
    Optional<DepartmentEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT d FROM DepartmentEntity d JOIN FETCH d.campus c JOIN FETCH d.departmentType dt WHERE (d.departmentName LIKE %:keyword% OR d.departmentCode LIKE %:keyword%) AND d.organizationId = :organizationId")
    List<DepartmentEntity> searchByKeywordAndOrganizationId(@Param("keyword") String keyword, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE DepartmentEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP WHERE d.id = :id AND d.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("SELECT (COUNT(d) > 0) FROM DepartmentEntity d WHERE d.organizationId = :organizationId AND d.campus.id = :campusId AND d.departmentCode = :code AND d.deleted = false")
    boolean existsByOrganizationIdAndCampusIdAndDepartmentCode(@Param("organizationId") Long organizationId, @Param("campusId") Long campusId, @Param("code") String code);

    @Query("SELECT (COUNT(d) > 0) FROM DepartmentEntity d WHERE d.organizationId = :organizationId AND d.campus.id = :campusId AND d.departmentName = :name AND d.deleted = false")
    boolean existsByOrganizationIdAndCampusIdAndDepartmentName(@Param("organizationId") Long organizationId, @Param("campusId") Long campusId, @Param("name") String name);

    @Query("SELECT COUNT(d) FROM DepartmentEntity d WHERE d.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(d) FROM DepartmentEntity d WHERE d.organizationId = :organizationId AND d.active = true")
    Long countByOrganizationIdAndActiveTrue(@Param("organizationId") Long organizationId);
}
