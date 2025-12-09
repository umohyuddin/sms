package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AdmissionTypeRepository extends JpaRepository<AdmissionTypeEntity, Long> {
    @Query("SELECT a FROM AdmissionTypeEntity a WHERE a.deleted = false")
    List<AdmissionTypeEntity> getAllActiveAdmissionTypes();


}
