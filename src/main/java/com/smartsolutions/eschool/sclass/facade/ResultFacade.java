package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.ResultEntity;
import com.smartsolutions.eschool.sclass.service.ResultService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class ResultFacade {

    private static final Log LOG = LogFactory.getLog(ResultFacade.class);
    @Autowired
    @Lazy
    private ResultService nResultService;

    public List<ResultEntity> getAll() {
        return nResultService.getAll();
    }

    public ResultEntity getById(Long id) {
        return nResultService.getById(id);
    }

    public List<ResultEntity> getByStudentId(Long id) {
        return nResultService.getByStudentId(id);
    }

    public List<ResultEntity> getByClassId(Long id) {
        return nResultService.getByClassId(id);
    }

    public List<ResultEntity> getBySubjectId(Long id) {
        return nResultService.getBySubjectId(id);
    }

    public String create(ResultEntity pResultEntity) {
        return nResultService.create(pResultEntity);
    }

    public String update(ResultEntity pResultEntity) {
        return nResultService.update(pResultEntity);
    }

    public String delete(Long id) {
        return nResultService.delete(id);
    }
}
