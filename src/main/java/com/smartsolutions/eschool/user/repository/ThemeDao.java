package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ThemeEntity;

import java.util.List;

public interface ThemeDao {
    int save(ThemeEntity pThemeEntity);
    int update(ThemeEntity pThemeEntity);
    int delete(Long id);
    ThemeEntity findById(Long id);
    List<ThemeEntity> findAll();
    List<ThemeEntity> findByUser(Long id);
    List<ThemeEntity> findByInstitute(Long id);
}
