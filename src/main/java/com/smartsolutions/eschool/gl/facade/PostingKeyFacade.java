package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.postingKey.request.PostingKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.postingKey.response.PostingKeyResponseDTO;
import com.smartsolutions.eschool.gl.service.PostingKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PostingKeyFacade {

    private final PostingKeyService postingKeyService;

    public List<PostingKeyResponseDTO> getAll() {
        log.info("[Facade:PostingKeyFacade] getAll() called");
        return postingKeyService.getAll();
    }

    public PostingKeyResponseDTO getById(Long id) {
        log.info("[Facade:PostingKeyFacade] getById() called - ID: {}", id);
        return postingKeyService.getById(id);
    }

    public PostingKeyResponseDTO create(PostingKeyRequestDTO requestDTO) {
        log.info("[Facade:PostingKeyFacade] create() called");
        return postingKeyService.create(requestDTO);
    }

    public PostingKeyResponseDTO update(Long id, PostingKeyRequestDTO requestDTO) {
        log.info("[Facade:PostingKeyFacade] update() called - ID: {}", id);
        return postingKeyService.update(id, requestDTO);
    }

    public void delete(Long id) {
        log.info("[Facade:PostingKeyFacade] delete() called - ID: {}", id);
        postingKeyService.delete(id);
    }

    public List<PostingKeyResponseDTO> search(String keyword) {
        log.info("[Facade:PostingKeyFacade] search() called - Keyword: {}", keyword);
        return postingKeyService.search(keyword);
    }
}
