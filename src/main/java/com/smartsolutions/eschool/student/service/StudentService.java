package com.smartsolutions.eschool.student.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentDao;
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
    private StudentDao studentDao;
    @Autowired
    private ObjectMapper objectMapper;


    public List<StudentDTO> getAll() {
        try {
            log.info("Fetching all Students from database");
            List<StudentEntity> result = studentDao.findAll();
            log.info("Successfully fetched {} Students", result.size());
            List<StudentDTO> studentDTOList = MapperUtil.mapList(result, StudentDTO.class);
            log.info("Successfully fetched {} Students", studentDTOList);
            return studentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching students", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to StudentDTO", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching students", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StudentEntity getById(Long id) {
        return studentDao.findById(id);
    }

    public List<StudentEntity> getByCampus(Long campus_id) {
        return studentDao.findByCampus(campus_id);
    }

    public List<StudentEntity> getByInstitute(Long institute_id) {
        return studentDao.findByInstitute(institute_id);
    }

    public String create(StudentEntity pStudentEntity) {
        return studentDao.save(pStudentEntity) == 1 ? "Student created" : "Error creating Student";
    }

    public String update(StudentEntity pStudentEntity) {
        return studentDao.update(pStudentEntity) == 1 ? "Student updated" : "Error updating Student";
    }

    public String delete(Long id) {
        return studentDao.delete(id) == 1 ? "Student deleted" : "Error deleting Student";
    }

}
