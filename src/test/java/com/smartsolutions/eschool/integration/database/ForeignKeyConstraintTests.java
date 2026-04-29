package com.smartsolutions.eschool.integration.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for foreign key constraints across the database
 * Tests:
 * - Referential integrity for Level 0 -> Level 1 dependencies
 * - Referential integrity for Level 4 -> Level 5 dependencies
 * - Referential integrity for Level 5 -> Level 6 dependencies
 * - Referential integrity for employee payroll dependencies
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Foreign Key Constraint Tests")
class ForeignKeyConstraintTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Should enforce FK: provinces.country_id -> country.id")
    void testProvinceCountryForeignKey() {
        String sql = "INSERT INTO provinces (country_id, name) VALUES (?, ?)";

        // Non-existent country should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 99999L, "Invalid Province");
        });
    }

    @Test
    @DisplayName("Should enforce FK: cities.province_id -> provinces.id")
    void testCityProvinceForeignKey() {
        // Setup a real province first
        Long countryId = setupCountry();
        Long provinceId = setupProvince(countryId);

        String sql = "INSERT INTO cities (province_id, name) VALUES (?, ?)";

        // Non-existent province should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 99999L, "Invalid City");
        });

        // Valid province should succeed
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql, provinceId, "Valid City");
        });
    }

    @Test
    @DisplayName("Should enforce FK: campuses.institute_id -> institutes.id")
    void testCampusInstituteForeignKey() {
        String sql = "INSERT INTO campuses (organization_id, institute_id, campus_name, active) " +
                "VALUES (?, ?, ?, ?)";

        // Non-existent institute should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, 99999L, "Test Campus", true);
        });
    }

    @Test
    @DisplayName("Should enforce FK: standards.campus_id -> campuses.id")
    void testStandardCampusForeignKey() {
        String sql = "INSERT INTO standards (organization_id, campus_id, standard_name, standard_code) " +
                "VALUES (?, ?, ?, ?)";

        // Non-existent campus should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, 99999L, "Grade 10", "G10");
        });
    }

    @Test
    @DisplayName("Should enforce FK: sections.standard_id -> standards.id")
    void testSectionStandardForeignKey() {
        String sql = "INSERT INTO sections (organization_id, standard_id, section_name) " +
                "VALUES (?, ?, ?)";

        // Non-existent standard should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, 99999L, "Section A");
        });
    }

    @Test
    @DisplayName("Should enforce FK: students.campus_id -> campuses.id")
    void testStudentCampusForeignKey() {
        setupRequiredStudentData();

        String sql = "INSERT INTO students (organization_id, first_name, full_name, last_name, " +
                "student_code, date_of_birth, gender, enrollment_date, campus_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Non-existent campus should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, "John", "John Doe", "Doe", "STU-INVALID",
                    LocalDate.of(2010, 1, 1), "M", LocalDate.now(), 99999L, 1L);
        });
    }

    @Test
    @DisplayName("Should enforce FK: students.academic_year_id -> academic_years.id")
    void testStudentAcademicYearForeignKey() {
        Long campusId = setupCampus();
        Long standardId = setupStandard(campusId);
        Long sectionId = setupSection(standardId);
        Long admissionTypeId = setupAdmissionType();

        String sql = "INSERT INTO students (organization_id, first_name, full_name, last_name, " +
                "student_code, date_of_birth, gender, enrollment_date, campus_id, standard_id, " +
                "section_id, admission_type_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Non-existent academic year should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, "John", "John Doe", "Doe", "STU-NOACADYEAR",
                    LocalDate.of(2010, 1, 1), "M", LocalDate.now(),
                    campusId, standardId, sectionId, admissionTypeId, 99999L);
        });
    }

    @Test
    @DisplayName("Should enforce FK: fee_rates.campus_id -> campuses.id")
    void testFeeRateCampusForeignKey() {
        Long standardId = setupStandard(setupCampus());
        Long academicYearId = setupAcademicYear();
        Long feeComponentId = setupFeeComponent();

        String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                "fee_component_id, academic_year_id, amount, effective_from, active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Non-existent campus should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, 99999L, standardId, feeComponentId, academicYearId,
                    5000.00, LocalDate.of(2024, 1, 1), true);
        });
    }

    @Test
    @DisplayName("Should enforce FK: student_fee_assignments.student_id -> students.id")
    void testStudentFeeAssignmentStudentForeignKey() {
        Long campusId = setupCampus();
        Long standardId = setupStandard(campusId);
        Long feeRateId = setupFeeRate(campusId, standardId);

        String sql = "INSERT INTO student_fee_assignments (organization_id, student_id, fee_rate_id, " +
                "total_amount) VALUES (?, ?, ?, ?)";

        // Non-existent student should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, 99999L, feeRateId, 5000.00);
        });
    }

    @Test
    @DisplayName("Should enforce FK: student_fee_payments.student_id -> students.id")
    void testStudentFeePaymentStudentForeignKey() {
        Long academicYearId = setupAcademicYear();

        String sql = "INSERT INTO student_fee_payments (organization_id, academic_year_id, " +
                "student_id, amount_paid, payment_month, payment_year) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        // Non-existent student should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, academicYearId, 99999L, 2500.00, "January", 2024);
        });
    }

    @Test
    @DisplayName("Should enforce FK: employee_master.employee_type_id -> employee_type.id")
    void testEmployeeMasterEmployeeTypeForeignKey() {
        String sql = "INSERT INTO employee_master (organization_id, employee_code, first_name, " +
                "last_name, full_name, email, employee_type_id, active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Non-existent employee type should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, "EMP-INVALID", "John", "Smith", "John Smith",
                    "john@example.com", 99999L, true);
        });
    }

    @Test
    @DisplayName("Should enforce FK: employee_salary.employee_id -> employee_master.id")
    void testEmployeeSalaryEmployeeForeignKey() {
        Long salaryStructureId = setupSalaryStructure();

        String sql = "INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, " +
                "gross_salary, total_deductions, net_salary, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Non-existent employee should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, 99999L, salaryStructureId, 50000.00, 10000.00, 40000.00,
                    LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should enforce FK: employee_bonus.employee_id -> employee_master.id")
    void testEmployeeBonusEmployeeForeignKey() {
        Long payrollPeriodId = setupPayrollPeriod();

        String sql = "INSERT INTO employee_bonus (organization_id, employee_id, bonus_type, amount, " +
                "payroll_period_id) VALUES (?, ?, ?, ?, ?)";

        // Non-existent employee should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, 99999L, "ANNUAL", 10000.00, payrollPeriodId);
        });
    }

    // Helper methods
    private Long setupCountry() {
        String sql = "INSERT INTO country (country_code, country_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, "PK", "Pakistan");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM country WHERE country_code = 'PK'", Long.class);
    }

    private Long setupProvince(Long countryId) {
        String sql = "INSERT INTO provinces (country_id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, countryId, "Sindh");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM provinces WHERE name = 'Sindh'", Long.class);
    }

    private Long setupCampus() {
        String sql = "INSERT INTO campuses (organization_id, campus_name, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "Main Campus", true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM campuses WHERE campus_name = 'Main Campus'", Long.class);
    }

    private Long setupStandard(Long campusId) {
        String sql = "INSERT INTO standards (organization_id, campus_id, standard_name, standard_code) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, campusId, "Grade 10", "G10");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM standards WHERE standard_code = 'G10'", Long.class);
    }

    private Long setupSection(Long standardId) {
        String sql = "INSERT INTO sections (organization_id, standard_id, section_name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, standardId, "A");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM sections WHERE section_name = 'A'", Long.class);
    }

    private Long setupAdmissionType() {
        String sql = "INSERT INTO admission_type (organization_id, code, name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "REGULAR", "Regular");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM admission_type WHERE code = 'REGULAR'", Long.class);
    }

    private Long setupAcademicYear() {
        String sql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, "AY-2024", "AY-2024",
                LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 12, "ACTIVE", 1L);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM academic_years WHERE code = 'AY-2024'", Long.class);
    }

    private Long setupFeeComponent() {
        Long feeCatalogId = null;
        try {
            feeCatalogId = jdbcTemplate.queryForObject(
                    "SELECT id FROM fee_catalog LIMIT 1", Long.class);
        } catch (Exception e) {
            // Ignore if empty
        }

        if (feeCatalogId == null) {
            String catalogSql = "INSERT INTO fee_catalog (organization_id, code, name, charge_type) " +
                    "VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(catalogSql, 1L, "TUITION", "Tuition Fee", "FIXED");
            feeCatalogId = jdbcTemplate.queryForObject(
                    "SELECT id FROM fee_catalog WHERE code = 'TUITION'", Long.class);
        }

        String sql = "INSERT INTO fee_component (organization_id, fee_catalog_id, component_code, " +
                "component_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, feeCatalogId, "TUITION", "Monthly Tuition");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM fee_component WHERE component_code = 'TUITION'", Long.class);
    }

    private Long setupFeeRate(Long campusId, Long standardId) {
        Long academicYearId = setupAcademicYear();
        Long feeComponentId = setupFeeComponent();

        String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                "fee_component_id, academic_year_id, amount, effective_from, active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                1L, campusId, standardId, feeComponentId, academicYearId,
                5000.00, LocalDate.of(2024, 1, 1), true);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM fee_rates ORDER BY id DESC LIMIT 1", Long.class);
    }

    private Long setupSalaryStructure() {
        Long employeeTypeId = setupEmployeeType();

        String sql = "INSERT INTO salary_structure (organization_id, employee_type_id, base_salary, " +
                "effective_from, is_current) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, employeeTypeId, 50000.00, LocalDate.of(2024, 1, 1), true);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM salary_structure ORDER BY id DESC LIMIT 1", Long.class);
    }

    private Long setupEmployeeType() {
        String sql = "INSERT INTO employee_type (organization_id, name, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "Teacher", true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM employee_type WHERE name = 'Teacher'", Long.class);
    }

    private Long setupPayrollPeriod() {
        String sql = "INSERT INTO payroll_period (organization_id, start_date, end_date, status) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31), "PENDING");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM payroll_period ORDER BY id DESC LIMIT 1", Long.class);
    }

    private void setupRequiredStudentData() {
        Long campusId = setupCampus();
        Long standardId = setupStandard(campusId);
        setupSection(standardId);
        setupAdmissionType();
        setupAcademicYear();
    }
}
