DROP
DATABASE IF EXISTS sms;
CREATE
DATABASE IF NOT EXISTS sms;
USE
sms;


DROP TABLE IF EXISTS academic_years;
CREATE TABLE academic_years (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(50) NOT NULL,            -- e.g. "2024-2025"
    code VARCHAR(20) NOT NULL,

    start_date DATE NOT NULL,
    end_date DATE NOT NULL,

    total_months BIGINT NOT NULL,

    is_current BOOLEAN NOT NULL DEFAULT FALSE,

    status VARCHAR(20) NOT NULL,          -- AcademicYearStatus (ENUM stored as STRING)

    remarks VARCHAR(255),

    is_locked BOOLEAN NOT NULL DEFAULT FALSE,
    locked_at DATETIME,
    locked_by BIGINT,

    organization_id BIGINT NOT NULL,

    -- Audit fields (from AuditableEntity)
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,

    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,

    deleted_at DATETIME,
    deleted_by BIGINT,

    -- Constraints
    CONSTRAINT uk_academic_year_code UNIQUE (code),
    CONSTRAINT uk_academic_year_date_range UNIQUE (start_date, end_date)
);

-- Indexes
CREATE INDEX idx_academic_year_status ON academic_years (status);
CREATE INDEX idx_academic_year_is_current ON academic_years (is_current);

DROP TABLE IF EXISTS school_types;
CREATE TABLE school_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(30) UNIQUE NOT NULL,   -- PRIVATE, PUBLIC, CHARTER
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
    iso_code VARCHAR(10) UNIQUE,   -- en, ur, ar
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
    code VARCHAR(10) UNIQUE,       -- e.g., PS, P, M, S, HS
    name VARCHAR(50) NOT NULL,     -- e.g., Primary, Secondary
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
    code VARCHAR(50) UNIQUE NOT NULL,      -- e.g., LAB, LIBRARY, PLAYGROUND
    name VARCHAR(100) NOT NULL,            -- e.g., "Computer Lab", "Library", "Playground"
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
    code VARCHAR(30) UNIQUE NOT NULL,   -- ONE_TIME, MONTHLY, QUARTERLY, etc.
    name VARCHAR(100) NOT NULL,         -- One Time, Monthly, Quarterly, etc.
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

-- Table: provinces
-- Purpose:
--   Stores the list of provinces/states used across the school management system.
--   Each campus, student, and employee address references a province from this table.
DROP TABLE IF EXISTS provinces;
CREATE TABLE provinces
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
        country_id BIGINT NOT NULL,
    name       VARCHAR(100) NOT NULL UNIQUE,
    code       VARCHAR(10),
    is_active  BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at DATETIME,
    created_by BIGINT,
    updated_at DATETIME,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,
    deleted    BOOLEAN      NOT NULL DEFAULT FALSE,
CONSTRAINT fk_province_country FOREIGN KEY (country_id) REFERENCES country(id),
     CONSTRAINT uq_country_province UNIQUE (country_id, name)
);

-- Table: cities
-- Purpose:
--   Stores the list of cities belonging to a province.
--   A city must belong to a valid province via province_id.
--   Used for campus addresses, student records, staff records, etc.
DROP TABLE IF EXISTS cities;
CREATE TABLE cities
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    province_id BIGINT       NOT NULL,
    name        VARCHAR(100) NOT NULL,
    code        VARCHAR(10),
    is_active   BOOLEAN               DEFAULT TRUE,
    created_at  DATETIME     NOT NULL,
    created_by  BIGINT,
    updated_at  DATETIME,
    updated_by  BIGINT,
    deleted_at  DATETIME,
    deleted_by  BIGINT,
    deleted     BOOLEAN      NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_province FOREIGN KEY (province_id) REFERENCES provinces (id)
);

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,

    code VARCHAR(50) UNIQUE NOT NULL,   -- SUPER_ADMIN, TEACHER, HR
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),

    is_system_role BOOLEAN DEFAULT FALSE,
    active BOOLEAN DEFAULT TRUE,
    created_at  DATETIME     NOT NULL,
      created_by  BIGINT,
      updated_at  DATETIME,
      updated_by  BIGINT,
      deleted_at  DATETIME,
      deleted_by  BIGINT,
      deleted     BOOLEAN      NOT NULL DEFAULT FALSE
);



-- TODO_
-- institutes TABLE
DROP TABLE IF EXISTS institutes;

CREATE TABLE institutes (
    id BIGINT PRIMARY KEY,              -- always 1

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
        CONSTRAINT fk_institute_country
            FOREIGN KEY (country_id) REFERENCES country(id),
        CONSTRAINT fk_institute_province
            FOREIGN KEY (province_id) REFERENCES provinces(id),
        CONSTRAINT fk_institute_city
            FOREIGN KEY (city_id) REFERENCES cities(id)
);



DROP TABLE IF EXISTS tax_types;
CREATE TABLE tax_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE NOT NULL,   -- VAT, GST, SALES_TAX
    name VARCHAR(50),
    tax_percentage DECIMAL(5,2) NOT NULL DEFAULT 0.00,
    country_id BIGINT,                   -- reference to countries table
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
    country_id BIGINT,                 -- FK to countries table
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



DROP TABLE IF EXISTS institute_languages;
CREATE TABLE institute_languages (
    institute_id BIGINT,
    language_id BIGINT,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (institute_id, language_id),
    FOREIGN KEY (institute_id) REFERENCES institutes(id),
    FOREIGN KEY (language_id) REFERENCES languages(id)
);



DROP TABLE IF EXISTS institute_contacts;

CREATE TABLE institute_contacts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,          -- FK to institutes
    role_id BIGINT NOT NULL,               -- FK to roles

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
DROP TABLE IF EXISTS refund_policies;
CREATE TABLE refund_policies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,           -- FK to institutes
    academic_year_id BIGINT,                -- FK to academic_years

    name VARCHAR(100),
    description TEXT,

    max_refund_percentage DECIMAL(5,2),    -- e.g., 50.00 for 50%
    max_refund_amount DECIMAL(10,2),       -- e.g., 1000.00
    allowed_after_days INT,                 -- e.g., 30 days after payment

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


-- Indexes for faster lookup
CREATE INDEX idx_institute_contacts_institute ON institute_contacts (institute_id);
CREATE INDEX idx_institute_contacts_role ON institute_contacts (role_id);
CREATE INDEX idx_institute_contacts_deleted ON institute_contacts (is_deleted);

DROP TABLE IF EXISTS institute_social_links;
CREATE TABLE institute_social_links (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,

    platform VARCHAR(50),     -- Facebook, LinkedIn, Instagram
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

DROP TABLE IF EXISTS institute_academic_offerings;
CREATE TABLE institute_academic_offerings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,

    education_level VARCHAR(50),    -- Primary, Secondary
    curriculum VARCHAR(100),        -- Cambridge, IB
    board VARCHAR(100),             -- FBISE, GCSE

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

DROP TABLE IF EXISTS institute_facilities;
CREATE TABLE institute_facilities (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT NOT NULL,

    facility_type VARCHAR(50),   -- Lab, Library, Playground
    description VARCHAR(255),
    capacity INT,

    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,

    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,

    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (institute_id) REFERENCES institutes(id)
);
CREATE INDEX idx_institute_facilities_institute ON institute_facilities (institute_id);

DROP TABLE IF EXISTS institute_billing;
CREATE TABLE institute_billing (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    institute_id BIGINT UNIQUE NOT NULL,

    billing_email VARCHAR(100),
    tax_number VARCHAR(50),
    currency VARCHAR(10),

    subscription_plan VARCHAR(50),     -- Free, Basic, Premium
    payment_cycle VARCHAR(20),          -- Monthly, Yearly
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

    document_type VARCHAR(50),     -- License, Registration
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

    authority_name VARCHAR(100),   -- KHDA, Ofsted, FBISE
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
    -- Currency and Language Settings
    currency_id INT,
    language_id BIGINT,
    locale VARCHAR(10),

    allow_partial_payments BOOLEAN DEFAULT FALSE,
    late_fee_applicable BOOLEAN DEFAULT FALSE,
    late_fee_type VARCHAR(20),              -- Fixed, Percentage
    late_fee_amount DECIMAL(10, 2),

    -- Tax Rules
    is_tax_applicable BOOLEAN DEFAULT FALSE,
    tax_type_id BIGINT,
    is_tax_inclusive BOOLEAN DEFAULT FALSE,

    -- Refund Rules
    allow_refunds BOOLEAN DEFAULT FALSE,
    refund_policy_url VARCHAR(255),
    refund_window_days INT,
    refund_percentage DECIMAL(5, 2),
    refund_fixed_amount DECIMAL(10, 2),

    -- Compliance
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

    about_chairperson TEXT,        -- optional
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
    role VARCHAR(50),             -- Chairman, Director, Secretary
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
    title VARCHAR(50),        -- CEO, COO, Director Academics
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



CREATE TABLE subjects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255),

    is_core BOOLEAN NOT NULL DEFAULT TRUE,

    active BOOLEAN NOT NULL DEFAULT TRUE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,

    created_at DATETIME,
    created_by BIGINT,

    updated_at DATETIME,
    updated_by BIGINT,

    deleted_at DATETIME,
    deleted_by BIGINT
);


-- Table: campuses
-- Purpose:
--   Stores all campus records for each institute within the school management system.
--   An institute can have multiple campuses (One-to-Many relationship).
--   Each campus belongs to a province and a city for address mapping.
--   Used in admissions, fee management, user profiles, and employee allocation.

DROP TABLE IF EXISTS `campuses`;
CREATE TABLE campuses
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    institute_id BIGINT,
    province_id  BIGINT,
    city_id      BIGINT,
    campus_name  VARCHAR(100) NOT NULL,
    campus_code  VARCHAR(100) UNIQUE,
    contact      VARCHAR(15),
    email        VARCHAR(100) UNIQUE,
    website      VARCHAR(100),
    address      VARCHAR(255),
    active       BOOLEAN      NOT NULL DEFAULT TRUE,
    logo         LONGBLOB,
    deleted      BOOLEAN      NOT NULL DEFAULT FALSE,

    created_at   DATETIME,
    created_by   BIGINT,
    updated_at   DATETIME,
    updated_by   BIGINT,
    deleted_at   DATETIME,
    deleted_by   BIGINT,

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





CREATE TABLE admission_type
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code        VARCHAR(50)  NOT NULL UNIQUE,
    name        VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,

    deleted     BOOLEAN      NOT NULL DEFAULT FALSE,

    created_at  DATETIME,
    created_by  BIGINT,
    updated_at  DATETIME,
    updated_by  BIGINT,
    deleted_at  DATETIME,
    deleted_by  BIGINT

);

-- standards TABLE
DROP TABLE IF EXISTS standards;
CREATE TABLE standards
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    campus_id     BIGINT      NOT NULL,
    standard_name VARCHAR(50) NOT NULL,
    standard_code VARCHAR(50),
    description   VARCHAR(500),

    deleted       BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at    DATETIME,
    created_by    BIGINT,
    updated_at    DATETIME,
    updated_by    BIGINT,
    deleted_at    DATETIME,
    deleted_by    BIGINT,
    UNIQUE (campus_id, standard_name), -- Standard name unique per campus
    UNIQUE (campus_id, standard_code), -- Standard code unique per campus
    CHECK (LENGTH(standard_name) > 0), -- Name cannot be empty
    CHECK (LENGTH(standard_code) > 0), -- Code cannot be empty
    FOREIGN KEY (campus_id) REFERENCES campuses (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

-- sections TABLE
DROP TABLE IF EXISTS `sections`;
CREATE TABLE sections
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    standard_id  BIGINT      NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15),
    deleted      BOOLEAN     NOT NULL DEFAULT FALSE,

    created_at   DATETIME,
    created_by   BIGINT,
    updated_at   DATETIME,
    updated_by   BIGINT,
    deleted_at   DATETIME,
    deleted_by   BIGINT,
-- Unique constraints: a section name/code must be unique within a standard
    UNIQUE KEY uq_standard_section_name (standard_id, section_name),
    UNIQUE KEY uq_standard_section_code (standard_id, section_code),

    -- Foreign key with cascading update and delete
    CONSTRAINT fk_sections_standard
        FOREIGN KEY (standard_id) REFERENCES standards (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

-- students TABLE
DROP TABLE IF EXISTS `students`;
CREATE TABLE students
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id   BIGINT NOT NULL,

    first_name        VARCHAR(50)  NOT NULL,
    full_name         VARCHAR(100) NOT NULL,
    last_name         VARCHAR(50)  NOT NULL,
    student_code      VARCHAR(50)  NOT NULL UNIQUE,
    date_of_birth     DATE         NOT NULL,
    gender            VARCHAR(10)  NOT NULL,
    email             VARCHAR(100) UNIQUE,
    phone             VARCHAR(15),
    address           VARCHAR(200),
    cnic              VARCHAR(20),
    passport_number   VARCHAR(20),
    religion          VARCHAR(50),
    nationality       VARCHAR(50),
    blood_group       VARCHAR(10),
    is_active         TINYINT(1) DEFAULT 1,
    status            VARCHAR(50),
    enrollment_date   DATE         NOT NULL,
    deleted           TINYINT(1) DEFAULT 0,
    deleted_at        DATETIME,
    created_at        DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at        DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- Foreign keys
    campus_id         BIGINT,
    standard_id       BIGINT,
    section_id        BIGINT,
    admission_type_id BIGINT,
    academic_year_id  BIGINT       NOT NULL,

    FOREIGN KEY (campus_id) REFERENCES campuses (id),
    FOREIGN KEY (standard_id) REFERENCES standards (id),
    FOREIGN KEY (section_id) REFERENCES sections (id),
    FOREIGN KEY (admission_type_id) REFERENCES admission_type (id),
    FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);

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
    CONSTRAINT fk_student_document_student
        FOREIGN KEY (student_id)
        REFERENCES students(id)
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS `fee_catalog`;
CREATE TABLE fee_catalog
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    code            VARCHAR(50)  NOT NULL UNIQUE,
    name            VARCHAR(100) NOT NULL,
    description     VARCHAR(255),
    charge_type     VARCHAR(50)  NOT NULL,
    recurrence_rule VARCHAR(50),
    active          BOOLEAN      NOT NULL DEFAULT TRUE,
    deleted         BOOLEAN      NOT NULL DEFAULT FALSE,

    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT
);

DROP TABLE IF EXISTS `fee_component`;
CREATE TABLE fee_component
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    fee_catalog_id BIGINT       NOT NULL,
    component_code VARCHAR(50)  NOT NULL,
    component_name VARCHAR(100) NOT NULL,
    account_code   VARCHAR(50),
    taxable        BOOLEAN      NOT NULL DEFAULT FALSE,
    active         BOOLEAN      NOT NULL DEFAULT TRUE,
    deleted        BOOLEAN      NOT NULL DEFAULT FALSE,
    discount_able  BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at     DATETIME,
    created_by     BIGINT,
    updated_at     DATETIME,
    updated_by     BIGINT,
    deleted_at     DATETIME,
    deleted_by     BIGINT,
    CONSTRAINT fk_fee_component_catalog
        FOREIGN KEY (fee_catalog_id) REFERENCES fee_catalog (id)
);



DROP TABLE IF EXISTS fee_rates;
CREATE TABLE fee_rates
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id  BIGINT NOT NULL,
    campus_id        BIGINT         NOT NULL,
    standard_id      BIGINT         NOT NULL,
    fee_component_id BIGINT,
    academic_year_id BIGINT         NOT NULL,
    description      VARCHAR(255),
    amount           DECIMAL(10, 2) NOT NULL,
    currency         VARCHAR(3),
    effective_from   DATE           NOT NULL,
    effective_to     DATE,
    active           BOOLEAN        NOT NULL DEFAULT TRUE,
    deleted          BOOLEAN        NOT NULL DEFAULT FALSE,

    created_at       DATETIME,
    created_by       BIGINT,
    updated_at       DATETIME,
    updated_by       BIGINT,
    deleted_at       DATETIME,
    deleted_by       BIGINT,

    CONSTRAINT fk_fee_rates_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),

    CONSTRAINT fk_fee_rates_standard FOREIGN KEY (standard_id) REFERENCES standards (id),

    CONSTRAINT fk_fee_rates_component FOREIGN KEY (fee_component_id) REFERENCES fee_component (id),
    CONSTRAINT fk_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);

DROP TABLE IF EXISTS student_fee_assignments;
CREATE TABLE student_fee_assignments
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    student_id    BIGINT NOT NULL,
    fee_rate_id   BIGINT NOT NULL,

    total_amount DOUBLE NOT NULL,
    due_date      DATE,
    assigned_date DATE,

    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_sfa_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_sfa_fee_rate FOREIGN KEY (fee_rate_id) REFERENCES fee_rates (id)
);
ALTER TABLE student_fee_assignments ADD CONSTRAINT uq_student_fee_unique UNIQUE (student_id, fee_rate_id);


DROP TABLE IF EXISTS student_fee_payments;
CREATE TABLE student_fee_payments
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id  BIGINT NOT NULL,
    academic_year_id BIGINT      NOT NULL,
    student_id       BIGINT      NOT NULL,
    payment_date     DATE,
    amount_paid DOUBLE NOT NULL,
    payment_month    VARCHAR(20) NOT NULL,
    payment_year     INT         NOT NULL,
    payment_mode     VARCHAR(50),

    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_fee_payment_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id),
    CONSTRAINT fk_sfp_student FOREIGN KEY (student_id) REFERENCES students (id)
);


DROP TABLE IF EXISTS student_fee_summary;
CREATE TABLE student_fee_summary
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id    BIGINT NOT NULL,
    student_id         BIGINT         NOT NULL,
    academic_year_id   BIGINT         NOT NULL,
    total_assigned_fee DECIMAL(10, 2) NOT NULL DEFAULT 0,
    total_paid         DECIMAL(10, 2) NOT NULL DEFAULT 0,
    balance            DECIMAL(10, 2) NOT NULL DEFAULT 0,
    updated_at         TIMESTAMP               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_student_fee_summary_student
        FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_Student_fee_academic_year
        FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);
ALTER TABLE student_fee_summary ADD CONSTRAINT uq_student_fee_summary UNIQUE (student_id, academic_year_id);

DROP TABLE IF EXISTS discount_type;
CREATE TABLE discount_type
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    code            VARCHAR(50)  NOT NULL,
    name            VARCHAR(150) NOT NULL,
    description     VARCHAR(500),

    charge_type     VARCHAR(30)  NOT NULL,
    recurrence_rule VARCHAR(30),

    priority        INT          NOT NULL DEFAULT 0,
    display_order   INT          NOT NULL DEFAULT 0,
    active          BOOLEAN      NOT NULL DEFAULT TRUE,
    deleted         BOOLEAN      NOT NULL DEFAULT FALSE,

    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT,
    CONSTRAINT uq_discount_type_code UNIQUE (code),

    CONSTRAINT chk_charge_type CHECK (
        charge_type IN (
                        'FIXED',
                        'PERCENTAGE',
                        'PER_CREDIT',
                        'PER_SUBJECT',
                        'VARIABLE',
                        'SLAB_BASED',
                        'USAGE_BASED',
                        'DISCOUNTED'
            )
        ),

    CONSTRAINT chk_recurrence_rule CHECK (
        recurrence_rule IN (
                            'ONE_TIME',
                            'MONTHLY',
                            'QUARTERLY',
                            'BI_MONTHLY',
                            'HALF_YEARLY',
                            'YEARLY',
                            'TERM_WISE',
                            'SEMESTER_WISE'
            )
            OR recurrence_rule IS NULL
        )
);



CREATE TABLE discount_sub_type
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id  BIGINT NOT NULL,
    discount_type_id BIGINT             NOT NULL,
    code             VARCHAR(50) UNIQUE NOT NULL,
    name             VARCHAR(150)       NOT NULL,
    description      VARCHAR(500),
    is_active        BOOLEAN            NOT NULL DEFAULT TRUE,
    priority         INT                         DEFAULT 0,
    display_order    INT                         DEFAULT 0,
    created_by       BIGINT,
    created_at       TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP,
    updated_by       BIGINT,
    updated_at       TIMESTAMP                   DEFAULT CURRENT_TIMESTAMP,
    deleted          BOOLEAN            NOT NULL DEFAULT FALSE,
    deleted_at       DATETIME,
    deleted_by       BIGINT,

    CONSTRAINT fk_discount_type FOREIGN KEY (discount_type_id) REFERENCES discount_type (id)
);



CREATE TABLE discount_rate
(
    id                   BIGINT PRIMARY KEY AUTO_INCREMENT,

    organization_id      BIGINT NOT NULL,

    value                DECIMAL(10, 2) NOT NULL,
    is_percentage        BOOLEAN        NOT NULL DEFAULT TRUE,

    effective_from       DATE NULL,
    effective_to         DATE NULL,

    is_active            BOOLEAN        NOT NULL DEFAULT TRUE,
    deleted              BOOLEAN        NOT NULL DEFAULT FALSE,

    discount_sub_type_id BIGINT         NOT NULL,
    campus_id            BIGINT NULL,
    academic_year_id     BIGINT         NOT NULL,

    created_at           DATETIME                DEFAULT CURRENT_TIMESTAMP,
    created_by           BIGINT NULL,
    updated_at           DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
    updated_by           BIGINT NULL,
    deleted_at           DATETIME,
    deleted_by           BIGINT,

    CONSTRAINT fk_discount_rate_discount_sub_type FOREIGN KEY (discount_sub_type_id) REFERENCES discount_sub_type (id),
    CONSTRAINT fk_discount_rate_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),
    CONSTRAINT fk_discount_rate_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);


CREATE TABLE student_discount_assignment
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,

    organization_id    BIGINT NOT NULL,

    student_id         BIGINT NOT NULL,
    campus_id          BIGINT NOT NULL,
    discount_rate_id   BIGINT NOT NULL,
    academic_year_id   BIGINT NOT NULL,

    applied_amount     DECIMAL(10, 2),
    applied_percentage DECIMAL(5, 2),

    reason             VARCHAR(255),
    is_active          BOOLEAN DEFAULT TRUE,
    deleted            BOOLEAN DEFAULT FALSE,

    created_at         DATETIME,
    created_by         BIGINT,
    updated_at         DATETIME,
    updated_by         BIGINT,
    deleted_at         DATETIME,
    deleted_by         BIGINT,

    CONSTRAINT fk_sda_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_sda_campus FOREIGN KEY (campus_id) REFERENCES campuses (id),
    CONSTRAINT fk_sda_rate FOREIGN KEY (discount_rate_id) REFERENCES discount_rate (id),
    CONSTRAINT fk_sda_year FOREIGN KEY (academic_year_id) REFERENCES academic_years (id)
);
ALTER TABLE student_discount_assignment ADD CONSTRAINT uq_student_discount_unique UNIQUE (student_id, discount_rate_id, academic_year_id);

CREATE TABLE system_users
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    -- Authentication
    username      VARCHAR(50)  NOT NULL UNIQUE,
    email         VARCHAR(150) NOT NULL UNIQUE,
    phone         VARCHAR(20) UNIQUE,
    password_hash VARCHAR(255) NOT NULL,

    -- Status
    is_active     BOOLEAN  DEFAULT TRUE,
    is_verified   BOOLEAN  DEFAULT FALSE,

    -- Audit
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS permission;
CREATE TABLE permission
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    permission_name  VARCHAR(255) NOT NULL,
    code             VARCHAR(100) UNIQUE,
    module           VARCHAR(255),
    description      TEXT,

    created_at       BIGINT,
    updated_at       BIGINT,
    is_deleted       BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT chk_permission_name_not_empty CHECK (LENGTH(permission_name) > 0),
    CONSTRAINT chk_permission_code_not_empty CHECK (code IS NULL OR LENGTH(code) > 0)
);
CREATE INDEX idx_permission_name ON permission (permission_name);
CREATE INDEX idx_permission_code ON permission (code);

CREATE TABLE employee_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
  active          BOOLEAN NOT NULL DEFAULT TRUE,
          deleted         BOOLEAN DEFAULT FALSE,
          created_at      DATETIME,
          created_by      BIGINT,
          updated_at      DATETIME,
          updated_by      BIGINT,
          deleted_at      DATETIME,
          deleted_by      BIGINT
);



CREATE TABLE employee_master
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    organization_id    BIGINT NOT NULL,
    employee_code      VARCHAR(50)  NOT NULL UNIQUE,

    -- Personal Information
    first_name         VARCHAR(100) NOT NULL,
    last_name          VARCHAR(100) NOT NULL,
    full_name          VARCHAR(100) NOT NULL,
    middle_Name        VARCHAR(100),
    gender             VARCHAR(10),
    date_of_birth      DATE,
    marital_status     VARCHAR(20),
    cnic               VARCHAR(20),
    passport_number    VARCHAR(20),
    religion           VARCHAR(50),
    nationality        VARCHAR(50),
    blood_group        VARCHAR(10),

    -- Contact Information
    email              VARCHAR(100) NOT NULL,
    primary_phone      VARCHAR(20),
    secondary_phone    VARCHAR(20),
    work_phone         VARCHAR(20),

    -- Employment Details
    joining_date       DATE,
    probation_end_date DATE,

    -- Employee Type (current)
    employee_type_id   BIGINT, -- FK → employee_type.id

    -- Profile
    profile_picture    VARCHAR(255),
    bio                TEXT,

    -- Status
    active             BOOLEAN      NOT NULL DEFAULT TRUE,

    deleted            BOOLEAN      DEFAULT FALSE,
    created_at         DATETIME,
    created_by         BIGINT,
    updated_at         DATETIME,
    updated_by         BIGINT,
    deleted_at         DATETIME,
    deleted_by         BIGINT,

    UNIQUE KEY uq_employee_code (employee_code),
    -- Indexes
    INDEX idx_employee_code (employee_code),
    INDEX idx_employee_active (active),
    INDEX idx_employee_type (employee_type_id),

    -- Foreign Key
    CONSTRAINT fk_employee_type FOREIGN KEY (employee_type_id) REFERENCES employee_type(id)
);


CREATE TABLE employee_document
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id   BIGINT       NOT NULL, -- foreign key to Teacher
    file_name     VARCHAR(255) NOT NULL,
    file_path     VARCHAR(500) NOT NULL,
    file_type     VARCHAR(50),
    document_type VARCHAR(100) NOT NULL,

    deleted       BOOLEAN DEFAULT FALSE,
    created_at    DATETIME,
    created_by    BIGINT,
    updated_at    DATETIME,
    updated_by    BIGINT,
    deleted_at    DATETIME,
    deleted_by    BIGINT,
    CONSTRAINT fk_teacher FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);


CREATE TABLE employee_address
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id  BIGINT       NOT NULL,
    address_type VARCHAR(50)  NOT NULL,
    line1        VARCHAR(255) NOT NULL,
    line2        VARCHAR(255),
    city_id      BIGINT       NOT NULL,
    province_id  BIGINT,
    postal_code  VARCHAR(20),
    country_id   BIGINT       NOT NULL,

    deleted      BOOLEAN DEFAULT FALSE,
    created_at   DATETIME,
    created_by   BIGINT,
    updated_at   DATETIME,
    updated_by   BIGINT,
    deleted_at   DATETIME,
    deleted_by   BIGINT,

    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee_master (id),
    CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES cities (id),
    CONSTRAINT fk_province_address FOREIGN KEY (province_id) REFERENCES provinces (id),
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE employee_emergency_contact
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id     BIGINT       NOT NULL,
    contact_name    VARCHAR(255) NOT NULL,
    relationship    VARCHAR(100) NOT NULL,
    phone_primary   VARCHAR(20)  NOT NULL,
    phone_secondary VARCHAR(20),
    email           VARCHAR(255),
    address         VARCHAR(500),

    deleted         BOOLEAN DEFAULT FALSE,
    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT,

    CONSTRAINT fk_employee_emergency FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);


CREATE TABLE employee_qualification
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id     BIGINT       NOT NULL,
    degree          VARCHAR(100) NOT NULL, -- e.g., B.Sc, M.Ed
    major_subject   VARCHAR(100),          -- e.g., Mathematics, English
    institute       VARCHAR(150),          -- University or College
    year_of_passing INT,                   -- Year completed
    grade           VARCHAR(20),           -- e.g., A, 3.5 GPA
    certificate     VARCHAR(255),          -- Optional: path to scanned certificate file

    deleted         BOOLEAN DEFAULT FALSE,
    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT,

    CONSTRAINT fk_employee_qualification FOREIGN KEY (employee_id) REFERENCES employee_master (id)
);

CREATE TABLE departments (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    department_code VARCHAR(50)  NOT NULL UNIQUE,
    department_name VARCHAR(150) NOT NULL,
    description     VARCHAR(255),
    parent_id       BIGINT NULL,
    head_employee_id BIGINT NULL,
    active       BOOLEAN NOT NULL DEFAULT TRUE,
    deleted         BOOLEAN DEFAULT FALSE,
    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT,
    CONSTRAINT fk_department_parent FOREIGN KEY (parent_id) REFERENCES departments(id),
    CONSTRAINT fk_department_head FOREIGN KEY (head_employee_id) REFERENCES employee_master(id)
);


CREATE TABLE employee_department_history (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id     BIGINT       NOT NULL,
    department_id   BIGINT       NOT NULL,
    start_date      DATETIME     NOT NULL,
    end_date        DATETIME,               -- NULL if current
    is_current      BOOLEAN      NOT NULL DEFAULT TRUE,

    deleted         BOOLEAN DEFAULT FALSE,
    created_at      DATETIME,
    created_by      BIGINT,
    updated_at      DATETIME,
    updated_by      BIGINT,
    deleted_at      DATETIME,
    deleted_by      BIGINT,

    CONSTRAINT fk_employee_history FOREIGN KEY (employee_id) REFERENCES employee_master(id),
    CONSTRAINT fk_department_history FOREIGN KEY (department_id) REFERENCES departments(id)
);






CREATE TABLE designations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    designation_code VARCHAR(50) NOT NULL UNIQUE,
    designation_name VARCHAR(150) NOT NULL,
    description VARCHAR(255),

    -- Link to employee type (mandatory, for salary structure)
    employee_type_id BIGINT NOT NULL,

    -- Optional link to department (can be NULL for general roles)
    department_id BIGINT NULL,

    active BOOLEAN NOT NULL DEFAULT TRUE,
              deleted         BOOLEAN DEFAULT FALSE,
              created_at      DATETIME,
              created_by      BIGINT,
              updated_at      DATETIME,
              updated_by      BIGINT,
              deleted_at      DATETIME,
              deleted_by      BIGINT,

    -- Foreign Key Constraints
    CONSTRAINT fk_designation_employee_type
        FOREIGN KEY (employee_type_id) REFERENCES employee_type(id),
    CONSTRAINT fk_designation_department
        FOREIGN KEY (department_id) REFERENCES departments(id)
);



CREATE TABLE employee_designation_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    designation_id BIGINT NOT NULL,
    department_id BIGINT,       -- optional, can reference current department
    start_date DATETIME NOT NULL,
    end_date DATETIME,          -- NULL if current
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



CREATE TABLE employee_type_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    employee_type_id BIGINT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME,          -- NULL if current
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

    CREATE TABLE salary_structure (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_type_id BIGINT NOT NULL,
    base_salary DECIMAL(12,2) NOT NULL,   -- Fixed base salary
    effective_from DATE NOT NULL,
    effective_to DATE,
    is_current BOOLEAN NOT NULL DEFAULT TRUE,
          deleted         BOOLEAN DEFAULT FALSE,
          created_at      DATETIME,
          created_by      BIGINT,
          updated_at      DATETIME,
          updated_by      BIGINT,
          deleted_at      DATETIME,
          deleted_by      BIGINT,
CONSTRAINT fk_salary_employee_type
FOREIGN KEY (employee_type_id)
REFERENCES employee_type(id),
CHECK (effective_to IS NULL OR effective_to >= effective_from),
UNIQUE (employee_type_id, is_current)
);


CREATE TABLE salary_component (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,                   -- Full name of the component
    type ENUM('EARNING','DEDUCTION') NOT NULL,    -- Earning or Deduction
    is_percentage BOOLEAN NOT NULL DEFAULT TRUE, -- TRUE if % of base salary, FALSE if fixed amount
          deleted         BOOLEAN DEFAULT FALSE,
            created_at      DATETIME,
            created_by      BIGINT,
            updated_at      DATETIME,
            updated_by      BIGINT,
            deleted_at      DATETIME,
            deleted_by      BIGINT
);

    CREATE TABLE salary_structure_component (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        organization_id BIGINT NOT NULL,
        salary_structure_id BIGINT NOT NULL,
        component_id BIGINT NOT NULL,
        value DECIMAL(12,2) NOT NULL,              -- % if is_percentage, fixed amount if not
      deleted         BOOLEAN DEFAULT FALSE,
                created_at      DATETIME,
                created_by      BIGINT,
                updated_at      DATETIME,
                updated_by      BIGINT,
                deleted_at      DATETIME,
                deleted_by      BIGINT,
        FOREIGN KEY (salary_structure_id) REFERENCES salary_structure(id),
        FOREIGN KEY (component_id) REFERENCES salary_component(id),
          CONSTRAINT UK_salary_structure_component UNIQUE (salary_structure_id, component_id)
    );

    CREATE TABLE employee_salary (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        organization_id BIGINT NOT NULL,
        employee_id BIGINT NOT NULL,
        salary_structure_id BIGINT NOT NULL,
        gross_salary DECIMAL(12,2) NOT NULL,
        total_deductions DECIMAL(12,2) NOT NULL,
        net_salary DECIMAL(12,2) NOT NULL,
        effective_date DATE NOT NULL,             -- Payroll month
deleted         BOOLEAN DEFAULT FALSE,
                created_at      DATETIME,
                created_by      BIGINT,
                updated_at      DATETIME,
                updated_by      BIGINT,
                deleted_at      DATETIME,
                deleted_by      BIGINT,
        FOREIGN KEY (employee_id) REFERENCES employee_master(id),
        FOREIGN KEY (salary_structure_id) REFERENCES salary_structure(id)
    );


        CREATE TABLE employee_deduction (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        organization_id BIGINT NOT NULL,
        employee_id BIGINT NOT NULL,
        deduction_type VARCHAR(50) NOT NULL,   -- PF, Tax, Loan, etc.
        amount DECIMAL(12,2) NOT NULL,
        month DATE NOT NULL,                    -- Payroll month
deleted         BOOLEAN DEFAULT FALSE,
                created_at      DATETIME,
                created_by      BIGINT,
                updated_at      DATETIME,
                updated_by      BIGINT,
                deleted_at      DATETIME,
                deleted_by      BIGINT,
        FOREIGN KEY (employee_id) REFERENCES employee_master(id)
    );


CREATE TABLE salary_payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    organization_id BIGINT NOT NULL,

    employee_salary_id BIGINT NOT NULL,    -- Link to computed salary
    payment_date DATE NOT NULL,            -- Date salary was paid
    payment_mode ENUM('BANK_TRANSFER','CASH','CHEQUE','OTHER') NOT NULL,
    transaction_reference VARCHAR(100),    -- Bank reference / cheque number / transaction ID
    amount_paid DECIMAL(12,2) NOT NULL,   -- Actual amount paid
    remarks VARCHAR(255),

    deleted BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT,
    deleted_at DATETIME,
    deleted_by BIGINT,

    FOREIGN KEY (employee_salary_id) REFERENCES employee_salary(id)
);


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
    deleted_by BIGINT
);


CREATE TABLE employee_bonus (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    bonus_type VARCHAR(50) NOT NULL,  -- e.g., Festival Bonus, Performance
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
    FOREIGN KEY (payroll_period_id) REFERENCES payroll_period(id)
);


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
    FOREIGN KEY (employee_id) REFERENCES employee_master(id)
);


CREATE TABLE salary_slip (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    organization_id BIGINT NOT NULL,
    employee_salary_id BIGINT NOT NULL,
    payroll_period_id BIGINT NOT NULL,
    slip_url VARCHAR(255),  -- PDF or file location
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