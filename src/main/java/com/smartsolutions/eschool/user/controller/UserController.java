package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.model.UserEntity;
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
@RequestMapping("/api/schools/user")
public class UserController extends AbstractUserRestController {

    @Autowired
    public UserController(UserServiceFacade userServiceFacade) {
        super(userServiceFacade);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject createUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        UserEntity nUserEntity = new UserEntity();
        nUserEntity.setRoleId((Long) attributes.get("role_id"));
        nUserEntity.setEmpId((Long) attributes.get("emp_id"));
        nUserEntity.setCmpId((Long) attributes.get("cmp_id"));
        nUserEntity.setActive((boolean) attributes.get("isactive"));
        nUserEntity.setAccountNonExpired((Boolean) attributes.get("account_non_expired"));
        nUserEntity.setAccountNonLocked((Boolean) attributes.get("account_non_locked"));
        nUserEntity.setCredentialsNonExpired((Boolean) attributes.get("credentials_non_expired"));
        nUserEntity.setEmail(String.valueOf(attributes.get("email")));
        nUserEntity.setEnabled((Boolean)attributes.get("enabled"));
        nUserEntity.setPassword((String) attributes.get("password"));
        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                asCurrentUser().createUser(nUserEntity)));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject updateUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        UserEntity nUserEntity = new UserEntity();
        nUserEntity.setRoleId((Long) attributes.get("role_id"));
        nUserEntity.setEmpId((Long) attributes.get("emp_id"));
        nUserEntity.setCmpId((Long) attributes.get("cmp_id"));
        nUserEntity.setActive((boolean) attributes.get("isactive"));
        nUserEntity.setAccountNonExpired((Boolean) attributes.get("account_non_expired"));
        nUserEntity.setAccountNonLocked((Boolean) attributes.get("account_non_locked"));
        nUserEntity.setCredentialsNonExpired((Boolean) attributes.get("credentials_non_expired"));
        nUserEntity.setEmail(String.valueOf(attributes.get("email")));
        nUserEntity.setEnabled((Boolean)attributes.get("enabled"));
        nUserEntity.setPassword((String) attributes.get("password"));
        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                asCurrentUser().updateUser(nUserEntity)));
    }

    // Get all students
    @GetMapping(value = "/get/{institute_Id}/campuses/{campus_id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getUsers(@PathVariable Long institute_Id, @PathVariable Long campus_id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                asCurrentUser().getUsers(institute_Id, campus_id)
                        .stream()
                        .map(AbstractUserRestController::toResourceObject)
                        .collect(Collectors.toList()));
    }
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                asCurrentUser().getAllUsers()
                        .stream()
                        .map(AbstractUserRestController::toResourceObject)
                        .collect(Collectors.toList()));
    }
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject deleteUser(
            @PathVariable Long user_Id
            ) throws Exception {

        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                asCurrentUser().deleteUser(user_Id)));
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
