package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentDao nDepartmentDao;

    public DepartmentService(DepartmentDao pDepartmentDao) {
        this.nDepartmentDao = pDepartmentDao;
    }


    public List<DepartmentEntity> getAll() {
        return nDepartmentDao.findAll();
    }

    public DepartmentEntity getById(Long id) {
        return nDepartmentDao.findById(id);
    }

    public String create(DepartmentEntity pDepartmentEntity) {
        return nDepartmentDao.save(pDepartmentEntity) == 1 ? "Department created" : "Error creating Department";
    }

    public String update(DepartmentEntity pDepartmentEntity) {
        return nDepartmentDao.update(pDepartmentEntity) == 1 ? "Department updated" : "Error updating Department";
    }

    public String delete(Long id) {
        return nDepartmentDao.delete(id) == 1 ? "Department deleted" : "Error deleting Department";
    }
}
