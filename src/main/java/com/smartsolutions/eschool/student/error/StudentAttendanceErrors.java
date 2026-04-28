package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;
import lombok.Getter;

@Getter
public enum StudentAttendanceErrors implements BaseErrorCode {
    ATTENDANCE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 101, "Student attendance record not found"),
    DUPLICATE_ATTENDANCE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 102, "Attendance already marked for this student on this date"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 103, "Access denied: Organization not found in session"),
    STUDENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 104, "Student not found"),
    CAMPUS_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 105, "Campus not found"),
    STANDARD_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 106, "Standard not found"),
    SECTION_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 107, "Section not found"),
    EMPLOYEE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 108, "Employee not found");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    StudentAttendanceErrors(AppModule module, ErrorCategory category, int number, String message) {
        this.module = module;
        this.category = category;
        this.number = number;
        this.message = message;
    }

    @Override
    public AppModule module() {
        return module;
    }

    @Override
    public ErrorCategory category() {
        return category;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public String message() {
        return message;
    }
}
