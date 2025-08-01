package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.SingleResourceSuccessResponseObject;
import com.smartsolutions.eschool.user.facade.UserServiceFacade;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/schools/{schoolId}/campuses/{campusUuid}/students")
public class UserController extends AbstractUserRestController {

    @Autowired
    public UserController(UserServiceFacade userServiceFacade) {
        super(userServiceFacade);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject createStudent(
            @PathVariable Long schoolId,
            @PathVariable String campusUuid,
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        return new SingleResourceSuccessResponseObject(
                asCurrentUser().createStudent(
                        schoolId,
                        campusUuid,
                        attributes,
                        AbstractUserRestController::toResourceObject));
    }

    // Get all students
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll(@PathVariable Long schoolId, @PathVariable String campusUuid) throws Exception {
        return new MultiResourceSuccessResponseObject(
                asCurrentUser().getAllStudents(schoolId, campusUuid)
                        .stream()
                        .map(AbstractUserRestController::toResourceObject)
                        .collect(Collectors.toList()));
    }

    // Get a student by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
//        Optional<StudentDto> student = studentService.findById(id);
//        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Update a student
//    @PutMapping("/{id}")
//    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto student) {
//        Optional<StudentDto> existingStudentOpt = studentService.findById(id);
//        if (existingStudentOpt.isPresent()) {
//            student.setId(id); // Ensure the ID is set to update the correct student
//            StudentDto updatedStudent = studentService.save(student);
//            return ResponseEntity.ok(updatedStudent);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete a student
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        studentService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
