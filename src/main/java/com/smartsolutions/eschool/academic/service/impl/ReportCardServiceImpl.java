package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.academic.dto.request.ReportCardRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ReportCardResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.ReportCardEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.ReportCardRepository;
import com.smartsolutions.eschool.academic.service.ReportCardService;
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

    @Override
    @Transactional
    public ReportCardResponseDTO generate(ReportCardRequestDTO dto) {
        StudentEntity student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        AcademicYearEntity year = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));

        ReportCardEntity entity = ResultsMapper.toEntity(dto);
        entity.setStudent(student);
        entity.setAcademicYear(year);
        
        return ResultsMapper.toResponse(reportCardRepository.save(entity));
    }

    @Override
    public List<ReportCardResponseDTO> getByStudent(Long studentId) {
        return reportCardRepository.findByStudentId(studentId).stream()
                .map(ResultsMapper::toResponse)
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
