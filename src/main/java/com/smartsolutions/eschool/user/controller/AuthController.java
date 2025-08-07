//package com.smartsolutions.eschool.students.controller;
//
//import com.smartsolutions.eschool.students.dto.StudentDto;
//import com.smartsolutions.eschool.students.dto.UserDto;
//import com.smartsolutions.eschool.students.entity.Student;
//import com.smartsolutions.eschool.students.service.StudentService;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//public class AuthController {
//
//    private StudentService userService;
//
//    public AuthController(StudentService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("index")
//    public String home(){
//        return "index";
//    }
//
//    @GetMapping("/login")
//    public String loginForm() {
//        return "login";
//    }
//
//    // handler method to handle user registration request
//    @GetMapping("register")
//    public String showRegistrationForm(Model model){
//        UserDto user = new UserDto();
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//    // handler method to handle register user form submit request
//    @PostMapping("/register/save")
//    public String registration(@Valid @ModelAttribute("user") StudentDto studentDto,
//                               BindingResult result,
//                               Model model){
//        Student existing = userService.findByEmail(studentDto.getEmail());
//        if (existing != null) {
//            result.rejectValue("email", null, "There is already an account registered with that email");
//        }
//        if (result.hasErrors()) {
//            model.addAttribute("student", studentDto);
//            return "register";
//        }
//        userService.saveStudent(studentDto);
//        return "redirect:/register?success";
//    }
//
//    @GetMapping("/users")
//    public String listRegisteredUsers(Model model){
//        List<StudentDto> students = userService.findAllStudents();
//        model.addAttribute("students", students);
//        return "students";
//    }
//}
