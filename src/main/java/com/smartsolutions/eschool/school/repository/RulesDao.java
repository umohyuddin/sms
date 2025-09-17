package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.RulesEntity;

import java.util.List;

public interface RulesDao {
    int save(RulesEntity pRulesEntity);
    int update(RulesEntity pRulesEntity);
    int delete(Long id);
    RulesEntity findByInstitute(Long id);
}
