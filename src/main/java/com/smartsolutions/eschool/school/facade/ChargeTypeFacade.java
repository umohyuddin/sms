package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.chargetype.request.ChargeTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.service.ChargeTypeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class ChargeTypeFacade {

    private final ChargeTypeService chargeTypeService;

    public ChargeTypeFacade(ChargeTypeService chargeTypeService) {
        this.chargeTypeService = chargeTypeService;
    }

    public ChargeTypeResponseDTO createChargeType(@Valid ChargeTypeRequestDTO requestDTO) {
        log.info("[Facade:ChargeTypeFacade] createChargeType() called");
        return chargeTypeService.createChargeType(requestDTO);
    }

    public List<ChargeTypeResponseDTO> getAll() {
        log.info("[Facade:ChargeTypeFacade] getAll() called");
        return chargeTypeService.getAllChargeTypes();
    }

    public ChargeTypeResponseDTO getById(Long id) {
        log.info("[Facade:ChargeTypeFacade] getById() called - id: {}", id);
        return chargeTypeService.getChargeTypeById(id);
    }

    public List<ChargeTypeResponseDTO> getAllActive() {
        log.info("[Facade:ChargeTypeFacade] getAllActive() called");
        return chargeTypeService.getAllActiveChargeTypes();
    }

    public ChargeTypeResponseDTO update(Long id, @Valid ChargeTypeRequestDTO requestDTO) {
        log.info("[Facade:ChargeTypeFacade] update() called - id: {}", id);
        return chargeTypeService.updateChargeType(id, requestDTO);
    }

    public List<ChargeTypeResponseDTO> search(String keyword) {
        log.info("[Facade:ChargeTypeFacade] search() called - keyword: '{}'", keyword);
        return chargeTypeService.searchChargeTypes(keyword);
    }

    public void delete(Long id) {
        log.info("[Facade:ChargeTypeFacade] delete() called - id: {}", id);
        chargeTypeService.deleteChargeType(id);
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Facade:ChargeTypeFacade] getStatistics() called");
        return chargeTypeService.getStatistics();
    }
}
