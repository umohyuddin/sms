package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.user.model.ThemeEntity;
import com.smartsolutions.eschool.user.repository.ThemeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    private ThemeDao themeDao;
    public ThemeService(ThemeDao pThemeDao) {
        this.themeDao = pThemeDao;
    }

    public List<ThemeEntity> getAll() {
        return themeDao.findAll();
    }
    public List<ThemeEntity> getByUser(Long id) {
        return themeDao.findByUser(id);
    }

    public List<ThemeEntity> getByInstitute(Long id) {
        return themeDao.findByInstitute(id);
    }

    public ThemeEntity getById(Long id) {
        return themeDao.findById(id);
    }

    public String create(ThemeEntity pThemeEntity) {
        return themeDao.save(pThemeEntity) == 1 ? "ThemeEntity created" : "Error creating ThemeEntity";
    }

    public String update(ThemeEntity pThemeEntity) {
        return themeDao.update(pThemeEntity) == 1 ? "ThemeEntity updated" : "Error updating ThemeEntity";
    }

    public String delete(Long id) {
        return themeDao.delete(id) == 1 ? "ThemeEntity deleted" : "Error deleting ThemeEntity";
    }
}
