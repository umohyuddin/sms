package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

    @Query("""
            SELECT m
            FROM ModuleEntity m
            WHERE m.id = :id
              AND m.deleted = false
            """)
    Optional<ModuleEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT m
            FROM ModuleEntity m
            WHERE m.active = true
              AND m.deleted = false
            ORDER BY m.displayOrder ASC, m.name ASC
            """)
    List<ModuleEntity> findAllActive();

    @Query("""
            SELECT m
            FROM ModuleEntity m
            WHERE m.deleted = false
            ORDER BY m.displayOrder ASC, m.name ASC
            """)
    List<ModuleEntity> findAllNotDeleted();

    @Query("""
            SELECT m
            FROM ModuleEntity m
            WHERE (LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(m.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND m.deleted = false
            ORDER BY m.displayOrder ASC, m.name ASC
            """)
    List<ModuleEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE ModuleEntity m
            SET m.deleted = true,
                m.deletedAt = CURRENT_TIMESTAMP
            WHERE m.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(m) FROM ModuleEntity m WHERE m.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(m) FROM ModuleEntity m WHERE m.active = true AND m.deleted = false")
    Long countByActiveTrue();

    @Query("SELECT COUNT(m) FROM ModuleEntity m WHERE m.active = false AND m.deleted = false")
    Long countByActiveFalse();

    @Query("SELECT (COUNT(m) > 0) FROM ModuleEntity m WHERE m.code = :code AND m.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(m) > 0) FROM ModuleEntity m WHERE m.code = :code AND m.id <> :id AND m.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
