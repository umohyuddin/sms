-- Global Actions
CREATE TABLE IF NOT EXISTS actions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT
);

-- Seed Actions
INSERT INTO actions (code, name, description) VALUES 
('VIEW', 'View', 'View records'),
('CREATE', 'Create', 'Create new records'),
('UPDATE', 'Update', 'Update existing records'),
('DELETE', 'Delete', 'Delete records'),
('APPROVE', 'Approve', 'Approve workflows or records'),
('EXPORT', 'Export', 'Export data');

-- Ensure Modules and Resources have audit fields and global scope where required
-- (Assuming tables already exist from previous partial implementations, but ensuring consistency)

-- Permissions Refactoring
-- Note: Dropping old constraints and adding new ones if necessary. 
-- In a real migration we would handle data transfer, but here we focus on the structure.

ALTER TABLE permissions 
ADD COLUMN IF NOT EXISTS action_id BIGINT,
ADD COLUMN IF NOT EXISTS resource_id BIGINT;

-- Link with Actions and Resources
-- Constraints will be enforced by JPA, but SQL ones are good too.
-- FOREIGN KEY (action_id) REFERENCES actions(id)
-- FOREIGN KEY (resource_id) REFERENCES resources(id)

-- Role Permissions Join Table consistency
CREATE TABLE IF NOT EXISTS role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- User Roles Join Table consistency
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES system_users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);
