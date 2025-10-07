package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.repository.SectionDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    private final SectionDao nSectionDao;

    public SectionService(SectionDao pSectionDao) {
        this.nSectionDao = pSectionDao;
    }

    public List<SectionEntity> getAll() {
        return nSectionDao.findAll();
    }

    public SectionEntity getById(Long id) {
        return nSectionDao.findById(id);
    }

    public List<SectionEntity> getByInstituteId(Long id) {
        return nSectionDao.findByInstituteId(id);
    }

    public List<SectionEntity> getByCampusId(Long id) {
        return nSectionDao.findByCampusId(id);
    }

    public List<SectionEntity> getByClassId(Long id) {
        return nSectionDao.findByClassId(id);
    }

    public String create(SectionEntity pSectionEntity) {
        return nSectionDao.save(pSectionEntity) == 1 ? "Section created" : "Error creating Section";
    }

    public String update(SectionEntity pSectionEntity) {
        return nSectionDao.update(pSectionEntity) == 1 ? "Section updated" : "Error updating Section";
    }

    public String delete(Long id) {
        return nSectionDao.delete(id) == 1 ? "Section deleted" : "Error deleting Section";
    }
}
