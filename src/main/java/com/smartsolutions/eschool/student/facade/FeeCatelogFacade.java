package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.service.FeeCatalogService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeCatelogFacade {


    private final FeeCatalogService feeCatalogService;

    public FeeCatelogFacade(FeeCatalogService feeCatalogService) {
        this.feeCatalogService = feeCatalogService;
    }

    public List<FeeCatalogDTO> getAll() {
        return feeCatalogService.getAll();
    }
    public FeeCatalogDTO getById(Long id) {
        return feeCatalogService.getById(id);
    }

    public  List<FeeCatalogDTO> searchFeeCatalog(String keyword){
        return feeCatalogService.searchFeeCatalog(keyword);
    }

//    public List<FeeEntity> getByStudent(Long std_id) {
//        return feeService.getByStudent(std_id);
//    }
//
//    public String create(FeeEntity pFeeEntity) {
//        return feeService.create(pFeeEntity);
//    }
//
//    public String update(FeeEntity pFeeEntity) {
//        return feeService.update(pFeeEntity);
//    }
//    public String delete(Long id) {
//        return feeService.delete(id);
//    }
}
