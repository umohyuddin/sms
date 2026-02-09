package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.sms.academic.dto.request.ReportCardRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ReportCardResponseDTO;
import com.smartsolutions.sms.academic.entity.master.ReportCardEntity;
import com.smartsolutions.sms.academic.mapper.ResultsMapper;
import com.smartsolutions.sms.academic.repository.ReportCardRepository;
import com.smartsolutions.sms.academic.service.ReportCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportCardServiceImpl implements ReportCardService {

    private final ReportCardRepository reportCardRepository;
    private final StudentRepository studentRepository;
    private final AcademicYearRepository academicYearRepository;
    private final ResultsMapper resultsMapper;

    @Override
    @Transactional
    public ReportCardResponseDTO generate(ReportCardRequestDTO dto) {
        StudentEntity student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        AcademicYearEntity year = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));

        ReportCardEntity entity = resultsMapper.toEntity(dto);
        entity.setStudent(student);
        entity.setAcademicYear(year);
        
        return resultsMapper.toResponse(reportCardRepository.save(entity));
    }

    @Override
    public List<ReportCardResponseDTO> getByStudent(Long studentId) {
        return reportCardRepository.findByStudentId(studentId).stream()
                .map(resultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!reportCardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report card record not found");
        }
        reportCardRepository.softDeleteById(id);
    }
}
