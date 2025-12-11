package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.global.configs.GenderConfig;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.service.StudentService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Scope("prototype")
public class StudentFacade {


    private final StudentService studentService;
    private final GenderConfig genderConfig;
    private Set<String> genderKeys;

    public StudentFacade(StudentService studentService, GenderConfig genderConfig) {
        this.studentService = studentService;
        this.genderConfig = genderConfig;
        genderKeys = this.genderConfig.getList().keySet();
    }

    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        return studentService.getStudentsByCampus(campusId);
    }

    public List<StudentDTO> getStudentsByName(String studentName) {
        return studentService.getStudentsByName(studentName);
    }

    public List<StudentDTO> getStudentsByStandard(Long id) {
        return studentService.getStudentsByStandard(id);
    }

    public List<StudentDTO> getStudentsBySection(Long id) {
        return studentService.getStudentsBySection(id);
    }

    public StudentDTO getById(Long id) {
        return studentService.getById(id);
    }

    public StudentDTO getByStudentCode(String studentCode) {
        return studentService.getByStudentCode(studentCode);
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    public Long getTotalStudents() {
        return studentService.getTotalStudents();
    }

    public Long getTotalStudentsByCampus(Long campusId) {
        return studentService.getTotalStudentsByCampus(campusId);
    }

    public Long getTotalStudentsByStandard(Long standardId) {
        return studentService.getTotalStudentsByStandard(standardId);
    }

    public Long getTotalStudentsBySection(Long sectionId) {
        return studentService.getTotalStudentsBySection(sectionId);
    }

    public Long getTotalStudentsByGender(String gender) {
        return studentService.getTotalStudentsByGender(gender);
    }

    public long getStudentsRegisteredThisMonth() {
        return studentService.getStudentsRegisteredThisMonth();
    }


    public StudentDashboardDTO getStudentDashboardInfo(Long campusId, Long standardId, Long sectionId, String gender) {
        StudentDashboardDTO studentDashboardDTO = new StudentDashboardDTO();

        Map<String, Long> studentCountByGender = new HashMap<>();
        for (String key : genderKeys) {
            studentCountByGender.put(key, getTotalStudentsByGender(key));
        }

        Long maleStudent = studentCountByGender.get("MALE");
        Long femaleStudent = studentCountByGender.get("FEMALE");
        Long otherStudent = studentCountByGender.get("OTHER");


        Long totalStudents = getTotalStudents();
        Long totalStudentByMonth = getStudentsRegisteredThisMonth();
        studentDashboardDTO.setTotalFemaleStudents(femaleStudent);
        studentDashboardDTO.setTotalMaleStudents(maleStudent);
        studentDashboardDTO.setTotalOtherStudents(otherStudent);
        studentDashboardDTO.setTotalStudents(totalStudents);
        studentDashboardDTO.setStudentsRegisteredThisMonth(totalStudentByMonth);
        return studentDashboardDTO;
    }
}


