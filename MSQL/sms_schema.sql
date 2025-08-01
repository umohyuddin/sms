-- USER_ROLE TABLE
CREATE TABLE user_role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- USER TABLE
CREATE TABLE `user` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_id BIGINT NOT NULL,
  emp_id BIGINT NOT NULL,
  isactive BIT(1),
  account_non_expired BIT(1) NOT NULL,
  account_non_locked BIT(1) NOT NULL,
  credentials_non_expired BIT(1) NOT NULL,
  email VARCHAR(255) UNIQUE,
  enabled BIT(1) NOT NULL,
  password VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_role (id)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_emp_role
    FOREIGN KEY (emp_id)
    REFERENCES employee (employee_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Creating table for Institutes
CREATE TABLE institutes (
    institute_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    contact_number VARCHAR(20),
    email VARCHAR(100),
    established_date DATE
);

-- Creating table for Campuses
CREATE TABLE campuses (
    campus_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    inst_id INT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(50),
	CONSTRAINT fk_inst_id
    FOREIGN KEY (inst_id) REFERENCES institutes(institute_id)
    ON DELETE RESTRICT ON UPDATE CASCADE
);


-- Students TABLE
CREATE TABLE students (
    student_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cmp_id BIGINT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(200),
	isactive BIT(1),
    enrollment_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_std_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Employee_ROLES TABLE
CREATE TABLE emp_roles (
  id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Employee TABLE
CREATE TABLE employee (
    employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_role_id INT NOT NULL,
	cmp_id BIGINT NOT NULL,
    f_name VARCHAR(50) NOT NULL,
    l_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    hire_date DATE NOT NULL,
    department VARCHAR(50),
	isactive BIT(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_emp_roles
		FOREIGN KEY (emp_role_id)
		REFERENCES emp_roles (id)
		ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_emp_cmp_id
		FOREIGN KEY (cmp_id) REFERENCES campuses(campus_id)
		ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Departments TABLE
CREATE TABLE departments (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100) NOT NULL UNIQUE,
    dpt_head_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dpt_head_id) REFERENCES employee(employee_id)
);

-- Courses TABLE
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(10) UNIQUE NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    dpt_id INT,
    teacher_id BIGINT,
	isactive BIT(1),
    credits INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dpt_id) REFERENCES departments(department_id),
    FOREIGN KEY (teacher_id) REFERENCES employee(employee_id)
);

-- Enrollments TABLE
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id INT,
    enrollment_date DATE NOT NULL,
    grade VARCHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- Attendance TABLE
CREATE TABLE attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id INT,
    attendance_date DATE NOT NULL,
    status ENUM('Present', 'Absent', 'Late') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- Employee Attendance TABLE
CREATE TABLE emp_attendance (
    emp_atn_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_id BIGINT,
    attendance_date DATE NOT NULL,
    status ENUM('Present', 'Absent', 'Late') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(employee_id)
);

-- Classes TABLE
CREATE TABLE classes (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT,
    teacher_id BIGINT,
    classroom VARCHAR(50),
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day_of_week ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    FOREIGN KEY (teacher_id) REFERENCES employee(employee_id)
);

-- Employee Slaray TABLE
CREATE TABLE salary (
    slr_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	emp_id BIGINT,
	amount BIGINT,
    `year` YEAR(4),
    `month` INT,
	status ENUM('Paid', 'Pending', 'Conflict') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (emp_id) REFERENCES employee(employee_id)
);

-- Students Fee TABLE
CREATE TABLE Fee (
    fee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	std_id BIGINT,
	amount BIGINT,
    `year` YEAR(4),
    `month` INT,
	status ENUM('Paid', 'Pending', 'Conflict') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (std_id) REFERENCES students(student_id)
);
