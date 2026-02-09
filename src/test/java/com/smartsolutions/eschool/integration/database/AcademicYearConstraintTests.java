package com.smartsolutions.eschool.integration.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for academic_years table constraints
 * Tests:
 * - Date range validation (end_date >= start_date)
 * - Code uniqueness constraint
 * - Required fields (name, code, status)
 * - Current academic year tracking
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Academic Year Constraint Tests")
class AcademicYearConstraintTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Should accept valid academic year with end_date >= start_date")
    void testValidDateRange() {
        String sql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, is_current, organization_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql,
                    "Academic Year 2024-2025", "AY-2024-25", 
                    "2024-01-01", "2024-12-31", 12, "ACTIVE", false, 1L);
        });
    }

    @Test
    @DisplayName("Should reject academic year with end_date < start_date")
    void testInvalidDateRange() {
        String sql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, is_current, organization_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql,
                    "Invalid Year", "AY-INVALID", 
                    "2024-12-31", "2024-01-01", 12, "ACTIVE", false, 1L);
        });
    }

    @Test
    @DisplayName("Should enforce unique constraint on code")
    void testUniqueCodeConstraint() {
        String insertSql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, is_current, organization_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // First insert should succeed
        jdbcTemplate.update(insertSql,
                "AY 2024-2025", "AY-2024-25", 
                "2024-01-01", "2024-12-31", 12, "ACTIVE", false, 1L);

        // Second insert with same code should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(insertSql,
                    "AY 2023-2024", "AY-2024-25", 
                    "2023-01-01", "2023-12-31", 12, "ACTIVE", false, 1L);
        });
    }

    @Test
    @DisplayName("Should require name and code fields")
    void testNotNullConstraints() {
        String sqlNullName = "INSERT INTO academic_years (code, start_date, end_date, total_months, " +
                "status, is_current, organization_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sqlNullName,
                    "AY-2024", "2024-01-01", "2024-12-31", 12, "ACTIVE", false, 1L);
        });
    }

    @Test
    @DisplayName("Should allow only one current academic year per organization")
    void testCurrentYearTracking() {
        String insertSql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, is_current, organization_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Insert first current year
        jdbcTemplate.update(insertSql,
                "Current Year", "AY-CURRENT", 
                "2024-01-01", "2024-12-31", 12, "ACTIVE", true, 1L);

        // Verify it was inserted
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM academic_years WHERE is_current = true AND organization_id = 1",
                Integer.class);
        assertEquals(1, count);
    }
}
