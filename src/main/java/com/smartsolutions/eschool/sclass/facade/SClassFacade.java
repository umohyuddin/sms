package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.service.SClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SClassFacade {

    private final SClassService sClassService;

    public SClassFacade(SClassService sClassService) {
        this.sClassService = sClassService;
    }

    public List<SClassEntity> getAll() {
        log.info("Facade: Request to fetch all SClasses");
        List<SClassEntity> result = sClassService.getAll();
        log.info("Facade: Successfully fetched {} SClasses", result.size());
        return result;
    }

    public SClassEntity getById(Long id) {
        log.info("Facade: Request to fetch SClass by id: {}", id);
        SClassEntity result = sClassService.getById(id);
        log.info("Facade: Successfully fetched SClass: id={}", id);
        return result;
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        log.info("Facade: Request to fetch SClasses by teacher id: {}", id);
        List<SClassEntity> result = sClassService.getByTeacherId(id);
        log.info("Facade: Successfully fetched {} SClasses for teacher id: {}", result.size(), id);
        return result;
    }

    public List<SClassEntity> getByCourseId(Long id) {
        log.info("Facade: Request to fetch SClasses by course id: {}", id);
        List<SClassEntity> result = sClassService.getByCourseId(id);
        log.info("Facade: Successfully fetched {} SClasses for course id: {}", result.size(), id);
        return result;
    }

    public List<SClassEntity> getByStudentId(Long id) {
        log.info("Facade: Request to fetch SClasses by student id: {}", id);
        List<SClassEntity> result = sClassService.getByStudentId(id);
        log.info("Facade: Successfully fetched {} SClasses for student id: {}", result.size(), id);
        return result;
    }

    public String create(SClassEntity pSClassEntity) {
        log.info("Facade: Request to create SClass: {}", pSClassEntity.getName());
        String result = sClassService.create(pSClassEntity);
        log.info("Facade: Create result: {}", result);
        return result;
    }

    public String update(SClassEntity pSClassEntity) {
        log.info("Facade: Request to update SClass id: {}", pSClassEntity.getId());
        String result = sClassService.update(pSClassEntity);
        log.info("Facade: Update result: {}", result);
        return result;
    }

    public String delete(Long id) {
        log.info("Facade: Request to delete SClass by id: {}", id);
        String result = sClassService.delete(id);
        log.info("Facade: Delete result: {}", result);
        return result;
    }

    public List<SClassEntity> searchByKeyword(String keyword) {
        log.info("Facade: Request to search SClasses by keyword: '{}'", keyword);
        List<SClassEntity> result = sClassService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} SClasses", result.size());
        return result;
    }
}
