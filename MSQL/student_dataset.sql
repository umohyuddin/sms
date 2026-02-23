-- Admission Types
INSERT INTO admission_type (organization_id, type_name, created_at, updated_at)
VALUES (1, 'New Admission', NOW(), NOW()),
       (1, 'Transfer', NOW(), NOW()),
       (1, 'Promoted', NOW(), NOW());

-- Student Data (5 per section for 30 sections = 150 students)
-- Campus 1, Standards 1-5, Sections 1-15
-- Campus 2, Standards 6-10, Sections 16-30

INSERT INTO students (organization_id, first_name, full_name, last_name, student_code, date_of_birth, gender, email, enrollment_date, campus_id, standard_id, section_id, admission_type_id, academic_year_id)
VALUES
-- Standard 1 (Campus 1), Section 1 (A)
(1, 'Ahmed', 'Ahmed Ali', 'Ali', 'STU001', '2015-05-12', 'Male', 'stu001@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Sara', 'Sara Khan', 'Khan', 'STU002', '2015-06-15', 'Female', 'stu002@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Omar', 'Omar Farooq', 'Farooq', 'STU003', '2015-04-20', 'Male', 'stu003@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Zainab', 'Zainab Bibi', 'Bibi', 'STU004', '2015-08-10', 'Female', 'stu004@example.com', '2026-02-22', 1, 1, 1, 1, 1),
(1, 'Bilal', 'Bilal Hassan', 'Hassan', 'STU005', '2015-03-05', 'Male', 'stu005@example.com', '2026-02-22', 1, 1, 1, 1, 1),

-- Standard 1 (Campus 1), Section 2 (B)
(1, 'Fatima', 'Fatima Zahra', 'Zahra', 'STU006', '2015-07-22', 'Female', 'stu006@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Usman', 'Usman Sheikh', 'Sheikh', 'STU007', '2015-09-30', 'Male', 'stu007@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Ayesha', 'Ayesha Malik', 'Malik', 'STU008', '2015-01-12', 'Female', 'stu008@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Hamza', 'Hamza Butt', 'Butt', 'STU009', '2015-11-05', 'Male', 'stu009@example.com', '2026-02-22', 1, 1, 2, 1, 1),
(1, 'Hania', 'Hania Amir', 'Amir', 'STU010', '2015-12-25', 'Female', 'stu010@example.com', '2026-02-22', 1, 1, 2, 1, 1),

-- Standard 1 (Campus 1), Section 3 (C)
(1, 'Ali', 'Ali Raza', 'Raza', 'STU011', '2015-02-14', 'Male', 'stu011@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Dua', 'Dua Lipa', 'Lipa', 'STU012', '2015-04-18', 'Female', 'stu012@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Mustafa', 'Mustafa Kamal', 'Kamal', 'STU013', '2015-06-06', 'Male', 'stu013@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Inaya', 'Inaya Fatima', 'Fatima', 'STU014', '2015-10-10', 'Female', 'stu014@example.com', '2026-02-22', 1, 1, 3, 1, 1),
(1, 'Rayyan', 'Rayyan Abbas', 'Abbas', 'STU015', '2015-08-25', 'Male', 'stu015@example.com', '2026-02-22', 1, 1, 3, 1, 1),

-- Standard 2 (Campus 1), Section 4 (A)
(1, 'Student', 'Student 16', '16', 'STU016', '2014-05-01', 'Male', 'stu016@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 17', '17', 'STU017', '2014-05-02', 'Female', 'stu017@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 18', '18', 'STU018', '2014-05-03', 'Male', 'stu018@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 19', '19', 'STU019', '2014-05-04', 'Female', 'stu019@example.com', '2026-02-22', 1, 2, 4, 1, 1),
(1, 'Student', 'Student 20', '20', 'STU020', '2014-05-05', 'Male', 'stu020@example.com', '2026-02-22', 1, 2, 4, 1, 1),

-- Standard 2 (Campus 1), Section 5 (B)
(1, 'Student', 'Student 21', '21', 'STU021', '2014-06-01', 'Female', 'stu021@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 22', '22', 'STU022', '2014-06-02', 'Male', 'stu022@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 23', '23', 'STU023', '2014-06-03', 'Female', 'stu023@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 24', '24', 'STU024', '2014-06-04', 'Male', 'stu024@example.com', '2026-02-22', 1, 2, 5, 1, 1),
(1, 'Student', 'Student 25', '25', 'STU025', '2014-06-05', 'Female', 'stu025@example.com', '2026-02-22', 1, 2, 5, 1, 1),

-- Standard 2 (Campus 1), Section 6 (C)
(1, 'Student', 'Student 26', '26', 'STU026', '2014-07-01', 'Male', 'stu026@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 27', '27', 'STU027', '2014-07-02', 'Female', 'stu027@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 28', '28', 'STU028', '2014-07-03', 'Male', 'stu028@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 29', '29', 'STU029', '2014-07-04', 'Female', 'stu029@example.com', '2026-02-22', 1, 2, 6, 1, 1),
(1, 'Student', 'Student 30', '30', 'STU030', '2014-07-05', 'Male', 'stu030@example.com', '2026-02-22', 1, 2, 6, 1, 1),

-- Standard 3 (Campus 1), Section 7 (A)
(1, 'Student', 'Student 31', '31', 'STU031', '2013-05-01', 'Male', 'stu031@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 32', '32', 'STU032', '2013-05-02', 'Female', 'stu032@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 33', '33', 'STU033', '2013-05-03', 'Male', 'stu033@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 34', '34', 'STU034', '2013-05-04', 'Female', 'stu034@example.com', '2026-02-22', 1, 3, 7, 1, 1),
(1, 'Student', 'Student 35', '35', 'STU035', '2013-05-05', 'Male', 'stu035@example.com', '2026-02-22', 1, 3, 7, 1, 1),

-- Standard 3 (Campus 1), Section 8 (B)
(1, 'Student', 'Student 36', '36', 'STU036', '2013-06-01', 'Female', 'stu036@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 37', '37', 'STU037', '2013-06-02', 'Male', 'stu037@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 38', '38', 'STU038', '2013-06-03', 'Female', 'stu038@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 39', '39', 'STU039', '2013-06-04', 'Male', 'stu039@example.com', '2026-02-22', 1, 3, 8, 1, 1),
(1, 'Student', 'Student 40', '40', 'STU040', '2013-06-05', 'Female', 'stu040@example.com', '2026-02-22', 1, 3, 8, 1, 1),

-- Standard 3 (Campus 1), Section 9 (C)
(1, 'Student', 'Student 41', '41', 'STU041', '2013-07-01', 'Male', 'stu041@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 42', '42', 'STU042', '2013-07-02', 'Female', 'stu042@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 43', '43', 'STU043', '2013-07-03', 'Male', 'stu043@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 44', '44', 'STU044', '2013-07-04', 'Female', 'stu044@example.com', '2026-02-22', 1, 3, 9, 1, 1),
(1, 'Student', 'Student 45', '45', 'STU045', '2013-07-05', 'Male', 'stu045@example.com', '2026-02-22', 1, 3, 9, 1, 1),

-- Standard 4 (Campus 1), Section 10 (A)
(1, 'Student', 'Student 46', '46', 'STU046', '2012-05-01', 'Male', 'stu046@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 47', '47', 'STU047', '2012-05-02', 'Female', 'stu047@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 48', '48', 'STU048', '2012-05-03', 'Male', 'stu048@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 49', '49', 'STU049', '2012-05-04', 'Female', 'stu049@example.com', '2026-02-22', 1, 4, 10, 1, 1),
(1, 'Student', 'Student 50', '50', 'STU050', '2012-05-05', 'Male', 'stu050@example.com', '2026-02-22', 1, 4, 10, 1, 1),

-- Standard 4 (Campus 1), Section 11 (B)
(1, 'Student', 'Student 51', '51', 'STU051', '2012-06-01', 'Female', 'stu051@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 52', '52', 'STU052', '2012-06-02', 'Male', 'stu052@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 53', '53', 'STU053', '2012-06-03', 'Female', 'stu053@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 54', '54', 'STU054', '2012-06-04', 'Male', 'stu054@example.com', '2026-02-22', 1, 4, 11, 1, 1),
(1, 'Student', 'Student 55', '55', 'STU055', '2012-06-05', 'Female', 'stu055@example.com', '2026-02-22', 1, 4, 11, 1, 1),

-- Standard 4 (Campus 1), Section 12 (C)
(1, 'Student', 'Student 56', '56', 'STU056', '2012-07-01', 'Male', 'stu056@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 57', '57', 'STU057', '2012-07-02', 'Female', 'stu057@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 58', '58', 'STU058', '2012-07-03', 'Male', 'stu058@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 59', '59', 'STU059', '2012-07-04', 'Female', 'stu059@example.com', '2026-02-22', 1, 4, 12, 1, 1),
(1, 'Student', 'Student 60', '60', 'STU060', '2012-07-05', 'Male', 'stu060@example.com', '2026-02-22', 1, 4, 12, 1, 1),

-- Standard 5 (Campus 1), Section 13 (A)
(1, 'Student', 'Student 61', '61', 'STU061', '2011-05-01', 'Male', 'stu061@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 62', '62', 'STU062', '2011-05-02', 'Female', 'stu062@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 63', '63', 'STU063', '2011-05-03', 'Male', 'stu063@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 64', '64', 'STU064', '2011-05-04', 'Female', 'stu064@example.com', '2026-02-22', 1, 5, 13, 1, 1),
(1, 'Student', 'Student 65', '65', 'STU065', '2011-05-05', 'Male', 'stu065@example.com', '2026-02-22', 1, 5, 13, 1, 1),

-- Standard 5 (Campus 1), Section 14 (B)
(1, 'Student', 'Student 66', '66', 'STU066', '2011-06-01', 'Female', 'stu066@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 67', '67', 'STU067', '2011-06-02', 'Male', 'stu067@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 68', '68', 'STU068', '2011-06-03', 'Female', 'stu068@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 69', '69', 'STU069', '2011-06-04', 'Male', 'stu069@example.com', '2026-02-22', 1, 5, 14, 1, 1),
(1, 'Student', 'Student 70', '70', 'STU070', '2011-06-05', 'Female', 'stu070@example.com', '2026-02-22', 1, 5, 14, 1, 1),

-- Standard 5 (Campus 1), Section 15 (C)
(1, 'Student', 'Student 71', '71', 'STU071', '2011-07-01', 'Male', 'stu071@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 72', '72', 'STU072', '2011-07-02', 'Female', 'stu072@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 73', '73', 'STU073', '2011-07-03', 'Male', 'stu073@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 74', '74', 'STU074', '2011-07-04', 'Female', 'stu074@example.com', '2026-02-22', 1, 5, 15, 1, 1),
(1, 'Student', 'Student 75', '75', 'STU075', '2011-07-05', 'Male', 'stu075@example.com', '2026-02-22', 1, 5, 15, 1, 1),

-- Campus 2, Standards 6-10, Sections 16-30
-- Standard 6 (Campus 2), Section 16 (A)
(1, 'Uptown', 'Uptown Student 76', '76', 'STU076', '2010-05-01', 'Male', 'stu076@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 77', '77', 'STU077', '2010-05-02', 'Female', 'stu077@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 78', '78', 'STU078', '2010-05-03', 'Male', 'stu078@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 79', '79', 'STU079', '2010-05-04', 'Female', 'stu079@example.com', '2026-02-22', 2, 6, 16, 1, 1),
(1, 'Uptown', 'Uptown Student 80', '80', 'STU080', '2010-05-05', 'Male', 'stu080@example.com', '2026-02-22', 2, 6, 16, 1, 1),

-- Standard 6 (Campus 2), Section 17 (B)
(1, 'Uptown', 'Uptown Student 81', '81', 'STU081', '2010-06-01', 'Female', 'stu081@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 82', '82', 'STU082', '2010-06-02', 'Male', 'stu082@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 83', '83', 'STU083', '2010-06-03', 'Female', 'stu083@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 84', '84', 'STU084', '2010-06-04', 'Male', 'stu084@example.com', '2026-02-22', 2, 6, 17, 1, 1),
(1, 'Uptown', 'Uptown Student 85', '85', 'STU085', '2010-06-05', 'Female', 'stu085@example.com', '2026-02-22', 2, 6, 17, 1, 1),

-- Standard 6 (Campus 2), Section 18 (C)
(1, 'Uptown', 'Uptown Student 86', '86', 'STU086', '2010-07-01', 'Male', 'stu086@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 87', '87', 'STU087', '2010-07-02', 'Female', 'stu087@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 88', '88', 'STU088', '2010-07-03', 'Male', 'stu088@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 89', '89', 'STU089', '2010-07-04', 'Female', 'stu089@example.com', '2026-02-22', 2, 6, 18, 1, 1),
(1, 'Uptown', 'Uptown Student 90', '90', 'STU090', '2010-07-05', 'Male', 'stu090@example.com', '2026-02-22', 2, 6, 18, 1, 1),

-- Standard 7 (Campus 2), Section 19 (A)
(1, 'Student', 'Student 91', '91', 'STU091', '2009-05-01', 'Male', 'stu091@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 92', '92', 'STU092', '2009-05-02', 'Female', 'stu092@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 93', '93', 'STU093', '2009-05-03', 'Male', 'stu093@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 94', '94', 'STU094', '2009-05-04', 'Female', 'stu094@example.com', '2026-02-22', 2, 7, 19, 1, 1),
(1, 'Student', 'Student 95', '95', 'STU095', '2009-05-05', 'Male', 'stu095@example.com', '2026-02-22', 2, 7, 19, 1, 1),

-- Standard 7 (Campus 2), Section 20 (B)
(1, 'Student', 'Student 96', '96', 'STU096', '2009-06-01', 'Female', 'stu096@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 97', '97', 'STU097', '2009-06-02', 'Male', 'stu097@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 98', '98', 'STU098', '2009-06-03', 'Female', 'stu098@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 99', '99', 'STU099', '2009-06-04', 'Male', 'stu099@example.com', '2026-02-22', 2, 7, 20, 1, 1),
(1, 'Student', 'Student 100', '100', 'STU100', '2009-06-05', 'Female', 'stu100@example.com', '2026-02-22', 2, 7, 20, 1, 1),

-- Standard 7 (Campus 2), Section 21 (C)
(1, 'Student', 'Student 101', '101', 'STU101', '2009-07-01', 'Male', 'stu101@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 102', '102', 'STU102', '2009-07-02', 'Female', 'stu102@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 103', '103', 'STU103', '2009-07-03', 'Male', 'stu103@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 104', '104', 'STU104', '2009-07-04', 'Female', 'stu104@example.com', '2026-02-22', 2, 7, 21, 1, 1),
(1, 'Student', 'Student 105', '105', 'STU105', '2009-07-05', 'Male', 'stu105@example.com', '2026-02-22', 2, 7, 21, 1, 1),

-- Standard 8 (Campus 2), Section 22 (A)
(1, 'Student', 'Student 106', '106', 'STU106', '2008-05-01', 'Male', 'stu106@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 107', '107', 'STU107', '2008-05-02', 'Female', 'stu107@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 108', '108', 'STU108', '2008-05-03', 'Male', 'stu108@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 109', '109', 'STU109', '2008-05-04', 'Female', 'stu109@example.com', '2026-02-22', 2, 8, 22, 1, 1),
(1, 'Student', 'Student 110', '110', 'STU110', '2008-05-05', 'Male', 'stu110@example.com', '2026-02-22', 2, 8, 22, 1, 1),

-- Standard 8 (Campus 2), Section 23 (B)
(1, 'Student', 'Student 111', '111', 'STU111', '2008-06-01', 'Female', 'stu111@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 112', '112', 'STU112', '2008-06-02', 'Male', 'stu112@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 113', '113', 'STU113', '2008-06-03', 'Female', 'stu113@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 114', '114', 'STU114', '2008-06-04', 'Male', 'stu114@example.com', '2026-02-22', 2, 8, 23, 1, 1),
(1, 'Student', 'Student 115', '115', 'STU115', '2008-06-05', 'Female', 'stu115@example.com', '2026-02-22', 2, 8, 23, 1, 1),

-- Standard 8 (Campus 2), Section 24 (C)
(1, 'Student', 'Student 116', '116', 'STU116', '2008-07-01', 'Male', 'stu116@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 117', '117', 'STU117', '2008-07-02', 'Female', 'stu117@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 118', '118', 'STU118', '2008-07-03', 'Male', 'stu118@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 119', '119', 'STU119', '2008-07-04', 'Female', 'stu119@example.com', '2026-02-22', 2, 8, 24, 1, 1),
(1, 'Student', 'Student 120', '120', 'STU120', '2008-07-05', 'Male', 'stu120@example.com', '2026-02-22', 2, 8, 24, 1, 1),

-- Standard 9 (Campus 2), Section 25 (A)
(1, 'Student', 'Student 121', '121', 'STU121', '2007-05-01', 'Male', 'stu121@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 122', '122', 'STU122', '2007-05-02', 'Female', 'stu122@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 123', '123', 'STU123', '2007-05-03', 'Male', 'stu123@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 124', '124', 'STU124', '2007-05-04', 'Female', 'stu124@example.com', '2026-02-22', 2, 9, 25, 1, 1),
(1, 'Student', 'Student 125', '125', 'STU125', '2007-05-05', 'Male', 'stu125@example.com', '2026-02-22', 2, 9, 25, 1, 1),

-- Standard 9 (Campus 2), Section 26 (B)
(1, 'Student', 'Student 126', '126', 'STU126', '2007-06-01', 'Female', 'stu126@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 127', '127', 'STU127', '2007-06-02', 'Male', 'stu127@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 128', '128', 'STU128', '2007-06-03', 'Female', 'stu128@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 129', '129', 'STU129', '2007-06-04', 'Male', 'stu129@example.com', '2026-02-22', 2, 9, 26, 1, 1),
(1, 'Student', 'Student 130', '130', 'STU130', '2007-06-05', 'Female', 'stu130@example.com', '2026-02-22', 2, 9, 26, 1, 1),

-- Standard 9 (Campus 2), Section 27 (C)
(1, 'Student', 'Student 131', '131', 'STU131', '2007-07-01', 'Male', 'stu131@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 132', '132', 'STU132', '2007-07-02', 'Female', 'stu132@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 133', '133', 'STU133', '2007-07-03', 'Male', 'stu133@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 134', '134', 'STU134', '2007-07-04', 'Female', 'stu134@example.com', '2026-02-22', 2, 9, 27, 1, 1),
(1, 'Student', 'Student 135', '135', 'STU135', '2007-07-05', 'Male', 'stu135@example.com', '2026-02-22', 2, 9, 27, 1, 1),

-- Standard 10 (Campus 2), Section 28 (A)
(1, 'Student', 'Student 136', '136', 'STU136', '2006-05-01', 'Male', 'stu136@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 137', '137', 'STU137', '2006-05-02', 'Female', 'stu137@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 138', '138', 'STU138', '2006-05-03', 'Male', 'stu138@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 139', '139', 'STU139', '2006-05-04', 'Female', 'stu139@example.com', '2026-02-22', 2, 10, 28, 1, 1),
(1, 'Student', 'Student 140', '140', 'STU140', '2006-05-05', 'Male', 'stu140@example.com', '2026-02-22', 2, 10, 28, 1, 1),

-- Standard 10 (Campus 2), Section 29 (B)
(1, 'Student', 'Student 141', '141', 'STU141', '2006-06-01', 'Female', 'stu141@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 142', '142', 'STU142', '2006-06-02', 'Male', 'stu142@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 143', '143', 'STU143', '2006-06-03', 'Female', 'stu143@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 144', '144', 'STU144', '2006-06-04', 'Male', 'stu144@example.com', '2026-02-22', 2, 10, 29, 1, 1),
(1, 'Student', 'Student 145', '145', 'STU145', '2006-06-05', 'Female', 'stu145@example.com', '2026-02-22', 2, 10, 29, 1, 1),

-- Standard 10 (Campus 2), Section 30 (C)
(1, 'Student', 'Student 146', '146', 'STU146', '2006-07-01', 'Male', 'stu146@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 147', '147', 'STU147', '2006-07-02', 'Female', 'stu147@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 148', '148', 'STU148', '2006-07-03', 'Male', 'stu148@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 149', '149', 'STU149', '2006-07-04', 'Female', 'stu149@example.com', '2026-02-22', 2, 10, 30, 1, 1),
(1, 'Student', 'Student 150', '150', 'STU150', '2006-07-05', 'Male', 'stu150@example.com', '2026-02-22', 2, 10, 30, 1, 1);
