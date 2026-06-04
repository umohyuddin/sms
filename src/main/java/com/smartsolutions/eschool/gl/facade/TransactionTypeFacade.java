package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.transactionType.request.TransactionTypeRequestDTO;
import com.smartsolutions.eschool.gl.dtos.transactionType.response.TransactionTypeResponseDTO;
import com.smartsolutions.eschool.gl.service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionTypeFacade {

    private final TransactionTypeService transactionTypeService;

    public List<TransactionTypeResponseDTO> getAll() {
        log.info("[Facade:TransactionTypeFacade] getAll() called");
        return transactionTypeService.getAll();
    }

    public TransactionTypeResponseDTO getById(Long id) {
        log.info("[Facade:TransactionTypeFacade] getById() called - ID: {}", id);
        return transactionTypeService.getById(id);
    }

    public TransactionTypeResponseDTO create(TransactionTypeRequestDTO requestDTO) {
        log.info("[Facade:TransactionTypeFacade] create() called");
        return transactionTypeService.create(requestDTO);
    }

    public TransactionTypeResponseDTO update(Long id, TransactionTypeRequestDTO requestDTO) {
        log.info("[Facade:TransactionTypeFacade] update() called - ID: {}", id);
        return transactionTypeService.update(id, requestDTO);
    }

    public void delete(Long id) {
        log.info("[Facade:TransactionTypeFacade] delete() called - ID: {}", id);
        transactionTypeService.delete(id);
    }

    public List<TransactionTypeResponseDTO> search(String keyword) {
        log.info("[Facade:TransactionTypeFacade] search() called - Keyword: {}", keyword);
        return transactionTypeService.search(keyword);
    }
}
