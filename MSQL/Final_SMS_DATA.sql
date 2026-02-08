
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
---------------------------------------------------------------------------------

INSERT INTO modules(code,name,description,icon,route,display_order,system_module,active,created_at,created_by)
VALUES
('DASHBOARD', 'Dashboard', 'System overview and analytics', 'dashboard', '/dashboard', 1, TRUE, TRUE, NOW(), 1),
('USER', 'User Management', 'Manage users and accounts', 'people', '/users', 2, TRUE, TRUE, NOW(), 1),
('ROLE', 'Role & Permissions', 'Manage roles and permissions', 'security', '/roles', 3, TRUE, TRUE, NOW(), 1),
('ACADEMIC', 'Academic Management', 'Academic years, classes, sections', 'school', '/academics', 4, TRUE, TRUE, NOW(), 1),
('STUDENT', 'Student Management', 'Student profiles and enrollment', 'groups', '/students', 5, FALSE, TRUE, NOW(), 1),
('TEACHER', 'Teacher Management', 'Teacher profiles and assignments', 'person', '/teachers', 6, FALSE, TRUE, NOW(), 1),
('FEE', 'Fee Management', 'Fee setup, collection and reports', 'payments', '/fees', 7, FALSE, TRUE, NOW(), 1),
('EXAM', 'Examination', 'Exam scheduling and results', 'assignment', '/exams', 8, FALSE, TRUE, NOW(), 1),
('REPORT', 'Reports', 'System and academic reports', 'bar_chart', '/reports', 9, TRUE, TRUE, NOW(), 1),
('SETTINGS', 'System Settings', 'Application configuration', 'settings', '/settings', 10, TRUE, TRUE, NOW(), 1);
