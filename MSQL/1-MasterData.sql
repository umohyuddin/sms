-- ====================================================
-- Country: Pakistan only
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1,'PK','Pakistan','PAK','+92', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL);


INSERT INTO provinces
(country_id, name, code, is_active, created_at, created_by, updated_at)
VALUES
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Punjab', 'PB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Sindh', 'SD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Khyber Pakhtunkhwa', 'KP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Balochistan', 'BL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Gilgit-Baltistan', 'GB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Azad Jammu and Kashmir', 'AJK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Islamabad Capital Territory', 'ICT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);

INSERT INTO cities
(province_id, name, code, is_active, created_at, created_by, updated_at)
VALUES

-- ================= PUNJAB =================
((SELECT id FROM provinces WHERE name='Punjab'), 'Lahore', 'LHR', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Faisalabad', 'FSD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rawalpindi', 'RWP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Multan', 'MUX', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Gujranwala', 'GUJ', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sialkot', 'SKT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Bahawalpur', 'BWP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sargodha', 'SGD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rahim Yar Khan', 'RYK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= SINDH =================
((SELECT id FROM provinces WHERE name='Sindh'), 'Karachi', 'KHI', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Hyderabad', 'HYD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Sukkur', 'SKZ', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Larkana', 'LRK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Nawabshah', 'NWS', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Mirpurkhas', 'MPK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= KP =================
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Peshawar', 'PEW', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Mardan', 'MRD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Abbottabad', 'ABT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Swat', 'SWT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Kohat', 'KHT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= BALOCHISTAN =================
((SELECT id FROM provinces WHERE name='Balochistan'), 'Quetta', 'QTA', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Gwadar', 'GWD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Turbat', 'TBT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Khuzdar', 'KZD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= GILGIT BALTISTAN =================
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Gilgit', 'GIL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Skardu', 'SKD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= AJK =================
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Muzaffarabad', 'MZD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Mirpur', 'MPR', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Kotli', 'KTL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= ISLAMABAD =================
((SELECT id FROM provinces WHERE name='Islamabad Capital Territory'), 'Islamabad', 'ISB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);






INSERT INTO institutes
(id, name, address, contact_number, email, website, tagline, logo_url,
 established_date, country_id, province_id, city_id, created_at, updated_at)
VALUES
(
 1, 'Smart Solutions School','123 Main Street, Lahore','+92-300-1234567','info@smartsolutions.edu','https://www.smartsolutions.edu','Excellence in Education',NULL, '2005-08-15',
 (SELECT id FROM country WHERE iso_code='PAK' LIMIT 1),
 (SELECT id FROM provinces WHERE name = 'Punjab'),
 (SELECT id FROM cities WHERE name = 'Lahore'),
 CURRENT_TIMESTAMP,
 CURRENT_TIMESTAMP
);
   -- ==========================================
   -- MASTER EMPLOYEE DATA (For Admin Profile)
   -- ==========================================
   INSERT INTO employee_master
   (organization_id, employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date, primary_phone, email, active, created_by)
   VALUES
   (1, 'EMP-MASTER', 'System', 'Admin', 'System Admin', 'MALE', '1980-01-01', 'SINGLE', CURRENT_DATE, '03000000000', 'admin@yourdomain.com', TRUE, 1);

-- ==========================================
-- SYSTEM USERS WITH USER TYPE
-- ==========================================
INSERT INTO system_users
(organization_id, username, email, phone, password_hash, employee_id, student_id, is_active, is_verified, created_at, updated_at)
VALUES
-- Default Admin User (Linked to Master Employee)
(1, 'admin.user', 'admin@gmail.com', '03001234567',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 1, NULL, TRUE, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO fee_recurrence_rules(code, name, occurrence_interval, description, is_active, deleted, created_at, created_by, updated_at)
VALUES
('ONE_TIME', 'One Time', 0, 'Fee charged only once (e.g., admission or registration fee)', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MONTHLY', 'Monthly', 1, 'Fee charged every month (common for tuition fees)', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('QUARTERLY', 'Quarterly', 3, 'Fee charged every three months', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('HALF_YEARLY', 'HALF YEARLY', 6, 'Fee charged twice in an academic year',TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ANNUAL', 'Annual', 12, 'Fee charged once per academic year',TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);



INSERT INTO facility_types (code, name, description, is_active, deleted, created_at, created_by, updated_at) VALUES
('LAB', 'Laboratory', 'Science, computer, or language labs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('LIBRARY', 'Library', 'Reading, reference, digital library', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PLAYGROUND', 'Playground', 'Outdoor sports and recreation area', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AUDITORIUM', 'Auditorium', 'Multipurpose hall for events and gatherings', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CAFETERIA', 'Cafeteria', 'Dining area for students and staff', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('HOSTEL', 'Hostel', 'On-campus accommodation for students', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MEDICAL_ROOM', 'Medical Room', 'First-aid and health services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('STAFF_ROOM', 'Staff Room', 'Teachers\' lounge or office area', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('TRANSPORT', 'Transport Facility', 'School buses, vans, or transport services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PRAYER_HALL', 'Prayer Hall', 'For religious activities or meditation', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SPORTS_GROUND', 'Sports Ground', 'Fields or courts for games like cricket, football, etc.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MUSIC_ROOM', 'Music Room', 'For music classes and practice', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ART_ROOM', 'Art Room', 'For painting, crafts, and other creative activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('COMPUTER_ROOM', 'Computer Room', 'Dedicated computer lab for students', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SCIENCE_ROOM', 'Science Lab', 'Physics, Chemistry, or Biology labs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('LANGUAGE_LAB', 'Language Lab', 'For learning foreign languages', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SWIMMING_POOL', 'Swimming Pool', 'Swimming facility', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('GYM', 'Gymnasium', 'Indoor fitness and exercise facility', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PARKING', 'Parking Facility', 'Staff and visitor parking', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MULTIPURPOSE_HALL', 'Multipurpose Hall', 'For indoor activities, events, or assemblies', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);



INSERT INTO currencies (iso_code, name, symbol, is_active, deleted, created_at, created_by, updated_at) VALUES
('PKR', 'Pakistani Rupee', 'PKR', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);

INSERT INTO charge_types
(code, name, description, is_active, deleted, created_at, updated_at)
VALUES
('FIXED',       'Fixed Amount', 'Standard set amount (e.g., tuition, admission)',                                                         TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PERCENTAGE',  'Percentage',   'Fee calculated as a % of another fee or total (e.g., late fine, discount)',                               TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE name=VALUES(name), updated_at=VALUES(updated_at);

-- ====================================================
-- TAX TYPES: Pakistan only
-- ====================================================
INSERT INTO tax_types
(id, code, name, tax_percentage, country_id, is_active, deleted, created_at, created_by, updated_at, updated_by)
VALUES
(1,'PK_GST','Pakistan GST',17.00,1,TRUE,FALSE,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1);



