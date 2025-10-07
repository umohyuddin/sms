package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.MCQEntity;
import com.smartsolutions.eschool.sclass.repository.MCQDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCQService {
    private final MCQDao nMCQDao;

    public MCQService(MCQDao pMCQDao) {
        this.nMCQDao = pMCQDao;
    }

    public List<MCQEntity> getAll() {
        return nMCQDao.findAll();
    }

    public MCQEntity getById(Long id) {
        return nMCQDao.findById(id);
    }

    public List<MCQEntity> getByChapter(Long id, Long chp) {
        return nMCQDao.findByChapter(id, chp);
    }

    public List<MCQEntity> getBySubjectId(Long id) {
        return nMCQDao.findBySubjectId(id);
    }

    public String create(MCQEntity pMCQEntity) {
        return nMCQDao.save(pMCQEntity) == 1 ? "MCQ created" : "Error creating MCQ";
    }

    public String update(MCQEntity pMCQEntity) {
        return nMCQDao.update(pMCQEntity) == 1 ? "MCQ updated" : "Error updating MCQ";
    }

    public String delete(Long id) {
        return nMCQDao.delete(id) == 1 ? "MCQ deleted" : "Error deleting MCQ";
    }
}
