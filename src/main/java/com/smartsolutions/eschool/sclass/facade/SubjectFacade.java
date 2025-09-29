package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;
import com.smartsolutions.eschool.sclass.service.SubjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class SubjectFacade {
    private static final Log LOG = LogFactory.getLog(SubjectFacade.class);
    @Autowired
    @Lazy
    private SubjectService subjectService;

    public List<SubjectEntity> getAll() {
        return subjectService.getAll();
    }

    public SubjectEntity getById(Long id) {
        return subjectService.getById(id);
    }

    public List<SubjectEntity> getByTeacherId(Long id) {
        return subjectService.getByTeacherId(id);
    }

    public List<SubjectEntity> getByDepartmentId(Long id) {
        return subjectService.getByDepartmentId(id);
    }

    public String create(SubjectEntity pSubjectEntity) {
        return subjectService.create(pSubjectEntity);
    }

    public String update(SubjectEntity pSubjectEntity) {
        return subjectService.update(pSubjectEntity);
    }

    public String delete(Long id) {
        return subjectService.delete(id);
    }
}
