# SMS Database Integration Tests

This directory contains comprehensive integration tests for the School Management System (SMS) database schema. These tests validate the database design, constraints, and integrity rules established in `sms_schema_reorganized.sql`.

## Test Coverage

### 1. **AcademicYearConstraintTests**
Tests for the `academic_years` table validating:
- ✅ Date range constraints (end_date >= start_date)
- ✅ Code uniqueness constraints
- ✅ Required fields (name, code, status)
- ✅ Current academic year tracking
- ✅ Default timestamp values

### 2. **FeeTableConstraintTests**
Tests for fee-related tables (`fee_rates`, `fee_component`, `student_fee_assignments`, `student_fee_payments`, `student_fee_summary`):
- ✅ Amount validation (>= 0)
- ✅ Date range validation (effective_to >= effective_from)
- ✅ Fee rate constraints
- ✅ Student fee assignment validation
- ✅ Fee payment tracking
- ✅ Fee summary validation
- ✅ Foreign key constraints

### 3. **DiscountConstraintTests**
Tests for discount-related tables (`discount_rate`, `student_discount_assignment`):
- ✅ Discount value validation (>= 0)
- ✅ Percentage range validation (0-100%)
- ✅ Applied percentage bounds
- ✅ Unique constraint on student discount assignments
- ✅ Foreign key constraints

### 4. **PayrollConstraintTests**
Tests for employee payroll tables (`employee_salary`, `employee_deduction`, `payroll_period`, `salary_payment`, `employee_bonus`, `employee_advance`):
- ✅ Salary amount validation (>= 0)
- ✅ Deduction amount validation (>= 0)
- ✅ Payroll period date range validation
- ✅ Bonus amount validation (>= 0)
- ✅ Advance amount validation (>= 0)
- ✅ Balance validation (>= 0)
- ✅ Foreign key constraints

### 5. **ForeignKeyConstraintTests**
Tests for referential integrity across all dependency levels:
- ✅ Level 0 -> Level 1 (country -> provinces -> cities)
- ✅ Level 1 -> Level 4 (institute -> campuses -> standards -> sections)
- ✅ Level 4 -> Level 5 (campuses -> students)
- ✅ Level 5 -> Level 6 (students -> fees, discounts)
- ✅ Employee type -> Employee master
- ✅ Employee salary relationships
- ✅ Payroll dependencies

### 6. **DataIntegrityAuditTests**
Tests for data integrity and audit trail mechanisms:
- ✅ created_at automatic timestamps
- ✅ created_by audit tracking
- ✅ Soft delete functionality (is_deleted, deleted_at, deleted_by)
- ✅ updated_at and updated_by tracking
- ✅ Organization-based multi-tenancy (organization_id)
- ✅ Optional audit field handling
- ✅ Soft delete query filtering
- ✅ Unique constraint consistency

## Database Schema Design Validation

These tests validate the following design principles established in `sms_schema_reorganized.sql`:

### Constraint Types Tested
1. **CHECK Constraints**
   - Date range validation (end_date >= start_date)
   - Amount validation (amount >= 0)
   - Percentage bounds (0-100)
   - Column length validation

2. **UNIQUE Constraints**
   - Academic year codes
   - Student discount assignments (student_id, discount_rate_id, academic_year_id)
   - Employee codes
   - Province-country combinations

3. **FOREIGN KEY Constraints**
   - CASCADE deletes where appropriate
   - RESTRICT deletes for structural integrity
   - SET NULL for optional relationships

4. **NOT NULL Constraints**
   - Required identification fields
   - Amount fields in financial tables
   - Organization and audit tracking fields

### Multi-Tenancy Support
All tests validate organization-based data isolation:
- `organization_id` on all tables
- Proper filtering in queries
- Data segregation across organizations

### Audit Trail
All tests verify comprehensive audit tracking:
- `created_at` (automatic timestamp)
- `created_by` (user who created the record)
- `updated_at` (automatic update timestamp)
- `updated_by` (user who last modified)
- `deleted_at` (soft delete timestamp)
- `deleted_by` (user who deleted)

## Running the Tests

### Prerequisites
1. MySQL server running
2. Test database created: `CREATE DATABASE sms_test;`
3. Test database initialized with schema from `sms_schema_reorganized.sql`

### Run All Tests
```bash
mvn test -P test
```

### Run Specific Test Class
```bash
mvn test -Dtest=AcademicYearConstraintTests
mvn test -Dtest=FeeTableConstraintTests
mvn test -Dtest=PayrollConstraintTests
mvn test -Dtest=ForeignKeyConstraintTests
mvn test -Dtest=DataIntegrityAuditTests
```

### Run Specific Test Method
```bash
mvn test -Dtest=AcademicYearConstraintTests#testValidDateRange
```

### Run with Coverage Report
```bash
mvn test jacoco:report -P test
```

## Test Configuration

The tests use the `test` profile which loads `application-test.properties`:
- Connects to `jdbc:mysql://localhost:3306/sms_test`
- Uses `validate` mode for Hibernate (no auto-creation)
- Enables debug logging for SQL statements
- Uses transactional tests (auto-rollback after each test)

## Test Data Setup

Each test class includes helper methods to set up prerequisite data:
- `setupAcademicYear()` - Creates academic year records
- `setupCampus()` - Creates campus with proper relationships
- `setupStudent()` - Creates student with all dependencies
- `setupFeeRate()` - Creates fee structure
- `setupEmployee()` - Creates employee records
- `setupPayrollPeriod()` - Creates payroll periods

All setup methods automatically create dependent records following the 8-level dependency hierarchy.

## Key Testing Patterns

### 1. Constraint Violation Testing
```java
@Test
void testInvalidDateRange() {
    assertThrows(Exception.class, () -> {
        jdbcTemplate.update(sql, invalid_data);
    });
}
```

### 2. Valid Data Acceptance Testing
```java
@Test
void testValidDateRange() {
    assertDoesNotThrow(() -> {
        jdbcTemplate.update(sql, valid_data);
    });
}
```

### 3. Boundary Value Testing
```java
// Test 0%, 50%, 100% for percentage fields
assertDoesNotThrow(() -> {
    jdbcTemplate.update(sql, 0.00, true, ...);
    jdbcTemplate.update(sql, 50.00, true, ...);
    jdbcTemplate.update(sql, 100.00, true, ...);
});

// Test > 100% should fail
assertThrows(Exception.class, () -> {
    jdbcTemplate.update(sql, 150.00, true, ...);
});
```

## Dependency Order Validation

The tests implicitly validate the 8-level dependency hierarchy:

- **Level 0**: academic_years, employee_type, etc.
- **Level 1**: provinces (country), cities (provinces)
- **Level 2**: institutes, fee_component
- **Level 3**: institute features
- **Level 4**: campuses, standards, sections
- **Level 5**: students, employee_master
- **Level 6**: student_fee_*, discounts
- **Level 7-8**: employee details, payroll

Each test that creates dependent records must follow this order.

## Continuous Integration

These tests are designed to run in CI/CD pipelines:
- ✅ Automatically rollback all changes (Transactional)
- ✅ No manual cleanup required
- ✅ Idempotent (safe to run multiple times)
- ✅ Comprehensive error messages
- ✅ Clear test names with @DisplayName

## Troubleshooting

### "No qualifying bean of type DataSource"
**Solution**: Ensure `application-test.properties` is in `src/test/resources`

### "Table doesn't exist" error
**Solution**: Initialize test database with `sms_schema_reorganized.sql`
```sql
mysql -u root -p < sms_schema_reorganized.sql
```

### "Connection refused"
**Solution**: Verify MySQL is running and test database exists
```bash
mysql -u root -p -e "SHOW DATABASES;" | grep sms_test
```

### Tests not running
**Solution**: Ensure Spring Boot test dependencies are in pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

## Future Enhancements

- [ ] Add performance tests for large datasets
- [ ] Add stress tests for concurrent operations
- [ ] Add transaction isolation tests
- [ ] Add backup and recovery tests
- [ ] Add index effectiveness tests
- [ ] Add query optimization validation

## References

- [Database Schema](../../MSQL/sms_schema_reorganized.sql)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [MySQL Constraint Documentation](https://dev.mysql.com/doc/refman/8.0/en/constraint-types.html)
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
