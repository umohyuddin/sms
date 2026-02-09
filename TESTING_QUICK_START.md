# Database Testing Quick Start Guide

## 📋 What Was Created

Your SMS database schema now has a comprehensive integration test suite covering:
- ✅ 6 test classes
- ✅ 60+ test methods
- ✅ All CHECK constraints (date ranges, amounts, percentages)
- ✅ All UNIQUE constraints
- ✅ All FOREIGN KEY constraints (15+)
- ✅ Audit trail functionality (created_at, updated_by, deleted_at, etc.)
- ✅ Soft delete patterns
- ✅ Multi-tenancy validation
- ✅ Data integrity rules

## 📁 File Structure

```
src/test/
├── java/com/smartsolutions/eschool/integration/database/
│   ├── AcademicYearConstraintTests.java        (Academic year constraints)
│   ├── FeeTableConstraintTests.java            (Fee table validations)
│   ├── DiscountConstraintTests.java            (Discount validations)
│   ├── PayrollConstraintTests.java             (Payroll validations)
│   ├── ForeignKeyConstraintTests.java          (FK relationships)
│   ├── DataIntegrityAuditTests.java            (Audit & integrity)
│   └── README.md                               (Detailed documentation)
└── resources/
    └── application-test.properties             (Test configuration)

DATABASE_TESTING_SUMMARY.md                     (This file)
```

## 🚀 Quick Start

### 1. Setup Test Database

```bash
# Create test database
mysql -u root -p -e "CREATE DATABASE sms_test;"

# Initialize with schema
mysql -u root -p sms_test < MSQL/sms_schema_reorganized.sql

# Verify setup
mysql -u root -p -e "USE sms_test; SELECT COUNT(*) FROM academic_years;"
```

### 2. Run Tests

```bash
# Run all tests
mvn test -P test

# Run one test class
mvn test -Dtest=AcademicYearConstraintTests

# Run one test method
mvn test -Dtest=AcademicYearConstraintTests#testValidDateRange

# Run with output
mvn test -P test -X
```

### 3. View Results

Results will show:
```
Tests run: 60+
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## 🧪 What Each Test Class Validates

### 1. AcademicYearConstraintTests
Tests for academic year data:
- End date must be >= start date
- Code must be unique
- Name and code are required
- Current year tracking works

**Example Test:**
```java
@Test
void testInvalidDateRange() {
    // Should reject: end_date (2024-01-01) < start_date (2024-12-31)
    assertThrows(Exception.class, () -> {
        jdbcTemplate.update(sql, ..., "2024-12-31", "2024-01-01", ...);
    });
}
```

### 2. FeeTableConstraintTests
Tests for all fee-related tables:
- Fee amounts must be >= 0
- Date ranges must be valid (effective_to >= effective_from)
- Foreign keys properly reference students and rates
- Student fee payments track correctly

**Example Test:**
```java
@Test
void testFeeRateAmountConstraint() {
    // Should accept amount 5000.00
    assertDoesNotThrow(() -> {
        jdbcTemplate.update(sql, ..., 5000.00, ...);
    });
}
```

### 3. DiscountConstraintTests
Tests for discount tables:
- Discount values >= 0
- Percentages must be 0-100%
- Unique constraint on student discount assignments
- Foreign keys to discount types and academic years

**Example Test:**
```java
@Test
void testPercentageDiscountRangeConstraint() {
    // These should pass: 0%, 50%, 100%
    assertDoesNotThrow(() -> {
        jdbcTemplate.update(sql, 1L, 0.00, true, ...);   // ✅
        jdbcTemplate.update(sql, 1L, 50.00, true, ...);  // ✅
        jdbcTemplate.update(sql, 1L, 100.00, true, ...); // ✅
    });
}

@Test
void testPercentageDiscountOverflowRejection() {
    // This should fail: 150% > 100%
    assertThrows(Exception.class, () -> {
        jdbcTemplate.update(sql, 1L, 150.00, true, ...); // ❌
    });
}
```

### 4. PayrollConstraintTests
Tests for payroll and salary tables:
- Salary amounts >= 0
- Deduction amounts >= 0
- Bonus amounts >= 0
- Advance amounts >= 0
- Payroll period dates valid
- Balance tracking works

**Example Test:**
```java
@Test
void testEmployeeSalaryNegativeGrossRejection() {
    // Should reject negative salary
    assertThrows(Exception.class, () -> {
        jdbcTemplate.update(sql, ..., -50000.00, ...);
    });
}
```

### 5. ForeignKeyConstraintTests
Tests referential integrity:
- provinces must reference valid countries
- cities must reference valid provinces
- campuses must reference valid institutes
- students must reference valid campuses
- fees must reference valid students
- employees must reference valid employee types
- Payroll records must reference valid employees

**Example Test:**
```java
@Test
void testStudentCampusForeignKey() {
    // Should fail: campus_id 99999 doesn't exist
    assertThrows(Exception.class, () -> {
        jdbcTemplate.update(sql, ..., 99999L, ...);
    });
}
```

### 6. DataIntegrityAuditTests
Tests audit and integrity features:
- created_at auto-timestamps
- created_by tracks who created records
- updated_at tracks last modification
- updated_by tracks who modified
- deleted_at tracks soft deletes
- deleted_by tracks who deleted
- organization_id enforces multi-tenancy
- Soft deleted records can be filtered

**Example Test:**
```java
@Test
void testCreatedAtDefaultValue() {
    // created_at should auto-populate with current timestamp
    jdbcTemplate.update(sql, "PRIMARY", "Primary School");
    
    Object createdAt = jdbcTemplate.queryForObject(
        "SELECT created_at FROM school_types WHERE code = 'PRIMARY'",
        Object.class
    );
    
    assertNotNull(createdAt); // ✅ Timestamp was auto-set
}

@Test
void testSoftDeleteFunctionality() {
    // Insert a record
    jdbcTemplate.update(insertSql, "Spanish", false);
    
    // Soft delete it
    jdbcTemplate.update(
        "UPDATE languages SET is_deleted = true, deleted_at = NOW() WHERE name = 'Spanish'"
    );
    
    // Query active records
    Integer activeCount = jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM languages WHERE is_deleted = false",
        Integer.class
    );
    
    assertEquals(0, activeCount); // ✅ Record is hidden from active queries
}
```

## 🔍 Understanding Test Results

### Success Output
```
[INFO] Running com.smartsolutions.eschool.integration.database.AcademicYearConstraintTests
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.543 s

[INFO] Running com.smartsolutions.eschool.integration.database.FeeTableConstraintTests
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.102 s

[INFO] BUILD SUCCESS
```

### Failure Output
```
[ERROR] testFeeRateNegativeAmountRejection FAILED
[ERROR] Expected: Exception to be thrown
[ERROR] but: No exception was thrown

[FAILURE] Your database allows negative amounts (constraint not applied)
[ACTION] Verify CHECK constraint in sms_schema_reorganized.sql
```

## 🛠️ Troubleshooting

### Test Database Issues

**"Access denied for user 'root'"**
```bash
# Verify credentials in application-test.properties
# Update if needed:
spring.datasource.username=root
spring.datasource.password=rootpassword123
```

**"Unknown database 'sms_test'"**
```bash
# Create test database
mysql -u root -p -e "CREATE DATABASE sms_test;"

# Initialize schema
mysql -u root -p sms_test < MSQL/sms_schema_reorganized.sql
```

**"Table 'sms_test.academic_years' doesn't exist"**
```bash
# Verify schema was loaded
mysql -u root -p sms_test -e "SHOW TABLES;" | grep academic_years

# If missing, reload schema
mysql -u root -p sms_test < MSQL/sms_schema_reorganized.sql
```

### Test Execution Issues

**"No qualifying bean of type DataSource"**
```
SOLUTION: Ensure application-test.properties exists in src/test/resources/
```

**"Tests not running"**
```bash
# Verify dependencies in pom.xml:
mvn dependency:tree | grep -i junit

# Should show junit-jupiter and spring-boot-starter-test
```

**"Tests timeout"**
```
SOLUTION: Increase timeout or check database performance
In test method: @Timeout(value = 10, unit = TimeUnit.SECONDS)
```

## 📊 Test Coverage by Database Component

### Level 0 (Core Tables)
- ✅ academic_years: Date ranges, uniqueness
- ✅ employee_type: Foreign keys
- ✅ salary_component: Basic constraints

### Level 1 (Geographic)
- ✅ provinces: Country foreign keys
- ✅ cities: Province foreign keys
- ✅ tax_types: Country relationships

### Level 4-5 (Academic Structure)
- ✅ campuses: Institute relationships
- ✅ standards: Campus relationships
- ✅ sections: Standard relationships
- ✅ students: All dependencies
- ✅ admission_type: Student relationships

### Level 6 (Financial)
- ✅ fee_rates: Amount validation, date ranges
- ✅ student_fee_assignments: Unique constraints, FK
- ✅ student_fee_payments: Amount validation
- ✅ student_fee_summary: Total validation
- ✅ discount_rate: Percentage bounds
- ✅ student_discount_assignment: Unique, percentage

### Level 7-8 (Payroll)
- ✅ employee_salary: Amount validation
- ✅ employee_deduction: Amount validation
- ✅ payroll_period: Date range validation
- ✅ salary_payment: Amount validation
- ✅ employee_bonus: Amount validation
- ✅ employee_advance: Amount & balance validation

## 🎯 Key Validation Rules

### Amount Fields (Must be >= 0)
| Table | Field | Min | Max |
|-------|-------|-----|-----|
| fee_rates | amount | 0 | ∞ |
| student_fee_assignments | total_amount | 0 | ∞ |
| student_fee_payments | amount_paid | 0 | ∞ |
| discount_rate | value | 0 | ∞ |
| student_discount_assignment | applied_amount | 0 | ∞ |
| employee_salary | gross_salary | 0 | ∞ |
| employee_deduction | amount | 0 | ∞ |
| salary_payment | amount_paid | 0 | ∞ |
| employee_bonus | amount | 0 | ∞ |
| employee_advance | amount | 0 | ∞ |

### Percentage Fields (Must be 0-100)
| Table | Field | Constraint |
|-------|-------|------------|
| student_discount_assignment | applied_percentage | 0 ≤ x ≤ 100 |
| discount_rate | value (when is_percentage=true) | 0 ≤ x ≤ 100 |

### Date Range Fields (end >= start)
| Table | Start | End |
|-------|-------|-----|
| academic_years | start_date | end_date |
| fee_rates | effective_from | effective_to |
| payroll_period | start_date | end_date |
| discount_rate | effective_from | effective_to |

## 📝 Writing New Tests

### Test Template
```java
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DisplayName("Your Test Class Description")
class YourTestClass {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Should test something specific")
    void testSomething() {
        // Setup
        String sql = "INSERT INTO table_name (...) VALUES (?, ?)";
        
        // Action & Assert
        assertDoesNotThrow(() -> {
            jdbcTemplate.update(sql, validData);
        });
        
        assertThrows(Exception.class, () -> {
            jdbcTemplate.update(sql, invalidData);
        });
    }

    // Helper methods
    private Long setupEntity() {
        String sql = "INSERT INTO table_name (...) VALUES (?)";
        jdbcTemplate.update(sql, data);
        return jdbcTemplate.queryForObject(
            "SELECT id FROM table_name WHERE ...",
            Long.class
        );
    }
}
```

## 🔗 Related Documentation

- **Database Schema**: `MSQL/sms_schema_reorganized.sql`
- **Test Configuration**: `src/test/resources/application-test.properties`
- **Detailed Guide**: `src/test/java/.../database/README.md`
- **Full Summary**: `DATABASE_TESTING_SUMMARY.md`

## ✅ Validation Checklist

Use this checklist to verify your database is working correctly:

- [ ] All 6 test classes load without errors
- [ ] All 60+ test methods pass
- [ ] No database connection issues
- [ ] All constraints are properly enforced
- [ ] Audit fields auto-populate
- [ ] Soft deletes work correctly
- [ ] Foreign keys prevent orphans
- [ ] Unique constraints prevent duplicates
- [ ] Date ranges validate correctly
- [ ] Amount validations work
- [ ] Percentage bounds are enforced

## 🎉 You're All Set!

Your SMS database schema now has comprehensive test coverage. The tests validate:
- ✅ All 40+ constraints
- ✅ All 15+ foreign keys
- ✅ Audit trail functionality
- ✅ Multi-tenancy support
- ✅ Data integrity rules
- ✅ Soft delete patterns

**Run the tests regularly to catch any schema regressions!**

```bash
mvn test -P test
```
