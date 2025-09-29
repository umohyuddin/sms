package com.smartsolutions.eschool.school.service;
import com.smartsolutions.eschool.school.model.ExpensesEntity;
import com.smartsolutions.eschool.school.repository.ExpensesDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    private final ExpensesDao nExpensesDao;

    public ExpensesService(ExpensesDao pExpensesDao) {
        this.nExpensesDao = pExpensesDao;
    }


    public List<ExpensesEntity> getAll() {
        return nExpensesDao.findAll();
    }

    public ExpensesEntity getById(Long id) {
        return nExpensesDao.findById(id);
    }

    public List<ExpensesEntity> getByInstitute(Long id) {
        return nExpensesDao.findByInstitute(id);
    }
    public List<ExpensesEntity> getByCampus(Long id) {
        return nExpensesDao.findByCampus(id);
    }

    public String create(ExpensesEntity pExpensesEntity) {
        return nExpensesDao.save(pExpensesEntity) == 1 ? "Expenses created" : "Error creating Expenses";
    }

    public String update(ExpensesEntity pExpensesEntity) {
        return nExpensesDao.update(pExpensesEntity) == 1 ? "Expenses updated" : "Error updating Expenses";
    }

    public String delete(Long id) {
        return nExpensesDao.delete(id) == 1 ? "Expenses deleted" : "Error deleting Expenses";
    }
}
