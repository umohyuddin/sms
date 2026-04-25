-- Create Institute Board Members table and Drop Institute Executives
DROP TABLE IF EXISTS institute_executives;

DROP TABLE IF EXISTS institute_board_members;
CREATE TABLE institute_board_members (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    role_id BIGINT,
    email VARCHAR(100),
    contact_number VARCHAR(20),
    term_start DATE,
    term_end DATE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_board_members_org FOREIGN KEY (organization_id) REFERENCES institutes(id),
    CONSTRAINT fk_board_members_role FOREIGN KEY (role_id) REFERENCES board_member_roles(id)
);

CREATE INDEX idx_institute_board_members_org ON institute_board_members (organization_id);
