package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.model.ThemeEntity;
import com.smartsolutions.eschool.user.service.ThemeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ThemeServiceFacade {
    private static final Log LOG = LogFactory.getLog(UserRoleServiceFacade.class);
    @Autowired
    @Lazy
    private ThemeService nThemeService;

    public ThemeServiceFacade changeUser() {
        //this.user = user;
        return this;
    }

    public List<ThemeEntity> getAll() {
        return nThemeService.getAll();
    }
    public List<ThemeEntity> getByUser(Long id) {
        return nThemeService.getByUser(id);
    }
    public List<ThemeEntity> getByInstitute(Long id) {
        return nThemeService.getByInstitute(id);
    }
    public ThemeEntity getById(Long id) {
        return nThemeService.getById(id);
    }

    public String create(ThemeEntity pThemeEntity) {
        return nThemeService.create(pThemeEntity);
    }

    public String update(ThemeEntity pThemeEntity) {
        return nThemeService.update(pThemeEntity);
    }
    public String delete(Long id) {
        return nThemeService.delete(id);
    }
}
