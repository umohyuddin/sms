
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
