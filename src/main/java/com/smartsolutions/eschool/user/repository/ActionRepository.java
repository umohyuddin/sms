package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    
    @Query("SELECT a FROM ActionEntity a WHERE a.deleted = false")
    List<ActionEntity> findAllNotDeleted();

    @Query("SELECT a FROM ActionEntity a WHERE " +
           "(LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(a.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(a.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
           "AND a.deleted = false")
    List<ActionEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT a FROM ActionEntity a WHERE a.id = :id AND a.deleted = false")
    Optional<ActionEntity> findByIdNotDeleted(@Param("id") Long id);

    Optional<ActionEntity> findByCode(String code);
}
