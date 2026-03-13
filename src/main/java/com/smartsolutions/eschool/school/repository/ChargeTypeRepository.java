package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChargeTypeRepository extends JpaRepository<ChargeTypeEntity, Long> {

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId")
    List<ChargeTypeEntity> findAllByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.active = true")
    List<ChargeTypeEntity> findAllActiveByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.id = :id AND c.organizationId = :organizationId")
    Optional<ChargeTypeEntity> findByIdAndOrganizationId(@Param("id") Long id,
            @Param("organizationId") Long organizationId);

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND " +
            "(LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<ChargeTypeEntity> searchByKeyword(@Param("organizationId") Long organizationId,
            @Param("keyword") String keyword);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.code = :code")
    boolean existsByOrganizationIdAndCode(@Param("organizationId") Long organizationId, @Param("code") String code);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.name = :name")
    boolean existsByOrganizationIdAndName(@Param("organizationId") Long organizationId, @Param("name") String name);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.code = :code AND c.id != :id")
    boolean existsByOrganizationIdAndCodeAndIdNot(@Param("organizationId") Long organizationId,
            @Param("code") String code, @Param("id") Long id);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.name = :name AND c.id != :id")
    boolean existsByOrganizationIdAndNameAndIdNot(@Param("organizationId") Long organizationId, @Param("name") String name, @Param("id") Long id);

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId")
    Long countByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.active = true")
    Long countByOrganizationIdAndActiveTrue(@Param("organizationId") Long organizationId);

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c WHERE c.organizationId = :organizationId AND c.active = false")
    Long countByOrganizationIdAndActiveFalse(@Param("organizationId") Long organizationId);
}
