package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ReportCardRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ReportCardResponseDTO;

import java.util.List;

public interface ReportCardService {
    ReportCardResponseDTO generate(ReportCardRequestDTO dto);
    List<ReportCardResponseDTO> getByStudent(Long studentId);
    void delete(Long id);
}
