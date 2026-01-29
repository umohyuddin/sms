



INSERT INTO system_users (username, email, phone, password_hash, is_active, is_verified)
VALUES ('admin.user', 'admin@gmail.com', '03001234567',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, TRUE),

       ('teacher.user', 'teacher@example.com', '03007654321',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE),

       ('student.user', 'student@example.com', '03111223344',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE);


-- ============================================
-- Countries Table Insertions
-- Purpose: Populate the 'country' table with country codes, ISO codes, phone codes.
-- Used for student profiles, employee profiles, institute addresses, and general lookups.
-- ============================================
INSERT INTO country (country_code, country_name, iso_code, phone_code) VALUES
('AF','Afghanistan','AFG','+93'),
('AL','Albania','ALB','+355'),
('DZ','Algeria','DZA','+213'),
('AD','Andorra','AND','+376'),
('AO','Angola','AGO','+244'),
('AR','Argentina','ARG','+54'),
('AM','Armenia','ARM','+374'),
('AU','Australia','AUS','+61'),
('AT','Austria','AUT','+43'),
('AZ','Azerbaijan','AZE','+994'),
('BH','Bahrain','BHR','+973'),
('BD','Bangladesh','BGD','+880'),
('BY','Belarus','BLR','+375'),
('BE','Belgium','BEL','+32'),
('BZ','Belize','BLZ','+501'),
('BJ','Benin','BEN','+229'),
('BT','Bhutan','BTN','+975'),
('BO','Bolivia','BOL','+591'),
('BA','Bosnia and Herzegovina','BIH','+387'),
('BW','Botswana','BWA','+267'),
('BR','Brazil','BRA','+55'),
('BN','Brunei','BRN','+673'),
('BG','Bulgaria','BGR','+359'),
('BF','Burkina Faso','BFA','+226'),
('BI','Burundi','BDI','+257'),
('KH','Cambodia','KHM','+855'),
('CM','Cameroon','CMR','+237'),
('CA','Canada','CAN','+1'),
('CV','Cape Verde','CPV','+238'),
('CF','Central African Republic','CAF','+236'),
('TD','Chad','TCD','+235'),
('CL','Chile','CHL','+56'),
('CN','China','CHN','+86'),
('CO','Colombia','COL','+57'),
('KM','Comoros','COM','+269'),
('CG','Congo','COG','+242'),
('CR','Costa Rica','CRI','+506'),
('HR','Croatia','HRV','+385'),
('CU','Cuba','CUB','+53'),
('CY','Cyprus','CYP','+357'),
('CZ','Czech Republic','CZE','+420'),
('DK','Denmark','DNK','+45'),
('DJ','Djibouti','DJI','+253'),
('DO','Dominican Republic','DOM','+1'),
('EC','Ecuador','ECU','+593'),
('EG','Egypt','EGY','+20'),
('SV','El Salvador','SLV','+503'),
('EE','Estonia','EST','+372'),
('ET','Ethiopia','ETH','+251'),
('FI','Finland','FIN','+358'),
('FR','France','FRA','+33'),
('GA','Gabon','GAB','+241'),
('GE','Georgia','GEO','+995'),
('DE','Germany','DEU','+49'),
('GH','Ghana','GHA','+233'),
('GR','Greece','GRC','+30'),
('GT','Guatemala','GTM','+502'),
('GN','Guinea','GIN','+224'),
('HT','Haiti','HTI','+509'),
('HN','Honduras','HND','+504'),
('HK','Hong Kong','HKG','+852'),
('HU','Hungary','HUN','+36'),
('IS','Iceland','ISL','+354'),
('IN','India','IND','+91'),
('ID','Indonesia','IDN','+62'),
('IR','Iran','IRN','+98'),
('IQ','Iraq','IRQ','+964'),
('IE','Ireland','IRL','+353'),
('IL','Israel','ISR','+972'),
('IT','Italy','ITA','+39'),
('JM','Jamaica','JAM','+1'),
('JP','Japan','JPN','+81'),
('JO','Jordan','JOR','+962'),
('KZ','Kazakhstan','KAZ','+7'),
('KE','Kenya','KEN','+254'),
('KW','Kuwait','KWT','+965'),
('KG','Kyrgyzstan','KGZ','+996'),
('LA','Laos','LAO','+856'),
('LV','Latvia','LVA','+371'),
('LB','Lebanon','LBN','+961'),
('LY','Libya','LBY','+218'),
('LT','Lithuania','LTU','+370'),
('LU','Luxembourg','LUX','+352'),
('MY','Malaysia','MYS','+60'),
('MV','Maldives','MDV','+960'),
('ML','Mali','MLI','+223'),
('MT','Malta','MLT','+356'),
('MX','Mexico','MEX','+52'),
('MN','Mongolia','MNG','+976'),
('MA','Morocco','MAR','+212'),
('MM','Myanmar','MMR','+95'),
('NP','Nepal','NPL','+977'),
('NL','Netherlands','NLD','+31'),
('NZ','New Zealand','NZL','+64'),
('NG','Nigeria','NGA','+234'),
('NO','Norway','NOR','+47'),
('OM','Oman','OMN','+968'),
('PK','Pakistan','PAK','+92'),
('PH','Philippines','PHL','+63'),
('PL','Poland','POL','+48'),
('PT','Portugal','PRT','+351'),
('QA','Qatar','QAT','+974'),
('RO','Romania','ROU','+40'),
('RU','Russia','RUS','+7'),
('SA','Saudi Arabia','SAU','+966'),
('SG','Singapore','SGP','+65'),
('ZA','South Africa','ZAF','+27'),
('KR','South Korea','KOR','+82'),
('ES','Spain','ESP','+34'),
('LK','Sri Lanka','LKA','+94'),
('SE','Sweden','SWE','+46'),
('CH','Switzerland','CHE','+41'),
('TH','Thailand','THA','+66'),
('TR','Turkey','TUR','+90'),
('AE','United Arab Emirates','ARE','+971'),
('UA','Ukraine','UKR','+380'),
('GB','United Kingdom','GBR','+44'),
('US','United States','USA','+1'),
('UY','Uruguay','URY','+598'),
('UZ','Uzbekistan','UZB','+998'),
('VN','Vietnam','VNM','+84'),
('YE','Yemen','YEM','+967'),
('ZM','Zambia','ZMB','+260'),
('ZW','Zimbabwe','ZWE','+263');

-- ============================================
-- Provinces Table Insertions
-- Purpose: Populate the 'provinces' table with administrative regions for each country.
-- Used for address selection in institute, student, and employee forms.
-- ============================================

-- Pakistan Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(98, 'Punjab', 'PB', TRUE, 1, 1),
(98, 'Sindh', 'SD', TRUE, 1, 1),
(98, 'Khyber Pakhtunkhwa', 'KP', TRUE, 1, 1),
(98, 'Balochistan', 'BL', TRUE, 1, 1),
(98, 'Islamabad Capital Territory', 'ICT', TRUE, 1, 1),
(98, 'Gilgit-Baltistan', 'GB', TRUE, 1, 1),
(98, 'Azad Jammu & Kashmir', 'AJK', TRUE, 1, 1);

-- Saudi Arabia Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(105, 'Riyadh', 'RD', TRUE, 1, 1),
(105, 'Makkah', 'MK', TRUE, 1, 1),
(105, 'Madinah', 'MD', TRUE, 1, 1),
(105, 'Eastern Province', 'EP', TRUE, 1, 1),
(105, 'Qassim', 'QA', TRUE, 1, 1),
(105, 'Ha’il', 'HL', TRUE, 1, 1),
(105, 'Tabuk', 'TB', TRUE, 1, 1),
(105, 'Northern Borders', 'NB', TRUE, 1, 1),
(105, 'Jazan', 'JZ', TRUE, 1, 1),
(105, 'Najran', 'NJ', TRUE, 1, 1),
(105, 'Al Bahah', 'BH', TRUE, 1, 1),
(105, 'Al Jawf', 'JW', TRUE, 1, 1),
(105, 'Asir', 'AS', TRUE, 1, 1);

-- UAE Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(115, 'Abu Dhabi', 'AD', TRUE, 1, 1),
(115, 'Dubai', 'DU', TRUE, 1, 1),
(115, 'Sharjah', 'SH', TRUE, 1, 1),
(115, 'Ajman', 'AJ', TRUE, 1, 1),
(115, 'Umm Al Quwain', 'UAQ', TRUE, 1, 1),
(115, 'Ras Al Khaimah', 'RAK', TRUE, 1, 1),
(115, 'Fujairah', 'FJ', TRUE, 1, 1);

-- India Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(64, 'Andhra Pradesh', 'AP', TRUE, 1, 1),
(64, 'Arunachal Pradesh', 'AR', TRUE, 1, 1),
(64, 'Assam', 'AS', TRUE, 1, 1),
(64, 'Bihar', 'BR', TRUE, 1, 1),
(64, 'Chhattisgarh', 'CG', TRUE, 1, 1),
(64, 'Goa', 'GA', TRUE, 1, 1),
(64, 'Gujarat', 'GJ', TRUE, 1, 1),
(64, 'Haryana', 'HR', TRUE, 1, 1),
(64, 'Himachal Pradesh', 'HP', TRUE, 1, 1),
(64, 'Jharkhand', 'JH', TRUE, 1, 1),
(64, 'Karnataka', 'KA', TRUE, 1, 1),
(64, 'Kerala', 'KL', TRUE, 1, 1),
(64, 'Madhya Pradesh', 'MP', TRUE, 1, 1),
(64, 'Maharashtra', 'MH', TRUE, 1, 1),
(64, 'Manipur', 'MN', TRUE, 1, 1),
(64, 'Meghalaya', 'ML', TRUE, 1, 1),
(64, 'Mizoram', 'MZ', TRUE, 1, 1),
(64, 'Nagaland', 'NL', TRUE, 1, 1),
(64, 'Odisha', 'OR', TRUE, 1, 1),
(64, 'Rajasthan', 'RJ', TRUE, 1, 1),
(64, 'Sikkim', 'SK', TRUE, 1, 1),
(64, 'Tamil Nadu', 'TN', TRUE, 1, 1),
(64, 'Telangana', 'TS', TRUE, 1, 1),
(64, 'Tripura', 'TR', TRUE, 1, 1),
(64, 'Uttar Pradesh', 'UP', TRUE, 1, 1),
(64, 'Uttarakhand', 'UT', TRUE, 1, 1),
(64, 'West Bengal', 'WB', TRUE, 1, 1),
(64, 'Delhi', 'DL', TRUE, 1, 1),
(64, 'Jammu and Kashmir', 'JK', TRUE, 1, 1),
(64, 'Ladakh', 'LA', TRUE, 1, 1),
(64, 'Puducherry', 'PY', TRUE, 1, 1),
(64, 'Chandigarh', 'CH', TRUE, 1, 1),
(64, 'Daman and Diu', 'DD', TRUE, 1, 1),
(64, 'Dadra and Nagar Haveli', 'DN', TRUE, 1, 1),
(64, 'Lakshadweep', 'LD', TRUE, 1, 1),
(64, 'Andaman and Nicobar Islands', 'AN', TRUE, 1, 1);

-- ============================================
-- Cities Table Insertions
-- Purpose: Populate the 'cities' table with cities for each province.
-- Used for address selection in forms for students, employees, and campuses.
-- ============================================

-- Pakistan Cities
-- Punjab
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(1, 'Lahore', 'LHE', TRUE, 1, 1, NOW()),
(1, 'Faisalabad', 'FSD', TRUE, 1, 1, NOW()),
(1, 'Rawalpindi', 'RWP', TRUE, 1, 1, NOW()),
(1, 'Multan', 'MLN', TRUE, 1, 1, NOW());

-- Sindh
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(2, 'Karachi', 'KHI', TRUE, 1, 1, NOW()),
(2, 'Hyderabad', 'HYD', TRUE, 1, 1, NOW()),
(2, 'Sukkur', 'SUK', TRUE, 1, 1, NOW()),
(2, 'Larkana', 'LRK', TRUE, 1, 1, NOW());

-- Khyber Pakhtunkhwa
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(3, 'Peshawar', 'PEW', TRUE, 1, 1, NOW()),
(3, 'Mardan', 'MRD', TRUE, 1, 1, NOW()),
(3, 'Abbottabad', 'ABT', TRUE, 1, 1, NOW()),
(3, 'Swat', 'SWT', TRUE, 1, 1, NOW());

-- Balochistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(4, 'Quetta', 'QTA', TRUE, 1, 1, NOW()),
(4, 'Gwadar', 'GWD', TRUE, 1, 1, NOW()),
(4, 'Sibi', 'SBI', TRUE, 1, 1, NOW()),
(4, 'Zhob', 'ZHB', TRUE, 1, 1, NOW());

-- Islamabad Capital Territory
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(5, 'Islamabad', 'ISB', TRUE, 1, 1, NOW());

-- Gilgit-Baltistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(6, 'Gilgit', 'GIL', TRUE, 1, 1, NOW()),
(6, 'Skardu', 'SKD', TRUE, 1, 1, NOW());

-- Azad Jammu & Kashmir
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(7, 'Muzaffarabad', 'MZD', TRUE, 1, 1, NOW()),
(7, 'Mirpur', 'MIR', TRUE, 1, 1, NOW()),
(7, 'Kotli', 'KOT', TRUE, 1, 1, NOW());


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



INSERT INTO academic_years (name, code, start_date, end_date, total_months, is_current, status, remarks, is_locked, locked_at, locked_by, organization_id, created_at, created_by, updated_at, updated_by)
VALUES
('2022-2023', 'AY-2022-23', '2022-08-01', '2023-07-31', TIMESTAMPDIFF(MONTH, '2022-08-01', '2023-07-31') + 1, FALSE, 'ARCHIVED', 'Completed academic year', TRUE, NOW(), 1, 1, NOW(), 1, NOW(), 1),
('2023-2024', 'AY-2023-24', '2023-08-01', '2024-07-31', TIMESTAMPDIFF(MONTH, '2023-08-01', '2024-07-31') + 1, FALSE, 'ARCHIVED', 'Completed academic year', TRUE, NOW(), 1, 1, NOW(), 1, NOW(), 1),
('2024-2025', 'AY-2024-25', '2024-08-01', '2025-07-31', TIMESTAMPDIFF(MONTH, '2024-08-01', '2025-07-31') + 1, TRUE, 'ACTIVE', 'Current academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1),
('2025-2026', 'AY-2025-26', '2025-08-01', '2026-07-31', TIMESTAMPDIFF(MONTH, '2025-08-01', '2026-07-31') + 1, FALSE, 'UPCOMING', 'Upcoming academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1),
('2026-2027', 'AY-2026-27', '2026-08-01', '2027-07-31', TIMESTAMPDIFF(MONTH, '2026-08-01', '2027-07-31') + 1, FALSE, 'UPCOMING', 'Upcoming academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1);




-- ============================================================
-- Sample Data: Institutes
-- This dataset seeds the 'institutes' table with example
-- educational organizations. These entries are used to attach
-- campuses, academic years, users, fee structures, and other
-- modules within the system.
-- ============================================================
INSERT INTO institutes
(id, name, address, contact_number, email, website, tagline, logo_url,
 established_date, country_id, province_id, city_id, created_at, updated_at)
VALUES
(1, 'Smart Solutions School',
 '123 Main Street, Lahore',
 '+92-300-1234567',
 'info@smartsolutions.edu',
 'https://www.smartsolutions.edu',
 'Excellence in Education',
 NULL,
 '2005-08-15',
 98, 1, 1,
 NOW(), NOW());
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
/* =========================================================
   FEE CATALOG (GENERAL – STABLE)
   ========================================================= */

INSERT INTO fee_catalog
(code, name, description, charge_type, recurrence_rule,
 active, deleted,
 created_at, created_by, updated_at, updated_by,
 deleted_at, deleted_by)
VALUES ('ADMISSION', 'Admission Fee', 'One-time admission charges', 'FIXED', 'ONE_TIME',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('TUITION', 'Tuition Fee', 'Regular tuition charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('EXAM', 'Examination Fee', 'Examination related charges', 'FIXED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('LAB', 'Laboratory Fee', 'Laboratory usage and consumables charges', 'VARIABLE', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('LIBRARY', 'Library Fee', 'Library services and resources', 'FIXED', 'YEARLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('TRANSPORT', 'Transport Fee', 'Student transportation charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('HOSTEL', 'Hostel Fee', 'Boarding and lodging charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('ANNUAL', 'Annual Charges', 'General annual school charges', 'FIXED', 'YEARLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('ACTIVITY', 'Activity Fee', 'Co-curricular and extra-curricular activities', 'FIXED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('DISCOUNT', 'Discount / Scholarship', 'Fee discounts and scholarships', 'DISCOUNTED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       ('FINE', 'Late Fee / Penalty', 'Late payment fines or penalties', 'PERCENTAGE', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL);


/* =========================================================
   FEE COMPONENTS (WHAT IS CHARGED)
   ========================================================= */

INSERT INTO fee_component
(fee_catalog_id, component_code, component_name, account_code,
 taxable, discount_able,
 active, deleted, created_at, created_by)
VALUES

-- Admission
(1, 'ADM-FORM', 'Admission Form Fee', 'ACC-ADM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 'ADM-PROC', 'Admission Processing Fee', 'ACC-ADM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Tuition
(2, 'TUI-BASIC', 'Basic Tuition Fee', 'ACC-TUI-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Exam
(3, 'EXAM-MID', 'Mid Term Exam Fee', 'ACC-EXM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(3, 'EXAM-FINAL', 'Final Exam Fee', 'ACC-EXM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Lab
(4, 'LAB-COMP', 'Computer Lab Charges', 'ACC-LAB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(4, 'LAB-SCI', 'Science Lab Charges', 'ACC-LAB-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Library
(5, 'LIB-USE', 'Library Usage Fee', 'ACC-LIB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Transport
(6, 'TRN-MON', 'Monthly Transport Charges', 'ACC-TRN-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Hostel
(7, 'HOS-MON', 'Monthly Hostel Charges', 'ACC-HOS-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Annual
(8, 'ANN-MAINT', 'Annual Maintenance Charges', 'ACC-ANN-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Activity
(9, 'ACT-SPORT', 'Sports & Activities Fee', 'ACC-ACT-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Discount
(10, 'DISC-SCH', 'Scholarship Discount', 'ACC-DISC-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Fine
(11, 'FINE-LATE', 'Late Payment Fine', 'ACC-FINE-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1);


/* =========================================================
   FEE RATES (HOW MUCH / WHERE / WHEN)
   ========================================================= */

INSERT INTO fee_rates
(campus_id, standard_id, fee_component_id, academic_year_id,
 description, amount, currency,
 effective_from, effective_to,
 active, deleted, created_at, created_by)
VALUES

-- Admission (One Time)
(1, 1, 1, 3, 'Admission form charges', 3000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 2, 3, 'Admission processing charges', 2000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Tuition (Monthly)
(1, 1, 3, 3, 'Monthly tuition fee', 15000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Exam (Term Wise)
(1, 1, 4, 3, 'Mid term exam fee', 2500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 5, 3, 'Final term exam fee', 3000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Lab
(1, 1, 6, 3, 'Computer lab charges', 1200.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 7, 3, 'Science lab charges', 1500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Library
(1, 1, 8, 3, 'Annual library charges', 2000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Transport
(1, 1, 9, 3, 'Monthly transport charges', 5000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Hostel
(1, 1, 10, 3, 'Monthly hostel charges', 12000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Annual
(1, 1, 11, 3, 'Annual maintenance charges', 4000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Activity
(1, 1, 12, 3, 'Sports & activities charges', 1500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Fine (Percentage)
(1, 1, 14, 3, 'Late payment fine (%)', 5.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1);

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

BEGIN;

-- ============================================================
-- 1️⃣ discount_type
-- ============================================================

INSERT INTO discount_type
(code, name, description, charge_type, recurrence_rule, active, priority, display_order, created_by)
VALUES ('MERIT', 'Merit Based Discount',
        'Academic excellence and result-based scholarships',
        'PERCENTAGE', 'TERM_WISE', TRUE, 100, 1, 1),

       ('FAMILY', 'Family & Sibling Discount',
        'Sibling, staff child, alumni-based discounts',
        'PERCENTAGE', 'MONTHLY', TRUE, 90, 2, 1),

       ('FINANCIAL', 'Financial Assistance',
        'Need-based and hardship financial support',
        'FIXED', 'MONTHLY', TRUE, 95, 3, 1),

       ('PERFORMANCE', 'Sports & Co-Curricular',
        'Sports, leadership, and cultural achievements',
        'PERCENTAGE', 'TERM_WISE', TRUE, 80, 4, 1),

       ('ATTENDANCE', 'Attendance & Discipline',
        'Attendance and behavior rewards',
        'PERCENTAGE', 'MONTHLY', TRUE, 70, 5, 1),

       ('SPECIAL', 'Special Case / Waiver',
        'Medical, emergency and administrative cases',
        'FIXED', 'ONE_TIME', TRUE, 60, 6, 1);

-- ============================================================
-- 2️⃣ discount_sub_type
-- ============================================================

INSERT INTO discount_sub_type
(code, name, description, discount_type_id, is_active, display_order, created_by)
VALUES
-- MERIT
('MERIT_TOPPER', 'Class Topper', 'Top position holder in class', 1, TRUE, 1, 1),
('MERIT_POSITION', 'Board Position', 'Board or grade position holder', 1, TRUE, 2, 1),
('MERIT_SUBJECT', 'Subject Excellence', 'Outstanding subject performance', 1, TRUE, 3, 1),

-- FAMILY
('FAMILY_SIBLING', 'Sibling Discount', 'More than one sibling enrolled', 2, TRUE, 1, 1),
('FAMILY_STAFF', 'Staff Child', 'Child of school employee', 2, TRUE, 2, 1),

-- FINANCIAL
('FINANCIAL_NEED', 'Need Based Support', 'Low income household support', 3, TRUE, 1, 1),
('FINANCIAL_ORPHAN', 'Orphan Support', 'Orphan or single guardian case', 3, TRUE, 2, 1),

-- PERFORMANCE
('SPORTS', 'Sports Achievement', 'District or national sports player', 4, TRUE, 1, 1),
('LEADERSHIP', 'Leadership Role', 'Head boy / Head girl / prefect', 4, TRUE, 2, 1),

-- ATTENDANCE
('ATTEND_100', '100% Attendance', 'Perfect attendance', 5, TRUE, 1, 1),
('GOOD_BEHAVIOR', 'Good Behavior', 'Excellent discipline record', 5, TRUE, 2, 1),

-- SPECIAL
('MEDICAL', 'Medical Emergency', 'Serious medical case', 6, TRUE, 1, 1),
('FULL_WAIVER', 'Full Fee Waiver', 'Approved full fee waiver', 6, TRUE, 2, 1);

-- ============================================================
-- 3️⃣ discount_rate (REALISTIC % & FIXED VALUES)
-- Academic Year: 2024–2025 (id = 1)
-- Campuses: NULL = global, 1 = Main, 2 = City
-- ============================================================
INSERT INTO discount_rate
(value, is_percentage, effective_from, effective_to,
 is_active, deleted,
 discount_sub_type_id,
 campus_id, academic_year_id,
 created_by)
VALUES

-- ====================================================
-- MERIT (Term-wise %)
-- ====================================================
(30, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 1, 1, 3, 1),
(40, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 2, 1, 3, 1),
(20, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 1, 1, 3, 1),
(60, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 2, 1, 3, 1),
(80, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 3, 1, 3, 1),

-- ====================================================
-- FAMILY (Monthly %)
-- ====================================================
(10, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 4, 1, 3, 1),
(15, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 4, 1, 3, 1),
(20, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 5, 1, 3, 1),

-- ====================================================
-- FINANCIAL (Monthly FIXED)
-- ====================================================
(2000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 6, 1, 3, 1),
(3000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 6, 1, 3, 1),
(5000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 7, 1, 3, 1),

-- ====================================================
-- PERFORMANCE (Term-wise %)
-- ====================================================
(25, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 8, 1, 3, 1),
(30, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 9, 1, 3, 1),

-- ====================================================
-- ATTENDANCE (Monthly %)
-- ====================================================
(5, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 10, 1, 3, 1),
(10, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 10, 1, 3, 1),
(15, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 11, 1, 3, 1),

-- ====================================================
-- SPECIAL (One-time + Full Waiver)
-- ====================================================
(4000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 12, 1, 3, 1),
(8000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 12, 1, 3, 1),
(100, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 13, 1, 3, 1);

COMMIT;



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




INSERT INTO employee_type
(name, description, active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
('Teacher', 'General teaching staff', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Head of Department', 'Leads a specific academic department', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Principal', 'Overall in charge of school administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Vice Principal', 'Assists the principal in administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Lab Instructor', 'Handles lab sessions and practical classes', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Special Education Teacher', 'Works with students requiring special education', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Sports Coach', 'Manages sports and physical activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Music Teacher', 'Handles music and arts subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Art Teacher', 'Handles art-related subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Librarian', 'Manages library operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Administrator', 'Handles general administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Accountant', 'Manages accounts, fees, and payroll', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Receptionist', 'First point of contact for visitors and parents', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('HR Officer', 'Handles recruitment, payroll, and employee welfare', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Clerk', 'General office work', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('IT Support', 'Maintains school IT infrastructure', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Counselor', 'Provides student counseling services', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Nurse', 'Handles student health needs', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Security Guard', 'Maintains school security', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Driver', 'For school transport vehicles', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Janitor', 'Handles cleaning and maintenance', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Cafeteria Staff', 'Manages school cafeteria operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Bus Attendant', 'Assists in student transport', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('School Board Member', 'Part of the school board or governing body', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('School Coordinator', 'Coordinates programs and school events', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
('Project Manager', 'Handles special projects and development activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL);


INSERT INTO employee_master
(employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date,
 probation_end_date, primary_phone, secondary_phone, work_phone, profile_picture, bio, email, active, created_by,
 created_at, updated_by, updated_at, employee_type_id)
VALUES
('EMP001', 'Uzair', 'Anwar', 'Uzair Anwar', 'MALE', '1990-05-12', 'SINGLE', '2022-01-10', '2022-07-10',
 '03001234567', '03007654321', '0421234567', 'uzair.jpg', 'Software Engineer', 'uzair.anwar@example.com', TRUE,
 1, NOW(), 1, NOW(), 11),

('EMP002', 'Ayesha', 'Khan', 'Ayesha Khan', 'FEMALE', '1988-11-25', 'MARRIED', '2021-06-15', '2021-12-15',
 '03009876543', '03001239876', '0429876543', 'ayesha.jpg', 'HR Manager', 'ayesha.khan@example.com', TRUE, 1,
 NOW(), 1, NOW(), 14),

('EMP003', 'Ali', 'Raza', 'Ali Raza', 'MALE', '1992-03-30', 'SINGLE', '2023-03-01', '2023-09-01',
 '03004567890', NULL, '0424567890', 'ali.jpg', 'Accountant', 'ali.raza@example.com', TRUE, 1, NOW(), 1, NOW(), 12),

('EMP004', 'Sana', 'Javed', 'Sana Javed', 'FEMALE', '1995-08-18', 'SINGLE', '2022-09-20', '2023-03-20',
 '03006789012', '03009871234', '0425678901', 'sana.jpg', 'Marketing Executive', 'sana.javed@example.com', TRUE,
 1, NOW(), 1, NOW(), 11),

('EMP005', 'Hamza', 'Shah', 'Hamza Shah', 'MALE', '1985-12-10', 'MARRIED', '2020-05-05', '2020-11-05',
 '03003456789', '03007654321', '0426789012', 'hamza.jpg', 'Finance Manager', 'hamza.shah@example.com', TRUE, 1,
 NOW(), 1, NOW(), 12),

('EMP006', 'Sara', 'Malik', 'Sara Malik', 'FEMALE', '1991-07-22', 'SINGLE', '2021-02-15', '2021-08-15',
 '03001112233', '03004445566', '0421122334', 'sara.jpg', 'Software Tester', 'sara.malik@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

('EMP007', 'Bilal', 'Ahmed', 'Bilal Ahmed', 'MALE', '1989-09-09', 'MARRIED', '2020-03-10', '2020-09-10',
 '03002223344', '03005556677', '0422233445', 'bilal.jpg', 'Project Manager', 'bilal.ahmed@example.com', TRUE, 1,
 NOW(), 1, NOW(), 26),

('EMP008', 'Hina', 'Saeed', 'Hina Saeed', 'FEMALE', '1993-04-14', 'SINGLE', '2022-05-05', '2022-11-05',
 '03003334455', '03006667788', '0423344556', 'hina.jpg', 'Business Analyst', 'hina.saeed@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP009', 'Omar', 'Farooq', 'Omar Farooq', 'MALE', '1990-12-01', 'MARRIED', '2021-01-20', '2021-07-20',
 '03004445566', '03007778899', '0424455667', 'omar.jpg', 'UI/UX Designer', 'omar.farooq@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP010', 'Maria', 'Bashir', 'Maria Bashir', 'FEMALE', '1994-06-30', 'SINGLE', '2022-03-15', '2022-09-15',
 '03005556677', '03008889900', '0425566778', 'maria.jpg', 'Content Writer', 'maria.bashir@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP011', 'Zain', 'Iqbal', 'Zain Iqbal', 'MALE', '1987-11-11', 'MARRIED', '2020-08-01', '2021-02-01',
 '03006667788', '03009990011', '0426677889', 'zain.jpg', 'Operations Manager', 'zain.iqbal@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP012', 'Amina', 'Khalid', 'Amina Khalid', 'FEMALE', '1992-01-25', 'SINGLE', '2021-12-05', '2022-06-05',
 '03007778899', '03001110022', '0427788990', 'amina.jpg', 'Graphic Designer', 'amina.khalid@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP013', 'Naveed', 'Hussain', 'Naveed Hussain', 'MALE', '1986-05-18', 'MARRIED', '2019-09-15', '2020-03-15',
 '03008889900', '03002220033', '0428899001', 'naveed.jpg', 'Database Admin', 'naveed.hussain@example.com', TRUE, 1,
 NOW(), 1, NOW(), 12),

('EMP014', 'Fatima', 'Rashid', 'Fatima Rashid', 'FEMALE', '1995-10-12', 'SINGLE', '2022-11-10', '2023-05-10',
 '03009990011', '03003331122', '0429900112', 'fatima.jpg', 'Digital Marketer', 'fatima.rashid@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP015', 'Adnan', 'Qureshi', 'Adnan Qureshi', 'MALE', '1988-02-28', 'MARRIED', '2020-06-20', '2020-12-20',
 '03001112234', '03004445567', '0421011123', 'adnan.jpg', 'DevOps Engineer', 'adnan.qureshi@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

('EMP016', 'Iqra', 'Naz', 'Iqra Naz', 'FEMALE', '1993-09-19', 'SINGLE', '2021-07-25', '2022-01-25',
 '03002223345', '03005556678', '0422122234', 'iqra.jpg', 'SEO Specialist', 'iqra.naz@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

('EMP017', 'Fahad', 'Jamil', 'Fahad Jamil', 'MALE', '1990-08-08', 'SINGLE', '2022-02-10', '2022-08-10',
 '03003334456', '03006667789', '0423233345', 'fahad.jpg', 'Network Engineer', 'fahad.jamil@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

('EMP018', 'Noor', 'Aziz', 'Noor Aziz', 'FEMALE', '1991-03-05', 'SINGLE', '2021-09-15', '2022-03-15',
 '03004445567', '03007778890', '0424344456', 'noor.jpg', 'Customer Support', 'noor.aziz@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

('EMP019', 'Tariq', 'Shafiq', 'Tariq Shafiq', 'MALE', '1989-12-22', 'MARRIED', '2020-11-01', '2021-05-01',
 '03005556678', '03008889901', '0425455567', 'tariq.jpg', 'IT Support', 'tariq.shafiq@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

('EMP020', 'Zoya', 'Irfan', 'Zoya Irfan', 'FEMALE', '1994-07-17', 'SINGLE', '2022-04-01', '2022-10-01',
 '03006667789', '03009990012', '0426566678', 'zoya.jpg', 'Front-end Developer', 'zoya.irfan@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

('EMP021', 'Usman', 'Fahim', 'Usman Fahim', 'MALE', '1987-10-30', 'MARRIED', '2019-08-10', '2020-02-10',
 '03007778890', '03001110023', '0427677789', 'usman.jpg', 'Back-end Developer', 'usman.fahim@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

('EMP022', 'Mahnoor', 'Aslam', 'Mahnoor Aslam', 'FEMALE', '1992-05-27', 'SINGLE', '2021-05-20', '2021-11-20',
 '03008889901', '03002220034', '0428788990', 'mahnoor.jpg', 'QA Analyst', 'mahnoor.aslam@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

('EMP023', 'Rashid', 'Babar', 'Rashid Babar', 'MALE', '1985-09-14', 'MARRIED', '2019-12-15', '2020-06-15',
 '03009990012', '03003331123', '0429899001', 'rashid.jpg', 'Security Officer', 'rashid.babar@example.com', TRUE, 1,
 NOW(), 1, NOW(), 19),

('EMP024', 'Hira', 'Shamim', 'Hira Shamim', 'FEMALE', '1993-01-10', 'SINGLE', '2021-10-05', '2022-04-05',
 '03001110024', '03004445568', '0421011124', 'hira.jpg', 'Receptionist', 'hira.shamim@example.com', TRUE, 1,
 NOW(), 1, NOW(), 13),

('EMP025', 'Kamran', 'Latif', 'Kamran Latif', 'MALE', '1988-06-06', 'MARRIED', '2020-02-10', '2020-08-10',
 '03002220035', '03005556679', '0422122235', 'kamran.jpg', 'HR Executive', 'kamran.latif@example.com', TRUE, 1,
 NOW(), 1, NOW(), 14),

('EMP026', 'Sadia', 'Naeem', 'Sadia Naeem', 'FEMALE', '1995-11-20', 'SINGLE', '2022-06-10', '2022-12-10',
 '03003331125', '03006667790', '0423233346', 'sadia.jpg', 'Software Developer', 'sadia.naeem@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1);

INSERT INTO departments (department_code, department_name, description, parent_id, head_employee_id, active)
VALUES
-- Top-level school departments
('SCH01', 'School of Science', 'All science-related departments', NULL, 1, TRUE),
('SCH02', 'School of Arts', 'All arts-related departments', NULL, 2, TRUE),
('SCH03', 'School of Commerce', 'All commerce-related departments', NULL, 3, TRUE),

-- Science Faculty (use existing employee IDs as heads)
('SCI01', 'Department of Physics', 'Physics department', 1, 4, TRUE),
('SCI02', 'Department of Chemistry', 'Chemistry department', 1, 5, TRUE),
('SCI03', 'Department of Biology', 'Biology department', 1, 1, TRUE),  -- cycle back to employee 1
-- Arts Faculty
('ART01', 'Department of History', 'History department', 2, 2, TRUE),
('ART02', 'Department of Literature', 'Literature department', 2, 3, TRUE),
('ART03', 'Department of Fine Arts', 'Fine Arts department', 2, 4, TRUE),
-- Commerce Faculty
('COM01', 'Department of Accounting', 'Accounting department', 3, 5, TRUE),
('COM02', 'Department of Business Administration', 'Business Admin dept', 3, 1, TRUE),
('COM03', 'Department of Economics', 'Economics department', 3, 2, TRUE);






INSERT INTO designations
(designation_code, designation_name, description, department_id, employee_type_id, active)
VALUES
-- School level roles (Management)
('DES001', 'Principal', 'Head of the school', NULL, 3, TRUE),
('DES002', 'Vice Principal', 'Assistant head of school', NULL, 3, TRUE),
('DES003', 'School Accountant', 'Handles school financials', 3, 2, TRUE),

-- Science Faculty roles (Teachers)
('DES004', 'Senior Physics Teacher', 'Experienced physics teacher', 4, 1, TRUE),
('DES005', 'Junior Physics Teacher', 'Junior-level physics teacher', 4, 1, TRUE),
('DES006', 'Senior Chemistry Teacher', 'Experienced chemistry teacher', 5, 1, TRUE),
('DES007', 'Junior Chemistry Teacher', 'Junior-level chemistry teacher', 5, 1, TRUE),
('DES008', 'Senior Biology Teacher', 'Experienced biology teacher', 6, 1, TRUE),
('DES009', 'Junior Biology Teacher', 'Junior-level biology teacher', 6, 1, TRUE),

-- Arts Faculty roles (Teachers)
('DES010', 'History Teacher', 'Teaches history', 2, 1, TRUE),
('DES011', 'Literature Teacher', 'Teaches literature', 2, 1, TRUE),
('DES012', 'Fine Arts Teacher', 'Teaches arts', 2, 1, TRUE),

-- Commerce Faculty roles (Teachers)
('DES013', 'Accounting Teacher', 'Teaches accounting', 3, 1, TRUE),
('DES014', 'Business Administration Teacher', 'Teaches business administration', 3, 1, TRUE),
('DES015', 'Economics Teacher', 'Teaches economics', 3, 1, TRUE);


-- =====================================
-- 1️⃣ Salary Structures
-- =====================================
INSERT INTO salary_structure
(employee_type_id, base_salary, effective_from, effective_to, deleted, created_at, created_by)
VALUES
(1, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Teacher
(2, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Head of Department
(3, 120000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Principal
(4, 100000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Vice Principal
(5, 40000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Lab Instructor
(6, 55000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Special Education Teacher
(7, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Sports Coach
(8, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Music Teacher
(9, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Art Teacher
(10, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Librarian
(11, 60000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Administrator
(12, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Accountant
(13, 35000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Receptionist
(14, 65000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- HR Officer
(15, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Clerk
(16, 60000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- IT Support
(17, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Counselor
(18, 40000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Nurse
(19, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Security Guard
(20, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Driver
(21, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Janitor
(22, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Cafeteria Staff
(23, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Bus Attendant
(24, 150000, '2025-01-01', NULL, FALSE, NOW(), 101), -- School Board Member
(25, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- School Coordinator
(26, 80000, '2025-01-01', NULL, FALSE, NOW(), 101);  -- Project Manager

-- =====================================
-- 2️⃣ Salary Components
-- =====================================
-- Earnings
INSERT INTO salary_component (name, type, is_percentage) VALUES
('House Rent Allowance (HRA)', 'EARNING', TRUE),
('Dearness Allowance (DA)', 'EARNING', TRUE),
('Conveyance Allowance', 'EARNING', FALSE),
('Medical Allowance', 'EARNING', FALSE),
('Special Allowance', 'EARNING', TRUE),
('Performance Bonus', 'EARNING', FALSE),
('Travel Allowance', 'EARNING', FALSE),
('Education Allowance', 'EARNING', FALSE),
('Meal / Food Allowance', 'EARNING', FALSE),
('Overtime Pay', 'EARNING', FALSE),
('Telephone / Internet Allowance', 'EARNING', FALSE),
('Leave Encashment', 'EARNING', FALSE),
('Festival / Annual Bonus', 'EARNING', FALSE),
('Project / Incentive Bonus', 'EARNING', FALSE);

-- Deductions
INSERT INTO salary_component (name, type, is_percentage) VALUES
('Provident Fund (PF)', 'DEDUCTION', TRUE),
('Employee State Insurance (ESI)', 'DEDUCTION', TRUE),
('Professional Tax (PT)', 'DEDUCTION', FALSE),
('Income Tax / TDS', 'DEDUCTION', TRUE),
('Loan Deduction', 'DEDUCTION', FALSE),
('Salary Advance Deduction', 'DEDUCTION', FALSE),
('Absence / Leave Deduction', 'DEDUCTION', FALSE),
('Insurance Premium Deduction', 'DEDUCTION', FALSE),
('Union Fees / Membership', 'DEDUCTION', FALSE),
('Other Voluntary Deductions', 'DEDUCTION', FALSE);


-- =====================================
-- Salary Structure Components
-- =====================================
-- For Teacher (salary_structure_id = 1)
INSERT INTO salary_structure_component
(salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 1, 20, NOW(), 101),    -- HRA 20%
(1, 2, 10, NOW(), 101),    -- DA 10%
(1, 3, 5000, NOW(), 101),  -- Conveyance fixed
(1, 4, 3000, NOW(), 101),  -- Medical fixed
(1, 14, 5, NOW(), 101),    -- Project Bonus 5%
(1, 15, 10, NOW(), 101),   -- PF deduction 10%
(1, 16, 5, NOW(), 101);    -- Tax deduction 5%

-- For Head of Department (salary_structure_id = 2)
INSERT INTO salary_structure_component
(salary_structure_id, component_id, value, created_at, created_by)
VALUES
(2, 1, 25, NOW(), 101),    -- HRA 25%
(2, 2, 12, NOW(), 101),    -- DA 12%
(2, 3, 6000, NOW(), 101),  -- Conveyance fixed
(2, 4, 4000, NOW(), 101),  -- Medical fixed
(2, 5, 7, NOW(), 101),     -- Special Allowance 7%
(2, 15, 10, NOW(), 101),   -- PF deduction 10%
(2, 16, 5, NOW(), 101);    -- Tax deduction 5%

-- For Principal (salary_structure_id = 3)
INSERT INTO salary_structure_component
(salary_structure_id, component_id, value, created_at, created_by)
VALUES
(3, 1, 30, NOW(), 101),    -- HRA 30%
(3, 2, 15, NOW(), 101),    -- DA 15%
(3, 3, 7000, NOW(), 101),  -- Conveyance fixed
(3, 4, 5000, NOW(), 101),  -- Medical fixed
(3, 5, 10, NOW(), 101),    -- Special Allowance 10%
(3, 15, 12, NOW(), 101),   -- PF deduction 12%
(3, 16, 8, NOW(), 101);    -- Tax deduction 8%

-- For Vice Principal (salary_structure_id = 4)
INSERT INTO salary_structure_component
(salary_structure_id, component_id, value, created_at, created_by)
VALUES
(4, 1, 28, NOW(), 101),
(4, 2, 13, NOW(), 101),
(4, 3, 6500, NOW(), 101),
(4, 4, 4500, NOW(), 101),
(4, 5, 8, NOW(), 101),
(4, 15, 11, NOW(), 101),
(4, 16, 6, NOW(), 101);


-- =====================================
-- 4️⃣ Employee Salary (calculated realistically)
-- =====================================
INSERT INTO employee_salary (employee_id, salary_structure_id, gross_salary, total_deductions, net_salary, effective_date, deleted, created_at, created_by) VALUES
(1, 1, 71000, 13100, 57900, '2025-12-01', FALSE, NOW(), 101),
(2, 2, 106500, 19050, 87450, '2025-12-01', FALSE, NOW(), 101),
(3, 3, 194000, 33800, 160200, '2025-12-01', FALSE, NOW(), 101),
(4, 4, 148500, 24000, 124500, '2025-12-01', FALSE, NOW(), 101),
(5, 5, 48000, 9000, 39000, '2025-12-01', FALSE, NOW(), 101),
(6, 6, 68000, 12000, 56000, '2025-12-01', FALSE, NOW(), 101),
(7, 7, 51000, 8500, 42500, '2025-12-01', FALSE, NOW(), 101),
(8, 8, 53000, 8800, 44200, '2025-12-01', FALSE, NOW(), 101),
(9, 9, 52000, 8600, 43400, '2025-12-01', FALSE, NOW(), 101),
(10, 10, 70500, 13000, 57500, '2025-12-01', FALSE, NOW(), 101),
(11, 11, 90000, 17500, 72500, '2025-12-01', FALSE, NOW(), 101),
(12, 12, 105000, 20000, 85000, '2025-12-01', FALSE, NOW(), 101),
(13, 13, 42000, 7500, 34500, '2025-12-01', FALSE, NOW(), 101),
(14, 14, 86000, 16000, 70000, '2025-12-01', FALSE, NOW(), 101),
(15, 15, 35000, 6000, 29000, '2025-12-01', FALSE, NOW(), 101),
(16, 16, 88000, 17000, 71000, '2025-12-01', FALSE, NOW(), 101),
(17, 17, 71000, 13500, 57500, '2025-12-01', FALSE, NOW(), 101),
(18, 18, 52000, 10000, 42000, '2025-12-01', FALSE, NOW(), 101),
(19, 19, 36000, 6500, 29500, '2025-12-01', FALSE, NOW(), 101),
(20, 20, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(21, 21, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(22, 22, 36000, 7000, 29000, '2025-12-01', FALSE, NOW(), 101),
(23, 23, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(24, 24, 210000, 40000, 170000, '2025-12-01', FALSE, NOW(), 101),
(25, 25, 105000, 20000, 85000, '2025-12-01', FALSE, NOW(), 101),
(26, 26, 120000, 25000, 95000, '2025-12-01', FALSE, NOW(), 101);

-- =====================================
-- 5️⃣ Employee Deductions
-- =====================================
INSERT INTO employee_deduction (employee_id, deduction_type, amount, month, deleted, created_at, created_by) VALUES
(1, 'PF', 6000, '2025-12-01', FALSE, NOW(), 101),
(1, 'Tax', 7100, '2025-12-01', FALSE, NOW(), 101),
(2, 'PF', 8400, '2025-12-01', FALSE, NOW(), 101),
(2, 'Tax', 10650, '2025-12-01', FALSE, NOW(), 101),
(3, 'PF', 14400, '2025-12-01', FALSE, NOW(), 101),
(3, 'Tax', 19400, '2025-12-01', FALSE, NOW(), 101),
(4, 'PF', 12000, '2025-12-01', FALSE, NOW(), 101),
(4, 'Tax', 12000, '2025-12-01', FALSE, NOW(), 101),
-- ...continue for all employees 5-26 similarly...
(26, 'PF', 24000, '2025-12-01', FALSE, NOW(), 101),
(26, 'Tax', 1000, '2025-12-01', FALSE, NOW(), 101);

-- =====================================
-- 6️⃣ Salary Payments
-- =====================================
INSERT INTO salary_payment (employee_salary_id, payment_date, payment_mode, transaction_reference, amount_paid, remarks, deleted, created_at)
VALUES
(1, '2025-12-31', 'BANK_TRANSFER', 'TXN1001', 57900, 'December salary', FALSE, NOW()),
(2, '2025-12-31', 'CHEQUE', 'CHQ1002', 87450, 'December salary', FALSE, NOW()),
(3, '2025-12-31', 'BANK_TRANSFER', 'TXN1003', 160200, 'December salary', FALSE, NOW()),
(4, '2025-12-31', 'BANK_TRANSFER', 'TXN1004', 124500, 'December salary', FALSE, NOW()),
-- ... continue for all employees ...
(26, '2025-12-31', 'BANK_TRANSFER', 'TXN1026', 95000, 'December salary', FALSE, NOW());


INSERT INTO employee_department_history
(employee_id, department_id, start_date, end_date, is_current, deleted, created_at, created_by)
VALUES
-- Employee 1 history
(1, 1, '2023-01-01 09:00:00', '2023-06-30 18:00:00', FALSE, FALSE, '2023-01-01 09:00:00', 1),
(1, 1, '2023-07-01 09:00:00', NULL, TRUE, FALSE, '2023-07-01 09:00:00', 1),

-- Employee 2 history
(2, 3, '2022-03-15 09:00:00', '2023-03-14 18:00:00', FALSE, FALSE, '2022-03-15 09:00:00', 1),
(2, 4, '2023-03-15 09:00:00', NULL, TRUE, FALSE, '2023-03-15 09:00:00', 1),

-- Employee 3 history
(3, 1, '2021-06-01 09:00:00', '2022-06-30 18:00:00', FALSE, FALSE, '2021-06-01 09:00:00', 1),
(3, 2, '2022-07-01 09:00:00', '2023-01-31 18:00:00', FALSE, FALSE, '2022-07-01 09:00:00', 1),
(3, 5, '2023-02-01 09:00:00', NULL, TRUE, FALSE, '2023-02-01 09:00:00', 1),

-- Employee 4 history (single current assignment)
(4, 3, '2024-01-01 09:00:00', NULL, TRUE, FALSE, '2024-01-01 09:00:00', 2),

-- Employee 5 history (no current department)
(5, 4, '2022-01-01 09:00:00', '2022-12-31 18:00:00', FALSE, FALSE, '2022-01-01 09:00:00', 1);




INSERT INTO employee_designation_history
(employee_id, designation_id, department_id, start_date, end_date, is_current, created_at, created_by)
VALUES
-- Employee 1 – Teacher → Senior Biology Teacher
(1, 9, 6, '2022-01-10 09:00:00', '2023-06-30 18:00:00', FALSE, NOW(), 1),
(1, 8, 6, '2023-07-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 2 – Vice Principal
(2, 2, NULL, '2021-06-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 3 – Accountant
(3, 3, 3, '2023-03-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 4 – Junior → Senior Physics Teacher
(4, 5, 4, '2022-09-20 09:00:00', '2024-01-31 18:00:00', FALSE, NOW(), 1),
(4, 4, 4, '2024-02-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 5 – Senior Chemistry Teacher
(5, 6, 5, '2020-05-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 6 – Junior Biology Teacher
(6, 9, 6, '2021-02-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 7 – Project Manager (School Level)
(7, 1, NULL, '2020-03-10 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 8 – Business Administration Teacher
(8, 14, 3, '2022-05-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 9 – Economics Teacher
(9, 15, 3, '2021-01-20 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 10 – Literature Teacher
(10, 11, 2, '2022-03-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 11 – Principal
(11, 1, NULL, '2020-08-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 12 – Fine Arts Teacher
(12, 12, 2, '2021-12-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 13 – Accounting Teacher
(13, 13, 3, '2019-09-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 14 – History Teacher
(14, 10, 2, '2022-11-10 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 15 – Junior → Senior Chemistry Teacher
(15, 7, 5, '2020-06-20 09:00:00', '2022-12-31 18:00:00', FALSE, NOW(), 1),
(15, 6, 5, '2023-01-01 09:00:00', NULL, TRUE, NOW(), 1);
