package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.student.repository.FeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    private final FeeDao feeDao;
    public FeeService(FeeDao pFeeDao) {
        this.feeDao = pFeeDao;
    }

    public List<FeeEntity> getAll() {
        return feeDao.findAll();
    }

    public FeeEntity getById(Long id) {
        return feeDao.findById(id);
    }
    public List<FeeEntity> getByStudent(Long std_id) {
        return feeDao.findByStudent(std_id);
    }


    public String create(FeeEntity pFeeEntity) {
        return feeDao.save(pFeeEntity) == 1 ? "Fee created" : "Error creating Fee";
    }

    public String update(FeeEntity pFeeEntity) {
        return feeDao.update(pFeeEntity) == 1 ? "Fee updated" : "Error updating Fee";
    }

    public String delete(Long id) {
        return feeDao.delete(id) == 1 ? "Fee deleted" : "Error deleting Fee";
    }
}
