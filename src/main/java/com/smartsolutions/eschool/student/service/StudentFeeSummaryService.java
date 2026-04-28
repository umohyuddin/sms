package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.mapper.StudentFeeAssignmentMapper;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
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
        log.info(
                "[Service:StudentFeeSummaryService] updateSummary() called - studentId={}, academicYearId={}, organizationId={}",
                studentId, academicYearId, organizationId);

        // 1. Calculate Totals
        Double totalAssignedDouble = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, academicYearId,
                organizationId);
        BigDecimal totalAssigned = BigDecimal.valueOf(totalAssignedDouble != null ? totalAssignedDouble : 0.0);

        BigDecimal totalDiscount = studentDiscountAssignmentRepository.findTotalDiscountByStudentAndYear(studentId,
                academicYearId);
        if (totalDiscount == null)
            totalDiscount = BigDecimal.ZERO;

        BigDecimal totalPaid = studentFeePaymentsRepository.findTotalPaidByStudentAndYear(studentId, academicYearId,
                organizationId);
        if (totalPaid == null)
            totalPaid = BigDecimal.ZERO;

        // Balance = Assigned - Discount - Paid
        BigDecimal balance = totalAssigned.subtract(totalDiscount).subtract(totalPaid);

        // 2. Fetch or Create Summary Entity
        StudentFeeSummaryEntity summary = studentFeeSummaryRepository
                .findByStudentIdAndAcademicYearId(studentId, academicYearId)
                .orElseGet(() -> {
                    log.info("[Service:StudentFeeSummaryService] Creating new summary entity");
                    StudentFeeSummaryEntity newSummary = new StudentFeeSummaryEntity();

                    StudentEntity student = studentRepository.findById(studentId)
                            .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + studentId));
                    AcademicYearEntity academicYear = academicYearRepository.findById(academicYearId)
                            .orElseThrow(
                                    () -> new ResourceNotFoundException("Academic Year not found: " + academicYearId));
                    InstituteEntity institute = instituteRepository.findById(organizationId)
                            .orElseThrow(
                                    () -> new ResourceNotFoundException("Organization not found: " + organizationId));

                    newSummary.setStudent(student);
                    newSummary.setAcademicYear(academicYear);
                    newSummary.setInstitute(institute);
                    return newSummary;
                });

        // 3. Update fields
        summary.setTotalAssignedFee(totalAssigned);
        summary.setTotalDiscount(totalDiscount);
        summary.setTotalPaid(totalPaid);
        summary.setBalance(balance);

        studentFeeSummaryRepository.save(summary);
        log.info(
                "[Service:StudentFeeSummaryService] Summary updated successfully - totalAssigned={}, totalDiscount={}, totalPaid={}, balance={}",
                totalAssigned, totalDiscount, totalPaid, balance);

        // 4. Return DTO (Using provide mapper if it exists, otherwise MapperUtil)
        return StudentFeeAssignmentMapper.toSummaryDTO(summary);
    }

    // public List<FeeComponentDTO> searchFeeComponent(String keyword) {
    // try {
    // log.info("Fetching all FeeComponent based on keyword from database");
    // List<FeeComponentEntity> result =
    // feeComponentRepository.searchFeeComponent(keyword);
    // log.info("Successfully fetched {} FeeComponent based on keyword",
    // result.size());
    // List<FeeComponentDTO> FeeComponentDTOList = MapperUtil.mapList(result,
    // FeeComponentDTO.class);
    // log.info("Successfully fetched FeeComponent based on keyword");
    // return FeeComponentDTOList;
    // } catch (DataAccessException dae) {
    // log.error("Database error while fetching FeeComponent based on keyword",
    // dae);
    // //throw new CustomServiceException("Unable to fetch students from database",
    // dae);
    // } catch (MappingException me) {
    // log.error("Error mapping StudentEntity to FeeComponent based on keyword",
    // me);
    // //throw new CustomServiceException("Error converting student data", me);
    // } catch (Exception e) {
    // log.error("Unexpected error while fetching FeeComponent based on keyword",
    // e);
    // //throw new ("Unexpected error occurred", e);
    // }
    // return Collections.emptyList();
    // }

    public StudentFeeSummaryDTO getByStudentId(Long id) {
        log.info("Fetching Student Fee Summary with id: {}", id);
        StudentFeeSummaryEntity studentFeeSummaryEntity = studentFeeSummaryRepository.findByStudentId(id)
                .orElseThrow(() -> {
                    log.info("Fetching Student Fee Summary with id: {}", id);
                    return new ResourceNotFoundException("Fee Summary not found with id: " + id);
                });

        StudentFeeSummaryDTO studentFeeSummaryDTO = MapperUtil.mapObject(studentFeeSummaryEntity,
                StudentFeeSummaryDTO.class);
        log.info("Successfully fetched Student Fee Summary: id={}", studentFeeSummaryDTO.getStudentId());
        return studentFeeSummaryDTO;
    }

    public List<StudentFeeSummaryDTO> getAll() {
        try {
            log.info("Fetching all Student fee summary from database");
            List<StudentFeeSummaryEntity> result = studentFeeSummaryRepository.findAllStudentFeeSummary();
            log.info("Successfully fetched {} Students fee summary", result.size());
            List<StudentFeeSummaryDTO> studentFeeSummaryDTOS = MapperUtil.mapList(result, StudentFeeSummaryDTO.class);
            log.info("Successfully fetched Student fee summary");
            return studentFeeSummaryDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Student fee summary", dae);
            // throw new CustomServiceException("Unable to fetch students from database",
            // dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Student fee summary", me);
            // throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Student fee summary", e);
            // throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StudentFeeSummaryResponseDto getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        log.info("Fetching Student Fee Summary for studentId={} and academicYearId={}", studentId, academicYearId);
        StudentFeeSummaryEntity studentFeeSummaryEntity = studentFeeSummaryRepository
                .findByStudentIdAndAcademicYearId(studentId, academicYearId).orElseThrow(() -> {
                    log.error("Student Fee Summary not found for studentId={} and academicYearId={}", studentId,
                            academicYearId);
                    return new ResourceNotFoundException("Fee Summary not found for studentId: " + studentId
                            + " and academicYearId: " + academicYearId);
                });
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = MapperUtil.mapObject(studentFeeSummaryEntity,
                StudentFeeSummaryResponseDto.class);
        log.info("Successfully fetched Student Fee Summary for studentId={} and academicYearId={}", studentId,
                academicYearId);
        return studentFeeSummaryDTO;
    }
}
