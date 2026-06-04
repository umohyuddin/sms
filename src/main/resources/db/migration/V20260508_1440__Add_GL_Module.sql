-- Chart of Accounts
CREATE TABLE IF NOT EXISTS gl_accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    campus_id BIGINT NULL,
    account_code VARCHAR(50) NOT NULL,
    account_name VARCHAR(255) NOT NULL,
    parent_id BIGINT NULL,
    account_type ENUM('ASSET', 'LIABILITY', 'EQUITY', 'INCOME', 'EXPENSE') NOT NULL,
    is_group BOOLEAN NOT NULL DEFAULT FALSE,
    level INT NOT NULL DEFAULT 1,
    is_control_account BOOLEAN DEFAULT FALSE,
    is_cash_account BOOLEAN DEFAULT FALSE,
    is_bank_account BOOLEAN DEFAULT FALSE,
    is_reconcilable BOOLEAN DEFAULT FALSE,
    normal_balance ENUM('DEBIT', 'CREDIT') NOT NULL,
    currency_code VARCHAR(10) DEFAULT 'PKR',
    is_active BOOLEAN DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    CONSTRAINT fk_gl_accounts_parent FOREIGN KEY (parent_id) REFERENCES gl_accounts(id),
    CONSTRAINT uk_account_code UNIQUE (organization_id, account_code)
);

-- Journal Entries (Linked to Academic Year)
CREATE TABLE IF NOT EXISTS gl_journal_entries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    campus_id BIGINT NULL,
    academic_year_id BIGINT NOT NULL,
    entry_date DATE NOT NULL,
    reference_number VARCHAR(100),
    description TEXT,
    entry_type VARCHAR(50),
    status ENUM('DRAFT', 'POSTED', 'CANCELLED') DEFAULT 'DRAFT',
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at DATETIME NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    CONSTRAINT fk_gl_je_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);

-- Journal Entry Lines
CREATE TABLE IF NOT EXISTS gl_journal_entry_lines (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    journal_entry_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    description VARCHAR(255),
    debit DECIMAL(18, 4) DEFAULT 0.0000,
    credit DECIMAL(18, 4) DEFAULT 0.0000,
    campus_id BIGINT NULL,
    reference_id BIGINT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_je_line_entry FOREIGN KEY (journal_entry_id) REFERENCES gl_journal_entries(id),
    CONSTRAINT fk_je_line_account FOREIGN KEY (account_id) REFERENCES gl_accounts(id)
);
