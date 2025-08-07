package com.smartsolutions.eschool.school.service;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteDao;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstituteService {

    private final InstituteDao nInstituteDao;

    public InstituteService(InstituteDao pInstituteDao) {
        this.nInstituteDao = pInstituteDao;
    }

    public List<InstituteEntity> getAll() {
        return nInstituteDao.findAll();
    }

    public InstituteEntity getById(Long id) {
        return nInstituteDao.findById(id);
    }

    public String create(InstituteEntity pInstituteEntity) {
        return nInstituteDao.save(pInstituteEntity) == 1 ? "Institute created" : "Error creating Institute";
    }

    public String update(InstituteEntity pInstituteEntity) {
        return nInstituteDao.update(pInstituteEntity) == 1 ? "Institute updated" : "Error updating Institute";
    }

    public String delete(Long id) {
        return nInstituteDao.delete(id) == 1 ? "Institute deleted" : "Error deleting Institute";
    }
}
