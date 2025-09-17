package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.repository.BankDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private final BankDao nBankDao;

    public BankService(BankDao pBankDao) {
        this.nBankDao = pBankDao;
    }

    public List<BankEntity> getAll() {
        return nBankDao.findAll();
    }

    public List<BankEntity> getByInstitute(Long id) {
        return nBankDao.findByInstitute(id);
    }

    public BankEntity getById(Long id) {
        return nBankDao.findById(id);
    }

    public String create(BankEntity pBankEntity) {
        return nBankDao.save(pBankEntity) == 1 ? "Bank created" : "Error creating Bank";
    }

    public String update(BankEntity pBankEntity) {
        return nBankDao.update(pBankEntity) == 1 ? "Bank updated" : "Error updating Bank";
    }

    public String delete(Long id) {
        return nBankDao.delete(id) == 1 ? "Bank deleted" : "Error deleting Bank";
    }
}
