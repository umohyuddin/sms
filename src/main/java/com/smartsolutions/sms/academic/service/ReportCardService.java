package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ReportCardRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ReportCardResponseDTO;

import java.util.List;

public interface ReportCardService {
    ReportCardResponseDTO generate(ReportCardRequestDTO dto);
    List<ReportCardResponseDTO> getByStudent(Long studentId);
    void delete(Long id);
}
