package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteRepository extends JpaRepository<InstituteEntity, Long> {

    // Fetch the single institute (singleton)
    default Optional<InstituteEntity> getSingletonInstitute() {
        return findById(1L);
    }
}
