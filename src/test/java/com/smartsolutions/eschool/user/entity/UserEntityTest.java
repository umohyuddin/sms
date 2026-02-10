package com.smartsolutions.eschool.user.entity;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserEntityTest {
    @Test
    public void testLombokGeneratedMethods() {
        SystemUserEntity userEntity = new SystemUserEntity();
        // userEntity.set("John");
        // assertEquals("John", userEntity.getFirstName());
    }

    @Test
    void testPasswordMatchesHash() {
        String rawPassword = "123456";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(rawPassword); // generates new valid hash

        boolean matches = passwordEncoder.matches(rawPassword, hashedPassword);

        assertTrue(matches, "Password should match the hash");
    }
}
