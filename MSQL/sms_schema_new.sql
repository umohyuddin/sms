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
    REFERENCES employee (id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_user_cmp_id
    FOREIGN KEY (cmp_id)
    REFERENCES campuses (id)
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
    REFERENCES institutes (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_theme_user_id
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);


-- Creating table for Institutes
DROP TABLE IF EXISTS institutes;
CREATE TABLE IF NOT EXISTS institutes (
    id INT PRIMARY KEY AUTO_INCREMENT,
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
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
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
    REFERENCES institutes (id)
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
    REFERENCES institutes (id)
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
    REFERENCES institutes (id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Creating table for Campuses
DROP TABLE IF EXISTS campuses;
CREATE TABLE IF NOT EXISTS campuses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
    FOREIGN KEY (inst_id) REFERENCES institutes(id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Inventory TABLE
DROP TABLE IF EXISTS inventory;
CREATE TABLE IF NOT EXISTS inventory (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cmp_id BIGINT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    status ENUM('Available', 'InUse', 'Damaged') NOT NULL,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_inv_cmp_id
        FOREIGN KEY (cmp_id) REFERENCES campuses(id)
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
        FOREIGN KEY (cmp_id) REFERENCES campuses(id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Students TABLE
DROP TABLE IF EXISTS students;
CREATE TABLE IF NOT EXISTS students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cmp_id BIGINT NOT NULL,
	class_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
	gender VARCHAR(10) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(200),
	isactive BIT(1),
    enrollment_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_std_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(id)
		ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_std_class_id
		FOREIGN KEY (class_id) REFERENCES sclass(id)
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
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_role_id INT NOT NULL,
	cmp_id BIGINT NOT NULL,
    f_name VARCHAR(50) NOT NULL,
    l_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    hire_date DATE NOT NULL,
	isactive BIT(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_emp_roles
		FOREIGN KEY (emp_role_id)
		REFERENCES emp_roles (id)
		ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_emp_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- sclass TABLE
DROP TABLE IF EXISTS sclass;
CREATE TABLE IF NOT EXISTS sclass (
    id INT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT Not NULL,
    name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (inst_id)
    REFERENCES institutes (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- subject TABLE
DROP TABLE IF EXISTS subject;
CREATE TABLE IF NOT EXISTS subject (
    id INT PRIMARY KEY AUTO_INCREMENT,
    c_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    t_id BIGINT,
	isactive BIT(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (c_id) REFERENCES sclass(id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- assesments TABLE
DROP TABLE IF EXISTS assessments;
CREATE TABLE IF NOT EXISTS assessments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sbj_id INT NOT NULL,
	std_id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    assessments_date DATE NOT NULL,
	status ENUM('P', 'A') NOT NULL,
	marks INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_assessments_sbj_id
		FOREIGN KEY (sbj_id) REFERENCES subject(id) ON UPDATE CASCADE,
	CONSTRAINT fk_assessments_std_id
		FOREIGN KEY (std_id) REFERENCES students(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- results TABLE
DROP TABLE IF EXISTS results;
CREATE TABLE IF NOT EXISTS results (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sbj_id INT NOT NULL,
	std_id BIGINT NOT NULL,
	marks INT NOT NULL,
    grade VARCHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_results_sbj_id
		FOREIGN KEY (sbj_id) REFERENCES subject(id) ON UPDATE CASCADE,
	CONSTRAINT fk_results_std_id
		FOREIGN KEY (std_id) REFERENCES students(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Attendance TABLE
DROP TABLE IF EXISTS attendance;
CREATE TABLE IF NOT EXISTS attendance (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    std_id BIGINT,
    attendance_date DATE NOT NULL,
    status ENUM('P', 'A', 'L') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (std_id) REFERENCES students(id)
);

-- Employee Attendance TABLE
DROP TABLE IF EXISTS emp_attendance;
CREATE TABLE IF NOT EXISTS emp_attendance (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_id BIGINT,
    attendance_date DATE NOT NULL,
    status ENUM('P', 'A', 'L') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(id)
);

-- timeTable TABLE
DROP TABLE IF EXISTS timetable;
CREATE TABLE IF NOT EXISTS timetable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cls_id INT,
    sbj_id INT,
    classroom VARCHAR(50),
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day_of_week ENUM('Mon','Tue','Wed','Thu','Fri','Sat','Sun') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (cls_id) REFERENCES sclass(id),
    FOREIGN KEY (sbj_id) REFERENCES subject(id)
);

-- Employee Slaray TABLE
DROP TABLE IF EXISTS salary;
CREATE TABLE IF NOT EXISTS salary (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	emp_id BIGINT NOT NULL,
	amount DECIMAL(10,2) NOT NULL,
    `year` YEAR(4) NOT NULL,
    `month` INT NOT NULL,
	status ENUM('Paid', 'Pending', 'Conflict') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(id)
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
	CONSTRAINT fk_bd_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (id)
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
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT fk_fp_inst_id
    FOREIGN KEY (inst_id)
    REFERENCES institutes (id)
    ON DELETE RESTRICT ON UPDATE CASCADE
    );

-- Students Fee TABLE
DROP TABLE IF EXISTS fee;
CREATE TABLE IF NOT EXISTS fee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
	status ENUM('Paid', 'Pending', 'Forward') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (std_id) REFERENCES students(id)
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
-- 5.1 Institutes
-- ========================
SET FOREIGN_KEY_CHECKS = 0;

-- Insert data into user_roles
INSERT INTO user_roles (role_name) VALUES
('Admin'), ('Teacher'), ('Staff'), ('Manager'), ('Principal'),
('Coordinator'), ('Librarian'), ('Counselor'), ('Accountant'), ('Registrar');

-- Insert data into institutes
INSERT INTO institutes (name, address, contact_number, email, website, tagline, country, established_date) VALUES
('Springfield High', '123 Main St', '1234567890', 'springfield@example.com', 'www.springfield.edu', 'Knowledge is Power', 'USA', '2000-01-01'),
('Riverside Academy', '456 River Rd', '2345678901', 'riverside@example.com', 'www.riverside.edu', 'Excellence in Education', 'USA', '1995-03-15'),
('Greenwood School', '789 Green St', '3456789012', 'greenwood@example.com', 'www.greenwood.edu', 'Learn and Grow', 'USA', '2010-06-20'),
('Bright Future Institute', '101 Bright Ave', '4567890123', 'brightfuture@example.com', 'www.brightfuture.edu', 'Shaping Tomorrow', 'USA', '2005-09-10'),
('Oakwood College', '202 Oak St', '5678901234', 'oakwood@example.com', 'www.oakwood.edu', 'Education for All', 'USA', '1990-11-25'),
('Maple Academy', '303 Maple Dr', '6789012345', 'maple@example.com', 'www.maple.edu', 'Inspire and Achieve', 'USA', '2008-02-14'),
('Pine Hill School', '404 Pine Rd', '7890123456', 'pinehill@example.com', 'www.pinehill.edu', 'Future Leaders', 'USA', '2012-07-30'),
('Cedar Institute', '505 Cedar Ln', '8901234567', 'cedar@example.com', 'www.cedar.edu', 'Empowering Minds', 'USA', '2003-04-18'),
('Elmwood Academy', '606 Elm St', '9012345678', 'elmwood@example.com', 'www.elmwood.edu', 'Knowledge for Life', 'USA', '1998-12-05'),
('Willow School', '707 Willow Ave', '0123456789', 'willow@example.com', 'www.willow.edu', 'Grow with Us', 'USA', '2007-08-22');

-- Insert data into campuses
INSERT INTO campuses (inst_id, name, contact, email, website, address, province, city) VALUES
(1, 'Springfield Main Campus', '1234567890', 'main@springfield.edu', 'www.springfield.edu/main', '123 Main St', 'CA', 'Springfield'),
(1, 'Springfield North Campus', '1234567891', 'north@springfield.edu', 'www.springfield.edu/north', '124 Main St', 'CA', 'Springfield'),
(2, 'Riverside Central Campus', '2345678901', 'central@riverside.edu', 'www.riverside.edu/central', '456 River Rd', 'NY', 'Riverside'),
(2, 'Riverside East Campus', '2345678902', 'east@riverside.edu', 'www.riverside.edu/east', '457 River Rd', 'NY', 'Riverside'),
(3, 'Greenwood Main Campus', '3456789012', 'main@greenwood.edu', 'www.greenwood.edu/main', '789 Green St', 'TX', 'Greenwood'),
(4, 'Bright Future Campus', '4567890123', 'main@brightfuture.edu', 'www.brightfuture.edu', '101 Bright Ave', 'FL', 'Bright City'),
(5, 'Oakwood Main Campus', '5678901234', 'main@oakwood.edu', 'www.oakwood.edu', '202 Oak St', 'IL', 'Oakwood'),
(6, 'Maple Main Campus', '6789012345', 'main@maple.edu', 'www.maple.edu', '303 Maple Dr', 'GA', 'Maple City'),
(7, 'Pine Hill Campus', '7890123456', 'main@pinehill.edu', 'www.pinehill.edu', '404 Pine Rd', 'WA', 'Pine Hill'),
(8, 'Cedar Main Campus', '8901234567', 'main@cedar.edu', 'www.cedar.edu', '505 Cedar Ln', 'OR', 'Cedar City');

-- Insert data into emp_roles
INSERT INTO emp_roles (role_name) VALUES
('Teacher'), ('Admin'), ('Librarian'), ('Counselor'), ('Security'),
('Janitor'), ('Accountant'), ('Registrar'), ('Principal'), ('Coordinator');


-- Insert data into employee
INSERT INTO employee (emp_role_id, cmp_id, f_name, l_name, email, phone, hire_date, isactive) VALUES
(1, 1, 'John', 'Doe', 'john.doe@example.com', '1234567890', '2020-01-01', 1),
(2, 1, 'Jane', 'Smith', 'jane.smith@example.com', '1234567891', '2019-03-15', 1),
(3, 2, 'Alice', 'Johnson', 'alice.johnson@example.com', '2345678901', '2021-06-20', 1),
(4, 2, 'Bob', 'Williams', 'bob.williams@example.com', '2345678902', '2018-09-10', 1),
(5, 3, 'Carol', 'Brown', 'carol.brown@example.com', '3456789012', '2022-11-25', 1),
(6, 4, 'David', 'Jones', 'david.jones@example.com', '4567890123', '2017-02-14', 1),
(7, 5, 'Emma', 'Garcia', 'emma.garcia@example.com', '5678901234', '2020-07-30', 1),
(8, 6, 'Frank', 'Martinez', 'frank.martinez@example.com', '6789012345', '2019-04-18', 1),
(9, 7, 'Grace', 'Lee', 'grace.lee@example.com', '7890123456', '2021-12-05', 1),
(10, 8, 'Henry', 'Taylor', 'henry.taylor@example.com', '8901234567', '2018-08-22', 1);

-- Insert data into user
INSERT INTO `user` (role_id, emp_id, cmp_id, isactive, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, password) VALUES
(1, 1, 1, 1, 1, 1, 1, 'john.doe@example.com', 1, 'password123'),
(2, 2, 1, 1, 1, 1, 1, 'jane.smith@example.com', 1, 'password123'),
(3, 3, 2, 1, 1, 1, 1, 'alice.johnson@example.com', 1, 'password123'),
(4, 4, 2, 1, 1, 1, 1, 'bob.williams@example.com', 1, 'password123'),
(5, 5, 3, 1, 1, 1, 1, 'carol.brown@example.com', 1, 'password123'),
(6, 6, 4, 1, 1, 1, 1, 'david.jones@example.com', 1, 'password123'),
(7, 7, 5, 1, 1, 1, 1, 'emma.garcia@example.com', 1, 'password123'),
(8, 8, 6, 1, 1, 1, 1, 'frank.martinez@example.com', 1, 'password123'),
(9, 9, 7, 1, 1, 1, 1, 'grace.lee@example.com', 1, 'password123'),
(10, 10, 8, 1, 1, 1, 1, 'henry.taylor@example.com', 1, 'password123');

-- Insert data into theme
INSERT INTO theme (user_id, inst_id, name, sidebar_bg, sidebar_text, body_bg, body_text, header_bg, header_text, active_item_bg, active_item_text) VALUES
(1, 1, 'Default', '#1a202c', '#ffffff', '#f7fafc', '#2d3748', '#2b6cb0', '#ffffff', '#2b6cb0', '#ffffff'),
(2, 1, 'Dark', '#2d3748', '#e2e8f0', '#1a202c', '#e2e8f0', '#4a5568', '#e2e8f0', '#4a5568', '#ffffff'),
(3, 2, 'Blue', '#3182ce', '#ffffff', '#ebf8ff', '#2b6cb0', '#2b6cb0', '#ffffff', '#2b6cb0', '#ffffff'),
(4, 2, 'Green', '#38a169', '#ffffff', '#f0fff4', '#276749', '#276749', '#ffffff', '#276749', '#ffffff'),
(5, 3, 'Red', '#e53e3e', '#ffffff', '#fff5f5', '#c53030', '#c53030', '#ffffff', '#c53030', '#ffffff'),
(6, 4, 'Purple', '#805ad5', '#ffffff', '#faf5ff', '#553c9a', '#553c9a', '#ffffff', '#553c9a', '#ffffff'),
(7, 5, 'Teal', '#319795', '#ffffff', '#e6fffa', '#285e61', '#285e61', '#ffffff', '#285e61', '#ffffff'),
(8, 6, 'Orange', '#ed8936', '#ffffff', '#fffaf0', '#c05621', '#c05621', '#ffffff', '#c05621', '#ffffff'),
(9, 7, 'Gray', '#4a5568', '#ffffff', '#edf2f7', '#2d3748', '#2d3748', '#ffffff', '#2d3748', '#ffffff'),
(10, 8, 'Indigo', '#4c51bf', '#ffffff', '#ebf4ff', '#434190', '#434190', '#ffffff', '#434190', '#ffffff');

-- Insert data into rules
INSERT INTO rules (inst_id, rules) VALUES
(1, 'No smoking on campus. All students must wear uniforms.'),
(2, 'Punctuality is mandatory. No electronic devices during class.'),
(3, 'Respect teachers and peers. Complete assignments on time.'),
(4, 'Follow dress code. Maintain cleanliness in classrooms.'),
(5, 'No bullying allowed. Attend all scheduled classes.'),
(6, 'Keep campus clean. Follow safety protocols.'),
(7, 'No unauthorized visitors. Submit assignments on time.'),
(8, 'Respect school property. No food in classrooms.'),
(9, 'Attend all mandatory events. No cheating in exams.'),
(10, 'Follow ethical guidelines. Maintain academic integrity.');

-- Insert data into failcriteria
INSERT INTO failcriteria (inst_id, percentage, subjectmarks, noofsubjects) VALUES
(1, 40, 50, 2),
(2, 35, 45, 3),
(3, 50, 60, 2),
(4, 45, 55, 3),
(5, 40, 50, 2),
(6, 35, 45, 3),
(7, 50, 60, 2),
(8, 45, 55, 3),
(9, 40, 50, 2),
(10, 35, 45, 3);

-- Insert data into marksgrading
INSERT INTO marksgrading (inst_id, name, marks) VALUES
(1, 'A+', 90),
(1, 'A', 80),
(2, 'B+', 75),
(2, 'B', 65),
(3, 'C+', 55),
(3, 'C', 50),
(4, 'D+', 45),
(4, 'D', 40),
(5, 'F', 35),
(6, 'E', 30);

-- Insert data into inventory
INSERT INTO inventory (cmp_id, item_name, quantity, status) VALUES
(1, 'Projector', 5, 'Available'),
(1, 'Laptop', 10, 'InUse'),
(2, 'Desk', 50, 'Available'),
(2, 'Chair', 100, 'Available'),
(3, 'Whiteboard', 20, 'InUse'),
(4, 'Printer', 5, 'Damaged'),
(5, 'Books', 200, 'Available'),
(6, 'Microscope', 15, 'InUse'),
(7, 'Computer', 30, 'Available'),
(8, 'Tablet', 25, 'InUse');

-- Insert data into expenses
INSERT INTO expenses (cmp_id, amount, details) VALUES
(1, 5000, 'Electricity Bill'),
(1, 2000, 'Stationery Purchase'),
(2, 3000, 'Maintenance Costs'),
(2, 1500, 'Cleaning Services'),
(3, 4000, 'Event Expenses'),
(4, 2500, 'Equipment Repair'),
(5, 6000, 'Software Licenses'),
(6, 3500, 'Furniture Purchase'),
(7, 4500, 'Security Services'),
(8, 2000, 'Miscellaneous Expenses');

-- Insert data into students
INSERT INTO students (cmp_id, class_id, first_name, last_name, dob, gender, email, phone, address, isactive, enrollment_date) VALUES
(1, 1, 'Michael', 'Scott', '2005-01-01', 'Male', 'michael.scott@example.com', '1234567890', '123 Main St', 1, '2023-09-01'),
(1, 2, 'Pam', 'Beesly', '2005-02-02', 'Female', 'pam.beesly@example.com', '1234567891', '124 Main St', 1, '2023-09-01'),
(2, 3, 'Jim', 'Halpert', '2005-03-03', 'Male', 'jim.halpert@example.com', '2345678901', '456 River Rd', 1, '2023-09-01'),
(2, 4, 'Dwight', 'Schrute', '2005-04-04', 'Male', 'dwight.schrute@example.com', '2345678902', '457 River Rd', 1, '2023-09-01'),
(3, 5, 'Angela', 'Martin', '2005-05-05', 'Female', 'angela.martin@example.com', '3456789012', '789 Green St', 1, '2023-09-01'),
(4, 6, 'Kevin', 'Malone', '2005-06-06', 'Male', 'kevin.malone@example.com', '4567890123', '101 Bright Ave', 1, '2023-09-01'),
(5, 7, 'Oscar', 'Martinez', '2005-07-07', 'Male', 'oscar.martinez@example.com', '5678901234', '202 Oak St', 1, '2023-09-01'),
(6, 8, 'Erin', 'Hannon', '2005-08-08', 'Female', 'erin.hannon@example.com', '6789012345', '303 Maple Dr', 1, '2023-09-01'),
(7, 9, 'Stanley', 'Hudson', '2005-09-09', 'Male', 'stanley.hudson@example.com', '7890123456', '404 Pine Rd', 1, '2023-09-01'),
(8, 10, 'Phyllis', 'Vance', '2005-10-10', 'Female', 'phyllis.vance@example.com', '8901234567', '505 Cedar Ln', 1, '2023-09-01');

-- Insert data into sclass
INSERT INTO sclass (inst_id, name) VALUES
(1, 'Class 1A'),
(1, 'Class 1B'),
(2, 'Class 2A'),
(2, 'Class 2B'),
(3, 'Class 3A'),
(4, 'Class 4A'),
(5, 'Class 5A'),
(6, 'Class 6A'),
(7, 'Class 7A'),
(8, 'Class 8A');

-- Insert data into subject
INSERT INTO subject (c_id, name, t_id, isactive) VALUES
(1, 'Mathematics', 1, 1),
(1, 'Science', 2, 1),
(2, 'English', 3, 1),
(2, 'History', 4, 1),
(3, 'Physical Education', 5, 1),
(4, 'Art', 6, 1),
(5, 'Music', 7, 1),
(6, 'Computer Science', 8, 1),
(7, 'Biology', 9, 1),
(8, 'Chemistry', 10, 1);

-- Insert data into assessments
INSERT INTO assessments (sbj_id, std_id, name, assessments_date, status, marks) VALUES
(1, 1, 'Midterm', '2025-03-01', 'P', 85),
(2, 2, 'Quiz 1', '2025-03-02', 'P', 90),
(3, 3, 'Final', '2025-06-01', 'P', 78),
(4, 4, 'Midterm', '2025-03-03', 'A', 0),
(5, 5, 'Quiz 2', '2025-03-04', 'P', 88),
(6, 6, 'Midterm', '2025-03-05', 'P', 92),
(7, 7, 'Final', '2025-06-02', 'P', 80),
(8, 8, 'Quiz 3', '2025-03-06', 'P', 85),
(9, 9, 'Midterm', '2025-03-07', 'P', 87),
(10, 10, 'Final', '2025-06-03', 'P', 90);

-- Insert data into results
INSERT INTO results (sbj_id, std_id, marks, grade) VALUES
(1, 1, 85, 'A'),
(2, 2, 90, 'A+'),
(3, 3, 78, 'B'),
(4, 4, 65, 'C'),
(5, 5, 88, 'A'),
(6, 6, 92, 'A+'),
(7, 7, 80, 'B+'),
(8, 8, 85, 'A'),
(9, 9, 87, 'A'),
(10, 10, 90, 'A+');

-- Insert data into attendance
INSERT INTO attendance (std_id, attendance_date, status) VALUES
(1, '2025-09-01', 'P'),
(2, '2025-09-01', 'P'),
(3, '2025-09-01', 'A'),
(4, '2025-09-01', 'L'),
(5, '2025-09-01', 'P'),
(6, '2025-09-01', 'P'),
(7, '2025-09-01', 'P'),
(8, '2025-09-01', 'A'),
(9, '2025-09-01', 'P'),
(10, '2025-09-01', 'P');

-- Insert data into emp_attendance
INSERT INTO emp_attendance (emp_id, attendance_date, status) VALUES
(1, '2025-09-01', 'P'),
(2, '2025-09-01', 'P'),
(3, '2025-09-01', 'A'),
(4, '2025-09-01', 'P'),
(5, '2025-09-01', 'P'),
(6, '2025-09-01', 'L'),
(7, '2025-09-01', 'P'),
(8, '2025-09-01', 'P'),
(9, '2025-09-01', 'A'),
(10, '2025-09-01', 'P');

-- Insert data into timetable
INSERT INTO timetable (cls_id, sbj_id, classroom, start_time, end_time, day_of_week) VALUES
(1, 1, 'Room 101', '08:00:00', '09:00:00', 'Mon'),
(1, 2, 'Room 102', '09:00:00', '10:00:00', 'Mon'),
(2, 3, 'Room 201', '08:00:00', '09:00:00', 'Tue'),
(2, 4, 'Room 202', '09:00:00', '10:00:00', 'Tue'),
(3, 5, 'Gym', '08:00:00', '09:00:00', 'Wed'),
(4, 6, 'Art Room', '08:00:00', '09:00:00', 'Thu'),
(5, 7, 'Music Room', '08:00:00', '09:00:00', 'Fri'),
(6, 8, 'Computer Lab', '08:00:00', '09:00:00', 'Mon'),
(7, 9, 'Science Lab', '08:00:00', '09:00:00', 'Tue'),
(8, 10, 'Chemistry Lab', '08:00:00', '09:00:00', 'Wed');

-- Insert data into salary
INSERT INTO salary (emp_id, amount, `year`, `month`, status) VALUES
(1, 3000.00, 2025, 9, 'Paid'),
(2, 3200.00, 2025, 9, 'Paid'),
(3, 2800.00, 2025, 9, 'Pending'),
(4, 2900.00, 2025, 9, 'Paid'),
(5, 3100.00, 2025, 9, 'Paid'),
(6, 2700.00, 2025, 9, 'Pending'),
(7, 3300.00, 2025, 9, 'Paid'),
(8, 3000.00, 2025, 9, 'Paid'),
(9, 2800.00, 2025, 9, 'Conflict'),
(10, 3100.00, 2025, 9, 'Paid');

-- Insert data into bankdetails
INSERT INTO bankdetails (inst_id, name, address, account_no, iban, instruction) VALUES
(1, 'Bank of Springfield', '123 Bank St', '123456789012', 'US123456789012', 'Pay by check or wire transfer'),
(2, 'Riverside Bank', '456 River St', '234567890123', 'US234567890123', 'Wire transfer only'),
(3, 'Greenwood Bank', '789 Green St', '345678901234', 'US345678901234', 'Pay by check'),
(4, 'Bright Bank', '101 Bright Ave', '456789012345', 'US456789012345', 'Online payment preferred'),
(5, 'Oakwood Bank', '202 Oak St', '567890123456', 'US567890123456', 'Wire transfer only'),
(6, 'Maple Bank', '303 Maple Dr', '678901234567', 'US678901234567', 'Pay by check or wire transfer'),
(7, 'Pine Hill Bank', '404 Pine Rd', '789012345678', 'US789012345678', 'Online payment preferred'),
(8, 'Cedar Bank', '505 Cedar Ln', '890123456789', 'US890123456789', 'Wire transfer only'),
(9, 'Elmwood Bank', '606 Elm St', '901234567890', 'US901234567890', 'Pay by check'),
(10, 'Willow Bank', '707 Willow Ave', '012345678901', 'US012345678901', 'Online payment preferred');

-- Insert data into feeparticular
INSERT INTO feeparticular (inst_id, name, tuition_fee, stationery, sports, annual_fee, electricity, maintenance, miscellaneous) VALUES
(1, 'Standard Fee', 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00),
(2, 'Premium Fee', 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00),
(3, 'Basic Fee', 900.00, 40.00, 20.00, 150.00, 15.00, 25.00, 5.00),
(4, 'Advanced Fee', 1100.00, 55.00, 35.00, 220.00, 22.00, 32.00, 12.00),
(5, 'Standard Fee', 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00),
(6, 'Premium Fee', 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00),
(7, 'Basic Fee', 900.00, 40.00, 20.00, 150.00, 15.00, 25.00, 5.00),
(8, 'Advanced Fee', 1100.00, 55.00, 35.00, 220.00, 22.00, 32.00, 12.00),
(9, 'Standard Fee', 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00),
(10, 'Premium Fee', 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00);

-- Insert data into fee
INSERT INTO fee (std_id, tuition_fee, stationery, sports, annual_fee, electricity, maintenance, miscellaneous, t_amount, p_amount, arrears, `year`, `month`, status) VALUES
(1, 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00, 1340.00, 1340.00, 0.00, 2025, 9, 'Paid'),
(2, 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00, 1340.00, 1000.00, 340.00, 2025, 9, 'Pending'),
(3, 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00, 1625.00, 1625.00, 0.00, 2025, 9, 'Paid'),
(4, 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00, 1625.00, 0.00, 1625.00, 2025, 9, 'Pending'),
(5, 900.00, 40.00, 20.00, 150.00, 15.00, 25.00, 5.00, 1155.00, 1155.00, 0.00, 2025, 9, 'Paid'),
(6, 1100.00, 55.00, 35.00, 220.00, 22.00, 32.00, 12.00, 1476.00, 1476.00, 0.00, 2025, 9, 'Paid'),
(7, 1000.00, 50.00, 30.00, 200.00, 20.00, 30.00, 10.00, 1340.00, 1000.00, 340.00, 2025, 9, 'Pending'),
(8, 1200.00, 60.00, 40.00, 250.00, 25.00, 35.00, 15.00, 1625.00, 1625.00, 0.00, 2025, 9, 'Paid'),
(9, 900.00, 40.00, 20.00, 150.00, 15.00, 25.00, 5.00, 1155.00, 0.00, 1155.00, 2025, 9, 'Pending'),
(10, 1100.00, 55.00, 35.00, 220.00, 22.00, 32.00, 12.00, 1476.00, 1476.00, 0.00, 2025, 9, 'Paid');

SET FOREIGN_KEY_CHECKS = 1;

