package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.BankEntity;

import java.util.List;

public interface BankDao {
    int save(BankEntity pBankEntity);
    int update(BankEntity pBankEntity);
    int delete(Long id);
    BankEntity findById(Long id);
    List<BankEntity> findByInstitute(Long id);
    List<BankEntity> findAll();
}
