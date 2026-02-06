package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

    @Query("""
            SELECT m FROM ModuleEntity m
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(m.code) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(m.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND m.deleted = false
            """)
    List<ModuleEntity> searchByKeyword(@Param("keyword") String keyword);

    List<ModuleEntity> findByActiveTrueAndDeletedFalseOrderByDisplayOrderAsc();
}
