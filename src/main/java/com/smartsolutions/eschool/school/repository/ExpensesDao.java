package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.model.ExpensesEntity;

import java.util.List;

public interface ExpensesDao {
    int save(ExpensesEntity pExpensesEntity);
    int update(ExpensesEntity pExpensesEntity);
    int delete(Long id);
    ExpensesEntity findById(Long id);
    List<ExpensesEntity> findByInstitute(Long id);
    List<ExpensesEntity> findByCampus(Long id);
    List<ExpensesEntity> findAll();
}
