package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Long> {
    Optional<SystemUserEntity> findByUsername(String username);

    Optional<SystemUserEntity> findByEmail(String email);

    boolean existsByEmail(String email);
    
    boolean existsByUsername(String username);
    
    boolean existsByStudentId(Long studentId);
    
    boolean existsByEmployeeId(Long employeeId);
    
    Optional<SystemUserEntity> findByStudentId(Long studentId);
    
    Optional<SystemUserEntity> findByEmployeeId(Long employeeId);

    @org.springframework.data.jpa.repository.Query("""
            SELECT u FROM SystemUserEntity u
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(u.phone) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND u.isActive = true
            """)
    java.util.List<SystemUserEntity> searchByKeyword(@org.springframework.data.repository.query.Param("keyword") String keyword);
}