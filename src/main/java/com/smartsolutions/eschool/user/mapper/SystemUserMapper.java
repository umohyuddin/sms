package com.smartsolutions.eschool.user.mapper;

import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.user.model.SystemUserEntity;

public class SystemUserMapper {

    private SystemUserMapper() {
        // prevent instantiation
    }

    public static SystemUserEntity toEntity(StudentEntity student, String encodedPassword, Long orgId) {
        if (student == null) return null;
        
        SystemUserEntity user = new SystemUserEntity();
        user.setOrganizationId(orgId);
        user.setUsername(student.getStudentCode());
        user.setEmail(student.getEmail());
        user.setPhone(student.getPhone());
        user.setPasswordHash(encodedPassword);
        user.setUserType(SystemUserEntity.UserType.STUDENT);
        user.setStudent(student);
        user.setIsActive(true);
        user.setIsVerified(true);
        
        return user;
    }
}
