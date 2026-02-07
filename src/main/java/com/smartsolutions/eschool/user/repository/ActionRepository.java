package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    Optional<ActionEntity> findByCode(String code);
}
