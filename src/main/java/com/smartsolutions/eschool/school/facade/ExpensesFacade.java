package com.smartsolutions.eschool.school.facade;
import com.smartsolutions.eschool.school.model.ExpensesEntity;
import com.smartsolutions.eschool.school.service.ExpensesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExpensesFacade {

    private static final Log LOG = LogFactory.getLog(ExpensesFacade.class);
    @Autowired
    @Lazy
    private final ExpensesService nExpensesService;

    public ExpensesFacade(ExpensesService pExpensesService) {
        this.nExpensesService = pExpensesService;
    }


    public List<ExpensesEntity> getAll() {
        return nExpensesService.getAll();
    }

    public ExpensesEntity getById(Long id) {
        return nExpensesService.getById(id);
    }

    public List<ExpensesEntity> getByInstitute(Long id) {
        return nExpensesService.getByInstitute(id);
    }
    public List<ExpensesEntity> getByCampus(Long id) { return nExpensesService.getByCampus(id); }

    public String create(ExpensesEntity pExpensesEntity) {
        return nExpensesService.create(pExpensesEntity);
    }

    public String update(ExpensesEntity pExpensesEntity) {
        return nExpensesService.update(pExpensesEntity);
    }

    public String delete(Long id) {
        return nExpensesService.delete(id);
    }

}
