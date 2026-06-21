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
   (1, 'EMP-MASTER', 'System', 'Admin', 'System Admin', 'MALE', '1980-01-01', 'SINGLE', CURRENT_DATE, '03001234567', 'admin@gmail.com', TRUE, 1);

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

INSERT INTO board_member_roles (organization_id, code, name, created_at, updated_at) VALUES
(1, 'CHAIRMAN', 'Chairman', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CHAIRPERSON', 'Chairperson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PRESIDENT', 'President', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_CHAIRMAN', 'Vice Chairman', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_CHAIRPERSON', 'Vice Chairperson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_PRESIDENT', 'Vice President', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DIRECTOR', 'Board Director', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXECUTIVE_DIRECTOR', 'Executive Director', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'NON_EXECUTIVE_DIRECTOR', 'Non-Executive Director', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'INDEPENDENT_DIRECTOR', 'Independent Director', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ADVISOR', 'Advisor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'TRUSTEE', 'Trustee', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GOVERNOR', 'Governor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'BOARD_MEMBER', 'Board Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SECRETARY', 'Board Secretary', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ASSISTANT_SECRETARY', 'Assistant Secretary', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'TREASURER', 'Treasurer', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ASSISTANT_TREASURER', 'Assistant Treasurer', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CHANCELLOR', 'Chancellor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_CHANCELLOR', 'Vice Chancellor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PRO_CHANCELLOR', 'Pro Chancellor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'RECTOR', 'Rector', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PROVOST', 'Provost', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'AUDIT_COMMITTEE_MEMBER', 'Audit Committee Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FINANCE_COMMITTEE_MEMBER', 'Finance Committee Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ACADEMIC_COMMITTEE_MEMBER', 'Academic Committee Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GOVERNANCE_COMMITTEE_MEMBER', 'Governance Committee Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LEGAL_ADVISOR', 'Legal Advisor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FINANCIAL_ADVISOR', 'Financial Advisor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'STRATEGIC_ADVISOR', 'Strategic Advisor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXTERNAL_MEMBER', 'External Board Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'INTERNAL_MEMBER', 'Internal Board Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PATRON', 'Patron', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FOUNDER', 'Founder', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CO_FOUNDER', 'Co-Founder', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HONORARY_MEMBER', 'Honorary Member', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


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


INSERT INTO admission_type
(id, organization_id, code, name, description, is_active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 1, 'REG', 'Regular Admission', 'Standard admission for new academic session', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(2, 1, 'LAT', 'Lateral Entry', 'Admission granted to students transferring from another institution', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(3, 1, 'TRF', 'Transfer Admission', 'Student migrated from another branch or campus', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(4, 1, 'SCH', 'Scholarship Admission', 'Admission granted under scholarship program', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(5, 1, 'SPC', 'Sports Quota', 'Admission based on sports quota eligibility', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(6, 1, 'MGMT', 'Management Quota', 'Admission under management quota', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(7, 1, 'INT', 'International Student', 'Admission for foreign or overseas students', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(8, 1, 'RADM', 'Re-Admission', 'Student rejoining after leaving previously', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(9, 1, 'COND', 'Conditional Admission', 'Admission granted with pending documents or requirements', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(10, 1, 'WAIT', 'Waiting List Admission', 'Admission offered from waiting list after seat availability', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL);



INSERT INTO guardian_relations
(organization_id, name, code, description, status, is_default, created_at, updated_at)
VALUES

-- 🔹 Core Parents
(1, 'Father', 'FATHER', 'Male parent (biological or legal)', 'ACTIVE', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Mother', 'MOTHER', 'Female parent (biological or legal)', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Primary Guardian
(1, 'Guardian', 'GUARDIAN', 'Primary responsible adult (non-parent)', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Immediate Family
(1, 'Grandparent', 'GRANDPARENT', 'Grandfather or grandmother', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Sibling', 'SIBLING', 'Brother or sister', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Extended Family
(1, 'Uncle/Aunt', 'UNCLE_AUNT', 'Parent’s sibling', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Relative', 'RELATIVE', 'Any other family member', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Legal / Care Types
(1, 'Foster Parent', 'FOSTER_PARENT', 'Temporary guardian assigned legally', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Adoptive Parent', 'ADOPTIVE_PARENT', 'Legally adopted parent', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Legal Guardian', 'LEGAL_GUARDIAN', 'Court-appointed guardian', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Care Providers
(1, 'Caretaker', 'CARETAKER', 'Responsible for daily care', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Nanny', 'NANNY', 'Childcare provider', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Institutional
(1, 'Hostel Authority', 'HOSTEL_AUTHORITY', 'Hostel or boarding authority', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Organization', 'ORGANIZATION', 'Institution acting as guardian', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Financial / Support
(1, 'Sponsor', 'SPONSOR', 'Financial supporter of student', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Emergency / Misc
(1, 'Emergency Contact', 'EMERGENCY_CONTACT', 'Emergency-only contact person', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 🔹 Fallback
(1, 'Other', 'OTHER', 'Other relationship', 'ACTIVE', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO exam_type
(
    organization_id,
    code,
    name,
    description,
    is_active,
    deleted,
    created_at,
    updated_at,
    created_by
)
VALUES

-- Major Exams
(1,'MID','Mid Term Exam','Mid session evaluation',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'FINAL','Final Exam','End term final exam',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'ANNUAL','Annual Exam','Yearly evaluation',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'SUPP','Supplementary Exam','Reattempt failed subjects',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'RET','Retake Exam','Retake full exam',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
-- Special Cases
(1,'ENT','Entrance Exam','Admission test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'MOCK','Mock Exam','Practice exam',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'SCH','Scholarship Exam','Scholarship qualification test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1);








INSERT INTO grade_scales
(organization_id, min_percentage, max_percentage, grade, remarks, created_at, updated_at, created_by)
VALUES
(1, 90.00, 100.00, 'A+', 'Outstanding', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 85.00, 89.99, 'A',  'Excellent', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 80.00, 84.99, 'A-', 'Very Good', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 75.00, 79.99, 'B+', 'Good', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 70.00, 74.99, 'B',  'Above Average', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 65.00, 69.99, 'B-', 'Satisfactory', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 60.00, 64.99, 'C+', 'Acceptable', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 55.00, 59.99, 'C',  'Needs Improvement', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 50.00, 54.99, 'D',  'Pass', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 0.00, 49.99, 'F',  'Fail', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);



-- 1. INSERT SUBJECT GROUPS
INSERT INTO subject_groups (organization_id, code, name, created_at, updated_at)
VALUES
-- Core Academic Streams
(1, 'SCI',  'Science Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ART',  'Arts Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'COM',  'Commerce Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Technology
(1, 'CS',   'Computer Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'IT',   'Information Technology Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'AI',   'Robotics & AI Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Creative Arts
(1, 'FA',   'Fine Arts Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PA',   'Performing Arts Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DES',  'Design & Media Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Physical & Health
(1, 'PE',   'Physical Education Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SP',   'Sports Science Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HLT',  'Health & Wellness Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Moral & Religious
(1, 'REL',  'Religious Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ETH',  'Ethics & Moral Education Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Foundational
(1, 'GEN',  'General Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PRI',  'Primary Education Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ECE',  'Early Childhood Education Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Humanities & Society
(1, 'SOC',  'Social Sciences Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HUM',  'Humanities Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CIV',  'Civics & Global Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Career & Practical
(1, 'BUS',  'Business & Economics Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VOC',  'Vocational Studies Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LIFE', 'Life Skills & Career Guidance Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Languages
(1, 'LANG', 'Languages Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FL',   'Foreign Languages Group', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    is_active = TRUE,
    deleted = FALSE;
