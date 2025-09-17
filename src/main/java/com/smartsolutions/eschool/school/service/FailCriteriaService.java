package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.FailCriteriaEntity;
import com.smartsolutions.eschool.school.repository.FailCriteriaDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailCriteriaService {
    private final FailCriteriaDao nFailCriteriaDao;

    public FailCriteriaService(FailCriteriaDao pFailCriteriaDao) {
        this.nFailCriteriaDao = pFailCriteriaDao;
    }

    public List<FailCriteriaEntity> getAll() {
        return nFailCriteriaDao.findAll();
    }

    public List<FailCriteriaEntity> getByInstitute(Long id) {
        return nFailCriteriaDao.findByInstitute(id);
    }

    public FailCriteriaEntity getById(Long id) {
        return nFailCriteriaDao.findById(id);
    }

    public String create(FailCriteriaEntity pFailCriteriaEntity) {
        return nFailCriteriaDao.save(pFailCriteriaEntity) == 1 ? "FailCriteria created" : "Error creating FailCriteria";
    }

    public String update(FailCriteriaEntity pFailCriteriaEntity) {
        return nFailCriteriaDao.update(pFailCriteriaEntity) == 1 ? "FailCriteria updated" : "Error updating FailCriteria";
    }

    public String delete(Long id) {
        return nFailCriteriaDao.delete(id) == 1 ? "FailCriteria deleted" : "Error deleting FailCriteria";
    }
}
