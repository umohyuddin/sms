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
 * Integration tests for fee-related tables (fee_rates, fee_component,
 * student_fee_*)
 * Tests:
 * - Amount >= 0 validation
 * - Date range validation (effective_to >= effective_from)
 * - Foreign key constraints
 * - Fee payment and assignment tracking
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Fee Table Constraint Tests")
class FeeTableConstraintTests {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        private Long academicYearId;
        private Long campusId;
        private Long standardId;
        private Long feeComponentId;
        private Long studentId;

        @BeforeEach
        void setup() {
                // Setup academic year
                academicYearId = setupAcademicYear();
                // Setup campus and academic structure
                campusId = setupCampus();
                standardId = setupStandard();
                // Setup fee component
                feeComponentId = setupFeeComponent();
                // Setup student
                studentId = setupStudent();
        }

        @Test
        @DisplayName("Should accept fee rate with amount >= 0")
        void testFeeRateAmountConstraint() {
                String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                                "fee_component_id, academic_year_id, amount, effective_from, effective_to, active) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                assertDoesNotThrow(() -> {
                        jdbcTemplate.update(sql,
                                        1L, campusId, standardId, feeComponentId, academicYearId,
                                        5000.00, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), true);
                });
        }

        @Test
        @DisplayName("Should reject fee rate with negative amount")
        void testFeeRateNegativeAmountRejection() {
                String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                                "fee_component_id, academic_year_id, amount, effective_from, active) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                assertThrows(Exception.class, () -> {
                        jdbcTemplate.update(sql,
                                        1L, campusId, standardId, feeComponentId, academicYearId,
                                        -100.00, LocalDate.of(2024, 1, 1), true);
                });
        }

        @Test
        @DisplayName("Should enforce fee rate date range validation")
        void testFeeRateDateRangeValidation() {
                String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                                "fee_component_id, academic_year_id, amount, effective_from, effective_to, active) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                assertThrows(Exception.class, () -> {
                        jdbcTemplate.update(sql,
                                        1L, campusId, standardId, feeComponentId, academicYearId,
                                        5000.00, LocalDate.of(2024, 12, 31), LocalDate.of(2024, 1, 1), true);
                });
        }

        @Test
        @DisplayName("Should accept student fee assignment with valid amount")
        void testStudentFeeAssignmentAmountValidation() {
                // First create a fee rate
                long feeRateId = setupFeeRate();

                String sql = "INSERT INTO student_fee_assignments (organization_id, student_id, " +
                                "fee_rate_id, total_amount, due_date, assigned_date) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

                assertDoesNotThrow(() -> {
                        jdbcTemplate.update(sql,
                                        1L, studentId, feeRateId, 5000.00,
                                        LocalDate.of(2024, 2, 28), LocalDate.of(2024, 1, 15));
                });
        }

        @Test
        @DisplayName("Should reject student fee assignment with negative amount")
        void testStudentFeeAssignmentNegativeAmountRejection() {
                long feeRateId = setupFeeRate();

                String sql = "INSERT INTO student_fee_assignments (organization_id, student_id, " +
                                "fee_rate_id, total_amount) VALUES (?, ?, ?, ?)";

                assertThrows(Exception.class, () -> {
                        jdbcTemplate.update(sql, 1L, studentId, feeRateId, -100.00);
                });
        }

        @Test
        @DisplayName("Should accept student fee payment with amount >= 0")
        void testStudentFeePaymentAmountValidation() {
                String sql = "INSERT INTO student_fee_payments (organization_id, academic_year_id, " +
                                "student_id, amount_paid, payment_month, payment_year) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

                assertDoesNotThrow(() -> {
                        jdbcTemplate.update(sql,
                                        1L, academicYearId, studentId, 2500.00, "January", 2024);
                });
        }

        @Test
        @DisplayName("Should reject student fee payment with negative amount")
        void testStudentFeePaymentNegativeAmountRejection() {
                String sql = "INSERT INTO student_fee_payments (organization_id, academic_year_id, " +
                                "student_id, amount_paid, payment_month, payment_year) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

                assertThrows(Exception.class, () -> {
                        jdbcTemplate.update(sql,
                                        1L, academicYearId, studentId, -500.00, "January", 2024);
                });
        }

        @Test
        @DisplayName("Should validate student fee summary totals")
        void testStudentFeeSummaryValidation() {
                String sql = "INSERT INTO student_fee_summary (organization_id, student_id, " +
                                "academic_year_id, total_assigned_fee, total_paid, balance) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

                assertDoesNotThrow(() -> {
                        jdbcTemplate.update(sql,
                                        1L, studentId, academicYearId, 10000.00, 5000.00, 5000.00);
                });
        }

        @Test
        @DisplayName("Should reject fee summary with negative total_assigned_fee")
        void testFeeSummaryNegativeTotalRejection() {
                String sql = "INSERT INTO student_fee_summary (organization_id, student_id, " +
                                "academic_year_id, total_assigned_fee, total_paid, balance) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

                assertThrows(Exception.class, () -> {
                        jdbcTemplate.update(sql,
                                        1L, studentId, academicYearId, -100.00, 0.00, 0.00);
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

        private Long setupCampus() {
                String sql = "INSERT INTO campuses (organization_id, campus_name, active) VALUES (?, ?, ?)";
                jdbcTemplate.update(sql, 1L, "Main Campus", true);
                return jdbcTemplate.queryForObject(
                                "SELECT id FROM campuses WHERE campus_name = 'Main Campus'", Long.class);
        }

        private Long setupStandard() {
                String sql = "INSERT INTO standards (organization_id, campus_id, standard_name, standard_code) " +
                                "VALUES (?, ?, ?, ?)";
                jdbcTemplate.update(sql, 1L, campusId, "Grade 10", "G10");
                return jdbcTemplate.queryForObject(
                                "SELECT id FROM standards WHERE standard_code = 'G10'", Long.class);
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

        private Long setupStudent() {
                String sql = "INSERT INTO students (organization_id, first_name, full_name, last_name, " +
                                "student_code, date_of_birth, gender, enrollment_date, campus_id, standard_id, " +
                                "section_id, admission_type_id, academic_year_id) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Setup section first
                long sectionId = setupSection();
                long admissionTypeId = setupAdmissionType();

                jdbcTemplate.update(sql,
                                1L, "John", "John Doe", "Doe", "STU-001",
                                LocalDate.of(2010, 1, 1), "M", LocalDate.now(),
                                campusId, standardId, sectionId, admissionTypeId, academicYearId);

                return jdbcTemplate.queryForObject(
                                "SELECT id FROM students WHERE student_code = 'STU-001'", Long.class);
        }

        private Long setupSection() {
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

        private Long setupFeeRate() {
                String sql = "INSERT INTO fee_rates (organization_id, campus_id, standard_id, " +
                                "fee_component_id, academic_year_id, amount, effective_from, active) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                jdbcTemplate.update(sql,
                                1L, campusId, standardId, feeComponentId, academicYearId,
                                5000.00, LocalDate.of(2024, 1, 1), true);
                return jdbcTemplate.queryForObject(
                                "SELECT id FROM fee_rates WHERE campus_id = ? ORDER BY id DESC LIMIT 1",
                                Long.class, campusId);
        }
}
