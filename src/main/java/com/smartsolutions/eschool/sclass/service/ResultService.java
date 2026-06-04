package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.ResultEntity;
import com.smartsolutions.eschool.sclass.repository.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<ResultEntity> getAll() {
        return resultRepository.findAll();
    }

    public ResultEntity getById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    public List<ResultEntity> getByClassId(Integer id) {
        return resultRepository.findByClsId(id);
    }

    public List<ResultEntity> getBySubjectId(Integer id) {
        return resultRepository.findBySubjectId(id);
    }

    public List<ResultEntity> getByStudentId(Long id) {
        return resultRepository.findByStudentId(id);
    }

    @Transactional
    public String create(ResultEntity pResultEntity) {
        resultRepository.save(pResultEntity);
        return "result created";
    }

    @Transactional
    public String update(ResultEntity pResultEntity) {
        resultRepository.save(pResultEntity);
        return "result updated";
    }

    @Transactional
    public String delete(Long id) {
        resultRepository.deleteById(id);
        return "result deleted";
    }
}
