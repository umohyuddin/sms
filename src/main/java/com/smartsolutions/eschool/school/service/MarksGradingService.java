package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.MarksGradingEntity;
import com.smartsolutions.eschool.school.repository.MarksGradingDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksGradingService {
    private final MarksGradingDao nMarksGradingDao;

    public MarksGradingService(MarksGradingDao pMarksGradingDao) {
        this.nMarksGradingDao = pMarksGradingDao;
    }

    public List<MarksGradingEntity> getAll() {
        return nMarksGradingDao.findAll();
    }

    public List<MarksGradingEntity> getByInstitute(Long id) {
        return nMarksGradingDao.findByInstitute(id);
    }

    public MarksGradingEntity getById(Long id) {
        return nMarksGradingDao.findById(id);
    }

    public String create(MarksGradingEntity pMarksGradingEntity) {
        return nMarksGradingDao.save(pMarksGradingEntity) == 1 ? "MarksGrading created" : "Error creating MarksGrading";
    }

    public String update(MarksGradingEntity pMarksGradingEntity) {
        return nMarksGradingDao.update(pMarksGradingEntity) == 1 ? "MarksGrading updated" : "Error updating MarksGrading";
    }

    public String delete(Long id) {
        return nMarksGradingDao.delete(id) == 1 ? "MarksGrading deleted" : "Error deleting MarksGrading";
    }
}
