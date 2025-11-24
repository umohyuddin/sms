DROP
DATABASE IF EXISTS sms;
CREATE
DATABASE IF NOT EXISTS sms;
USE
sms;

SET
FOREIGN_KEY_CHECKS = 0;



-- institutes TABLE
DROP TABLE IF EXISTS `institutes`;
CREATE TABLE institutes
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    address          VARCHAR(255),
    contact_number   VARCHAR(20),
    email            VARCHAR(100),
    website          VARCHAR(100),
    tagline          VARCHAR(255),
    country          VARCHAR(100),
    logo             LONGBLOB,
    established_date DATE,
    created_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO institutes (name, address, contact_number, email, website, tagline, country, logo, established_date)
VALUES ('Smart Solutions School', '123 Main Street, Cityville', '03001234567', 'info@smartsolutions.edu',
        'https://www.smartsolutions.edu', 'Excellence in Education', 'Pakistan',
        NULL, '2005-08-15');


-- campuses TABLE
DROP TABLE IF EXISTS `campuses`;
CREATE TABLE campuses
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    province_id  BIGINT,
    city_id      BIGINT,
    institute_id BIGINT       NOT NULL,
    campus_name  VARCHAR(100) NOT NULL,
    contact      VARCHAR(20),
    email        VARCHAR(100),
    website      VARCHAR(100),
    address      VARCHAR(255),
    province     VARCHAR(100),
    city         VARCHAR(50),
    logo         LONGBLOB,
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      BOOLEAN      NOT NULL DEFAULT FALSE,
    deleted_at   DATETIME,
    CONSTRAINT fk_institute FOREIGN KEY (institute_id) REFERENCES institutes (id)
);

INSERT INTO campuses (id, institute_id, campus_name, contact, email, website, address, province, city, created_at,
                      updated_at, deleted, deleted_at)
VALUES (1, 1, 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com', 'https://downtown.smarteschool.com',
        '123 Main Street', 'Punjab', 'Lahore', NOW(), NOW(), TRUE, NULL),
       (2, 1, 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com', 'https://uptown.smarteschool.com',
        '456 Park Avenue', 'Punjab', 'Lahore', NOW(), NOW(), TRUE, NULL),
       (3, 1, 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com', 'https://riverside.smarteschool.com',
        '789 River Road', 'Sindh', 'Karachi', NOW(), NOW(), FALSE, NULL),
       (4, 1, 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com', 'https://hilltop.smarteschool.com',
        '101 Hill Street', 'KPK', 'Peshawar', NOW(), NOW(), FALSE, NULL),
       (5, 1, 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
        'https://greenfield.smarteschool.com',
        '202 Green Road', 'Punjab', 'Faisalabad', NOW(), NOW(), FALSE, NULL),
       (6, 1, 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com', 'https://seaside.smarteschool.com',
        '303 Beach Avenue', 'Sindh', 'Karachi', NOW(), NOW(), FALSE, NULL),
       (7, 1, 'Central Campus', '+92-303-9990001', 'central@smarteschool.com', 'https://central.smarteschool.com',
        '404 Central Street', 'Punjab', 'Multan', NOW(), NOW(), FALSE, NULL),
       (8, 1, 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com', 'https://lakeside.smarteschool.com',
        '505 Lake Road', 'Sindh', 'Hyderabad', NOW(), NOW(), FALSE, NULL),
       (9, 1, 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com', 'https://sunrise.smarteschool.com',
        '606 Sunrise Blvd', 'Punjab', 'Rawalpindi', NOW(), NOW(), FALSE, NULL),
       (10, 1, 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com', 'https://maple.smarteschool.com',
        '707 Maple Street', 'Balochistan', 'Quetta', NOW(), NOW(), FALSE, NULL);


-- standards TABLE
DROP TABLE IF EXISTS standards;
CREATE TABLE standards
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_name VARCHAR(50) NOT NULL,
    standard_code VARCHAR(50),
    description   VARCHAR(500),
    campus_id     BIGINT      NOT NULL,
    created_at    DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted       BOOLEAN     NOT NULL DEFAULT FALSE,
    deleted_at    DATETIME,
    FOREIGN KEY (campus_id) REFERENCES campuses (id)
);

INSERT INTO standards (id, standard_name, campus_id, created_at, updated_at, deleted, deleted_at)
VALUES (1, '1st Grade', 1, NOW(), NOW(), 1, NULL),
       (2, '2nd Grade', 1, NOW(), NOW(), 1, NULL),
       (3, '3rd Grade', 1, NOW(), NOW(), 0, NULL),
       (4, '4th Grade', 1, NOW(), NOW(), 0, NULL),
       (5, '5th Grade', 1, NOW(), NOW(), 0, NULL),
       (6, '6th Grade', 1, NOW(), NOW(), 0, NULL),
       (7, '7th Grade', 1, NOW(), NOW(), 0, NULL),
       (8, '8th Grade', 1, NOW(), NOW(), 0, NULL),
       (9, '9th Grade', 1, NOW(), NOW(), 0, NULL),
       (10, '10th Grade', 1, NOW(), NOW(), 0, NULL);


-- sections TABLE
DROP TABLE IF EXISTS `sections`;
CREATE TABLE sections
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_id  BIGINT      NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15),
    created_at   DATETIME             DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      BOOLEAN     NOT NULL DEFAULT FALSE,
    deleted_at   DATETIME,
    FOREIGN KEY (standard_id) REFERENCES standards (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
INSERT INTO sections (standard_id, section_name, created_at, updated_at, deleted, deleted_at)
VALUES
    -- Standard 1
    (1, 'A', NOW(), NOW(), 1, NULL),
    (1, 'B', NOW(), NOW(), 0, NULL),
    (1, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 2
    (2, 'A', NOW(), NOW(), 0, NULL),
    (2, 'B', NOW(), NOW(), 0, NULL),
    (2, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 3
    (3, 'A', NOW(), NOW(), 0, NULL),
    (3, 'B', NOW(), NOW(), 0, NULL),
    (3, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 4
    (4, 'A', NOW(), NOW(), 0, NULL),
    (4, 'B', NOW(), NOW(), 0, NULL),
    (4, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 5
    (5, 'A', NOW(), NOW(), 0, NULL),
    (5, 'B', NOW(), NOW(), 0, NULL),
    (5, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 6
    (6, 'A', NOW(), NOW(), 0, NULL),
    (6, 'B', NOW(), NOW(), 0, NULL),
    (6, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 7
    (7, 'A', NOW(), NOW(), 0, NULL),
    (7, 'B', NOW(), NOW(), 0, NULL),
    (7, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 8
    (8, 'A', NOW(), NOW(), 0, NULL),
    (8, 'B', NOW(), NOW(), 0, NULL),
    (8, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 9
    (9, 'A', NOW(), NOW(), 0, NULL),
    (9, 'B', NOW(), NOW(), 0, NULL),
    (9, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 10
    (10, 'A', NOW(), NOW(), 0, NULL),
    (10, 'B', NOW(), NOW(), 0, NULL),
    (10, 'C', NOW(), NOW(), 0, NULL);


-- students TABLE
DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS students
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    campus_id
    BIGINT
    NOT
    NULL,
    standard_id
    BIGINT
    NOT
    NULL,
    section_id
    BIGINT
    NOT
    NULL,
    student_code
    VARCHAR
(
    20
) NOT NULL UNIQUE,
    full_name VARCHAR
(
    100
) NOT NULL,
    first_name VARCHAR
(
    50
) NOT NULL,
    last_name VARCHAR
(
    50
) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR
(
    10
) NOT NULL,
    email VARCHAR
(
    100
) UNIQUE,
    phone VARCHAR
(
    20
),
    address VARCHAR
(
    500
),
    is_active TINYINT
(
    1
) DEFAULT 1,
    status VARCHAR
(
    50
),
    enrollment_date DATE NOT NULL,
    deleted TINYINT
(
    1
) DEFAULT 0,
    deleted_at DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY
(
    campus_id
) REFERENCES campuses
(
    id
),
    FOREIGN KEY
(
    standard_id
) REFERENCES standards
(
    id
),
    FOREIGN KEY
(
    section_id
) REFERENCES sections
(
    id
)
    );

-- INSERT DUMMY DATA
INSERT INTO students
(campus_id, standard_id, section_id,
 student_code, full_name, first_name, last_name, date_of_birth,
 gender, email, phone, address, is_active, status,
 enrollment_date, deleted)
VALUES (1, 1, 1, 'STU001', 'Ali Khan', 'Ali', 'Khan', '2008-05-15', 'Male', 'ali.khan@example.com', '03001234567',
        'Gulshan-e-Iqbal, Karachi', 1, 'Enrolled', '2024-04-02', 0),
       (1, 1, 2, 'STU002', 'Ayesha Malik', 'Ayesha', 'Malik', '2009-03-21', 'Female', 'ayesha.malik@example.com',
        '03015678900', 'Model Town, Lahore', 1, 'Enrolled', '2024-04-03', 0),
       (1, 2, 3, 'STU003', 'Hassan Ali', 'Hassan', 'Ali', '2007-10-11', 'Male', 'hassan.ali@example.com', '03007894561',
        'Cantt Road, Rawalpindi', 1, 'Enrolled', '2024-04-05', 0),
       (2, 2, 4, 'STU004', 'Fatima Shah', 'Fatima', 'Shah', '2008-12-01', 'Female', 'fatima.shah@example.com',
        '03112233445', 'North Nazimabad, Karachi', 1, 'Enrolled', '2024-04-06', 0),
       (2, 3, 5, 'STU005', 'Saad Ahmed', 'Saad', 'Ahmed', '2010-06-18', 'Male', 'saad.ahmed@example.com', '03214567890',
        'F-8 Sector, Islamabad', 1, 'Enrolled', '2024-04-06', 0),
       (1, 3, 6, 'STU006', 'Zainab Raza', 'Zainab', 'Raza', '2011-01-09', 'Female', 'zainab.raza@example.com',
        '03023456781', 'Johar Town, Lahore', 1, 'Enrolled', '2024-04-07', 0),
       (1, 4, 7, 'STU007', 'Ahmed Farooq', 'Ahmed', 'Farooq', '2009-07-19', 'Male', 'ahmed.farooq@example.com',
        '03002345890', 'Garden West, Karachi', 1, 'Enrolled', '2024-04-10', 0),
       (2, 4, 8, 'STU008', 'Maryam Iqbal', 'Maryam', 'Iqbal', '2010-11-25', 'Female', 'maryam.iqbal@example.com',
        '03113335566', 'Bahria Town, Lahore', 1, 'Enrolled', '2024-04-11', 0),
       (1, 5, 9, 'STU009', 'Usman Tariq', 'Usman', 'Tariq', '2008-09-02', 'Male', 'usman.tariq@example.com',
        '03029876543', 'Satellite Town, Rawalpindi', 1, 'Enrolled', '2024-04-12', 0),
       (2, 5, 10, 'STU010', 'Hiba Rehman', 'Hiba', 'Rehman', '2011-02-14', 'Female', 'hiba.rehman@example.com',
        '03440011223', 'Defence Phase 2, Karachi', 1, 'Enrolled', '2024-04-12', 0);





