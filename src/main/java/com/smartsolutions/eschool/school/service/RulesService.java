package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.RulesEntity;
import com.smartsolutions.eschool.school.repository.RulesDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RulesService {
    private final RulesDao nRulesDao;

    public RulesService(RulesDao pRulesDao) {
        this.nRulesDao = pRulesDao;
    }

    public RulesEntity getByInstitute(Long id) {
        return nRulesDao.findByInstitute(id);
    }

    public String create(RulesEntity pRulesEntity) {
        return nRulesDao.save(pRulesEntity) == 1 ? "Rules created" : "Error creating Rules";
    }

    public String update(RulesEntity pRulesEntity) {
        return nRulesDao.update(pRulesEntity) == 1 ? "Rules updated" : "Error updating Rules";
    }

    public String delete(Long id) {
        return nRulesDao.delete(id) == 1 ? "Rules deleted" : "Error deleting Rules";
    }
}
