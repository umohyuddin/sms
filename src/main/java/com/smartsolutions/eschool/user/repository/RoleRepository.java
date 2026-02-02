package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("""
            SELECT r FROM RoleEntity r
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(r.roleName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<RoleEntity> searchByKeyword(@Param("keyword") String keyword);
}
