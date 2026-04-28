package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.repository.BankDao;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BankService {
    private final BankDao nBankDao;

    public BankService(BankDao pBankDao) {
        this.nBankDao = pBankDao;
    }

    public List<BankEntity> getAll() {
        log.info("Fetching all Banks from database");
        try {
            List<BankEntity> result = nBankDao.findAll();
            log.info("Successfully fetched {} Banks", result.size());
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching all Banks", e);
            throw new CustomServiceException("Failed to fetch all Banks");
        }
    }

    public List<BankEntity> getByInstitute(Long id) {
        log.info("Fetching Banks for Institute ID: {} from database", id);
        try {
            List<BankEntity> result = nBankDao.findByInstitute(id);
            log.info("Successfully fetched {} Banks for Institute ID: {}", result.size(), id);
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Banks for Institute ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Banks for institute");
        }
    }

    public BankEntity getById(Long id) {
        log.info("Fetching Bank with ID: {} from database", id);
        try {
            BankEntity result = nBankDao.findById(id);
            if (result != null) {
                log.info("Successfully fetched Bank: id={}", result.getId());
            } else {
                log.warn("Bank not found with ID: {}", id);
            }
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Bank ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Bank by ID");
        }
    }

    @Transactional
    public String create(BankEntity pBankEntity) {
        log.info("Creating new Bank in database: {}", pBankEntity.getName());
        try {
            int result = nBankDao.save(pBankEntity);
            if (result == 1) {
                log.info("Bank saved successfully with ID: {}", pBankEntity.getId());
                return "Bank created";
            }
            log.warn("Failed to create Bank: {}", pBankEntity.getName());
            return "Error creating Bank";
        } catch (Exception e) {
            log.error("Unexpected error while creating Bank", e);
            throw new CustomServiceException("Failed to create Bank");
        }
    }

    @Transactional
    public String update(BankEntity pBankEntity) {
        log.info("Updating Bank with ID: {} in database", pBankEntity.getId());
        try {
            int result = nBankDao.update(pBankEntity);
            if (result == 1) {
                log.info("Bank updated successfully with ID: {}", pBankEntity.getId());
                return "Bank updated";
            }
            log.warn("Failed to update Bank ID: {}", pBankEntity.getId());
            return "Error updating Bank";
        } catch (Exception e) {
            log.error("Unexpected error while updating Bank ID: {}", pBankEntity.getId(), e);
            throw new CustomServiceException("Failed to update Bank");
        }
    }

    @Transactional
    public String delete(Long id) {
        log.info("Deleting Bank with ID: {} from database", id);
        try {
            int result = nBankDao.delete(id);
            if (result == 1) {
                log.info("Bank deleted successfully with ID: {}", id);
                return "Bank deleted";
            }
            log.warn("Failed to delete Bank ID: {}", id);
            return "Error deleting Bank";
        } catch (Exception e) {
            log.error("Unexpected error while deleting Bank ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Bank");
        }
    }

    public List<BankEntity> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Fetching Banks based on search from database with keyword: '{}'", searchKey);
        try {
            List<BankEntity> result = nBankDao.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Banks based on search", result.size());
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while searching Banks", e);
            throw new CustomServiceException("Failed to search Banks");
        }
    }
}
