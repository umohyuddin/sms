DROP
DATABASE IF EXISTS sms;
CREATE
DATABASE IF NOT EXISTS sms;
USE
sms;

SET
FOREIGN_KEY_CHECKS = 0;


-- standards TABLE
DROP TABLE IF EXISTS standards;
CREATE TABLE standards
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_name VARCHAR(50) NOT NULL,
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- sections TABLE
DROP TABLE IF EXISTS `sections`;
CREATE TABLE sections
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_id  BIGINT      NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15),
    created_at   DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (standard_id) REFERENCES standards (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `students`;
CREATE TABLE students
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    section_id      BIGINT      NOT NULL,
    student_code    VARCHAR(20) NOT NULL,
    full_name       VARCHAR(100),
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    date_of_birth   DATE,
    gender          VARCHAR(10),
    email           VARCHAR(100),
    phone           VARCHAR(20),
    address         VARCHAR(500),
    is_active       TINYINT(1) DEFAULT 1,
    status          VARCHAR(50),
    enrollment_date DATE,
    is_deleted      TINYINT(1) DEFAULT 0,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (section_id) REFERENCES sections (id)
);



INSERT INTO standards (id, standard_name, created_at, updated_at)
VALUES (1, '1st Grade', NOW(), NOW()),
       (2, '2nd Grade', NOW(), NOW()),
       (3, '3rd Grade', NOW(), NOW()),
       (4, '4th Grade', NOW(), NOW()),
       (5, '5th Grade', NOW(), NOW()),
       (6, '6th Grade', NOW(), NOW()),
       (7, '7th Grade', NOW(), NOW()),
       (8, '8th Grade', NOW(), NOW()),
       (9, '9th Grade', NOW(), NOW()),
       (10, '10th Grade', NOW(), NOW());


INSERT INTO sections (standard_id, section_name, created_at, updated_at)
VALUES
    -- Standard 1
    (1, 'A', NOW(), NOW()),
    (1, 'B', NOW(), NOW()),
    (1, 'C', NOW(), NOW()),
    -- Standard 2
    (2, 'A', NOW(), NOW()),
    (2, 'B', NOW(), NOW()),
    (2, 'C', NOW(), NOW()),
    -- Standard 3
    (3, 'A', NOW(), NOW()),
    (3, 'B', NOW(), NOW()),
    (3, 'C', NOW(), NOW()),
    -- Standard 4
    (4, 'A', NOW(), NOW()),
    (4, 'B', NOW(), NOW()),
    (4, 'C', NOW(), NOW()),
    -- Standard 5
    (5, 'A', NOW(), NOW()),
    (5, 'B', NOW(), NOW()),
    (5, 'C', NOW(), NOW()),
    -- Standard 6
    (6, 'A', NOW(), NOW()),
    (6, 'B', NOW(), NOW()),
    (6, 'C', NOW(), NOW()),
    -- Standard 7
    (7, 'A', NOW(), NOW()),
    (7, 'B', NOW(), NOW()),
    (7, 'C', NOW(), NOW()),
    -- Standard 8
    (8, 'A', NOW(), NOW()),
    (8, 'B', NOW(), NOW()),
    (8, 'C', NOW(), NOW()),
    -- Standard 9
    (9, 'A', NOW(), NOW()),
    (9, 'B', NOW(), NOW()),
    (9, 'C', NOW(), NOW()),
    -- Standard 10
    (10, 'A', NOW(), NOW()),
    (10, 'B', NOW(), NOW()),
    (10, 'C', NOW(), NOW());


INSERT INTO students
(section_id, student_code, full_name, first_name, last_name, date_of_birth, gender, email, phone, address, is_active,
 status, enrollment_date, is_deleted)
VALUES (1, 'STU001', 'Ali Khan', 'Ali', 'Khan', '2008-05-15', 'Male', 'ali.khan@example.com', '03001234567',
        '123 Street, City', 1, 'Enrolled', '2023-08-20', 0),

       (1, 'STU002', 'Sara Ahmed', 'Sara', 'Ahmed', '2009-07-10', 'Female', 'sara.ahmed@example.com', '03007654321',
        '456 Avenue, City', 1, 'Enrolled', '2023-08-21', 0),

       (2, 'STU003', 'Hassan Raza', 'Hassan', 'Raza', '2008-03-22', 'Male', 'hassan.raza@example.com', '03009876543',
        '789 Road, City', 1, 'Enrolled', '2023-08-22', 0),

       (2, 'STU004', 'Ayesha Malik', 'Ayesha', 'Malik', '2009-12-05', 'Female', 'ayesha.malik@example.com',
        '03002345678', '101 Lane, City', 1, 'Enrolled', '2023-08-23', 0),

       (3, 'STU005', 'Zain Ali', 'Zain', 'Ali', '2008-09-18', 'Male', 'zain.ali@example.com', '03003456789',
        '202 Boulevard, City', 1, 'Enrolled', '2023-08-24', 0),

       (1, 'STU006', 'Fatima Noor', 'Fatima', 'Noor', '2009-01-25', 'Female', 'fatima.noor@example.com', '03004567890',
        '303 Street, City', 1, 'Enrolled', '2023-08-25', 0),

       (2, 'STU007', 'Usman Tariq', 'Usman', 'Tariq', '2008-11-30', 'Male', 'usman.tariq@example.com', '03005678901',
        '404 Avenue, City', 1, 'Enrolled', '2023-08-26', 0),

       (3, 'STU008', 'Hira Shah', 'Hira', 'Shah', '2009-02-14', 'Female', 'hira.shah@example.com', '03006789012',
        '505 Road, City', 1, 'Enrolled', '2023-08-27', 0),

       (1, 'STU009', 'Bilal Khan', 'Bilal', 'Khan', '2008-07-20', 'Male', 'bilal.khan@example.com', '03007890123',
        '606 Lane, City', 1, 'Enrolled', '2023-08-28', 0),

       (2, 'STU010', 'Zoya Ali', 'Zoya', 'Ali', '2009-03-11', 'Female', 'zoya.ali@example.com', '03008901234',
        '707 Boulevard, City', 1, 'Enrolled', '2023-08-29', 0),

       (3, 'STU011', 'Ahmed Raza', 'Ahmed', 'Raza', '2008-10-05', 'Male', 'ahmed.raza@example.com', '03001234568',
        '808 Street, City', 1, 'Enrolled', '2023-08-30', 0),

       (1, 'STU012', 'Sana Malik', 'Sana', 'Malik', '2009-06-22', 'Female', 'sana.malik@example.com', '03002345679',
        '909 Avenue, City', 1, 'Enrolled', '2023-08-31', 0),

       (2, 'STU013', 'Owais Khan', 'Owais', 'Khan', '2008-04-18', 'Male', 'owais.khan@example.com', '03003456780',
        '111 Road, City', 1, 'Enrolled', '2023-09-01', 0),

       (3, 'STU014', 'Maryam Shah', 'Maryam', 'Shah', '2009-09-09', 'Female', 'maryam.shah@example.com', '03004567891',
        '222 Lane, City', 1, 'Enrolled', '2023-09-02', 0),

       (1, 'STU015', 'Danish Ali', 'Danish', 'Ali', '2008-12-12', 'Male', 'danish.ali@example.com', '03005678902',
        '333 Boulevard, City', 1, 'Enrolled', '2023-09-03', 0),

       (2, 'STU016', 'Hafsa Noor', 'Hafsa', 'Noor', '2009-08-08', 'Female', 'hafsa.noor@example.com', '03006789013',
        '444 Street, City', 1, 'Enrolled', '2023-09-04', 0),

       (3, 'STU017', 'Imran Tariq', 'Imran', 'Tariq', '2008-05-05', 'Male', 'imran.tariq@example.com', '03007890124',
        '555 Avenue, City', 1, 'Enrolled', '2023-09-05', 0),

       (1, 'STU018', 'Areeba Ali', 'Areeba', 'Ali', '2009-11-11', 'Female', 'areeba.ali@example.com', '03008901235',
        '666 Road, City', 1, 'Enrolled', '2023-09-06', 0),

       (2, 'STU019', 'Saad Khan', 'Saad', 'Khan', '2008-03-03', 'Male', 'saad.khan@example.com', '03001234569',
        '777 Lane, City', 1, 'Enrolled', '2023-09-07', 0),

       (3, 'STU020', 'Zunaira Malik', 'Zunaira', 'Malik', '2009-07-07', 'Female', 'zunaira.malik@example.com',
        '03002345670', '888 Boulevard, City', 1, 'Enrolled', '2023-09-08', 0);
