package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.RulesEntity;
import com.smartsolutions.eschool.school.service.RulesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class RulesFacade {
    private static final Log LOG = LogFactory.getLog(RulesFacade.class);
    @Autowired
    @Lazy
    private final RulesService nRulesService;

    public RulesFacade(RulesService pRulesService) {
        this.nRulesService = pRulesService;
    }
    public RulesEntity getByInstitute(Long id) {
        return nRulesService.getByInstitute(id);
    }

    public String create(RulesEntity pRulesEntity) {
        return nRulesService.create(pRulesEntity);
    }

    public String update(RulesEntity pRulesEntity) {
        return nRulesService.update(pRulesEntity);
    }

    public String delete(Long id) {
        return nRulesService.delete(id);
    }
}
