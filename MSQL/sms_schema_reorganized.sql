DROP DATABASE IF EXISTS sms;
CREATE DATABASE IF NOT EXISTS sms;
USE sms;

-- =============================
-- LEVEL 0: CORE TABLES (No dependencies)
-- =============================

DROP TABLE IF EXISTS academic_years;
CREATE TABLE academic_years (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    code VARCHAR(20) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_months BIGINT NOT NULL,
    is_current BOOLEAN NOT NULL DEFAULT FALSE,
    status VARCHAR(20) NOT NULL,
    remarks VARCHAR(255),
    is_locked BOOLEAN NOT NULL DEFAULT FALSE,
    locked_at DATETIME,
    locked_by BIGINT,
    organization_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT uk_academic_year_code UNIQUE (code),
    CONSTRAINT uk_academic_year_date_range UNIQUE (start_date, end_date),
    CONSTRAINT chk_academic_year_dates CHECK (end_date >= start_date)
);
CREATE INDEX idx_academic_year_status ON academic_years (status);
CREATE INDEX idx_academic_year_is_current ON academic_years (is_current);

DROP TABLE IF EXISTS school_types;
CREATE TABLE school_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(30) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT chk_school_type_code_not_empty CHECK (LENGTH(code) > 0),
    CONSTRAINT chk_school_type_name_not_empty CHECK (LENGTH(name) > 0)
);
CREATE INDEX idx_school_type_code ON school_types (code);
CREATE INDEX idx_school_type_name ON school_types (name);

DROP TABLE IF EXISTS languages;
CREATE TABLE languages (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    iso_code VARCHAR(10) UNIQUE,
    name VARCHAR(50) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT chk_language_name_not_empty CHECK (LENGTH(name) > 0)
);
CREATE INDEX idx_language_iso_code ON languages (iso_code);
CREATE INDEX idx_language_name ON languages (name);

DROP TABLE IF EXISTS currencies;
CREATE TABLE currencies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    iso_code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    symbol VARCHAR(10),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS education_levels;
CREATE TABLE education_levels (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10) UNIQUE,
    name VARCHAR(50) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS curricula;
CREATE TABLE curricula (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE,
    name VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS facility_types;
CREATE TABLE facility_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS fee_recurrence_rules;
CREATE TABLE fee_recurrence_rules (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(30) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);
CREATE INDEX idx_fee_recurrence_rule_code ON fee_recurrence_rules (code);

DROP TABLE IF EXISTS country;
CREATE TABLE country (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    country_code VARCHAR(5) NOT NULL,
    country_name VARCHAR(100) NOT NULL,
    iso_code VARCHAR(3),
    phone_code VARCHAR(10),
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS actions;
CREATE TABLE actions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

DROP TABLE IF EXISTS modules;
CREATE TABLE modules (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    icon VARCHAR(50),
    route VARCHAR(100),
    display_order INT,
    system_module BOOLEAN NOT NULL DEFAULT TRUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at DATETIME NOT NULL,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

DROP TABLE IF EXISTS employee_type;
CREATE TABLE employee_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS salary_component;
CREATE TABLE salary_component (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    type ENUM('EARNING','DEDUCTION') NOT NULL,
    is_percentage BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

-- =============================
-- LEVEL 1: Tables depending on LEVEL 0
-- =============================

DROP TABLE IF EXISTS provinces;
CREATE TABLE provinces (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    country_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL UNIQUE,
    code VARCHAR(10),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_province_country FOREIGN KEY (country_id) REFERENCES country(id),
    CONSTRAINT uq_country_province UNIQUE (country_id, name)
);
CREATE INDEX idx_provinces_country_id ON provinces (country_id);

DROP TABLE IF EXISTS cities;
CREATE TABLE cities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    province_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10),
    is_active BOOLEAN DEFAULT TRUE,
    created_at DATETIME NOT NULL,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_province FOREIGN KEY (province_id) REFERENCES provinces (id)
);
CREATE INDEX idx_cities_province_id ON cities (province_id);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    is_system_role BOOLEAN DEFAULT FALSE,
    active BOOLEAN DEFAULT TRUE,
    created_at DATETIME NOT NULL,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

DROP TABLE IF EXISTS tax_types;
CREATE TABLE tax_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(50),
    tax_percentage DECIMAL(5,2) NOT NULL DEFAULT 0.00,
    country_id BIGINT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_tax_country FOREIGN KEY (country_id) REFERENCES country(id)
);

DROP TABLE IF EXISTS education_boards;
CREATE TABLE education_boards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(150) NOT NULL,
    country_id BIGINT,
    description VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT chk_education_board_name_not_empty CHECK (LENGTH(name) > 0),
    CONSTRAINT fk_education_board_country FOREIGN KEY (country_id) REFERENCES country(id)
);
CREATE INDEX idx_education_board_code ON education_boards (code);
CREATE INDEX idx_education_board_name ON education_boards (name);
CREATE INDEX idx_education_board_country ON education_boards (country_id);

DROP TABLE IF EXISTS fee_catalog;
CREATE TABLE fee_catalog (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    charge_type VARCHAR(50) NOT NULL,
    recurrence_rule VARCHAR(50),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS resources;
CREATE TABLE resources (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    module_id BIGINT,
    resource_code VARCHAR(150) UNIQUE NOT NULL,
    resource_name VARCHAR(150) NOT NULL,
    resource_endpoint VARCHAR(255) NULL,
    methodType VARCHAR(50) NULL,
    version VARCHAR(20) NOT NULL DEFAULT '1.0',
    description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_auth_required BOOLEAN NOT NULL DEFAULT TRUE,
    rate_limit INT,
    is_deprecated BOOLEAN NOT NULL DEFAULT FALSE,
    documentation_url VARCHAR(255),
    owner VARCHAR(100),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (module_id) REFERENCES modules(id)
);

DROP TABLE IF EXISTS salary_structure;
CREATE TABLE salary_structure (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_type_id BIGINT NOT NULL,
    base_salary DECIMAL(12,2) NOT NULL,
    effective_from DATE NOT NULL,
    effective_to DATE,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_salary_employee_type FOREIGN KEY (employee_type_id) REFERENCES employee_type(id),
    CHECK (effective_to IS NULL OR effective_to >= effective_from),
    UNIQUE (employee_type_id, is_current)
);

-- =============================
-- LEVEL 2: Institute and related
-- =============================

DROP TABLE IF EXISTS institutes;
CREATE TABLE institutes (
    id BIGINT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(100),
    website VARCHAR(100),
    tagline VARCHAR(255),
    contact_number VARCHAR(20),
    address VARCHAR(255),
    country_id BIGINT NOT NULL,
    province_id BIGINT NOT NULL,
    city_id BIGINT NOT NULL,
    established_date DATE,
    logo_url VARCHAR(255),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT chk_single_institute CHECK (id = 1),
    CONSTRAINT fk_institute_country FOREIGN KEY (country_id) REFERENCES country(id),
    CONSTRAINT fk_institute_province FOREIGN KEY (province_id) REFERENCES provinces(id),
    CONSTRAINT fk_institute_city FOREIGN KEY (city_id) REFERENCES cities(id)
);
CREATE INDEX idx_institutes_country_id ON institutes (country_id);
CREATE INDEX idx_institutes_province_id ON institutes (province_id);
CREATE INDEX idx_institutes_city_id ON institutes (city_id);

DROP TABLE IF EXISTS fee_component;
CREATE TABLE fee_component (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    fee_catalog_id BIGINT NOT NULL,
    component_code VARCHAR(50) NOT NULL,
    component_name VARCHAR(100) NOT NULL,
    account_code VARCHAR(50),
    taxable BOOLEAN NOT NULL DEFAULT FALSE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    discount_able BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_fee_component_catalog FOREIGN KEY (fee_catalog_id) REFERENCES fee_catalog (id)
);
CREATE INDEX idx_fee_component_catalog_id ON fee_component (fee_catalog_id);

DROP TABLE IF EXISTS permissions;
CREATE TABLE permissions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    module_id BIGINT NOT NULL,
    resource_id BIGINT NOT NULL,
    action_id BIGINT NOT NULL,
    organization_id BIGINT NULL,
    code VARCHAR(150) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    description VARCHAR(255),
    is_system_permission BOOLEAN DEFAULT FALSE,
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

DROP TABLE IF EXISTS institute_languages;
CREATE TABLE institute_languages (
    institute_id BIGINT,
    language_id BIGINT,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (institute_id, language_id),
    FOREIGN KEY (institute_id) REFERENCES institutes(id),
    FOREIGN KEY (language_id) REFERENCES languages(id)
);

-- =============================
-- LEVEL 3: Institute features
-- =============================

DROP TABLE IF EXISTS institute_contacts;
CREATE TABLE institute_contacts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    contact_person_name VARCHAR(150) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    is_primary BOOLEAN DEFAULT FALSE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);
CREATE INDEX idx_institute_contacts_institute ON institute_contacts (institute_id);
CREATE INDEX idx_institute_contacts_role ON institute_contacts (role_id);
CREATE INDEX idx_institute_contacts_deleted ON institute_contacts (is_deleted);

DROP TABLE IF EXISTS refund_policies;
CREATE TABLE refund_policies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    academic_year_id BIGINT,
    name VARCHAR(100),
    description TEXT,
    max_refund_percentage DECIMAL(5,2),
    max_refund_amount DECIMAL(10,2),
    allowed_after_days INT,
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);

DROP TABLE IF EXISTS institute_social_links;
CREATE TABLE institute_social_links (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    platform VARCHAR(50),
    url VARCHAR(255),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_social_links_institute ON institute_social_links (institute_id);

DROP TABLE IF EXISTS institute_facilities;
CREATE TABLE institute_facilities (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    facility_type_id BIGINT NOT NULL,
    description VARCHAR(255),
    capacity INT,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_facility_institute FOREIGN KEY (institute_id) REFERENCES institutes(id),
    CONSTRAINT fk_facility_type FOREIGN KEY (facility_type_id) REFERENCES facility_types(id)
);

DROP TABLE IF EXISTS institute_academic_offerings;
CREATE TABLE institute_academic_offerings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    education_level VARCHAR(50),
    curriculum VARCHAR(100),
    board VARCHAR(100),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_academic_offerings_institute ON institute_academic_offerings (institute_id);

DROP TABLE IF EXISTS institute_billing;
CREATE TABLE institute_billing (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT UNIQUE NOT NULL,
    billing_email VARCHAR(100),
    tax_number VARCHAR(50),
    currency VARCHAR(10),
    subscription_plan VARCHAR(50),
    payment_cycle VARCHAR(20),
    subscription_start DATE,
    subscription_end DATE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_billing_institute ON institute_billing (institute_id);

DROP TABLE IF EXISTS institute_documents;
CREATE TABLE institute_documents (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    document_type VARCHAR(50),
    file_name VARCHAR(150),
    file_url VARCHAR(255),
    expiry_date DATE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_documents_institute ON institute_documents (institute_id);

DROP TABLE IF EXISTS institute_accreditations;
CREATE TABLE institute_accreditations (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    authority_name VARCHAR(100),
    license_number VARCHAR(50),
    valid_from DATE,
    valid_to DATE,
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_accreditations_institute ON institute_accreditations (institute_id);

DROP TABLE IF EXISTS institute_financial_settings;
CREATE TABLE institute_financial_settings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    fee_recurrence_rule_id BIGINT,
    currency_id INT,
    language_id BIGINT,
    locale VARCHAR(10),
    allow_partial_payments BOOLEAN DEFAULT FALSE,
    late_fee_applicable BOOLEAN DEFAULT FALSE,
    late_fee_type VARCHAR(20),
    late_fee_amount DECIMAL(10, 2),
    is_tax_applicable BOOLEAN DEFAULT FALSE,
    tax_type_id BIGINT,
    is_tax_inclusive BOOLEAN DEFAULT FALSE,
    allow_refunds BOOLEAN DEFAULT FALSE,
    refund_policy_url VARCHAR(255),
    refund_window_days INT,
    refund_percentage DECIMAL(5, 2),
    refund_fixed_amount DECIMAL(10, 2),
    invoice_mandatory BOOLEAN DEFAULT TRUE,
    receipt_mandatory BOOLEAN DEFAULT TRUE,
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id),
    FOREIGN KEY (currency_id) REFERENCES currencies(id),
    FOREIGN KEY (tax_type_id) REFERENCES tax_types(id),
    FOREIGN KEY (fee_recurrence_rule_id) REFERENCES fee_recurrence_rules(id)
);
CREATE INDEX idx_institute_financial_settings_institute ON institute_financial_settings (institute_id);
CREATE INDEX idx_institute_financial_settings_academic_year ON institute_financial_settings (academic_year_id);

DROP TABLE IF EXISTS institute_profiles;
CREATE TABLE institute_profiles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT UNIQUE NOT NULL,
    description TEXT,
    mission TEXT,
    vision TEXT,
    `values` TEXT,
    about_chairperson TEXT,
    organization_email VARCHAR(100),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_profiles_institute ON institute_profiles (institute_id);

DROP TABLE IF EXISTS institute_board_members;
CREATE TABLE institute_board_members (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    role VARCHAR(50),
    email VARCHAR(100),
    contact_number VARCHAR(20),
    term_start DATE,
    term_end DATE,
    is_active BOOLEAN DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_board_members_institute ON institute_board_members (institute_id);

DROP TABLE IF EXISTS institute_executives;
CREATE TABLE institute_executives (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,
    full_name VARCHAR(100),
    title VARCHAR(50),
    email VARCHAR(100),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_executives_institute ON institute_executives (institute_id);

-- =============================
-- LEVEL 4: Campus and Academic structure
-- =============================

DROP TABLE IF EXISTS campuses;
CREATE TABLE campuses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    institute_id BIGINT,
    province_id BIGINT,
    city_id BIGINT,
    campus_name VARCHAR(100) NOT NULL,
    campus_code VARCHAR(100) UNIQUE,
    contact VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    website VARCHAR(100),
    address VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    logo LONGBLOB,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_campuses_institute FOREIGN KEY (institute_id) REFERENCES institutes (id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_campuses_province FOREIGN KEY (province_id) REFERENCES provinces (id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_campuses_city FOREIGN KEY (city_id) REFERENCES cities (id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT chk_active CHECK (active IN (0, 1)),
    CONSTRAINT chk_deleted CHECK (deleted IN (0, 1))
);
CREATE INDEX idx_campus_institute ON campuses (institute_id);
CREATE INDEX idx_campus_province ON campuses (province_id);
CREATE INDEX idx_campus_city ON campuses (city_id);
CREATE INDEX idx_campus_name ON campuses (campus_name);



DROP TABLE IF EXISTS admission_type;
CREATE TABLE admission_type (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);

DROP TABLE IF EXISTS standards;
CREATE TABLE standards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    campus_id BIGINT NOT NULL,
    standard_name VARCHAR(50) NOT NULL,
    standard_code VARCHAR(50),
    description VARCHAR(500),
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    UNIQUE (campus_id, standard_name),
    UNIQUE (campus_id, standard_code),
    CHECK (LENGTH(standard_name) > 0),
    CHECK (LENGTH(standard_code) > 0),
    FOREIGN KEY (campus_id) REFERENCES campuses (id) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE INDEX idx_standards_campus_id ON standards (campus_id);

DROP TABLE IF EXISTS sections;
CREATE TABLE sections (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15),
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    UNIQUE KEY uq_standard_section_name (standard_id, section_name),
    UNIQUE KEY uq_standard_section_code (standard_id, section_code),
    CONSTRAINT fk_sections_standard FOREIGN KEY (standard_id) REFERENCES standards (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX idx_sections_standard_id ON sections (standard_id);

DROP TABLE IF EXISTS fee_rates;
CREATE TABLE fee_rates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    campus_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    fee_component_id BIGINT,
    academic_year_id BIGINT NOT NULL,
    description VARCHAR(255),
    amount DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(3),
    effective_from DATE NOT NULL,
    effective_to DATE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_fee_rates_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),
    CONSTRAINT fk_fee_rates_standard FOREIGN KEY (standard_id) REFERENCES standards (id),
    CONSTRAINT fk_fee_rates_component FOREIGN KEY (fee_component_id) REFERENCES fee_component (id),
    CONSTRAINT fk_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT chk_fee_rates_amount CHECK (amount >= 0),
    CONSTRAINT chk_fee_rates_dates CHECK (effective_to IS NULL OR effective_to >= effective_from)
);
CREATE INDEX idx_fee_rates_campus_id ON fee_rates (campus_id);
CREATE INDEX idx_fee_rates_standard_id ON fee_rates (standard_id);
CREATE INDEX idx_fee_rates_component_id ON fee_rates (fee_component_id);
CREATE INDEX idx_fee_rates_academic_year_id ON fee_rates (academic_year_id);

-- =============================
-- LEVEL 5: Employee and Student
-- =============================

DROP TABLE IF EXISTS employee_master;
CREATE TABLE employee_master (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_code VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    middle_Name VARCHAR(100),
    gender VARCHAR(10),
    date_of_birth DATE,
    marital_status VARCHAR(20),
    cnic VARCHAR(20),
    passport_number VARCHAR(20),
    religion VARCHAR(50),
    nationality VARCHAR(50),
    blood_group VARCHAR(10),
    email VARCHAR(100) NOT NULL,
    primary_phone VARCHAR(20),
    secondary_phone VARCHAR(20),
    work_phone VARCHAR(20),
    joining_date DATE,
    probation_end_date DATE,
    employee_type_id BIGINT,
    profile_picture VARCHAR(255),
    bio TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    UNIQUE KEY uq_employee_code (employee_code),
    INDEX idx_employee_code (employee_code),
    INDEX idx_employee_active (active),
    INDEX idx_employee_type (employee_type_id),
    CONSTRAINT fk_employee_type FOREIGN KEY (employee_type_id) REFERENCES employee_type(id)
);

DROP TABLE IF EXISTS students;
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    student_code VARCHAR(50) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(200),
    cnic VARCHAR(20),
    passport_number VARCHAR(20),
    religion VARCHAR(50),
    nationality VARCHAR(50),
    blood_group VARCHAR(10),
    is_active TINYINT(1) DEFAULT 1,
    status VARCHAR(50),
    enrollment_date DATE NOT NULL,
    deleted TINYINT(1) DEFAULT 0,
    deleted_at DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    campus_id BIGINT,
    standard_id BIGINT,
    section_id BIGINT,
    admission_type_id BIGINT,
    academic_year_id BIGINT NOT NULL,
    FOREIGN KEY (campus_id) REFERENCES campuses (id),
    FOREIGN KEY (standard_id) REFERENCES standards (id),
    FOREIGN KEY (section_id) REFERENCES sections (id),
    FOREIGN KEY (admission_type_id) REFERENCES admission_type (id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);
CREATE INDEX idx_students_campus_id ON students (campus_id);
CREATE INDEX idx_students_standard_id ON students (standard_id);
CREATE INDEX idx_students_section_id ON students (section_id);
CREATE INDEX idx_students_admission_type_id ON students (admission_type_id);
CREATE INDEX idx_students_academic_year_id ON students (academic_year_id);

-- =============================
-- LEVEL 6: User and relation tables
-- =============================

DROP TABLE IF EXISTS system_users;
CREATE TABLE system_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(20) UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    employee_id BIGINT NULL UNIQUE,
    student_id BIGINT NULL UNIQUE,
    user_type VARCHAR(20) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    is_verified BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_system_user_employee FOREIGN KEY (employee_id) REFERENCES employee_master(id) ON DELETE SET NULL,
    CONSTRAINT fk_system_user_student FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE SET NULL,
    INDEX idx_user_type (user_type),
    INDEX idx_user_email (email),
    INDEX idx_user_employee (employee_id),
    INDEX idx_user_student (student_id)
);

DROP TABLE IF EXISTS student_document;
CREATE TABLE student_document (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    file_type VARCHAR(50),
    document_type VARCHAR(100) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_student_document_student FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);
CREATE INDEX idx_student_document_student_id ON student_document (student_id);

DROP TABLE IF EXISTS student_fee_assignments;
CREATE TABLE student_fee_assignments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    fee_rate_id BIGINT NOT NULL,
    total_amount DOUBLE NOT NULL,
    due_date DATE,
    assigned_date DATE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_sfa_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_sfa_fee_rate FOREIGN KEY (fee_rate_id) REFERENCES fee_rates (id),
    CONSTRAINT chk_student_fee_assign_amount CHECK (total_amount >= 0)
);
ALTER TABLE student_fee_assignments ADD CONSTRAINT uq_student_fee_unique UNIQUE (student_id, fee_rate_id);
CREATE INDEX idx_student_fee_assign_fee_rate_id ON student_fee_assignments (fee_rate_id);

DROP TABLE IF EXISTS student_fee_payments;
CREATE TABLE student_fee_payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    payment_date DATE,
    amount_paid DOUBLE NOT NULL,
    payment_month VARCHAR(20) NOT NULL,
    payment_year INT NOT NULL,
    payment_mode VARCHAR(50),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_fee_payment_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT fk_sfp_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT chk_student_fee_payment_amount CHECK (amount_paid >= 0)
);
CREATE INDEX idx_student_fee_payments_academic_year_id ON student_fee_payments (academic_year_id);
CREATE INDEX idx_student_fee_payments_student_id ON student_fee_payments (student_id);

DROP TABLE IF EXISTS student_fee_summary;
CREATE TABLE student_fee_summary (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    total_assigned_fee DECIMAL(10, 2) NOT NULL DEFAULT 0,
    total_paid DECIMAL(10, 2) NOT NULL DEFAULT 0,
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_student_fee_summary_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_Student_fee_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT chk_student_fee_summary_totals CHECK (total_assigned_fee >= 0 AND total_paid >= 0 AND balance >= 0)
);
ALTER TABLE student_fee_summary ADD CONSTRAINT uq_student_fee_summary UNIQUE (student_id, academic_year_id);
CREATE INDEX idx_student_fee_summary_academic_year_id ON student_fee_summary (academic_year_id);

DROP TABLE IF EXISTS discount_type;
CREATE TABLE discount_type (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    charge_type VARCHAR(30) NOT NULL,
    recurrence_rule VARCHAR(30),
    priority INT NOT NULL DEFAULT 0,
    display_order INT NOT NULL DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT uq_discount_type_code UNIQUE (code),
    CONSTRAINT chk_charge_type CHECK (charge_type IN ('FIXED','PERCENTAGE','PER_CREDIT','PER_SUBJECT','VARIABLE','SLAB_BASED','USAGE_BASED','DISCOUNTED')),
    CONSTRAINT chk_recurrence_rule CHECK (recurrence_rule IN ('ONE_TIME','MONTHLY','QUARTERLY','BI_MONTHLY','HALF_YEARLY','YEARLY','TERM_WISE','SEMESTER_WISE') OR recurrence_rule IS NULL)
);

DROP TABLE IF EXISTS discount_sub_type;
CREATE TABLE discount_sub_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    discount_type_id BIGINT NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    priority INT DEFAULT 0,
    display_order INT DEFAULT 0,
    created_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by BIGINT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_discount_type FOREIGN KEY (discount_type_id) REFERENCES discount_type (id)
);
CREATE INDEX idx_discount_sub_type_discount_type_id ON discount_sub_type (discount_type_id);

DROP TABLE IF EXISTS discount_rate;
CREATE TABLE discount_rate (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    value DECIMAL(10, 2) NOT NULL,
    is_percentage BOOLEAN NOT NULL DEFAULT TRUE,
    effective_from DATE NULL,
    effective_to DATE NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    discount_sub_type_id BIGINT NOT NULL,
    campus_id BIGINT NULL,
    academic_year_id BIGINT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT NULL,
    updated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT NULL,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_discount_rate_discount_sub_type FOREIGN KEY (discount_sub_type_id) REFERENCES discount_sub_type (id),
    CONSTRAINT fk_discount_rate_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),
    CONSTRAINT fk_discount_rate_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT chk_discount_rate_value CHECK (value >= 0)
);
CREATE INDEX idx_discount_rate_discount_sub_type_id ON discount_rate (discount_sub_type_id);
CREATE INDEX idx_discount_rate_campus_id ON discount_rate (campus_id);
CREATE INDEX idx_discount_rate_academic_year_id ON discount_rate (academic_year_id);

DROP TABLE IF EXISTS student_discount_assignment;
CREATE TABLE student_discount_assignment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    campus_id BIGINT NOT NULL,
    discount_rate_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    applied_amount DECIMAL(10, 2),
    applied_percentage DECIMAL(5, 2),
    reason VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_sda_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_sda_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),
    CONSTRAINT fk_sda_rate FOREIGN KEY (discount_rate_id) REFERENCES discount_rate (id),
    CONSTRAINT fk_sda_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT chk_student_discount_amount CHECK (applied_amount IS NULL OR applied_amount >= 0),
    CONSTRAINT chk_student_discount_percentage CHECK (applied_percentage IS NULL OR (applied_percentage >= 0 AND applied_percentage <= 100))
);
ALTER TABLE student_discount_assignment ADD CONSTRAINT uq_student_discount_unique UNIQUE (student_id, discount_rate_id, academic_year_id);
CREATE INDEX idx_student_discount_assignment_campus_id ON student_discount_assignment (campus_id);
CREATE INDEX idx_student_discount_assignment_rate_id ON student_discount_assignment (discount_rate_id);
CREATE INDEX idx_student_discount_assignment_year_id ON student_discount_assignment (academic_year_id);

DROP TABLE IF EXISTS role_permissions;
CREATE TABLE role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    organization_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES system_users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- =============================
-- LEVEL 7: Employee related tables
-- =============================

DROP TABLE IF EXISTS employee_document;
CREATE TABLE employee_document (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    file_type VARCHAR(50),
    document_type VARCHAR(100) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_teacher FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);
CREATE INDEX idx_employee_document_employee_id ON employee_document (employee_id);

DROP TABLE IF EXISTS employee_address;
CREATE TABLE employee_address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    address_type VARCHAR(50) NOT NULL,
    line1 VARCHAR(255) NOT NULL,
    line2 VARCHAR(255),
    city_id BIGINT NOT NULL,
    province_id BIGINT,
    postal_code VARCHAR(20),
    country_id BIGINT NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee_master (id),
    CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES cities (id),
    CONSTRAINT fk_province_address FOREIGN KEY (province_id) REFERENCES provinces (id),
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (id)
);
CREATE INDEX idx_employee_address_employee_id ON employee_address (employee_id);
CREATE INDEX idx_employee_address_city_id ON employee_address (city_id);
CREATE INDEX idx_employee_address_province_id ON employee_address (province_id);
CREATE INDEX idx_employee_address_country_id ON employee_address (country_id);

DROP TABLE IF EXISTS employee_emergency_contact;
CREATE TABLE employee_emergency_contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    contact_name VARCHAR(255) NOT NULL,
    relationship VARCHAR(100) NOT NULL,
    phone_primary VARCHAR(20) NOT NULL,
    phone_secondary VARCHAR(20),
    email VARCHAR(255),
    address VARCHAR(500),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee_emergency FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);
CREATE INDEX idx_employee_emergency_contact_employee_id ON employee_emergency_contact (employee_id);

DROP TABLE IF EXISTS employee_qualification;
CREATE TABLE employee_qualification (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    degree VARCHAR(100) NOT NULL,
    major_subject VARCHAR(100),
    institute VARCHAR(150),
    year_of_passing INT,
    grade VARCHAR(20),
    certificate VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee_qualification FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);
CREATE INDEX idx_employee_qualification_employee_id ON employee_qualification (employee_id);

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    department_code VARCHAR(50) NOT NULL UNIQUE,
    department_name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    parent_id BIGINT NULL,
    head_employee_id BIGINT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_department_parent FOREIGN KEY (parent_id) REFERENCES departments(id),
    CONSTRAINT fk_department_head FOREIGN KEY (head_employee_id) REFERENCES employee_master(id)
);

DROP TABLE IF EXISTS employee_department_history;
CREATE TABLE employee_department_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    department_id BIGINT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee_history FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT fk_department_history FOREIGN KEY (department_id) REFERENCES departments(id)
);
CREATE INDEX idx_employee_department_history_employee_id ON employee_department_history (employee_id);
CREATE INDEX idx_employee_department_history_department_id ON employee_department_history (department_id);

DROP TABLE IF EXISTS designations;
CREATE TABLE designations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    designation_code VARCHAR(50) NOT NULL UNIQUE,
    designation_name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    employee_type_id BIGINT NOT NULL,
    department_id BIGINT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_designation_employee_type FOREIGN KEY (employee_type_id) REFERENCES employee_type(id),
    CONSTRAINT fk_designation_department FOREIGN KEY (department_id) REFERENCES departments(id)
);
CREATE INDEX idx_designations_employee_type_id ON designations (employee_type_id);
CREATE INDEX idx_designations_department_id ON designations (department_id);

DROP TABLE IF EXISTS employee_designation_history;
CREATE TABLE employee_designation_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    designation_id BIGINT NOT NULL,
    department_id BIGINT,
    start_date DATETIME NOT NULL,
    end_date DATETIME,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee_designation FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT fk_designation FOREIGN KEY (designation_id) REFERENCES designations(id),
    CONSTRAINT fk_department_designation FOREIGN KEY (department_id) REFERENCES departments(id)
);
CREATE INDEX idx_employee_designation_history_employee_id ON employee_designation_history (employee_id);
CREATE INDEX idx_employee_designation_history_designation_id ON employee_designation_history (designation_id);
CREATE INDEX idx_employee_designation_history_department_id ON employee_designation_history (department_id);

DROP TABLE IF EXISTS employee_type_history;
CREATE TABLE employee_type_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    employee_type_id BIGINT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT fk_employee_type_history_employee FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT fk_employee_type_history_type FOREIGN KEY (employee_type_id) REFERENCES employee_type(id)
);
CREATE INDEX idx_employee_type_history_employee_id ON employee_type_history (employee_id);
CREATE INDEX idx_employee_type_history_type_id ON employee_type_history (employee_type_id);

-- =============================
-- LEVEL 8: Salary and Payroll
-- =============================

DROP TABLE IF EXISTS salary_structure_component;
CREATE TABLE salary_structure_component (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    salary_structure_id BIGINT NOT NULL,
    component_id BIGINT NOT NULL,
    value DECIMAL(12,2) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (salary_structure_id) REFERENCES salary_structure(id),
    FOREIGN KEY (component_id) REFERENCES salary_component(id),
    CONSTRAINT UK_salary_structure_component UNIQUE (salary_structure_id, component_id)
);

DROP TABLE IF EXISTS employee_salary;
CREATE TABLE employee_salary (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    salary_structure_id BIGINT NOT NULL,
    gross_salary DECIMAL(12,2) NOT NULL,
    total_deductions DECIMAL(12,2) NOT NULL,
    net_salary DECIMAL(12,2) NOT NULL,
    effective_date DATE NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    FOREIGN KEY (salary_structure_id) REFERENCES salary_structure(id),
    CONSTRAINT chk_employee_salary_amounts CHECK (gross_salary >= 0 AND total_deductions >= 0 AND net_salary >= 0)
);
CREATE INDEX idx_employee_salary_employee_id ON employee_salary (employee_id);
CREATE INDEX idx_employee_salary_structure_id ON employee_salary (salary_structure_id);

DROP TABLE IF EXISTS employee_deduction;
CREATE TABLE employee_deduction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    deduction_type VARCHAR(50) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    month DATE NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT chk_employee_deduction_amount CHECK (amount >= 0)
);
CREATE INDEX idx_employee_deduction_employee_id ON employee_deduction (employee_id);

DROP TABLE IF EXISTS payroll_period;
CREATE TABLE payroll_period (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status ENUM('PENDING','COMPLETED','CANCELLED') NOT NULL DEFAULT 'PENDING',
    description VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    CONSTRAINT chk_payroll_period_dates CHECK (end_date >= start_date)
);

DROP TABLE IF EXISTS salary_payment;
CREATE TABLE salary_payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_salary_id BIGINT NOT NULL,
    payment_date DATE NOT NULL,
    payment_mode ENUM('BANK_TRANSFER','CASH','CHEQUE','OTHER') NOT NULL,
    transaction_reference VARCHAR(100),
    amount_paid DECIMAL(12,2) NOT NULL,
    remarks VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_salary_id) REFERENCES employee_salary(id),
    CONSTRAINT chk_salary_payment_amount CHECK (amount_paid >= 0)
);
CREATE INDEX idx_salary_payment_employee_salary_id ON salary_payment (employee_salary_id);

DROP TABLE IF EXISTS employee_bonus;
CREATE TABLE employee_bonus (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    bonus_type VARCHAR(50) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    payroll_period_id BIGINT NOT NULL,
    remarks VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    FOREIGN KEY (payroll_period_id) REFERENCES payroll_period(id),
    CONSTRAINT chk_employee_bonus_amount CHECK (amount >= 0)
);
CREATE INDEX idx_employee_bonus_employee_id ON employee_bonus (employee_id);
CREATE INDEX idx_employee_bonus_payroll_period_id ON employee_bonus (payroll_period_id);

DROP TABLE IF EXISTS employee_advance;
CREATE TABLE employee_advance (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    repayment_months INT,
    start_date DATE,
    end_date DATE,
    balance DECIMAL(12,2),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT chk_employee_advance_amounts CHECK (amount >= 0 AND (balance IS NULL OR balance >= 0))
);
CREATE INDEX idx_employee_advance_employee_id ON employee_advance (employee_id);

DROP TABLE IF EXISTS salary_slip;
CREATE TABLE salary_slip (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_salary_id BIGINT NOT NULL,
    payroll_period_id BIGINT NOT NULL,
    slip_url VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    FOREIGN KEY (employee_salary_id) REFERENCES employee_salary(id),
    FOREIGN KEY (payroll_period_id) REFERENCES payroll_period(id)
);
CREATE INDEX idx_salary_slip_employee_salary_id ON salary_slip (employee_salary_id);
CREATE INDEX idx_salary_slip_payroll_period_id ON salary_slip (payroll_period_id);



DROP TABLE IF EXISTS subject_groups;
CREATE TABLE subject_groups (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    code VARCHAR(20) UNIQUE,
    name VARCHAR(100) NOT NULL,
  description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);



DROP TABLE IF EXISTS subjects;
CREATE TABLE subjects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    is_core BOOLEAN NOT NULL DEFAULT TRUE,

    subject_group_id BIGINT,  -- link to subject_groups

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (subject_group_id) REFERENCES subject_groups(id)
);




DROP TABLE IF EXISTS standard_subjects;
CREATE TABLE standard_subjects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,

    is_optional BOOLEAN NOT NULL DEFAULT FALSE,
    weekly_hours INT,
    theory_marks INT,
    practical_marks INT,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

UNIQUE (organization_id, standard_id, subject_id, academic_year_id, is_deleted),

    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);




DROP TABLE IF EXISTS teacher_subject_assignment;
CREATE TABLE teacher_subject_assignment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,

    teaching_role VARCHAR(30) DEFAULT 'PRIMARY', -- PRIMARY, ASSISTANT, SUBSTITUTE
    effective_from DATE NOT NULL,
    effective_to DATE,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (
        organization_id,
        employee_id,
        standard_id,
        section_id,
        subject_id,
        academic_year_id,
        effective_from
    ),

    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (section_id) REFERENCES sections(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);




DROP TABLE IF EXISTS student_attendance;
CREATE TABLE student_attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    attendance_date DATE NOT NULL,
    status ENUM('PRESENT','ABSENT','LEAVE') NOT NULL,
    marked_by BIGINT,
    remarks VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, student_id, attendance_date),

    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (section_id) REFERENCES sections(id),
    FOREIGN KEY (marked_by) REFERENCES employee_master(id) -- who marked the attendance
);




DROP TABLE IF EXISTS employee_attendance;
CREATE TABLE employee_attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    attendance_date DATE NOT NULL,
    status ENUM('PRESENT','ABSENT','LEAVE','HALF_DAY') NOT NULL,
    remarks VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, employee_id, attendance_date),

    FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    FOREIGN KEY (created_by) REFERENCES employee_master(id)
);






DROP TABLE IF EXISTS exam_type;
CREATE TABLE exam_type (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    UNIQUE (organization_id, code)
);



DROP TABLE IF EXISTS exam_terms;
CREATE TABLE exam_terms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL,          -- Mid Term, Final Term
    sequence_no INT NOT NULL,           -- order of the term in academic year
    academic_year_id BIGINT NOT NULL,   -- FK to academic_years table

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, name, academic_year_id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);



DROP TABLE IF EXISTS assessment_types;
CREATE TABLE assessment_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code VARCHAR(20) NOT NULL,   -- QUIZ, ASSIGNMENT
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    UNIQUE (organization_id, code)
);

DROP TABLE IF EXISTS grade_scales;
CREATE TABLE grade_scales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    min_percentage DECIMAL(5,2) NOT NULL,
    max_percentage DECIMAL(5,2) NOT NULL,
    grade VARCHAR(5) NOT NULL,
    remarks VARCHAR(50),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT
);


DROP TABLE IF EXISTS assessments;
CREATE TABLE assessments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    teacher_subject_assignment_id BIGINT NOT NULL,
    assessment_type_id BIGINT NOT NULL,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    total_marks DECIMAL(6,2) NOT NULL,
    passing_marks DECIMAL(6,2),
    assessment_date DATE,
    due_date DATE,
    is_published BOOLEAN NOT NULL DEFAULT FALSE,
    academic_year_id BIGINT NOT NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (teacher_subject_assignment_id) REFERENCES teacher_subject_assignment(id),
    FOREIGN KEY (assessment_type_id) REFERENCES assessment_types(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);

DROP TABLE IF EXISTS student_assessments;
CREATE TABLE student_assessments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    assessment_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    obtained_marks DECIMAL(6,2),
    grade VARCHAR(5),
    remarks VARCHAR(255),
    submission_status ENUM('SUBMITTED','NOT_SUBMITTED') DEFAULT 'NOT_SUBMITTED',
    evaluated_by BIGINT,
    evaluated_at DATETIME,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, assessment_id, student_id),

    FOREIGN KEY (assessment_id) REFERENCES assessments(id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (evaluated_by) REFERENCES employee_master(id)
);


DROP TABLE IF EXISTS assessment_attachments;
CREATE TABLE assessment_attachments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    assessment_id BIGINT NOT NULL,
    file_url VARCHAR(255) NOT NULL,
    file_type VARCHAR(50),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (assessment_id) REFERENCES assessments(id)
);


DROP TABLE IF EXISTS exams;
CREATE TABLE exams (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    exam_term_id BIGINT NOT NULL,
    campus_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    name VARCHAR(150) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status ENUM('DRAFT','SCHEDULED','IN_PROGRESS','LOCKED','PUBLISHED') DEFAULT 'DRAFT',

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, academic_year_id, exam_term_id, standard_id, section_id),

    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id),
    FOREIGN KEY (exam_term_id) REFERENCES exam_terms(id),
    FOREIGN KEY (campus_id) REFERENCES campuses(id),
    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (section_id) REFERENCES sections(id)
);

DROP TABLE IF EXISTS exam_subjects;
CREATE TABLE exam_subjects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    exam_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    total_marks DECIMAL(6,2) NOT NULL,
    passing_marks DECIMAL(6,2) NOT NULL,
    exam_date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    evaluator_id BIGINT,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, exam_id, subject_id),
    FOREIGN KEY (exam_id) REFERENCES exams(id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    FOREIGN KEY (evaluator_id) REFERENCES employee_master(id)
);

DROP TABLE IF EXISTS student_exam_attendance;
CREATE TABLE student_exam_attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    exam_subject_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    status ENUM('PRESENT','ABSENT','UFM') NOT NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, exam_subject_id, student_id),
    FOREIGN KEY (exam_subject_id) REFERENCES exam_subjects(id),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

DROP TABLE IF EXISTS student_exam_marks;
CREATE TABLE student_exam_marks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    exam_subject_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    obtained_marks DECIMAL(6,2),
    grace_marks DECIMAL(6,2) DEFAULT 0,
    is_locked BOOLEAN DEFAULT FALSE,
    remarks VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    UNIQUE (organization_id, exam_subject_id, student_id),
    FOREIGN KEY (exam_subject_id) REFERENCES exam_subjects(id),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

DROP TABLE IF EXISTS exam_weightage;
CREATE TABLE exam_weightage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    exam_term_id BIGINT NOT NULL,
    weight_percentage DECIMAL(5,2) NOT NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    UNIQUE (organization_id, standard_id, subject_id, exam_term_id),
    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    FOREIGN KEY (exam_term_id) REFERENCES exam_terms(id)
);

DROP TABLE IF EXISTS student_term_result;
CREATE TABLE student_term_result (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    exam_term_id BIGINT NOT NULL,
    total_marks DECIMAL(8,2),
    obtained_marks DECIMAL(8,2),
    percentage DECIMAL(5,2),
    grade VARCHAR(10),
    gpa DECIMAL(3,2),
    generated_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    UNIQUE (organization_id, student_id, academic_year_id, exam_term_id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id),
    FOREIGN KEY (exam_term_id) REFERENCES exam_terms(id)
);

DROP TABLE IF EXISTS report_card;
CREATE TABLE report_card (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    generated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    file_url VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);

DROP TABLE IF EXISTS student_activity;
CREATE TABLE student_activity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    activity_type VARCHAR(100),
    description VARCHAR(255),
    activity_date DATE,
    grade VARCHAR(10),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE student_academic_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    status ENUM('PROMOTED','RETAINED','WITHDRAWN') NOT NULL,
    remarks VARCHAR(255),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (section_id) REFERENCES sections(id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);


CREATE TABLE timetable (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    standard_id BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL,
    day_of_week ENUM('MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY') NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    room VARCHAR(50),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (standard_id) REFERENCES standards(id),
    FOREIGN KEY (section_id) REFERENCES sections(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    FOREIGN KEY (teacher_id) REFERENCES employee_master(id)
);
