-- ============================================================
-- Sample Data: Admission Types
-- This section populates the 'admission_type' table with a
-- predefined list of admission categories typically used in
-- school management systems. These records are intended to
-- standardize the process of student enrollment, fee
-- management, and reporting across different modules such as
-- student registration, class assignment, scholarship
-- management, and special programs.
-- ============================================================


INSERT INTO admission_type (code, name, description, is_active)
VALUES ('NEW_ADMISSION', 'New Admission / Fresh Admission', 'Student joining the school for the first time.', TRUE),
       ('TRANSFER', 'Transfer Admission', 'Student transferring from another school.', TRUE),
       ('READMISSION', 'Re-admission / Returning Student', 'Student returning after leaving the school.', TRUE),
       ('LATERAL_ENTRY', 'Lateral Entry / Direct Admission', 'Student joining a higher grade directly.', TRUE),
       ('SCHOLARSHIP', 'Scholarship / Concession Admission', 'Admission with full or partial fee waiver.', TRUE),
       ('MANAGEMENT', 'Management / Special Admission', 'Admission under management quota.', TRUE),
       ('EARLY', 'Early Admission', 'Admission before the academic session starts.', TRUE),
       ('LATE', 'Late Admission', 'Admission after the academic session has started.', TRUE),
       ('INTERNATIONAL', 'International / Expat Admission', 'Students from foreign countries.', TRUE),
       ('SPECIAL_NEEDS', 'Special Needs Admission', 'Students requiring special assistance.', TRUE),
       ('ONLINE', 'Online / Distance Learning Admission', 'Admission for online programs.', TRUE),
       ('SIBLING', 'Sibling Admission', 'Admission given when a sibling is already enrolled.', TRUE),
       ('STAFF_WARD', 'Staff / Employee Ward Admission', 'Children of school staff may get special consideration.',
        TRUE),
       ('MERIT', 'Merit-based Admission', 'Admission based purely on exam/test performance.', TRUE),
       ('MID_YEAR', 'Late Entry Mid-Year', 'Students joining mid-session due to relocation or other reasons.', TRUE);



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
(first_name, full_name, last_name, student_code, date_of_birth, gender, email, phone, address, cnic, passport_number,
 religion, nationality, blood_group, is_active, status, enrollment_date, deleted, campus_id, standard_id, section_id,
 admission_type_id, academic_year_id)
VALUES ('Ali', 'Ali Khan', 'Khan', 'STU001', '2008-05-15', 'MALE', 'ali.khan1@example.com', '03001234501',
        'Gulshan-e-Iqbal, Karachi', '42101-1234501-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-02', 0,
        1, 1, 1, 1, 3),
       ('Ayesha', 'Ayesha Malik', 'Malik', 'STU002', '2009-03-21', 'FEMALE', 'ayesha.malik2@example.com', '03001234502',
        'Model Town, Lahore', '42201-2345602-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-04', 0, 1, 1,
        2, 2, 3),
       ('Hassan', 'Hassan Ali', 'Ali', 'STU003', '2007-10-11', 'MALE', 'hassan.ali3@example.com', '03001234503',
        'Cantt Road, Rawalpindi', '42301-3456703-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-01-06', 0,
        1, 2, 3, 1, 3),
       ('Fatima', 'Fatima Shah', 'Shah', 'STU004', '2008-12-01', 'FEMALE', 'fatima.shah4@example.com', '03001234504',
        'North Nazimabad, Karachi', '42401-4567804-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-01-08',
        0, 2, 2, 4, 3, 3),
       ('Saad', 'Saad Ahmed', 'Ahmed', 'STU005', '2010-06-18', 'MALE', 'saad.ahmed5@example.com', '03001234505',
        'F-8 Sector, Islamabad', '42501-5678905-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-01-10', 0, 2,
        3, 5, 4, 3),
       ('Zainab', 'Zainab Raza', 'Raza', 'STU006', '2011-01-09', 'FEMALE', 'zainab.raza6@example.com', '03001234506',
        'Johar Town, Lahore', '42601-6789016-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-01-12', 0, 1, 3,
        6, 1, 3),
       ('Ahmed', 'Ahmed Farooq', 'Farooq', 'STU007', '2009-07-19', 'MALE', 'ahmed.farooq7@example.com', '03001234507',
        'Garden West, Karachi', '42701-7890127-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-01-14', 0, 1,
        4, 7, 2, 3),
       ('Maryam', 'Maryam Iqbal', 'Iqbal', 'STU008', '2010-11-25', 'FEMALE', 'maryam.iqbal8@example.com', '03001234508',
        'Bahria Town, Lahore', '42801-8901238-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-01-16', 0, 2,
        4, 8, 3, 3),
       ('Usman', 'Usman Tariq', 'Tariq', 'STU009', '2008-09-02', 'MALE', 'usman.tariq9@example.com', '03001234509',
        'Satellite Town, Rawalpindi', '42901-9012349-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-18',
        0, 1, 5, 9, 4, 3),
       ('Hiba', 'Hiba Rehman', 'Rehman', 'STU010', '2011-02-14', 'FEMALE', 'hiba.rehman10@example.com', '03001234510',
        'Defence Phase 2, Karachi', '43001-0123420-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-20', 0,
        2, 5, 10, 1, 3),
       ('Bilal', 'Bilal Ahmed', 'Ahmed', 'STU011', '2009-08-05', 'MALE', 'bilal.ahmed11@example.com', '03001234511',
        'Gulberg, Lahore', '43101-1234511-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-22', 0, 1, 1, 1,
        1, 3),
       ('Sana', 'Sana Tariq', 'Tariq', 'STU012', '2010-03-12', 'FEMALE', 'sana.tariq12@example.com', '03001234512',
        'Model Town, Lahore', '43201-2345612-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-24', 0, 1, 1,
        2, 2, 3),
       ('Omar', 'Omar Farooq', 'Farooq', 'STU013', '2008-07-19', 'MALE', 'omar.farooq13@example.com', '03001234513',
        'Cantt Road, Rawalpindi', '43301-3456713-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-01-26', 0,
        1, 2, 3, 1, 3),
       ('Areeba', 'Areeba Shah', 'Shah', 'STU014', '2011-12-25', 'FEMALE', 'areeba.shah14@example.com', '03001234514',
        'North Nazimabad, Karachi', '43401-4567814-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-01-28',
        0, 2, 2, 4, 3, 3),
       ('Hamza', 'Hamza Ali', 'Ali', 'STU015', '2009-05-21', 'MALE', 'hamza.ali15@example.com', '03001234515',
        'F-8 Sector, Islamabad', '43501-5678915-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-01-30', 0, 2,
        3, 5, 4, 3),
       ('Sadia', 'Sadia Raza', 'Raza', 'STU016', '2010-09-14', 'FEMALE', 'sadia.raza16@example.com', '03001234516',
        'Johar Town, Lahore', '43601-6789016-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-02-01', 0, 1, 3,
        6, 1, 3),
       ('Imran', 'Imran Farooq', 'Farooq', 'STU017', '2008-11-11', 'MALE', 'imran.farooq17@example.com', '03001234517',
        'Garden West, Karachi', '43701-7890117-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-02-03', 0, 1,
        4, 7, 2, 3),
       ('Huma', 'Huma Iqbal', 'Iqbal', 'STU018', '2010-06-23', 'FEMALE', 'huma.iqbal18@example.com', '03001234518',
        'Bahria Town, Lahore', '43801-8901218-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-02-05', 0, 2,
        4, 8, 3, 3),
       ('Naveed', 'Naveed Tariq', 'Tariq', 'STU019', '2009-09-17', 'MALE', 'naveed.tariq19@example.com', '03001234519',
        'Satellite Town, Rawalpindi', '43901-9012319-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-07',
        0, 1, 5, 9, 4, 3),
       ('Iram', 'Iram Rehman', 'Rehman', 'STU020', '2011-02-10', 'FEMALE', 'iram.rehman20@example.com', '03001234520',
        'Defence Phase 2, Karachi', '44001-0123420-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-02-09', 0,
        2, 5, 10, 1, 3),
       ('Ali', 'Ali Raza', 'Raza', 'STU021', '2008-04-12', 'MALE', 'ali.raza21@example.com', '03001234521',
        'Gulshan-e-Iqbal, Karachi', '44101-1234521-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-11', 0,
        1, 1, 1, 1, 3),
       ('Sara', 'Sara Ahmed', 'Ahmed', 'STU022', '2009-05-09', 'FEMALE', 'sara.ahmed22@example.com', '03001234522',
        'Model Town, Lahore', '44201-2345622-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-02-13', 0, 1, 1,
        2, 2, 3),
       ('Bilal', 'Bilal Khan', 'Khan', 'STU023', '2007-08-17', 'MALE', 'bilal.khan23@example.com', '03001234523',
        'Cantt Road, Rawalpindi', '44301-3456723-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-02-15', 0,
        1, 2, 3, 1, 3),
       ('Fiza', 'Fiza Shah', 'Shah', 'STU024', '2010-11-20', 'FEMALE', 'fiza.shah24@example.com', '03001234524',
        'North Nazimabad, Karachi', '44401-4567824-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-02-17',
        0, 2, 2, 4, 3, 3),
       ('Owais', 'Owais Farooq', 'Farooq', 'STU025', '2009-02-14', 'MALE', 'owais.farooq25@example.com', '03001234525',
        'F-8 Sector, Islamabad', '44501-5678925-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-02-19', 0, 2,
        3, 5, 4, 3),
       ('Zoya', 'Zoya Iqbal', 'Iqbal', 'STU026', '2011-01-11', 'FEMALE', 'zoya.iqbal26@example.com', '03001234526',
        'Johar Town, Lahore', '44601-6789026-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-02-21', 0, 1, 3,
        6, 1, 3),
       ('Hamza', 'Hamza Tariq', 'Tariq', 'STU027', '2008-03-25', 'MALE', 'hamza.tariq27@example.com', '03001234527',
        'Garden West, Karachi', '44701-7890127-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-02-23', 0, 1,
        4, 7, 2, 3),
       ('Aimen', 'Aimen Rehman', 'Rehman', 'STU028', '2010-08-17', 'FEMALE', 'aimen.rehman28@example.com',
        '03001234528', 'Bahria Town, Lahore', '44801-8901228-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled',
        '2025-02-25', 0, 2, 4, 8, 3, 3),
       ('Shahid', 'Shahid Ali', 'Ali', 'STU029', '2009-09-10', 'MALE', 'shahid.ali29@example.com', '03001234529',
        'Satellite Town, Rawalpindi', '44901-9012329-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-27',
        0, 1, 5, 9, 4, 3),
       ('Saba', 'Saba Tariq', 'Tariq', 'STU032', '2009-07-12', 'FEMALE', 'saba.tariq32@example.com', '03001234532',
        'Model Town, Lahore', '45201-2345632-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-03-04', 0, 1, 1,
        2, 2, 3),
       ('Rehan', 'Rehan Khan', 'Khan', 'STU033', '2007-08-25', 'MALE', 'rehan.khan33@example.com', '03001234533',
        'Cantt Road, Rawalpindi', '45301-3456733-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-03-06', 0,
        1, 2, 3, 1, 3),
       ('Nida', 'Nida Shah', 'Shah', 'STU034', '2010-12-18', 'FEMALE', 'nida.shah34@example.com', '03001234534',
        'North Nazimabad, Karachi', '45401-4567834-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-03-08',
        0, 2, 2, 4, 3, 3),
       ('Danish', 'Danish Ahmed', 'Ahmed', 'STU035', '2009-06-05', 'MALE', 'danish.ahmed35@example.com', '03001234535',
        'F-8 Sector, Islamabad', '45501-5678935-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-03-10', 0, 2,
        3, 5, 4, 3),
       ('Maryam', 'Maryam Raza', 'Raza', 'STU036', '2011-04-12', 'FEMALE', 'maryam.raza36@example.com', '03001234536',
        'Johar Town, Lahore', '45601-6789036-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-03-12', 0, 1, 3,
        6, 1, 3),
       ('Farhan', 'Farhan Farooq', 'Farooq', 'STU037', '2008-11-11', 'MALE', 'farhan.farooq37@example.com',
        '03001234537', 'Garden West, Karachi', '45701-7890137-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled',
        '2025-03-14', 0, 1, 4, 7, 2, 3),
       ('Sofia', 'Sofia Iqbal', 'Iqbal', 'STU038', '2010-02-14', 'FEMALE', 'sofia.iqbal38@example.com', '03001234538',
        'Bahria Town, Lahore', '45801-8901238-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-03-16', 0, 2,
        4, 8, 3, 3),
       ('Asad', 'Asad Tariq', 'Tariq', 'STU039', '2009-09-19', 'MALE', 'asad.tariq39@example.com', '03001234539',
        'Satellite Town, Rawalpindi', '45901-9012339-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-03-18',
        0, 1, 5, 9, 4, 3),
       ('Hina', 'Hina Rehman', 'Rehman', 'STU040', '2011-06-22', 'FEMALE', 'hina.rehman40@example.com', '03001234540',
        'Defence Phase 2, Karachi', '46001-0123440-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-03-20', 0,
        2, 5, 10, 1, 3),
       ('Omar', 'Omar Raza', 'Raza', 'STU041', '2008-04-05', 'MALE', 'omar.raza41@example.com', '03001234541',
        'Gulshan-e-Iqbal, Karachi', '46101-1234541-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-03-22', 0,
        1, 1, 1, 1, 3),
       ('Ayesha', 'Ayesha Farooq', 'Farooq', 'STU042', '2009-08-14', 'FEMALE', 'ayesha.farooq42@example.com',
        '03001234542', 'Model Town, Lahore', '46201-2345642-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled',
        '2025-03-24', 0, 1, 1, 2, 2, 3),
       ('Ali', 'Ali Shah', 'Shah', 'STU043', '2007-09-23', 'MALE', 'ali.shah43@example.com', '03001234543',
        'Cantt Road, Rawalpindi', '46301-3456743-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-03-26', 0,
        1, 2, 3, 1, 3),
       ('Sadia', 'Sadia Ahmed', 'Ahmed', 'STU044', '2010-12-05', 'FEMALE', 'sadia.ahmed44@example.com', '03001234544',
        'North Nazimabad, Karachi', '46401-4567844-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-03-28',
        0, 2, 2, 4, 3, 3),
       ('Saad', 'Saad Farooq', 'Farooq', 'STU045', '2009-05-11', 'MALE', 'saad.farooq45@example.com', '03001234545',
        'F-8 Sector, Islamabad', '46501-5678945-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-03-30', 0, 2,
        3, 5, 4, 3),
       ('Zoya', 'Zoya Khan', 'Khan', 'STU046', '2011-01-17', 'FEMALE', 'zoya.khan46@example.com', '03001234546',
        'Johar Town, Lahore', '46601-6789046-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-04-01', 0, 1, 3,
        6, 1, 3),
       ('Bilal', 'Bilal Tariq', 'Tariq', 'STU047', '2008-03-20', 'MALE', 'bilal.tariq47@example.com', '03001234547',
        'Garden West, Karachi', '46701-7890147-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-04-03', 0, 1,
        4, 7, 2, 3),
       ('Hina', 'Hina Iqbal', 'Iqbal', 'STU048', '2010-07-22', 'FEMALE', 'hina.iqbal48@example.com', '03001234548',
        'Bahria Town, Lahore', '46801-8901248-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-04-05', 0, 2,
        4, 8, 3, 3),
       ('Owais', 'Owais Rehman', 'Rehman', 'STU049', '2009-09-14', 'MALE', 'owais.rehman49@example.com', '03001234549',
        'Satellite Town, Rawalpindi', '46901-9012349-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-04-07',
        0, 1, 5, 9, 4, 3),
       ('Iram', 'Iram Shah', 'Shah', 'STU050', '2011-02-18', 'FEMALE', 'iram.shah50@example.com', '03001234550',
        'Defence Phase 2, Karachi', '47001-0123450-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-04-09', 0,
        2, 5, 10, 1, 3);

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
(campus_id, standard_id, fee_component_id, academic_year_id, description,
 amount, currency, effective_from, effective_to, active, deleted)
VALUES

-- ============================================================
-- MAIN CAMPUS — Admission Fees (Academic Year 3)
-- ============================================================
(1, 1, 1, 3, 'Rate for Admission Form Fee', 5000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 2, 3, 'Rate for Admission Processing', 2000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 3, 3, 'Rate for Admission Test', 1500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- MAIN CAMPUS — Tuition Fees (Academic Year 3)
-- ============================================================
(1, 1, 4, 3, 'Rate for Basic Tuition', 20000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 5, 3, 'Rate for Activity Charges', 3000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 6, 3, 'Rate for Lab Access', 2500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- MAIN CAMPUS — Transport Fees (Academic Year 3)
-- ============================================================
(1, 1, 7, 3, 'Rate for Transport Base Fare', 8000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 8, 3, 'Rate for Fuel Adjustment', 1500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(1, 1, 9, 3, 'Rate for Vehicle Maintenance', 2000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- CITY CAMPUS — Admission Fees (Academic Year 3)
-- ============================================================
(2, 1, 10, 3, 'Rate for City Admission Form Fee', 4000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(2, 1, 11, 3, 'Rate for City Admission Processing', 1500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- GIRLS CAMPUS — Tuition Fees (Academic Year 3)
-- ============================================================
(3, 1, 14, 3, 'Rate for Girls Basic Tuition', 18000.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 15, 3, 'Rate for Girls Activities', 2500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 16, 3, 'Rate for Science Materials', 1200.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),

-- ============================================================
-- GIRLS CAMPUS — Library Fees (Academic Year 3)
-- ============================================================
(3, 1, 17, 3, 'Rate for Book Rental', 500.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 18, 3, 'Rate for Library Maintenance', 800.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE),
(3, 1, 19, 3, 'Rate for Library Card', 200.00, 'PKR', '2025-01-01', NULL, TRUE, FALSE);

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
VALUES ('admin.user', 'admin@example.com', '03001234567',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, TRUE),

       ('teacher.user', 'teacher@example.com', '03007654321',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE),

       ('student.user', 'student@example.com', '03111223344',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE);



INSERT INTO student_fee_assignments
    (student_id, fee_rate_id, total_amount, due_date, assigned_date)
VALUES
-- Ali (STU001)
(1, 1, 5000.00, '2025-01-10', '2025-01-02'),
(1, 4, 20000.00, '2025-01-15', '2025-01-02'),
(1, 7, 8000.00, '2025-01-20', '2025-01-02'),

-- Ayesha (STU002)
(2, 1, 5000.00, '2025-01-10', '2025-01-04'),
(2, 4, 20000.00, '2025-01-15', '2025-01-04'),

-- Hassan (STU003)
(3, 1, 5000.00, '2025-01-10', '2025-01-06'),
(3, 4, 20000.00, '2025-01-15', '2025-01-06'),

-- Fatima (STU004)
(4, 1, 5000.00, '2025-01-10', '2025-01-08'),
(4, 4, 20000.00, '2025-01-15', '2025-01-08'),

-- Saad (STU005)
(5, 1, 5000.00, '2025-01-10', '2025-01-10'),
(5, 4, 20000.00, '2025-01-15', '2025-01-10');



INSERT INTO student_fee_payments
(academic_year_id, student_id, payment_date, amount_paid, payment_month, payment_year, payment_mode)
VALUES
-- Ali
(3, 1, '2025-01-12', 5000.00, 'January', 2025, 'Cash'),
(3, 1, '2025-01-18', 20000.00, 'January', 2025, 'Bank Transfer'),

-- Ayesha
(3, 2, '2025-01-12', 5000.00, 'January', 2025, 'Cash'),

-- Hassan
(3, 3, '2025-01-14', 5000.00, 'January', 2025, 'Cheque'),

-- Fatima
(3, 4, '2025-01-15', 5000.00, 'January', 2025, 'Cash'),

-- Saad
(3, 5, '2025-01-16', 2500.00, 'January', 2025, 'Bank Transfer');



INSERT INTO student_fee_summary
    (student_id, academic_year_id, total_assigned_fee, total_paid, balance)
VALUES
-- Ali: Assigned 5000+20000+8000 = 33000, Paid 25000, Balance 8000
(1, 3, 33000.00, 25000.00, 8000.00),

-- Ayesha: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(2, 3, 25000.00, 5000.00, 20000.00),

-- Hassan: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(3, 3, 25000.00, 5000.00, 20000.00),

-- Fatima: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(4, 3, 25000.00, 5000.00, 20000.00),

-- Saad: Assigned 5000+20000 = 25000, Paid 2500, Balance 22500
(5, 3, 25000.00, 2500.00, 22500.00);
