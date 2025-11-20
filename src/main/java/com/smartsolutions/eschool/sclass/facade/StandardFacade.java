package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.service.SClassService;
import com.smartsolutions.eschool.sclass.service.StandardService;
import com.smartsolutions.eschool.util.ResourceObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StandardFacade {


    @Autowired
    @Lazy
    private StandardService standardServicee;

    public List<ResourceObject> getAll() {
        return standardServicee.getAll();
    }

//    public SClassEntity getById(Long id) {
//        return standardServicee.getById(id);
//    }
//
//    public List<SClassEntity> getByTeacherId(Long id) {
//        return standardServicee.getByTeacherId(id);
//    }
//
//    public List<SClassEntity> getByCourseId(Long id) {
//        return standardServicee.getByCourseId(id);
//    }
//
//    public List<SClassEntity> getByStudentId(Long id) {
//        return standardServicee.getByStudentId(id);
//    }
//
//    public String create(SClassEntity pSClassEntity) {
//        return standardServicee.create(pSClassEntity);
//    }
//
//    public String update(SClassEntity pSClassEntity) {
//        return standardServicee.update(pSClassEntity);
//    }
//
//    public String delete(Long id) {
//        return standardServicee.delete(id);
//    }
}
