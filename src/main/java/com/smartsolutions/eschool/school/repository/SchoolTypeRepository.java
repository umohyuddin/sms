package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.SchoolTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolTypeEntity, Long> {

    @Query("""
            SELECT s FROM SchoolTypeEntity s
            WHERE s.id = :id
            """)
    Optional<SchoolTypeEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT s FROM SchoolTypeEntity s
            """)
    List<SchoolTypeEntity> findAllJpql();

    @Query("""
            SELECT s FROM SchoolTypeEntity s
            WHERE s.isActive = true
            """)
    List<SchoolTypeEntity> findAllActive();

    @Query("""
            SELECT s FROM SchoolTypeEntity s
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(s.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(s.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<SchoolTypeEntity> searchByKeyword(@Param("keyword") String keyword);
}
