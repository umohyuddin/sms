package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.StandardSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StandardSubjectRepository extends JpaRepository<StandardSubjectEntity, Long> {

    List<StandardSubjectEntity> findByStandard_Id(Long standardId);

    List<StandardSubjectEntity> findBySubject_Id(Long subjectId);

    Optional<StandardSubjectEntity> findByStandard_IdAndSubject_Id(Long standardId, Long subjectId);

    boolean existsByStandard_IdAndSubject_Id(Long standardId, Long subjectId);
}
