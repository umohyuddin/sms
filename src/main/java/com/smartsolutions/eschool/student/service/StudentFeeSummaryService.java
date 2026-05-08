package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.error.StudentErrors;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.mapper.StudentFeeSummaryMapper;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class StudentFeeSummaryService {

    private final StudentFeeSummaryRepository studentFeeSummaryRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentDiscountAssignmentRepository studentDiscountAssignmentRepository;
    private final StudentFeePaymentsRepository studentFeePaymentsRepository;
    private final StudentRepository studentRepository;
    private final AcademicYearRepository academicYearRepository;
    private final InstituteRepository instituteRepository;

    public StudentFeeSummaryService(StudentFeeSummaryRepository studentFeeSummaryRepository,
            StudentFeeAssignmentRepository studentFeeAssignmentRepository,
            StudentDiscountAssignmentRepository studentDiscountAssignmentRepository,
            StudentFeePaymentsRepository studentFeePaymentsRepository,
            StudentRepository studentRepository,
            AcademicYearRepository academicYearRepository,
            InstituteRepository instituteRepository) {
        this.studentFeeSummaryRepository = studentFeeSummaryRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentDiscountAssignmentRepository = studentDiscountAssignmentRepository;
        this.studentFeePaymentsRepository = studentFeePaymentsRepository;
        this.studentRepository = studentRepository;
        this.academicYearRepository = academicYearRepository;
        this.instituteRepository = instituteRepository;
    }

    @Transactional
    public StudentFeeSummaryDTO updateSummary(Long studentId, Long academicYearId, Long organizationId) {
        log.info("[Service:StudentFeeSummaryService] updateSummary() called - studentId={}, academicYearId={}, organizationId={}",
                studentId, academicYearId, organizationId);

        BigDecimal totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, academicYearId, organizationId);
        if (totalAssigned == null) totalAssigned = BigDecimal.ZERO;

        BigDecimal totalDiscount = studentDiscountAssignmentRepository.findTotalDiscountByStudentAndYear(studentId, academicYearId);
        if (totalDiscount == null) totalDiscount = BigDecimal.ZERO;

        BigDecimal totalPaid = studentFeePaymentsRepository.findTotalPaidByStudentAndYear(studentId, academicYearId, organizationId);
        if (totalPaid == null) totalPaid = BigDecimal.ZERO;

        BigDecimal balance = totalAssigned.subtract(totalDiscount).subtract(totalPaid);

        StudentFeeSummaryEntity summary = studentFeeSummaryRepository
                .findByStudentIdAndAcademicYearId(studentId, academicYearId)
                .orElseGet(() -> {
                    log.info("[Service:StudentFeeSummaryService] Creating new summary entity");
                    StudentFeeSummaryEntity newSummary = new StudentFeeSummaryEntity();
                    StudentEntity student = studentRepository.findById(studentId)
                            .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + studentId));
                    AcademicYearEntity academicYear = academicYearRepository.findById(academicYearId)
                            .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found: " + academicYearId));
                    newSummary.setStudent(student);
                    newSummary.setAcademicYear(academicYear);
                    newSummary.setOrganizationId(organizationId);
                    return newSummary;
                });

        summary.setTotalAssignedFee(totalAssigned);
        summary.setTotalDiscount(totalDiscount);
        summary.setTotalPaid(totalPaid);
        summary.setBalance(balance);

        studentFeeSummaryRepository.save(summary);
        log.info("[Service:StudentFeeSummaryService] updateSummary() succeeded - id={}", summary.getId());

        return StudentFeeSummaryMapper.toSummaryDTO(summary);
    }

    @Transactional
    public StudentFeeSummaryDTO getByStudentId(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeSummaryService] getByStudentId() called - studentId: {}, institute: {}", id, organizationId);
        
        StudentFeeSummaryEntity entity = studentFeeSummaryRepository.findByStudentId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee Summary not found for student id: " + id));

        if (!entity.getOrganizationId().equals(organizationId)) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }

        StudentFeeSummaryDTO dto = StudentFeeSummaryMapper.toSummaryDTO(entity);
        log.info("[Service:StudentFeeSummaryService] getByStudentId() succeeded");
        return dto;
    }

    @Transactional
    public List<StudentFeeSummaryDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeSummaryService] getAll() called - institute: {}", organizationId);
        
        List<StudentFeeSummaryEntity> result = studentFeeSummaryRepository.findByOrganizationId(organizationId);
        List<StudentFeeSummaryDTO> dtos = StudentFeeSummaryMapper.toSummaryDTOList(result);
        
        log.info("[Service:StudentFeeSummaryService] getAll() succeeded - Found {} summaries", dtos.size());
        return dtos;
    }

    @Transactional
    public StudentFeeSummaryResponseDto getDetailedSummary(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeSummaryService] getDetailedSummary() called - studentId: {}, academicYearId: {}, institute: {}", 
                studentId, academicYearId, organizationId);

        StudentFeeSummaryEntity entity = studentFeeSummaryRepository
                .findByStudentIdAndAcademicYearId(studentId, academicYearId)
                .orElseThrow(() -> new ResourceNotFoundException("Fee Summary not found for studentId: " + studentId + " and academicYearId: " + academicYearId));

        if (!entity.getOrganizationId().equals(organizationId)) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }

        StudentFeeSummaryResponseDto dto = StudentFeeSummaryMapper.toDetailedResponseDTO(entity);
        log.info("[Service:StudentFeeSummaryService] getDetailedSummary() succeeded");
        return dto;
    }

    @Transactional
    public List<StudentFeeSummaryDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeSummaryService] searchByKeyword() called - keyword: {}, institute: {}", keyword, organizationId);
        
        List<StudentFeeSummaryEntity> result = studentFeeSummaryRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<StudentFeeSummaryDTO> dtos = StudentFeeSummaryMapper.toSummaryDTOList(result);
        
        log.info("[Service:StudentFeeSummaryService] searchByKeyword() succeeded - Found {} matching summaries", dtos.size());
        return dtos;
    }
}

