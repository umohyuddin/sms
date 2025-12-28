package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.service.InstituteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Slf4j
public class InstituteFacade {
    private final InstituteService instituteService;
    private final CampusFacade campusFacade;

    public InstituteFacade(InstituteService instituteService, CampusFacade campusFacade) {
        this.instituteService = instituteService;
        this.campusFacade = campusFacade;
    }


    public InstituteResponseDTO getInstitute() {

        InstituteResponseDTO responseDTO = instituteService.getInstitute();
        responseDTO.setCampusCount(campusFacade.getCampusCountByInstituteId(responseDTO.getId()));
        return responseDTO;
    }

    public InstituteResponseDTO updateInstitute(InstituteRequestDTO instituteRequestDTO) {
        InstituteResponseDTO responseDTO = instituteService.updateInstitute(instituteRequestDTO);
        responseDTO.setCampusCount(campusFacade.getCampusCountByInstituteId(responseDTO.getId()));
        return responseDTO;
    }
}