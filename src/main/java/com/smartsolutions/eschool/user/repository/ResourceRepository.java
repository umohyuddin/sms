package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    @Query("""
            SELECT r FROM ResourceEntity r
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(r.resourceName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.owner) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND r.deleted = false
            """)
    List<ResourceEntity> searchByKeyword(@Param("keyword") String keyword);
}
