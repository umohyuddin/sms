package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Long> {
    Optional<SystemUserEntity> findByUsername(String username);

    Optional<SystemUserEntity> findByEmail(String email);
}