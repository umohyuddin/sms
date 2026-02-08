

INSERT INTO system_users
(username, email, phone, password_hash, is_active, is_verified, organization_id)
VALUES
('admin.user', 'admin@gmail.com', '03001234567',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 TRUE, TRUE, 1),

('teacher.user', 'teacher@example.com', '03007654321',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 TRUE, FALSE, 1),

('student.user', 'student@example.com', '03111223344',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 TRUE, FALSE, 1);


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