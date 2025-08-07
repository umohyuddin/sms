package com.smartsolutions.eschool.school.service;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.CampusDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService {

    private final CampusDao nCampusDao;

    public CampusService(CampusDao pCampusDao) {
        this.nCampusDao = pCampusDao;
    }


    public List<CampusEntity> getAll() {
        return nCampusDao.findAll();
    }

    public CampusEntity getById(Long id) {
        return nCampusDao.findById(id);
    }

    public String create(CampusEntity pCampusEntity) {
        return nCampusDao.save(pCampusEntity) == 1 ? "Campus created" : "Error creating Campus";
    }

    public String update(CampusEntity pCampusEntity) {
        return nCampusDao.update(pCampusEntity) == 1 ? "Campus updated" : "Error updating Campus";
    }

    public String delete(Long id) {
        return nCampusDao.delete(id) == 1 ? "Campus deleted" : "Error deleting Campus";
    }
}
