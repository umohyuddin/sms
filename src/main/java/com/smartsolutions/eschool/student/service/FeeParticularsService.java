package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.student.model.FeeParticularsEntity;
import com.smartsolutions.eschool.student.repository.FeeParticularsDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeeParticularsService {

    private final FeeParticularsDao nFeeParticularsDao;
    public FeeParticularsService(FeeParticularsDao pFeeParticularsDao) {
        this.nFeeParticularsDao = pFeeParticularsDao;
    }

    public List<FeeParticularsEntity> getAll() {
        return nFeeParticularsDao.findAll();
    }

    public FeeParticularsEntity getById(Long id) {
        return nFeeParticularsDao.findById(id);
    }
    public List<FeeParticularsEntity> getByInstitute(Long id) {
        return nFeeParticularsDao.findByInstitute(id);
    }


    public String create(FeeParticularsEntity pFeeParticularsEntity) {
        return nFeeParticularsDao.save(pFeeParticularsEntity) == 1 ? "FeeParticulars created" : "Error creating FeeParticulars";
    }

    public String update(FeeParticularsEntity pFeeParticularsEntity) {
        return nFeeParticularsDao.update(pFeeParticularsEntity) == 1 ? "FeeParticulars updated" : "Error updating FeeParticulars";
    }

    public String delete(Long id) {
        return nFeeParticularsDao.delete(id) == 1 ? "FeeParticulars deleted" : "Error deleting FeeParticulars";
    }
}
