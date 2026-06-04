package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.SchoolTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolTypeEntity, Long> {

    @Query("SELECT s FROM SchoolTypeEntity s")
    List<SchoolTypeEntity> findAllGlobal();

    @Query("SELECT s FROM SchoolTypeEntity s WHERE s.active = true")
    List<SchoolTypeEntity> findAllActiveGlobal();

    @Query("""
            SELECT s FROM SchoolTypeEntity s
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(s.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(s.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<SchoolTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("UPDATE SchoolTypeEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT (COUNT(s) > 0) FROM SchoolTypeEntity s WHERE s.code = :code")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(s) > 0) FROM SchoolTypeEntity s WHERE s.code = :code AND s.id <> :id")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);

    @Query("SELECT COUNT(s) FROM SchoolTypeEntity s")
    Long countAll();

    @Query("SELECT COUNT(s) FROM SchoolTypeEntity s WHERE s.active = true")
    Long countActive();

    @Query("SELECT COUNT(s) FROM SchoolTypeEntity s WHERE s.active = false")
    Long countInactive();
}


