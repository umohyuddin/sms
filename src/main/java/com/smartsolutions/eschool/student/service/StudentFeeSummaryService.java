package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.StudentFeePaymentsRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeSummaryRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class StudentFeeSummaryService {

    private final StudentFeeSummaryRepository studentFeeSummaryRepository;


    public StudentFeeSummaryService(StudentFeeSummaryRepository studentFeeSummaryRepository) {

        this.studentFeeSummaryRepository = studentFeeSummaryRepository;
    }

//    public List<FeeComponentDTO> searchFeeComponent(String keyword) {
//        try {
//            log.info("Fetching all FeeComponent based on keyword from database");
//            List<FeeComponentEntity> result = feeComponentRepository.searchFeeComponent(keyword);
//            log.info("Successfully fetched {} FeeComponent based on keyword", result.size());
//            List<FeeComponentDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeComponentDTO.class);
//            log.info("Successfully fetched FeeComponent based on keyword");
//            return FeeComponentDTOList;
//        } catch (DataAccessException dae) {
//            log.error("Database error while fetching FeeComponent based on keyword", dae);
//            //throw new CustomServiceException("Unable to fetch students from database", dae);
//        } catch (MappingException me) {
//            log.error("Error mapping StudentEntity to FeeComponent based on keyword", me);
//            //throw new CustomServiceException("Error converting student data", me);
//        } catch (Exception e) {
//            log.error("Unexpected error while fetching FeeComponent based on keyword", e);
//            //throw new ("Unexpected error occurred", e);
//        }
//        return Collections.emptyList();
//    }


    public StudentFeeSummaryDTO getByStudentId(Long id) {
        log.info("Fetching Student Fee Summary with id: {}", id);
        StudentFeeSummaryEntity studentFeeSummaryEntity = studentFeeSummaryRepository.findByStudentId(id).orElseThrow(() -> {
            log.info("Fetching Student Fee Summary with id: {}", id);
            return new ResourceNotFoundException("Fee Summary not found with id: " + id);
        });

        StudentFeeSummaryDTO studentFeeSummaryDTO = MapperUtil.mapObject(studentFeeSummaryEntity, StudentFeeSummaryDTO.class);
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
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Student fee summary", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Student fee summary", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StudentFeeSummaryResponseDto getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        log.info("Fetching Student Fee Summary for studentId={} and academicYearId={}", studentId, academicYearId);
        StudentFeeSummaryEntity studentFeeSummaryEntity = studentFeeSummaryRepository.findByStudentIdAndAcademicYearId(studentId, academicYearId).orElseThrow(() -> {
            log.error("Student Fee Summary not found for studentId={} and academicYearId={}", studentId, academicYearId);
            return new ResourceNotFoundException("Fee Summary not found for studentId: " + studentId + " and academicYearId: " + academicYearId);
        });
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = MapperUtil.mapObject(studentFeeSummaryEntity, StudentFeeSummaryResponseDto.class);
        log.info("Successfully fetched Student Fee Summary for studentId={} and academicYearId={}", studentId, academicYearId);
        return studentFeeSummaryDTO;
    }
}
