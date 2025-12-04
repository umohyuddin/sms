-- Standards for Downtown Campus (campus_id = 1)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 1, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 1, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 1, NOW(), NOW(), 0, NULL),
    ('4th Grade', 1, NOW(), NOW(), 0, NULL),
    ('5th Grade', 1, NOW(), NOW(), 0, NULL);

-- Standards for Uptown Campus (campus_id = 2)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 2, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 2, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 2, NOW(), NOW(), 0, NULL),
    ('4th Grade', 2, NOW(), NOW(), 0, NULL),
    ('5th Grade', 2, NOW(), NOW(), 0, NULL);

-- Standards for Riverside Campus (campus_id = 3)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 3, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 3, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 3, NOW(), NOW(), 0, NULL),
    ('4th Grade', 3, NOW(), NOW(), 0, NULL),
    ('5th Grade', 3, NOW(), NOW(), 0, NULL);

-- Standards for Hilltop Campus (campus_id = 4)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 4, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 4, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 4, NOW(), NOW(), 0, NULL),
    ('4th Grade', 4, NOW(), NOW(), 0, NULL),
    ('5th Grade', 4, NOW(), NOW(), 0, NULL);

-- Standards for Greenfield Campus (campus_id = 5)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 5, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 5, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 5, NOW(), NOW(), 0, NULL),
    ('4th Grade', 5, NOW(), NOW(), 0, NULL),
    ('5th Grade', 5, NOW(), NOW(), 0, NULL);

-- Standards for Seaside Campus (campus_id = 6)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 6, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 6, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 6, NOW(), NOW(), 0, NULL),
    ('4th Grade', 6, NOW(), NOW(), 0, NULL),
    ('5th Grade', 6, NOW(), NOW(), 0, NULL);

-- Standards for Central Campus (campus_id = 7)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 7, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 7, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 7, NOW(), NOW(), 0, NULL),
    ('4th Grade', 7, NOW(), NOW(), 0, NULL),
    ('5th Grade', 7, NOW(), NOW(), 0, NULL);

-- Standards for Lakeside Campus (campus_id = 8)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 8, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 8, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 8, NOW(), NOW(), 0, NULL),
    ('4th Grade', 8, NOW(), NOW(), 0, NULL),
    ('5th Grade', 8, NOW(), NOW(), 0, NULL);

-- Standards for Sunrise Campus (campus_id = 9)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 9, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 9, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 9, NOW(), NOW(), 0, NULL),
    ('4th Grade', 9, NOW(), NOW(), 0, NULL),
    ('5th Grade', 9, NOW(), NOW(), 0, NULL);

-- Standards for Maple Campus (campus_id = 10)
INSERT INTO standards (standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES
    ('1st Grade', 10, NOW(), NOW(), 0, NULL),
    ('2nd Grade', 10, NOW(), NOW(), 0, NULL),
    ('3rd Grade', 10, NOW(), NOW(), 0, NULL),
    ('4th Grade', 10, NOW(), NOW(), 0, NULL),
    ('5th Grade', 10, NOW(), NOW(), 0, NULL);



--Fee Catalog
INSERT INTO fee_catalog
(code, name, description, charge_type, recurrence_rule, active, deleted, created_at, created_by, updated_at, updated_by,
 deleted_at, deleted_by)
VALUES
-- Academic and Administrative Fees
('LIB-001', 'Library Fee', 'Library maintenance and book renewal charges', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('CMP-001', 'Computer Lab Fee', 'Computer lab usage and maintenance charges', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('SCI-001', 'Science Lab Fee', 'Charges for science laboratory usage', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1, NOW(),
 1, NULL, NULL),
('REG-001', 'Registration Fee', 'New student registration charges', 'FIXED', 'ONE_TIME', TRUE, FALSE, NOW(), 1, NOW(),
 1, NULL, NULL),
('EXAM-001', 'Examination Fee', 'Charges for mid-term and final exams', 'FIXED', 'ONE_TIME', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('ID-001', 'Student ID Card Fee', 'Charges for issuing student ID card', 'FIXED', 'ONE_TIME', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('TRANS-001', 'Transportation Fee', 'Bus/transport charges for students', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('SPORT-001', 'Sports Fee', 'Sports activities and facilities fee', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1, NOW(), 1,
 NULL, NULL),
('HEALTH-001', 'Health & Medical Fee', 'Basic first-aid, medical checkup, and hygiene support', 'FIXED', 'YEARLY', TRUE,
 FALSE, NOW(), 1, NOW(), 1, NULL, NULL),
('SEC-001', 'Security Charges', 'Annual security and safety maintenance fee', 'FIXED', 'YEARLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('GEN-001', 'Generator Fuel Charges', 'Fuel cost for backup generator', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('DEV-001', 'Development Charges', 'School building and infrastructure development fund', 'FIXED', 'YEARLY', TRUE,
 FALSE, NOW(), 1, NOW(), 1, NULL, NULL),
('MAINT-001', 'Maintenance Charges', 'School maintenance and repair charges', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('ACT-001', 'Activity Fee', 'Co-curricular and extra-curricular activities', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('LAB-001', 'Lab Consumables Fee', 'Consumables for science or computer labs', 'VARIABLE', 'TERM_WISE', TRUE, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),
('PER-001', 'Per Subject Fee', 'Charges applied per subject/course', 'PER_SUBJECT', 'TERM_WISE', TRUE, FALSE, NOW(), 1,
 NOW(), 1, NULL, NULL),
('CREDIT-001', 'Per Credit Fee', 'Charges applied per academic credit', 'PER_CREDIT', 'TERM_WISE', TRUE, FALSE, NOW(),
 1, NOW(), 1, NULL, NULL),
('SCHOLAR-001', 'Scholarship Adjustment', 'Deduction/adjustment for scholarship', 'PERCENTAGE', 'ONE_TIME', TRUE, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),
('HOSTEL-001', 'Hostel Fee', 'Boarding and lodging charges', 'FIXED', 'MONTHLY', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL,
 NULL),
('HOSTEL-DEP-001', 'Hostel Security Deposit', 'Refundable hostel security deposit', 'FIXED', 'ONE_TIME', TRUE, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL);

