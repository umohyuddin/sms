package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.glAccountMapping.request.GLAccountMappingRequestDTO;
import com.smartsolutions.eschool.gl.dtos.glAccountMapping.response.GLAccountMappingResponseDTO;
import com.smartsolutions.eschool.gl.service.GLAccountMappingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GLAccountMappingFacade {

    private final GLAccountMappingService mappingService;

    public List<GLAccountMappingResponseDTO> getAll() {
        log.info("[Facade:GLAccountMappingFacade] getAll() called");
        return mappingService.getAll();
    }

    public GLAccountMappingResponseDTO getById(Long id) {
        log.info("[Facade:GLAccountMappingFacade] getById() called - ID: {}", id);
        return mappingService.getById(id);
    }

    public GLAccountMappingResponseDTO create(GLAccountMappingRequestDTO requestDTO) {
        log.info("[Facade:GLAccountMappingFacade] create() called");
        return mappingService.create(requestDTO);
    }

    public GLAccountMappingResponseDTO update(Long id, GLAccountMappingRequestDTO requestDTO) {
        log.info("[Facade:GLAccountMappingFacade] update() called - ID: {}", id);
        return mappingService.update(id, requestDTO);
    }

    public void delete(Long id) {
        log.info("[Facade:GLAccountMappingFacade] delete() called - ID: {}", id);
        mappingService.delete(id);
    }

    public List<GLAccountMappingResponseDTO> search(String keyword) {
        log.info("[Facade:GLAccountMappingFacade] search() called - Keyword: {}", keyword);
        return mappingService.search(keyword);
    }
}
