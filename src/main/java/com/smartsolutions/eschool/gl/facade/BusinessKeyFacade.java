package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.businessKey.request.BusinessKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.businessKey.response.BusinessKeyResponseDTO;
import com.smartsolutions.eschool.gl.service.BusinessKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BusinessKeyFacade {

    private final BusinessKeyService businessKeyService;

    public List<BusinessKeyResponseDTO> getAll() {
        log.info("[Facade:BusinessKeyFacade] getAll() called");
        return businessKeyService.getAll();
    }

    public BusinessKeyResponseDTO getById(Long id) {
        log.info("[Facade:BusinessKeyFacade] getById() called - ID: {}", id);
        return businessKeyService.getById(id);
    }

    public BusinessKeyResponseDTO create(BusinessKeyRequestDTO requestDTO) {
        log.info("[Facade:BusinessKeyFacade] create() called");
        return businessKeyService.create(requestDTO);
    }

    public BusinessKeyResponseDTO update(Long id, BusinessKeyRequestDTO requestDTO) {
        log.info("[Facade:BusinessKeyFacade] update() called - ID: {}", id);
        return businessKeyService.update(id, requestDTO);
    }

    public void delete(Long id) {
        log.info("[Facade:BusinessKeyFacade] delete() called - ID: {}", id);
        businessKeyService.delete(id);
    }

    public List<BusinessKeyResponseDTO> search(String keyword) {
        log.info("[Facade:BusinessKeyFacade] search() called - Keyword: {}", keyword);
        return businessKeyService.search(keyword);
    }
}
