package com.smartsolutions.eschool.user.student.facade;

import com.smartsolutions.eschool.util.ReturnFunction;
import com.smartsolutions.eschool.user.student.model.User;
import com.smartsolutions.eschool.user.student.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class UserServiceFacade {
    private static final Log LOG = LogFactory.getLog(UserServiceFacade.class);
    private User user;
    @Autowired
    @Lazy
    private StudentService studentService;

    public UserServiceFacade changeUser() {
        //this.user = user;
        return this;
    }

    public List<User> getAllStudents(Long schoolId, String campusUuid) {
        return studentService.getAllStudents(schoolId, campusUuid);
    }

    public void createStudent(User user) {
        studentService.createStudent(user);
    }

    public <O> O createStudent(
            Long schoolId,
            String campusUuid,
            Map<String, Object> attributes,
            ReturnFunction<User, O> returnFunction)
            throws Exception {

        if (attributes.isEmpty()) {
            throw new Exception("Data is missing");
        }

        User nUser = new User();
        nUser.setSchoolId(schoolId);
        nUser.setCampusUuid(campusUuid);
        nUser.setFirstName((String) attributes.get("firstName"));
        nUser.setLastName((String) attributes.get("lastName"));
        nUser.setEmail((String) attributes.get("email"));
        studentService.createStudent(nUser);

        return returnFunction.getObject(nUser);
    }
}
