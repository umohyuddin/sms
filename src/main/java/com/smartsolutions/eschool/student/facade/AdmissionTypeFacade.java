package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.service.AdmissionTypeService;
import com.smartsolutions.eschool.student.service.FeeCatalogService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AdmissionTypeFacade {


    private final AdmissionTypeService admissionTypeService;

    public AdmissionTypeFacade(AdmissionTypeService admissionTypeService) {
        this.admissionTypeService = admissionTypeService;
    }

    public List<AdmissionTypeResponseDTO> getAll() {
        return admissionTypeService.getAll();
    }

}
