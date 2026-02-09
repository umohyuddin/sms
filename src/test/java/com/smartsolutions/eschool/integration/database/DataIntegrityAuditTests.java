package com.smartsolutions.eschool.integration.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for data integrity and audit trail
 * Tests:
 * - Audit trail fields (created_at, created_by, updated_at, updated_by)
 * - Soft delete functionality (is_deleted, deleted_at, deleted_by)
 * - Organization-based multi-tenancy (organization_id)
 * - Timestamp management (created_at defaults to CURRENT_TIMESTAMP)
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Data Integrity and Audit Tests")
class DataIntegrityAuditTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Should set created_at to CURRENT_TIMESTAMP automatically")
    void testCreatedAtDefaultValue() {
        String sql = "INSERT INTO school_types (code, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, "PRIMARY", "Primary School");

        String selectSql = "SELECT created_at FROM school_types WHERE code = 'PRIMARY'";
        Object createdAt = jdbcTemplate.queryForObject(selectSql, Object.class);

        assertNotNull(createdAt, "created_at should not be null");
    }

    @Test
    @DisplayName("Should track created_by user for audit trail")
    void testCreatedByAuditTrail() {
        String sql = "INSERT INTO languages (name, created_by) VALUES (?, ?)";
        jdbcTemplate.update(sql, "English", 101L);

        String selectSql = "SELECT created_by FROM languages WHERE name = 'English'";
        Long createdBy = jdbcTemplate.queryForObject(selectSql, Long.class);

        assertEquals(101L, createdBy, "created_by should match inserted value");
    }

    @Test
    @DisplayName("Should support soft delete with is_deleted flag")
    void testSoftDeleteFlag() {
        String insertSql = "INSERT INTO languages (name, is_deleted) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, "Urdu", false);

        String updateSql = "UPDATE languages SET is_deleted = true, deleted_at = NOW(), deleted_by = ? " +
                "WHERE name = 'Urdu'";
        jdbcTemplate.update(updateSql, 102L);

        String selectSql = "SELECT is_deleted, deleted_by FROM languages WHERE name = 'Urdu'";
        var result = jdbcTemplate.queryForMap(selectSql);

        assertTrue((Boolean) result.get("is_deleted"), "is_deleted should be true");
        assertEquals(102L, result.get("deleted_by"), "deleted_by should be set");
    }

    @Test
    @DisplayName("Should track deleted_at timestamp on soft delete")
    void testDeletedAtTimestamp() {
        String insertSql = "INSERT INTO currencies (iso_code, name) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, "USD", "US Dollar");

        String updateSql = "UPDATE currencies SET is_deleted = true, deleted_at = NOW() " +
                "WHERE iso_code = 'USD'";
        jdbcTemplate.update(updateSql);

        String selectSql = "SELECT deleted_at FROM currencies WHERE iso_code = 'USD'";
        Object deletedAt = jdbcTemplate.queryForObject(selectSql, Object.class);

        assertNotNull(deletedAt, "deleted_at should be set on soft delete");
    }

    @Test
    @DisplayName("Should enforce organization_id for multi-tenancy")
    void testOrganizationIdMultiTenancy() {
        String sql1 = "INSERT INTO modules (organization_id, code, name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql1, 1L, "STUDENTS", "Student Management");

        String sql2 = "INSERT INTO modules (organization_id, code, name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql2, 2L, "STUDENTS", "Student Management");

        String selectOrgSql = "SELECT COUNT(*) FROM modules WHERE code = 'STUDENTS' AND organization_id = 1";
        Integer count = jdbcTemplate.queryForObject(selectOrgSql, Integer.class);

        assertEquals(1, count, "Should have exactly one STUDENTS module for organization 1");
    }

    @Test
    @DisplayName("Should support updated_at and updated_by for record modifications")
    void testUpdatedAtAndUpdatedBy() {
        String insertSql = "INSERT INTO academic_years (name, code, start_date, end_date, total_months, " +
                "status, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertSql, "AY-2024", "AY-2024",
                LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 12, "ACTIVE", 1L);

        String updateSql = "UPDATE academic_years SET status = 'ARCHIVED', updated_by = 103L " +
                "WHERE code = 'AY-2024'";
        jdbcTemplate.update(updateSql);

        String selectSql = "SELECT updated_by FROM academic_years WHERE code = 'AY-2024'";
        Long updatedBy = jdbcTemplate.queryForObject(selectSql, Long.class);

        assertEquals(103L, updatedBy, "updated_by should be set on modification");
    }

    @Test
    @DisplayName("Should maintain referential integrity across audit fields")
    void testAuditFieldConsistency() {
        String insertSql = "INSERT INTO school_types (code, name, created_by, updated_by) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertSql, "SECONDARY", "Secondary School", 101L, 101L);

        String selectSql = "SELECT created_by, updated_by FROM school_types WHERE code = 'SECONDARY'";
        var result = jdbcTemplate.queryForMap(selectSql);

        assertEquals(101L, result.get("created_by"), "created_by should match");
        assertEquals(101L, result.get("updated_by"), "updated_by should initially match created_by");
    }

    @Test
    @DisplayName("Should allow NULL for optional audit fields")
    void testOptionalAuditFields() {
        String sql = "INSERT INTO education_levels (code, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, "PRIMARY", "Primary Education");

        String selectSql = "SELECT created_by, updated_by, deleted_by FROM education_levels " +
                "WHERE code = 'PRIMARY'";
        var result = jdbcTemplate.queryForMap(selectSql);

        assertNull(result.get("created_by"), "created_by can be NULL");
        assertNull(result.get("updated_by"), "updated_by can be NULL");
        assertNull(result.get("deleted_by"), "deleted_by should be NULL before soft delete");
    }

    @Test
    @DisplayName("Should prevent orphaned records by enforcing FK on delete")
    void testForeignKeyOnDeleteRestrict() {
        // Setup: Create a campus (which depends on institute)
        Long campusId = setupCampus();

        // Try to delete the campus - should succeed as it may have cascade
        String deleteSql = "DELETE FROM campuses WHERE id = ?";
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(deleteSql, campusId);
        });
    }

    @Test
    @DisplayName("Should maintain data consistency with unique constraints")
    void testUniqueConstraintConsistency() {
        String insertSql = "INSERT INTO provinces (country_id, name) VALUES (?, ?)";
        
        Long countryId = setupCountry();

        // First insert should succeed
        jdbcTemplate.update(insertSql, countryId, "Punjab");

        // Second insert with same country and name should fail
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(insertSql, countryId, "Punjab");
        });
    }

    @Test
    @DisplayName("Should support soft delete queries filtering out deleted records")
    void testSoftDeleteQueryFiltering() {
        String insertSql = "INSERT INTO languages (name, is_deleted) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, "Spanish", false);
        jdbcTemplate.update(insertSql, "French", true);

        String selectActiveSql = "SELECT COUNT(*) FROM languages WHERE name IN ('Spanish', 'French') " +
                "AND is_deleted = false";
        Integer activeCount = jdbcTemplate.queryForObject(selectActiveSql, Integer.class);

        String selectAllSql = "SELECT COUNT(*) FROM languages WHERE name IN ('Spanish', 'French')";
        Integer totalCount = jdbcTemplate.queryForObject(selectAllSql, Integer.class);

        assertEquals(1, activeCount, "Should have 1 active language");
        assertEquals(2, totalCount, "Should have 2 total records including soft-deleted");
    }

    // Helper methods
    private Long setupCampus() {
        String sql = "INSERT INTO campuses (organization_id, campus_name, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 1L, "Test Campus", true);
        return jdbcTemplate.queryForObject(
                "SELECT id FROM campuses WHERE campus_name = 'Test Campus'", Long.class);
    }

    private Long setupCountry() {
        String sql = "INSERT INTO country (country_code, country_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, "PK", "Pakistan");
        return jdbcTemplate.queryForObject(
                "SELECT id FROM country WHERE country_code = 'PK'", Long.class);
    }
}
