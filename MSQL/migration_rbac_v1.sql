-- Migration Script: Phase 1 - Enterprise RBAC Schema
-- This script creates the new normalized structure and prepares for data migration.

-- 1. Create Actions Table (Global)
CREATE TABLE IF NOT EXISTS actions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL, -- e.g., VIEW, CREATE, UPDATE, DELETE, APPROVE, EXPORT
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    
    -- Audit fields
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

-- 2. Seed Initial Actions
INSERT IGNORE INTO actions (code, name, description) VALUES 
('VIEW', 'View', 'Read access to the resource'),
('CREATE', 'Create', 'Ability to create new records'),
('UPDATE', 'Update', 'Ability to modify existing records'),
('DELETE', 'Delete', 'Ability to remove records'),
('APPROVE', 'Approve', 'Ability to approve workflows'),
('EXPORT', 'Export', 'Ability to export data to Excel/PDF');

-- 3. Refactor Modules (Make Global)
-- Note: Current implementation has organization_id. We'll keep it for now (Dual support) 
-- but add a comment that it's deprecated.
ALTER TABLE modules MODIFY organization_id BIGINT NULL; 

-- 4. Refactor Resources (Prepare for mapping)
-- Add module_id if missing, deprecate endpoint fields.
ALTER TABLE resources ADD COLUMN IF NOT EXISTS module_id BIGINT;
ALTER TABLE resources MODIFY resource_endpoint VARCHAR(255) NULL;
ALTER TABLE resources MODIFY methodType VARCHAR(50) NULL;

-- 5. Create New Normalized Permissions Table
CREATE TABLE IF NOT EXISTS permissions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    module_id BIGINT NOT NULL,
    resource_id BIGINT NOT NULL,
    action_id BIGINT NOT NULL,
    organization_id BIGINT NULL, -- Optional for tenant-specific variations
    
    code VARCHAR(150) UNIQUE NOT NULL, -- e.g., FINANCE_FEE_VIEW
    name VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    
    -- Audit fields
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (module_id) REFERENCES modules(id),
    FOREIGN KEY (resource_id) REFERENCES resources(id),
    FOREIGN KEY (action_id) REFERENCES actions(id),
    UNIQUE KEY uq_mod_res_act (module_id, resource_id, action_id, organization_id)
);

-- 6. Create Role Permissions Mapping
CREATE TABLE IF NOT EXISTS role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- 7. Ensure User Roles exists with correct structure
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES system_users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);
