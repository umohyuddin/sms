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
