package com.smartsolutions.eschool.student.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.mapper.StudentMapper;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentDao;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.ResourceObject;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> getAll() {
        try {
            log.info("Fetching all Students from database");
            List<StudentEntity> result = studentRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Students", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            //List<StudentDTO> studentDTOList = studentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Students", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        try {
            log.info("Fetching all Students by Campus from database");
            List<StudentEntity> result = studentRepository.findByCampusId(campusId);
            log.info("Successfully fetched {} Students by Campus", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            //List<StudentDTO> studentDTOList = studentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Campus", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Campus", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Students by Campus", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Campus", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByName(String studentName) {
        try {
            log.info("Fetching all Students by Name from database");
            List<StudentEntity> result = studentRepository.searchStudentsByName(studentName);
            log.info("Successfully fetched {} Students by Name", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            log.info("Successfully fetched {} Students by Name", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Name", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Students by Name", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Name", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsByStandard(Long standardId) {
        try {
            log.info("Fetching all Students by Standard from database");
            List<StudentEntity> result = studentRepository.findByStandardId(standardId);
            log.info("Successfully fetched {} Students by Standard", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            //List<StudentDTO> studentDTOList = studentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Standard", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Standard", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Students by Standard", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Standard", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public List<StudentDTO> getStudentsBySection(Long sectionId) {
        try {
            log.info("Fetching all Students by Section from database");
            List<StudentEntity> result = studentRepository.findBySectionId(sectionId);
            log.info("Successfully fetched {} Students by Section", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            //List<StudentDTO> studentDTOList = studentMapper.toDTOList(result);
            log.info("Successfully fetched {} Students by Section", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Students by Section", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Students by Section", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Students by Section", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StudentDTO getById(Long id) {
        log.info("Fetching Student with id: {}", id);
        StudentEntity studentEntity = studentRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Student with id: {}", id);
            return new ResourceNotFoundException("Student not found with id: " + id);
        });
        StudentDTO studentDTO = MapperUtil.mapObject(studentEntity, StudentDTO.class);
        log.info("Successfully fetched Standard: id={}", studentDTO.getId());
        return studentDTO;
    }

    public StudentDTO getByStudentCode(String studentCode) {
        log.info("Fetching Student with studentCode: {}", studentCode);
        StudentEntity studentEntity = studentRepository.findByStudentCode(studentCode).orElseThrow(() -> {
            log.info("Fetching Student with studentCode: {}", studentCode);
            return new ResourceNotFoundException("Student not found with id: " + studentCode);
        });
        StudentDTO studentDTO = MapperUtil.mapObject(studentEntity, StudentDTO.class);
        log.info("Successfully fetched student: id={}", studentDTO.getStudentCode());
        return studentDTO;
    }
}
