package com.smartsolutions.eschool.school.facade;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentDao;
import com.smartsolutions.eschool.school.service.DepartmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DepartmentFacade {
    private static final Log LOG = LogFactory.getLog(DepartmentFacade.class);
    @Autowired
    @Lazy
    private final DepartmentService nDepartmentService;

    public DepartmentFacade(DepartmentService pDepartmentService) {
        this.nDepartmentService = pDepartmentService;
    }
    public List<DepartmentEntity> getAll() {
        return nDepartmentService.getAll();
    }
    public DepartmentEntity getById(Long id) {
        return nDepartmentService.getById(id);
    }
    public String create(DepartmentEntity pDepartmentEntity) {
        return nDepartmentService.create(pDepartmentEntity);
    }
    public String update(DepartmentEntity pDepartmentEntity) {
        return nDepartmentService.update(pDepartmentEntity);
    }
    public String delete(Long id) {
        return nDepartmentService.delete(id);
    }
}
