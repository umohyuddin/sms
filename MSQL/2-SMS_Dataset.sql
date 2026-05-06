SET SQL_SAFE_UPDATES = 0;



INSERT INTO institute_social_links 
(institute_id, platform, url, created_by, updated_by) 
VALUES
(1, 'facebook', 'https://www.facebook.com/smartsolutions.edu', 1, 1),
(1, 'twitter', 'https://twitter.com/smartsolutionsedu', 1, 1),
(1, 'linkedIn', 'https://www.linkedin.com/company/smartsolutions-edu', 1, 1),
(1, 'instagram', 'https://www.instagram.com/smartsolutions.edu', 1, 1),
(1, 'youTube', 'https://www.youtube.com/c/SmartSolutionsEdu', 1, 1);


INSERT INTO institute_facilities 
(institute_id, facility_type_id, description, capacity, created_by) 
VALUES
(1, (SELECT id FROM facility_types WHERE code = 'LAB'), 'Main Science Laboratory', 30, 1),
(1, (SELECT id FROM facility_types WHERE code = 'LIBRARY'), 'Central Library', 50, 1),
(1, (SELECT id FROM facility_types WHERE code = 'COMPUTER_ROOM'), 'Computer Lab 1', 25, 1),
(1, (SELECT id FROM facility_types WHERE code = 'SPORTS_GROUND'), 'Cricket Ground', NULL, 1),
(1, (SELECT id FROM facility_types WHERE code = 'CAFETERIA'), 'Main Cafeteria', 100, 1);


INSERT INTO institute_accreditations 
(institute_id, authority_name, license_number, valid_from, valid_to, created_by) 
VALUES
(1, 'Ministry of Education', 'MOE-PAK-2024-001', '2024-01-01', '2029-12-31', 1),
(1, 'BISE Lahore', 'BISE-LHR-9982', '2023-06-15', '2026-06-14', 1),
(1, 'ISO 9001:2015', 'CERT-9001-SS-2022', '2022-01-01', '2025-12-31', 1);


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


INSERT INTO institute_board_members 
(organization_id, full_name, role_id, email, contact_number, term_start, term_end, created_by) 
VALUES
(1, 'Dr. Ahmed Khan', (SELECT id FROM board_member_roles WHERE code = 'CHAIRMAN' AND organization_id = 1), 'ahmed.khan@example.com', '+92-300-1112223', '2023-01-01', '2026-12-31', 1),
(1, 'Mrs. Saira Ali', (SELECT id FROM board_member_roles WHERE code = 'PRESIDENT' AND organization_id = 1), 'saira.ali@example.com', '+92-300-4445556', '2024-01-01', '2027-12-31', 1),
(1, 'Mr. Rizwan Ahmed', (SELECT id FROM board_member_roles WHERE code = 'SECRETARY' AND organization_id = 1), 'rizwan.ahmed@example.com', '+92-300-7778889', '2023-01-01', '2026-12-31', 1),
(1, 'Ms. Fatima Noor', (SELECT id FROM board_member_roles WHERE code = 'TREASURER' AND organization_id = 1), 'fatima.noor@example.com', '+92-300-9990001', '2024-01-01', '2027-12-31', 1),
(1, 'Mr. Bilal Sheikh', (SELECT id FROM board_member_roles WHERE code = 'DIRECTOR' AND organization_id = 1), 'bilal.sheikh@example.com', '+92-300-2223334', '2023-06-01', '2026-05-31', 1),
(1, 'Prof. Yasmin Shah', (SELECT id FROM board_member_roles WHERE code = 'VICE_CHAIRMAN' AND organization_id = 1), 'yasmin.shah@example.com', '+92-300-3334445', '2023-01-01', '2026-12-31', 1),
(1, 'Mr. Khalid Mansoor', (SELECT id FROM board_member_roles WHERE code = 'ADVISOR' AND organization_id = 1), 'khalid.mansoor@example.com', '+92-300-5556667', '2024-01-01', '2025-12-31', 1),
(1, 'Dr. Zafar Iqbal', (SELECT id FROM board_member_roles WHERE code = 'FOUNDER' AND organization_id = 1), 'zafar.iqbal@example.com', '+92-300-8889990', '2005-08-15', NULL, 1),
(1, 'Ms. Nadia Hasan', (SELECT id FROM board_member_roles WHERE code = 'GOVERNOR' AND organization_id = 1), 'nadia.hasan@example.com', '+92-300-6667778', '2022-01-01', '2025-12-31', 1),
(1, 'Adv. Salman Faris', (SELECT id FROM board_member_roles WHERE code = 'LEGAL_ADVISOR' AND organization_id = 1), 'salman.faris@example.com', '+92-300-1239876', '2023-01-01', '2026-12-31', 1);


INSERT INTO academic_years
(name, code, start_date, end_date, total_months, is_current, status, organization_id, created_at, updated_at)
VALUES
('Academic Year 2025-2026', 'AY2025', '2025-04-01', '2026-03-31', 12, TRUE, 'ACTIVE', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




-- =========================
-- 1. Leadership
-- =========================
INSERT INTO designations (organization_id, designation_code, designation_name, description, active, deleted, created_at, updated_at)
VALUES
(1, 'PRINCIPAL', 'Principal', 'Leads the campus and oversees academic and administrative operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_PRINCIPAL', 'Vice Principal', 'Supports the principal in managing academic and discipline functions', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HEADMASTER', 'Headmaster / Headmistress', 'Senior school authority responsible for overall school management', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CAMPUS_DIRECTOR', 'Campus Director', 'Responsible for strategic and operational management of a campus', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ACADEMIC_DIRECTOR', 'Academic Director', 'Oversees curriculum, teaching quality, and academic planning', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'OPERATIONS_MANAGER', 'Operations Manager', 'Manages day-to-day operational activities of the school', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ADMINISTRATOR', 'Administrator', 'Handles overall administrative control and coordination', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- =========================
-- 2. Teaching Staff
-- =========================
INSERT INTO designations (organization_id, designation_code, designation_name, description, active, deleted, created_at, updated_at) VALUES
(1, 'TEACHER', 'Teacher', 'Delivers subject teaching and manages classroom activities', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SENIOR_TEACHER', 'Senior Teacher', 'Experienced teacher with additional academic responsibilities', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'JUNIOR_TEACHER', 'Junior Teacher', 'Entry-level teacher supporting classroom instruction', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SUBJECT_TEACHER', 'Subject Teacher', 'Specialized teacher for a specific subject area', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'MONTESSORI_TEACHER', 'Montessori Teacher', 'Handles early childhood education using Montessori methods', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'KG_TEACHER', 'Kindergarten Teacher', 'Responsible for foundational early learning education', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ART_TEACHER', 'Art Teacher', 'Teaches drawing, painting, and creative arts', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'MUSIC_TEACHER', 'Music Teacher', 'Teaches music theory and performance skills', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PE_TEACHER', 'Physical Education Teacher', 'Conducts sports and physical fitness training', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ISLAMIC_STUDIES_TEACHER', 'Islamic Studies Teacher', 'Teaches Quran and Islamic education', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LAB_INSTRUCTOR', 'Lab Instructor', 'Supervises lab sessions and practical experiments', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'TEACHING_ASSISTANT', 'Teaching Assistant', 'Supports teachers in classroom activities', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LAB_ASSISTANT', 'Lab Assistant', 'Assists in lab setup and maintenance', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LIBRARIAN', 'Librarian', 'Manages library resources and student access', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ASSISTANT_LIBRARIAN', 'Assistant Librarian', 'Supports library operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ACADEMIC_COORDINATOR', 'Academic Coordinator', 'Coordinates academic schedules and planning', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CURRICULUM_DEVELOPER', 'Curriculum Developer', 'Designs and improves educational curriculum', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'OFFICE_MANAGER', 'Office Manager', 'Manages office operations and documentation', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ADMIN_OFFICER', 'Admin Officer', 'Handles administrative tasks and coordination', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'RECEPTIONIST', 'Receptionist', 'Manages front desk and visitor interactions', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HR_OFFICER', 'HR Officer', 'Manages recruitment and HR operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HR_MANAGER', 'HR Manager', 'Leads HR policies and employee lifecycle', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ACCOUNTS_OFFICER', 'Accounts Officer', 'Maintains financial records and transactions', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FINANCE_MANAGER', 'Finance Manager', 'Handles budgeting and financial planning', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DATA_ENTRY_OPERATOR', 'Data Entry Operator', 'Maintains system data and records', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'RECORD_KEEPER', 'Record Keeper', 'Maintains official documentation and archives', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DRIVER', 'Driver', 'Provides transportation services', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'BUS_ATTENDANT', 'Bus Attendant', 'Ensures student safety during transport', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SECURITY_GUARD', 'Security Guard', 'Ensures campus safety and security', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'WATCHMAN', 'Watchman', 'Monitors premises during off hours', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CLEANER', 'Cleaner', 'Maintains cleanliness of facilities', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'MAINTENANCE_STAFF', 'Maintenance Staff', 'Handles general maintenance tasks', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ELECTRICIAN', 'Electrician', 'Handles electrical systems and repairs', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PLUMBER', 'Plumber', 'Handles plumbing maintenance', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CANTEEN_MANAGER', 'Canteen Manager', 'Manages cafeteria operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'COOK', 'Cook', 'Prepares meals for students and staff', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'KITCHEN_STAFF', 'Kitchen Staff', 'Assists in kitchen operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXAM_CONTROLLER', 'Exam Controller', 'Manages exam planning and execution', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXAM_COORDINATOR', 'Exam Coordinator', 'Coordinates exam schedules', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EVALUATOR', 'Evaluator', 'Checks and grades exam papers', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'INVIGILATOR', 'Invigilator', 'Supervises students during exams', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DISCIPLINE_INCHARGE', 'Discipline Incharge', 'Ensures student discipline and behavior management', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GRADE_COORDINATOR', 'Grade Coordinator', 'Coordinates activities of a specific grade', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SECTION_HEAD', 'Section Head', 'Manages a section or group of classes', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HOD', 'Head of Department', 'Leads a department academically and administratively', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SUBJECT_COORDINATOR', 'Subject Coordinator', 'Coordinates subject curriculum and teachers', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CEO', 'CEO / Founder', 'Top-level executive managing organization strategy', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DIRECTOR_GENERAL', 'Director General', 'Oversees multiple campuses and operations', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CAO', 'CAO / Chief Academic Officer', 'Leads academic strategy across organization', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'COO', 'COO / Chief Operating Officer', 'Handles operations across campuses', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'REGIONAL_MANAGER', 'Regional Manager', 'Manages campuses within a region', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);













INSERT INTO department_types 
(organization_id, code, name, description, created_at, updated_at) VALUES

-- Core Academic
(1, 'ACADEMIC', 'Academic', 'Core teaching and subject-related departments', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Administration
(1, 'ADMIN', 'Administration', 'Administrative and management departments', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Student Support
(1, 'SUPPORT', 'Student Support', 'Departments supporting student services and wellbeing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Operations / Facilities
(1, 'OPERATIONS', 'Operations', 'Campus operations, facilities, and maintenance', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- IT / Technical
(1, 'IT', 'Information Technology', 'IT systems, infrastructure, and technical support', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Finance
(1, 'FINANCE', 'Finance & Accounts', 'Financial operations, accounting, and budgeting', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Human Resources
(1, 'HR', 'Human Resources', 'Employee management, hiring, and HR operations', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Academic Support
(1, 'ACADEMIC_SUPPORT', 'Academic Support', 'Support for teaching, curriculum, and faculty', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Research (important for universities)
(1, 'RESEARCH', 'Research & Development', 'Research activities, labs, and innovation', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Admissions
(1, 'ADMISSIONS', 'Admissions', 'Student admissions and enrollment management', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Examination
(1, 'EXAM', 'Examinations', 'Exams, results, and academic assessments', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Compliance / Quality
(1, 'QUALITY', 'Quality Assurance', 'Accreditation, compliance, and quality control', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Legal
(1, 'LEGAL', 'Legal Affairs', 'Legal operations and compliance', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Marketing / PR
(1, 'MARKETING', 'Marketing & Communications', 'Marketing, branding, and public relations', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Transport
(1, 'TRANSPORT', 'Transport', 'Transport and fleet management', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Hostel / Accommodation
(1, 'HOSTEL', 'Hostel & Accommodation', 'Student housing and accommodation', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Health / Medical
(1, 'MEDICAL', 'Health Services', 'Medical and healthcare services', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Library
(1, 'LIBRARY', 'Library Services', 'Library and knowledge resources', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Security
(1, 'SECURITY', 'Security', 'Campus safety and security management', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Cafeteria
(1, 'FOOD', 'Cafeteria & Food Services', 'Food and cafeteria services', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);






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





-- ============================================================
-- Lookup Data: Languages
-- ============================================================
INSERT INTO languages (iso_code, name, is_active, deleted, created_at, created_by, updated_at) VALUES
('aa', 'Afar', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ab', 'Abkhaz', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('af', 'Afrikaans', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ak', 'Akan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('am', 'Amharic', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('an', 'Aragonese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ar', 'Arabic', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('as', 'Assamese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('av', 'Avaric', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ay', 'Aymara', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('az', 'Azerbaijani', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ba', 'Bashkir', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('be', 'Belarusian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bg', 'Bulgarian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bh', 'Bihari', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bi', 'Bislama', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bn', 'Bengali', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bo', 'Tibetan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('br', 'Breton', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('bs', 'Bosnian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ca', 'Catalan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ch', 'Chamorro', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('co', 'Corsican', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('cs', 'Czech', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('cy', 'Welsh', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('da', 'Danish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('de', 'German', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('dv', 'Divehi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('dz', 'Dzongkha', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('el', 'Greek', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('en', 'English', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('eo', 'Esperanto', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('es', 'Spanish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('et', 'Estonian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('eu', 'Basque', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fa', 'Persian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ff', 'Fulah', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fi', 'Finnish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fj', 'Fijian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fo', 'Faroese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fr', 'French', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('fy', 'Western Frisian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ga', 'Irish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('gd', 'Scottish Gaelic', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('gl', 'Galician', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('gn', 'Guarani', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('gu', 'Gujarati', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('gv', 'Manx', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ha', 'Hausa', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('he', 'Hebrew', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('hi', 'Hindi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ho', 'Hiri Motu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('hr', 'Croatian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ht', 'Haitian Creole', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('hu', 'Hungarian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('hy', 'Armenian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ia', 'Interlingua', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('id', 'Indonesian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ie', 'Interlingue', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ig', 'Igbo', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ii', 'Nuosu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ik', 'Inupiaq', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('io', 'Ido', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('is', 'Icelandic', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('it', 'Italian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('iu', 'Inuktitut', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ja', 'Japanese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('jv', 'Javanese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ka', 'Georgian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kg', 'Kongo', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ki', 'Kikuyu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kk', 'Kazakh', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kl', 'Greenlandic', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('km', 'Central Khmer', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kn', 'Kannada', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ko', 'Korean', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kr', 'Kanuri', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ks', 'Kashmiri', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ku', 'Kurdish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kv', 'Komi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('kw', 'Cornish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ky', 'Kyrgyz', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('la', 'Latin', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('lb', 'Luxembourgish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ln', 'Lingala', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('lo', 'Lao', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('lt', 'Lithuanian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('lv', 'Latvian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mg', 'Malagasy', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mh', 'Marshallese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mi', 'Māori', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mk', 'Macedonian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ml', 'Malayalam', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mn', 'Mongolian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mr', 'Marathi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ms', 'Malay', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('mt', 'Maltese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('my', 'Burmese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('na', 'Nauru', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nb', 'Norwegian Bokmål', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nd', 'North Ndebele', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ne', 'Nepali', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ng', 'Ndonga', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nl', 'Dutch', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nn', 'Norwegian Nynorsk', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('no', 'Norwegian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nr', 'South Ndebele', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('nv', 'Navajo', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ny', 'Chichewa', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('oc', 'Occitan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('oj', 'Ojibwa', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('om', 'Oromo', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('or', 'Oriya', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('os', 'Ossetian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('pa', 'Punjabi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('pi', 'Pāli', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('pl', 'Polish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ps', 'Pashto', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('pt', 'Portuguese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('qu', 'Quechua', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('rm', 'Romansh', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('rn', 'Kirundi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ro', 'Romanian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ru', 'Russian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('rw', 'Kinyarwanda', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sa', 'Sanskrit', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sc', 'Sardinian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sd', 'Sindhi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('se', 'Northern Sami', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sg', 'Sango', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('si', 'Sinhala', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sk', 'Slovak', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sl', 'Slovenian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sm', 'Samoan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sn', 'Shona', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('so', 'Somali', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sq', 'Albanian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sr', 'Serbian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ss', 'Swati', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('st', 'Southern Sotho', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('su', 'Sundanese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sv', 'Swedish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('sw', 'Swahili', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ta', 'Tamil', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('te', 'Telugu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tg', 'Tajik', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('th', 'Thai', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ti', 'Tigrinya', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tk', 'Turkmen', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tl', 'Tagalog', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tn', 'Tswana', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('to', 'Tongan', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tr', 'Turkish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ts', 'Tsonga', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tt', 'Tatar', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('tw', 'Twi', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ty', 'Tahitian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ug', 'Uighur', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('uk', 'Ukrainian', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ur', 'Urdu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('uz', 'Uzbek', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ve', 'Venda', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('vi', 'Vietnamese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('vo', 'Volapük', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('wa', 'Walloon', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('wo', 'Wolof', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('xh', 'Xhosa', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('yi', 'Yiddish', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('yo', 'Yoruba', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('za', 'Zhuang', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('zh', 'Chinese', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('zu', 'Zulu', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);


INSERT INTO actions(code, name, description, is_active, created_by, deleted, created_at, updated_at)
VALUES
-- Core CRUD
('VIEW', 'View', 'Read access to the resource', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CREATE', 'Create', 'Ability to create new records', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('UPDATE', 'Update', 'Ability to modify existing records', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('DELETE', 'Delete', 'Ability to remove records', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Workflow & Utility
('APPROVE', 'Approve', 'Ability to approve workflows', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('EXPORT', 'Export', 'Ability to export data to Excel or PDF', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('IMPORT', 'Import', 'Ability to import data from files', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Management
('ASSIGN', 'Assign', 'Assign roles or resources', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('UNASSIGN', 'Unassign', 'Remove assigned roles or resources', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- System Control
('ACTIVATE', 'Activate', 'Activate a disabled record', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('DEACTIVATE', 'Deactivate', 'Deactivate an active record', TRUE, 1, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- ==========================================
-- MODULES
-- ==========================================
INSERT INTO modules(code,name,description,icon,route,display_order,system_module,active,created_at,created_by,updated_at)
VALUES
-- Identity & Access Management
('DASHBOARD', 'Dashboard', 'System overview and analytics', 'dashboard', '/dashboard', 1, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('IAM', 'Identity & Access', 'Users, roles, permissions & security', 'security', '/iam', 2, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Student Management
('STUDENT', 'Student Management', 'Student profiles, admission & attendance', 'groups', '/students', 3, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Student Fees & Payments
('FEE', 'Fee Management', 'Fee structure, payments & summaries', 'payments', '/fees', 4, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Academic Structure
('ACADEMIC', 'Academic Management', 'Classes, sections, subjects & curriculum', 'school', '/academics', 5, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Assessment & Examination
('EXAM', 'Examinations', 'Assessments, grading & results', 'assignment', '/exams', 6, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Institute Management
('INSTITUTE', 'Institute Management', 'Institute profile, campuses & offerings', 'apartment', '/institute', 7, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Administration & Governance
('ADMINISTRATION', 'Administration & Governance', 'Departments, designations & boards', 'account_balance', '/administration', 8, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Employee & Payroll
('EMPLOYEE', 'Employee Management', 'Employees, salaries & payroll periods', 'badge', '/employees', 9, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Finance & Operations
('FINANCE', 'Finance & Operations', 'Expenses, banks & inventory', 'account_balance_wallet', '/finance', 10, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Discounts & Tax
('PRICING', 'Discounts & Tax', 'Discounts, tax rules & pricing models', 'percent', '/pricing', 11, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Reference / Master Data
('MASTERDATA', 'Master Data', 'Countries, currencies, boards & lookups', 'storage', '/master-data', 12, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- System Configuration
('SETTINGS', 'System Settings', 'Rules, themes & configuration', 'settings', '/settings', 13, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Reporting & Analytics
('REPORTS', 'Reports & Analytics', 'Academic, financial & system reports', 'bar_chart', '/reports', 14, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- Future Modules
('COMMUNICATION', 'Communication', 'SMS, Email, Notifications & Announcements', 'campaign', '/communication', 15, TRUE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('TRANSPORT', 'Transport Management', 'Routes, vehicles & student transport', 'directions_bus', '/transport', 16, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('HOSTEL', 'Hostel Management', 'Rooms, allocations & hostel fees', 'home', '/hostel', 17, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('LIBRARY', 'Library Management', 'Books, members & issue tracking', 'library_books', '/library', 18, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ALUMNI', 'Alumni Management', 'Alumni records & engagement', 'diversity_3', '/alumni', 19, FALSE, TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);

-- ==========================================
-- RESOURCES
-- ==========================================

-- IAM / Security
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='IAM'), 'IAM_AUTH_LOGIN', 'Login', '/sms/auth', 'POST', 'User login', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Users
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_SEARCH', 'Search Users', '/api/v1/users/search', 'GET', 'Search system users', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_ASSIGN_ROLE', 'Assign Roles', '/api/v1/users/{userId}/roles', 'PUT', 'Assign roles to user', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Roles
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_CREATE', 'Create Role', '/api/v1/roles', 'POST', 'Create role', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_VIEW', 'View Roles', '/api/v1/roles/organization/{organizationId}', 'GET', 'List roles', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_UPDATE', 'Update Role', '/api/v1/roles/{id}/organization/{organizationId}', 'PUT', 'Update role', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_DELETE', 'Delete Role', '/api/v1/roles/{id}/organization/{organizationId}', 'DELETE', 'Delete role', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Permissions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_CREATE', 'Create Permission', '/api/v1/permissions', 'POST', 'Create permission', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_VIEW', 'View Permissions', '/api/v1/permissions/organization/{organizationId}', 'GET', 'List permissions', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_UPDATE', 'Update Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'PUT', 'Update permission', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_DELETE', 'Delete Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'DELETE', 'Delete permission', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Role Permission
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_ASSIGN', 'Assign Permission', '/api/role-permissions/assign', 'POST', 'Assign permission to role', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_VIEW', 'View Role Permissions', '/api/role-permissions/role/{roleId}', 'GET', 'View role permissions', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_REMOVE', 'Remove Permission', '/api/role-permissions/role/{roleId}/permission/{permissionId}', 'DELETE', 'Remove permission', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Modules / Resources / Actions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_MODULE_MANAGE', 'Manage Modules', '/api/v1/modules', 'POST', 'Create module', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_RESOURCE_MANAGE', 'Manage Resources', '/api/v1/resources', 'POST', 'Create resource', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ACTION_MANAGE', 'Manage Actions', '/api/v1/actions', 'POST', 'Create action', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- STUDENT Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_CREATE', 'Create Student', '/api/institute/students', 'POST', 'Create student', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW', 'View Students', '/api/institute/students', 'GET', 'List students', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW_DETAIL', 'View Student Detail', '/api/institute/students/{id}', 'GET', 'Student details', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_UPDATE', 'Update Student', '/api/institute/students/{id}', 'PUT', 'Update student', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_SEARCH', 'Search Students', '/api/institute/students/search', 'GET', 'Search students', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DASHBOARD_VIEW', 'Student Dashboard', '/api/institute/students/dashboard', 'GET', 'Student dashboard', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Student Documents
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_UPLOAD', 'Upload Document', '/api/institute/students/upload-document', 'POST', 'Upload document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_VIEW', 'View Documents', '/api/institute/students/{studentId}/documents', 'GET', 'View documents', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_DOWNLOAD', 'Download Document', '/api/institute/students/download-document/{documentId}', 'GET', 'Download document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Attendance
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_MARK', 'Mark Attendance', '/api/student/attendance/create', 'POST', 'Mark attendance', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_VIEW', 'View Attendance', '/api/student/attendance/getbystudent/{id}', 'GET', 'View attendance', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- FEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='FEE'), 'FEE_ASSIGN', 'Assign Fee', '/api/students/{studentId}/fees/assign', 'POST', 'Assign fee', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_UPDATE', 'Update Fee', '/api/students/{studentId}/fees/update', 'PUT', 'Update assigned fee', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_PAYMENT_CREATE', 'Pay Fee', '/api/students/fee/payments', 'POST', 'Fee payment', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_SUMMARY_VIEW', 'Fee Summary', '/api/students/fee/summary', 'GET', 'Fee summary', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ASSIGN', 'Assign Discount', '/api/school/discounts/student', 'POST', 'Assign student discount', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_UPDATE', 'Update Discount', '/api/school/discounts/student/{assignmentId}', 'PUT', 'Update discount', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ACTIVATE', 'Activate Discount', '/api/school/discounts/student/{assignmentId}/activate', 'PATCH', 'Activate discount', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_DEACTIVATE', 'Deactivate Discount', '/api/school/discounts/student/{assignmentId}/deactivate', 'PATCH', 'Deactivate discount', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ACADEMIC Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_CLASS_MANAGE', 'Manage Classes', '/api/classes', 'POST', 'Manage classes', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_STANDARD_MANAGE', 'Manage Standards', '/api/standards', 'POST', 'Manage standards', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SECTION_MANAGE', 'Manage Sections', '/api/sections', 'POST', 'Manage sections', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_ASSIGN', 'Assign Subject', '/api/standard-subjects', 'POST', 'Assign subject', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_TIMETABLE_MANAGE', 'Manage Timetable', '/api/timetable', 'POST', 'Manage timetable', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_YEAR_MANAGE', 'Academic Year', '/api/academic-years', 'POST', 'Manage academic years', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_MANAGE', 'Academic Subjects', '/api/academic-subjects', 'POST', 'Manage subjects', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- EXAM Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_ASSESSMENT_CREATE', 'Create Assessment', '/api/assessments', 'POST', 'Create assessment', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_MCQ_MANAGE', 'Manage MCQs', '/api/mcqs', 'POST', 'Manage MCQs', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_PUBLISH', 'Publish Result', '/api/results', 'POST', 'Publish result', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_VIEW', 'View Results', '/api/results', 'GET', 'View results', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_GRADING_MANAGE', 'Grading System', '/api/marks-grading', 'POST', 'Manage grading system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_FAIL_CRITERIA_MANAGE', 'Fail Criteria', '/api/fail-criteria', 'POST', 'Manage fail criteria', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- INSTITUTE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_PROFILE_UPDATE', 'Update Institute', '/api/institute', 'PUT', 'Update institute', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_UPLOAD', 'Upload Institute Document', '/api/institute/documents', 'POST', 'Upload institute document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_DOWNLOAD', 'Download Institute Document', '/api/institute/documents/{documentId}', 'GET', 'Download institute document', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ADMINISTRATION Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='ADMINISTRATION'), 'ADMIN_CONTACT_MANAGE', 'Institute Contacts', '/api/institute/contacts', 'POST', 'Manage institute contacts', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- EMPLOYEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_CREATE', 'Create Employee', '/api/employees', 'POST', 'Create employee', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_SALARY_PAY', 'Salary Payment', '/api/salaries/pay', 'POST', 'Pay employee salary', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_HISTORY_VIEW', 'Employee History', '/api/employees/history', 'GET', 'View employee history', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- FINANCE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='FINANCE'), 'FINANCE_EXPENSE_CREATE', 'Create Expense', '/api/schools/expenses', 'POST', 'Create expense', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- MASTERDATA Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='MASTERDATA'), 'MASTERDATA_COUNTRY_VIEW', 'View Countries', '/api/countries', 'GET', 'List countries', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- REPORTS Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description, created_at, updated_at)
VALUES
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ATTENDANCE', 'Attendance Report', '/api/attendance/report', 'GET', 'Attendance reports', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_FEE', 'Fee Report', '/api/students/fee/report', 'GET', 'Fee reports', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ACADEMIC', 'Academic Report', '/api/academics/report', 'GET', 'Academic reports', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);





INSERT INTO school_types (code, name, description, is_active, deleted, created_at, updated_at) VALUES
('PUBLIC', 'Public School', 'Funded and operated by the government, free for students.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PRIVATE', 'Private School', 'Privately funded school, requires tuition fees.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CHARTER', 'Charter School', 'Publicly funded independent school with special curriculum.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('TRUST', 'Trust School', 'Managed by charitable trusts or foundations.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('INTERNATIONAL', 'International School', 'Follows international curriculum like IB or Cambridge.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('GOVERNMENT', 'Government School', 'Directly run by local or federal government authorities.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MONTESSORI', 'Montessori School', 'Focuses on child-led learning and early education.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('VOCATIONAL', 'Vocational School', 'Specializes in skill-based education for trades and professions.', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




INSERT INTO roles(organization_id,code,name,description,is_system_role,active,deleted,created_by,created_at,updated_at)
VALUES
(1, 'MASTER_ADMIN', 'Master Administrator', 'Alias of SUPER_ADMIN', TRUE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SUPER_ADMIN', 'Super Administrator', 'Full system access across all modules and organizations',TRUE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ORG_ADMIN', 'Organization Administrator', 'Manages institute-level configuration, campuses, and users',TRUE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
-- ===============================
-- ACADEMIC LEADERSHIP
-- ===============================
(1, 'PRINCIPAL', 'Principal', 'Overall academic and administrative head of the school',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'VICE_PRINCIPAL', 'Vice Principal', 'Assists principal in academic and disciplinary matters',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HEAD_OF_DEPARTMENT', 'Head of Department', 'Manages academic department and teaching staff', FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- TEACHING STAFF
-- ===============================
(1, 'TEACHER', 'Teacher', 'Teaches assigned classes and manages student academics',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CLASS_TEACHER', 'Class Teacher', 'Responsible for a specific class and student coordination',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SUBSTITUTE_TEACHER', 'Substitute Teacher', 'Temporary teacher assigned to cover classes',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- STUDENT & PARENT PORTALS
-- ===============================
(1, 'STUDENT', 'Student', 'Student portal access for academics, attendance, and fees',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PARENT', 'Parent / Guardian', 'Parent portal access to monitor student progress and fees',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- ADMISSIONS & EXAMINATION
-- ===============================
(1, 'ADMISSIONS_OFFICER', 'Admissions Officer', 'Handles student admissions and enrollment process',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXAM_CONTROLLER', 'Examination Controller', 'Manages exams, grading, and result publication',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'EXAMINER', 'Examiner', 'Creates exams and evaluates student performance',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- FINANCE & ACCOUNTS
-- ===============================
(1, 'ACCOUNTANT', 'Accountant', 'Manages fee collection, payments, and accounting reports',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FINANCE_MANAGER', 'Finance Manager', 'Oversees financial operations and approvals',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FEE_COLLECTION_OFFICER', 'Fee Collection Officer', 'Handles daily fee collection and receipts',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- HR & PAYROLL
-- ===============================
(1, 'HR_MANAGER', 'HR Manager', 'Manages employees, payroll, and HR policies',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'HR_OFFICER', 'HR Officer', 'Handles employee records, attendance, and documentation',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PAYROLL_OFFICER', 'Payroll Officer', 'Processes salaries and payroll cycles',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- ===============================
-- IT & SUPPORT
-- ===============================
(1, 'IT_ADMIN', 'IT Administrator', 'Manages system configuration, users, and technical support',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SUPPORT_STAFF', 'Support Staff', 'Limited access for operational and support activities',FALSE, TRUE, FALSE, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);












INSERT INTO employee_type
(organization_id, name, description, active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 'Teacher', 'General teaching staff', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Head of Department', 'Leads a specific academic department', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Principal', 'Overall in charge of school administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Vice Principal', 'Assists the principal in administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Lab Instructor', 'Handles lab sessions and practical classes', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Special Education Teacher', 'Works with students requiring special education', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Sports Coach', 'Manages sports and physical activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Music Teacher', 'Handles music and arts subjects', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Art Teacher', 'Handles art-related subjects', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Librarian', 'Manages library operations', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Administrator', 'Handles general administration', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Accountant', 'Manages accounts, fees, and payroll', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Receptionist', 'First point of contact for visitors and parents', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'HR Officer', 'Handles recruitment, payroll, and employee welfare', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Clerk', 'General office work', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'IT Support', 'Maintains school IT infrastructure', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Counselor', 'Provides student counseling services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Nurse', 'Handles student health needs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Security Guard', 'Maintains school security', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Driver', 'For school transport vehicles', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Janitor', 'Handles cleaning and maintenance', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Cafeteria Staff', 'Manages school cafeteria operations', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Bus Attendant', 'Assists in student transport', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'School Board Member', 'Part of the school board or governing body', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'School Coordinator', 'Coordinates programs and school events', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(1, 'Project Manager', 'Handles special projects and development activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL);



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

-- 2. INSERT SUBJECTS
-- Note: subject_group_id is fetched dynamically to ensure correctness regardless of ID generation.
-- Defaulting is_core = TRUE as per user data.

INSERT INTO subjects (organization_id, code, name, subject_group_id, is_core, created_at, updated_at)
VALUES
-- Science Group
(1, 'PHY',     'Physics',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CHEM',    'Chemistry',             (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'BIO',     'Biology',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GEN_SCI', 'General Science',       (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ENV_SCI', 'Environmental Science', (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Arts Group
(1, 'HIST',    'History',               (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GEO',     'Geography',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PSY',     'Psychology',            (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'SOCIO',   'Sociology',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Commerce Group
(1, 'ACC',     'Accounting',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ECO',     'Economics',             (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'BST',     'Business Studies',      (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'STAT',    'Statistics',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Computer Studies Group
(1, 'CS_FUND', 'Computer Fundamentals', (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PROG',    'Programming',           (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DS',      'Data Structures',       (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Information Technology Group
(1, 'IT_BASIC', 'Information Technology', (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'NET',      'Networking Basics',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DB',       'Database Concepts',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Robotics & AI Group
(1, 'AI_INTRO', 'Introduction to AI',     (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ROBO',     'Robotics',               (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Fine Arts Group
(1, 'DRAW',   'Drawing',               (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PAINT',  'Painting',              (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CRAFT',  'Craft & Design',        (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Performing Arts Group
(1, 'MUSIC',  'Music',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DRAMA',  'Drama',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DANCE',  'Dance',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Design & Media Studies Group
(1, 'GD',     'Graphic Design',        (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'MEDIA',  'Media Studies',         (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'PHOTO',  'Photography',           (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Physical Education Group
(1, 'PE',     'Physical Education',    (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'YOGA',    'Yoga',                  (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Sports Science Group
(1, 'SPORT_SCI', 'Sports Science',     (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FIT',       'Fitness Training',   (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Health & Wellness Group
(1, 'HEALTH', 'Health Education',      (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'NUT',    'Nutrition',             (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Religious Studies Group
(1, 'ISL',     'Islamic Studies',      (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'REL_GEN', 'Comparative Religion', (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Ethics & Moral Education Group
(1, 'ETHICS', 'Ethics',                (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'MORAL',  'Moral Education',       (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- General Studies Group
(1, 'GK',     'General Knowledge',     (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GS',     'General Studies',       (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Primary Education Group
(1, 'BASIC_MATH', 'Basic Mathematics', (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'BASIC_LANG', 'Basic Language',    (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Early Childhood Education Group
(1, 'PLAY',       'Play & Learning',   (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DRAW_BASIC', 'Basic Drawing',     (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Social Sciences Group
(1, 'POL',    'Political Science',     (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ANTH',   'Anthropology',          (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Humanities Group
(1, 'PHIL',   'Philosophy',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'LIT',    'Literature',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Civics & Global Studies Group
(1, 'CIVICS', 'Civics',                (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GLOBAL', 'Global Studies',        (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Business & Economics Group
(1, 'ENT',    'Entrepreneurship',      (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'FIN',    'Finance Basics',        (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Vocational Studies Group
(1, 'ELEC',   'Basic Electronics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'AUTO',   'Automobile Basics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Life Skills & Career Guidance Group
(1, 'LS',     'Life Skills',           (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CAREER', 'Career Guidance',       (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Languages Group
(1, 'ENG',    'English',               (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'URD',    'Urdu',                  (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'ARB',    'Arabic',                (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Foreign Languages Group
(1, 'FR',     'French',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'GER',    'German',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'CHI',    'Chinese',               (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    subject_group_id = VALUES(subject_group_id),
    is_core = VALUES(is_core),
    is_active = TRUE,
    deleted = FALSE;





INSERT INTO campuses (organization_id, institute_id, province_id, city_id,
                      campus_name, contact, email, website, address,
                      logo, deleted,
                      created_at, created_by, updated_at, updated_by,
                      deleted_at, deleted_by)
VALUES

-- Lahore
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Lahore' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com',
 'https://downtown.smarteschool.com', '123 Main Street', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Lahore
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Lahore' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com',
 'https://uptown.smarteschool.com', '456 Park Avenue', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com',
 'https://riverside.smarteschool.com', '789 River Road', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Peshawar
(1, 1,
 (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'),
 (SELECT id FROM cities WHERE name='Peshawar' AND province_id = (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa')),
 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com',
 'https://hilltop.smarteschool.com', '101 Hill Street', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Faisalabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Faisalabad' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
 'https://greenfield.smarteschool.com', '202 Green Road', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com',
 'https://seaside.smarteschool.com', '303 Beach Avenue', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Multan
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Multan' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Central Campus', '+92-303-9990001', 'central@smarteschool.com',
 'https://central.smarteschool.com', '404 Central Street', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Hyderabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Hyderabad' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com',
 'https://lakeside.smarteschool.com', '505 Lake Road', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Rawalpindi
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Rawalpindi' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com',
 'https://sunrise.smarteschool.com', '606 Sunrise Blvd', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

-- Quetta
(1, 1,
 (SELECT id FROM provinces WHERE name='Balochistan'),
 (SELECT id FROM cities WHERE name='Quetta' AND province_id = (SELECT id FROM provinces WHERE name='Balochistan')),
 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com',
 'https://maple.smarteschool.com', '707 Maple Street', NULL, FALSE,
 CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL);


-- ============================================================
-- Sample Data: Standards / Grades
-- Each campus has 1st Grade → 5th Grade. These standards
-- are used to assign students, teachers, timetables, exams,
-- and fees. The 'deleted' column is FALSE (0) for active records.
-- ============================================================

-- Sample standards for 10 campuses
INSERT INTO standards (organization_id, campus_id, standard_name, created_at, updated_at)
VALUES
-- Downtown Campus (campus_id = 1)
(1, 1, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Uptown Campus (campus_id = 2)
(1, 2, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Riverside Campus (campus_id = 3)
(1, 3, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Hilltop Campus (campus_id = 4)
(1, 4, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 4, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 4, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 4, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 4, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Greenfield Campus (campus_id = 5)
(1, 5, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Seaside Campus (campus_id = 6)
(1, 6, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 6, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 6, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 6, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 6, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Central Campus (campus_id = 7)
(1, 7, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 7, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 7, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 7, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 7, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Lakeside Campus (campus_id = 8)
(1, 8, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 8, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 8, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 8, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 8, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Sunrise Campus (campus_id = 9)
(1, 9, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 9, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 9, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 9, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 9, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Maple Campus (campus_id = 10)
(1, 10, '1st Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, '2nd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, '3rd Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, '4th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, '5th Grade', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- ============================================================
-- Sample Data: Sections
-- Each standard (grade) is divided into sections (A/B/C).
-- Sections are used to manage class divisions, student
-- assignments, timetables, and teacher allocation.
-- 'deleted' = 0 indicates active section, 1 indicates soft-deleted.
-- ============================================================


INSERT INTO sections (organization_id, standard_id, section_name, created_at, updated_at, deleted, deleted_at)
VALUES
    -- Standard 1
    (1, 1, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, NULL),
    (1, 1, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 1, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 2
    (1, 2, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 2, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 2, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 3
    (1, 3, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 3, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 3, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 4
    (1, 4, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 4, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 4, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 5
    (1, 5, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 5, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 5, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 6
    (1, 6, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 6, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 6, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 7
    (1, 7, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 7, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 7, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 8
    (1, 8, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 8, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 8, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 9
    (1, 9, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 9, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 9, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    -- Standard 10
    (1, 10, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 10, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL),
    (1, 10, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, NULL);


-- ============================================================
-- 🏢 DEPARTMENTS MASTER DATA (ALL-ENCOMPASSING PRODUCTION SET)
-- ============================================================

-- ------------------------------------------------------------
-- 🏥 CAMPUS 1: DOWNTOWN CAMPUS (Science, Tech & Medical University)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active, created_at, updated_at) VALUES

-- 1. Faculty of Engineering & Tech (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ENG-FAC', 'Faculty of Engineering', 'Main engineering faculty', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CS', 'Dept of Computer Science', 'Core CS and algorithms', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-SE', 'Dept of Software Engineering', 'Software design and development', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-IT', 'Dept of Information Technology', 'IT systems and networks', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-AI', 'Dept of Artificial Intelligence', 'AI, Robotics and Machine Learning', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-DS', 'Dept of Data Science', 'Big data and analytics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CYB', 'Dept of Cyber Security', 'Information security', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-EE', 'Dept of Electrical Engineering', 'Power and electronics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ME', 'Dept of Mechanical Engineering', 'Thermodynamics and mechanics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CE', 'Dept of Civil Engineering', 'Structures and transport', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CHE', 'Dept of Chemical Engineering', 'Chemical processes and labs', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 2. Faculty of Medical & Life Sciences (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-MED', 'Faculty of Medical Sciences', 'Medical and healthcare studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-PHARM', 'Dept of Pharmacy', 'Pharmaceutical studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-NURS', 'Dept of Nursing', 'Nursing and healthcare support', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BIO', 'Dept of Biology', 'Biological sciences', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BIOTECH', 'Dept of Biotechnology', 'Bio-engineering', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-MICRO', 'Dept of Microbiology', 'Microbial research', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ZOO', 'Dept of Zoology', 'Animal sciences', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BOT', 'Dept of Botany', 'Plant sciences', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 3. Administrative (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-REG', 'Registrar Office', 'Main campus registry', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-CONT', 'Controller Office', 'Main administrative control', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'HR' AND organization_id = 1), 'DT-HR-DEPT', 'Human Resources (HR)', 'Staff and faculty management', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'FINANCE' AND organization_id = 1), 'DT-FIN-ACC', 'Finance / Accounts', 'Payroll and accounting', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMISSIONS' AND organization_id = 1), 'DT-ADM-CELL', 'Admissions Office', 'Student intake', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'EXAM' AND organization_id = 1), 'DT-EXAM-DEPT', 'Examinations Department', 'Exams and results', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'IT' AND organization_id = 1), 'DT-IT-SUP', 'IT / System Support', 'Tech infrastructure', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'QUALITY' AND organization_id = 1), 'DT-QA-DEPT', 'Quality Assurance', 'Academic quality control', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-PROC', 'Procurement & Purchasing', 'Supply chain and vendor mgmt', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-FAC-AFF', 'Faculty Affairs', 'Faculty records and coordination', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-LMS-UNIT', 'E-Learning / LMS Center', 'Digital education support', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'RESEARCH' AND organization_id = 1), 'DT-IP-OFFICE', 'Intellectual Property (IP) Office', 'Patents and research IP', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 4. Specialized Units (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'RESEARCH' AND organization_id = 1), 'DT-RES-LABS', 'Research Labs', 'Core research facilities', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'DT-INT-OFF', 'International Office', 'Foreign student support', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-RD-GRANT', 'Grants & Funding Office', 'Research grants management', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ENV', 'Dept of Environmental Science', 'Ecology and environment', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-STAT', 'Dept of Statistics', 'Mathematical statistics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-TRAIN-DEV', 'Training & Development', 'Faculty training programs', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- ------------------------------------------------------------
-- 🎓 CAMPUS 2: UPTOWN CAMPUS (Business, Arts & Social Sciences)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active, created_at, updated_at) VALUES

-- 1. Faculty of Business & Management (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-BUS-FAC', 'Faculty of Business', 'Main business faculty', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-BBA', 'Dept of BBA/MBA', 'Business administration', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-FIN', 'Dept of Finance', 'Financial studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ACC', 'Dept of Accounting', 'Accounting and audit', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-MKT', 'Dept of Marketing', 'Marketing and sales', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HRM', 'Dept of HRM', 'Human resources mgmt', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-SCM', 'Dept of Supply Chain', 'Logistics and operations', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 2. Faculty of Humanities & Social Sciences (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HUM-FAC', 'Faculty of Humanities', 'Arts and social sciences', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-PSY', 'Dept of Psychology', 'Behavioral sciences', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-SOC', 'Dept of Sociology', 'Societal studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-POL', 'Dept of Political Science', 'Governance and politics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-IR', 'Dept of Intl Relations', 'Global affairs', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-PHI', 'Dept of Philosophy', 'Logics and ethics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-LAW', 'Dept of Legal Affairs', 'Legal and law studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 3. Languages & Arts (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ENG', 'Dept of English', 'English linguistics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-URD', 'Dept of Urdu', 'Urdu studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ARA', 'Dept of Arabic', 'Arabic studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-FRN', 'Dept of French', 'French studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-CHI', 'Dept of Chinese', 'Chinese studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HIS', 'Dept of History', 'Historical studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-GEO', 'Dept of Geography', 'Geographical and spatial studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 4. Student Support (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-COUNSEL', 'Student Counseling', 'Guidance and support', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-CAREER', 'Career Services', 'Placement office', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-ALUMNI', 'Alumni Relations', 'Alumni network', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'HOSTEL' AND organization_id = 1), 'UP-SS-HOSTEL', 'Hostel Management', 'On-campus housing', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-GER', 'Dept of German', 'German studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'UP-AS-TRAIN', 'Training & Development', 'Staff and faculty training', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-DIST', 'Distance Learning', 'Online and remote education', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- ------------------------------------------------------------
-- 🌿 CAMPUS 3: RIVERSIDE CAMPUS (Comprehensive School & College)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active, created_at, updated_at) VALUES

-- 1. General school Departments (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-MAT', 'Mathematics Dept', 'Core mathematics', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-SCI', 'General Science Dept', 'Physics, Chemistry, Biology', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ENG', 'English Dept', 'Grammar and literature', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-SOC', 'Social Studies Dept', 'History and Geography', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ISL', 'Islamic Studies Dept', 'Religious education', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-CIV', 'Civics & Pol Science', 'Citizenship education', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ART', 'Fine Arts Dept', 'Creative arts', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-MUS', 'Music Dept', 'Musical education', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-PE', 'Physical Education', 'Sports and games', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'RS-SS-DISC', 'Discipline Office', 'Student conduct and discipline', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 2. College Level Departments (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-PREM', 'Pre-Medical Dept', 'College pre-med', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-PREE', 'Pre-Engineering Dept', 'College pre-eng', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-COM', 'Commerce Dept', 'College commerce', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 3. Operational & Facilities (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'OPERATIONS' AND organization_id = 1), 'RS-OP-MAINT', 'Facilities & Maintenance', 'Campus upkeep', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'SECURITY' AND organization_id = 1), 'RS-OP-SEC', 'Security Department', 'Campus safety', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'OPERATIONS' AND organization_id = 1), 'RS-OP-CLEAN', 'Housekeeping', 'Cleanliness and hygiene', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'FOOD' AND organization_id = 1), 'RS-OP-FOOD', 'Cafeteria Services', 'Student food services', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'TRANSPORT' AND organization_id = 1), 'RS-OP-TRANS', 'Transport Department', 'Fleet management', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- 4. Specialized Religious / Cultural (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-REL-SHARIAH', 'Shariah Department', 'Specialized religious studies', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-REL-ETHICS', 'Ethics & Moral Ed', 'Values education', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-CUL-AFFAIRS', 'Cultural Affairs', 'Heritage and culture', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Final Hierarchical Updates (Assigning Parents)
UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'DT-ACAD-ENG-FAC' AND d2.campus_id = 1
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('DT-ACAD-CS', 'DT-ACAD-SE', 'DT-ACAD-IT', 'DT-ACAD-AI', 'DT-ACAD-DS', 'DT-ACAD-CYB', 'DT-ACAD-EE', 'DT-ACAD-ME', 'DT-ACAD-CE', 'DT-ACAD-CHE') AND d1.campus_id = 1;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'DT-ACAD-MED' AND d2.campus_id = 1
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('DT-ACAD-PHARM', 'DT-ACAD-NURS', 'DT-ACAD-BIO', 'DT-ACAD-BIOTECH', 'DT-ACAD-MICRO', 'DT-ACAD-ZOO', 'DT-ACAD-BOT') AND d1.campus_id = 1;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'UP-ACAD-BUS-FAC' AND d2.campus_id = 2
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('UP-ACAD-BBA', 'UP-ACAD-FIN', 'UP-ACAD-ACC', 'UP-ACAD-MKT', 'UP-ACAD-HRM', 'UP-ACAD-SCM') AND d1.campus_id = 2;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'UP-ACAD-HUM-FAC' AND d2.campus_id = 2
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('UP-ACAD-PSY', 'UP-ACAD-SOC', 'UP-ACAD-POL', 'UP-ACAD-IR', 'UP-ACAD-PHI', 'UP-ACAD-LAW', 'UP-ACAD-HIS', 'UP-ACAD-GEO') AND d1.campus_id = 2;


INSERT INTO fee_catalog
(organization_id, code, name, description, charge_type_id, recurrence_rule_id,
 active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES

(1, 'ADMISSION', 'Admission Fee', 'Fee charged at the time of student admission',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ONE_TIME'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'TUITION', 'Tuition Fee', 'Core academic fee for teaching and instruction',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'ACADEMIC', 'Academic Services Fee', 'Charges related to academic support and services',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='PER_TERM'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'FACILITY', 'Facility Usage Fee', 'Charges for using school facilities and infrastructure',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ANNUAL'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'TRANSPORT', 'Transport Services Fee', 'Fee related to student transportation services',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'ACTIVITY', 'Student Activities Fee', 'Fee related to extracurricular and student activities',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='PER_TERM'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'RESOURCE', 'Learning Resource Fee', 'Fee related to learning materials and resources',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ANNUAL'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'BOARDING', 'Boarding and Accommodation Fee', 'Charges for hostel or boarding facilities',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'PENALTY', 'Penalty and Fine', 'Charges applied for late payments or violations',
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ON_DEMAND'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL),

(1, 'DISCOUNT', 'Discount or Concession', 'Fee reduction applied based on eligibility',
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ON_DEMAND'),
 TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, 1, NULL, NULL);

-- ===================================
-- FEE COMPONENTS DATA
-- ===================================
-- ADMISSION FEE (Catalog ID = 1)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 1, 'ADM-FORM', 'Admission Form Fee', 'ACC-ADM-01', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 1, 'ADM-PROC', 'Admission Processing Fee', 'ACC-ADM-02', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 1, 'ADM-ORIENT', 'Orientation Session Fee', 'ACC-ADM-03', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- TUITION FEE (Catalog ID = 2)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 2, 'TUI-BASIC', 'Basic Tuition Fee', 'ACC-TUI-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 2, 'TUI-LAB', 'Lab Tuition Fee', 'ACC-TUI-02', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 2, 'TUI-MISC', 'Miscellaneous Tuition Fee', 'ACC-TUI-03', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- ACADEMIC SERVICES FEE (Catalog ID = 3)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 3, 'EXAM-MID', 'Mid Term Exam Fee', 'ACC-EXM-01', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 3, 'EXAM-FINAL', 'Final Exam Fee', 'ACC-EXM-02', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 3, 'GRADING', 'Grading & Evaluation Fee', 'ACC-EXM-03', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- FACILITY USAGE FEE (Catalog ID = 4)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 4, 'LAB-COMP', 'Computer Lab Charges', 'ACC-LAB-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 4, 'LAB-SCI', 'Science Lab Charges', 'ACC-LAB-02', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 4, 'LIB-USE', 'Library Usage Fee', 'ACC-LIB-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 4, 'SPORT-FAC', 'Sports Facility Charges', 'ACC-SPORT-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- TRANSPORT FEE (Catalog ID = 5)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 5, 'TRN-MON', 'Monthly Transport Charges', 'ACC-TRN-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 5, 'TRN-REG', 'Transport Registration Fee', 'ACC-TRN-02', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 5, 'TRN-ROUTE', 'Route & Pickup Fee', 'ACC-TRN-03', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- ACTIVITY FEE (Catalog ID = 6)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 6, 'ACT-SPORT', 'Sports & Activities Fee', 'ACC-ACT-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 6, 'ACT-MUSIC', 'Music & Arts Fee', 'ACC-ACT-02', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 6, 'ACT-CLUB', 'Clubs & Societies Fee', 'ACC-ACT-03', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- RESOURCE FEE (Catalog ID = 7)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 7, 'RES-LIB', 'Library Resources Fee', 'ACC-RES-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 7, 'RES-LAB', 'Lab Consumables Fee', 'ACC-RES-02', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 7, 'RES-MATERIAL', 'Learning Materials Fee', 'ACC-RES-03', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- BOARDING FEE (Catalog ID = 8)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 8, 'HOS-MON', 'Monthly Hostel Charges', 'ACC-HOS-01', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 8, 'HOS-FOOD', 'Hostel Food Charges', 'ACC-HOS-02', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 8, 'HOS-UTIL', 'Hostel Utility Charges', 'ACC-HOS-03', FALSE, TRUE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- PENALTY & FINE (Catalog ID = 9)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 9, 'FINE-LATE', 'Late Payment Fine', 'ACC-FINE-01', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 9, 'FINE-DISC', 'Disciplinary Fine', 'ACC-FINE-02', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 9, 'FINE-MISC', 'Miscellaneous Penalty', 'ACC-FINE-03', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- DISCOUNT & CONCESSION (Catalog ID = 10)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, updated_at, created_by)
VALUES
(1, 10, 'DISC-SCH', 'Scholarship Discount', 'ACC-DISC-01', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 10, 'DISC-FAM', 'Family Discount', 'ACC-DISC-02', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(1, 10, 'DISC-PROMO', 'Promotional Discount', 'ACC-DISC-03', FALSE, FALSE, TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- ===================================
-- FEE RATES DATA
-- ===================================
-- Notes:
--   • fee_rates.fee_component_id uses composite FK (organization_id, fee_component_id)
--     → fee_component(organization_id, id).  All subqueries must filter by organization_id=1.
--   • charge_type_id uses composite FK (organization_id, charge_type_id)
--     → charge_types(organization_id, id).  Subqueries filter by organization_id=1.
--   • chk_fee_rates_pricing_mode requires EXACTLY ONE of:
--     fixed_amount | percentage_value | unit_price | slab_group_id to be non-NULL.
--     Transport (SLAB) is skipped here until real slab groups are seeded.

-- 1. ADMISSION FEES (Fixed Amount)
INSERT INTO fee_rates
  (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
   charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at, updated_at)
VALUES
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='ADM-FORM'   AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 1000.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='ADM-PROC'   AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 2500.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='ADM-ORIENT' AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
  500.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2. TUITION FEES (Fixed Amount)
INSERT INTO fee_rates
  (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
   charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at, updated_at)
VALUES
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='TUI-BASIC' AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 8000.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='TUI-LAB'   AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 1500.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='TUI-MISC'  AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
  500.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 3. ACADEMIC SERVICES (Fixed Amount)
INSERT INTO fee_rates
  (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
   charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at, updated_at)
VALUES
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='EXAM-MID'   AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 1200.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='EXAM-FINAL' AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 2000.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 4. FACILITY USAGE (Fixed Amount)
INSERT INTO fee_rates
  (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
   charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at, updated_at)
VALUES
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='LAB-COMP' AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
 1000.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='LIB-USE'  AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='FIXED'),
  400.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 5. TRANSPORT (SLAB-based) — skipped until fee_slab_groups are seeded.
--    Insert a fee_slab_group first, then uncomment:
-- INSERT INTO fee_slab_groups (organization_id, fee_component_id, code, name, active, deleted, created_at, created_by)
-- VALUES (1, (SELECT id FROM fee_component WHERE component_code='TRN-MON' AND organization_id=1),
--         'TRN-DISTANCE', 'Transport Distance Slabs', TRUE, FALSE, CURRENT_TIMESTAMP, 1);
-- INSERT INTO fee_slabs (organization_id, slab_group_id, min_value, max_value, amount, currency, active, deleted, created_at, created_by)
-- VALUES (1, LAST_INSERT_ID(),  0.00,  5.00, 1500.00, 'PKR', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
--        (1, LAST_INSERT_ID(),  5.01, 15.00, 2500.00, 'PKR', TRUE, FALSE, CURRENT_TIMESTAMP, 1),
--        (1, LAST_INSERT_ID(), 15.01, NULL,  3500.00, 'PKR', TRUE, FALSE, CURRENT_TIMESTAMP, 1);
-- INSERT INTO fee_rates (..., slab_group_id, ...) VALUES (1, 1, 1, ..., <slab_group_id>, ...);

-- 6. RESOURCE FEE (Per Unit Pricing)
-- INSERT INTO fee_rates
--   (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
--    charge_type_id, unit_price, currency, effective_from, active, deleted, created_at, updated_at)
-- VALUES
-- (1, 1, 1,
--  (SELECT id FROM fee_component WHERE component_code='RES-MATERIAL' AND organization_id=1),
--  1, (SELECT id FROM charge_types WHERE code='FIXED'),
--  50.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 7. PENALTY & FINES (Percentage Based)
INSERT INTO fee_rates
  (organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
   charge_type_id, percentage_value, currency, effective_from, active, deleted, created_at, updated_at)
VALUES
(1, 1, 1,
 (SELECT id FROM fee_component WHERE component_code='FINE-LATE' AND organization_id=1),
 1, (SELECT id FROM charge_types WHERE code='PERCENTAGE'),
 5.00, 'PKR', '2025-04-01', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 8. DISCOUNTS & CONCESSIONS (Percentage Based)
--    These are fee reduction markers, NOT billable line items.
--    They do not need a fee_rate record. Discount logic is handled by
--    the student_discount_assignments table. Skipped intentionally.



    -- Populate standard_subjects with real-time dataset
    INSERT INTO standard_subjects
    (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks, created_at, updated_at)
    VALUES
    -- Primary (Std 1-5)
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 3, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 3, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 4, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 4, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 5, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 5, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    -- Secondary (Std 6-10)
    (1, 6, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 6, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 6, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 6, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 7, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 7, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 7, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 7, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 8, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 8, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 8, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 8, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 9, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 9, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 9, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 9, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 10, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 10, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 10, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 10, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    -- Higher Secondary / Electives (Std 11-12)
    (1, 11, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 11, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 11, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 11, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 11, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 11, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 12, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


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

-- Periodic Exams
(1,'UT1','Unit Test 1','First unit test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'UT2','Unit Test 2','Second unit test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'UT3','Unit Test 3','Third unit test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'MT1','Monthly Test','Monthly performance test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'WKLY','Weekly Test','Weekly short test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Internal Evaluation
(1,'INT','Internal Exam','Internal assessment',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'CLASS','Class Test','Classroom evaluation',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'ORAL','Oral Exam','Spoken evaluation',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Practical Based
(1,'PRAC','Practical Exam','Hands-on practical exam',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'LAB','Lab Exam','Laboratory evaluation',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'VIVA','Viva Voce','Oral viva assessment',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Special Cases
(1,'ENT','Entrance Exam','Admission test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'MOCK','Mock Exam','Practice exam',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'SCH','Scholarship Exam','Scholarship qualification test',TRUE,FALSE,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1);


INSERT INTO exam_terms
(organization_id, name, sequence_no, academic_year_id, created_at, updated_at, created_by) VALUES
(1,'First Term',1,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'Mid Term',2,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'Second Term',3,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'Pre Final',4,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'Final Term',5,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1);



INSERT INTO assessment_types
(organization_id, code, name, description, created_at, updated_at, created_by)
VALUES

-- Written Evaluations
(1,'WR','Written Exam','Traditional written paper exam',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'MCQ','MCQ Test','Multiple choice questions based test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'SUB','Subjective','Long answer descriptive paper',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'OBJ','Objective','Short answer or objective type test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Continuous Assessment
(1,'QUIZ','Quiz','Short quiz assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'ASSIGN','Assignment','Homework or take-home task',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'CLASS','Class Test','In-class short test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'WKTEST','Weekly Test','Weekly performance test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'UNIT','Unit Test','Unit completion test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Practical Based
(1,'PRAC','Practical','Hands-on practical exam',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'LAB','Lab Work','Laboratory performance assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'DEMO','Demonstration','Practical demonstration assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Oral / Interactive
(1,'VIVA','Viva Voce','Oral examination',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'ORAL','Oral Test','Spoken or verbal test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'PRES','Presentation','Presentation based evaluation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Project / Coursework
(1,'PROJ','Project','Project based evaluation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'COURSE','Course Work','Continuous coursework assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'PORT','Portfolio','Portfolio submission assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Behavior / Participation
(1,'ATT','Attendance','Marks based on attendance',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'PART','Participation','Class participation marks',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'DISC','Discipline','Discipline evaluation marks',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),

-- Special Evaluations
(1,'MOCK','Mock Assessment','Practice exam for preparation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'DIAG','Diagnostic Test','Skill assessment test',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'SKILL','Skill Test','Skill-based evaluation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1),
(1,'PHYS','Physical Test','Physical activity assessment',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1);


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


-- Admission Types
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
-- Student Data (5 per section for 30 sections = 150 students)
-- Campus 1, Standards 1-5, Sections 1-15
-- Campus 2, Standards 6-10, Sections 16-30

INSERT INTO students (organization_id, first_name, full_name, last_name, student_code, date_of_birth, gender, email, enrollment_date, campus_id, standard_id, section_id, admission_type_id, academic_year_id, created_at, updated_at)
VALUES
-- Standard 1 (Campus 1), Section 1 (A)
(1, 'Ahmed', 'Ahmed Ali', 'Ali', 'STU001', '2015-05-12', 'Male', 'stu001@example.com', '2026-02-22', 1, 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Sara', 'Sara Khan', 'Khan', 'STU002', '2015-06-15', 'Female', 'stu002@example.com', '2026-02-22', 1, 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Omar', 'Omar Farooq', 'Farooq', 'STU003', '2015-04-20', 'Male', 'stu003@example.com', '2026-02-22', 1, 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Zainab', 'Zainab Bibi', 'Bibi', 'STU004', '2015-08-10', 'Female', 'stu004@example.com', '2026-02-22', 1, 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Bilal', 'Bilal Hassan', 'Hassan', 'STU005', '2015-03-05', 'Male', 'stu005@example.com', '2026-02-22', 1, 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 1 (Campus 1), Section 2 (B)
(1, 'Fatima', 'Fatima Zahra', 'Zahra', 'STU006', '2015-07-22', 'Female', 'stu006@example.com', '2026-02-22', 1, 1, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Usman', 'Usman Sheikh', 'Sheikh', 'STU007', '2015-09-30', 'Male', 'stu007@example.com', '2026-02-22', 1, 1, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Ayesha', 'Ayesha Malik', 'Malik', 'STU008', '2015-01-12', 'Female', 'stu008@example.com', '2026-02-22', 1, 1, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Hamza', 'Hamza Butt', 'Butt', 'STU009', '2015-11-05', 'Male', 'stu009@example.com', '2026-02-22', 1, 1, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Hania', 'Hania Amir', 'Amir', 'STU010', '2015-12-25', 'Female', 'stu010@example.com', '2026-02-22', 1, 1, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 1 (Campus 1), Section 3 (C)
(1, 'Ali', 'Ali Raza', 'Raza', 'STU011', '2015-02-14', 'Male', 'stu011@example.com', '2026-02-22', 1, 1, 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Dua', 'Dua Lipa', 'Lipa', 'STU012', '2015-04-18', 'Female', 'stu012@example.com', '2026-02-22', 1, 1, 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Mustafa', 'Mustafa Kamal', 'Kamal', 'STU013', '2015-06-06', 'Male', 'stu013@example.com', '2026-02-22', 1, 1, 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Inaya', 'Inaya Fatima', 'Fatima', 'STU014', '2015-10-10', 'Female', 'stu014@example.com', '2026-02-22', 1, 1, 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Rayyan', 'Rayyan Abbas', 'Abbas', 'STU015', '2015-08-25', 'Male', 'stu015@example.com', '2026-02-22', 1, 1, 3, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 2 (Campus 1), Section 4 (A)
(1, 'Student', 'Student 16', '16', 'STU016', '2014-05-01', 'Male', 'stu016@example.com', '2026-02-22', 1, 2, 4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 17', '17', 'STU017', '2014-05-02', 'Female', 'stu017@example.com', '2026-02-22', 1, 2, 4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 18', '18', 'STU018', '2014-05-03', 'Male', 'stu018@example.com', '2026-02-22', 1, 2, 4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 19', '19', 'STU019', '2014-05-04', 'Female', 'stu019@example.com', '2026-02-22', 1, 2, 4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 20', '20', 'STU020', '2014-05-05', 'Male', 'stu020@example.com', '2026-02-22', 1, 2, 4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 2 (Campus 1), Section 5 (B)
(1, 'Student', 'Student 21', '21', 'STU021', '2014-06-01', 'Female', 'stu021@example.com', '2026-02-22', 1, 2, 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 22', '22', 'STU022', '2014-06-02', 'Male', 'stu022@example.com', '2026-02-22', 1, 2, 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 23', '23', 'STU023', '2014-06-03', 'Female', 'stu023@example.com', '2026-02-22', 1, 2, 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 24', '24', 'STU024', '2014-06-04', 'Male', 'stu024@example.com', '2026-02-22', 1, 2, 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 25', '25', 'STU025', '2014-06-05', 'Female', 'stu025@example.com', '2026-02-22', 1, 2, 5, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 2 (Campus 1), Section 6 (C)
(1, 'Student', 'Student 26', '26', 'STU026', '2014-07-01', 'Male', 'stu026@example.com', '2026-02-22', 1, 2, 6, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 27', '27', 'STU027', '2014-07-02', 'Female', 'stu027@example.com', '2026-02-22', 1, 2, 6, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 28', '28', 'STU028', '2014-07-03', 'Male', 'stu028@example.com', '2026-02-22', 1, 2, 6, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 29', '29', 'STU029', '2014-07-04', 'Female', 'stu029@example.com', '2026-02-22', 1, 2, 6, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 30', '30', 'STU030', '2014-07-05', 'Male', 'stu030@example.com', '2026-02-22', 1, 2, 6, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 3 (Campus 1), Section 7 (A)
(1, 'Student', 'Student 31', '31', 'STU031', '2013-05-01', 'Male', 'stu031@example.com', '2026-02-22', 1, 3, 7, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 32', '32', 'STU032', '2013-05-02', 'Female', 'stu032@example.com', '2026-02-22', 1, 3, 7, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 33', '33', 'STU033', '2013-05-03', 'Male', 'stu033@example.com', '2026-02-22', 1, 3, 7, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 34', '34', 'STU034', '2013-05-04', 'Female', 'stu034@example.com', '2026-02-22', 1, 3, 7, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 35', '35', 'STU035', '2013-05-05', 'Male', 'stu035@example.com', '2026-02-22', 1, 3, 7, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 3 (Campus 1), Section 8 (B)
(1, 'Student', 'Student 36', '36', 'STU036', '2013-06-01', 'Female', 'stu036@example.com', '2026-02-22', 1, 3, 8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 37', '37', 'STU037', '2013-06-02', 'Male', 'stu037@example.com', '2026-02-22', 1, 3, 8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 38', '38', 'STU038', '2013-06-03', 'Female', 'stu038@example.com', '2026-02-22', 1, 3, 8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 39', '39', 'STU039', '2013-06-04', 'Male', 'stu039@example.com', '2026-02-22', 1, 3, 8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 40', '40', 'STU040', '2013-06-05', 'Female', 'stu040@example.com', '2026-02-22', 1, 3, 8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 3 (Campus 1), Section 9 (C)
(1, 'Student', 'Student 41', '41', 'STU041', '2013-07-01', 'Male', 'stu041@example.com', '2026-02-22', 1, 3, 9, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 42', '42', 'STU042', '2013-07-02', 'Female', 'stu042@example.com', '2026-02-22', 1, 3, 9, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 43', '43', 'STU043', '2013-07-03', 'Male', 'stu043@example.com', '2026-02-22', 1, 3, 9, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 44', '44', 'STU044', '2013-07-04', 'Female', 'stu044@example.com', '2026-02-22', 1, 3, 9, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 45', '45', 'STU045', '2013-07-05', 'Male', 'stu045@example.com', '2026-02-22', 1, 3, 9, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 4 (Campus 1), Section 10 (A)
(1, 'Student', 'Student 46', '46', 'STU046', '2012-05-01', 'Male', 'stu046@example.com', '2026-02-22', 1, 4, 10, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 47', '47', 'STU047', '2012-05-02', 'Female', 'stu047@example.com', '2026-02-22', 1, 4, 10, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 48', '48', 'STU048', '2012-05-03', 'Male', 'stu048@example.com', '2026-02-22', 1, 4, 10, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 49', '49', 'STU049', '2012-05-04', 'Female', 'stu049@example.com', '2026-02-22', 1, 4, 10, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 50', '50', 'STU050', '2012-05-05', 'Male', 'stu050@example.com', '2026-02-22', 1, 4, 10, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 4 (Campus 1), Section 11 (B)
(1, 'Student', 'Student 51', '51', 'STU051', '2012-06-01', 'Female', 'stu051@example.com', '2026-02-22', 1, 4, 11, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 52', '52', 'STU052', '2012-06-02', 'Male', 'stu052@example.com', '2026-02-22', 1, 4, 11, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 53', '53', 'STU053', '2012-06-03', 'Female', 'stu053@example.com', '2026-02-22', 1, 4, 11, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 54', '54', 'STU054', '2012-06-04', 'Male', 'stu054@example.com', '2026-02-22', 1, 4, 11, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 55', '55', 'STU055', '2012-06-05', 'Female', 'stu055@example.com', '2026-02-22', 1, 4, 11, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 4 (Campus 1), Section 12 (C)
(1, 'Student', 'Student 56', '56', 'STU056', '2012-07-01', 'Male', 'stu056@example.com', '2026-02-22', 1, 4, 12, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 57', '57', 'STU057', '2012-07-02', 'Female', 'stu057@example.com', '2026-02-22', 1, 4, 12, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 58', '58', 'STU058', '2012-07-03', 'Male', 'stu058@example.com', '2026-02-22', 1, 4, 12, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 59', '59', 'STU059', '2012-07-04', 'Female', 'stu059@example.com', '2026-02-22', 1, 4, 12, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 60', '60', 'STU060', '2012-07-05', 'Male', 'stu060@example.com', '2026-02-22', 1, 4, 12, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 5 (Campus 1), Section 13 (A)
(1, 'Student', 'Student 61', '61', 'STU061', '2011-05-01', 'Male', 'stu061@example.com', '2026-02-22', 1, 5, 13, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 62', '62', 'STU062', '2011-05-02', 'Female', 'stu062@example.com', '2026-02-22', 1, 5, 13, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 63', '63', 'STU063', '2011-05-03', 'Male', 'stu063@example.com', '2026-02-22', 1, 5, 13, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 64', '64', 'STU064', '2011-05-04', 'Female', 'stu064@example.com', '2026-02-22', 1, 5, 13, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 65', '65', 'STU065', '2011-05-05', 'Male', 'stu065@example.com', '2026-02-22', 1, 5, 13, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 5 (Campus 1), Section 14 (B)
(1, 'Student', 'Student 66', '66', 'STU066', '2011-06-01', 'Female', 'stu066@example.com', '2026-02-22', 1, 5, 14, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 67', '67', 'STU067', '2011-06-02', 'Male', 'stu067@example.com', '2026-02-22', 1, 5, 14, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 68', '68', 'STU068', '2011-06-03', 'Female', 'stu068@example.com', '2026-02-22', 1, 5, 14, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 69', '69', 'STU069', '2011-06-04', 'Male', 'stu069@example.com', '2026-02-22', 1, 5, 14, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 70', '70', 'STU070', '2011-06-05', 'Female', 'stu070@example.com', '2026-02-22', 1, 5, 14, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 5 (Campus 1), Section 15 (C)
(1, 'Student', 'Student 71', '71', 'STU071', '2011-07-01', 'Male', 'stu071@example.com', '2026-02-22', 1, 5, 15, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 72', '72', 'STU072', '2011-07-02', 'Female', 'stu072@example.com', '2026-02-22', 1, 5, 15, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 73', '73', 'STU073', '2011-07-03', 'Male', 'stu073@example.com', '2026-02-22', 1, 5, 15, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 74', '74', 'STU074', '2011-07-04', 'Female', 'stu074@example.com', '2026-02-22', 1, 5, 15, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 75', '75', 'STU075', '2011-07-05', 'Male', 'stu075@example.com', '2026-02-22', 1, 5, 15, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Campus 2, Standards 6-10, Sections 16-30
-- Standard 6 (Campus 2), Section 16 (A)
(1, 'Uptown', 'Uptown Student 76', '76', 'STU076', '2010-05-01', 'Male', 'stu076@example.com', '2026-02-22', 2, 6, 16, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 77', '77', 'STU077', '2010-05-02', 'Female', 'stu077@example.com', '2026-02-22', 2, 6, 16, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 78', '78', 'STU078', '2010-05-03', 'Male', 'stu078@example.com', '2026-02-22', 2, 6, 16, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 79', '79', 'STU079', '2010-05-04', 'Female', 'stu079@example.com', '2026-02-22', 2, 6, 16, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 80', '80', 'STU080', '2010-05-05', 'Male', 'stu080@example.com', '2026-02-22', 2, 6, 16, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 6 (Campus 2), Section 17 (B)
(1, 'Uptown', 'Uptown Student 81', '81', 'STU081', '2010-06-01', 'Female', 'stu081@example.com', '2026-02-22', 2, 6, 17, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 82', '82', 'STU082', '2010-06-02', 'Male', 'stu082@example.com', '2026-02-22', 2, 6, 17, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 83', '83', 'STU083', '2010-06-03', 'Female', 'stu083@example.com', '2026-02-22', 2, 6, 17, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 84', '84', 'STU084', '2010-06-04', 'Male', 'stu084@example.com', '2026-02-22', 2, 6, 17, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 85', '85', 'STU085', '2010-06-05', 'Female', 'stu085@example.com', '2026-02-22', 2, 6, 17, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 6 (Campus 2), Section 18 (C)
(1, 'Uptown', 'Uptown Student 86', '86', 'STU086', '2010-07-01', 'Male', 'stu086@example.com', '2026-02-22', 2, 6, 18, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 87', '87', 'STU087', '2010-07-02', 'Female', 'stu087@example.com', '2026-02-22', 2, 6, 18, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 88', '88', 'STU088', '2010-07-03', 'Male', 'stu088@example.com', '2026-02-22', 2, 6, 18, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 89', '89', 'STU089', '2010-07-04', 'Female', 'stu089@example.com', '2026-02-22', 2, 6, 18, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Uptown', 'Uptown Student 90', '90', 'STU090', '2010-07-05', 'Male', 'stu090@example.com', '2026-02-22', 2, 6, 18, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 7 (Campus 2), Section 19 (A)
(1, 'Student', 'Student 91', '91', 'STU091', '2009-05-01', 'Male', 'stu091@example.com', '2026-02-22', 2, 7, 19, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 92', '92', 'STU092', '2009-05-02', 'Female', 'stu092@example.com', '2026-02-22', 2, 7, 19, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 93', '93', 'STU093', '2009-05-03', 'Male', 'stu093@example.com', '2026-02-22', 2, 7, 19, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 94', '94', 'STU094', '2009-05-04', 'Female', 'stu094@example.com', '2026-02-22', 2, 7, 19, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 95', '95', 'STU095', '2009-05-05', 'Male', 'stu095@example.com', '2026-02-22', 2, 7, 19, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 7 (Campus 2), Section 20 (B)
(1, 'Student', 'Student 96', '96', 'STU096', '2009-06-01', 'Female', 'stu096@example.com', '2026-02-22', 2, 7, 20, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 97', '97', 'STU097', '2009-06-02', 'Male', 'stu097@example.com', '2026-02-22', 2, 7, 20, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 98', '98', 'STU098', '2009-06-03', 'Female', 'stu098@example.com', '2026-02-22', 2, 7, 20, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 99', '99', 'STU099', '2009-06-04', 'Male', 'stu099@example.com', '2026-02-22', 2, 7, 20, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 100', '100', 'STU100', '2009-06-05', 'Female', 'stu100@example.com', '2026-02-22', 2, 7, 20, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 7 (Campus 2), Section 21 (C)
(1, 'Student', 'Student 101', '101', 'STU101', '2009-07-01', 'Male', 'stu101@example.com', '2026-02-22', 2, 7, 21, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 102', '102', 'STU102', '2009-07-02', 'Female', 'stu102@example.com', '2026-02-22', 2, 7, 21, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 103', '103', 'STU103', '2009-07-03', 'Male', 'stu103@example.com', '2026-02-22', 2, 7, 21, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 104', '104', 'STU104', '2009-07-04', 'Female', 'stu104@example.com', '2026-02-22', 2, 7, 21, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 105', '105', 'STU105', '2009-07-05', 'Male', 'stu105@example.com', '2026-02-22', 2, 7, 21, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 8 (Campus 2), Section 22 (A)
(1, 'Student', 'Student 106', '106', 'STU106', '2008-05-01', 'Male', 'stu106@example.com', '2026-02-22', 2, 8, 22, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 107', '107', 'STU107', '2008-05-02', 'Female', 'stu107@example.com', '2026-02-22', 2, 8, 22, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 108', '108', 'STU108', '2008-05-03', 'Male', 'stu108@example.com', '2026-02-22', 2, 8, 22, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 109', '109', 'STU109', '2008-05-04', 'Female', 'stu109@example.com', '2026-02-22', 2, 8, 22, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 110', '110', 'STU110', '2008-05-05', 'Male', 'stu110@example.com', '2026-02-22', 2, 8, 22, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 8 (Campus 2), Section 23 (B)
(1, 'Student', 'Student 111', '111', 'STU111', '2008-06-01', 'Female', 'stu111@example.com', '2026-02-22', 2, 8, 23, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 112', '112', 'STU112', '2008-06-02', 'Male', 'stu112@example.com', '2026-02-22', 2, 8, 23, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 113', '113', 'STU113', '2008-06-03', 'Female', 'stu113@example.com', '2026-02-22', 2, 8, 23, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 114', '114', 'STU114', '2008-06-04', 'Male', 'stu114@example.com', '2026-02-22', 2, 8, 23, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 115', '115', 'STU115', '2008-06-05', 'Female', 'stu115@example.com', '2026-02-22', 2, 8, 23, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 8 (Campus 2), Section 24 (C)
(1, 'Student', 'Student 116', '116', 'STU116', '2008-07-01', 'Male', 'stu116@example.com', '2026-02-22', 2, 8, 24, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 117', '117', 'STU117', '2008-07-02', 'Female', 'stu117@example.com', '2026-02-22', 2, 8, 24, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 118', '118', 'STU118', '2008-07-03', 'Male', 'stu118@example.com', '2026-02-22', 2, 8, 24, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 119', '119', 'STU119', '2008-07-04', 'Female', 'stu119@example.com', '2026-02-22', 2, 8, 24, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 120', '120', 'STU120', '2008-07-05', 'Male', 'stu120@example.com', '2026-02-22', 2, 8, 24, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 9 (Campus 2), Section 25 (A)
(1, 'Student', 'Student 121', '121', 'STU121', '2007-05-01', 'Male', 'stu121@example.com', '2026-02-22', 2, 9, 25, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 122', '122', 'STU122', '2007-05-02', 'Female', 'stu122@example.com', '2026-02-22', 2, 9, 25, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 123', '123', 'STU123', '2007-05-03', 'Male', 'stu123@example.com', '2026-02-22', 2, 9, 25, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 124', '124', 'STU124', '2007-05-04', 'Female', 'stu124@example.com', '2026-02-22', 2, 9, 25, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 125', '125', 'STU125', '2007-05-05', 'Male', 'stu125@example.com', '2026-02-22', 2, 9, 25, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 9 (Campus 2), Section 26 (B)
(1, 'Student', 'Student 126', '126', 'STU126', '2007-06-01', 'Female', 'stu126@example.com', '2026-02-22', 2, 9, 26, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 127', '127', 'STU127', '2007-06-02', 'Male', 'stu127@example.com', '2026-02-22', 2, 9, 26, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 128', '128', 'STU128', '2007-06-03', 'Female', 'stu128@example.com', '2026-02-22', 2, 9, 26, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 129', '129', 'STU129', '2007-06-04', 'Male', 'stu129@example.com', '2026-02-22', 2, 9, 26, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 130', '130', 'STU130', '2007-06-05', 'Female', 'stu130@example.com', '2026-02-22', 2, 9, 26, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 9 (Campus 2), Section 27 (C)
(1, 'Student', 'Student 131', '131', 'STU131', '2007-07-01', 'Male', 'stu131@example.com', '2026-02-22', 2, 9, 27, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 132', '132', 'STU132', '2007-07-02', 'Female', 'stu132@example.com', '2026-02-22', 2, 9, 27, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 133', '133', 'STU133', '2007-07-03', 'Male', 'stu133@example.com', '2026-02-22', 2, 9, 27, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 134', '134', 'STU134', '2007-07-04', 'Female', 'stu134@example.com', '2026-02-22', 2, 9, 27, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 135', '135', 'STU135', '2007-07-05', 'Male', 'stu135@example.com', '2026-02-22', 2, 9, 27, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 10 (Campus 2), Section 28 (A)
(1, 'Student', 'Student 136', '136', 'STU136', '2006-05-01', 'Male', 'stu136@example.com', '2026-02-22', 2, 10, 28, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 137', '137', 'STU137', '2006-05-02', 'Female', 'stu137@example.com', '2026-02-22', 2, 10, 28, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 138', '138', 'STU138', '2006-05-03', 'Male', 'stu138@example.com', '2026-02-22', 2, 10, 28, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 139', '139', 'STU139', '2006-05-04', 'Female', 'stu139@example.com', '2026-02-22', 2, 10, 28, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 140', '140', 'STU140', '2006-05-05', 'Male', 'stu140@example.com', '2026-02-22', 2, 10, 28, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 10 (Campus 2), Section 29 (B)
(1, 'Student', 'Student 141', '141', 'STU141', '2006-06-01', 'Female', 'stu141@example.com', '2026-02-22', 2, 10, 29, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 142', '142', 'STU142', '2006-06-02', 'Male', 'stu142@example.com', '2026-02-22', 2, 10, 29, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 143', '143', 'STU143', '2006-06-03', 'Female', 'stu143@example.com', '2026-02-22', 2, 10, 29, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 144', '144', 'STU144', '2006-06-04', 'Male', 'stu144@example.com', '2026-02-22', 2, 10, 29, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 145', '145', 'STU145', '2006-06-05', 'Female', 'stu145@example.com', '2026-02-22', 2, 10, 29, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Standard 10 (Campus 2), Section 30 (C)
(1, 'Student', 'Student 146', '146', 'STU146', '2006-07-01', 'Male', 'stu146@example.com', '2026-02-22', 2, 10, 30, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 147', '147', 'STU147', '2006-07-02', 'Female', 'stu147@example.com', '2026-02-22', 2, 10, 30, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 148', '148', 'STU148', '2006-07-03', 'Male', 'stu148@example.com', '2026-02-22', 2, 10, 30, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 149', '149', 'STU149', '2006-07-04', 'Female', 'stu149@example.com', '2026-02-22', 2, 10, 30, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Student', 'Student 150', '150', 'STU150', '2006-07-05', 'Male', 'stu150@example.com', '2026-02-22', 2, 10, 30, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




INSERT INTO exams (organization_id, academic_year_id, exam_term_id, exam_type_id, campus_id, standard_id, section_id, name, description, start_date, end_date, status, created_at, updated_at)
VALUES
(1, 1, 1, 6, 1, 1, 1, 'Unit Test 1 - Section 1', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 1, 1, 'Unit Test 2 - Section 1', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 1, 1, 'Mid Term Exam - Section 1', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 1, 1, 'Unit Test 3 - Section 1', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 1, 1, 'Final Exam - Section 1', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 1, 2, 'Unit Test 1 - Section 2', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 1, 2, 'Unit Test 2 - Section 2', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 1, 2, 'Mid Term Exam - Section 2', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 1, 2, 'Unit Test 3 - Section 2', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 1, 2, 'Final Exam - Section 2', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 1, 3, 'Unit Test 1 - Section 3', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 1, 3, 'Unit Test 2 - Section 3', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 1, 3, 'Mid Term Exam - Section 3', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 1, 3, 'Unit Test 3 - Section 3', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 1, 3, 'Final Exam - Section 3', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 2, 4, 'Unit Test 1 - Section 4', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 2, 4, 'Unit Test 2 - Section 4', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 2, 4, 'Mid Term Exam - Section 4', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 2, 4, 'Unit Test 3 - Section 4', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 2, 4, 'Final Exam - Section 4', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 2, 5, 'Unit Test 1 - Section 5', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 2, 5, 'Unit Test 2 - Section 5', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 2, 5, 'Mid Term Exam - Section 5', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 2, 5, 'Unit Test 3 - Section 5', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 2, 5, 'Final Exam - Section 5', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 2, 6, 'Unit Test 1 - Section 6', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 2, 6, 'Unit Test 2 - Section 6', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 2, 6, 'Mid Term Exam - Section 6', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 2, 6, 'Unit Test 3 - Section 6', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 2, 6, 'Final Exam - Section 6', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 3, 7, 'Unit Test 1 - Section 7', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 3, 7, 'Unit Test 2 - Section 7', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 3, 7, 'Mid Term Exam - Section 7', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 3, 7, 'Unit Test 3 - Section 7', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 3, 7, 'Final Exam - Section 7', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 3, 8, 'Unit Test 1 - Section 8', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 3, 8, 'Unit Test 2 - Section 8', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 3, 8, 'Mid Term Exam - Section 8', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 3, 8, 'Unit Test 3 - Section 8', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 3, 8, 'Final Exam - Section 8', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 3, 9, 'Unit Test 1 - Section 9', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 3, 9, 'Unit Test 2 - Section 9', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 3, 9, 'Mid Term Exam - Section 9', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 3, 9, 'Unit Test 3 - Section 9', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 3, 9, 'Final Exam - Section 9', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 4, 10, 'Unit Test 1 - Section 10', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 4, 10, 'Unit Test 2 - Section 10', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 4, 10, 'Mid Term Exam - Section 10', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 4, 10, 'Unit Test 3 - Section 10', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 4, 10, 'Final Exam - Section 10', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 4, 11, 'Unit Test 1 - Section 11', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 4, 11, 'Unit Test 2 - Section 11', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 4, 11, 'Mid Term Exam - Section 11', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 4, 11, 'Unit Test 3 - Section 11', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 4, 11, 'Final Exam - Section 11', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 4, 12, 'Unit Test 1 - Section 12', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 4, 12, 'Unit Test 2 - Section 12', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 4, 12, 'Mid Term Exam - Section 12', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 4, 12, 'Unit Test 3 - Section 12', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 4, 12, 'Final Exam - Section 12', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 5, 13, 'Unit Test 1 - Section 13', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 5, 13, 'Unit Test 2 - Section 13', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 5, 13, 'Mid Term Exam - Section 13', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 5, 13, 'Unit Test 3 - Section 13', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 5, 13, 'Final Exam - Section 13', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 5, 14, 'Unit Test 1 - Section 14', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 5, 14, 'Unit Test 2 - Section 14', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 5, 14, 'Mid Term Exam - Section 14', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 5, 14, 'Unit Test 3 - Section 14', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 5, 14, 'Final Exam - Section 14', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 1, 5, 15, 'Unit Test 1 - Section 15', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 1, 5, 15, 'Unit Test 2 - Section 15', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 1, 5, 15, 'Mid Term Exam - Section 15', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 1, 5, 15, 'Unit Test 3 - Section 15', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 1, 5, 15, 'Final Exam - Section 15', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 6, 16, 'Unit Test 1 - Section 16', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 6, 16, 'Unit Test 2 - Section 16', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 6, 16, 'Mid Term Exam - Section 16', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 6, 16, 'Unit Test 3 - Section 16', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 6, 16, 'Final Exam - Section 16', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 6, 17, 'Unit Test 1 - Section 17', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 6, 17, 'Unit Test 2 - Section 17', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 6, 17, 'Mid Term Exam - Section 17', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 6, 17, 'Unit Test 3 - Section 17', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 6, 17, 'Final Exam - Section 17', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 6, 18, 'Unit Test 1 - Section 18', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 6, 18, 'Unit Test 2 - Section 18', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 6, 18, 'Mid Term Exam - Section 18', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 6, 18, 'Unit Test 3 - Section 18', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 6, 18, 'Final Exam - Section 18', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 7, 19, 'Unit Test 1 - Section 19', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 7, 19, 'Unit Test 2 - Section 19', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 7, 19, 'Mid Term Exam - Section 19', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 7, 19, 'Unit Test 3 - Section 19', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 7, 19, 'Final Exam - Section 19', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 7, 20, 'Unit Test 1 - Section 20', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 7, 20, 'Unit Test 2 - Section 20', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 7, 20, 'Mid Term Exam - Section 20', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 7, 20, 'Unit Test 3 - Section 20', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 7, 20, 'Final Exam - Section 20', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 7, 21, 'Unit Test 1 - Section 21', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 7, 21, 'Unit Test 2 - Section 21', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 7, 21, 'Mid Term Exam - Section 21', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 7, 21, 'Unit Test 3 - Section 21', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 7, 21, 'Final Exam - Section 21', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 8, 22, 'Unit Test 1 - Section 22', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 8, 22, 'Unit Test 2 - Section 22', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 8, 22, 'Mid Term Exam - Section 22', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 8, 22, 'Unit Test 3 - Section 22', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 8, 22, 'Final Exam - Section 22', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 8, 23, 'Unit Test 1 - Section 23', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 8, 23, 'Unit Test 2 - Section 23', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 8, 23, 'Mid Term Exam - Section 23', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 8, 23, 'Unit Test 3 - Section 23', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 8, 23, 'Final Exam - Section 23', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 8, 24, 'Unit Test 1 - Section 24', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 8, 24, 'Unit Test 2 - Section 24', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 8, 24, 'Mid Term Exam - Section 24', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 8, 24, 'Unit Test 3 - Section 24', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 8, 24, 'Final Exam - Section 24', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 9, 25, 'Unit Test 1 - Section 25', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 9, 25, 'Unit Test 2 - Section 25', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 9, 25, 'Mid Term Exam - Section 25', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 9, 25, 'Unit Test 3 - Section 25', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 9, 25, 'Final Exam - Section 25', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 9, 26, 'Unit Test 1 - Section 26', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 9, 26, 'Unit Test 2 - Section 26', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 9, 26, 'Mid Term Exam - Section 26', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 9, 26, 'Unit Test 3 - Section 26', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 9, 26, 'Final Exam - Section 26', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 9, 27, 'Unit Test 1 - Section 27', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 9, 27, 'Unit Test 2 - Section 27', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 9, 27, 'Mid Term Exam - Section 27', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 9, 27, 'Unit Test 3 - Section 27', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 9, 27, 'Final Exam - Section 27', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 10, 28, 'Unit Test 1 - Section 28', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 10, 28, 'Unit Test 2 - Section 28', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 10, 28, 'Mid Term Exam - Section 28', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 10, 28, 'Unit Test 3 - Section 28', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 10, 28, 'Final Exam - Section 28', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 10, 29, 'Unit Test 1 - Section 29', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 10, 29, 'Unit Test 2 - Section 29', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 10, 29, 'Mid Term Exam - Section 29', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 10, 29, 'Unit Test 3 - Section 29', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 10, 29, 'Final Exam - Section 29', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 6, 2, 10, 30, 'Unit Test 1 - Section 30', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 1, 7, 2, 10, 30, 'Unit Test 2 - Section 30', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 2, 1, 2, 10, 30, 'Mid Term Exam - Section 30', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 3, 8, 2, 10, 30, 'Unit Test 3 - Section 30', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 1, 5, 2, 2, 10, 30, 'Final Exam - Section 30', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE standard_subjects;
SET FOREIGN_KEY_CHECKS = 1;

-- ==========================================
-- Downtown Campus
-- ==========================================
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Uptown Campus
-- ==========================================
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Riverside Campus
-- ==========================================
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Hilltop Campus
-- ==========================================
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Greenfield Campus
-- ==========================================
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Seaside Campus
-- ==========================================
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Central Campus
-- ==========================================
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Lakeside Campus
-- ==========================================
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Sunrise Campus
-- ==========================================
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Maple Campus
-- ==========================================
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');



-- =============================================
-- TEST DATA FOR EXAM SUBJECTS AND ATTENDANCE
-- Coverage: 30 Sections, 150 Students, All Subjects
-- =============================================

-- 1. Populate exam_subjects
-- We will assign 3 subjects to each Mid Term/Final and 1 subject to Unit Tests.
-- Targeting sections 1 to 30 as defined in Final_SMS_DATA.sql

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
-- Standard 1 (Sections 1-3)
SELECT 1, e.id, s.id, 50, 20, '2025-05-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'ENG'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id = 1;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 50, 20, '2025-08-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'URD'
WHERE e.name LIKE 'Unit Test 2 - Section %' AND e.standard_id = 1;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 100, 40, '2025-10-20', '09:00:00', '12:00:00', 1
FROM exams e
JOIN subjects s ON s.code IN ('ENG', 'URD', 'BASIC_MATH')
WHERE e.name LIKE 'Mid Term Exam - Section %' AND e.standard_id = 1;

-- Standard 2-5 (Primary)
INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 50, 20, '2025-05-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'BASIC_MATH'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id BETWEEN 2 AND 5;

-- Standard 6-10 (Secondary)
INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 70, 30, '2025-05-20', '11:00:00', '13:00:00', 1
FROM exams e
JOIN subjects s ON s.code = 'PHY'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id BETWEEN 6 AND 10;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 100, 40, '2025-10-25', '09:00:00', '12:00:00', 1
FROM exams e
JOIN subjects s ON s.code IN ('ENG', 'PHY', 'CHEM')
WHERE e.name LIKE 'Mid Term Exam - Section %' AND e.standard_id BETWEEN 6 AND 10;

-- 2. Populate student_exam_attendance
-- We will mark attendance for all students in the corresponding sections
-- Status randomization: mostly PRESENT, some ABSENT/UFM

INSERT INTO student_exam_attendance (organization_id, exam_subject_id, student_id, status, created_by)
SELECT 
    1, 
    es.id, 
    s.id,
    CASE 
        WHEN RAND() > 0.1 THEN 'PRESENT' 
        WHEN RAND() > 0.05 THEN 'ABSENT'
        ELSE 'UFM' 
    END,
    1
FROM exam_subjects es
JOIN exams e ON es.exam_id = e.id
JOIN students s ON s.campus_id = e.campus_id 
    AND s.standard_id = e.standard_id 
    AND s.section_id = e.section_id
WHERE e.status != 'DRAFT';

-- Verification counts
SELECT 'Exam Subjects Created' as Category, COUNT(*) as Count FROM exam_subjects;
SELECT 'Attendance Records Created' as Category, COUNT(*) as Count FROM student_exam_attendance;








-- =============================================
-- TEST DATA FOR EXAM WEIGHTAGE
-- Coverage: All Standard Subjects for Academic Year 1
-- Distribution: 10% (T1), 25% (Mid), 10% (T2), 15% (Pre), 40% (Final)
-- =============================================

-- Populate exam_weightage
-- Linking each subject to all 5 terms with specific weightages

INSERT INTO exam_weightage (
    organization_id, 
    academic_year_id, 
    standard_subject_id, 
    exam_term_id, 
    weight_percentage, 
    created_by
)
SELECT 
    ss.organization_id, 
    ss.academic_year_id, 
    ss.id as standard_subject_id, 
    et.id as exam_term_id,
    -- Weight Distribution Logic
    CASE 
        WHEN et.sequence_no = 1 THEN 10.00 -- First Term
        WHEN et.sequence_no = 2 THEN 25.00 -- Mid Term
        WHEN et.sequence_no = 3 THEN 10.00 -- Second Term
        WHEN et.sequence_no = 4 THEN 15.00 -- Pre Final
        WHEN et.sequence_no = 5 THEN 40.00 -- Final Term
        ELSE 0 
    END as weight_percentage,
    1
FROM standard_subjects ss
CROSS JOIN exam_terms et
WHERE ss.academic_year_id = 1 
  AND et.academic_year_id = 1
  AND ss.deleted = FALSE;

-- Verification counts
SELECT 'Weightage Records Created' as Category, COUNT(*) as Count FROM exam_weightage;
SELECT 'Total Weightage Per Subject (Check for 100%)' as Category, standard_subject_id, SUM(weight_percentage) as Total 
FROM exam_weightage 
GROUP BY standard_subject_id;


INSERT INTO campus_financial_settings 
(
    institute_id, campus_id, academic_year_id, currency_id, language_id, locale, 
    allow_partial_payments, late_fee_applicable, late_fee_type, late_fee_fixed_amount, 
    late_fee_percentage, grace_days, late_fee_frequency, late_fee_max_amount, 
    late_fee_apply_on, send_payment_reminder, reminder_days_before_due, tax_type_id, 
    allow_refunds, refund_policy_url, refund_window_days, refund_type, 
    refund_percentage, refund_fixed_amount, invoice_mandatory, receipt_mandatory, 
    is_active, deleted, created_by
) 
VALUES
-- Campus 1: Main Campus
(1, 1, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 2: City Campus
(1, 2, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 3: North Campus
(1, 3, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 4: South Campus
(1, 4, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 5: East Campus
(1, 5, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 6: West Campus
(1, 6, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 7: Elite Campus
(1, 7, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 2000.00, 0.00, 3, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 15, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 60, 'FIXED', 0.00, 2000.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 8: Professional Campus
(1, 8, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1500.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 30, 'FIXED', 0.00, 1500.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 9: Digital Campus
(1, 9, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 500.00, 0.00, 7, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 7, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 20, 'FIXED', 0.00, 500.00, TRUE, TRUE, TRUE, FALSE, 1),
-- Campus 10: Model Campus
(1, 10, (SELECT id FROM academic_years WHERE code='AY2025' LIMIT 1), (SELECT id FROM currencies WHERE iso_code='PKR' LIMIT 1), (SELECT id FROM languages WHERE iso_code='en' LIMIT 1), 'en-PK', 
 TRUE, TRUE, 'FIXED', 1000.00, 0.00, 5, 'ONE_TIME', 0.00, 'OUTSTANDING', TRUE, 10, (SELECT id FROM tax_types WHERE code='PK_TAX' LIMIT 1), 
 TRUE, NULL, 40, 'FIXED', 0.00, 1000.00, TRUE, TRUE, TRUE, FALSE, 1);