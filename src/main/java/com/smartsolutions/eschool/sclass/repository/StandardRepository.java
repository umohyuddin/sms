package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository

public interface StandardRepository extends JpaRepository<StandardEntity,Long> {
    Optional<StandardEntity> findByIdAndDeletedFalse(Long id);
    List<StandardEntity> findByDeletedFalse();

    List<StandardEntity> findByCampusIdAndDeletedFalse(Long instituteId);
    // Find all campuses by institute ID
    List<StandardEntity> findByCampusId(Long instituteId);

    // Find a campus by its name WHERE Standard_name LIKE %?%
    List<StandardEntity> findByStandardNameContainingAndDeletedFalse(String campusName);
}
