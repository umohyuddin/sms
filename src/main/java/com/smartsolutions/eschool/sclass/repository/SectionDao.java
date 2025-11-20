package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectionDao {
    int save(SectionEntity sectionEntity);
    int update(SectionEntity sectionEntity);
    int delete(Long id);

    SectionEntity findById(Long id);

    //@Query("SELECT s FROM SectionEntity s LEFT JOIN FETCH s.standard")
    List<SectionEntity> findAll();

    List<SectionEntity> findByClassId(Long id);
    List<SectionEntity> findByCampusId(Long id);
    List<SectionEntity> findByInstituteId(Long id);
}
