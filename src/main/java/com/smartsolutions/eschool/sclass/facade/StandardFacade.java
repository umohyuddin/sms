package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.service.StandardService;
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
    private StandardService standardService;

    public List<StandardDTO> getAll() {
        return standardService.getAll();
    }

    public StandardDTO getById(Long id) {
        return standardService.getById(id);
    }

    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        return standardService.create(standardDTO);
    }

    public int softDeleteById(Long standardId) {
        return standardService.softDeleteById(standardId);
    }

    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        return standardService.updateStandard(id, dto);
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        return standardService.searchByKeyword(keyword);
    }

    public List<StandardDTO> getByCampusId(Long id) {
        return standardService.findByCampusId(id);
    }

    public int softDeleteByCampusId(Long campusId) {
       return standardService.sofDeleteByCampusId(campusId);
    }

    public List<StandardDTO> getStandardsByFilter(Long campusId, String keyword) {
        return standardService.getStandardByFilter(campusId,keyword);
    }


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
