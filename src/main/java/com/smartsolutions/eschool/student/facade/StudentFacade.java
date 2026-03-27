package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.global.configs.GenderConfig;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentBasicInfoUpdateDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class StudentFacade {

    private final StudentService studentService;
    private final GenderConfig genderConfig;

    public List<StudentDTO> getAll() {
        log.info("[Facade:StudentFacade] getAll() called");
        return studentService.getAll();
    }

    public List<StudentDTO> getActive() {
        log.info("[Facade:StudentFacade] getActive() called");
        return studentService.getActive();
    }

    public List<StudentDTO> getInactive() {
        log.info("[Facade:StudentFacade] getInactive() called");
        return studentService.getInactive();
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        log.info("[Facade:StudentFacade] getStudentsByCampus() called for: {}", campusId);
        return studentService.getStudentsByCampus(campusId);
    }

    public List<StudentDTO> getStudentsByName(String studentName) {
        log.info("[Facade:StudentFacade] getStudentsByName() called for: {}", studentName);
        return studentService.getStudentsByName(studentName);
    }

    public List<StudentDTO> getStudentsByStandard(Long id) {
        log.info("[Facade:StudentFacade] getStudentsByStandard() called for: {}", id);
        return studentService.getStudentsByStandard(id);
    }

    public List<StudentDTO> getStudentsBySection(Long id) {
        log.info("[Facade:StudentFacade] getStudentsBySection() called for: {}", id);
        return studentService.getStudentsBySection(id);
    }

    public StudentResponseDTO getById(Long id) {
        log.info("[Facade:StudentFacade] getById() called for: {}", id);
        return studentService.getById(id);
    }

    public StudentDTO getByStudentCode(String studentCode) {
        log.info("[Facade:StudentFacade] getByStudentCode() called for: {}", studentCode);
        return studentService.getByStudentCode(studentCode);
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentDTO) {
        log.info("[Facade:StudentFacade] createStudent() called");
        return studentService.createStudent(studentDTO);
    }

    public StudentResponseDTO updateStudent(Long studentId, StudentRequestDTO studentRequestDTO) {
        log.info("[Facade:StudentFacade] updateStudent() called for: {}", studentId);
        return studentService.updateStudent(studentId, studentRequestDTO);
    }

    public StudentResponseDTO updateStudentBasicInfo(Long studentId, StudentBasicInfoUpdateDTO basicInfoDTO) {
        log.info("[Facade:StudentFacade] updateStudentBasicInfo() called for: {}", studentId);
        return studentService.updateStudentBasicInfo(studentId, basicInfoDTO);
    }

    public void softDeleteStudent(Long studentId) {
        log.info("[Facade:StudentFacade] softDeleteStudent() called for: {}", studentId);
        studentService.softDeleteStudent(studentId);
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
        log.info("[Facade:StudentFacade] getStudentDashboardInfo() called");
        StudentDashboardDTO studentDashboardDTO = new StudentDashboardDTO();

        Map<String, Long> studentCountByGender = new HashMap<>();
        if (genderConfig != null && genderConfig.getList() != null) {
            Set<String> genderKeys = genderConfig.getList().keySet();
            for (String key : genderKeys) {
                studentCountByGender.put(key, getTotalStudentsByGender(key));
            }
        }

        Long maleStudent = studentCountByGender.getOrDefault("MALE", 0L);
        Long femaleStudent = studentCountByGender.getOrDefault("FEMALE", 0L);
        Long otherStudent = studentCountByGender.getOrDefault("OTHER", 0L);

        Long totalStudents = getTotalStudents();
        Long totalStudentByMonth = getStudentsRegisteredThisMonth();

        studentDashboardDTO.setTotalFemaleStudents(femaleStudent);
        studentDashboardDTO.setTotalMaleStudents(maleStudent);
        studentDashboardDTO.setTotalOtherStudents(otherStudent);
        studentDashboardDTO.setTotalStudents(totalStudents);
        studentDashboardDTO.setStudentsRegisteredThisMonth(totalStudentByMonth);
        
        return studentDashboardDTO;
    }

    public List<StudentDTO> searchStudents(Long campusId, Long standardId, Long sectionId, Long studentId, Long academicYearId, String kw) {
        log.info("[Facade:StudentFacade] searchStudents() called");
        return studentService.searchStudents(campusId, standardId, sectionId, studentId, academicYearId, kw);
    }

    public void saveStudentDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        log.info("[Facade:StudentFacade] saveStudentDocument() called");
        studentService.saveStudentDocument(employeeId, docKey, file);
    }

    public List<StudentDocumentResponseDto> getSaveDocuments(Long employeeId) {
        log.info("[Facade:StudentFacade] getSaveDocuments() called");
        return studentService.getDocumentsByStudentId(employeeId);
    }

    public Map<String, List<StudentDocumentResponseDto>> getDocumentsByEmployeeId(Long employeeId) {
        log.info("[Facade:StudentFacade] getDocumentsByEmployeeId() called");
        return studentService.getGroupedDocuments(employeeId);
    }

    public Resource getDocumentById(Long documentId, Long employeeId) {
        log.info("[Facade:StudentFacade] getDocumentById() called");
        return studentService.downloadDocument(documentId, employeeId);
    }
}
