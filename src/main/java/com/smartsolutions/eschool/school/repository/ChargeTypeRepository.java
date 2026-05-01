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

    @Query("SELECT c FROM ChargeTypeEntity c")
    List<ChargeTypeEntity> findAllChargeTypes();

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.active = true")
    List<ChargeTypeEntity> findAllActiveChargeTypes();

    @Query("SELECT c FROM ChargeTypeEntity c WHERE c.id = :id")
    Optional<ChargeTypeEntity> findByIdAndActiveTrue(@Param("id") Long id);

    @Query("SELECT c FROM ChargeTypeEntity c WHERE " +
            "(LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.code) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<ChargeTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.code = :code")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.name = :name")
    boolean existsByName(@Param("name") String name);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.code = :code AND c.id != :id")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);

    @Query("SELECT (COUNT(c) > 0) FROM ChargeTypeEntity c WHERE c.name = :name AND c.id != :id")
    boolean existsByNameAndIdNot(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c")
    Long countAllChargeTypes();

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c WHERE c.active = true")
    Long countByActiveTrue();

    @Query("SELECT COUNT(c) FROM ChargeTypeEntity c WHERE c.active = false")
    Long countByActiveFalse();
}
