package com.smartsolutions.eschool.sclass.service;
import com.smartsolutions.eschool.sclass.model.ResultEntity;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.repository.ResultDao;
import com.smartsolutions.eschool.sclass.repository.SClassDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    private final ResultDao nResultDao;

    public ResultService(ResultDao pResultDao) {
        this.nResultDao = pResultDao;
    }

    public List<ResultEntity> getAll() {
        return nResultDao.findAll();
    }

    public ResultEntity getById(Long id) {
        return nResultDao.findById(id);
    }

    public List<ResultEntity> getByClassId(Long id) {
        return nResultDao.findByClassId(id);
    }

    public List<ResultEntity> getBySubjectId(Long id) {
        return nResultDao.findBySubjectId(id);
    }

    public List<ResultEntity> getByStudentId(Long id) {
        return nResultDao.findByStudentId(id);
    }

    public String create(ResultEntity pResultEntity) {
        return nResultDao.save(pResultEntity) == 1 ? "result created" : "Error creating result";
    }

    public String update(ResultEntity pResultEntity) {
        return nResultDao.update(pResultEntity) == 1 ? "result updated" : "Error updating result";
    }

    public String delete(Long id) {
        return nResultDao.delete(id) == 1 ? "result deleted" : "Error deleting result";
    }
}
