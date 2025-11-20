DROP DATABASE IF EXISTS sms;
CREATE DATABASE IF NOT EXISTS sms;
USE sms;

SET FOREIGN_KEY_CHECKS = 0;


-- standards TABLE
DROP TABLE IF EXISTS standards;
CREATE TABLE standards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_name VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- sections TABLE
DROP TABLE IF EXISTS `sections`;
CREATE TABLE sections (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    standard_id BIGINT NOT NULL,
    section_name VARCHAR(10) NOT NULL,
    section_code VARCHAR(15)
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (standard_id) REFERENCES standards(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);








INSERT INTO standards (id, standard_name, created_at, updated_at) VALUES
(1, '1st Grade', NOW(), NOW()),
(2, '2nd Grade', NOW(), NOW()),
(3, '3rd Grade', NOW(), NOW()),
(4, '4th Grade', NOW(), NOW()),
(5, '5th Grade', NOW(), NOW()),
(6, '6th Grade', NOW(), NOW()),
(7, '7th Grade', NOW(), NOW()),
(8, '8th Grade', NOW(), NOW()),
(9, '9th Grade', NOW(), NOW()),
(10, '10th Grade', NOW(), NOW()),


INSERT INTO sections (standard_id, section_name, created_at, updated_at) VALUES
-- 1st Grade
    (1, 'A', NOW(), NOW()),
    (1, 'B', NOW(), NOW()),
    (1, 'C', NOW(), NOW()),
-- 2nd Grade
    (2, 'A', NOW(), NOW()),
    (2, 'B', NOW(), NOW()),
    (2, 'C', NOW(), NOW()),
-- 3rd Grade
    (3, 'A', NOW(), NOW()),
    (3, 'B', NOW(), NOW()),
    (3, 'C', NOW(), NOW()),
-- 4th Grade
    (4, 'A', NOW(), NOW()),
    (4, 'B', NOW(), NOW()),
    (4, 'C', NOW(), NOW()),
-- 5th Grade
    (5, 'A', NOW(), NOW()),
    (5, 'B', NOW(), NOW()),
    (5, 'C', NOW(), NOW()),
-- 6th Grade
    (6, 'A', NOW(), NOW()),
    (6, 'B', NOW(), NOW()),
    (6, 'C', NOW(), NOW()),
-- 7th Grade
    (7, 'A', NOW(), NOW()),
    (7, 'B', NOW(), NOW()),
    (7, 'C', NOW(), NOW()),
-- 8th Grade
    (8, 'A', NOW(), NOW()),
    (8, 'B', NOW(), NOW()),
    (8, 'C', NOW(), NOW()),
-- 9th Grade
    (9, 'A', NOW(), NOW()),
    (9, 'B', NOW(), NOW()),
    (9, 'C', NOW(), NOW()),
-- 10th Grade
    (10, 'A', NOW(), NOW()),
    (10, 'B', NOW(), NOW()),
    (10, 'C', NOW(), NOW());
