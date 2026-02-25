INSERT INTO academic_years
(name, code, start_date, end_date, total_months, is_current, status, organization_id)
VALUES
('Academic Year 2025-2026', 'AY2025', '2025-04-01', '2026-03-31', 12, TRUE, 'ACTIVE', 1);

-- ============================================================
-- Lookup Data: Languages
-- ============================================================
INSERT INTO languages (iso_code, name, is_active, is_deleted, created_at, created_by) VALUES
('aa', 'Afar', TRUE, FALSE, NOW(), 1),
('ab', 'Abkhaz', TRUE, FALSE, NOW(), 1),
('af', 'Afrikaans', TRUE, FALSE, NOW(), 1),
('ak', 'Akan', TRUE, FALSE, NOW(), 1),
('am', 'Amharic', TRUE, FALSE, NOW(), 1),
('an', 'Aragonese', TRUE, FALSE, NOW(), 1),
('ar', 'Arabic', TRUE, FALSE, NOW(), 1),
('as', 'Assamese', TRUE, FALSE, NOW(), 1),
('av', 'Avaric', TRUE, FALSE, NOW(), 1),
('ay', 'Aymara', TRUE, FALSE, NOW(), 1),
('az', 'Azerbaijani', TRUE, FALSE, NOW(), 1),
('ba', 'Bashkir', TRUE, FALSE, NOW(), 1),
('be', 'Belarusian', TRUE, FALSE, NOW(), 1),
('bg', 'Bulgarian', TRUE, FALSE, NOW(), 1),
('bh', 'Bihari', TRUE, FALSE, NOW(), 1),
('bi', 'Bislama', TRUE, FALSE, NOW(), 1),
('bn', 'Bengali', TRUE, FALSE, NOW(), 1),
('bo', 'Tibetan', TRUE, FALSE, NOW(), 1),
('br', 'Breton', TRUE, FALSE, NOW(), 1),
('bs', 'Bosnian', TRUE, FALSE, NOW(), 1),
('ca', 'Catalan', TRUE, FALSE, NOW(), 1),
('ch', 'Chamorro', TRUE, FALSE, NOW(), 1),
('co', 'Corsican', TRUE, FALSE, NOW(), 1),
('cs', 'Czech', TRUE, FALSE, NOW(), 1),
('cy', 'Welsh', TRUE, FALSE, NOW(), 1),
('da', 'Danish', TRUE, FALSE, NOW(), 1),
('de', 'German', TRUE, FALSE, NOW(), 1),
('dv', 'Divehi', TRUE, FALSE, NOW(), 1),
('dz', 'Dzongkha', TRUE, FALSE, NOW(), 1),
('el', 'Greek', TRUE, FALSE, NOW(), 1),
('en', 'English', TRUE, FALSE, NOW(), 1),
('eo', 'Esperanto', TRUE, FALSE, NOW(), 1),
('es', 'Spanish', TRUE, FALSE, NOW(), 1),
('et', 'Estonian', TRUE, FALSE, NOW(), 1),
('eu', 'Basque', TRUE, FALSE, NOW(), 1),
('fa', 'Persian', TRUE, FALSE, NOW(), 1),
('ff', 'Fulah', TRUE, FALSE, NOW(), 1),
('fi', 'Finnish', TRUE, FALSE, NOW(), 1),
('fj', 'Fijian', TRUE, FALSE, NOW(), 1),
('fo', 'Faroese', TRUE, FALSE, NOW(), 1),
('fr', 'French', TRUE, FALSE, NOW(), 1),
('fy', 'Western Frisian', TRUE, FALSE, NOW(), 1),
('ga', 'Irish', TRUE, FALSE, NOW(), 1),
('gd', 'Scottish Gaelic', TRUE, FALSE, NOW(), 1),
('gl', 'Galician', TRUE, FALSE, NOW(), 1),
('gn', 'Guarani', TRUE, FALSE, NOW(), 1),
('gu', 'Gujarati', TRUE, FALSE, NOW(), 1),
('gv', 'Manx', TRUE, FALSE, NOW(), 1),
('ha', 'Hausa', TRUE, FALSE, NOW(), 1),
('he', 'Hebrew', TRUE, FALSE, NOW(), 1),
('hi', 'Hindi', TRUE, FALSE, NOW(), 1),
('ho', 'Hiri Motu', TRUE, FALSE, NOW(), 1),
('hr', 'Croatian', TRUE, FALSE, NOW(), 1),
('ht', 'Haitian Creole', TRUE, FALSE, NOW(), 1),
('hu', 'Hungarian', TRUE, FALSE, NOW(), 1),
('hy', 'Armenian', TRUE, FALSE, NOW(), 1),
('ia', 'Interlingua', TRUE, FALSE, NOW(), 1),
('id', 'Indonesian', TRUE, FALSE, NOW(), 1),
('ie', 'Interlingue', TRUE, FALSE, NOW(), 1),
('ig', 'Igbo', TRUE, FALSE, NOW(), 1),
('ii', 'Nuosu', TRUE, FALSE, NOW(), 1),
('ik', 'Inupiaq', TRUE, FALSE, NOW(), 1),
('io', 'Ido', TRUE, FALSE, NOW(), 1),
('is', 'Icelandic', TRUE, FALSE, NOW(), 1),
('it', 'Italian', TRUE, FALSE, NOW(), 1),
('iu', 'Inuktitut', TRUE, FALSE, NOW(), 1),
('ja', 'Japanese', TRUE, FALSE, NOW(), 1),
('jv', 'Javanese', TRUE, FALSE, NOW(), 1),
('ka', 'Georgian', TRUE, FALSE, NOW(), 1),
('kg', 'Kongo', TRUE, FALSE, NOW(), 1),
('ki', 'Kikuyu', TRUE, FALSE, NOW(), 1),
('kk', 'Kazakh', TRUE, FALSE, NOW(), 1),
('kl', 'Greenlandic', TRUE, FALSE, NOW(), 1),
('km', 'Central Khmer', TRUE, FALSE, NOW(), 1),
('kn', 'Kannada', TRUE, FALSE, NOW(), 1),
('ko', 'Korean', TRUE, FALSE, NOW(), 1),
('kr', 'Kanuri', TRUE, FALSE, NOW(), 1),
('ks', 'Kashmiri', TRUE, FALSE, NOW(), 1),
('ku', 'Kurdish', TRUE, FALSE, NOW(), 1),
('kv', 'Komi', TRUE, FALSE, NOW(), 1),
('kw', 'Cornish', TRUE, FALSE, NOW(), 1),
('ky', 'Kyrgyz', TRUE, FALSE, NOW(), 1),
('la', 'Latin', TRUE, FALSE, NOW(), 1),
('lb', 'Luxembourgish', TRUE, FALSE, NOW(), 1),
('ln', 'Lingala', TRUE, FALSE, NOW(), 1),
('lo', 'Lao', TRUE, FALSE, NOW(), 1),
('lt', 'Lithuanian', TRUE, FALSE, NOW(), 1),
('lv', 'Latvian', TRUE, FALSE, NOW(), 1),
('mg', 'Malagasy', TRUE, FALSE, NOW(), 1),
('mh', 'Marshallese', TRUE, FALSE, NOW(), 1),
('mi', 'Māori', TRUE, FALSE, NOW(), 1),
('mk', 'Macedonian', TRUE, FALSE, NOW(), 1),
('ml', 'Malayalam', TRUE, FALSE, NOW(), 1),
('mn', 'Mongolian', TRUE, FALSE, NOW(), 1),
('mr', 'Marathi', TRUE, FALSE, NOW(), 1),
('ms', 'Malay', TRUE, FALSE, NOW(), 1),
('mt', 'Maltese', TRUE, FALSE, NOW(), 1),
('my', 'Burmese', TRUE, FALSE, NOW(), 1),
('na', 'Nauru', TRUE, FALSE, NOW(), 1),
('nb', 'Norwegian Bokmål', TRUE, FALSE, NOW(), 1),
('nd', 'North Ndebele', TRUE, FALSE, NOW(), 1),
('ne', 'Nepali', TRUE, FALSE, NOW(), 1),
('ng', 'Ndonga', TRUE, FALSE, NOW(), 1),
('nl', 'Dutch', TRUE, FALSE, NOW(), 1),
('nn', 'Norwegian Nynorsk', TRUE, FALSE, NOW(), 1),
('no', 'Norwegian', TRUE, FALSE, NOW(), 1),
('nr', 'South Ndebele', TRUE, FALSE, NOW(), 1),
('nv', 'Navajo', TRUE, FALSE, NOW(), 1),
('ny', 'Chichewa', TRUE, FALSE, NOW(), 1),
('oc', 'Occitan', TRUE, FALSE, NOW(), 1),
('oj', 'Ojibwa', TRUE, FALSE, NOW(), 1),
('om', 'Oromo', TRUE, FALSE, NOW(), 1),
('or', 'Oriya', TRUE, FALSE, NOW(), 1),
('os', 'Ossetian', TRUE, FALSE, NOW(), 1),
('pa', 'Punjabi', TRUE, FALSE, NOW(), 1),
('pi', 'Pāli', TRUE, FALSE, NOW(), 1),
('pl', 'Polish', TRUE, FALSE, NOW(), 1),
('ps', 'Pashto', TRUE, FALSE, NOW(), 1),
('pt', 'Portuguese', TRUE, FALSE, NOW(), 1),
('qu', 'Quechua', TRUE, FALSE, NOW(), 1),
('rm', 'Romansh', TRUE, FALSE, NOW(), 1),
('rn', 'Kirundi', TRUE, FALSE, NOW(), 1),
('ro', 'Romanian', TRUE, FALSE, NOW(), 1),
('ru', 'Russian', TRUE, FALSE, NOW(), 1),
('rw', 'Kinyarwanda', TRUE, FALSE, NOW(), 1),
('sa', 'Sanskrit', TRUE, FALSE, NOW(), 1),
('sc', 'Sardinian', TRUE, FALSE, NOW(), 1),
('sd', 'Sindhi', TRUE, FALSE, NOW(), 1),
('se', 'Northern Sami', TRUE, FALSE, NOW(), 1),
('sg', 'Sango', TRUE, FALSE, NOW(), 1),
('si', 'Sinhala', TRUE, FALSE, NOW(), 1),
('sk', 'Slovak', TRUE, FALSE, NOW(), 1),
('sl', 'Slovenian', TRUE, FALSE, NOW(), 1),
('sm', 'Samoan', TRUE, FALSE, NOW(), 1),
('sn', 'Shona', TRUE, FALSE, NOW(), 1),
('so', 'Somali', TRUE, FALSE, NOW(), 1),
('sq', 'Albanian', TRUE, FALSE, NOW(), 1),
('sr', 'Serbian', TRUE, FALSE, NOW(), 1),
('ss', 'Swati', TRUE, FALSE, NOW(), 1),
('st', 'Southern Sotho', TRUE, FALSE, NOW(), 1),
('su', 'Sundanese', TRUE, FALSE, NOW(), 1),
('sv', 'Swedish', TRUE, FALSE, NOW(), 1),
('sw', 'Swahili', TRUE, FALSE, NOW(), 1),
('ta', 'Tamil', TRUE, FALSE, NOW(), 1),
('te', 'Telugu', TRUE, FALSE, NOW(), 1),
('tg', 'Tajik', TRUE, FALSE, NOW(), 1),
('th', 'Thai', TRUE, FALSE, NOW(), 1),
('ti', 'Tigrinya', TRUE, FALSE, NOW(), 1),
('tk', 'Turkmen', TRUE, FALSE, NOW(), 1),
('tl', 'Tagalog', TRUE, FALSE, NOW(), 1),
('tn', 'Tswana', TRUE, FALSE, NOW(), 1),
('to', 'Tongan', TRUE, FALSE, NOW(), 1),
('tr', 'Turkish', TRUE, FALSE, NOW(), 1),
('ts', 'Tsonga', TRUE, FALSE, NOW(), 1),
('tt', 'Tatar', TRUE, FALSE, NOW(), 1),
('tw', 'Twi', TRUE, FALSE, NOW(), 1),
('ty', 'Tahitian', TRUE, FALSE, NOW(), 1),
('ug', 'Uighur', TRUE, FALSE, NOW(), 1),
('uk', 'Ukrainian', TRUE, FALSE, NOW(), 1),
('ur', 'Urdu', TRUE, FALSE, NOW(), 1),
('uz', 'Uzbek', TRUE, FALSE, NOW(), 1),
('ve', 'Venda', TRUE, FALSE, NOW(), 1),
('vi', 'Vietnamese', TRUE, FALSE, NOW(), 1),
('vo', 'Volapük', TRUE, FALSE, NOW(), 1),
('wa', 'Walloon', TRUE, FALSE, NOW(), 1),
('wo', 'Wolof', TRUE, FALSE, NOW(), 1),
('xh', 'Xhosa', TRUE, FALSE, NOW(), 1),
('yi', 'Yiddish', TRUE, FALSE, NOW(), 1),
('yo', 'Yoruba', TRUE, FALSE, NOW(), 1),
('za', 'Zhuang', TRUE, FALSE, NOW(), 1),
('zh', 'Chinese', TRUE, FALSE, NOW(), 1),
('zu', 'Zulu', TRUE, FALSE, NOW(), 1);
-- ==========================================
-- EMPLOYEE MASTER DATA (Required before system_users)
-- ==========================================
INSERT INTO employee_master
(organization_id, employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date, probation_end_date, primary_phone, email, active, created_by)
VALUES
(1, 'EMP001', 'Uzair', 'Anwar', 'Uzair Anwar', 'MALE', '1990-05-12', 'SINGLE', '2022-01-10', '2022-07-10', '03001234567', 'uzair.anwar@example.com', TRUE, 1),
(1, 'EMP002', 'Ayesha', 'Khan', 'Ayesha Khan', 'FEMALE', '1988-11-25', 'MARRIED', '2021-06-15', '2021-12-15', '03009876543', 'ayesha.khan@example.com', TRUE, 1),
(1, 'EMP003', 'Ali', 'Raza', 'Ali Raza', 'MALE', '1992-03-30', 'SINGLE', '2023-03-01', '2023-09-01', '03004567890', 'ali.raza@example.com', TRUE, 1);

-- ==========================================
-- SYSTEM USERS WITH USER TYPE
-- ==========================================
INSERT INTO system_users
(organization_id, username, email, phone, password_hash, employee_id, student_id, user_type, is_active, is_verified, created_at, updated_at)
VALUES
-- Admin User (No employee or student link)
(1, 'admin.user', 'admin@gmail.com', '03001234567',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'ADMIN', TRUE, TRUE, NOW(), NOW()),

-- Employee User (Teacher) - References employee_id 1 (Uzair Anwar)
(1, 'teacher.user', 'teacher@example.com', '03007654321',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 1, NULL, 'EMPLOYEE', TRUE, FALSE, NOW(), NOW()),

-- Employee User (HR Officer) - References employee_id 2 (Ayesha Khan)
(1, 'hr.officer', 'hr.officer@example.com', '03012345678',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 2, NULL, 'EMPLOYEE', TRUE, FALSE, NOW(), NOW()),

-- Student User (No employee link)
(1, 'student.user', 'student@example.com', '03111223344',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'STUDENT', TRUE, FALSE, NOW(), NOW()),

-- Student User (No employee link)
(1, 'ayesha.student', 'ayesha.student@example.com', '03117654321',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'STUDENT', TRUE, FALSE, NOW(), NOW());


INSERT INTO actions(code, name, description, is_active, created_by, deleted)
VALUES
-- Core CRUD
('VIEW', 'View', 'Read access to the resource', TRUE, 1, FALSE),
('CREATE', 'Create', 'Ability to create new records', TRUE, 1, FALSE),
('UPDATE', 'Update', 'Ability to modify existing records', TRUE, 1, FALSE),
('DELETE', 'Delete', 'Ability to remove records', TRUE, 1, FALSE),

-- Workflow & Utility
('APPROVE', 'Approve', 'Ability to approve workflows', TRUE, 1, FALSE),
('EXPORT', 'Export', 'Ability to export data to Excel or PDF', TRUE, 1, FALSE),
('IMPORT', 'Import', 'Ability to import data from files', TRUE, 1, FALSE),

-- Management
('ASSIGN', 'Assign', 'Assign roles or resources', TRUE, 1, FALSE),
('UNASSIGN', 'Unassign', 'Remove assigned roles or resources', TRUE, 1, FALSE),

-- System Control
('ACTIVATE', 'Activate', 'Activate a disabled record', TRUE, 1, FALSE),
('DEACTIVATE', 'Deactivate', 'Deactivate an active record', TRUE, 1, FALSE);


-- ==========================================
-- MODULES
-- ==========================================
INSERT INTO modules(code,name,description,icon,route,display_order,system_module,active,created_at,created_by)
VALUES
-- Identity & Access Management
('DASHBOARD', 'Dashboard', 'System overview and analytics', 'dashboard', '/dashboard', 1, TRUE, TRUE, NOW(), 1),
('IAM', 'Identity & Access', 'Users, roles, permissions & security', 'security', '/iam', 2, TRUE, TRUE, NOW(), 1),

-- Student Management
('STUDENT', 'Student Management', 'Student profiles, admission & attendance', 'groups', '/students', 3, FALSE, TRUE, NOW(), 1),

-- Student Fees & Payments
('FEE', 'Fee Management', 'Fee structure, payments & summaries', 'payments', '/fees', 4, FALSE, TRUE, NOW(), 1),

-- Academic Structure
('ACADEMIC', 'Academic Management', 'Classes, sections, subjects & curriculum', 'school', '/academics', 5, FALSE, TRUE, NOW(), 1),

-- Assessment & Examination
('EXAM', 'Examinations', 'Assessments, grading & results', 'assignment', '/exams', 6, FALSE, TRUE, NOW(), 1),

-- Institute Management
('INSTITUTE', 'Institute Management', 'Institute profile, campuses & offerings', 'apartment', '/institute', 7, TRUE, TRUE, NOW(), 1),

-- Administration & Governance
('ADMINISTRATION', 'Administration & Governance', 'Departments, designations & boards', 'account_balance', '/administration', 8, TRUE, TRUE, NOW(), 1),

-- Employee & Payroll
('EMPLOYEE', 'Employee Management', 'Employees, salaries & payroll periods', 'badge', '/employees', 9, FALSE, TRUE, NOW(), 1),

-- Finance & Operations
('FINANCE', 'Finance & Operations', 'Expenses, banks & inventory', 'account_balance_wallet', '/finance', 10, FALSE, TRUE, NOW(), 1),

-- Discounts & Tax
('PRICING', 'Discounts & Tax', 'Discounts, tax rules & pricing models', 'percent', '/pricing', 11, TRUE, TRUE, NOW(), 1),

-- Reference / Master Data
('MASTERDATA', 'Master Data', 'Countries, currencies, boards & lookups', 'storage', '/master-data', 12, TRUE, TRUE, NOW(), 1),

-- System Configuration
('SETTINGS', 'System Settings', 'Rules, themes & configuration', 'settings', '/settings', 13, TRUE, TRUE, NOW(), 1),

-- Reporting & Analytics
('REPORTS', 'Reports & Analytics', 'Academic, financial & system reports', 'bar_chart', '/reports', 14, TRUE, TRUE, NOW(), 1),

-- Future Modules
('COMMUNICATION', 'Communication', 'SMS, Email, Notifications & Announcements', 'campaign', '/communication', 15, TRUE, TRUE, NOW(), 1),
('TRANSPORT', 'Transport Management', 'Routes, vehicles & student transport', 'directions_bus', '/transport', 16, FALSE, TRUE, NOW(), 1),
('HOSTEL', 'Hostel Management', 'Rooms, allocations & hostel fees', 'home', '/hostel', 17, FALSE, TRUE, NOW(), 1),
('LIBRARY', 'Library Management', 'Books, members & issue tracking', 'library_books', '/library', 18, FALSE, TRUE, NOW(), 1),
('ALUMNI', 'Alumni Management', 'Alumni records & engagement', 'diversity_3', '/alumni', 19, FALSE, TRUE, NOW(), 1);

-- ==========================================
-- RESOURCES
-- ==========================================

-- IAM / Security
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='IAM'), 'IAM_AUTH_LOGIN', 'Login', '/sms/auth', 'POST', 'User login'),

-- Users
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_SEARCH', 'Search Users', '/api/v1/users/search', 'GET', 'Search system users'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_ASSIGN_ROLE', 'Assign Roles', '/api/v1/users/{userId}/roles', 'PUT', 'Assign roles to user'),

-- Roles
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_CREATE', 'Create Role', '/api/v1/roles', 'POST', 'Create role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_VIEW', 'View Roles', '/api/v1/roles/organization/{organizationId}', 'GET', 'List roles'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_UPDATE', 'Update Role', '/api/v1/roles/{id}/organization/{organizationId}', 'PUT', 'Update role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_DELETE', 'Delete Role', '/api/v1/roles/{id}/organization/{organizationId}', 'DELETE', 'Delete role'),

-- Permissions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_CREATE', 'Create Permission', '/api/v1/permissions', 'POST', 'Create permission'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_VIEW', 'View Permissions', '/api/v1/permissions/organization/{organizationId}', 'GET', 'List permissions'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_UPDATE', 'Update Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'PUT', 'Update permission'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_DELETE', 'Delete Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'DELETE', 'Delete permission'),

-- Role Permission
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_ASSIGN', 'Assign Permission', '/api/role-permissions/assign', 'POST', 'Assign permission to role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_VIEW', 'View Role Permissions', '/api/role-permissions/role/{roleId}', 'GET', 'View role permissions'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_REMOVE', 'Remove Permission', '/api/role-permissions/role/{roleId}/permission/{permissionId}', 'DELETE', 'Remove permission'),

-- Modules / Resources / Actions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_MODULE_MANAGE', 'Manage Modules', '/api/v1/modules', 'POST', 'Create module'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_RESOURCE_MANAGE', 'Manage Resources', '/api/v1/resources', 'POST', 'Create resource'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ACTION_MANAGE', 'Manage Actions', '/api/v1/actions', 'POST', 'Create action');

-- STUDENT Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_CREATE', 'Create Student', '/api/institute/students', 'POST', 'Create student'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW', 'View Students', '/api/institute/students', 'GET', 'List students'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW_DETAIL', 'View Student Detail', '/api/institute/students/{id}', 'GET', 'Student details'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_UPDATE', 'Update Student', '/api/institute/students/{id}', 'PUT', 'Update student'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_SEARCH', 'Search Students', '/api/institute/students/search', 'GET', 'Search students'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DASHBOARD_VIEW', 'Student Dashboard', '/api/institute/students/dashboard', 'GET', 'Student dashboard'),

-- Student Documents
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_UPLOAD', 'Upload Document', '/api/institute/students/upload-document', 'POST', 'Upload document'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_VIEW', 'View Documents', '/api/institute/students/{studentId}/documents', 'GET', 'View documents'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_DOWNLOAD', 'Download Document', '/api/institute/students/download-document/{documentId}', 'GET', 'Download document'),

-- Attendance
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_MARK', 'Mark Attendance', '/api/student/attendance/create', 'POST', 'Mark attendance'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_VIEW', 'View Attendance', '/api/student/attendance/getbystudent/{id}', 'GET', 'View attendance');

-- FEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='FEE'), 'FEE_ASSIGN', 'Assign Fee', '/api/students/{studentId}/fees/assign', 'POST', 'Assign fee'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_UPDATE', 'Update Fee', '/api/students/{studentId}/fees/update', 'PUT', 'Update assigned fee'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_PAYMENT_CREATE', 'Pay Fee', '/api/students/fee/payments', 'POST', 'Fee payment'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_SUMMARY_VIEW', 'Fee Summary', '/api/students/fee/summary', 'GET', 'Fee summary'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ASSIGN', 'Assign Discount', '/api/school/discounts/student', 'POST', 'Assign student discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_UPDATE', 'Update Discount', '/api/school/discounts/student/{assignmentId}', 'PUT', 'Update discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ACTIVATE', 'Activate Discount', '/api/school/discounts/student/{assignmentId}/activate', 'PATCH', 'Activate discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_DEACTIVATE', 'Deactivate Discount', '/api/school/discounts/student/{assignmentId}/deactivate', 'PATCH', 'Deactivate discount');

-- ACADEMIC Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_CLASS_MANAGE', 'Manage Classes', '/api/classes', 'POST', 'Manage classes'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_STANDARD_MANAGE', 'Manage Standards', '/api/standards', 'POST', 'Manage standards'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SECTION_MANAGE', 'Manage Sections', '/api/sections', 'POST', 'Manage sections'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_ASSIGN', 'Assign Subject', '/api/standard-subjects', 'POST', 'Assign subject'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_TIMETABLE_MANAGE', 'Manage Timetable', '/api/timetable', 'POST', 'Manage timetable'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_YEAR_MANAGE', 'Academic Year', '/api/academic-years', 'POST', 'Manage academic years'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_MANAGE', 'Academic Subjects', '/api/academic-subjects', 'POST', 'Manage subjects');

-- EXAM Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_ASSESSMENT_CREATE', 'Create Assessment', '/api/assessments', 'POST', 'Create assessment'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_MCQ_MANAGE', 'Manage MCQs', '/api/mcqs', 'POST', 'Manage MCQs'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_PUBLISH', 'Publish Result', '/api/results', 'POST', 'Publish result'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_VIEW', 'View Results', '/api/results', 'GET', 'View results'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_GRADING_MANAGE', 'Grading System', '/api/marks-grading', 'POST', 'Manage grading system'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_FAIL_CRITERIA_MANAGE', 'Fail Criteria', '/api/fail-criteria', 'POST', 'Manage fail criteria');

-- INSTITUTE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_PROFILE_UPDATE', 'Update Institute', '/api/institute', 'PUT', 'Update institute'),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_UPLOAD', 'Upload Institute Document', '/api/institute/documents', 'POST', 'Upload institute document'),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_DOWNLOAD', 'Download Institute Document', '/api/institute/documents/{documentId}', 'GET', 'Download institute document');

-- ADMINISTRATION Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='ADMINISTRATION'), 'ADMIN_CONTACT_MANAGE', 'Institute Contacts', '/api/institute/contacts', 'POST', 'Manage institute contacts');

-- EMPLOYEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_CREATE', 'Create Employee', '/api/employees', 'POST', 'Create employee'),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_SALARY_PAY', 'Salary Payment', '/api/salaries/pay', 'POST', 'Pay employee salary'),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_HISTORY_VIEW', 'Employee History', '/api/employees/history', 'GET', 'View employee history');

-- FINANCE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='FINANCE'), 'FINANCE_EXPENSE_CREATE', 'Create Expense', '/api/schools/expenses', 'POST', 'Create expense');

-- MASTERDATA Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='MASTERDATA'), 'MASTERDATA_COUNTRY_VIEW', 'View Countries', '/api/countries', 'GET', 'List countries');

-- REPORTS Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ATTENDANCE', 'Attendance Report', '/api/attendance/report', 'GET', 'Attendance reports'),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_FEE', 'Fee Report', '/api/students/fee/report', 'GET', 'Fee reports'),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ACADEMIC', 'Academic Report', '/api/academics/report', 'GET', 'Academic reports');





INSERT INTO school_types (code, name, description, is_active, is_deleted) VALUES
('PUBLIC', 'Public School', 'Funded and operated by the government, free for students.', TRUE, FALSE),
('PRIVATE', 'Private School', 'Privately funded school, requires tuition fees.', TRUE, FALSE),
('CHARTER', 'Charter School', 'Publicly funded independent school with special curriculum.', TRUE, FALSE),
('TRUST', 'Trust School', 'Managed by charitable trusts or foundations.', TRUE, FALSE),
('INTERNATIONAL', 'International School', 'Follows international curriculum like IB or Cambridge.', TRUE, FALSE),
('GOVERNMENT', 'Government School', 'Directly run by local or federal government authorities.', TRUE, FALSE),
('MONTESSORI', 'Montessori School', 'Focuses on child-led learning and early education.', TRUE, FALSE),
('VOCATIONAL', 'Vocational School', 'Specializes in skill-based education for trades and professions.', TRUE, FALSE);


INSERT INTO fee_recurrence_rules(code, name, description, is_active, is_deleted, created_by)
VALUES
('ONE_TIME', 'One Time', 'Fee charged only once (e.g., admission or registration fee)', TRUE, FALSE, 1),
('MONTHLY', 'Monthly', 'Fee charged every month (common for tuition fees)', TRUE, FALSE, 1),
('QUARTERLY', 'Quarterly', 'Fee charged every three months', TRUE, FALSE, 1),
('HALF_YEARLY', 'Half Yearly', 'Fee charged twice in an academic year',TRUE, FALSE, 1),
('ANNUAL', 'Annual', 'Fee charged once per academic year',TRUE, FALSE, 1),
('PER_TERM', 'Per Term', 'Fee charged per academic term or semester', TRUE, FALSE, 1),
('ON_DEMAND', 'On Demand', 'Fee charged when a service is used (transport, lab, activity)', TRUE, FALSE, 1);


INSERT INTO roles(organization_id,code,name,description,is_system_role,active,deleted,created_by,created_at)
VALUES
(1, 'MASTER_ADMIN', 'Master Administrator', 'Alias of SUPER_ADMIN', TRUE, TRUE, FALSE, 1, NOW()),
(1, 'SUPER_ADMIN', 'Super Administrator', 'Full system access across all modules and organizations',TRUE, TRUE, FALSE, 1, NOW()),
(1, 'ORG_ADMIN', 'Organization Administrator', 'Manages institute-level configuration, campuses, and users',TRUE, TRUE, FALSE, 1, NOW()),
-- ===============================
-- ACADEMIC LEADERSHIP
-- ===============================
(1, 'PRINCIPAL', 'Principal', 'Overall academic and administrative head of the school',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'VICE_PRINCIPAL', 'Vice Principal', 'Assists principal in academic and disciplinary matters',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'HEAD_OF_DEPARTMENT', 'Head of Department', 'Manages academic department and teaching staff', FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- TEACHING STAFF
-- ===============================
(1, 'TEACHER', 'Teacher', 'Teaches assigned classes and manages student academics',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'CLASS_TEACHER', 'Class Teacher', 'Responsible for a specific class and student coordination',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'SUBSTITUTE_TEACHER', 'Substitute Teacher', 'Temporary teacher assigned to cover classes',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- STUDENT & PARENT PORTALS
-- ===============================
(1, 'STUDENT', 'Student', 'Student portal access for academics, attendance, and fees',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'PARENT', 'Parent / Guardian', 'Parent portal access to monitor student progress and fees',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- ADMISSIONS & EXAMINATION
-- ===============================
(1, 'ADMISSIONS_OFFICER', 'Admissions Officer', 'Handles student admissions and enrollment process',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'EXAM_CONTROLLER', 'Examination Controller', 'Manages exams, grading, and result publication',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'EXAMINER', 'Examiner', 'Creates exams and evaluates student performance',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- FINANCE & ACCOUNTS
-- ===============================
(1, 'ACCOUNTANT', 'Accountant', 'Manages fee collection, payments, and accounting reports',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'FINANCE_MANAGER', 'Finance Manager', 'Oversees financial operations and approvals',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'FEE_COLLECTION_OFFICER', 'Fee Collection Officer', 'Handles daily fee collection and receipts',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- HR & PAYROLL
-- ===============================
(1, 'HR_MANAGER', 'HR Manager', 'Manages employees, payroll, and HR policies',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'HR_OFFICER', 'HR Officer', 'Handles employee records, attendance, and documentation',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'PAYROLL_OFFICER', 'Payroll Officer', 'Processes salaries and payroll cycles',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- IT & SUPPORT
-- ===============================
(1, 'IT_ADMIN', 'IT Administrator', 'Manages system configuration, users, and technical support',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'SUPPORT_STAFF', 'Support Staff', 'Limited access for operational and support activities',FALSE, TRUE, FALSE, 1, NOW());



-- Batch 1: Countries 1–50
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1,'AF','Afghanistan','AFG','+93', NOW(), 1, NULL, NULL, NULL, NULL),
(2,'AL','Albania','ALB','+355', NOW(), 1, NULL, NULL, NULL, NULL),
(3,'DZ','Algeria','DZA','+213', NOW(), 1, NULL, NULL, NULL, NULL),
(4,'AD','Andorra','AND','+376', NOW(), 1, NULL, NULL, NULL, NULL),
(5,'AO','Angola','AGO','+244', NOW(), 1, NULL, NULL, NULL, NULL),
(6,'AR','Argentina','ARG','+54', NOW(), 1, NULL, NULL, NULL, NULL),
(7,'AM_','Armenia','ARM','+374', NOW(), 1, NULL, NULL, NULL, NULL),
(8,'AU','Australia','AUS','+61', NOW(), 1, NULL, NULL, NULL, NULL),
(9,'AT','Austria','AUT','+43', NOW(), 1, NULL, NULL, NULL, NULL),
(10,'AZ','Azerbaijan','AZE','+994', NOW(), 1, NULL, NULL, NULL, NULL),
(11,'BH','Bahrain','BHR','+973', NOW(), 1, NULL, NULL, NULL, NULL),
(12,'BD','Bangladesh','BGD','+880', NOW(), 1, NULL, NULL, NULL, NULL),
(13,'BY','Belarus','BLR','+375', NOW(), 1, NULL, NULL, NULL, NULL),
(14,'BE','Belgium','BEL','+32', NOW(), 1, NULL, NULL, NULL, NULL),
(15,'BZ','Belize','BLZ','+501', NOW(), 1, NULL, NULL, NULL, NULL),
(16,'BJ','Benin','BEN','+229', NOW(), 1, NULL, NULL, NULL, NULL),
(17,'BT','Bhutan','BTN','+975', NOW(), 1, NULL, NULL, NULL, NULL),
(18,'BO','Bolivia','BOL','+591', NOW(), 1, NULL, NULL, NULL, NULL),
(19,'BA','Bosnia and Herzegovina','BIH','+387', NOW(), 1, NULL, NULL, NULL, NULL),
(20,'BW','Botswana','BWA','+267', NOW(), 1, NULL, NULL, NULL, NULL),
(21,'BR','Brazil','BRA','+55', NOW(), 1, NULL, NULL, NULL, NULL),
(22,'BN','Brunei','BRN','+673', NOW(), 1, NULL, NULL, NULL, NULL),
(23,'BG','Bulgaria','BGR','+359', NOW(), 1, NULL, NULL, NULL, NULL),
(24,'BF','Burkina Faso','BFA','+226', NOW(), 1, NULL, NULL, NULL, NULL),
(25,'BI','Burundi','BDI','+257', NOW(), 1, NULL, NULL, NULL, NULL),
(26,'KH','Cambodia','KHM','+855', NOW(), 1, NULL, NULL, NULL, NULL),
(27,'CM','Cameroon','CMR','+237', NOW(), 1, NULL, NULL, NULL, NULL),
(28,'CA','Canada','CAN','+1', NOW(), 1, NULL, NULL, NULL, NULL),
(29,'CV','Cape Verde','CPV','+238', NOW(), 1, NULL, NULL, NULL, NULL),
(30,'CF','Central African Republic','CAF','+236', NOW(), 1, NULL, NULL, NULL, NULL),
(31,'TD','Chad','TCD','+235', NOW(), 1, NULL, NULL, NULL, NULL),
(32,'CL','Chile','CHL','+56', NOW(), 1, NULL, NULL, NULL, NULL),
(33,'CN','China','CHN','+86', NOW(), 1, NULL, NULL, NULL, NULL),
(34,'CO','Colombia','COL','+57', NOW(), 1, NULL, NULL, NULL, NULL),
(35,'KM','Comoros','COM','+269', NOW(), 1, NULL, NULL, NULL, NULL),
(36,'CG','Congo','COG','+242', NOW(), 1, NULL, NULL, NULL, NULL),
(37,'CR','Costa Rica','CRI','+506', NOW(), 1, NULL, NULL, NULL, NULL),
(38,'HR','Croatia','HRV','+385', NOW(), 1, NULL, NULL, NULL, NULL),
(39,'CU','Cuba','CUB','+53', NOW(), 1, NULL, NULL, NULL, NULL),
(40,'CY','Cyprus','CYP','+357', NOW(), 1, NULL, NULL, NULL, NULL),
(41,'CZ','Czech Republic','CZE','+420', NOW(), 1, NULL, NULL, NULL, NULL),
(42,'DK','Denmark','DNK','+45', NOW(), 1, NULL, NULL, NULL, NULL),
(43,'DJ','Djibouti','DJI','+253', NOW(), 1, NULL, NULL, NULL, NULL),
(44,'DO','Dominican Republic','DOM','+1', NOW(), 1, NULL, NULL, NULL, NULL),
(45,'EC','Ecuador','ECU','+593', NOW(), 1, NULL, NULL, NULL, NULL),
(46,'EG','Egypt','EGY','+20', NOW(), 1, NULL, NULL, NULL, NULL),
(47,'SV','El Salvador','SLV','+503', NOW(), 1, NULL, NULL, NULL, NULL),
(48,'EE','Estonia','EST','+372', NOW(), 1, NULL, NULL, NULL, NULL),
(49,'ET','Ethiopia','ETH','+251', NOW(), 1, NULL, NULL, NULL, NULL),
(50,'FI','Finland','FIN','+358', NOW(), 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 2: Countries 51–100
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(51,'FR','France','FRA','+33', NOW(), 1, NULL, NULL, NULL, NULL),
(52,'GA','Gabon','GAB','+241', NOW(), 1, NULL, NULL, NULL, NULL),
(53,'GE','Georgia','GEO','+995', NOW(), 1, NULL, NULL, NULL, NULL),
(54,'DE','Germany','DEU','+49', NOW(), 1, NULL, NULL, NULL, NULL),
(55,'GH','Ghana','GHA','+233', NOW(), 1, NULL, NULL, NULL, NULL),
(56,'GR','Greece','GRC','+30', NOW(), 1, NULL, NULL, NULL, NULL),
(57,'GT','Guatemala','GTM','+502', NOW(), 1, NULL, NULL, NULL, NULL),
(58,'GN','Guinea','GIN','+224', NOW(), 1, NULL, NULL, NULL, NULL),
(59,'HT','Haiti','HTI','+509', NOW(), 1, NULL, NULL, NULL, NULL),
(60,'HN','Honduras','HND','+504', NOW(), 1, NULL, NULL, NULL, NULL),
(61,'HK','Hong Kong','HKG','+852', NOW(), 1, NULL, NULL, NULL, NULL),
(62,'HU','Hungary','HUN','+36', NOW(), 1, NULL, NULL, NULL, NULL),
(63,'IS','Iceland','ISL','+354', NOW(), 1, NULL, NULL, NULL, NULL),
(64,'IN','India','IND','+91', NOW(), 1, NULL, NULL, NULL, NULL),
(65,'ID','Indonesia','IDN','+62', NOW(), 1, NULL, NULL, NULL, NULL),
(66,'IR','Iran','IRN','+98', NOW(), 1, NULL, NULL, NULL, NULL),
(67,'IQ','Iraq','IRQ','+964', NOW(), 1, NULL, NULL, NULL, NULL),
(68,'IE','Ireland','IRL','+353', NOW(), 1, NULL, NULL, NULL, NULL),
(69,'IL','Israel','ISR','+972', NOW(), 1, NULL, NULL, NULL, NULL),
(70,'IT','Italy','ITA','+39', NOW(), 1, NULL, NULL, NULL, NULL),
(71,'JM','Jamaica','JAM','+1', NOW(), 1, NULL, NULL, NULL, NULL),
(72,'JP','Japan','JPN','+81', NOW(), 1, NULL, NULL, NULL, NULL),
(73,'JO','Jordan','JOR','+962', NOW(), 1, NULL, NULL, NULL, NULL),
(74,'KZ','Kazakhstan','KAZ','+7', NOW(), 1, NULL, NULL, NULL, NULL),
(75,'KE','Kenya','KEN','+254', NOW(), 1, NULL, NULL, NULL, NULL),
(76,'KW','Kuwait','KWT','+965', NOW(), 1, NULL, NULL, NULL, NULL),
(77,'KG','Kyrgyzstan','KGZ','+996', NOW(), 1, NULL, NULL, NULL, NULL),
(78,'LA','Laos','LAO','+856', NOW(), 1, NULL, NULL, NULL, NULL),
(79,'LV','Latvia','LVA','+371', NOW(), 1, NULL, NULL, NULL, NULL),
(80,'LB','Lebanon','LBN','+961', NOW(), 1, NULL, NULL, NULL, NULL),
(81,'LY','Libya','LBY','+218', NOW(), 1, NULL, NULL, NULL, NULL),
(82,'LT','Lithuania','LTU','+370', NOW(), 1, NULL, NULL, NULL, NULL),
(83,'LU','Luxembourg','LUX','+352', NOW(), 1, NULL, NULL, NULL, NULL),
(84,'MY','Malaysia','MYS','+60', NOW(), 1, NULL, NULL, NULL, NULL),
(85,'MV','Maldives','MDV','+960', NOW(), 1, NULL, NULL, NULL, NULL),
(86,'ML','Mali','MLI','+223', NOW(), 1, NULL, NULL, NULL, NULL),
(87,'MT','Malta','MLT','+356', NOW(), 1, NULL, NULL, NULL, NULL),
(88,'MX','Mexico','MEX','+52', NOW(), 1, NULL, NULL, NULL, NULL),
(89,'MN','Mongolia','MNG','+976', NOW(), 1, NULL, NULL, NULL, NULL),
(90,'MA','Morocco','MAR','+212', NOW(), 1, NULL, NULL, NULL, NULL),
(91,'MM','Myanmar','MMR','+95', NOW(), 1, NULL, NULL, NULL, NULL),
(92,'NP','Nepal','NPL','+977', NOW(), 1, NULL, NULL, NULL, NULL),
(93,'NL','Netherlands','NLD','+31', NOW(), 1, NULL, NULL, NULL, NULL),
(94,'NZ','New Zealand','NZL','+64', NOW(), 1, NULL, NULL, NULL, NULL),
(95,'NG','Nigeria','NGA','+234', NOW(), 1, NULL, NULL, NULL, NULL),
(96,'NO','Norway','NOR','+47', NOW(), 1, NULL, NULL, NULL, NULL),
(97,'OM','Oman','OMN','+968', NOW(), 1, NULL, NULL, NULL, NULL),
(98,'PK','Pakistan','PAK','+92', NOW(), 1, NULL, NULL, NULL, NULL),
(99,'PH','Philippines','PHL','+63', NOW(), 1, NULL, NULL, NULL, NULL),
(100,'PL','Poland','POL','+48', NOW(), 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 3: Countries 101–150
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(101,'PT','Portugal','PRT','+351', NOW(), 1, NULL, NULL, NULL, NULL),
(102,'QA','Qatar','QAT','+974', NOW(), 1, NULL, NULL, NULL, NULL),
(103,'RO','Romania','ROU','+40', NOW(), 1, NULL, NULL, NULL, NULL),
(104,'RU','Russia','RUS','+7', NOW(), 1, NULL, NULL, NULL, NULL),
(105,'SA','Saudi Arabia','SAU','+966', NOW(), 1, NULL, NULL, NULL, NULL),
(106,'SG','Singapore','SGP','+65', NOW(), 1, NULL, NULL, NULL, NULL),
(107,'ZA','South Africa','ZAF','+27', NOW(), 1, NULL, NULL, NULL, NULL),
(108,'KR','South Korea','KOR','+82', NOW(), 1, NULL, NULL, NULL, NULL),
(109,'ES','Spain','ESP','+34', NOW(), 1, NULL, NULL, NULL, NULL),
(110,'LK','Sri Lanka','LKA','+94', NOW(), 1, NULL, NULL, NULL, NULL),
(111,'SE','Sweden','SWE','+46', NOW(), 1, NULL, NULL, NULL, NULL),
(112,'CH','Switzerland','CHE','+41', NOW(), 1, NULL, NULL, NULL, NULL),
(113,'TH','Thailand','THA','+66', NOW(), 1, NULL, NULL, NULL, NULL),
(114,'TR','Turkey','TUR','+90', NOW(), 1, NULL, NULL, NULL, NULL),
(115,'AE','United Arab Emirates','ARE','+971', NOW(), 1, NULL, NULL, NULL, NULL),
(116,'UA','Ukraine','UKR','+380', NOW(), 1, NULL, NULL, NULL, NULL),
(117,'GB','United Kingdom','GBR','+44', NOW(), 1, NULL, NULL, NULL, NULL),
(118,'US','United States','USA','+1', NOW(), 1, NULL, NULL, NULL, NULL),
(119,'UY','Uruguay','URY','+598', NOW(), 1, NULL, NULL, NULL, NULL),
(120,'UZ','Uzbekistan','UZB','+998', NOW(), 1, NULL, NULL, NULL, NULL),
(121,'VN','Vietnam','VNM','+84', NOW(), 1, NULL, NULL, NULL, NULL),
(122,'YE','Yemen','YEM','+967', NOW(), 1, NULL, NULL, NULL, NULL),
(123,'ZM','Zambia','ZMB','+260', NOW(), 1, NULL, NULL, NULL, NULL),
(124,'ZW','Zimbabwe','ZWE','+263', NOW(), 1, NULL, NULL, NULL, NULL),
(125,'AM','Armenia','ARM','+374', NOW(), 1, NULL, NULL, NULL, NULL),
(126,'AZ','Azerbaijan','AZE','+994', NOW(), 1, NULL, NULL, NULL, NULL),
(127,'BY','Belarus','BLR','+375', NOW(), 1, NULL, NULL, NULL, NULL),
(128,'BA','Bosnia and Herzegovina','BIH','+387', NOW(), 1, NULL, NULL, NULL, NULL),
(129,'BG','Bulgaria','BGR','+359', NOW(), 1, NULL, NULL, NULL, NULL),
(130,'HR','Croatia','HRV','+385', NOW(), 1, NULL, NULL, NULL, NULL),
(131,'CY','Cyprus','CYP','+357', NOW(), 1, NULL, NULL, NULL, NULL),
(132,'CZ','Czech Republic','CZE','+420', NOW(), 1, NULL, NULL, NULL, NULL),
(133,'EE','Estonia','EST','+372', NOW(), 1, NULL, NULL, NULL, NULL),
(134,'GE','Georgia','GEO','+995', NOW(), 1, NULL, NULL, NULL, NULL),
(135,'HU','Hungary','HUN','+36', NOW(), 1, NULL, NULL, NULL, NULL),
(136,'IS','Iceland','ISL','+354', NOW(), 1, NULL, NULL, NULL, NULL),
(137,'KZ','Kazakhstan','KAZ','+7', NOW(), 1, NULL, NULL, NULL, NULL),
(138,'KG','Kyrgyzstan','KGZ','+996', NOW(), 1, NULL, NULL, NULL, NULL),
(139,'LV','Latvia','LVA','+371', NOW(), 1, NULL, NULL, NULL, NULL),
(140,'LI','Liechtenstein','LIE','+423', NOW(), 1, NULL, NULL, NULL, NULL),
(141,'LT','Lithuania','LTU','+370', NOW(), 1, NULL, NULL, NULL, NULL),
(142,'LU','Luxembourg','LUX','+352', NOW(), 1, NULL, NULL, NULL, NULL),
(143,'MK','North Macedonia','MKD','+389', NOW(), 1, NULL, NULL, NULL, NULL),
(144,'MT','Malta','MLT','+356', NOW(), 1, NULL, NULL, NULL, NULL),
(145,'MD','Moldova','MDA','+373', NOW(), 1, NULL, NULL, NULL, NULL),
(146,'MC','Monaco','MCO','+377', NOW(), 1, NULL, NULL, NULL, NULL),
(147,'ME','Montenegro','MNE','+382', NOW(), 1, NULL, NULL, NULL, NULL),
(148,'NL','Netherlands','NLD','+31', NOW(), 1, NULL, NULL, NULL, NULL),
(149,'NO','Norway','NOR','+47', NOW(), 1, NULL, NULL, NULL, NULL),
(150,'PL','Poland','POL','+48', NOW(), 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 4: Countries 151–200
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(151,'PT','Portugal','PRT','+351', NOW(), 1, NULL, NULL, NULL, NULL),
(152,'RO','Romania','ROU','+40', NOW(), 1, NULL, NULL, NULL, NULL),
(153,'RU','Russia','RUS','+7', NOW(), 1, NULL, NULL, NULL, NULL),
(154,'SM','San Marino','SMR','+378', NOW(), 1, NULL, NULL, NULL, NULL),
(155,'RS','Serbia','SRB','+381', NOW(), 1, NULL, NULL, NULL, NULL),
(156,'SK','Slovakia','SVK','+421', NOW(), 1, NULL, NULL, NULL, NULL),
(157,'SI','Slovenia','SVN','+386', NOW(), 1, NULL, NULL, NULL, NULL),
(158,'ES','Spain','ESP','+34', NOW(), 1, NULL, NULL, NULL, NULL),
(159,'SE','Sweden','SWE','+46', NOW(), 1, NULL, NULL, NULL, NULL),
(160,'CH','Switzerland','CHE','+41', NOW(), 1, NULL, NULL, NULL, NULL),
(161,'TR','Turkey','TUR','+90', NOW(), 1, NULL, NULL, NULL, NULL),
(162,'UA','Ukraine','UKR','+380', NOW(), 1, NULL, NULL, NULL, NULL),
(163,'GB','United Kingdom','GBR','+44', NOW(), 1, NULL, NULL, NULL, NULL),
(164,'VA','Vatican City','VAT','+379', NOW(), 1, NULL, NULL, NULL, NULL),
(165,'DZ','Algeria','DZA','+213', NOW(), 1, NULL, NULL, NULL, NULL),
(166,'AO','Angola','AGO','+244', NOW(), 1, NULL, NULL, NULL, NULL),
(167,'BJ','Benin','BEN','+229', NOW(), 1, NULL, NULL, NULL, NULL),
(168,'BW','Botswana','BWA','+267', NOW(), 1, NULL, NULL, NULL, NULL),
(169,'BF','Burkina Faso','BFA','+226', NOW(), 1, NULL, NULL, NULL, NULL),
(170,'BI','Burundi','BDI','+257', NOW(), 1, NULL, NULL, NULL, NULL),
(171,'CV','Cape Verde','CPV','+238', NOW(), 1, NULL, NULL, NULL, NULL),
(172,'CM','Cameroon','CMR','+237', NOW(), 1, NULL, NULL, NULL, NULL),
(173,'CF','Central African Republic','CAF','+236', NOW(), 1, NULL, NULL, NULL, NULL),
(174,'TD','Chad','TCD','+235', NOW(), 1, NULL, NULL, NULL, NULL),
(175,'KM','Comoros','COM','+269', NOW(), 1, NULL, NULL, NULL, NULL),
(176,'CG','Congo','COG','+242', NOW(), 1, NULL, NULL, NULL, NULL),
(177,'CD','Democratic Republic of the Congo','COD','+243', NOW(), 1, NULL, NULL, NULL, NULL),
(178,'DJ','Djibouti','DJI','+253', NOW(), 1, NULL, NULL, NULL, NULL),
(179,'EG','Egypt','EGY','+20', NOW(), 1, NULL, NULL, NULL, NULL),
(180,'GQ','Equatorial Guinea','GNQ','+240', NOW(), 1, NULL, NULL, NULL, NULL),
(181,'ER','Eritrea','ERI','+291', NOW(), 1, NULL, NULL, NULL, NULL),
(182,'ET','Ethiopia','ETH','+251', NOW(), 1, NULL, NULL, NULL, NULL),
(183,'GA','Gabon','GAB','+241', NOW(), 1, NULL, NULL, NULL, NULL),
(184,'GM','Gambia','GMB','+220', NOW(), 1, NULL, NULL, NULL, NULL),
(185,'GH','Ghana','GHA','+233', NOW(), 1, NULL, NULL, NULL, NULL),
(186,'GN','Guinea','GIN','+224', NOW(), 1, NULL, NULL, NULL, NULL),
(187,'GW','Guinea-Bissau','GNB','+245', NOW(), 1, NULL, NULL, NULL, NULL),
(188,'CI','Ivory Coast','CIV','+225', NOW(), 1, NULL, NULL, NULL, NULL),
(189,'KE','Kenya','KEN','+254', NOW(), 1, NULL, NULL, NULL, NULL),
(190,'LS','Lesotho','LSO','+266', NOW(), 1, NULL, NULL, NULL, NULL),
(191,'LR','Liberia','LBR','+231', NOW(), 1, NULL, NULL, NULL, NULL),
(192,'LY','Libya','LBY','+218', NOW(), 1, NULL, NULL, NULL, NULL),
(193,'MG','Madagascar','MDG','+261', NOW(), 1, NULL, NULL, NULL, NULL),
(194,'MW','Malawi','MWI','+265', NOW(), 1, NULL, NULL, NULL, NULL),
(195,'ML','Mali','MLI','+223', NOW(), 1, NULL, NULL, NULL, NULL),
(196,'MR','Mauritania','MRT','+222', NOW(), 1, NULL, NULL, NULL, NULL),
(197,'MU','Mauritius','MUS','+230', NOW(), 1, NULL, NULL, NULL, NULL),
(198,'MA','Morocco','MAR','+212', NOW(), 1, NULL, NULL, NULL, NULL),
(199,'MZ','Mozambique','MOZ','+258', NOW(), 1, NULL, NULL, NULL, NULL),
(200,'NA','Namibia','NAM','+264', NOW(), 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 5: Countries 201–246
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(201,'NP','Nepal','NPL','+977', NOW(), 1, NULL, NULL, NULL, NULL),
(202,'NL','Netherlands','NLD','+31', NOW(), 1, NULL, NULL, NULL, NULL),
(203,'NZ','New Zealand','NZL','+64', NOW(), 1, NULL, NULL, NULL, NULL),
(204,'NI','Nicaragua','NIC','+505', NOW(), 1, NULL, NULL, NULL, NULL),
(205,'NE','Niger','NER','+227', NOW(), 1, NULL, NULL, NULL, NULL),
(206,'NG','Nigeria','NGA','+234', NOW(), 1, NULL, NULL, NULL, NULL),
(207,'KP','North Korea','PRK','+850', NOW(), 1, NULL, NULL, NULL, NULL),
(208,'MK','North Macedonia','MKD','+389', NOW(), 1, NULL, NULL, NULL, NULL),
(209,'NO','Norway','NOR','+47', NOW(), 1, NULL, NULL, NULL, NULL),
(210,'OM','Oman','OMN','+968', NOW(), 1, NULL, NULL, NULL, NULL),
(211,'PK','Pakistan','PAK','+92', NOW(), 1, NULL, NULL, NULL, NULL),
(212,'PW','Palau','PLW','+680', NOW(), 1, NULL, NULL, NULL, NULL),
(213,'PA','Panama','PAN','+507', NOW(), 1, NULL, NULL, NULL, NULL),
(214,'PG','Papua New Guinea','PNG','+675', NOW(), 1, NULL, NULL, NULL, NULL),
(215,'PY','Paraguay','PRY','+595', NOW(), 1, NULL, NULL, NULL, NULL),
(216,'PE','Peru','PER','+51', NOW(), 1, NULL, NULL, NULL, NULL),
(217,'PH','Philippines','PHL','+63', NOW(), 1, NULL, NULL, NULL, NULL),
(218,'PL','Poland','POL','+48', NOW(), 1, NULL, NULL, NULL, NULL),
(219,'PT','Portugal','PRT','+351', NOW(), 1, NULL, NULL, NULL, NULL),
(220,'QA','Qatar','QAT','+974', NOW(), 1, NULL, NULL, NULL, NULL),
(221,'RO','Romania','ROU','+40', NOW(), 1, NULL, NULL, NULL, NULL),
(222,'RU','Russia','RUS','+7', NOW(), 1, NULL, NULL, NULL, NULL),
(223,'RW','Rwanda','RWA','+250', NOW(), 1, NULL, NULL, NULL, NULL),
(224,'KN','Saint Kitts and Nevis','KNA','+1-869', NOW(), 1, NULL, NULL, NULL, NULL),
(225,'LC','Saint Lucia','LCA','+1-758', NOW(), 1, NULL, NULL, NULL, NULL),
(226,'VC','Saint Vincent and the Grenadines','VCT','+1-784', NOW(), 1, NULL, NULL, NULL, NULL),
(227,'WS','Samoa','WSM','+685', NOW(), 1, NULL, NULL, NULL, NULL),
(228,'SM','San Marino','SMR','+378', NOW(), 1, NULL, NULL, NULL, NULL),
(229,'ST','Sao Tome and Principe','STP','+239', NOW(), 1, NULL, NULL, NULL, NULL),
(230,'SA','Saudi Arabia','SAU','+966', NOW(), 1, NULL, NULL, NULL, NULL),
(231,'SN','Senegal','SEN','+221', NOW(), 1, NULL, NULL, NULL, NULL),
(232,'RS','Serbia','SRB','+381', NOW(), 1, NULL, NULL, NULL, NULL),
(233,'SC','Seychelles','SYC','+248', NOW(), 1, NULL, NULL, NULL, NULL),
(234,'SL','Sierra Leone','SLE','+232', NOW(), 1, NULL, NULL, NULL, NULL),
(235,'SG','Singapore','SGP','+65', NOW(), 1, NULL, NULL, NULL, NULL),
(236,'SK','Slovakia','SVK','+421', NOW(), 1, NULL, NULL, NULL, NULL),
(237,'SI','Slovenia','SVN','+386', NOW(), 1, NULL, NULL, NULL, NULL),
(238,'SB','Solomon Islands','SLB','+677', NOW(), 1, NULL, NULL, NULL, NULL),
(239,'SO','Somalia','SOM','+252', NOW(), 1, NULL, NULL, NULL, NULL),
(240,'ZA','South Africa','ZAF','+27', NOW(), 1, NULL, NULL, NULL, NULL),
(241,'KR','South Korea','KOR','+82', NOW(), 1, NULL, NULL, NULL, NULL),
(242,'SS','South Sudan','SSD','+211', NOW(), 1, NULL, NULL, NULL, NULL),
(243,'ES','Spain','ESP','+34', NOW(), 1, NULL, NULL, NULL, NULL),
(244,'LK','Sri Lanka','LKA','+94', NOW(), 1, NULL, NULL, NULL, NULL),
(245,'SD','Sudan','SDN','+249', NOW(), 1, NULL, NULL, NULL, NULL),
(246,'ZW','Zimbabwe','ZWE','+263', NOW(), 1, NULL, NULL, NULL, NULL);



INSERT INTO provinces
(country_id, name, code, is_active, created_at, created_by, deleted)
VALUES
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Punjab', 'PB', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Sindh', 'SD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Khyber Pakhtunkhwa', 'KP', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Balochistan', 'BL', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Gilgit-Baltistan', 'GB', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Azad Jammu and Kashmir', 'AJK', TRUE, NOW(), 1, FALSE),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Islamabad Capital Territory', 'ICT', TRUE, NOW(), 1, FALSE);

INSERT INTO cities
(province_id, name, code, is_active, created_at, created_by, deleted)
VALUES

-- ================= PUNJAB =================
((SELECT id FROM provinces WHERE name='Punjab'), 'Lahore', 'LHR', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Faisalabad', 'FSD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rawalpindi', 'RWP', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Multan', 'MUX', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Gujranwala', 'GUJ', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sialkot', 'SKT', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Bahawalpur', 'BWP', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sargodha', 'SGD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rahim Yar Khan', 'RYK', TRUE, NOW(), 1, FALSE),

-- ================= SINDH =================
((SELECT id FROM provinces WHERE name='Sindh'), 'Karachi', 'KHI', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Sindh'), 'Hyderabad', 'HYD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Sindh'), 'Sukkur', 'SKZ', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Sindh'), 'Larkana', 'LRK', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Sindh'), 'Nawabshah', 'NWS', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Sindh'), 'Mirpurkhas', 'MPK', TRUE, NOW(), 1, FALSE),

-- ================= KP =================
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Peshawar', 'PEW', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Mardan', 'MRD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Abbottabad', 'ABT', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Swat', 'SWT', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Kohat', 'KHT', TRUE, NOW(), 1, FALSE),

-- ================= BALOCHISTAN =================
((SELECT id FROM provinces WHERE name='Balochistan'), 'Quetta', 'QTA', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Gwadar', 'GWD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Turbat', 'TBT', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Khuzdar', 'KZD', TRUE, NOW(), 1, FALSE),

-- ================= GILGIT BALTISTAN =================
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Gilgit', 'GIL', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Skardu', 'SKD', TRUE, NOW(), 1, FALSE),

-- ================= AJK =================
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Muzaffarabad', 'MZD', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Mirpur', 'MPR', TRUE, NOW(), 1, FALSE),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Kotli', 'KTL', TRUE, NOW(), 1, FALSE),

-- ================= ISLAMABAD =================
((SELECT id FROM provinces WHERE name='Islamabad Capital Territory'), 'Islamabad', 'ISB', TRUE, NOW(), 1, FALSE);



INSERT INTO employee_type
(organization_id, name, description, active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 'Teacher', 'General teaching staff', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Head of Department', 'Leads a specific academic department', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Principal', 'Overall in charge of school administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Vice Principal', 'Assists the principal in administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Lab Instructor', 'Handles lab sessions and practical classes', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Special Education Teacher', 'Works with students requiring special education', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Sports Coach', 'Manages sports and physical activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Music Teacher', 'Handles music and arts subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Art Teacher', 'Handles art-related subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Librarian', 'Manages library operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Administrator', 'Handles general administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Accountant', 'Manages accounts, fees, and payroll', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Receptionist', 'First point of contact for visitors and parents', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'HR Officer', 'Handles recruitment, payroll, and employee welfare', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Clerk', 'General office work', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'IT Support', 'Maintains school IT infrastructure', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Counselor', 'Provides student counseling services', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Nurse', 'Handles student health needs', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Security Guard', 'Maintains school security', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Driver', 'For school transport vehicles', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Janitor', 'Handles cleaning and maintenance', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Cafeteria Staff', 'Manages school cafeteria operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Bus Attendant', 'Assists in student transport', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'School Board Member', 'Part of the school board or governing body', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'School Coordinator', 'Coordinates programs and school events', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Project Manager', 'Handles special projects and development activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL);



-- 1. INSERT SUBJECT GROUPS
INSERT INTO subject_groups (organization_id, code, name)
VALUES
-- Core Academic Streams
(1, 'SCI',  'Science Group'),
(1, 'ART',  'Arts Group'),
(1, 'COM',  'Commerce Group'),

-- Technology
(1, 'CS',   'Computer Studies Group'),
(1, 'IT',   'Information Technology Group'),
(1, 'AI',   'Robotics & AI Group'),

-- Creative Arts
(1, 'FA',   'Fine Arts Group'),
(1, 'PA',   'Performing Arts Group'),
(1, 'DES',  'Design & Media Studies Group'),

-- Physical & Health
(1, 'PE',   'Physical Education Group'),
(1, 'SP',   'Sports Science Group'),
(1, 'HLT',  'Health & Wellness Group'),

-- Moral & Religious
(1, 'REL',  'Religious Studies Group'),
(1, 'ETH',  'Ethics & Moral Education Group'),

-- Foundational
(1, 'GEN',  'General Studies Group'),
(1, 'PRI',  'Primary Education Group'),
(1, 'ECE',  'Early Childhood Education Group'),

-- Humanities & Society
(1, 'SOC',  'Social Sciences Group'),
(1, 'HUM',  'Humanities Group'),
(1, 'CIV',  'Civics & Global Studies Group'),

-- Career & Practical
(1, 'BUS',  'Business & Economics Group'),
(1, 'VOC',  'Vocational Studies Group'),
(1, 'LIFE', 'Life Skills & Career Guidance Group'),

-- Languages
(1, 'LANG', 'Languages Group'),
(1, 'FL',   'Foreign Languages Group')
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    is_active = TRUE,
    is_deleted = FALSE;

-- 2. INSERT SUBJECTS
-- Note: subject_group_id is fetched dynamically to ensure correctness regardless of ID generation.
-- Defaulting is_core = TRUE as per user data.

INSERT INTO subjects (organization_id, code, name, subject_group_id, is_core)
VALUES
-- Science Group
(1, 'PHY',     'Physics',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'CHEM',    'Chemistry',             (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'BIO',     'Biology',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'GEN_SCI', 'General Science',       (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'ENV_SCI', 'Environmental Science', (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),

-- Arts Group
(1, 'HIST',    'History',               (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'GEO',     'Geography',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'PSY',     'Psychology',            (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'SOCIO',   'Sociology',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),

-- Commerce Group
(1, 'ACC',     'Accounting',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'ECO',     'Economics',             (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'BST',     'Business Studies',      (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'STAT',    'Statistics',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),

-- Computer Studies Group
(1, 'CS_FUND', 'Computer Fundamentals', (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),
(1, 'PROG',    'Programming',           (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),
(1, 'DS',      'Data Structures',       (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),

-- Information Technology Group
(1, 'IT_BASIC', 'Information Technology', (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),
(1, 'NET',      'Networking Basics',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),
(1, 'DB',       'Database Concepts',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),

-- Robotics & AI Group
(1, 'AI_INTRO', 'Introduction to AI',     (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE),
(1, 'ROBO',     'Robotics',               (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE),

-- Fine Arts Group
(1, 'DRAW',   'Drawing',               (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),
(1, 'PAINT',  'Painting',              (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),
(1, 'CRAFT',  'Craft & Design',        (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),

-- Performing Arts Group
(1, 'MUSIC',  'Music',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),
(1, 'DRAMA',  'Drama',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),
(1, 'DANCE',  'Dance',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),

-- Design & Media Studies Group
(1, 'GD',     'Graphic Design',        (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),
(1, 'MEDIA',  'Media Studies',         (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),
(1, 'PHOTO',  'Photography',           (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),

-- Physical Education Group
(1, 'PE',     'Physical Education',    (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE),
(1, 'YOGA',    'Yoga',                  (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE),

-- Sports Science Group
(1, 'SPORT_SCI', 'Sports Science',     (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE),
(1, 'FIT',       'Fitness Training',   (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE),

-- Health & Wellness Group
(1, 'HEALTH', 'Health Education',      (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE),
(1, 'NUT',    'Nutrition',             (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE),

-- Religious Studies Group
(1, 'ISL',     'Islamic Studies',      (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE),
(1, 'REL_GEN', 'Comparative Religion', (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE),

-- Ethics & Moral Education Group
(1, 'ETHICS', 'Ethics',                (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE),
(1, 'MORAL',  'Moral Education',       (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE),

-- General Studies Group
(1, 'GK',     'General Knowledge',     (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE),
(1, 'GS',     'General Studies',       (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE),

-- Primary Education Group
(1, 'BASIC_MATH', 'Basic Mathematics', (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE),
(1, 'BASIC_LANG', 'Basic Language',    (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE),

-- Early Childhood Education Group
(1, 'PLAY',       'Play & Learning',   (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE),
(1, 'DRAW_BASIC', 'Basic Drawing',     (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE),

-- Social Sciences Group
(1, 'POL',    'Political Science',     (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE),
(1, 'ANTH',   'Anthropology',          (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE),

-- Humanities Group
(1, 'PHIL',   'Philosophy',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE),
(1, 'LIT',    'Literature',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE),

-- Civics & Global Studies Group
(1, 'CIVICS', 'Civics',                (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE),
(1, 'GLOBAL', 'Global Studies',        (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE),

-- Business & Economics Group
(1, 'ENT',    'Entrepreneurship',      (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE),
(1, 'FIN',    'Finance Basics',        (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE),

-- Vocational Studies Group
(1, 'ELEC',   'Basic Electronics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE),
(1, 'AUTO',   'Automobile Basics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE),

-- Life Skills & Career Guidance Group
(1, 'LS',     'Life Skills',           (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE),
(1, 'CAREER', 'Career Guidance',       (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE),

-- Languages Group
(1, 'ENG',    'English',               (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),
(1, 'URD',    'Urdu',                  (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),
(1, 'ARB',    'Arabic',                (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),

-- Foreign Languages Group
(1, 'FR',     'French',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE),
(1, 'GER',    'German',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE),
(1, 'CHI',    'Chinese',               (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE)
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    subject_group_id = VALUES(subject_group_id),
    is_core = VALUES(is_core),
    is_active = TRUE,
    is_deleted = FALSE;




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
(
 1, 'Smart Solutions School','123 Main Street, Lahore','+92-300-1234567','info@smartsolutions.edu','https://www.smartsolutions.edu','Excellence in Education',NULL, '2005-08-15',
 (SELECT id FROM country WHERE iso_code='PAK' LIMIT 1),
 (SELECT id FROM provinces WHERE name = 'Punjab'),
 (SELECT id FROM cities WHERE name = 'Lahore'),
 NOW(),
 NOW()
);

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
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Lahore
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Lahore' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com',
 'https://uptown.smarteschool.com', '456 Park Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com',
 'https://riverside.smarteschool.com', '789 River Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Peshawar
(1, 1,
 (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'),
 (SELECT id FROM cities WHERE name='Peshawar' AND province_id = (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa')),
 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com',
 'https://hilltop.smarteschool.com', '101 Hill Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Faisalabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Faisalabad' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
 'https://greenfield.smarteschool.com', '202 Green Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com',
 'https://seaside.smarteschool.com', '303 Beach Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Multan
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Multan' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Central Campus', '+92-303-9990001', 'central@smarteschool.com',
 'https://central.smarteschool.com', '404 Central Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Hyderabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Hyderabad' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com',
 'https://lakeside.smarteschool.com', '505 Lake Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Rawalpindi
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Rawalpindi' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com',
 'https://sunrise.smarteschool.com', '606 Sunrise Blvd', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Quetta
(1, 1,
 (SELECT id FROM provinces WHERE name='Balochistan'),
 (SELECT id FROM cities WHERE name='Quetta' AND province_id = (SELECT id FROM provinces WHERE name='Balochistan')),
 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com',
 'https://maple.smarteschool.com', '707 Maple Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL);


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
(1, 1, '1st Grade', NOW(), NOW()),
(1, 1, '2nd Grade', NOW(), NOW()),
(1, 1, '3rd Grade', NOW(), NOW()),
(1, 1, '4th Grade', NOW(), NOW()),
(1, 1, '5th Grade', NOW(), NOW()),

-- Uptown Campus (campus_id = 2)
(1, 2, '1st Grade', NOW(), NOW()),
(1, 2, '2nd Grade', NOW(), NOW()),
(1, 2, '3rd Grade', NOW(), NOW()),
(1, 2, '4th Grade', NOW(), NOW()),
(1, 2, '5th Grade', NOW(), NOW()),

-- Riverside Campus (campus_id = 3)
(1, 3, '1st Grade', NOW(), NOW()),
(1, 3, '2nd Grade', NOW(), NOW()),
(1, 3, '3rd Grade', NOW(), NOW()),
(1, 3, '4th Grade', NOW(), NOW()),
(1, 3, '5th Grade', NOW(), NOW()),

-- Hilltop Campus (campus_id = 4)
(1, 4, '1st Grade', NOW(), NOW()),
(1, 4, '2nd Grade', NOW(), NOW()),
(1, 4, '3rd Grade', NOW(), NOW()),
(1, 4, '4th Grade', NOW(), NOW()),
(1, 4, '5th Grade', NOW(), NOW()),

-- Greenfield Campus (campus_id = 5)
(1, 5, '1st Grade', NOW(), NOW()),
(1, 5, '2nd Grade', NOW(), NOW()),
(1, 5, '3rd Grade', NOW(), NOW()),
(1, 5, '4th Grade', NOW(), NOW()),
(1, 5, '5th Grade', NOW(), NOW()),

-- Seaside Campus (campus_id = 6)
(1, 6, '1st Grade', NOW(), NOW()),
(1, 6, '2nd Grade', NOW(), NOW()),
(1, 6, '3rd Grade', NOW(), NOW()),
(1, 6, '4th Grade', NOW(), NOW()),
(1, 6, '5th Grade', NOW(), NOW()),

-- Central Campus (campus_id = 7)
(1, 7, '1st Grade', NOW(), NOW()),
(1, 7, '2nd Grade', NOW(), NOW()),
(1, 7, '3rd Grade', NOW(), NOW()),
(1, 7, '4th Grade', NOW(), NOW()),
(1, 7, '5th Grade', NOW(), NOW()),

-- Lakeside Campus (campus_id = 8)
(1, 8, '1st Grade', NOW(), NOW()),
(1, 8, '2nd Grade', NOW(), NOW()),
(1, 8, '3rd Grade', NOW(), NOW()),
(1, 8, '4th Grade', NOW(), NOW()),
(1, 8, '5th Grade', NOW(), NOW()),

-- Sunrise Campus (campus_id = 9)
(1, 9, '1st Grade', NOW(), NOW()),
(1, 9, '2nd Grade', NOW(), NOW()),
(1, 9, '3rd Grade', NOW(), NOW()),
(1, 9, '4th Grade', NOW(), NOW()),
(1, 9, '5th Grade', NOW(), NOW()),

-- Maple Campus (campus_id = 10)
(1, 10, '1st Grade', NOW(), NOW()),
(1, 10, '2nd Grade', NOW(), NOW()),
(1, 10, '3rd Grade', NOW(), NOW()),
(1, 10, '4th Grade', NOW(), NOW()),
(1, 10, '5th Grade', NOW(), NOW());


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
    (1, 1, 'A', NOW(), NOW(), 1, NULL),
    (1, 1, 'B', NOW(), NOW(), 0, NULL),
    (1, 1, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 2
    (1, 2, 'A', NOW(), NOW(), 0, NULL),
    (1, 2, 'B', NOW(), NOW(), 0, NULL),
    (1, 2, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 3
    (1, 3, 'A', NOW(), NOW(), 0, NULL),
    (1, 3, 'B', NOW(), NOW(), 0, NULL),
    (1, 3, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 4
    (1, 4, 'A', NOW(), NOW(), 0, NULL),
    (1, 4, 'B', NOW(), NOW(), 0, NULL),
    (1, 4, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 5
    (1, 5, 'A', NOW(), NOW(), 0, NULL),
    (1, 5, 'B', NOW(), NOW(), 0, NULL),
    (1, 5, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 6
    (1, 6, 'A', NOW(), NOW(), 0, NULL),
    (1, 6, 'B', NOW(), NOW(), 0, NULL),
    (1, 6, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 7
    (1, 7, 'A', NOW(), NOW(), 0, NULL),
    (1, 7, 'B', NOW(), NOW(), 0, NULL),
    (1, 7, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 8
    (1, 8, 'A', NOW(), NOW(), 0, NULL),
    (1, 8, 'B', NOW(), NOW(), 0, NULL),
    (1, 8, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 9
    (1, 9, 'A', NOW(), NOW(), 0, NULL),
    (1, 9, 'B', NOW(), NOW(), 0, NULL),
    (1, 9, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 10
    (1, 10, 'A', NOW(), NOW(), 0, NULL),
    (1, 10, 'B', NOW(), NOW(), 0, NULL),
    (1, 10, 'C', NOW(), NOW(), 0, NULL);



    -- Populate standard_subjects with real-time dataset
    INSERT INTO standard_subjects
    (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
    VALUES
    -- Primary (Std 1-5)
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 3, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 3, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 4, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 4, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 5, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 5, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),

    -- Secondary (Std 6-10)
    (1, 6, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 7, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 8, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 9, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 10, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),

    -- Higher Secondary / Electives (Std 11-12)
    (1, 11, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 11, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 11, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 12, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 12, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 12, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0);


INSERT INTO exam_type
(
    organization_id,
    code,
    name,
    description,
    is_active,
    is_deleted,
    created_at,
    created_by
)
VALUES

-- Major Exams
(1,'MID','Mid Term Exam','Mid session evaluation',TRUE,FALSE,NOW(),1),
(1,'FINAL','Final Exam','End term final exam',TRUE,FALSE,NOW(),1),
(1,'ANNUAL','Annual Exam','Yearly evaluation',TRUE,FALSE,NOW(),1),
(1,'SUPP','Supplementary Exam','Reattempt failed subjects',TRUE,FALSE,NOW(),1),
(1,'RET','Retake Exam','Retake full exam',TRUE,FALSE,NOW(),1),

-- Periodic Exams
(1,'UT1','Unit Test 1','First unit test',TRUE,FALSE,NOW(),1),
(1,'UT2','Unit Test 2','Second unit test',TRUE,FALSE,NOW(),1),
(1,'UT3','Unit Test 3','Third unit test',TRUE,FALSE,NOW(),1),
(1,'MT1','Monthly Test','Monthly performance test',TRUE,FALSE,NOW(),1),
(1,'WKLY','Weekly Test','Weekly short test',TRUE,FALSE,NOW(),1),

-- Internal Evaluation
(1,'INT','Internal Exam','Internal assessment',TRUE,FALSE,NOW(),1),
(1,'CLASS','Class Test','Classroom evaluation',TRUE,FALSE,NOW(),1),
(1,'ORAL','Oral Exam','Spoken evaluation',TRUE,FALSE,NOW(),1),

-- Practical Based
(1,'PRAC','Practical Exam','Hands-on practical exam',TRUE,FALSE,NOW(),1),
(1,'LAB','Lab Exam','Laboratory evaluation',TRUE,FALSE,NOW(),1),
(1,'VIVA','Viva Voce','Oral viva assessment',TRUE,FALSE,NOW(),1),

-- Special Cases
(1,'ENT','Entrance Exam','Admission test',TRUE,FALSE,NOW(),1),
(1,'MOCK','Mock Exam','Practice exam',TRUE,FALSE,NOW(),1),
(1,'SCH','Scholarship Exam','Scholarship qualification test',TRUE,FALSE,NOW(),1);


INSERT INTO exam_terms
(organization_id, name, sequence_no, academic_year_id, created_by) VALUES
(1,'First Term',1,1,1),
(1,'Mid Term',2,1,1),
(1,'Second Term',3,1,1),
(1,'Pre Final',4,1,1),
(1,'Final Term',5,1,1);



INSERT INTO assessment_types
(organization_id, code, name, description, created_by)
VALUES

-- Written Evaluations
(1,'WR','Written Exam','Traditional written paper exam',1),
(1,'MCQ','MCQ Test','Multiple choice questions based test',1),
(1,'SUB','Subjective','Long answer descriptive paper',1),
(1,'OBJ','Objective','Short answer or objective type test',1),

-- Continuous Assessment
(1,'QUIZ','Quiz','Short quiz assessment',1),
(1,'ASSIGN','Assignment','Homework or take-home task',1),
(1,'CLASS','Class Test','In-class short test',1),
(1,'WKTEST','Weekly Test','Weekly performance test',1),
(1,'UNIT','Unit Test','Unit completion test',1),

-- Practical Based
(1,'PRAC','Practical','Hands-on practical exam',1),
(1,'LAB','Lab Work','Laboratory performance assessment',1),
(1,'DEMO','Demonstration','Practical demonstration assessment',1),

-- Oral / Interactive
(1,'VIVA','Viva Voce','Oral examination',1),
(1,'ORAL','Oral Test','Spoken or verbal test',1),
(1,'PRES','Presentation','Presentation based evaluation',1),

-- Project / Coursework
(1,'PROJ','Project','Project based evaluation',1),
(1,'COURSE','Course Work','Continuous coursework assessment',1),
(1,'PORT','Portfolio','Portfolio submission assessment',1),

-- Behavior / Participation
(1,'ATT','Attendance','Marks based on attendance',1),
(1,'PART','Participation','Class participation marks',1),
(1,'DISC','Discipline','Discipline evaluation marks',1),

-- Special Evaluations
(1,'MOCK','Mock Assessment','Practice exam for preparation',1),
(1,'DIAG','Diagnostic Test','Skill assessment test',1),
(1,'SKILL','Skill Test','Skill-based evaluation',1),
(1,'PHYS','Physical Test','Physical activity assessment',1);


INSERT INTO grade_scales
(organization_id, min_percentage, max_percentage, grade, remarks, created_by)
VALUES
(1, 90.00, 100.00, 'A+', 'Outstanding', 1),
(1, 85.00, 89.99, 'A',  'Excellent', 1),
(1, 80.00, 84.99, 'A-', 'Very Good', 1),
(1, 75.00, 79.99, 'B+', 'Good', 1),
(1, 70.00, 74.99, 'B',  'Above Average', 1),
(1, 65.00, 69.99, 'B-', 'Satisfactory', 1),
(1, 60.00, 64.99, 'C+', 'Acceptable', 1),
(1, 55.00, 59.99, 'C',  'Needs Improvement', 1),
(1, 50.00, 54.99, 'D',  'Pass', 1),
(1, 0.00, 49.99, 'F',  'Fail', 1);


-- Admission Types
INSERT INTO admission_type
(id, organization_id, code, name, description, is_active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 101, 'REG', 'Regular Admission', 'Standard admission for new academic session', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(2, 101, 'LAT', 'Lateral Entry', 'Admission granted to students transferring from another institution', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(3, 101, 'TRF', 'Transfer Admission', 'Student migrated from another branch or campus', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(4, 101, 'SCH', 'Scholarship Admission', 'Admission granted under scholarship program', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(5, 101, 'SPC', 'Sports Quota', 'Admission based on sports quota eligibility', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(6, 101, 'MGMT', 'Management Quota', 'Admission under management quota', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(7, 101, 'INT', 'International Student', 'Admission for foreign or overseas students', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(8, 101, 'RADM', 'Re-Admission', 'Student rejoining after leaving previously', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(9, 101, 'COND', 'Conditional Admission', 'Admission granted with pending documents or requirements', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(10, 101, 'WAIT', 'Waiting List Admission', 'Admission offered from waiting list after seat availability', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL);
-- Student Data (5 per section for 30 sections = 150 students)
-- Campus 1, Standards 1-5, Sections 1-15
-- Campus 2, Standards 6-10, Sections 16-30

INSERT INTO students (organization_id, first_name, full_name, last_name, student_code, date_of_birth, gender, email, enrollment_date, campus_id, standard_id, section_id, admission_type_id, academic_year_id)
VALUES
-- Standard 1 (Campus 1), Section 1 (A)
(1, 'Ahmed', 'Ahmed Ali', 'Ali', 'STU001', '2015-05-12', 'Male', 'stu001@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Sara', 'Sara Khan', 'Khan', 'STU002', '2015-06-15', 'Female', 'stu002@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Omar', 'Omar Farooq', 'Farooq', 'STU003', '2015-04-20', 'Male', 'stu003@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Zainab', 'Zainab Bibi', 'Bibi', 'STU004', '2015-08-10', 'Female', 'stu004@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Bilal', 'Bilal Hassan', 'Hassan', 'STU005', '2015-03-05', 'Male', 'stu005@example.com', '2026-02-22', 1, 1, 1, 1, 1),

-- Standard 1 (Campus 1), Section 2 (B)
(1, 'Fatima', 'Fatima Zahra', 'Zahra', 'STU006', '2015-07-22', 'Female', 'stu006@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Usman', 'Usman Sheikh', 'Sheikh', 'STU007', '2015-09-30', 'Male', 'stu007@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Ayesha', 'Ayesha Malik', 'Malik', 'STU008', '2015-01-12', 'Female', 'stu008@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Hamza', 'Hamza Butt', 'Butt', 'STU009', '2015-11-05', 'Male', 'stu009@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Hania', 'Hania Amir', 'Amir', 'STU010', '2015-12-25', 'Female', 'stu010@example.com', '2026-02-22', 1, 1, 2, 1, 1),

-- Standard 1 (Campus 1), Section 3 (C)
(1, 'Ali', 'Ali Raza', 'Raza', 'STU011', '2015-02-14', 'Male', 'stu011@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Dua', 'Dua Lipa', 'Lipa', 'STU012', '2015-04-18', 'Female', 'stu012@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Mustafa', 'Mustafa Kamal', 'Kamal', 'STU013', '2015-06-06', 'Male', 'stu013@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Inaya', 'Inaya Fatima', 'Fatima', 'STU014', '2015-10-10', 'Female', 'stu014@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Rayyan', 'Rayyan Abbas', 'Abbas', 'STU015', '2015-08-25', 'Male', 'stu015@example.com', '2026-02-22', 1, 1, 3, 1, 1),

-- Standard 2 (Campus 1), Section 4 (A)
(1, 'Student', 'Student 16', '16', 'STU016', '2014-05-01', 'Male', 'stu016@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 17', '17', 'STU017', '2014-05-02', 'Female', 'stu017@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 18', '18', 'STU018', '2014-05-03', 'Male', 'stu018@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 19', '19', 'STU019', '2014-05-04', 'Female', 'stu019@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 20', '20', 'STU020', '2014-05-05', 'Male', 'stu020@example.com', '2026-02-22', 1, 2, 4, 1, 1),

-- Standard 2 (Campus 1), Section 5 (B)
(1, 'Student', 'Student 21', '21', 'STU021', '2014-06-01', 'Female', 'stu021@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 22', '22', 'STU022', '2014-06-02', 'Male', 'stu022@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 23', '23', 'STU023', '2014-06-03', 'Female', 'stu023@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 24', '24', 'STU024', '2014-06-04', 'Male', 'stu024@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 25', '25', 'STU025', '2014-06-05', 'Female', 'stu025@example.com', '2026-02-22', 1, 2, 5, 1, 1),

-- Standard 2 (Campus 1), Section 6 (C)
(1, 'Student', 'Student 26', '26', 'STU026', '2014-07-01', 'Male', 'stu026@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 27', '27', 'STU027', '2014-07-02', 'Female', 'stu027@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 28', '28', 'STU028', '2014-07-03', 'Male', 'stu028@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 29', '29', 'STU029', '2014-07-04', 'Female', 'stu029@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 30', '30', 'STU030', '2014-07-05', 'Male', 'stu030@example.com', '2026-02-22', 1, 2, 6, 1, 1),

-- Standard 3 (Campus 1), Section 7 (A)
(1, 'Student', 'Student 31', '31', 'STU031', '2013-05-01', 'Male', 'stu031@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 32', '32', 'STU032', '2013-05-02', 'Female', 'stu032@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 33', '33', 'STU033', '2013-05-03', 'Male', 'stu033@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 34', '34', 'STU034', '2013-05-04', 'Female', 'stu034@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 35', '35', 'STU035', '2013-05-05', 'Male', 'stu035@example.com', '2026-02-22', 1, 3, 7, 1, 1),

-- Standard 3 (Campus 1), Section 8 (B)
(1, 'Student', 'Student 36', '36', 'STU036', '2013-06-01', 'Female', 'stu036@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 37', '37', 'STU037', '2013-06-02', 'Male', 'stu037@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 38', '38', 'STU038', '2013-06-03', 'Female', 'stu038@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 39', '39', 'STU039', '2013-06-04', 'Male', 'stu039@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 40', '40', 'STU040', '2013-06-05', 'Female', 'stu040@example.com', '2026-02-22', 1, 3, 8, 1, 1),

-- Standard 3 (Campus 1), Section 9 (C)
(1, 'Student', 'Student 41', '41', 'STU041', '2013-07-01', 'Male', 'stu041@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 42', '42', 'STU042', '2013-07-02', 'Female', 'stu042@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 43', '43', 'STU043', '2013-07-03', 'Male', 'stu043@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 44', '44', 'STU044', '2013-07-04', 'Female', 'stu044@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 45', '45', 'STU045', '2013-07-05', 'Male', 'stu045@example.com', '2026-02-22', 1, 3, 9, 1, 1),

-- Standard 4 (Campus 1), Section 10 (A)
(1, 'Student', 'Student 46', '46', 'STU046', '2012-05-01', 'Male', 'stu046@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 47', '47', 'STU047', '2012-05-02', 'Female', 'stu047@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 48', '48', 'STU048', '2012-05-03', 'Male', 'stu048@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 49', '49', 'STU049', '2012-05-04', 'Female', 'stu049@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 50', '50', 'STU050', '2012-05-05', 'Male', 'stu050@example.com', '2026-02-22', 1, 4, 10, 1, 1),

-- Standard 4 (Campus 1), Section 11 (B)
(1, 'Student', 'Student 51', '51', 'STU051', '2012-06-01', 'Female', 'stu051@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 52', '52', 'STU052', '2012-06-02', 'Male', 'stu052@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 53', '53', 'STU053', '2012-06-03', 'Female', 'stu053@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 54', '54', 'STU054', '2012-06-04', 'Male', 'stu054@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 55', '55', 'STU055', '2012-06-05', 'Female', 'stu055@example.com', '2026-02-22', 1, 4, 11, 1, 1),

-- Standard 4 (Campus 1), Section 12 (C)
(1, 'Student', 'Student 56', '56', 'STU056', '2012-07-01', 'Male', 'stu056@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 57', '57', 'STU057', '2012-07-02', 'Female', 'stu057@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 58', '58', 'STU058', '2012-07-03', 'Male', 'stu058@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 59', '59', 'STU059', '2012-07-04', 'Female', 'stu059@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 60', '60', 'STU060', '2012-07-05', 'Male', 'stu060@example.com', '2026-02-22', 1, 4, 12, 1, 1),

-- Standard 5 (Campus 1), Section 13 (A)
(1, 'Student', 'Student 61', '61', 'STU061', '2011-05-01', 'Male', 'stu061@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 62', '62', 'STU062', '2011-05-02', 'Female', 'stu062@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 63', '63', 'STU063', '2011-05-03', 'Male', 'stu063@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 64', '64', 'STU064', '2011-05-04', 'Female', 'stu064@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 65', '65', 'STU065', '2011-05-05', 'Male', 'stu065@example.com', '2026-02-22', 1, 5, 13, 1, 1),

-- Standard 5 (Campus 1), Section 14 (B)
(1, 'Student', 'Student 66', '66', 'STU066', '2011-06-01', 'Female', 'stu066@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 67', '67', 'STU067', '2011-06-02', 'Male', 'stu067@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 68', '68', 'STU068', '2011-06-03', 'Female', 'stu068@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 69', '69', 'STU069', '2011-06-04', 'Male', 'stu069@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 70', '70', 'STU070', '2011-06-05', 'Female', 'stu070@example.com', '2026-02-22', 1, 5, 14, 1, 1),

-- Standard 5 (Campus 1), Section 15 (C)
(1, 'Student', 'Student 71', '71', 'STU071', '2011-07-01', 'Male', 'stu071@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 72', '72', 'STU072', '2011-07-02', 'Female', 'stu072@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 73', '73', 'STU073', '2011-07-03', 'Male', 'stu073@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 74', '74', 'STU074', '2011-07-04', 'Female', 'stu074@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 75', '75', 'STU075', '2011-07-05', 'Male', 'stu075@example.com', '2026-02-22', 1, 5, 15, 1, 1),

-- Campus 2, Standards 6-10, Sections 16-30
-- Standard 6 (Campus 2), Section 16 (A)
(1, 'Uptown', 'Uptown Student 76', '76', 'STU076', '2010-05-01', 'Male', 'stu076@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 77', '77', 'STU077', '2010-05-02', 'Female', 'stu077@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 78', '78', 'STU078', '2010-05-03', 'Male', 'stu078@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 79', '79', 'STU079', '2010-05-04', 'Female', 'stu079@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 80', '80', 'STU080', '2010-05-05', 'Male', 'stu080@example.com', '2026-02-22', 2, 6, 16, 1, 1),

-- Standard 6 (Campus 2), Section 17 (B)
(1, 'Uptown', 'Uptown Student 81', '81', 'STU081', '2010-06-01', 'Female', 'stu081@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 82', '82', 'STU082', '2010-06-02', 'Male', 'stu082@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 83', '83', 'STU083', '2010-06-03', 'Female', 'stu083@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 84', '84', 'STU084', '2010-06-04', 'Male', 'stu084@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 85', '85', 'STU085', '2010-06-05', 'Female', 'stu085@example.com', '2026-02-22', 2, 6, 17, 1, 1),

-- Standard 6 (Campus 2), Section 18 (C)
(1, 'Uptown', 'Uptown Student 86', '86', 'STU086', '2010-07-01', 'Male', 'stu086@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 87', '87', 'STU087', '2010-07-02', 'Female', 'stu087@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 88', '88', 'STU088', '2010-07-03', 'Male', 'stu088@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 89', '89', 'STU089', '2010-07-04', 'Female', 'stu089@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 90', '90', 'STU090', '2010-07-05', 'Male', 'stu090@example.com', '2026-02-22', 2, 6, 18, 1, 1),

-- Standard 7 (Campus 2), Section 19 (A)
(1, 'Student', 'Student 91', '91', 'STU091', '2009-05-01', 'Male', 'stu091@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 92', '92', 'STU092', '2009-05-02', 'Female', 'stu092@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 93', '93', 'STU093', '2009-05-03', 'Male', 'stu093@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 94', '94', 'STU094', '2009-05-04', 'Female', 'stu094@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 95', '95', 'STU095', '2009-05-05', 'Male', 'stu095@example.com', '2026-02-22', 2, 7, 19, 1, 1),

-- Standard 7 (Campus 2), Section 20 (B)
(1, 'Student', 'Student 96', '96', 'STU096', '2009-06-01', 'Female', 'stu096@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 97', '97', 'STU097', '2009-06-02', 'Male', 'stu097@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 98', '98', 'STU098', '2009-06-03', 'Female', 'stu098@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 99', '99', 'STU099', '2009-06-04', 'Male', 'stu099@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 100', '100', 'STU100', '2009-06-05', 'Female', 'stu100@example.com', '2026-02-22', 2, 7, 20, 1, 1),

-- Standard 7 (Campus 2), Section 21 (C)
(1, 'Student', 'Student 101', '101', 'STU101', '2009-07-01', 'Male', 'stu101@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 102', '102', 'STU102', '2009-07-02', 'Female', 'stu102@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 103', '103', 'STU103', '2009-07-03', 'Male', 'stu103@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 104', '104', 'STU104', '2009-07-04', 'Female', 'stu104@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 105', '105', 'STU105', '2009-07-05', 'Male', 'stu105@example.com', '2026-02-22', 2, 7, 21, 1, 1),

-- Standard 8 (Campus 2), Section 22 (A)
(1, 'Student', 'Student 106', '106', 'STU106', '2008-05-01', 'Male', 'stu106@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 107', '107', 'STU107', '2008-05-02', 'Female', 'stu107@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 108', '108', 'STU108', '2008-05-03', 'Male', 'stu108@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 109', '109', 'STU109', '2008-05-04', 'Female', 'stu109@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 110', '110', 'STU110', '2008-05-05', 'Male', 'stu110@example.com', '2026-02-22', 2, 8, 22, 1, 1),

-- Standard 8 (Campus 2), Section 23 (B)
(1, 'Student', 'Student 111', '111', 'STU111', '2008-06-01', 'Female', 'stu111@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 112', '112', 'STU112', '2008-06-02', 'Male', 'stu112@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 113', '113', 'STU113', '2008-06-03', 'Female', 'stu113@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 114', '114', 'STU114', '2008-06-04', 'Male', 'stu114@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 115', '115', 'STU115', '2008-06-05', 'Female', 'stu115@example.com', '2026-02-22', 2, 8, 23, 1, 1),

-- Standard 8 (Campus 2), Section 24 (C)
(1, 'Student', 'Student 116', '116', 'STU116', '2008-07-01', 'Male', 'stu116@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 117', '117', 'STU117', '2008-07-02', 'Female', 'stu117@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 118', '118', 'STU118', '2008-07-03', 'Male', 'stu118@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 119', '119', 'STU119', '2008-07-04', 'Female', 'stu119@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 120', '120', 'STU120', '2008-07-05', 'Male', 'stu120@example.com', '2026-02-22', 2, 8, 24, 1, 1),

-- Standard 9 (Campus 2), Section 25 (A)
(1, 'Student', 'Student 121', '121', 'STU121', '2007-05-01', 'Male', 'stu121@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 122', '122', 'STU122', '2007-05-02', 'Female', 'stu122@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 123', '123', 'STU123', '2007-05-03', 'Male', 'stu123@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 124', '124', 'STU124', '2007-05-04', 'Female', 'stu124@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 125', '125', 'STU125', '2007-05-05', 'Male', 'stu125@example.com', '2026-02-22', 2, 9, 25, 1, 1),

-- Standard 9 (Campus 2), Section 26 (B)
(1, 'Student', 'Student 126', '126', 'STU126', '2007-06-01', 'Female', 'stu126@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 127', '127', 'STU127', '2007-06-02', 'Male', 'stu127@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 128', '128', 'STU128', '2007-06-03', 'Female', 'stu128@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 129', '129', 'STU129', '2007-06-04', 'Male', 'stu129@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 130', '130', 'STU130', '2007-06-05', 'Female', 'stu130@example.com', '2026-02-22', 2, 9, 26, 1, 1),

-- Standard 9 (Campus 2), Section 27 (C)
(1, 'Student', 'Student 131', '131', 'STU131', '2007-07-01', 'Male', 'stu131@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 132', '132', 'STU132', '2007-07-02', 'Female', 'stu132@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 133', '133', 'STU133', '2007-07-03', 'Male', 'stu133@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 134', '134', 'STU134', '2007-07-04', 'Female', 'stu134@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 135', '135', 'STU135', '2007-07-05', 'Male', 'stu135@example.com', '2026-02-22', 2, 9, 27, 1, 1),

-- Standard 10 (Campus 2), Section 28 (A)
(1, 'Student', 'Student 136', '136', 'STU136', '2006-05-01', 'Male', 'stu136@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 137', '137', 'STU137', '2006-05-02', 'Female', 'stu137@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 138', '138', 'STU138', '2006-05-03', 'Male', 'stu138@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 139', '139', 'STU139', '2006-05-04', 'Female', 'stu139@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 140', '140', 'STU140', '2006-05-05', 'Male', 'stu140@example.com', '2026-02-22', 2, 10, 28, 1, 1),

-- Standard 10 (Campus 2), Section 29 (B)
(1, 'Student', 'Student 141', '141', 'STU141', '2006-06-01', 'Female', 'stu141@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 142', '142', 'STU142', '2006-06-02', 'Male', 'stu142@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 143', '143', 'STU143', '2006-06-03', 'Female', 'stu143@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 144', '144', 'STU144', '2006-06-04', 'Male', 'stu144@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 145', '145', 'STU145', '2006-06-05', 'Female', 'stu145@example.com', '2026-02-22', 2, 10, 29, 1, 1),

-- Standard 10 (Campus 2), Section 30 (C)
(1, 'Student', 'Student 146', '146', 'STU146', '2006-07-01', 'Male', 'stu146@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 147', '147', 'STU147', '2006-07-02', 'Female', 'stu147@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 148', '148', 'STU148', '2006-07-03', 'Male', 'stu148@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 149', '149', 'STU149', '2006-07-04', 'Female', 'stu149@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 150', '150', 'STU150', '2006-07-05', 'Male', 'stu150@example.com', '2026-02-22', 2, 10, 30, 1, 1);




INSERT INTO exams (organization_id, academic_year_id, exam_term_id, exam_type_id, campus_id, standard_id, section_id, name, description, start_date, end_date, status)
VALUES
(1, 1, 1, 6, 1, 1, 1, 'Unit Test 1 - Section 1', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 1, 'Unit Test 2 - Section 1', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 1, 'Mid Term Exam - Section 1', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 1, 'Unit Test 3 - Section 1', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 1, 'Final Exam - Section 1', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 1, 2, 'Unit Test 1 - Section 2', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 2, 'Unit Test 2 - Section 2', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 2, 'Mid Term Exam - Section 2', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 2, 'Unit Test 3 - Section 2', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 2, 'Final Exam - Section 2', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 1, 3, 'Unit Test 1 - Section 3', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 3, 'Unit Test 2 - Section 3', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 3, 'Mid Term Exam - Section 3', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 3, 'Unit Test 3 - Section 3', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 3, 'Final Exam - Section 3', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 4, 'Unit Test 1 - Section 4', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 4, 'Unit Test 2 - Section 4', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 4, 'Mid Term Exam - Section 4', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 4, 'Unit Test 3 - Section 4', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 4, 'Final Exam - Section 4', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 5, 'Unit Test 1 - Section 5', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 5, 'Unit Test 2 - Section 5', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 5, 'Mid Term Exam - Section 5', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 5, 'Unit Test 3 - Section 5', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 5, 'Final Exam - Section 5', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 6, 'Unit Test 1 - Section 6', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 6, 'Unit Test 2 - Section 6', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 6, 'Mid Term Exam - Section 6', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 6, 'Unit Test 3 - Section 6', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 6, 'Final Exam - Section 6', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 7, 'Unit Test 1 - Section 7', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 7, 'Unit Test 2 - Section 7', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 7, 'Mid Term Exam - Section 7', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 7, 'Unit Test 3 - Section 7', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 7, 'Final Exam - Section 7', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 8, 'Unit Test 1 - Section 8', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 8, 'Unit Test 2 - Section 8', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 8, 'Mid Term Exam - Section 8', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 8, 'Unit Test 3 - Section 8', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 8, 'Final Exam - Section 8', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 9, 'Unit Test 1 - Section 9', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 9, 'Unit Test 2 - Section 9', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 9, 'Mid Term Exam - Section 9', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 9, 'Unit Test 3 - Section 9', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 9, 'Final Exam - Section 9', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 10, 'Unit Test 1 - Section 10', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 10, 'Unit Test 2 - Section 10', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 10, 'Mid Term Exam - Section 10', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 10, 'Unit Test 3 - Section 10', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 10, 'Final Exam - Section 10', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 11, 'Unit Test 1 - Section 11', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 11, 'Unit Test 2 - Section 11', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 11, 'Mid Term Exam - Section 11', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 11, 'Unit Test 3 - Section 11', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 11, 'Final Exam - Section 11', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 12, 'Unit Test 1 - Section 12', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 12, 'Unit Test 2 - Section 12', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 12, 'Mid Term Exam - Section 12', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 12, 'Unit Test 3 - Section 12', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 12, 'Final Exam - Section 12', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 13, 'Unit Test 1 - Section 13', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 13, 'Unit Test 2 - Section 13', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 13, 'Mid Term Exam - Section 13', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 13, 'Unit Test 3 - Section 13', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 13, 'Final Exam - Section 13', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 14, 'Unit Test 1 - Section 14', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 14, 'Unit Test 2 - Section 14', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 14, 'Mid Term Exam - Section 14', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 14, 'Unit Test 3 - Section 14', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 14, 'Final Exam - Section 14', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 15, 'Unit Test 1 - Section 15', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 15, 'Unit Test 2 - Section 15', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 15, 'Mid Term Exam - Section 15', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 15, 'Unit Test 3 - Section 15', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 15, 'Final Exam - Section 15', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 16, 'Unit Test 1 - Section 16', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 16, 'Unit Test 2 - Section 16', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 16, 'Mid Term Exam - Section 16', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 16, 'Unit Test 3 - Section 16', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 16, 'Final Exam - Section 16', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 17, 'Unit Test 1 - Section 17', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 17, 'Unit Test 2 - Section 17', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 17, 'Mid Term Exam - Section 17', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 17, 'Unit Test 3 - Section 17', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 17, 'Final Exam - Section 17', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 18, 'Unit Test 1 - Section 18', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 18, 'Unit Test 2 - Section 18', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 18, 'Mid Term Exam - Section 18', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 18, 'Unit Test 3 - Section 18', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 18, 'Final Exam - Section 18', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 19, 'Unit Test 1 - Section 19', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 19, 'Unit Test 2 - Section 19', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 19, 'Mid Term Exam - Section 19', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 19, 'Unit Test 3 - Section 19', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 19, 'Final Exam - Section 19', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 20, 'Unit Test 1 - Section 20', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 20, 'Unit Test 2 - Section 20', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 20, 'Mid Term Exam - Section 20', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 20, 'Unit Test 3 - Section 20', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 20, 'Final Exam - Section 20', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 21, 'Unit Test 1 - Section 21', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 21, 'Unit Test 2 - Section 21', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 21, 'Mid Term Exam - Section 21', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 21, 'Unit Test 3 - Section 21', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 21, 'Final Exam - Section 21', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 22, 'Unit Test 1 - Section 22', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 22, 'Unit Test 2 - Section 22', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 22, 'Mid Term Exam - Section 22', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 22, 'Unit Test 3 - Section 22', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 22, 'Final Exam - Section 22', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 23, 'Unit Test 1 - Section 23', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 23, 'Unit Test 2 - Section 23', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 23, 'Mid Term Exam - Section 23', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 23, 'Unit Test 3 - Section 23', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 23, 'Final Exam - Section 23', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 24, 'Unit Test 1 - Section 24', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 24, 'Unit Test 2 - Section 24', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 24, 'Mid Term Exam - Section 24', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 24, 'Unit Test 3 - Section 24', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 24, 'Final Exam - Section 24', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 25, 'Unit Test 1 - Section 25', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 25, 'Unit Test 2 - Section 25', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 25, 'Mid Term Exam - Section 25', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 25, 'Unit Test 3 - Section 25', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 25, 'Final Exam - Section 25', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 26, 'Unit Test 1 - Section 26', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 26, 'Unit Test 2 - Section 26', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 26, 'Mid Term Exam - Section 26', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 26, 'Unit Test 3 - Section 26', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 26, 'Final Exam - Section 26', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 27, 'Unit Test 1 - Section 27', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 27, 'Unit Test 2 - Section 27', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 27, 'Mid Term Exam - Section 27', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 27, 'Unit Test 3 - Section 27', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 27, 'Final Exam - Section 27', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 28, 'Unit Test 1 - Section 28', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 28, 'Unit Test 2 - Section 28', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 28, 'Mid Term Exam - Section 28', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 28, 'Unit Test 3 - Section 28', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 28, 'Final Exam - Section 28', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 29, 'Unit Test 1 - Section 29', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 29, 'Unit Test 2 - Section 29', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 29, 'Mid Term Exam - Section 29', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 29, 'Unit Test 3 - Section 29', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 29, 'Final Exam - Section 29', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 30, 'Unit Test 1 - Section 30', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 30, 'Unit Test 2 - Section 30', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 30, 'Mid Term Exam - Section 30', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 30, 'Unit Test 3 - Section 30', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 30, 'Final Exam - Section 30', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT');




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
  AND ss.is_deleted = FALSE;

-- Verification counts
SELECT 'Weightage Records Created' as Category, COUNT(*) as Count FROM exam_weightage;
SELECT 'Total Weightage Per Subject (Check for 100%)' as Category, standard_subject_id, SUM(weight_percentage) as Total 
FROM exam_weightage 
GROUP BY standard_subject_id;
