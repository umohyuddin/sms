package com.smartsolutions.eschool.student.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.mapper.StudentMapper;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.AdmissionTypeRepository;
import com.smartsolutions.eschool.student.repository.StudentDao;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    private final StudentRepository studentRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final AcademicYearRepository academicYearRepository;
    private final AdmissionTypeRepository admissionTypeRepository;


    public StudentService(StudentRepository studentRepository, CampusRepository campusRepository, StandardRepository standardRepository, SectionRepository sectionRepository, AcademicYearRepository academicYearRepository, AdmissionTypeRepository admissionTypeRepository) {
        this.studentRepository = studentRepository;
        this.campusRepository = campusRepository;
        this.standardRepository = standardRepository;
        this.sectionRepository = sectionRepository;
        this.academicYearRepository = academicYearRepository;
        this.admissionTypeRepository = admissionTypeRepository;
    }

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

    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO studentDTO) {
        log.info("Creating new Student: {}", studentDTO);

        // Fetch related entities from DB
        CampusEntity campus = campusRepository.findById(studentDTO.getCampusId()).orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + studentDTO.getCampusId()));

        StandardEntity standard = standardRepository.findById(studentDTO.getStandardId()).orElseThrow(() -> new ResourceNotFoundException("Standard not found with id: " + studentDTO.getStandardId()));

        SectionEntity section = sectionRepository.findById(studentDTO.getSectionId()).orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + studentDTO.getSectionId()));

        AdmissionTypeEntity admissionType = admissionTypeRepository.findById(studentDTO.getAdmissionTypeId()).orElseThrow(() -> new ResourceNotFoundException("Admission Type not found with id: " + studentDTO.getAdmissionTypeId()));

        AcademicYearEntity academicYear = academicYearRepository.findById(studentDTO.getAcademicYearId()).orElseThrow(() -> new ResourceNotFoundException("Academic Year not found with id: " + studentDTO.getAcademicYearId()));

        // Manual mapping from DTO to Entity
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setFullName(studentDTO.getFullName());
        studentEntity.setStudentCode(studentDTO.getStudentCode());
        studentEntity.setDateOfBirth(studentDTO.getDateOfBirth());
        studentEntity.setGender(studentDTO.getGender());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhone(studentDTO.getPhone());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setCnic(studentDTO.getCnic());
        studentEntity.setPassportNumber(studentDTO.getPassportNumber());
        studentEntity.setReligion(studentDTO.getReligion());
        studentEntity.setNationality(studentDTO.getNationality());
        studentEntity.setBloodGroup(studentDTO.getBloodGroup());
        studentEntity.setEnrollmentDate(studentDTO.getEnrollmentDate());
        studentEntity.setIsActive(studentDTO.getIsActive() != null ? studentDTO.getIsActive() : true);
        studentEntity.setStatus(studentDTO.getStatus());
        studentEntity.setDeleted(false);

        // Assign existing related entities
        studentEntity.setCampus(campus);
        studentEntity.setStandard(standard);
        studentEntity.setSection(section);
        studentEntity.setAdmissionType(admissionType);
        studentEntity.setAcademicYear(academicYear);

        // Save entity
        StudentEntity savedStudent = studentRepository.save(studentEntity);

        // Map back to DTO for response
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(savedStudent.getId());
        responseDTO.setFirstName(savedStudent.getFirstName());
        responseDTO.setLastName(savedStudent.getLastName());
        responseDTO.setFullName(savedStudent.getFullName());
        responseDTO.setStudentCode(savedStudent.getStudentCode());
        responseDTO.setDateOfBirth(savedStudent.getDateOfBirth());
        responseDTO.setGender(savedStudent.getGender());
        responseDTO.setEmail(savedStudent.getEmail());
        responseDTO.setPhone(savedStudent.getPhone());
        responseDTO.setAddress(savedStudent.getAddress());
        responseDTO.setCnic(savedStudent.getCnic());
        responseDTO.setPassportNumber(savedStudent.getPassportNumber());
        responseDTO.setReligion(savedStudent.getReligion());
        responseDTO.setNationality(savedStudent.getNationality());
        responseDTO.setBloodGroup(savedStudent.getBloodGroup());
        responseDTO.setEnrollmentDate(savedStudent.getEnrollmentDate());
        responseDTO.setIsActive(savedStudent.getIsActive());
        responseDTO.setStatus(savedStudent.getStatus());

        // Include FK info if needed
        responseDTO.setCampusId(savedStudent.getCampus().getId());
        responseDTO.setStandardId(savedStudent.getStandard().getId());
        responseDTO.setSectionId(savedStudent.getSection().getId());
        responseDTO.setAdmissionTypeId(savedStudent.getAdmissionType().getId());
        responseDTO.setAcademicYearId(savedStudent.getAcademicYear().getId());
        responseDTO.setAcademicYearName(savedStudent.getAcademicYear().getName());

        log.info("Successfully created Student: {}", responseDTO);
        return responseDTO;
    }


    public Long getTotalStudents() {
        return studentRepository.countAllActiveStudents();
    }

    public Long getTotalStudentsByCampus(Long campusId) {
        return studentRepository.countByCampus(campusId);
    }

    public Long getTotalStudentsByStandard(Long standardId) {
        return studentRepository.countByStandard(standardId);
    }

    public Long getTotalStudentsBySection(Long sectionId) {
        return studentRepository.countBySection(sectionId);
    }

    public Long getTotalStudentsByGender(String gender) {
        return studentRepository.countByGender(gender);
    }


    public Long getStudentsRegisteredThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        return studentRepository.countStudentsRegisteredBetween(start, end);
    }

    public List<StudentDTO> searchStudents(Long campusId, Long standardId, Long studentId, Long academicYearId) {
        try {
            log.info("Searching students with filters → campusId={}, standardId={}, studentId={}, academicYearId={}", campusId, standardId, studentId, academicYearId);

            List<StudentEntity> result = studentRepository.searchStudents(campusId, standardId, studentId, academicYearId);

            log.info("Student search returned {} results", result.size());

            // Convert entity → DTO
            return MapperUtil.mapList(result, StudentDTO.class);

        } catch (Exception e) {
            log.error("Error searching students", e);
            return Collections.emptyList();
        }
    }
}
