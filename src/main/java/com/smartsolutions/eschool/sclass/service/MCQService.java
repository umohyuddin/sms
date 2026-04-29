package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.MCQEntity;
import com.smartsolutions.eschool.sclass.repository.MCQRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MCQService {
    private final MCQRepository mcqRepository;

    public MCQService(MCQRepository mcqRepository) {
        this.mcqRepository = mcqRepository;
    }

    public List<MCQEntity> getAll() {
        return mcqRepository.findAll();
    }

    public MCQEntity getById(Long id) {
        return mcqRepository.findById(id).orElse(null);
    }

    public List<MCQEntity> getByChapter(Integer id, Integer chp) {
        return mcqRepository.findByChapter(id, chp);
    }

    public List<MCQEntity> getBySubjectId(Integer id) {
        return mcqRepository.findBySubjectId(id);
    }

    @Transactional
    public String create(MCQEntity pMCQEntity) {
        mcqRepository.save(pMCQEntity);
        return "MCQ created";
    }

    @Transactional
    public String update(MCQEntity pMCQEntity) {
        mcqRepository.save(pMCQEntity);
        return "MCQ updated";
    }

    @Transactional
    public String delete(Long id) {
        mcqRepository.deleteById(id);
        return "MCQ deleted";
    }
}
