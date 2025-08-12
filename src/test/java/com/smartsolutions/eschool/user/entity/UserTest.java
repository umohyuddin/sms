package com.smartsolutions.eschool.user.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testLombokGeneratedMethods() {
        User user = new User();
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }
}
