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
 * Integration tests for discount tables (discount_rate, student_discount_assignment)
 * Tests:
 * - Discount value >= 0 validation
 * - Percentage range validation (0-100 for percentages)
 * - Date range validation
 * - Foreign key constraints
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Discount Constraint Tests")
class DiscountConstraintTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Long academicYearId;
    private Long discountSubTypeId;
    private Long campusId;
    private Long studentId;

    @BeforeEach
    void setup() {
        academicYearId = setupAcademicYear();
        discountSubTypeId = setupDiscountSubType();
        campusId = setupCampus();
        studentId = setupStudent();
    }

    @Test
    @DisplayName("Should accept discount rate with value >= 0")
    void testDiscountRateValueConstraint() {
        String sql = "INSERT INTO discount_rate (organization_id, value, is_percentage, " +
                "effective_from, effective_to, discount_sub_type_id, campus_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, 500.00, false,
                    LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31),
                    discountSubTypeId, campusId, academicYearId);
        });
    }

    @Test
    @DisplayName("Should reject discount rate with negative value")
    void testDiscountRateNegativeValueRejection() {
        String sql = "INSERT INTO discount_rate (organization_id, value, is_percentage, " +
                "discount_sub_type_id, campus_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, -100.00, false,
                    discountSubTypeId, campusId, academicYearId);
        });
    }

    @Test
    @DisplayName("Should accept percentage discount with value between 0-100")
    void testPercentageDiscountRangeConstraint() {
        String sql = "INSERT INTO discount_rate (organization_id, value, is_percentage, " +
                "discount_sub_type_id, campus_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        // Test boundary value: 0%
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql, 1L, 0.00, true, discountSubTypeId, campusId, academicYearId);
        });

        // Test boundary value: 100%
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql, 1L, 100.00, true, discountSubTypeId, campusId, academicYearId);
        });

        // Test mid-range: 50%
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql, 1L, 50.00, true, discountSubTypeId, campusId, academicYearId);
        });
    }

    @Test
    @DisplayName("Should reject percentage discount with value > 100")
    void testPercentageDiscountOverflowRejection() {
        String sql = "INSERT INTO discount_rate (organization_id, value, is_percentage, " +
                "discount_sub_type_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, 150.00, true, discountSubTypeId, academicYearId);
        });
    }

    @Test
    @DisplayName("Should accept student discount assignment with valid amount")
    void testStudentDiscountAmountValidation() {
        long discountRateId = setupDiscountRate();

        String sql = "INSERT INTO student_discount_assignment (organization_id, student_id, " +
                "campus_id, discount_rate_id, academic_year_id, applied_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, studentId, campusId, discountRateId, academicYearId, 500.00);
        });
    }

    @Test
    @DisplayName("Should reject student discount assignment with negative amount")
    void testStudentDiscountNegativeAmountRejection() {
        long discountRateId = setupDiscountRate();

        String sql = "INSERT INTO student_discount_assignment (organization_id, student_id, " +
                "campus_id, discount_rate_id, academic_year_id, applied_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, studentId, campusId, discountRateId, academicYearId, -100.00);
        });
    }

    @Test
    @DisplayName("Should accept student discount percentage between 0-100")
    void testStudentDiscountPercentageValidation() {
        long discountRateId = setupDiscountRate();

        String sql = "INSERT INTO student_discount_assignment (organization_id, student_id, " +
                "campus_id, discount_rate_id, academic_year_id, applied_percentage) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, studentId, campusId, discountRateId, academicYearId, 25.00);
        });
    }

    @Test
    @DisplayName("Should reject student discount percentage > 100")
    void testStudentDiscountPercentageOverflowRejection() {
        long discountRateId = setupDiscountRate();

        String sql = "INSERT INTO student_discount_assignment (organization_id, student_id, " +
                "campus_id, discount_rate_id, academic_year_id, applied_percentage) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, studentId, campusId, discountRateId, academicYearId, 150.00);
        });
    }

    @Test
    @DisplayName("Should enforce unique constraint on student discount assignment")
    void testStudentDiscountUniqueConstraint() {
        long discountRateId = setupDiscountRate();

        String sql = "INSERT INTO student_discount_assignment (organization_id, student_id, " +
                "campus_id, discount_rate_id, academic_year_id, applied_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        // First insert should succeed
        jdbcTemplate.update(sql, 1L, studentId, campusId, discountRateId, academicYearId, 500.00);

        // Second insert with same student+discount+year should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, studentId, campusId, discountRateId, academicYearId, 300.00);
        });
    }

    // Helper methods
    private Long setupAcademicYear() {
        String sql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, "AY-2024", "AY-2024",
                LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 12, "ACTIVE", 1L);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM academic_years WHERE code = 'AY-2024'", Long.class);
    }

    private Long setupDiscountSubType() {
        // Setup discount type first
        String discountTypeSql = "INSERT INTO discount_type (organization_id, code, name, charge_type) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(discountTypeSql, 1L, "MERIT", "Merit Discount", "PERCENTAGE");

        Long discountTypeId = jdbcTemplate.queryForObject(
                "SELECT id FROM discount_type WHERE code = 'MERIT'", Long.class);

        String sql = "INSERT INTO discount_sub_type (organization_id, discount_type_id, code, name) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, discountTypeId, "MERIT_50", "50% Merit");

        return jdbcTemplate.queryForObject(
                "SELECT id FROM discount_sub_type WHERE code = 'MERIT_50'", Long.class);
    }

    private Long setupCampus() {
        String sql = "INSERT INTO campuses (organization_id, campus_name, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "Main Campus", true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM campuses WHERE campus_name = 'Main Campus'", Long.class);
    }

    private Long setupStudent() {
        // Setup prerequisite data
        long standardId = setupStandard();
        long sectionId = setupSection(standardId);
        long admissionTypeId = setupAdmissionType();

        String sql = "INSERT INTO students (organization_id, first_name, full_name, last_name, " +
                "student_code, date_of_birth, gender, enrollment_date, campus_id, standard_id, " +
                "section_id, admission_type_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                1L, "Jane", "Jane Doe", "Doe", "STU-002",
                LocalDate.of(2010, 1, 1), "F", LocalDate.now(),
                campusId, standardId, sectionId, admissionTypeId, academicYearId);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM students WHERE student_code = 'STU-002'", Long.class);
    }

    private Long setupStandard() {
        String sql = "INSERT INTO standards (organization_id, campus_id, standard_name, standard_code) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, campusId, "Grade 9", "G9");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM standards WHERE standard_code = 'G9'", Long.class);
    }

    private Long setupSection(Long standardId) {
        String sql = "INSERT INTO sections (organization_id, standard_id, section_name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, standardId, "B");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM sections WHERE section_name = 'B'", Long.class);
    }

    private Long setupAdmissionType() {
        String sql = "INSERT INTO admission_type (organization_id, code, name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "TRANSFER", "Transfer");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM admission_type WHERE code = 'TRANSFER'", Long.class);
    }

    private Long setupDiscountRate() {
        String sql = "INSERT INTO discount_rate (organization_id, value, is_percentage, " +
                "discount_sub_type_id, campus_id, academic_year_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, 25.00, true, discountSubTypeId, campusId, academicYearId);

        return jdbcTemplate.queryForObject(
                "SELECT id FROM discount_rate ORDER BY id DESC LIMIT 1", Long.class);
    }
}
