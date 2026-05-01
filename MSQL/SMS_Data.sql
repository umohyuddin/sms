



INSERT INTO education_boards
(code, name, country_id, description, is_active, is_deleted)
VALUES
-- Federal
('FBISE', 'Federal Board of Intermediate and Secondary Education', 98,
 'Federal education board responsible for SSC and HSSC examinations across Pakistan and overseas.', TRUE, FALSE),

-- Punjab Boards
('BISE_LAHORE', 'Board of Intermediate and Secondary Education Lahore', 98,
 'Provincial examination board for Lahore region.', TRUE, FALSE),

('BISE_FAISALABAD', 'Board of Intermediate and Secondary Education Faisalabad', 98,
 'Provincial examination board for Faisalabad region.', TRUE, FALSE),

('BISE_GUJRANWALA', 'Board of Intermediate and Secondary Education Gujranwala', 98,
 'Provincial examination board for Gujranwala region.', TRUE, FALSE),

('BISE_MULTAN', 'Board of Intermediate and Secondary Education Multan', 98,
 'Provincial examination board for Multan region.', TRUE, FALSE),

('BISE_RAWALPINDI', 'Board of Intermediate and Secondary Education Rawalpindi', 98,
 'Provincial examination board for Rawalpindi region.', TRUE, FALSE),

('BISE_SARGODHA', 'Board of Intermediate and Secondary Education Sargodha', 98,
 'Provincial examination board for Sargodha region.', TRUE, FALSE),

('BISE_BAHWALPUR', 'Board of Intermediate and Secondary Education Bahawalpur', 98,
 'Provincial examination board for Bahawalpur region.', TRUE, FALSE),

('BISE_DG_KHAN', 'Board of Intermediate and Secondary Education Dera Ghazi Khan', 98,
 'Provincial examination board for Dera Ghazi Khan region.', TRUE, FALSE),

('BISE_SAHIWAL', 'Board of Intermediate and Secondary Education Sahiwal', 98,
 'Provincial examination board for Sahiwal region.', TRUE, FALSE),

-- Sindh Boards
('BSEK', 'Board of Secondary Education Karachi', 98,
 'Secondary education examination board for Karachi.', TRUE, FALSE),

('BIEK', 'Board of Intermediate Education Karachi', 98,
 'Intermediate education examination board for Karachi.', TRUE, FALSE),

('BISE_HYDERABAD', 'Board of Intermediate and Secondary Education Hyderabad', 98,
 'Provincial examination board for Hyderabad region.', TRUE, FALSE),

('BISE_SUKKUR', 'Board of Intermediate and Secondary Education Sukkur', 98,
 'Provincial examination board for Sukkur region.', TRUE, FALSE),

('BISE_LARKANA', 'Board of Intermediate and Secondary Education Larkana', 98,
 'Provincial examination board for Larkana region.', TRUE, FALSE),

('BISE_MIRPURKHAS', 'Board of Intermediate and Secondary Education Mirpurkhas', 98,
 'Provincial examination board for Mirpurkhas region.', TRUE, FALSE),

('AKU_EB', 'Aga Khan University Examination Board', 98,
 'Private national examination board recognized across Pakistan.', TRUE, FALSE),

-- Khyber Pakhtunkhwa Boards
('BISE_PESHAWAR', 'Board of Intermediate and Secondary Education Peshawar', 98,
 'Provincial examination board for Peshawar region.', TRUE, FALSE),

('BISE_ABBOTABAD', 'Board of Intermediate and Secondary Education Abbottabad', 98,
 'Provincial examination board for Abbottabad region.', TRUE, FALSE),

('BISE_MARDAN', 'Board of Intermediate and Secondary Education Mardan', 98,
 'Provincial examination board for Mardan region.', TRUE, FALSE),

('BISE_BANNU', 'Board of Intermediate and Secondary Education Bannu', 98,
 'Provincial examination board for Bannu region.', TRUE, FALSE),

('BISE_SWAT', 'Board of Intermediate and Secondary Education Swat', 98,
 'Provincial examination board for Swat region.', TRUE, FALSE),

('BISE_MALAKAND', 'Board of Intermediate and Secondary Education Malakand', 98,
 'Provincial examination board for Malakand region.', TRUE, FALSE),

('BISE_KOHAT', 'Board of Intermediate and Secondary Education Kohat', 98,
 'Provincial examination board for Kohat region.', TRUE, FALSE),

('BISE_DI_KHAN', 'Board of Intermediate and Secondary Education Dera Ismail Khan', 98,
 'Provincial examination board for Dera Ismail Khan region.', TRUE, FALSE),

-- Balochistan Boards
('BISE_QUETTA', 'Board of Intermediate and Secondary Education Quetta', 98,
 'Provincial examination board for Quetta region.', TRUE, FALSE),

('BISE_TURBAT', 'Board of Intermediate and Secondary Education Turbat', 98,
 'Regional examination board for Turbat region.', TRUE, FALSE),

('BISE_ZHOB', 'Board of Intermediate and Secondary Education Zhob', 98,
 'Regional examination board for Zhob region.', TRUE, FALSE),

-- AJK & GB
('BISE_AJK', 'Board of Intermediate and Secondary Education Azad Jammu and Kashmir', 98,
 'Examination board for Azad Jammu and Kashmir.', TRUE, FALSE),

('BISE_GB', 'Board of Intermediate and Secondary Education Gilgit Baltistan', 98,
 'Examination board for Gilgit-Baltistan region.', TRUE, FALSE);


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
INSERT INTO institute_social_links(institute_id, platform, url, is_deleted, created_by)VALUES
(1, 'Facebook',  'https://www.facebook.com/institute1', FALSE, 1),
(1, 'Instagram', 'https://www.instagram.com/institute1', FALSE, 1),
(1, 'LinkedIn',  'https://www.linkedin.com/company/institute1', FALSE, 1),
(1, 'YouTube',   'https://www.youtube.com/@institute1', FALSE, 1),
(1, 'Twitter',   'https://twitter.com/institute1', FALSE, 1);




-- ============================================================
-- Lookup Data: Education Levels
-- ============================================================
INSERT INTO education_levels (code, name, is_active, is_deleted, created_at, created_by) VALUES
('PS', 'Early Childhood / Pre-Primary Education', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('P', 'Primary / Elementary Education', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('M', 'Lower Secondary / Middle Education', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('S', 'Upper Secondary / High School', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('HS', 'Post-Secondary Non-Tertiary', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('UG', 'Short-Cycle Tertiary / Undergraduate', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('PG', 'Bachelor / First Tertiary Degree', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('PG2', 'Master / Second Tertiary Degree', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('PH', 'Doctoral / Third Tertiary Degree', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('VT', 'Vocational / Technical Education', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
('AE', 'Adult / Continuing Education', TRUE, FALSE, CURRENT_TIMESTAMP, 1);


INSERT INTO employee_type
(organization_id, name, description, active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 'Teacher', 'General teaching staff', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Head of Department', 'Leads a specific academic department', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Principal', 'Overall in charge of school administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Vice Principal', 'Assists the principal in administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Lab Instructor', 'Handles lab sessions and practical classes', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Special Education Teacher', 'Works with students requiring special education', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Sports Coach', 'Manages sports and physical activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Music Teacher', 'Handles music and arts subjects', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Art Teacher', 'Handles art-related subjects', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Librarian', 'Manages library operations', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Administrator', 'Handles general administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Accountant', 'Manages accounts, fees, and payroll', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Receptionist', 'First point of contact for visitors and parents', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'HR Officer', 'Handles recruitment, payroll, and employee welfare', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Clerk', 'General office work', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'IT Support', 'Maintains school IT infrastructure', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Counselor', 'Provides student counseling services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Nurse', 'Handles student health needs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Security Guard', 'Maintains school security', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Driver', 'For school transport vehicles', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Janitor', 'Handles cleaning and maintenance', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Cafeteria Staff', 'Manages school cafeteria operations', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Bus Attendant', 'Assists in student transport', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'School Board Member', 'Part of the school board or governing body', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'School Coordinator', 'Coordinates programs and school events', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL),
(1, 'Project Manager', 'Handles special projects and development activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, NULL);


INSERT INTO employee_master
(organization_id, employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date,
 probation_end_date, primary_phone, secondary_phone, work_phone, profile_picture, bio, email, active, created_by,
 created_at, updated_by, updated_at, employee_type_id)
VALUES
(1, 'EMP001', 'Uzair', 'Anwar', 'Uzair Anwar', 'MALE', '1990-05-12', 'SINGLE', '2022-01-10', '2022-07-10',
 '03001234567', '03007654321', '0421234567', 'uzair.jpg', 'Software Engineer', 'uzair.anwar@example.com', TRUE,
 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP002', 'Ayesha', 'Khan', 'Ayesha Khan', 'FEMALE', '1988-11-25', 'MARRIED', '2021-06-15', '2021-12-15',
 '03009876543', '03001239876', '0429876543', 'ayesha.jpg', 'HR Manager', 'ayesha.khan@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 14),

(1, 'EMP003', 'Ali', 'Raza', 'Ali Raza', 'MALE', '1992-03-30', 'SINGLE', '2023-03-01', '2023-09-01',
 '03004567890', NULL, '0424567890', 'ali.jpg', 'Accountant', 'ali.raza@example.com', TRUE, 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 12),

(1, 'EMP004', 'Sana', 'Javed', 'Sana Javed', 'FEMALE', '1995-08-18', 'SINGLE', '2022-09-20', '2023-03-20',
 '03006789012', '03009871234', '0425678901', 'sana.jpg', 'Marketing Executive', 'sana.javed@example.com', TRUE,
 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP005', 'Hamza', 'Shah', 'Hamza Shah', 'MALE', '1985-12-10', 'MARRIED', '2020-05-05', '2020-11-05',
 '03003456789', '03007654321', '0426789012', 'hamza.jpg', 'Finance Manager', 'hamza.shah@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 12),

(1, 'EMP006', 'Sara', 'Malik', 'Sara Malik', 'FEMALE', '1991-07-22', 'SINGLE', '2021-02-15', '2021-08-15',
 '03001112233', '03004445566', '0421122334', 'sara.jpg', 'Software Tester', 'sara.malik@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1),

(1, 'EMP007', 'Bilal', 'Ahmed', 'Bilal Ahmed', 'MALE', '1989-09-09', 'MARRIED', '2020-03-10', '2020-09-10',
 '03002223344', '03005556677', '0422233445', 'bilal.jpg', 'Project Manager', 'bilal.ahmed@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 26),

(1, 'EMP008', 'Hina', 'Saeed', 'Hina Saeed', 'FEMALE', '1993-04-14', 'SINGLE', '2022-05-05', '2022-11-05',
 '03003334455', '03006667788', '0423344556', 'hina.jpg', 'Business Analyst', 'hina.saeed@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP009', 'Omar', 'Farooq', 'Omar Farooq', 'MALE', '1990-12-01', 'MARRIED', '2021-01-20', '2021-07-20',
 '03004445566', '03007778899', '0424455667', 'omar.jpg', 'UI/UX Designer', 'omar.farooq@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP010', 'Maria', 'Bashir', 'Maria Bashir', 'FEMALE', '1994-06-30', 'SINGLE', '2022-03-15', '2022-09-15',
 '03005556677', '03008889900', '0425566778', 'maria.jpg', 'Content Writer', 'maria.bashir@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP011', 'Zain', 'Iqbal', 'Zain Iqbal', 'MALE', '1987-11-11', 'MARRIED', '2020-08-01', '2021-02-01',
 '03006667788', '03009990011', '0426677889', 'zain.jpg', 'Operations Manager', 'zain.iqbal@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP012', 'Amina', 'Khalid', 'Amina Khalid', 'FEMALE', '1992-01-25', 'SINGLE', '2021-12-05', '2022-06-05',
 '03007778899', '03001110022', '0427788990', 'amina.jpg', 'Graphic Designer', 'amina.khalid@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP013', 'Naveed', 'Hussain', 'Naveed Hussain', 'MALE', '1986-05-18', 'MARRIED', '2019-09-15', '2020-03-15',
 '03008889900', '03002220033', '0428899001', 'naveed.jpg', 'Database Admin', 'naveed.hussain@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 12),

(1, 'EMP014', 'Fatima', 'Rashid', 'Fatima Rashid', 'FEMALE', '1995-10-12', 'SINGLE', '2022-11-10', '2023-05-10',
 '03009990011', '03003331122', '0429900112', 'fatima.jpg', 'Digital Marketer', 'fatima.rashid@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP015', 'Adnan', 'Qureshi', 'Adnan Qureshi', 'MALE', '1988-02-28', 'MARRIED', '2020-06-20', '2020-12-20',
 '03001112234', '03004445567', '0421011123', 'adnan.jpg', 'DevOps Engineer', 'adnan.qureshi@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1),

(1, 'EMP016', 'Iqra', 'Naz', 'Iqra Naz', 'FEMALE', '1993-09-19', 'SINGLE', '2021-07-25', '2022-01-25',
 '03002223345', '03005556678', '0422122234', 'iqra.jpg', 'SEO Specialist', 'iqra.naz@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 11),

(1, 'EMP017', 'Fahad', 'Jamil', 'Fahad Jamil', 'MALE', '1990-08-08', 'SINGLE', '2022-02-10', '2022-08-10',
 '03003334456', '03006667789', '0423233345', 'fahad.jpg', 'Network Engineer', 'fahad.jamil@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 16),

(1, 'EMP018', 'Noor', 'Aziz', 'Noor Aziz', 'FEMALE', '1991-03-05', 'SINGLE', '2021-09-15', '2022-03-15',
 '03004445567', '03007778890', '0424344456', 'noor.jpg', 'Customer Support', 'noor.aziz@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 16),

(1, 'EMP019', 'Tariq', 'Shafiq', 'Tariq Shafiq', 'MALE', '1989-12-22', 'MARRIED', '2020-11-01', '2021-05-01',
 '03005556678', '03008889901', '0425455567', 'tariq.jpg', 'IT Support', 'tariq.shafiq@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 16),

(1, 'EMP020', 'Zoya', 'Irfan', 'Zoya Irfan', 'FEMALE', '1994-07-17', 'SINGLE', '2022-04-01', '2022-10-01',
 '03006667789', '03009990012', '0426566678', 'zoya.jpg', 'Front-end Developer', 'zoya.irfan@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1),

(1, 'EMP021', 'Usman', 'Fahim', 'Usman Fahim', 'MALE', '1987-10-30', 'MARRIED', '2019-08-10', '2020-02-10',
 '03007778890', '03001110023', '0427677789', 'usman.jpg', 'Back-end Developer', 'usman.fahim@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1),

(1, 'EMP022', 'Mahnoor', 'Aslam', 'Mahnoor Aslam', 'FEMALE', '1992-05-27', 'SINGLE', '2021-05-20', '2021-11-20',
 '03008889901', '03002220034', '0428788990', 'mahnoor.jpg', 'QA Analyst', 'mahnoor.aslam@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1),

(1, 'EMP023', 'Rashid', 'Babar', 'Rashid Babar', 'MALE', '1985-09-14', 'MARRIED', '2019-12-15', '2020-06-15',
 '03009990012', '03003331123', '0429899001', 'rashid.jpg', 'Security Officer', 'rashid.babar@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 19),

(1, 'EMP024', 'Hira', 'Shamim', 'Hira Shamim', 'FEMALE', '1993-01-10', 'SINGLE', '2021-10-05', '2022-04-05',
 '03001110024', '03004445568', '0421011124', 'hira.jpg', 'Receptionist', 'hira.shamim@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 13),

(1, 'EMP025', 'Kamran', 'Latif', 'Kamran Latif', 'MALE', '1988-06-06', 'MARRIED', '2020-02-10', '2020-08-10',
 '03002220035', '03005556679', '0422122235', 'kamran.jpg', 'HR Executive', 'kamran.latif@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 14),

(1, 'EMP026', 'Sadia', 'Naeem', 'Sadia Naeem', 'FEMALE', '1995-11-20', 'SINGLE', '2022-06-10', '2022-12-10',
 '03003331125', '03006667790', '0423233346', 'sadia.jpg', 'Software Developer', 'sadia.naeem@example.com', TRUE, 1,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1);

INSERT INTO departments (organization_id, department_code, department_name, description, parent_id, head_employee_id, active)
VALUES
-- Top-level school departments
(1, 'SCH01', 'School of Science', 'All science-related departments', NULL, 1, TRUE),
(1, 'SCH02', 'School of Arts', 'All arts-related departments', NULL, 2, TRUE),
(1, 'SCH03', 'School of Commerce', 'All commerce-related departments', NULL, 3, TRUE),

-- Science Faculty (use existing employee IDs as heads)
(1, 'SCI01', 'Department of Physics', 'Physics department', 1, 4, TRUE),
(1, 'SCI02', 'Department of Chemistry', 'Chemistry department', 1, 5, TRUE),
(1, 'SCI03', 'Department of Biology', 'Biology department', 1, 1, TRUE),  -- cycle back to employee 1
-- Arts Faculty
(1, 'ART01', 'Department of History', 'History department', 2, 2, TRUE),
(1, 'ART02', 'Department of Literature', 'Literature department', 2, 3, TRUE),
(1, 'ART03', 'Department of Fine Arts', 'Fine Arts department', 2, 4, TRUE),
-- Commerce Faculty
(1, 'COM01', 'Department of Accounting', 'Accounting department', 3, 5, TRUE),
(1, 'COM02', 'Department of Business Administration', 'Business Admin dept', 3, 1, TRUE),
(1, 'COM03', 'Department of Economics', 'Economics department', 3, 2, TRUE);






INSERT INTO designations
(organization_id, designation_code, designation_name, description, active)
VALUES
-- School level roles (Management)
(1, 'DES001', 'Principal', 'Head of the school', TRUE),
(1, 'DES002', 'Vice Principal', 'Assistant head of school', TRUE),
(1, 'DES003', 'School Accountant', 'Handles school financials', TRUE),

-- Science Faculty roles (Teachers)
(1, 'DES004', 'Senior Physics Teacher', 'Experienced physics teacher', TRUE),
(1, 'DES005', 'Junior Physics Teacher', 'Junior-level physics teacher', TRUE),
(1, 'DES006', 'Senior Chemistry Teacher', 'Experienced chemistry teacher', TRUE),
(1, 'DES007', 'Junior Chemistry Teacher', 'Junior-level chemistry teacher', TRUE),
(1, 'DES008', 'Senior Biology Teacher', 'Experienced biology teacher', TRUE),
(1, 'DES009', 'Junior Biology Teacher', 'Junior-level biology teacher', TRUE),

-- Arts Faculty roles (Teachers)
(1, 'DES010', 'History Teacher', 'Teaches history', TRUE),
(1, 'DES011', 'Literature Teacher', 'Teaches literature', TRUE),
(1, 'DES012', 'Fine Arts Teacher', 'Teaches arts', TRUE),

-- Commerce Faculty roles (Teachers)
(1, 'DES013', 'Accounting Teacher', 'Teaches accounting', TRUE),
(1, 'DES014', 'Business Administration Teacher', 'Teaches business administration', TRUE),
(1, 'DES015', 'Economics Teacher', 'Teaches economics', TRUE);


-- =====================================
-- 1️⃣ Salary Structures
-- =====================================
INSERT INTO salary_structure
(organization_id, employee_type_id, base_salary, effective_from, effective_to, deleted, created_at, created_by)
VALUES
(1, 1, 50000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Teacher
(1, 2, 70000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Head of Department
(1, 3, 120000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Principal
(1, 4, 100000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Vice Principal
(1, 5, 40000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Lab Instructor
(1, 6, 55000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Special Education Teacher
(1, 7, 45000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Sports Coach
(1, 8, 45000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Music Teacher
(1, 9, 45000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),   -- Art Teacher
(1, 10, 50000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Librarian
(1, 11, 60000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Administrator
(1, 12, 70000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Accountant
(1, 13, 35000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Receptionist
(1, 14, 65000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- HR Officer
(1, 15, 30000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Clerk
(1, 16, 60000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- IT Support
(1, 17, 50000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Counselor
(1, 18, 40000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Nurse
(1, 19, 30000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Security Guard
(1, 20, 25000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Driver
(1, 21, 25000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Janitor
(1, 22, 30000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Cafeteria Staff
(1, 23, 25000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- Bus Attendant
(1, 24, 150000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101), -- School Board Member
(1, 25, 70000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101),  -- School Coordinator
(1, 26, 80000, '2025-01-01', NULL, FALSE, CURRENT_TIMESTAMP, 101);  -- Project Manager

-- =====================================
-- 2️⃣ Salary Components
-- =====================================
-- Earnings
INSERT INTO salary_component (organization_id, name, type, is_percentage) VALUES
(1, 'House Rent Allowance (HRA)', 'EARNING', TRUE),
(1, 'Dearness Allowance (DA)', 'EARNING', TRUE),
(1, 'Conveyance Allowance', 'EARNING', FALSE),
(1, 'Medical Allowance', 'EARNING', FALSE),
(1, 'Special Allowance', 'EARNING', TRUE),
(1, 'Performance Bonus', 'EARNING', FALSE),
(1, 'Travel Allowance', 'EARNING', FALSE),
(1, 'Education Allowance', 'EARNING', FALSE),
(1, 'Meal / Food Allowance', 'EARNING', FALSE),
(1, 'Overtime Pay', 'EARNING', FALSE),
(1, 'Telephone / Internet Allowance', 'EARNING', FALSE),
(1, 'Leave Encashment', 'EARNING', FALSE),
(1, 'Festival / Annual Bonus', 'EARNING', FALSE),
(1, 'Project / Incentive Bonus', 'EARNING', FALSE);

-- Deductions
INSERT INTO salary_component (organization_id, name, type, is_percentage) VALUES
(1, 'Provident Fund (PF)', 'DEDUCTION', TRUE),
(1, 'Employee State Insurance (ESI)', 'DEDUCTION', TRUE),
(1, 'Professional Tax (PT)', 'DEDUCTION', FALSE),
(1, 'Income Tax / TDS', 'DEDUCTION', TRUE),
(1, 'Loan Deduction', 'DEDUCTION', FALSE),
(1, 'Salary Advance Deduction', 'DEDUCTION', FALSE),
(1, 'Absence / Leave Deduction', 'DEDUCTION', FALSE),
(1, 'Insurance Premium Deduction', 'DEDUCTION', FALSE),
(1, 'Union Fees / Membership', 'DEDUCTION', FALSE),
(1, 'Other Voluntary Deductions', 'DEDUCTION', FALSE);


-- =====================================
-- Salary Structure Components
-- =====================================
-- For Teacher (salary_structure_id = 1)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 1, 1, 20, CURRENT_TIMESTAMP, 101),    -- HRA 20%
(1, 1, 2, 10, CURRENT_TIMESTAMP, 101),    -- DA 10%
(1, 1, 3, 5000, CURRENT_TIMESTAMP, 101),  -- Conveyance fixed
(1, 1, 4, 3000, CURRENT_TIMESTAMP, 101),  -- Medical fixed
(1, 1, 14, 5, CURRENT_TIMESTAMP, 101),    -- Project Bonus 5%
(1, 1, 15, 10, CURRENT_TIMESTAMP, 101),   -- PF deduction 10%
(1, 1, 16, 5, CURRENT_TIMESTAMP, 101);    -- Tax deduction 5%

-- For Head of Department (salary_structure_id = 2)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 2, 1, 25, CURRENT_TIMESTAMP, 101),    -- HRA 25%
(1, 2, 2, 12, CURRENT_TIMESTAMP, 101),    -- DA 12%
(1, 2, 3, 6000, CURRENT_TIMESTAMP, 101),  -- Conveyance fixed
(1, 2, 4, 4000, CURRENT_TIMESTAMP, 101),  -- Medical fixed
(1, 2, 5, 7, CURRENT_TIMESTAMP, 101),     -- Special Allowance 7%
(1, 2, 15, 10, CURRENT_TIMESTAMP, 101),   -- PF deduction 10%
(1, 2, 16, 5, CURRENT_TIMESTAMP, 101);    -- Tax deduction 5%

-- For Principal (salary_structure_id = 3)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 3, 1, 30, CURRENT_TIMESTAMP, 101),    -- HRA 30%
(1, 3, 2, 15, CURRENT_TIMESTAMP, 101),    -- DA 15%
(1, 3, 3, 7000, CURRENT_TIMESTAMP, 101),  -- Conveyance fixed
(1, 3, 4, 5000, CURRENT_TIMESTAMP, 101),  -- Medical fixed
(1, 3, 5, 10, CURRENT_TIMESTAMP, 101),    -- Special Allowance 10%
(1, 3, 15, 12, CURRENT_TIMESTAMP, 101),   -- PF deduction 12%
(1, 3, 16, 8, CURRENT_TIMESTAMP, 101);    -- Tax deduction 8%

-- For Vice Principal (salary_structure_id = 4)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 4, 1, 28, CURRENT_TIMESTAMP, 101),
(1, 4, 2, 13, CURRENT_TIMESTAMP, 101),
(1, 4, 3, 6500, CURRENT_TIMESTAMP, 101),
(1, 4, 4, 4500, CURRENT_TIMESTAMP, 101),
(1, 4, 5, 8, CURRENT_TIMESTAMP, 101),
(1, 4, 15, 11, CURRENT_TIMESTAMP, 101),
(1, 4, 16, 6, CURRENT_TIMESTAMP, 101);


-- =====================================
-- 4️⃣ Employee Salary (calculated realistically)
-- =====================================
INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, gross_salary, total_deductions, net_salary, effective_date, deleted, created_at, created_by) VALUES
(1, 1, 1, 71000, 13100, 57900, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 2, 2, 106500, 19050, 87450, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 3, 3, 194000, 33800, 160200, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 4, 4, 148500, 24000, 124500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 5, 5, 48000, 9000, 39000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 6, 6, 68000, 12000, 56000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 7, 7, 51000, 8500, 42500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 8, 8, 53000, 8800, 44200, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 9, 9, 52000, 8600, 43400, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 10, 10, 70500, 13000, 57500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 11, 11, 90000, 17500, 72500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 12, 12, 105000, 20000, 85000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 13, 13, 42000, 7500, 34500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 14, 14, 86000, 16000, 70000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 15, 15, 35000, 6000, 29000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 16, 16, 88000, 17000, 71000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 17, 17, 71000, 13500, 57500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 18, 18, 52000, 10000, 42000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 19, 19, 36000, 6500, 29500, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 20, 20, 30000, 5000, 25000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 21, 21, 30000, 5000, 25000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 22, 22, 36000, 7000, 29000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 23, 23, 30000, 5000, 25000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 24, 24, 210000, 40000, 170000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 25, 25, 105000, 20000, 85000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 26, 26, 120000, 25000, 95000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101);

-- =====================================
-- 5️⃣ Employee Deductions
-- =====================================
INSERT INTO employee_deduction (organization_id, employee_id, deduction_type, amount, month, deleted, created_at, created_by) VALUES
(1, 1, 'PF', 6000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 1, 'Tax', 7100, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 2, 'PF', 8400, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 2, 'Tax', 10650, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 3, 'PF', 14400, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 3, 'Tax', 19400, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 4, 'PF', 12000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 4, 'Tax', 12000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
-- ...continue for all employees 5-26 similarly...
(1, 26, 'PF', 24000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101),
(1, 26, 'Tax', 1000, '2025-12-01', FALSE, CURRENT_TIMESTAMP, 101);

-- =====================================
-- 6️⃣ Salary Payments
-- =====================================
INSERT INTO salary_payment (organization_id, employee_salary_id, payment_date, payment_mode, transaction_reference, amount_paid, remarks, deleted, created_at)
VALUES
(1, 1, '2025-12-31', 'BANK_TRANSFER', 'TXN1001', 57900, 'December salary', FALSE, CURRENT_TIMESTAMP),
(1, 2, '2025-12-31', 'CHEQUE', 'CHQ1002', 87450, 'December salary', FALSE, CURRENT_TIMESTAMP),
(1, 3, '2025-12-31', 'BANK_TRANSFER', 'TXN1003', 160200, 'December salary', FALSE, CURRENT_TIMESTAMP),
(1, 4, '2025-12-31', 'BANK_TRANSFER', 'TXN1004', 124500, 'December salary', FALSE, CURRENT_TIMESTAMP),
-- ... continue for all employees ...
(1, 26, '2025-12-31', 'BANK_TRANSFER', 'TXN1026', 95000, 'December salary', FALSE, CURRENT_TIMESTAMP);


INSERT INTO employee_department_history
(organization_id, employee_id, department_id, start_date, end_date, is_current, deleted, created_at, created_by)
VALUES
-- Employee 1 history
(1, 1, 1, '2023-01-01 09:00:00', '2023-06-30 18:00:00', FALSE, FALSE, '2023-01-01 09:00:00', 1),
(1, 1, 1, '2023-07-01 09:00:00', NULL, TRUE, FALSE, '2023-07-01 09:00:00', 1),

-- Employee 2 history
(1, 2, 3, '2022-03-15 09:00:00', '2023-03-14 18:00:00', FALSE, FALSE, '2022-03-15 09:00:00', 1),
(1, 2, 4, '2023-03-15 09:00:00', NULL, TRUE, FALSE, '2023-03-15 09:00:00', 1),

-- Employee 3 history
(1, 3, 1, '2021-06-01 09:00:00', '2022-06-30 18:00:00', FALSE, FALSE, '2021-06-01 09:00:00', 1),
(1, 3, 2, '2022-07-01 09:00:00', '2023-01-31 18:00:00', FALSE, FALSE, '2022-07-01 09:00:00', 1),
(1, 3, 5, '2023-02-01 09:00:00', NULL, TRUE, FALSE, '2023-02-01 09:00:00', 1),

-- Employee 4 history (single current assignment)
(1, 4, 3, '2024-01-01 09:00:00', NULL, TRUE, FALSE, '2024-01-01 09:00:00', 2),

-- Employee 5 history (no current department)
(1, 5, 4, '2022-01-01 09:00:00', '2022-12-31 18:00:00', FALSE, FALSE, '2022-01-01 09:00:00', 1);




INSERT INTO employee_designation_history
(organization_id, employee_id, designation_id, department_id, start_date, end_date, is_current, created_at, created_by)
VALUES
-- Employee 1 – Teacher → Senior Biology Teacher
(1, 1, 9, 6, '2022-01-10 09:00:00', '2023-06-30 18:00:00', FALSE, CURRENT_TIMESTAMP, 1),
(1, 1, 8, 6, '2023-07-01 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 2 – Vice Principal
(1, 2, 2, NULL, '2021-06-15 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 3 – Accountant
(1, 3, 3, 3, '2023-03-01 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 4 – Junior → Senior Physics Teacher
(1, 4, 5, 4, '2022-09-20 09:00:00', '2024-01-31 18:00:00', FALSE, CURRENT_TIMESTAMP, 1),
(1, 4, 4, 4, '2024-02-01 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 5 – Senior Chemistry Teacher
(1, 5, 6, 5, '2020-05-05 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 6 – Junior Biology Teacher
(1, 6, 9, 6, '2021-02-15 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 7 – Project Manager (School Level)
(1, 7, 1, NULL, '2020-03-10 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 8 – Business Administration Teacher
(1, 8, 14, 3, '2022-05-05 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 9 – Economics Teacher
(1, 9, 15, 3, '2021-01-20 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 10 – Literature Teacher
(1, 10, 11, 2, '2022-03-15 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 11 – Principal
(1, 11, 1, NULL, '2020-08-01 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 12 – Fine Arts Teacher
(1, 12, 12, 2, '2021-12-05 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 13 – Accounting Teacher
(1, 13, 13, 3, '2019-09-15 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 14 – History Teacher
(1, 14, 10, 2, '2022-11-10 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1),

-- Employee 15 – Junior → Senior Chemistry Teacher
(1, 15, 7, 5, '2020-06-20 09:00:00', '2022-12-31 18:00:00', FALSE, CURRENT_TIMESTAMP, 1),
(1, 15, 6, 5, '2023-01-01 09:00:00', NULL, TRUE, CURRENT_TIMESTAMP, 1);
