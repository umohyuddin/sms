DROP
DATABASE IF EXISTS sms;
CREATE
DATABASE IF NOT EXISTS sms;
USE
sms;

SET
FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `academic_years`;
CREATE TABLE academic_years
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50) NOT NULL, -- e.g., "2024-2025"
    start_date   DATE        NOT NULL,
    end_date     DATE        NOT NULL,
    total_months INT         NOT NULL, -- Total months in the academic year
    is_current   BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at   DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


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

-- institutes TABLE
DROP TABLE IF EXISTS `institutes`;
CREATE TABLE institutes
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    address          VARCHAR(255),
    contact_number   VARCHAR(20),
    email            VARCHAR(100),
    website          VARCHAR(100),
    tagline          VARCHAR(255),
    country          VARCHAR(100),
    logo             LONGBLOB,
    established_date DATE,
    created_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO institutes (name, address, contact_number, email, website, tagline, country, logo, established_date)
VALUES ('Smart Solutions School', '123 Main Street, Cityville', '03001234567', 'info@smartsolutions.edu',
        'https://www.smartsolutions.edu', 'Excellence in Education', 'Pakistan',
        NULL, '2005-08-15');


-- campuses TABLE
DROP TABLE IF EXISTS `campuses`;
CREATE TABLE campuses
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    province_id  BIGINT,
    city_id      BIGINT,
    institute_id BIGINT       NOT NULL,
    campus_name  VARCHAR(100) NOT NULL,
    contact      VARCHAR(20),
    email        VARCHAR(100),
    website      VARCHAR(100),
    address      VARCHAR(255),
    province     VARCHAR(100),
    city         VARCHAR(50),
    logo         LONGBLOB,
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted_at   DATETIME,
    CONSTRAINT fk_institute FOREIGN KEY (institute_id) REFERENCES institutes (id)
);

INSERT INTO campuses (id, institute_id, campus_name, contact, email, website, address, province, city, created_at,
                      updated_at, deleted, deleted_at)
VALUES (1, 1, 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com', 'https://downtown.smarteschool.com',
        '123 Main Street', 'Punjab', 'Lahore', NOW(), NOW(), TRUE, NULL),
       (2, 1, 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com', 'https://uptown.smarteschool.com',
        '456 Park Avenue', 'Punjab', 'Lahore', NOW(), NOW(), TRUE, NULL),
       (3, 1, 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com', 'https://riverside.smarteschool.com',
        '789 River Road', 'Sindh', 'Karachi', NOW(), NOW(), FALSE, NULL),
       (4, 1, 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com', 'https://hilltop.smarteschool.com',
        '101 Hill Street', 'KPK', 'Peshawar', NOW(), NOW(), FALSE, NULL),
       (5, 1, 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
        'https://greenfield.smarteschool.com',
        '202 Green Road', 'Punjab', 'Faisalabad', NOW(), NOW(), FALSE, NULL),
       (6, 1, 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com', 'https://seaside.smarteschool.com',
        '303 Beach Avenue', 'Sindh', 'Karachi', NOW(), NOW(), FALSE, NULL),
       (7, 1, 'Central Campus', '+92-303-9990001', 'central@smarteschool.com', 'https://central.smarteschool.com',
        '404 Central Street', 'Punjab', 'Multan', NOW(), NOW(), FALSE, NULL),
       (8, 1, 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com', 'https://lakeside.smarteschool.com',
        '505 Lake Road', 'Sindh', 'Hyderabad', NOW(), NOW(), FALSE, NULL),
       (9, 1, 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com', 'https://sunrise.smarteschool.com',
        '606 Sunrise Blvd', 'Punjab', 'Rawalpindi', NOW(), NOW(), FALSE, NULL),
       (10, 1, 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com', 'https://maple.smarteschool.com',
        '707 Maple Street', 'Balochistan', 'Quetta', NOW(), NOW(), FALSE, NULL);


-- standards TABLE
DROP TABLE IF EXISTS standards;
CREATE TABLE standards
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_name VARCHAR(50) NOT NULL,
    standard_code VARCHAR(50),
    description   VARCHAR(500),
    campus_id     BIGINT      NOT NULL,
    created_at    DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted       BOOLEAN     NOT NULL DEFAULT FALSE,
    deleted_at    DATETIME,
    FOREIGN KEY (campus_id) REFERENCES campuses (id)
);

INSERT INTO standards (id, standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES (1, '1st Grade', 1, NOW(), NOW(), 1, NULL),
       (2, '2nd Grade', 1, NOW(), NOW(), 1, NULL),
       (3, '3rd Grade', 1, NOW(), NOW(), 0, NULL),
       (4, '4th Grade', 1, NOW(), NOW(), 0, NULL),
       (5, '5th Grade', 1, NOW(), NOW(), 0, NULL),
       (6, '6th Grade', 1, NOW(), NOW(), 0, NULL),
       (7, '7th Grade', 1, NOW(), NOW(), 0, NULL),
       (8, '8th Grade', 1, NOW(), NOW(), 0, NULL),
       (9, '9th Grade', 1, NOW(), NOW(), 0, NULL),
       (10, '10th Grade', 1, NOW(), NOW(), 0, NULL);


-- sections TABLE
DROP TABLE IF EXISTS `sections`;
CREATE TABLE sections
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_id  BIGINT      NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15),
    created_at   DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      BOOLEAN     NOT NULL DEFAULT FALSE,
    deleted_at   DATETIME,
    FOREIGN KEY (standard_id) REFERENCES standards (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
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


-- students TABLE
DROP TABLE IF EXISTS `students`;
CREATE TABLE students
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    campus_id       BIGINT       NOT NULL,
    standard_id     BIGINT       NOT NULL,
    section_id      BIGINT       NOT NULL,
    student_code    VARCHAR(20)  NOT NULL UNIQUE,
    full_name       VARCHAR(100) NOT NULL,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    date_of_birth   DATE         NOT NULL,
    gender          VARCHAR(10)  NOT NULL,
    email           VARCHAR(100) UNIQUE,
    phone           VARCHAR(20),
    address         VARCHAR(500),
    is_active       TINYINT (1) DEFAULT 1,
    status          VARCHAR(50),
    enrollment_date DATE         NOT NULL,
    deleted         TINYINT (1) DEFAULT 0,
    deleted_at      DATETIME,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (campus_id) REFERENCES campuses (id),
    FOREIGN KEY (standard_id) REFERENCES standards (id),
    FOREIGN KEY (section_id) REFERENCES sections (id)
);

-- INSERT DUMMY DATA
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

DROP TABLE IF EXISTS `fee_catalog`;
CREATE TABLE fee_catalog
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    code             VARCHAR(50)  NOT NULL UNIQUE,
    name             VARCHAR(100) NOT NULL,
    description      VARCHAR(255),
    charge_type      VARCHAR(50)  NOT NULL,
    recurrence_rule  VARCHAR(50),
    active           BOOLEAN      NOT NULL DEFAULT TRUE,

    campus_id        BIGINT       NOT NULL,
    academic_year_id BIGINT       NOT NULL,

    created_at       DATETIME              DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted          BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted_at       DATETIME,
    CONSTRAINT fk_fee_catalog_campus
        FOREIGN KEY (campus_id) REFERENCES campuses (id),

    CONSTRAINT fk_fee_catalog_academic_year
        FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);


INSERT INTO fee_catalog
(code, name, description, charge_type, recurrence_rule, active, academic_year_id, campus_id, deleted, deleted_at)
VALUES
-- General School Charges (Campus 1 – Main)
('LIB-MAIN-001', 'Library Fee', 'Library maintenance and book renewal charges', 'FIXED', 'MONTHLY', TRUE, 1, 1, FALSE,
 NULL),
('CMP-MAIN-001', 'Computer Lab Fee', 'Computer lab usage and maintenance charges', 'FIXED', 'MONTHLY', TRUE, 1, 1,
 FALSE, NULL),
('SCI-MAIN-001', 'Science Lab Fee', 'Charges for science laboratory usage', 'FIXED', 'MONTHLY', TRUE, 1, 1, FALSE,
 NULL),
('REG-MAIN-001', 'Registration Fee', 'New student registration charges', 'FIXED', 'ONE_TIME', TRUE, 1, 1, FALSE, NULL),
('SEC-MAIN-001', 'Security Charges', 'Annual security and safety maintenance fee', 'FIXED', 'YEARLY', TRUE, 1, 1, FALSE,
 NULL),
('GEN-MAIN-001', 'Generator Fuel Charges', 'Fuel cost for backup generator', 'FIXED', 'MONTHLY', TRUE, 1, 1, FALSE,
 NULL),
('DEV-MAIN-001', 'Development Charges', 'School building and infrastructure development fund', 'FIXED', 'YEARLY', TRUE,
 1, 1, FALSE, NULL),
('MAINT-MAIN-001', 'Maintenance Charges', 'School maintenance and repair charges', 'FIXED', 'MONTHLY', TRUE, 1, 1,
 FALSE, NULL),
('SPORT-MAIN-001', 'Sports Fee', 'Sports activities and facilities fee', 'FIXED', 'MONTHLY', TRUE, 1, 1, FALSE, NULL),
('ID-MAIN-001', 'Student ID Card Fee', 'Charges for issuing student ID card', 'FIXED', 'ONE_TIME', TRUE, 1, 1, FALSE,
 NULL),

('HST-ANN-001', 'Hostel Security Deposit', 'Refundable hostel security deposit', 'FIXED', 'ONE_TIME', TRUE, 1, 1, FALSE,
 NULL),

-- Campus 2 (City Campus)
('CMP-CITY-001', 'Computer Lab Fee', 'Charges for computer lab usage', 'FIXED', 'MONTHLY', TRUE, 1, 2, FALSE, NULL),
('REG-CITY-001', 'Registration Fee', 'Student registration fee - City Campus', 'FIXED', 'ONE_TIME', TRUE, 1, 2, FALSE,
 NULL),
('EXM-CITY-001', 'Exam Charges', 'Mid & final exam charges', 'FIXED', 'ONE_TIME', TRUE, 1, 2, FALSE, NULL),
('DEV-CITY-001', 'Development Fee', 'Campus development & improvement fund', 'FIXED', 'YEARLY', TRUE, 1, 2, FALSE,
 NULL),

-- Campus 3 (Girls Campus)
('CMP-GIRLS-001', 'Computer Lab Fee', 'Girls campus computer lab usage', 'FIXED', 'MONTHLY', TRUE, 1, 3, FALSE, NULL),
('EXM-GIRLS-001', 'Examination Charges', 'Girls campus exam fee', 'FIXED', 'ONE_TIME', TRUE, 1, 3, FALSE, NULL),
('REG-GIRLS-001', 'Registration Fee', 'Girls campus registration charges', 'FIXED', 'ONE_TIME', TRUE, 1, 3, FALSE,
 NULL),
('ACT-GIRLS-001', 'Activity Fee', 'Co-curricular & extra activities fee', 'FIXED', 'MONTHLY', TRUE, 1, 3, FALSE, NULL),
('HEALTH-GIRLS-001', 'Health & Medical Fee', 'Basic first-aid, medical checkup, and hygiene support', 'FIXED', 'YEARLY',
 TRUE, 1, 3, FALSE, NULL);


CREATE TABLE fee_component
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,

    fee_catalog_id BIGINT       NOT NULL,
    component_code VARCHAR(50)  NOT NULL,
    component_name VARCHAR(100) NOT NULL,
    account_code   VARCHAR(50),
    taxable        BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted        BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted_at     DATETIME,
    CONSTRAINT fk_fee_component_catalog
        FOREIGN KEY (fee_catalog_id) REFERENCES fee_catalog (id)
);

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



DROP TABLE IF EXISTS fee_rates;
CREATE TABLE fee_rates
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,

    campus_id        BIGINT       NOT NULL,
    standard_id      BIGINT       NOT NULL,
    academic_year_id BIGINT       NOT NULL,
    fee_component_id BIGINT,

    code             VARCHAR(50)  NOT NULL,
    name             VARCHAR(100) NOT NULL,
    description      VARCHAR(255),

    charge_type      VARCHAR(50),
    recurrence_rule  VARCHAR(100),

    active           BOOLEAN      NOT NULL DEFAULT TRUE,

    amount           DECIMAL(10, 2),
    effective_from   DATE,
    effective_to     DATE,

    created_at       DATETIME              DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    deleted          BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted_at       DATETIME,
    CONSTRAINT fk_fee_rates_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),

    CONSTRAINT fk_fee_rates_standard FOREIGN KEY (standard_id) REFERENCES standards (id),

    CONSTRAINT fk_fee_rates_component FOREIGN KEY (fee_component_id) REFERENCES fee_component (id),
    CONSTRAINT fk_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);


INSERT INTO fee_rates
(campus_id, standard_id, fee_component_id, code, name, description, charge_type,
 recurrence_rule, active, amount, effective_from, effective_to, academic_year_id)
VALUES
-- Library Fee
(1, 1, 11, 'LIB-MAIN-001-RATE', 'Library Fee – Basic', 'Monthly library charges', 'FIXED',
 'MONTHLY', TRUE, 300.00, '2024-04-01', NULL, 3),

-- Computer Lab
(1, 2, 2, 'CMP-MAIN-001-RATE', 'Computer Lab Fee', 'System usage + maintenance', 'FIXED',
 'MONTHLY', TRUE, 500.00, '2024-04-01', NULL, 3),

-- Science Lab
(1, 3, 3, 'SCI-MAIN-001-RATE', 'Science Lab Fee', 'Lab consumables fee', 'FIXED',
 'MONTHLY', TRUE, 450.00, '2024-04-01', NULL, 3),

-- Registration Fee (One-time)
(1, 1, 4, 'REG-MAIN-001-RATE', 'Registration Fee', 'One-time student registration', 'FIXED',
 'ONE_TIME', TRUE, 2000.00, '2024-04-01', NULL, 3),

-- Security Charges (Annual)
(1, 4, 5, 'SEC-MAIN-001-RATE', 'Security Charges', 'Annual security management fee', 'FIXED',
 'YEARLY', TRUE, 1200.00, '2024-04-01', NULL, 3);

INSERT INTO fee_rates
(campus_id, standard_id, fee_component_id, code, name, description, charge_type,
 recurrence_rule, active, amount, effective_from, effective_to, academic_year_id)
VALUES
-- Computer Lab Fee
(2, 1, 14, 'CMP-CITY-001-RATE', 'Computer Lab Fee – City', 'City campus lab charges', 'FIXED',
 'MONTHLY', TRUE, 400.00, '2024-04-01', NULL, 3),

-- Registration Fee
(2, 2, 16, 'REG-CITY-001-RATE', 'Registration Fee – City', 'One-time fee', 'FIXED',
 'ONE_TIME', TRUE, 1800.00, '2024-04-01', NULL, 3),

-- Exam Fee
(2, 3, 17, 'EXM-CITY-001-RATE', 'Examination Charges', 'Mid/Final exam charges', 'FIXED',
 'ONE_TIME', TRUE, 1500.00, '2024-04-01', NULL, 3);


INSERT INTO fee_rates
(campus_id, standard_id, fee_component_id, code, name, description, charge_type,
 recurrence_rule, active, amount, effective_from, effective_to, academic_year_id)
VALUES
-- Computer Lab Fee
(3, 1, 20, 'CMP-GIRLS-001-RATE', 'Computer Lab Fee – Girls', 'Lab maintenance (girls campus)', 'FIXED',
 'MONTHLY', TRUE, 350.00, '2024-04-01', NULL, 3),

-- Exam Fee
(3, 2, 22, 'EXM-GIRLS-001-RATE', 'Examination Fee – Girls', 'Annual exam charges', 'FIXED',
 'ONE_TIME', TRUE, 1400.00, '2024-04-01', NULL, 3),

-- Activity Fee
(3, 3, 23, 'ACT-GIRLS-001-RATE', 'Activity Fee', 'Extracurricular activities', 'FIXED',
 'MONTHLY', TRUE, 250.00, '2024-04-01', NULL, 3),

-- Health Fee
(3, 4, 24, 'HEALTH-GIRLS-001-RATE', 'Health & Medical Fee', 'Medical aid & hygiene', 'FIXED',
 'YEARLY', TRUE, 1000.00, '2024-04-01', NULL, 3);

DROP TABLE IF EXISTS student_fee_assignments;

CREATE TABLE student_fee_assignments
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,

    student_id    BIGINT NOT NULL,
    fee_rate_id   BIGINT NOT NULL,

    total_amount DOUBLE NOT NULL,
    due_date      DATE,
    assigned_date DATE,

    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_sfa_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_sfa_fee_rate FOREIGN KEY (fee_rate_id) REFERENCES fee_rates (id)
);

-- INSERT INTO student_fee_assignments (student_id, fee_rate_id, total_amount, due_date, assigned_date)
-- VALUES
-- -- STU001 (Ali Khan)
-- (1, 1, 2300.00, '2024-05-02', '2024-04-02'),
--
-- -- STU002 (Ayesha Malik)
-- (2, 1, 2300.00, '2024-05-03', '2024-04-03'),
--
-- -- STU003 (Hassan Ali)
-- (3, 2, 500.00, '2024-05-05', '2024-04-05'),
--
-- -- STU004
-- (4, 7, 1800.00, '2024-05-06', '2024-04-06'),
--
-- -- STU005
-- (5, 8, 1500.00, '2024-05-06', '2024-04-06'),
--
-- -- STU006 (Zainab Raza)
-- (6, 3, 450.00, '2024-05-07', '2024-04-07'),
--
-- -- STU007 (Ahmed Farooq)
-- (7, 5, 1200.00, '2024-05-10', '2024-04-10');


DROP TABLE IF EXISTS student_fee_payments;
CREATE TABLE student_fee_payments
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    academic_year_id BIGINT      NOT NULL,
    student_id       BIGINT      NOT NULL,
    payment_date     DATE,
    amount_paid DOUBLE NOT NULL,
    payment_month    VARCHAR(20) NOT NULL,
    payment_year     INT         NOT NULL,
    payment_mode     VARCHAR(50),

    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_fee_payment_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT fk_sfp_student FOREIGN KEY (student_id) REFERENCES students (id)
);

-- INSERT INTO student_fee_payments
-- (student_id, assignment_id, payment_date, amount_paid, payment_month, payment_year, payment_mode, created_at)
-- VALUES (1, 1, '2024-05-02', 2300.00, 'May', 2024, 'Cash', NOW()),
--        (1, 1, '2024-06-02', 2300.00, 'June', 2024, 'Bank Transfer', NOW()),
--
--        (2, 2, '2024-05-03', 2300.00, 'May', 2024, 'Cheque', NOW()),
--
--        (3, 3, '2024-05-05', 500.00, 'May', 2024, 'Cash', NOW()),
--
--        (4, 4, '2024-05-06', 1800.00, 'May', 2024, 'Bank Transfer', NOW()),
--
--        (5, 5, '2024-05-06', 1500.00, 'May', 2024, 'Cash', NOW()),
--
--        (6, 6, '2024-05-07', 450.00, 'May', 2024, 'Cash', NOW()),
--
--        (7, 7, '2024-05-10', 1200.00, 'May', 2024, 'Cheque', NOW());

DROP TABLE IF EXISTS student_fee_summary;
CREATE TABLE student_fee_summary
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id         BIGINT         NOT NULL,
    academic_year_id   BIGINT         NOT NULL,
    total_assigned_fee DECIMAL(10, 2) NOT NULL DEFAULT 0,
    total_paid         DECIMAL(10, 2) NOT NULL DEFAULT 0,
    balance            DECIMAL(10, 2) NOT NULL DEFAULT 0,
    updated_at         TIMESTAMP               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_student_fee_summary_student
        FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_Student_fee_academic_year
        FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);

DROP TABLE IF EXISTS discount_type;
CREATE TABLE discount_type
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    code          VARCHAR(50) UNIQUE NOT NULL,
    name          VARCHAR(150)       NOT NULL,
    description   VARCHAR(500),

    is_active     BOOLEAN            NOT NULL DEFAULT TRUE,
    priority      INT                         DEFAULT 0,
    display_order INT                         DEFAULT 0,

    created_by    BIGINT,
    created_at    TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP,
    updated_by    BIGINT,
    updated_at    TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP,
    deleted       BOOLEAN            NOT NULL DEFAULT FALSE,
    deleted_at    DATETIME
);

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


