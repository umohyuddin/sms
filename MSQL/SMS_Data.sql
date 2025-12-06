

-- ============================================================
-- Sample Data: Academic Years
-- This section populates the 'academic_years' table with a
-- predefined list of academic sessions typically used in
-- schools/colleges across Pakistan (Aug–July cycle).
-- These records support admission, fee structure, attendance,
-- exams, and class scheduling modules.
-- ============================================================


INSERT INTO academic_years (name, start_date, end_date, total_months, is_current, created_at, updated_at)
VALUES ('2022-2023', '2022-08-01', '2023-07-31', TIMESTAMPDIFF(MONTH, '2022-08-01', '2023-07-31') + 1, FALSE, NOW(),
        NOW()),
       ('2023-2024', '2023-08-01', '2024-07-31', TIMESTAMPDIFF(MONTH, '2023-08-01', '2024-07-31') + 1, FALSE, NOW(),
        NOW()),
       ('2024-2025', '2024-08-01', '2025-07-31', TIMESTAMPDIFF(MONTH, '2024-08-01', '2025-07-31') + 1, TRUE, NOW(),
        NOW()),
       ('2025-2026', '2025-08-01', '2026-07-31', TIMESTAMPDIFF(MONTH, '2025-08-01', '2026-07-31') + 1, FALSE, NOW(),
        NOW()),
       ('2026-2027', '2026-08-01', '2027-07-31', TIMESTAMPDIFF(MONTH, '2026-08-01', '2027-07-31') + 1, FALSE, NOW(),
        NOW());

-- ============================================
-- Sample Data: Provinces of Pakistan
-- This dataset is used to populate the 'provinces' table
-- with all administrative regions required for addresses,
-- student profiles, employee profiles, and campus records.
-- ============================================

INSERT INTO provinces (name, code, is_active, created_by, updated_by)
VALUES ('Punjab', 'PB', TRUE, 1, 1),
       ('Sindh', 'SD', TRUE, 1, 1),
       ('Khyber Pakhtunkhwa', 'KP', TRUE, 1, 1),
       ('Balochistan', 'BL', TRUE, 1, 1),
       ('Islamabad Capital Territory', 'ICT', TRUE, 1, 1),
       ('Gilgit-Baltistan', 'GB', TRUE, 1, 1),
       ('Azad Jammu & Kashmir', 'AJK', TRUE, 1, 1);


-- Cities for Punjab (id=1)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (1, 'Lahore', 'LHE', TRUE, 1, 1, NOW()),
       (1, 'Faisalabad', 'FSD', TRUE, 1, 1, NOW()),
       (1, 'Rawalpindi', 'RWP', TRUE, 1, 1, NOW()),
       (1, 'Multan', 'MLN', TRUE, 1, 1,
        NOW());
-- Cities for Sindh (id=2)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (2, 'Karachi', 'KHI', TRUE, 1, 1, NOW()),
       (2, 'Hyderabad', 'HYD', TRUE, 1, 1, NOW()),
       (2, 'Sukkur', 'SUK', TRUE, 1, 1, NOW()),
       (2, 'Larkana', 'LRK', TRUE, 1, 1,
        NOW());
-- Cities for Khyber Pakhtunkhwa (id=3)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (3, 'Peshawar', 'PEW', TRUE, 1, 1, NOW()),
       (3, 'Mardan', 'MRD', TRUE, 1, 1, NOW()),
       (3, 'Abbottabad', 'ABT', TRUE, 1, 1, NOW()),
       (3, 'Swat', 'SWT', TRUE, 1, 1,
        NOW());
-- Cities for Balochistan (id=4)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (4, 'Quetta', 'QTA', TRUE, 1, 1, NOW()),
       (4, 'Gwadar', 'GWD', TRUE, 1, 1, NOW()),
       (4, 'Sibi', 'SBI', TRUE, 1, 1, NOW()),
       (4, 'Zhob', 'ZHB', TRUE, 1, 1,
        NOW());
-- Cities for Islamabad Capital Territory (id=5)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (5, 'Islamabad', 'ISB', TRUE, 1, 1,
        NOW());
-- Cities for Gilgit-Baltistan (id=6)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (6, 'Gilgit', 'GIL', TRUE, 1, 1, NOW()),
       (6, 'Skardu', 'SKD', TRUE, 1, 1,
        NOW());
-- Cities for Azad Jammu & Kashmir (id=7)
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES (7, 'Muzaffarabad', 'MZD', TRUE, 1, 1, NOW()),
       (7, 'Mirpur', 'MIR', TRUE, 1, 1, NOW()),
       (7, 'Kotli', 'KOT', TRUE, 1, 1,
        NOW());




-- ============================================================
-- Sample Data: Institutes
-- This dataset seeds the 'institutes' table with example
-- educational organizations. These entries are used to attach
-- campuses, academic years, users, fee structures, and other
-- modules within the system.
-- ============================================================

INSERT INTO institutes
(name, address, contact_number, email, website, tagline, country, logo, established_date, created_at, updated_at)
VALUES ('Smart Solutions School', '123 Main Street, Lahore', '+92-300-1234567', 'info@smartsolutions.edu',
        'https://www.smartsolutions.edu', 'Excellence in Education', 'Pakistan', NULL, '2005-08-15', NOW(), NOW()),

       ('Bright Future Academy', '456 Park Avenue, Karachi', '+92-301-7654321', 'contact@brightfuture.edu',
        'https://www.brightfuture.edu', 'Empowering Young Minds', 'Pakistan', NULL, '2010-01-10', NOW(), NOW()),

       ('Global Vision School', '789 River Road, Islamabad', '+92-302-1112223', 'admin@globalvision.edu',
        'https://www.globalvision.edu', 'Learning Beyond Boundaries', 'Pakistan', NULL, '2012-05-20', NOW(), NOW()),

       ('Riverside International School', '101 Riverside Street, Faisalabad', '+92-303-3334445',
        'info@riversideschool.edu',
        'https://www.riversideschool.edu', 'Nurturing Excellence', 'Pakistan', NULL, '2008-09-05', NOW(), NOW()),

       ('Hilltop Learning Center', '202 Hilltop Road, Peshawar', '+92-304-5556667', 'contact@hilltop.edu',
        'https://www.hilltop.edu', 'Climbing Higher Together', 'Pakistan', NULL, '2015-03-15', NOW(), NOW());

-- ============================================================
-- Sample Data: Campuses
-- This dataset seeds the 'campuses' table for Smart Solutions
-- School institutes. Each campus is associated with a province
-- and city. These records support student enrollment, fee
-- assignments, timetable, and staff allocation.
-- ============================================================


INSERT INTO campuses (institute_id, province_id, city_id,
                      campus_name, contact, email, website, address,
                      logo, deleted,
                      created_at, created_by, updated_at, updated_by,
                      deleted_at, deleted_by)
VALUES
-- Punjab → Lahore (1)
(1, 1, 1, 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com',
 'https://downtown.smarteschool.com', '123 Main Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Lahore (1)
(1, 1, 1, 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com',
 'https://uptown.smarteschool.com', '456 Park Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Karachi (5)
(1, 2, 5, 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com',
 'https://riverside.smarteschool.com', '789 River Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- KPK → Peshawar (9)
(1, 3, 9, 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com',
 'https://hilltop.smarteschool.com', '101 Hill Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Faisalabad (2)
(1, 1, 2, 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
 'https://greenfield.smarteschool.com', '202 Green Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Karachi (5)
(1, 2, 5, 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com',
 'https://seaside.smarteschool.com', '303 Beach Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Multan (4)
(1, 1, 4, 'Central Campus', '+92-303-9990001', 'central@smarteschool.com',
 'https://central.smarteschool.com', '404 Central Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Hyderabad (6)
(1, 2, 6, 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com',
 'https://lakeside.smarteschool.com', '505 Lake Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Rawalpindi (3)
(1, 1, 3, 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com',
 'https://sunrise.smarteschool.com', '606 Sunrise Blvd', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Balochistan → Quetta (13)
(1, 4, 13, 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com',
 'https://maple.smarteschool.com', '707 Maple Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL);


-- ============================================================
-- Sample Data: Standards / Grades
-- Each campus has 1st Grade → 5th Grade. These standards
-- are used to assign students, teachers, timetables, exams,
-- and fees. The 'deleted' column is FALSE (0) for active records.
-- ============================================================

-- Sample standards for 10 campuses
INSERT INTO standards (standard_name, campus_id, created_at, updated_at)
VALUES
-- Downtown Campus (campus_id = 1)
('1st Grade', 1, NOW(), NOW()),
('2nd Grade', 1, NOW(), NOW()),
('3rd Grade', 1, NOW(), NOW()),
('4th Grade', 1, NOW(), NOW()),
('5th Grade', 1, NOW(), NOW()),

-- Uptown Campus (campus_id = 2)
('1st Grade', 2, NOW(), NOW()),
('2nd Grade', 2, NOW(), NOW()),
('3rd Grade', 2, NOW(), NOW()),
('4th Grade', 2, NOW(), NOW()),
('5th Grade', 2, NOW(), NOW()),

-- Riverside Campus (campus_id = 3)
('1st Grade', 3, NOW(), NOW()),
('2nd Grade', 3, NOW(), NOW()),
('3rd Grade', 3, NOW(), NOW()),
('4th Grade', 3, NOW(), NOW()),
('5th Grade', 3, NOW(), NOW()),

-- Hilltop Campus (campus_id = 4)
('1st Grade', 4, NOW(), NOW()),
('2nd Grade', 4, NOW(), NOW()),
('3rd Grade', 4, NOW(), NOW()),
('4th Grade', 4, NOW(), NOW()),
('5th Grade', 4, NOW(), NOW()),

-- Greenfield Campus (campus_id = 5)
('1st Grade', 5, NOW(), NOW()),
('2nd Grade', 5, NOW(), NOW()),
('3rd Grade', 5, NOW(), NOW()),
('4th Grade', 5, NOW(), NOW()),
('5th Grade', 5, NOW(), NOW()),

-- Seaside Campus (campus_id = 6)
('1st Grade', 6, NOW(), NOW()),
('2nd Grade', 6, NOW(), NOW()),
('3rd Grade', 6, NOW(), NOW()),
('4th Grade', 6, NOW(), NOW()),
('5th Grade', 6, NOW(), NOW()),

-- Central Campus (campus_id = 7)
('1st Grade', 7, NOW(), NOW()),
('2nd Grade', 7, NOW(), NOW()),
('3rd Grade', 7, NOW(), NOW()),
('4th Grade', 7, NOW(), NOW()),
('5th Grade', 7, NOW(), NOW()),

-- Lakeside Campus (campus_id = 8)
('1st Grade', 8, NOW(), NOW()),
('2nd Grade', 8, NOW(), NOW()),
('3rd Grade', 8, NOW(), NOW()),
('4th Grade', 8, NOW(), NOW()),
('5th Grade', 8, NOW(), NOW()),

-- Sunrise Campus (campus_id = 9)
('1st Grade', 9, NOW(), NOW()),
('2nd Grade', 9, NOW(), NOW()),
('3rd Grade', 9, NOW(), NOW()),
('4th Grade', 9, NOW(), NOW()),
('5th Grade', 9, NOW(), NOW()),

-- Maple Campus (campus_id = 10)
('1st Grade', 10, NOW(), NOW()),
('2nd Grade', 10, NOW(), NOW()),
('3rd Grade', 10, NOW(), NOW()),
('4th Grade', 10, NOW(), NOW()),
('5th Grade', 10, NOW(), NOW());


-- ============================================================
-- Sample Data: Sections
-- Each standard (grade) is divided into sections (A/B/C).
-- Sections are used to manage class divisions, student
-- assignments, timetables, and teacher allocation.
-- 'deleted' = 0 indicates active section, 1 indicates soft-deleted.
-- ============================================================


INSERT INTO sections (standard_id, section_name, created_at, updated_at, deleted, deleted_at)
VALUES
    -- Standard 1
    (1, 'A', NOW(), NOW(), 1, NULL),
    (1, 'B', NOW(), NOW(), 0, NULL),
    (1, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 2
    (2, 'A', NOW(), NOW(), 0, NULL),
    (2, 'B', NOW(), NOW(), 0, NULL),
    (2, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 3
    (3, 'A', NOW(), NOW(), 0, NULL),
    (3, 'B', NOW(), NOW(), 0, NULL),
    (3, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 4
    (4, 'A', NOW(), NOW(), 0, NULL),
    (4, 'B', NOW(), NOW(), 0, NULL),
    (4, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 5
    (5, 'A', NOW(), NOW(), 0, NULL),
    (5, 'B', NOW(), NOW(), 0, NULL),
    (5, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 6
    (6, 'A', NOW(), NOW(), 0, NULL),
    (6, 'B', NOW(), NOW(), 0, NULL),
    (6, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 7
    (7, 'A', NOW(), NOW(), 0, NULL),
    (7, 'B', NOW(), NOW(), 0, NULL),
    (7, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 8
    (8, 'A', NOW(), NOW(), 0, NULL),
    (8, 'B', NOW(), NOW(), 0, NULL),
    (8, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 9
    (9, 'A', NOW(), NOW(), 0, NULL),
    (9, 'B', NOW(), NOW(), 0, NULL),
    (9, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 10
    (10, 'A', NOW(), NOW(), 0, NULL),
    (10, 'B', NOW(), NOW(), 0, NULL),
    (10, 'C', NOW(), NOW(), 0, NULL);



-- ============================================================
-- Sample Data: Students
-- Each student is linked to a campus, standard (grade), and
-- section. This data includes basic personal information,
-- contact info, enrollment details, and active status.
-- ============================================================


INSERT INTO students
(campus_id, standard_id, section_id, student_code, full_name, first_name, last_name, date_of_birth, gender, email,
 phone, address, is_active, status, enrollment_date, deleted)
VALUES (1, 1, 1, 'STU001', 'Ali Khan', 'Ali', 'Khan', '2008-05-15', 'Male', 'ali.khan@example.com', '03001234567',
        'Gulshan-e-Iqbal, Karachi', 1, 'Enrolled', '2024-04-02', 0),
       (1, 1, 2, 'STU002', 'Ayesha Malik', 'Ayesha', 'Malik', '2009-03-21', 'Female', 'ayesha.malik@example.com',
        '03015678900', 'Model Town, Lahore', 1, 'Enrolled', '2024-04-03', 0),
       (1, 2, 3, 'STU003', 'Hassan Ali', 'Hassan', 'Ali', '2007-10-11', 'Male', 'hassan.ali@example.com', '03007894561',
        'Cantt Road, Rawalpindi', 1, 'Enrolled', '2024-04-05', 0),
       (2, 2, 4, 'STU004', 'Fatima Shah', 'Fatima', 'Shah', '2008-12-01', 'Female', 'fatima.shah@example.com',
        '03112233445', 'North Nazimabad, Karachi', 1, 'Enrolled', '2024-04-06', 0),
       (2, 3, 5, 'STU005', 'Saad Ahmed', 'Saad', 'Ahmed', '2010-06-18', 'Male', 'saad.ahmed@example.com', '03214567890',
        'F-8 Sector, Islamabad', 1, 'Enrolled', '2024-04-06', 0),
       (1, 3, 6, 'STU006', 'Zainab Raza', 'Zainab', 'Raza', '2011-01-09', 'Female', 'zainab.raza@example.com',
        '03023456781', 'Johar Town, Lahore', 1, 'Enrolled', '2024-04-07', 0),
       (1, 4, 7, 'STU007', 'Ahmed Farooq', 'Ahmed', 'Farooq', '2009-07-19', 'Male', 'ahmed.farooq@example.com',
        '03002345890', 'Garden West, Karachi', 1, 'Enrolled', '2024-04-10', 0),
       (2, 4, 8, 'STU008', 'Maryam Iqbal', 'Maryam', 'Iqbal', '2010-11-25', 'Female', 'maryam.iqbal@example.com',
        '03113335566', 'Bahria Town, Lahore', 1, 'Enrolled', '2024-04-11', 0),
       (1, 5, 9, 'STU009', 'Usman Tariq', 'Usman', 'Tariq', '2008-09-02', 'Male', 'usman.tariq@example.com',
        '03029876543', 'Satellite Town, Rawalpindi', 1, 'Enrolled', '2024-04-12', 0),
       (2, 5, 10, 'STU010', 'Hiba Rehman', 'Hiba', 'Rehman', '2011-02-14', 'Female', 'hiba.rehman@example.com',
        '03440011223', 'Defence Phase 2, Karachi', 1, 'Enrolled', '2024-04-12', 0);



-- ============================================================
-- Fee Catalog Sample Data
-- Each entry represents a charge that can be applied to students.
-- Fields:
--   code             : Unique code for fee
--   name             : Descriptive name of the fee
--   description      : Explanation / purpose of the fee
--   charge_type      : FIXED / VARIABLE / PER_SUBJECT / PER_CREDIT / PERCENTAGE
--   recurrence_rule  : ONE_TIME / MONTHLY / YEARLY / TERM_WISE
--   active           : TRUE if currently applicable
--   deleted          : Soft-delete flag
--   created_at/updated_at : Audit timestamps
-- ============================================================

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



-- ============================================================
-- Fee Components linked to Fee Catalog
-- Each fee_catalog entry (like Tuition Fee, Admission Fee) can have multiple components
-- Fields:
--   fee_catalog_id  : Reference to the fee_catalog table
--   component_code  : Unique code for the component
--   component_name  : Descriptive name
--   account_code    : Ledger/account code for accounting
--   taxable         : TRUE if taxable
-- ============================================================

INSERT INTO fee_component
    (fee_catalog_id, component_code, component_name, account_code, taxable)
VALUES

-- ============================================================
-- MAIN CAMPUS
-- ============================================================

-- 1. MAIN — Admission Fee (ID: 1)
(1, 'ADM-MAIN-FORM', 'Admission Form Fee', 'AC-101', FALSE),
(1, 'ADM-MAIN-PROC', 'Admission Processing', 'AC-102', FALSE),
(1, 'ADM-MAIN-TEST', 'Admission Test Fee', 'AC-103', FALSE),

-- 2. MAIN — Tuition Fee (ID: 2)
(2, 'TUI-MAIN-BASIC', 'Basic Tuition Fee', 'AC-201', FALSE),
(2, 'TUI-MAIN-ACT', 'Activities Add-on', 'AC-202', FALSE),
(2, 'TUI-MAIN-LAB', 'Lab Access Fee', 'AC-203', FALSE),

-- 3. MAIN — Transport Fee (ID: 3)
(3, 'TRN-MAIN-FARE', 'Base Transport Fare', 'AC-301', FALSE),
(3, 'TRN-MAIN-FUEL', 'Fuel Adjustment Fee', 'AC-302', TRUE),
(3, 'TRN-MAIN-MAINT', 'Vehicle Maintenance Fee', 'AC-303', FALSE),

-- 4. MAIN — Annual Charges (ID: 4)
(4, 'ANN-MAIN-MAINT', 'Annual Maintenance', 'AC-401', FALSE),
(4, 'ANN-MAIN-ACT', 'Annual Activities Fee', 'AC-402', FALSE),
(4, 'ANN-MAIN-DEV', 'School Development Fund', 'AC-403', FALSE),

-- 5. MAIN — Examination Fee (ID: 5)
(5, 'EXM-MAIN-MID', 'Midterm Exam Fee', 'AC-501', FALSE),
(5, 'EXM-MAIN-FINAL', 'Final Exam Fee', 'AC-502', FALSE),
(5, 'EXM-MAIN-BOARD', 'Board Registration Fee', 'AC-503', FALSE),


-- ============================================================
-- CITY CAMPUS
-- ============================================================

-- 6. CITY — Admission Fee (ID: 6)
(6, 'ADM-CITY-FORM', 'Admission Form Fee', 'AC-601', FALSE),
(6, 'ADM-CITY-PROC', 'Admission Processing', 'AC-602', FALSE),

-- 7. CITY — Tuition Fee (ID: 7)
(7, 'TUI-CITY-BASIC', 'Basic Tuition Fee', 'AC-701', FALSE),
(7, 'TUI-CITY-ACT', 'Activity Charges', 'AC-702', FALSE),

-- 8. CITY — Lab Charges (ID: 8)
(8, 'LAB-CITY-COMP', 'Computer Lab Fee', 'AC-801', FALSE),
(8, 'LAB-CITY-SCI', 'Science Lab Fee', 'AC-802', FALSE),
(8, 'LAB-CITY-MAINT', 'Lab Maintenance Fee', 'AC-803', FALSE),


-- ============================================================
-- GIRLS CAMPUS
-- ============================================================

-- 9. GIRLS — Admission Fee (ID: 9)
(9, 'ADM-GIRLS-FORM', 'Admission Form Fee', 'AC-901', FALSE),
(9, 'ADM-GIRLS-PROC', 'Admission Processing', 'AC-902', FALSE),

-- 10. GIRLS — Tuition Fee (ID: 10)
(10, 'TUI-GIRLS-BASIC', 'Basic Tuition Fee', 'AC-1001', FALSE),
(10, 'TUI-GIRLS-ACT', 'Activities Add-on', 'AC-1002', FALSE),
(10, 'TUI-GIRLS-SCI', 'Science Material Fee', 'AC-1003', FALSE),

-- 11. GIRLS — Library Fee (ID: 11)
(11, 'LIB-GIRLS-BOOK', 'Book Rental Fee', 'AC-1101', FALSE),
(11, 'LIB-GIRLS-MAINT', 'Library Maintenance Fee', 'AC-1102', FALSE),
(11, 'LIB-GIRLS-CARD', 'Library Card Fee', 'AC-1103', FALSE);


-- ============================================================
-- Fee Rates
-- Each rate links a fee component to a campus, standard, and academic year.
-- Fields:
--   campus_id        : Reference to campuses table
--   standard_id      : Reference to standards table
--   fee_component_id : Reference to fee_component table
--   academic_year_id : Reference to academic_years table
--   code             : Unique code for this rate
--   name             : Descriptive name
--   description      : Details about the fee
--   amount           : Fee amount
--   currency         : Currency (e.g., PKR)
--   effective_from   : Start date of this fee rate
--   effective_to     : End date (NULL = open-ended)
--   active           : TRUE if rate is currently active
--   deleted          : FALSE if not deleted
-- ============================================================

INSERT INTO fee_rates
(campus_id, standard_id, fee_component_id, academic_year_id, code, name, description, amount, currency, effective_from,
 effective_to, active, deleted)
VALUES

-- ============================================================
-- MAIN CAMPUS — Admission Fees
-- ============================================================
(1, 1, 1, 1, 'FR-MAIN-ADM-FORM-001', 'Admission Form Fee Rate', 'Rate for Admission Form Fee', 5000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 2, 1, 'FR-MAIN-ADM-PROC-001', 'Admission Processing Fee Rate', 'Rate for Admission Processing', 2000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 3, 1, 'FR-MAIN-ADM-TEST-001', 'Admission Test Fee Rate', 'Rate for Admission Test', 1500.00, 'PKR', '2025-01-01',
 NULL, TRUE, FALSE),

-- ============================================================
-- MAIN CAMPUS — Tuition Fees
-- ============================================================
(1, 1, 4, 1, 'FR-MAIN-TUI-BASIC-001', 'Basic Tuition Fee Rate', 'Rate for Basic Tuition', 20000.00, 'PKR', '2025-01-01',
 NULL, TRUE, FALSE),
(1, 1, 5, 1, 'FR-MAIN-TUI-ACT-001', 'Activities Add-on Fee Rate', 'Rate for Activity Charges', 3000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 6, 1, 'FR-MAIN-TUI-LAB-001', 'Lab Access Fee Rate', 'Rate for Lab Access', 2500.00, 'PKR', '2025-01-01', NULL,
 TRUE, FALSE),

-- ============================================================
-- MAIN CAMPUS — Transport Fees
-- ============================================================
(1, 1, 7, 1, 'FR-MAIN-TRN-FARE-001', 'Base Transport Fare Rate', 'Rate for Transport Base Fare', 8000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 8, 1, 'FR-MAIN-TRN-FUEL-001', 'Fuel Adjustment Fee Rate', 'Rate for Fuel Adjustment', 1500.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 9, 1, 'FR-MAIN-TRN-MAINT-001', 'Vehicle Maintenance Fee Rate', 'Rate for Vehicle Maintenance', 2000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- CITY CAMPUS — Admission Fees
-- ============================================================
(2, 1, 10, 1, 'FR-CITY-ADM-FORM-001', 'Admission Form Fee Rate', 'Rate for City Admission Form Fee', 4000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(2, 1, 11, 1, 'FR-CITY-ADM-PROC-001', 'Admission Processing Fee Rate', 'Rate for City Admission Processing', 1500.00,
 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- GIRLS CAMPUS — Tuition Fees
-- ============================================================
(3, 1, 14, 1, 'FR-GIRLS-TUI-BASIC-001', 'Girls Basic Tuition Fee Rate', 'Rate for Girls Basic Tuition', 18000.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 15, 1, 'FR-GIRLS-TUI-ACT-001', 'Girls Activity Add-on Rate', 'Rate for Girls Activities', 2500.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 16, 1, 'FR-GIRLS-TUI-SCI-001', 'Science Material Fee Rate', 'Rate for Science Materials', 1200.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- GIRLS CAMPUS — Library Fees
-- ============================================================
(3, 1, 17, 1, 'FR-GIRLS-LIB-BOOK-001', 'Book Rental Fee Rate', 'Rate for Book Rental', 500.00, 'PKR', '2025-01-01',
 NULL, TRUE, FALSE),
(3, 1, 18, 1, 'FR-GIRLS-LIB-MAINT-001', 'Library Maintenance Fee Rate', 'Rate for Library Maintenance', 800.00, 'PKR',
 '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 19, 1, 'FR-GIRLS-LIB-CARD-001', 'Library Card Fee Rate', 'Rate for Library Card', 200.00, 'PKR', '2025-01-01',
 NULL, TRUE, FALSE);


-- ============================================================

-- Table: discount_type
-- Fields:
--   code          : Unique identifier for the discount type
--   name          : Descriptive name of the discount category
--   description   : Explains when/how the discount applies
--   is_active     : TRUE if currently applicable
--   priority      : Higher number → higher precedence when multiple discounts apply
--   display_order : Order in which discount types are shown in UI
--   created_by    : User ID who created the record
-- ============================================================

INSERT INTO discount_type
(code, name, description, is_active, priority, display_order, created_by)
VALUES ('MERIT', 'Academic / Merit-Based Discounts',
        'Scholarships and awards based on academic excellence or subject performance.', TRUE, 100, 1, 1),
       ('FAMILY', 'Family-Based Discounts', 'Discounts for siblings, staff children, or alumni children.', TRUE, 80, 2,
        1),
       ('FINANCIAL', 'Financial / Social Support', 'Need-based, government, or NGO-sponsored tuition support.', TRUE,
        90, 3, 1),
       ('PERFORMANCE', 'Performance / Extra-Curricular',
        'Discounts for sports, cultural achievements, leadership roles.', TRUE, 70, 4, 1),
       ('ATTENDANCE', 'Attendance / Behavior-Based', 'Rewards for perfect attendance or exemplary behavior.', TRUE, 60,
        5, 1),
       ('SPECIAL', 'One-Time / Special Case Discounts',
        'Medical, emergency, transfer, or custom administrative discounts.', TRUE, 50, 6, 1);


-- ============================================================

-- Table: discount_sub_type
-- Fields:
--   code            : Unique identifier for the sub-type
--   name            : Sub-type name
--   description     : Explains when/how the sub-type applies
--   discount_type_id: References discount_type(id)
--   is_active       : TRUE if currently applicable
--   display_order   : Order within the discount type
--   created_by      : User ID who created the record
-- ============================================================

INSERT INTO discount_sub_type
(code, name, description, discount_type_id, is_active, display_order, created_by)
VALUES
-- ============================
-- MERIT Sub-Types
-- ============================
('MERIT_TOPPER', 'Class Topper Discount',
 'Awarded to top-performing students in their class or grade.',
 1, TRUE, 1, 1),

('MERIT_POSITION', 'Position Holder Discount',
 'Given to students securing 1st, 2nd, or 3rd position in exams.',
 1, TRUE, 2, 1),

('MERIT_SUBJECT', 'Subject Excellence Discount',
 'For exceptional performance in specific subjects like Math, Science, English.',
 1, TRUE, 3, 1),

('MERIT_OVERALL', 'Overall Academic Excellence',
 'For consistent high academic performance throughout the year.',
 1, TRUE, 4, 1),

('MERIT_BOARD', 'Board Exam Achievement',
 'Discount for high marks in Federal/Board examinations.',
 1, TRUE, 5, 1),

-- ============================
-- FAMILY Sub-Types
-- ============================
('FAMILY_SIBLING', 'Sibling Discount',
 'Given when multiple siblings are enrolled in the school.',
 2, TRUE, 1, 1),

('FAMILY_STAFF_CHILD', 'Staff Child Discount',
 'Special discount for children of school employees and staff.',
 2, TRUE, 2, 1),

('FAMILY_ALUMNI', 'Alumni Child Discount',
 'For children of former students (alumni).',
 2, TRUE, 3, 1),

('FAMILY_MULTI_CHILD', 'Multi-Child Scheme',
 'For families with 3 or more children in the school.',
 2, TRUE, 4, 1),

('FAMILY_GUARDIAN', 'Guardian-Based Discount',
 'Discount for students under the care of registered guardians.',
 2, TRUE, 5, 1),

-- ============================
-- FINANCIAL Sub-Types
-- ============================
('FINANCIAL_NEED', 'Low-Income Support',
 'Need-based fee support for low-income households.',
 3, TRUE, 1, 1),

('FINANCIAL_GOVT', 'Government-Sponsored Support',
 'Discounts applied through government assistance programs.',
 3, TRUE, 2, 1),

('FINANCIAL_NGO', 'NGO / Donor Sponsored Discount',
 'Financial support provided through NGOs or private donors.',
 3, TRUE, 3, 1),

('FINANCIAL_ORPHAN', 'Orphan Support Program',
 'Fee discount or waiver for orphan students.',
 3, TRUE, 4, 1),

('FINANCIAL_SPECIAL_CASE', 'Special Financial Hardship Discount',
 'Temporary discount due to sudden hardship such as job loss or crisis.',
 3, TRUE, 5, 1),

-- ============================
-- PERFORMANCE Sub-Types
-- ============================
('PERF_SPORTS', 'Sports Achievement Discount',
 'For achievements or participation in district, state, or national-level sports events.',
 4, TRUE, 1, 1),

('PERF_CULTURAL', 'Cultural Achievement Discount',
 'For achievements in music, dance, art, or cultural competitions.',
 4, TRUE, 2, 1),

('PERF_LEADERSHIP', 'Leadership Role Discount',
 'Given to student leaders such as Head Boy, Head Girl, or Prefects.',
 4, TRUE, 3, 1),

('PERF_COMPETITION', 'Inter-School Competition Award',
 'For achievements in inter-school competitions (debate, quiz, science fair, etc.).',
 4, TRUE, 4, 1),

('PERF_ATTENDANCE', 'High Attendance with Performance',
 'Given for consistent attendance combined with active performance.',
 4, TRUE, 5, 1),

-- ============================
-- ATTENDANCE Sub-Types
-- ============================
('ATTEND_100', '100% Attendance Discount',
 'Awarded for perfect attendance throughout the academic year.',
 5, TRUE, 1, 1),

('ATTEND_95', '95% Attendance Discount',
 'For students who maintain 95% or above attendance.',
 5, TRUE, 2, 1),

('ATTEND_BEHAVIOR', 'Good Behavior Discount',
 'Awarded for maintaining discipline, manners, and positive behavior.',
 5, TRUE, 3, 1),

('ATTEND_CONDUCT', 'Conduct Excellence Discount',
 'For exemplary conduct and overall discipline.',
 5, TRUE, 4, 1),

-- ============================
-- SPECIAL Sub-Types
-- ============================
('SPECIAL_MEDICAL', 'Medical Emergency Discount',
 'Given due to critical medical issues in student or family.',
 6, TRUE, 1, 1),

('SPECIAL_TRANSFER', 'Transfer Case Support',
 'For students admitted due to relocation or transfers.',
 6, TRUE, 2, 1),

('SPECIAL_COVID', 'Emergency Relief Discount',
 'Emergency relief discount in crisis situations (pandemic, natural disasters).',
 6, TRUE, 3, 1),

('SPECIAL_ADMIN', 'Administrative Discount',
 'Principal/Administrator approved discount for special cases.',
 6, TRUE, 4, 1),

('SPECIAL_FEE_WAIVER', 'Fee Waiver (Full/Partial)',
 'One-time custom fee waiver based on case-by-case evaluation.',
 6, TRUE, 5, 1);


-- ============================================================
-- Table: discount_rate
-- Fields:
--   value               : Numeric value of the discount (amount or percentage)
--   is_percentage       : TRUE if the value is a percentage, FALSE if fixed amount
--   effective_from      : Start date when the discount is applicable
--   effective_to        : End date for discount applicability (nullable for ongoing)
--   is_active           : TRUE if discount is currently active
--   deleted             : TRUE if record is logically deleted
--   discount_sub_type_id: References discount_sub_type(id), specifies which sub-type this rate belongs to
--   campus_id           : References campus(id), NULL if global
--   academic_year_id    : References academic_year(id) for which this rate applies
--   created_by          : User ID who created the record
-- ============================================================

INSERT INTO discount_rate
(value, is_percentage, effective_from, effective_to, is_active, deleted,
 discount_sub_type_id, campus_id, academic_year_id, created_by)
VALUES (15.00, TRUE, '2024-04-01', '2025-03-31', TRUE, FALSE, 1, 1, 1, 1),
       (10.00, TRUE, '2024-04-01', '2024-12-31', TRUE, FALSE, 2, 2, 1, 1),
       (5000.00, FALSE, '2024-08-01', '2025-07-31', TRUE, FALSE, 3, NULL, 2, 1),
       (20.00, TRUE, '2024-05-15', '2025-05-14', TRUE, FALSE, 4, 1, 2, 1),
       (25.00, TRUE, '2024-06-01', '2024-12-31', TRUE, FALSE, 5, 3, 2, 1),

       (12.00, TRUE, '2024-04-01', '2025-03-31', TRUE, FALSE, 6, 1, 1, 1),
       (3000.00, FALSE, '2024-09-01', '2025-08-31', TRUE, FALSE, 7, NULL, 2, 1),
       (8.00, TRUE, '2024-08-01', '2025-02-01', TRUE, FALSE, 8, 3, 3, 1),
       (10.00, TRUE, '2024-04-01', '2024-10-31', TRUE, FALSE, 9, 1, 3, 1),
       (500.00, FALSE, '2024-07-15', '2025-01-15', TRUE, FALSE, 10, NULL, 1, 1),

       (18.00, TRUE, '2024-04-01', '2025-03-31', TRUE, FALSE, 11, 2, 4, 1),
       (7.00, TRUE, '2024-09-01', '2025-08-31', TRUE, FALSE, 12, NULL, 4, 1),
       (6000.00, FALSE, '2024-06-01', '2025-05-31', TRUE, FALSE, 13, 1, 5, 1),
       (5.00, TRUE, '2024-04-01', '2024-12-31', TRUE, FALSE, 14, 3, 5, 1),
       (8000.00, FALSE, '2024-08-01', '2025-07-31', TRUE, FALSE, 15, 2, 4, 1),

       (10.00, TRUE, '2024-05-01', '2025-04-30', TRUE, FALSE, 16, 1, 2, 1),
       (9000.00, FALSE, '2024-07-01', '2025-06-30', TRUE, FALSE, 17, NULL, 3, 1),
       (20.00, TRUE, '2024-04-01', '2025-03-31', TRUE, FALSE, 18, 2, 1, 1),
       (14.00, TRUE, '2024-10-01', '2025-09-30', TRUE, FALSE, 19, 3, 2, 1),
       (4500.00, FALSE, '2024-08-01', '2025-08-01', TRUE, FALSE, 20, 1, 4, 1),

       (5.00, TRUE, '2024-04-01', '2024-12-31', TRUE, FALSE, 21, NULL, 4, 1),
       (30.00, TRUE, '2024-06-01', '2025-05-31', TRUE, FALSE, 22, 2, 5, 1),
       (7000.00, FALSE, '2024-08-01', '2025-07-31', TRUE, FALSE, 23, 3, 1, 1),
       (6.00, TRUE, '2024-05-01', '2024-11-01', TRUE, FALSE, 24, NULL, 3, 1),
       (900.00, FALSE, '2024-07-01', '2025-01-01', TRUE, FALSE, 25, 1, 2, 1),

       (17.00, TRUE, '2024-04-01', '2025-03-31', TRUE, FALSE, 1, 3, 1, 1),
       (600.00, FALSE, '2024-09-01', '2025-02-01', TRUE, FALSE, 2, NULL, 2, 1),
       (9.00, TRUE, '2024-10-01', '2025-03-01', TRUE, FALSE, 3, 2, 3, 1),
       (5000.00, FALSE, '2024-05-01', '2025-05-01', TRUE, FALSE, 4, 1, 4, 1),
       (15.00, TRUE, '2024-06-01', '2025-06-01', TRUE, FALSE, 5, 3, 5, 1);



INSERT INTO system_users (username, email, phone, password_hash, is_active, is_verified)
VALUES
    ('admin.user', 'admin@example.com', '03001234567',
     '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, TRUE),

    ('teacher.user', 'teacher@example.com', '03007654321',
     '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE),

    ('student.user', 'student@example.com', '03111223344',
     '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE);
