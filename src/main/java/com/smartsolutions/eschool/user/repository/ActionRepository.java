package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {

    @Query("""
            SELECT a
            FROM ActionEntity a
            WHERE a.id = :id
              AND a.deleted = false
            """)
    Optional<ActionEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT a
            FROM ActionEntity a
            WHERE a.active = true
              AND a.deleted = false
            ORDER BY a.name ASC
            """)
    List<ActionEntity> findAllActive();

    @Query("""
            SELECT a
            FROM ActionEntity a
            WHERE a.deleted = false
            ORDER BY a.name ASC
            """)
    List<ActionEntity> findAllNotDeleted();

    @Query("""
            SELECT a
            FROM ActionEntity a
            WHERE (LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(a.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND a.deleted = false
            ORDER BY a.name ASC
            """)
    List<ActionEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE ActionEntity a
            SET a.deleted = true,
                a.deletedAt = CURRENT_TIMESTAMP
            WHERE a.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(a) FROM ActionEntity a WHERE a.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(a) FROM ActionEntity a WHERE a.active = true AND a.deleted = false")
    Long countByActiveTrue();

    @Query("SELECT COUNT(a) FROM ActionEntity a WHERE a.active = false AND a.deleted = false")
    Long countByActiveFalse();

    @Query("SELECT (COUNT(a) > 0) FROM ActionEntity a WHERE a.code = :code AND a.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(a) > 0) FROM ActionEntity a WHERE a.code = :code AND a.id <> :id AND a.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
