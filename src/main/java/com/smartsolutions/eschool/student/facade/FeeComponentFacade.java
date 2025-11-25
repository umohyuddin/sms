package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.service.FeeCatalogService;
import com.smartsolutions.eschool.student.service.FeeComponentService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeComponentFacade {


    private final FeeComponentService feeComponentService;

    public FeeComponentFacade(FeeComponentService feeComponentService) {
        this.feeComponentService = feeComponentService;
    }

    public List<FeeComponentDTO> getAll() {
        return feeComponentService.getAll();
    }
    public FeeComponentDTO getById(Long id) {
        return feeComponentService.getById(id);
    }

    public  List<FeeComponentDTO> searchFeeCatalog(String keyword){
        return feeComponentService.searchFeeComponent(keyword);
    }
}
