DROP
DATABASE IF EXISTS sms;
CREATE
DATABASE IF NOT EXISTS sms;
USE
sms;




CREATE TABLE country (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    country_code VARCHAR(5) NOT NULL UNIQUE,   -- PK, SA, US
    country_name VARCHAR(100) NOT NULL,         -- Pakistan, Saudi Arabia
    iso_code VARCHAR(3),                        -- ISO-3166 (PAK, SAU)
    phone_code VARCHAR(10)
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
-- TODO_
-- institutes TABLE
DROP TABLE IF EXISTS institutes;

CREATE TABLE institutes (
    id BIGINT PRIMARY KEY,              -- always 1

    name VARCHAR(150) NOT NULL,
    tagline VARCHAR(255),

    address VARCHAR(255),

    country_id BIGINT NOT NULL,
    province_id BIGINT NOT NULL,
    city_id BIGINT NOT NULL,

    contact_number VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(100),

    logo_url VARCHAR(255),
    established_date DATE,

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



DROP TABLE IF EXISTS `academic_years`;
CREATE TABLE academic_years
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50) NOT NULL, -- e.g., "2024-2025"
    start_date   DATE        NOT NULL,
    end_date     DATE        NOT NULL,
    total_months INT         NOT NULL, -- Total months in the academic year
    is_current   BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at   DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE admission_type
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
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


DROP TABLE IF EXISTS `fee_catalog`;
CREATE TABLE fee_catalog
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
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


DROP TABLE IF EXISTS student_fee_payments;
CREATE TABLE student_fee_payments
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
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

DROP TABLE IF EXISTS discount_type;
CREATE TABLE discount_type
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,

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


CREATE TABLE system_users
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,

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


CREATE TABLE employee_master
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
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

    -- Profile
    profile_picture    VARCHAR(255),
    bio                TEXT,

    -- Status
    active             BOOLEAN      NOT NULL DEFAULT TRUE,

    deleted            BOOLEAN               DEFAULT FALSE,
    created_at         DATETIME,
    created_by         BIGINT,
    updated_at         DATETIME,
    updated_by         BIGINT,
    deleted_at         DATETIME,
    deleted_by         BIGINT,

    UNIQUE KEY uq_employee_code (employee_code),
    -- Indexes
    INDEX              idx_employee_code (employee_code),
    INDEX              idx_employee_active (active)
);



CREATE TABLE employee_document
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
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




CREATE TABLE employee_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
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




CREATE TABLE designations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

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


    CREATE TABLE salary_structure (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_type_id BIGINT NOT NULL,
    base_salary DECIMAL(12,2) NOT NULL,   -- Fixed base salary
    effective_from DATE NOT NULL,
    effective_to DATE,
          deleted         BOOLEAN DEFAULT FALSE,
          created_at      DATETIME,
          created_by      BIGINT,
          updated_at      DATETIME,
          updated_by      BIGINT,
          deleted_at      DATETIME,
          deleted_by      BIGINT,
    FOREIGN KEY (employee_type_id) REFERENCES employee_type(id)
);


CREATE TABLE salary_component (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
        FOREIGN KEY (component_id) REFERENCES salary_component(id)
    );

    CREATE TABLE employee_salary (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
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