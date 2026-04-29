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
 * Integration tests for employee payroll tables
 * Tests:
 * - Salary/deduction amounts >= 0
 * - Payroll period date range validation (end_date >= start_date)
 * - Employee advance amount validation
 * - Employee bonus amount validation
 * - Foreign key constraints
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Payroll Constraint Tests")
class PayrollConstraintTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Long employeeId;
    private Long employeeTypeId;
    private Long salaryStructureId;
    private Long payrollPeriodId;

    @BeforeEach
    void setup() {
        employeeTypeId = setupEmployeeType();
        salaryStructureId = setupSalaryStructure();
        employeeId = setupEmployee();
        payrollPeriodId = setupPayrollPeriod();
    }

    @Test
    @DisplayName("Should accept employee salary with gross_salary >= 0")
    void testEmployeeSalaryAmountValidation() {
        String sql = "INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, " +
                "gross_salary, total_deductions, net_salary, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, salaryStructureId, 50000.00, 10000.00, 40000.00,
                    LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should reject employee salary with negative gross_salary")
    void testEmployeeSalaryNegativeGrossRejection() {
        String sql = "INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, " +
                "gross_salary, total_deductions, net_salary, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, salaryStructureId, -50000.00, 10000.00, 40000.00,
                    LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should reject employee salary with negative net_salary")
    void testEmployeeSalaryNegativeNetRejection() {
        String sql = "INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, " +
                "gross_salary, total_deductions, net_salary, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, salaryStructureId, 50000.00, 10000.00, -5000.00,
                    LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should accept employee deduction with amount >= 0")
    void testEmployeeDeductionAmountValidation() {
        String sql = "INSERT INTO employee_deduction (organization_id, employee_id, deduction_type, " +
                "amount, month) VALUES (?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, "TAX", 5000.00, LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should reject employee deduction with negative amount")
    void testEmployeeDeductionNegativeAmountRejection() {
        String sql = "INSERT INTO employee_deduction (organization_id, employee_id, deduction_type, " +
                "amount, month) VALUES (?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, "TAX", -1000.00, LocalDate.of(2024, 1, 1));
        });
    }

    @Test
    @DisplayName("Should validate payroll period date range (end_date >= start_date)")
    void testPayrollPeriodDateRangeValidation() {
        String sql = "INSERT INTO payroll_period (organization_id, start_date, end_date, status) " +
                "VALUES (?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, LocalDate.of(2024, 12, 31), LocalDate.of(2024, 1, 1), "PENDING");
        });
    }

    @Test
    @DisplayName("Should accept valid payroll period with end_date >= start_date")
    void testValidPayrollPeriodDateRange() {
        String sql = "INSERT INTO payroll_period (organization_id, start_date, end_date, status) " +
                "VALUES (?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31), "PENDING");
        });
    }

    @Test
    @DisplayName("Should accept salary payment with amount >= 0")
    void testSalaryPaymentAmountValidation() {
        long employeeSalaryId = setupEmployeeSalary();

        String sql = "INSERT INTO salary_payment (organization_id, employee_salary_id, payment_date, " +
                "payment_mode, amount_paid) VALUES (?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, employeeSalaryId, LocalDate.of(2024, 1, 31), "BANK_TRANSFER", 40000.00);
        });
    }

    @Test
    @DisplayName("Should reject salary payment with negative amount")
    void testSalaryPaymentNegativeAmountRejection() {
        long employeeSalaryId = setupEmployeeSalary();

        String sql = "INSERT INTO salary_payment (organization_id, employee_salary_id, payment_date, " +
                "payment_mode, amount_paid) VALUES (?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, employeeSalaryId, LocalDate.of(2024, 1, 31), "BANK_TRANSFER", -5000.00);
        });
    }

    @Test
    @DisplayName("Should accept employee bonus with amount >= 0")
    void testEmployeeBonusAmountValidation() {
        String sql = "INSERT INTO employee_bonus (organization_id, employee_id, bonus_type, amount, " +
                "payroll_period_id) VALUES (?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, "ANNUAL", 10000.00, payrollPeriodId);
        });
    }

    @Test
    @DisplayName("Should reject employee bonus with negative amount")
    void testEmployeeBonusNegativeAmountRejection() {
        String sql = "INSERT INTO employee_bonus (organization_id, employee_id, bonus_type, amount, " +
                "payroll_period_id) VALUES (?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, "ANNUAL", -5000.00, payrollPeriodId);
        });
    }

    @Test
    @DisplayName("Should accept employee advance with amount >= 0")
    void testEmployeeAdvanceAmountValidation() {
        String sql = "INSERT INTO employee_advance (organization_id, employee_id, amount, " +
                "repayment_months, balance) VALUES (?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    1L, employeeId, 25000.00, 12, 25000.00);
        });
    }

    @Test
    @DisplayName("Should reject employee advance with negative amount")
    void testEmployeeAdvanceNegativeAmountRejection() {
        String sql = "INSERT INTO employee_advance (organization_id, employee_id, amount, " +
                "repayment_months) VALUES (?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, employeeId, -10000.00, 12);
        });
    }

    @Test
    @DisplayName("Should reject employee advance with negative balance")
    void testEmployeeAdvanceNegativeBalanceRejection() {
        String sql = "INSERT INTO employee_advance (organization_id, employee_id, amount, balance) " +
                "VALUES (?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, 1L, employeeId, 25000.00, -5000.00);
        });
    }

    // Helper methods
    private Long setupEmployeeType() {
        String sql = "INSERT INTO employee_type (organization_id, name, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "Teacher", true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM employee_type WHERE name = 'Teacher'", Long.class);
    }

    private Long setupSalaryStructure() {
        String sql = "INSERT INTO salary_structure (organization_id, employee_type_id, base_salary, " +
                "effective_from, is_current) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1L, employeeTypeId, 50000.00, LocalDate.of(2024, 1, 1), true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM salary_structure WHERE employee_type_id = ?", Long.class, employeeTypeId);
    }

    private Long setupEmployee() {
        String sql = "INSERT INTO employee_master (organization_id, employee_code, first_name, " +
                "last_name, full_name, email, employee_type_id, active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                1L, "EMP-001", "John", "Smith", "John Smith",
                "john@example.com", employeeTypeId, true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM employee_master WHERE employee_code = 'EMP-001'", Long.class);
    }

    private Long setupPayrollPeriod() {
        String sql = "INSERT INTO payroll_period (organization_id, start_date, end_date, status) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                1L, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31), "PENDING");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM payroll_period ORDER BY id DESC LIMIT 1", Long.class);
    }

    private Long setupEmployeeSalary() {
        String sql = "INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, " +
                "gross_salary, total_deductions, net_salary, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                1L, employeeId, salaryStructureId, 50000.00, 10000.00, 40000.00,
                LocalDate.of(2024, 1, 1));
        return jdbcTemplate.queryForObject(
                "SELECT id FROM employee_salary ORDER BY id DESC LIMIT 1", Long.class);
    }
}
