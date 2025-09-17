-- DROP DATABASE IF EXISTS sms;
-- CREATE DATABASE IF NOT EXISTS sms;
-- USE sms;

SET FOREIGN_KEY_CHECKS = 0;

-- USER_ROLE TABLE
DROP TABLE IF EXISTS user_roles;
CREATE TABLE IF NOT EXISTS user_roles (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

-- USER TABLE
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_id BIGINT NOT NULL,
  emp_id BIGINT NOT NULL,
  cmp_id BIGINT NOT NULL,
  isactive BIT(1),
  account_non_expired BIT(1) NOT NULL,
  account_non_locked BIT(1) NOT NULL,
  credentials_non_expired BIT(1) NOT NULL,
  email VARCHAR(255) UNIQUE,
  enabled BIT(1) NOT NULL,
  password VARCHAR(255) DEFAULT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_roles
    FOREIGN KEY (role_id)
    REFERENCES user_roles (id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_user_emp_id
    FOREIGN KEY (emp_id)
    REFERENCES employee (employee_id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_user_cmp_id
    FOREIGN KEY (cmp_id)
    REFERENCES campuses (campus_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS theme;
CREATE TABLE IF NOT EXISTS theme (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    inst_id INT,
    name VARCHAR(100) NOT NULL,
    sidebar_bg VARCHAR(100) NOT NULL,
    sidebar_text VARCHAR(100) NOT NULL,
    body_bg VARCHAR(100) NOT NULL,
    body_text VARCHAR(100) NOT NULL,
    header_bg VARCHAR(100) NOT NULL,
    header_text VARCHAR(100) NOT NULL,
    active_item_bg VARCHAR(100) NOT NULL,
    active_item_text VARCHAR(100) NOT NULL,
	CONSTRAINT fk_theme_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);


-- Creating table for Institutes
DROP TABLE IF EXISTS institutes;
CREATE TABLE IF NOT EXISTS institutes (
    institute_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT ,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    contact_number VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(100),
    tagline VARCHAR(255),
    country VARCHAR(100),
    logo LONGBLOB,
    established_date DATE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_institute_user_id
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Creating table rules
DROP TABLE IF EXISTS rules;
CREATE TABLE IF NOT EXISTS rules (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    rules MEDIUMTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_rules_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
    );

-- Creating table fail criteria
DROP TABLE IF EXISTS failcriteria;
CREATE TABLE IF NOT EXISTS failcriteria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    percentage INT,
    subjectmarks INT,
    noofsubjects INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_failcriteria_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Creating table marks grading
DROP TABLE IF EXISTS marksgrading;
CREATE TABLE IF NOT EXISTS marksgrading (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	inst_id INT NOT NULL,
    name VARCHAR(2),
    marks INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_marksandgrading_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Creating table for Campuses
DROP TABLE IF EXISTS campuses;
CREATE TABLE IF NOT EXISTS campuses (
    campus_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(100),
    address VARCHAR(255),
    province VARCHAR(100),
    city VARCHAR(50),
    logo LONGBLOB,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_campuses_inst_id
    FOREIGN KEY (inst_id) REFERENCES institutes(institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Inventory TABLE
DROP TABLE IF EXISTS inventory;
CREATE TABLE IF NOT EXISTS inventory (
    inventory_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cmp_id BIGINT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    status ENUM('Available', 'InUse', 'Damaged') NOT NULL,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_inv_cmp_id
        FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- expenses TABLE
DROP TABLE IF EXISTS expenses;
CREATE TABLE IF NOT EXISTS expenses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cmp_id BIGINT NOT NULL,
    amount BIGINT NOT NULL,
	details VARCHAR(300),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_exp_cmp_id
        FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Students TABLE
DROP TABLE IF EXISTS students;
CREATE TABLE IF NOT EXISTS students (
    student_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cmp_id BIGINT NOT NULL,
	dpt_id INT NOT NULL,
	grade INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(200),
	isactive BIT(1),
    enrollment_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_std_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
		ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_std_dpt_id
		FOREIGN KEY (dpt_id) REFERENCES departments(department_id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Employee_ROLES TABLE
DROP TABLE IF EXISTS emp_roles;
CREATE TABLE IF NOT EXISTS emp_roles (
  id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

-- Employee TABLE
DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
    employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_role_id INT NOT NULL,
	cmp_id BIGINT NOT NULL,
	dpt_id INT,
    f_name VARCHAR(50) NOT NULL,
    l_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    hire_date DATE NOT NULL,
    department VARCHAR(50),
	isactive BIT(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (dpt_id) REFERENCES departments(department_id),
    CONSTRAINT fk_emp_roles
		FOREIGN KEY (emp_role_id)
		REFERENCES emp_roles (id)
		ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_emp_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Departments TABLE
DROP TABLE IF EXISTS departments;
CREATE TABLE IF NOT EXISTS departments (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
	cmp_id BIGINT NOT NULL,
    department_name VARCHAR(100) NOT NULL UNIQUE,
    dpt_head_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (dpt_head_id) REFERENCES employee(employee_id),
	CONSTRAINT fk_dpt_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Courses TABLE
DROP TABLE IF EXISTS courses;
CREATE TABLE IF NOT EXISTS courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(10) UNIQUE NOT NULL,
    course_name VARCHAR(100) NOT NULL,
	grade INT NOT NULL,
    dpt_id INT,
    teacher_id BIGINT,
	isactive BIT(1),
    credits INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (dpt_id) REFERENCES departments(department_id),
    FOREIGN KEY (teacher_id) REFERENCES employee(employee_id)
);

-- Enrollments TABLE
DROP TABLE IF EXISTS enrollments;
CREATE TABLE IF NOT EXISTS enrollments (
    enrollment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id INT,
    enrollment_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- assesments TABLE
DROP TABLE IF EXISTS assessments;
CREATE TABLE IF NOT EXISTS assessments (
    assessments_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    enr_id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    assessments_date DATE NOT NULL,
	status ENUM('P', 'A') NOT NULL,
	marks INT NOT NULL,
    grade VARCHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_assessments_enr_id
		FOREIGN KEY (enr_id) REFERENCES enrollments(enrollment_id)
		ON DELETE CASCADE ON UPDATE CASCADE
);

-- Attendance TABLE
DROP TABLE IF EXISTS attendance;
CREATE TABLE IF NOT EXISTS attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id INT,
    attendance_date DATE NOT NULL,
    status ENUM('P', 'A', 'L') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- Employee Attendance TABLE
DROP TABLE IF EXISTS emp_attendance;
CREATE TABLE IF NOT EXISTS emp_attendance (
    emp_atn_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_id BIGINT,
    attendance_date DATE NOT NULL,
    status ENUM('P', 'A', 'L') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(employee_id)
);

-- Classes TABLE
DROP TABLE IF EXISTS classes;
CREATE TABLE IF NOT EXISTS classes (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT,
    teacher_id BIGINT,
    classroom VARCHAR(50),
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day_of_week ENUM('Mon','Tue','Wed','Thu','Fri','Sat','Sun') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (teacher_id) REFERENCES employee(employee_id)
);

-- Employee Slaray TABLE
DROP TABLE IF EXISTS salary;
CREATE TABLE IF NOT EXISTS salary (
    slr_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	emp_id BIGINT NOT NULL,
	amount DECIMAL(10,2) NOT NULL,
    `year` YEAR(4) NOT NULL,
    `month` INT NOT NULL,
	status ENUM('Paid', 'Pending', 'Conflict') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(employee_id)
);

-- Bank Details TABLE
DROP TABLE IF EXISTS bankdetails;
CREATE TABLE IF NOT EXISTS bankdetails (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(300) NOT NULL,
    account_no VARCHAR(20) NOT NULL,
    iban VARCHAR(30) NOT NULL,
    instruction VARCHAR(400) NOT NULL,
    logo LONGBLOB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_bankdetails_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
    );

-- Students fee particular TABLE
DROP TABLE IF EXISTS feeparticular;
CREATE TABLE IF NOT EXISTS feeparticular (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    name VARCHAR(100) NOT NULL,
    tuition_fee DECIMAL(10,2) DEFAULT 0.00,
    stationery DECIMAL(10,2) DEFAULT 0.00,
    sports DECIMAL(10,2) DEFAULT 0.00,
    annual_fee DECIMAL(10,2) DEFAULT 0.00,
    electricity DECIMAL(10,2) DEFAULT 0.00,
    maintenance DECIMAL(10,2) DEFAULT 0.00,
    miscellaneous DECIMAL(10,2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

-- Students Fee TABLE
DROP TABLE IF EXISTS fee;
CREATE TABLE IF NOT EXISTS fee (
    fee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	std_id BIGINT,
	tuition_fee DECIMAL(10,2) DEFAULT 0.00,
    stationery DECIMAL(10,2) DEFAULT 0.00,
    sports DECIMAL(10,2) DEFAULT 0.00,
    annual_fee DECIMAL(10,2) DEFAULT 0.00,
    electricity DECIMAL(10,2) DEFAULT 0.00,
    maintenance DECIMAL(10,2) DEFAULT 0.00,
    miscellaneous DECIMAL(10,2) DEFAULT 0.00,
	t_amount DECIMAL(10,2) DEFAULT 0.00,
	p_amount DECIMAL(10,2) DEFAULT 0.00,
	arrears DECIMAL(10,2) DEFAULT 0.00,
    `year` YEAR(4),
    `month` INT,
	status ENUM('Paid', 'Pending', 'Conflict') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (std_id) REFERENCES students(student_id)
);

SET FOREIGN_KEY_CHECKS = 1;

-- ========================
-- 3. TRIGGERS for FEE
-- ========================
DELIMITER $$

DROP TRIGGER IF EXISTS before_fee_insert$$

CREATE TRIGGER before_fee_insert
BEFORE INSERT ON fee
FOR EACH ROW
BEGIN
    SET NEW.t_amount = IFNULL(NEW.tuition_fee,0)+IFNULL(NEW.stationery,0)+
                       IFNULL(NEW.sports,0)+IFNULL(NEW.annual_fee,0)+
                       IFNULL(NEW.electricity,0)+IFNULL(NEW.maintenance,0)+
                       IFNULL(NEW.miscellaneous,0);
    SET NEW.arrears = NEW.t_amount - IFNULL(NEW.p_amount,0);
END$$

DROP TRIGGER IF EXISTS before_fee_update$$
CREATE TRIGGER before_fee_update

BEFORE UPDATE ON fee
FOR EACH ROW
BEGIN
    SET NEW.t_amount = IFNULL(NEW.tuition_fee,0)+IFNULL(NEW.stationery,0)+
                       IFNULL(NEW.sports,0)+IFNULL(NEW.annual_fee,0)+
                       IFNULL(NEW.electricity,0)+IFNULL(NEW.maintenance,0)+
                       IFNULL(NEW.miscellaneous,0);
    SET NEW.arrears = NEW.t_amount - IFNULL(NEW.p_amount,0);
END$$

DELIMITER ;
-- ========================
-- 3. TRIGGERS for matching grade (Student <-> Course)
-- ========================
DELIMITER $$


CREATE TRIGGER check_grade_match_before_insert
BEFORE INSERT ON enrollments
FOR EACH ROW
BEGIN
    DECLARE student_grade VARCHAR(2);
    DECLARE course_grade VARCHAR(2);

    -- Get the student's grade
    SELECT grade INTO student_grade
    FROM students
    WHERE student_id = NEW.student_id;

    -- Get the course's grade
    SELECT grade INTO course_grade
    FROM courses
    WHERE course_id = NEW.course_id;

    -- Check if grades match (handle NULL cases if needed)
    IF (student_grade IS NOT NULL AND course_grade IS NOT NULL AND student_grade != course_grade) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Student grade does not match course grade';
    END IF;
END $$

CREATE TRIGGER check_grade_match_before_update
BEFORE UPDATE ON enrollments
FOR EACH ROW
BEGIN
    DECLARE student_grade VARCHAR(2);
    DECLARE course_grade VARCHAR(2);

    -- Get the student's grade
    SELECT grade INTO student_grade
    FROM students
    WHERE student_id = NEW.student_id;

    -- Get the course's grade
    SELECT grade INTO course_grade
    FROM courses
    WHERE course_id = NEW.course_id;

    -- Check if grades match (handle NULL cases if needed)
    IF (student_grade IS NOT NULL AND course_grade IS NOT NULL AND student_grade != course_grade) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Student grade does not match course grade';
    END IF;
END $$

DELIMITER ;


-- ========================
-- 5.1 Institutes
-- ========================
INSERT INTO institutes (name, address, contact_number, email, established_date) VALUES
('Sunshine Group', 'Main Road, City A', '111-222-333', 'info1@group.com', '2000-05-01'),
('Galaxy Foundation', 'Park Lane, City B', '222-333-444', 'info2@group.com', '2002-07-05'),
('Global Education', 'Ring Road, City C', '333-444-555', 'info3@group.com', '2005-08-10'),
('Future Stars', 'Block B, City D', '444-555-666', 'info4@group.com', '2008-02-12'),
('Smart Kids', 'Block C, City E', '555-666-777', 'info5@group.com', '2010-03-18'),
('Learning Tree', 'Street 6, City F', '666-777-888', 'info6@group.com', '2012-09-14'),
('Bright Minds', 'Street 10, City G', '777-888-999', 'info7@group.com', '2014-11-20'),
('EduCare', 'Market Road, City H', '888-999-000', 'info8@group.com', '2016-06-22'),
('Knowledge Base', 'Garden Road, City I', '999-000-111', 'info9@group.com', '2018-01-25'),
('Inspire Schools', 'Central Road, City J', '000-111-222', 'info10@group.com', '2020-04-30');

-- ========================
-- 5.2 Campuses
-- ========================
INSERT INTO campuses (inst_id, name, address, city) VALUES
(1,'Campus A','Address A','City A'), (2,'Campus B','Address B','City B'),
(3,'Campus C','Address C','City C'), (4,'Campus D','Address D','City D'),
(5,'Campus E','Address E','City E'), (6,'Campus F','Address F','City F'),
(7,'Campus G','Address G','City G'), (8,'Campus H','Address H','City H'),
(9,'Campus I','Address I','City I'), (10,'Campus J','Address J','City J');

-- ========================
-- 5.3 Departments
-- ========================
INSERT INTO departments (cmp_id, department_name) VALUES
(1,'Science'),(2,'Arts'),(3,'Commerce'),(4,'Sports'),(5,'Library'),
(6,'Transport'),(7,'HR'),(8,'Finance'),(9,'IT'),(10,'Administration');

-- ========================
-- 5.4 emp_roles
-- ========================
INSERT INTO emp_roles (role_name) VALUES
('Principal'),('Vice Principal'),('Teacher'),('Clerk'),('HR'),
('Finance'),('Driver'),('Security'),('Cleaner'),('IT Officer');

-- ========================
-- 5.5 Employee
-- ========================
INSERT INTO employee (emp_role_id, cmp_id, f_name, l_name, email, phone, hire_date, department, isactive) VALUES
(1,1,'Ali','Khan','ali.khan@school.com','0300111111','2015-01-10','Science',1),
(2,2,'Sara','Ahmed','sara.ahmed@school.com','0300222222','2016-03-15','Arts',1),
(3,3,'John','Smith','john.smith@school.com','0300333333','2017-06-20','Commerce',1),
(4,4,'Maryam','Rashid','maryam.rashid@school.com','0300444444','2018-08-12','HR',1),
(5,5,'David','Lee','david.lee@school.com','0300555555','2019-10-05','Finance',1),
(6,6,'Hina','Saeed','hina.saeed@school.com','0300666666','2020-02-18','IT',1),
(7,7,'Nashit','Malik','nashit.malik@school.com','0300777777','2020-05-25','Sports',1),
(8,8,'Usman','Tariq','usman.tariq@school.com','0300888888','2021-07-14','Library',1),
(9,9,'Mona','Qureshi','mona.qureshi@school.com','0300999999','2021-09-09','Transport',1),
(10,10,'Zeeshan','Farooq','zeeshan.farooq@school.com','0300101010','2022-11-20','Administration',1);

-- ========================
-- 5.6 user_role
-- ========================
INSERT INTO user_roles (role_name) VALUES
('Admin'), ('Manager'), ('Teacher'), ('Student'), ('HR'),
('Finance'), ('Parent'), ('Clerk'), ('Librarian'), ('IT Support');

-- ========================
-- 5.7 userEntity
-- ========================
INSERT INTO `user` (role_id, emp_id, cmp_id, isactive, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, password) VALUES
(1,1,1,1,1,1,1,'user1@school.com',1,'pass1'),
(2,2,2,1,1,1,1,'user2@school.com',1,'pass2'),
(3,3,3,1,1,1,1,'user3@school.com',1,'pass3'),
(4,4,4,1,1,1,1,'user4@school.com',1,'pass4'),
(5,5,5,1,1,1,1,'user5@school.com',1,'pass5'),
(6,6,6,1,1,1,1,'user6@school.com',1,'pass6'),
(7,7,7,1,1,1,1,'user7@school.com',1,'pass7'),
(8,8,8,1,1,1,1,'user8@school.com',1,'pass8'),
(9,9,9,1,1,1,1,'user9@school.com',1,'pass9'),
(10,10,10,1,1,1,1,'user10@school.com',1,'pass10');

-- ========================
-- 5.8 Students
-- ========================
INSERT INTO students (cmp_id, dpt_id, grade, first_name, last_name, date_of_birth, email, phone, address, isactive, enrollment_date) VALUES
(1, 1, 3, 'Ahmed', 'Ali', '2005-01-12', 'ahmed.ali@student.com', '0301111111', 'City A', 1, '2022-08-01'),
(2, 2, 1, 'Bilal', 'Khan', '2006-03-15', 'bilal.khan@student.com', '0301222222', 'City B', 1, '2022-08-02'),
(3, 3, 2, 'Saad', 'Qureshi', '2004-05-20', 'saad.qureshi@student.com', '0301333333', 'City C', 1, '2022-08-03'),
(4, 4, 4, 'Ayesha', 'Rashid', '2007-06-25', 'ayesha.rashid@student.com', '0301444444', 'City D', 1, '2022-08-04'),
(5, 5, 5, 'Fatima', 'Shahid', '2005-07-22', 'fatima.shahid@student.com', '0301555555', 'City E', 1, '2022-08-05'),
(6, 6, 6, 'Zara', 'Malik', '2006-09-30', 'zara.malik@student.com', '0301666666', 'City F', 1, '2022-08-06'),
(7, 7, 7, 'Hassan', 'Tariq', '2005-10-12', 'hassan.tariq@student.com', '0301777777', 'City G', 1, '2022-08-07'),
(8, 8, 8, 'Omar', 'Farooq', '2004-11-18', 'omar.farooq@student.com', '0301888888', 'City H', 1, '2022-08-08'),
(9, 9, 9, 'Noor', 'Anwar', '2006-12-25', 'noor.anwar@student.com', '0301999999', 'City I', 1, '2022-08-09'),
(10, 10, 10, 'Mariam', 'Latif', '2007-01-30', 'mariam.latif@student.com', '0301010101', 'City J', 1, '2022-08-10');

-- ========================
-- 5.9 inventory
-- ========================
INSERT INTO inventory (cmp_id, item_name, quantity, status) VALUES
(1, 'Projector', 5, 'Available'),
(1, 'Laptop', 10, 'InUse'),
(2, 'Desk', 20, 'Available'),
(2, 'Whiteboard', 3, 'Damaged'),
(3, 'Printer', 2, 'Available'),
(4, 'Chair', 30, 'InUse'),
(5, 'Microscope', 15, 'Available'),
(6, 'Bookshelf', 8, 'Available'),
(7, 'Computer', 25, 'InUse'),
(8, 'Scanner', 1, 'Damaged');

-- ========================
-- 5.10 courses
-- ========================
INSERT INTO courses (course_code, course_name, grade, dpt_id, teacher_id, isactive, credits) VALUES
('SCI101', 'Physics', 3, 1, 1, 1, 3),
('SCI102', 'Chemistry', 1, 1, 2, 1, 3),
('ART101', 'Drawing', 2, 2, 3, 1, 2),
('COM101', 'Accounting', 4, 3, 4, 1, 3),
('HR101', 'HR Management', 5, 7, 5, 1, 2),
('FIN101', 'Corporate Finance', 6, 8, 6, 1, 3),
('IT101', 'Programming', 7, 9, 7, 1, 4),
('ADM101', 'Admin Basics', 8, 10, 8, 1, 2),
('LIB101', 'Library Science', 9, 5, 9, 1, 2),
('TRN101', 'Logistics', 10, 6, 10, 1, 2);

-- ========================
-- 5.11 enrollments
-- ========================

INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2022-08-01'), -- grade 3 (student) matches grade 3 (course)
(2, 2, '2022-08-02'), -- grade 1 matches grade 1
(3, 3, '2022-08-03'), -- grade 2 matches grade 2
(4, 4, '2022-08-04'), -- grade 4 matches grade 4
(5, 5, '2022-08-05'), -- grade 5 matches grade 5
(6, 6, '2022-08-06'), -- grade 6 matches grade 6
(7, 7, '2022-08-07'), -- grade 7 matches grade 7
(8, 8, '2022-08-08'), -- grade 8 matches grade 8
(9, 9, '2022-08-09'), -- grade 9 matches grade 9
(10, 10, '2022-08-10'); -- grade 10 matches grade 10

-- ========================
-- 5.12 assessments
-- ========================
INSERT INTO assessments (enr_id, name, assessments_date, status, marks, grade) VALUES
(1, 'Quiz 1', '2022-08-05', 'P', 85, 'B'),
(2, 'Midterm', '2022-08-10', 'P', 78, 'C'),
(3, 'Assignment 1', '2022-08-07', 'P', 92, 'A'),
(4, 'Quiz 2', '2022-08-12', 'A', 0, 'F'),
(5, 'Project', '2022-08-15', 'P', 88, 'B'),
(6, 'Final Exam', '2022-08-20', 'P', 95, 'A'),
(7, 'Quiz 3', '2022-08-08', 'P', 80, 'B'),
(8, 'Midterm', '2022-08-11', 'P', 90, 'A'),
(9, 'Assignment 2', '2022-08-09', 'A', 0, 'F'),
(10, 'Quiz 4', '2022-08-13', 'P', 82, 'B');

-- ========================
-- 5.13 attendance
-- ========================
INSERT INTO attendance (student_id, course_id, attendance_date, status) VALUES
(1,1,'2022-08-01','P'),(2,2,'2022-08-02','A'),
(3,3,'2022-08-03','P'),(4,4,'2022-08-04','L'),
(5,5,'2022-08-05','P'),(6,6,'2022-08-06','A'),
(7,7,'2022-08-07','P'),(8,8,'2022-08-08','L'),
(9,9,'2022-08-09','P'),(10,10,'2022-08-10','A');

-- ========================
-- 5.14 emp_attendance
-- ========================
INSERT INTO emp_attendance (emp_id, attendance_date, status) VALUES
(1,'2022-08-01','P'),(2,'2022-08-02','P'),
(3,'2022-08-03','A'),(4,'2022-08-04','P'),
(5,'2022-08-05','L'),(6,'2022-08-06','P'),
(7,'2022-08-07','A'),(8,'2022-08-08','P'),
(9,'2022-08-09','P'),(10,'2022-08-10','L');


-- ========================
-- 5.15 classes
-- ========================
INSERT INTO classes (course_id, teacher_id, classroom, start_time, end_time, day_of_week) VALUES
(1,1,'Room A','08:00','09:00','Mon'),(2,2,'Room B','09:00','10:00','Tue'),
(3,3,'Room C','10:00','11:00','Wed'),(4,4,'Room D','11:00','12:00','Thu'),
(5,5,'Room E','12:00','13:00','Fri'),(6,6,'Room F','13:00','14:00','Mon'),
(7,7,'Room G','14:00','15:00','Tue'),(8,8,'Room H','15:00','16:00','Wed'),
(9,9,'Room I','16:00','17:00','Thu'),(10,10,'Room J','17:00','18:00','Fri');

-- ========================
-- 5.16 salary
-- ========================
INSERT INTO salary (emp_id, amount, `year`, `month`, status) VALUES
(1,50000,2022,1,'Paid'),(2,40000,2022,1,'Paid'),
(3,45000,2022,1,'Pending'),(4,35000,2022,1,'Paid'),
(5,60000,2022,1,'Paid'),(6,30000,2022,1,'Pending'),
(7,32000,2022,1,'Paid'),(8,40000,2022,1,'Paid'),
(9,37000,2022,1,'Conflict'),(10,42000,2022,1,'Paid');

-- ========================
-- 5.17 fee
-- ========================
INSERT INTO fee (std_id, tuition_fee, stationery, sports, annual_fee, electricity, maintenance, miscellaneous, p_amount, `year`, `month`, status) VALUES
(1,5000,500,300,2000,400,200,100,15000,2022,1,'Paid'),
(2,5000,400,200,1800,300,100,50,12000,2022,1,'Pending'),
(3,6000,600,350,2200,500,300,150,10000,2022,1,'Pending'),
(4,5500,450,250,2100,350,150,80,13500,2022,1,'Paid'),
(5,5000,500,300,2000,400,200,100,15000,2022,1,'Paid'),
(6,5500,480,260,2150,370,180,90,11000,2022,1,'Pending'),
(7,6000,600,350,2200,500,300,150,14000,2022,1,'Paid'),
(8,5000,500,300,2000,400,200,100,15000,2022,1,'Paid'),
(9,5300,420,280,2050,330,160,70,12500,2022,1,'Conflict'),
(10,5000,500,300,2000,400,200,100,15000,2022,1,'Paid');

-- ========================
-- 5.18
-- ========================

