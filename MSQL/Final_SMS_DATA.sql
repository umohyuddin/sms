SET SQL_SAFE_UPDATES = 0;
INSERT INTO academic_years
(name, code, start_date, end_date, total_months, is_current, status, organization_id)
VALUES
('Academic Year 2025-2026', 'AY2025', '2025-04-01', '2026-03-31', 12, TRUE, 'ACTIVE', 1);




-- =========================
-- 1. Leadership
-- =========================
INSERT INTO designations (organization_id, designation_code, designation_name, description, active, deleted, created_at)
VALUES
(1, 'PRINCIPAL', 'Principal', 'Leads the campus and oversees academic and administrative operations', true, false, NOW()),
(1, 'VICE_PRINCIPAL', 'Vice Principal', 'Supports the principal in managing academic and discipline functions', true, false, NOW()),
(1, 'HEADMASTER', 'Headmaster / Headmistress', 'Senior school authority responsible for overall school management', true, false, NOW()),
(1, 'CAMPUS_DIRECTOR', 'Campus Director', 'Responsible for strategic and operational management of a campus', true, false, NOW()),
(1, 'ACADEMIC_DIRECTOR', 'Academic Director', 'Oversees curriculum, teaching quality, and academic planning', true, false, NOW()),
(1, 'OPERATIONS_MANAGER', 'Operations Manager', 'Manages day-to-day operational activities of the school', true, false, NOW()),
(1, 'ADMINISTRATOR', 'Administrator', 'Handles overall administrative control and coordination', true, false, NOW());

-- =========================
-- 2. Teaching Staff
-- =========================
INSERT INTO designations VALUES
(NULL,1,'TEACHER','Teacher','Delivers subject teaching and manages classroom activities',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'SENIOR_TEACHER','Senior Teacher','Experienced teacher with additional academic responsibilities',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'JUNIOR_TEACHER','Junior Teacher','Entry-level teacher supporting classroom instruction',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'SUBJECT_TEACHER','Subject Teacher','Specialized teacher for a specific subject area',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 3. Specialized Teaching
-- =========================
INSERT INTO designations VALUES
(NULL,1,'MONTESSORI_TEACHER','Montessori Teacher','Handles early childhood education using Montessori methods',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'KG_TEACHER','Kindergarten Teacher','Responsible for foundational early learning education',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ART_TEACHER','Art Teacher','Teaches drawing, painting, and creative arts',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'MUSIC_TEACHER','Music Teacher','Teaches music theory and performance skills',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'PE_TEACHER','Physical Education Teacher','Conducts sports and physical fitness training',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ISLAMIC_STUDIES_TEACHER','Islamic Studies Teacher','Teaches Quran and Islamic education',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'LAB_INSTRUCTOR','Lab Instructor','Supervises lab sessions and practical experiments',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 4. Academic Support
-- =========================
INSERT INTO designations VALUES
(NULL,1,'TEACHING_ASSISTANT','Teaching Assistant','Supports teachers in classroom activities',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'LAB_ASSISTANT','Lab Assistant','Assists in lab setup and maintenance',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'LIBRARIAN','Librarian','Manages library resources and student access',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ASSISTANT_LIBRARIAN','Assistant Librarian','Supports library operations',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ACADEMIC_COORDINATOR','Academic Coordinator','Coordinates academic schedules and planning',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'CURRICULUM_DEVELOPER','Curriculum Developer','Designs and improves educational curriculum',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 5. Admin Staff
-- =========================
INSERT INTO designations VALUES
(NULL,1,'OFFICE_MANAGER','Office Manager','Manages office operations and documentation',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ADMIN_OFFICER','Admin Officer','Handles administrative tasks and coordination',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'RECEPTIONIST','Receptionist','Manages front desk and visitor interactions',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'HR_OFFICER','HR Officer','Manages recruitment and HR operations',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'HR_MANAGER','HR Manager','Leads HR policies and employee lifecycle',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ACCOUNTS_OFFICER','Accounts Officer','Maintains financial records and transactions',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'FINANCE_MANAGER','Finance Manager','Handles budgeting and financial planning',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'DATA_ENTRY_OPERATOR','Data Entry Operator','Maintains system data and records',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'RECORD_KEEPER','Record Keeper','Maintains official documentation and archives',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 6. Support Staff
-- =========================
INSERT INTO designations VALUES
(NULL,1,'DRIVER','Driver','Provides transportation services',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'BUS_ATTENDANT','Bus Attendant','Ensures student safety during transport',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'SECURITY_GUARD','Security Guard','Ensures campus safety and security',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'WATCHMAN','Watchman','Monitors premises during off hours',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'CLEANER','Cleaner','Maintains cleanliness of facilities',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'MAINTENANCE_STAFF','Maintenance Staff','Handles general maintenance tasks',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'ELECTRICIAN','Electrician','Handles electrical systems and repairs',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'PLUMBER','Plumber','Handles plumbing maintenance',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'CANTEEN_MANAGER','Canteen Manager','Manages cafeteria operations',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'COOK','Cook','Prepares meals for students and staff',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'KITCHEN_STAFF','Kitchen Staff','Assists in kitchen operations',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 7. Exams
-- =========================
INSERT INTO designations VALUES
(NULL,1,'EXAM_CONTROLLER','Exam Controller','Manages exam planning and execution',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'EXAM_COORDINATOR','Exam Coordinator','Coordinates exam schedules',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'EVALUATOR','Evaluator','Checks and grades exam papers',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'INVIGILATOR','Invigilator','Supervises students during exams',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 8. Coordination Roles
-- =========================
INSERT INTO designations VALUES
(NULL,1,'DISCIPLINE_INCHARGE','Discipline Incharge','Ensures student discipline and behavior management',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'GRADE_COORDINATOR','Grade Coordinator','Coordinates activities of a specific grade',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'SECTION_HEAD','Section Head','Manages a section or group of classes',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'HOD','Head of Department','Leads a department academically and administratively',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'SUBJECT_COORDINATOR','Subject Coordinator','Coordinates subject curriculum and teachers',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);

-- =========================
-- 9. Organization Level
-- =========================
INSERT INTO designations VALUES
(NULL,1,'CEO','CEO / Founder','Top-level executive managing organization strategy',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'DIRECTOR_GENERAL','Director General','Oversees multiple campuses and operations',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'CAO','Chief Academic Officer','Leads academic strategy across organization',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'COO','Chief Operating Officer','Handles operations across campuses',true,false,NOW(),NULL,NULL,NULL,NULL,NULL),
(NULL,1,'REGIONAL_MANAGER','Regional Manager','Manages campuses within a region',true,false,NOW(),NULL,NULL,NULL,NULL,NULL);













INSERT INTO department_types 
(organization_id, code, name, description) VALUES

-- Core Academic
(1, 'ACADEMIC', 'Academic', 'Core teaching and subject-related departments'),

-- Administration
(1, 'ADMIN', 'Administration', 'Administrative and management departments'),

-- Student Support
(1, 'SUPPORT', 'Student Support', 'Departments supporting student services and wellbeing'),

-- Operations / Facilities
(1, 'OPERATIONS', 'Operations', 'Campus operations, facilities, and maintenance'),

-- IT / Technical
(1, 'IT', 'Information Technology', 'IT systems, infrastructure, and technical support'),

-- Finance
(1, 'FINANCE', 'Finance & Accounts', 'Financial operations, accounting, and budgeting'),

-- Human Resources
(1, 'HR', 'Human Resources', 'Employee management, hiring, and HR operations'),

-- Academic Support
(1, 'ACADEMIC_SUPPORT', 'Academic Support', 'Support for teaching, curriculum, and faculty'),

-- Research (important for universities)
(1, 'RESEARCH', 'Research & Development', 'Research activities, labs, and innovation'),

-- Admissions
(1, 'ADMISSIONS', 'Admissions', 'Student admissions and enrollment management'),

-- Examination
(1, 'EXAM', 'Examinations', 'Exams, results, and academic assessments'),

-- Compliance / Quality
(1, 'QUALITY', 'Quality Assurance', 'Accreditation, compliance, and quality control'),

-- Legal
(1, 'LEGAL', 'Legal Affairs', 'Legal operations and compliance'),

-- Marketing / PR
(1, 'MARKETING', 'Marketing & Communications', 'Marketing, branding, and public relations'),

-- Transport
(1, 'TRANSPORT', 'Transport', 'Transport and fleet management'),

-- Hostel / Accommodation
(1, 'HOSTEL', 'Hostel & Accommodation', 'Student housing and accommodation'),

-- Health / Medical
(1, 'MEDICAL', 'Health Services', 'Medical and healthcare services'),

-- Library
(1, 'LIBRARY', 'Library Services', 'Library and knowledge resources'),

-- Security
(1, 'SECURITY', 'Security', 'Campus safety and security management'),

-- Cafeteria
(1, 'FOOD', 'Cafeteria & Food Services', 'Food and cafeteria services');






INSERT INTO guardian_relations 
(organization_id, name, code, description, status, is_default)
VALUES

-- 🔹 Core Parents
(1, 'Father', 'FATHER', 'Male parent (biological or legal)', 'ACTIVE', TRUE),
(1, 'Mother', 'MOTHER', 'Female parent (biological or legal)', 'ACTIVE', FALSE),

-- 🔹 Primary Guardian
(1, 'Guardian', 'GUARDIAN', 'Primary responsible adult (non-parent)', 'ACTIVE', FALSE),

-- 🔹 Immediate Family
(1, 'Grandparent', 'GRANDPARENT', 'Grandfather or grandmother', 'ACTIVE', FALSE),
(1, 'Sibling', 'SIBLING', 'Brother or sister', 'ACTIVE', FALSE),

-- 🔹 Extended Family
(1, 'Uncle/Aunt', 'UNCLE_AUNT', 'Parent’s sibling', 'ACTIVE', FALSE),
(1, 'Relative', 'RELATIVE', 'Any other family member', 'ACTIVE', FALSE),

-- 🔹 Legal / Care Types
(1, 'Foster Parent', 'FOSTER_PARENT', 'Temporary guardian assigned legally', 'ACTIVE', FALSE),
(1, 'Adoptive Parent', 'ADOPTIVE_PARENT', 'Legally adopted parent', 'ACTIVE', FALSE),
(1, 'Legal Guardian', 'LEGAL_GUARDIAN', 'Court-appointed guardian', 'ACTIVE', FALSE),

-- 🔹 Care Providers
(1, 'Caretaker', 'CARETAKER', 'Responsible for daily care', 'ACTIVE', FALSE),
(1, 'Nanny', 'NANNY', 'Childcare provider', 'ACTIVE', FALSE),

-- 🔹 Institutional
(1, 'Hostel Authority', 'HOSTEL_AUTHORITY', 'Hostel or boarding authority', 'ACTIVE', FALSE),
(1, 'Organization', 'ORGANIZATION', 'Institution acting as guardian', 'ACTIVE', FALSE),

-- 🔹 Financial / Support
(1, 'Sponsor', 'SPONSOR', 'Financial supporter of student', 'ACTIVE', FALSE),

-- 🔹 Emergency / Misc
(1, 'Emergency Contact', 'EMERGENCY_CONTACT', 'Emergency-only contact person', 'ACTIVE', FALSE),

-- 🔹 Fallback
(1, 'Other', 'OTHER', 'Other relationship', 'ACTIVE', FALSE);



INSERT INTO currencies (iso_code, name, symbol, is_active, is_deleted, created_at, created_by) VALUES
('AFN', 'Afghan Afghani', '؋', TRUE, FALSE, NOW(), 1),
('ALL', 'Albanian Lek', 'L', TRUE, FALSE, NOW(), 1),
('DZD', 'Algerian Dinar', 'د.ج', TRUE, FALSE, NOW(), 1),
('EUR', 'Euro', '€', TRUE, FALSE, NOW(), 1),
('AOA', 'Angolan Kwanza', 'Kz', TRUE, FALSE, NOW(), 1),
('ARS', 'Argentine Peso', '$', TRUE, FALSE, NOW(), 1),
('AUD', 'Australian Dollar', '$', TRUE, FALSE, NOW(), 1),
('AZN', 'Azerbaijani Manat', '₼', TRUE, FALSE, NOW(), 1),
('BSD', 'Bahamian Dollar', '$', TRUE, FALSE, NOW(), 1),
('BHD', 'Bahraini Dinar', '.د.ب', TRUE, FALSE, NOW(), 1),
('BDT', 'Bangladeshi Taka', '৳', TRUE, FALSE, NOW(), 1),
('BBD', 'Barbados Dollar', '$', TRUE, FALSE, NOW(), 1),
('BYN', 'Belarusian Ruble', 'Br', TRUE, FALSE, NOW(), 1),
('BZD', 'Belize Dollar', '$', TRUE, FALSE, NOW(), 1),
('BTN', 'Bhutanese Ngultrum', 'Nu.', TRUE, FALSE, NOW(), 1),
('BOB', 'Bolivian Boliviano', 'Bs.', TRUE, FALSE, NOW(), 1),
('BAM', 'Bosnian Convertible Mark', 'KM', TRUE, FALSE, NOW(), 1),
('BWP', 'Botswana Pula', 'P', TRUE, FALSE, NOW(), 1),
('BRL', 'Brazilian Real', 'R$', TRUE, FALSE, NOW(), 1),
('CAD', 'Canadian Dollar', '$', TRUE, FALSE, NOW(), 1),
('CLP', 'Chilean Peso', '$', TRUE, FALSE, NOW(), 1),
('CNY', 'Chinese Yuan', '¥', TRUE, FALSE, NOW(), 1),
('COP', 'Colombian Peso', '$', TRUE, FALSE, NOW(), 1),
('CZK', 'Czech Koruna', 'Kč', TRUE, FALSE, NOW(), 1),
('DKK', 'Danish Krone', 'kr', TRUE, FALSE, NOW(), 1),
('DOP', 'Dominican Peso', '$', TRUE, FALSE, NOW(), 1),
('EGP', 'Egyptian Pound', 'E£', TRUE, FALSE, NOW(), 1),
('ETB', 'Ethiopian Birr', 'Br', TRUE, FALSE, NOW(), 1),
('INR', 'Indian Rupee', '₹', TRUE, FALSE, NOW(), 1),
('IDR', 'Indonesian Rupiah', 'Rp', TRUE, FALSE, NOW(), 1),
('ILS', 'Israeli New Shekel', '₪', TRUE, FALSE, NOW(), 1),
('JPY', 'Japanese Yen', '¥', TRUE, FALSE, NOW(), 1),
('KES', 'Kenyan Shilling', 'Sh', TRUE, FALSE, NOW(), 1),
('KWD', 'Kuwaiti Dinar', 'د.ك', TRUE, FALSE, NOW(), 1),
('MYR', 'Malaysian Ringgit', 'RM', TRUE, FALSE, NOW(), 1),
('MXN', 'Mexican Peso', '$', TRUE, FALSE, NOW(), 1),
('MAD', 'Moroccan Dirham', 'د.م.', TRUE, FALSE, NOW(), 1),
('NPR', 'Nepalese Rupee', '₨', TRUE, FALSE, NOW(), 1),
('NZD', 'New Zealand Dollar', '$', TRUE, FALSE, NOW(), 1),
('NGN', 'Nigerian Naira', '₦', TRUE, FALSE, NOW(), 1),
('NOK', 'Norwegian Krone', 'kr', TRUE, FALSE, NOW(), 1),
('PKR', 'Pakistani Rupee', '₨', TRUE, FALSE, NOW(), 1),
('PHP', 'Philippine Peso', '₱', TRUE, FALSE, NOW(), 1),
('QAR', 'Qatari Riyal', 'ر.ق', TRUE, FALSE, NOW(), 1),
('RUB', 'Russian Ruble', '₽', TRUE, FALSE, NOW(), 1),
('SAR', 'Saudi Riyal', 'ر.س', TRUE, FALSE, NOW(), 1),
('SGD', 'Singapore Dollar', '$', TRUE, FALSE, NOW(), 1),
('ZAR', 'South African Rand', 'R', TRUE, FALSE, NOW(), 1),
('KRW', 'South Korean Won', '₩', TRUE, FALSE, NOW(), 1),
('SEK', 'Swedish Krona', 'kr', TRUE, FALSE, NOW(), 1),
('CHF', 'Swiss Franc', 'CHF', TRUE, FALSE, NOW(), 1),
('THB', 'Thai Baht', '฿', TRUE, FALSE, NOW(), 1),
('TRY', 'Turkish Lira', '₺', TRUE, FALSE, NOW(), 1),
('AED', 'UAE Dirham', 'د.إ', TRUE, FALSE, NOW(), 1),
('USD', 'US Dollar', '$', TRUE, FALSE, NOW(), 1),
('VES', 'Venezuelan Bolívar', 'Bs.', TRUE, FALSE, NOW(), 1),
('XOF', 'West African CFA Franc', 'Fr', TRUE, FALSE, NOW(), 1),
('ZMW', 'Zambian Kwacha', 'K', TRUE, FALSE, NOW(), 1);


INSERT INTO facility_types (code, name, description, is_active, is_deleted, created_at, created_by) VALUES
('LAB', 'Laboratory', 'Science, computer, or language labs', TRUE, FALSE, NOW(), 1),
('LIBRARY', 'Library', 'Reading, reference, digital library', TRUE, FALSE, NOW(), 1),
('PLAYGROUND', 'Playground', 'Outdoor sports and recreation area', TRUE, FALSE, NOW(), 1),
('AUDITORIUM', 'Auditorium', 'Multipurpose hall for events and gatherings', TRUE, FALSE, NOW(), 1),
('CAFETERIA', 'Cafeteria', 'Dining area for students and staff', TRUE, FALSE, NOW(), 1),
('HOSTEL', 'Hostel', 'On-campus accommodation for students', TRUE, FALSE, NOW(), 1),
('MEDICAL_ROOM', 'Medical Room', 'First-aid and health services', TRUE, FALSE, NOW(), 1),
('STAFF_ROOM', 'Staff Room', 'Teachers\' lounge or office area', TRUE, FALSE, NOW(), 1),
('TRANSPORT', 'Transport Facility', 'School buses, vans, or transport services', TRUE, FALSE, NOW(), 1),
('PRAYER_HALL', 'Prayer Hall', 'For religious activities or meditation', TRUE, FALSE, NOW(), 1),
('SPORTS_GROUND', 'Sports Ground', 'Fields or courts for games like cricket, football, etc.', TRUE, FALSE, NOW(), 1),
('MUSIC_ROOM', 'Music Room', 'For music classes and practice', TRUE, FALSE, NOW(), 1),
('ART_ROOM', 'Art Room', 'For painting, crafts, and other creative activities', TRUE, FALSE, NOW(), 1),
('COMPUTER_ROOM', 'Computer Room', 'Dedicated computer lab for students', TRUE, FALSE, NOW(), 1),
('SCIENCE_ROOM', 'Science Lab', 'Physics, Chemistry, or Biology labs', TRUE, FALSE, NOW(), 1),
('LANGUAGE_LAB', 'Language Lab', 'For learning foreign languages', TRUE, FALSE, NOW(), 1),
('SWIMMING_POOL', 'Swimming Pool', 'Swimming facility', TRUE, FALSE, NOW(), 1),
('GYM', 'Gymnasium', 'Indoor fitness and exercise facility', TRUE, FALSE, NOW(), 1),
('PARKING', 'Parking Facility', 'Staff and visitor parking', TRUE, FALSE, NOW(), 1),
('MULTIPURPOSE_HALL', 'Multipurpose Hall', 'For indoor activities, events, or assemblies', TRUE, FALSE, NOW(), 1);

-- ============================================================
-- Lookup Data: Languages
-- ============================================================
INSERT INTO languages (iso_code, name, is_active, is_deleted, created_at, created_by) VALUES
('aa', 'Afar', TRUE, FALSE, NOW(), 1),
('ab', 'Abkhaz', TRUE, FALSE, NOW(), 1),
('af', 'Afrikaans', TRUE, FALSE, NOW(), 1),
('ak', 'Akan', TRUE, FALSE, NOW(), 1),
('am', 'Amharic', TRUE, FALSE, NOW(), 1),
('an', 'Aragonese', TRUE, FALSE, NOW(), 1),
('ar', 'Arabic', TRUE, FALSE, NOW(), 1),
('as', 'Assamese', TRUE, FALSE, NOW(), 1),
('av', 'Avaric', TRUE, FALSE, NOW(), 1),
('ay', 'Aymara', TRUE, FALSE, NOW(), 1),
('az', 'Azerbaijani', TRUE, FALSE, NOW(), 1),
('ba', 'Bashkir', TRUE, FALSE, NOW(), 1),
('be', 'Belarusian', TRUE, FALSE, NOW(), 1),
('bg', 'Bulgarian', TRUE, FALSE, NOW(), 1),
('bh', 'Bihari', TRUE, FALSE, NOW(), 1),
('bi', 'Bislama', TRUE, FALSE, NOW(), 1),
('bn', 'Bengali', TRUE, FALSE, NOW(), 1),
('bo', 'Tibetan', TRUE, FALSE, NOW(), 1),
('br', 'Breton', TRUE, FALSE, NOW(), 1),
('bs', 'Bosnian', TRUE, FALSE, NOW(), 1),
('ca', 'Catalan', TRUE, FALSE, NOW(), 1),
('ch', 'Chamorro', TRUE, FALSE, NOW(), 1),
('co', 'Corsican', TRUE, FALSE, NOW(), 1),
('cs', 'Czech', TRUE, FALSE, NOW(), 1),
('cy', 'Welsh', TRUE, FALSE, NOW(), 1),
('da', 'Danish', TRUE, FALSE, NOW(), 1),
('de', 'German', TRUE, FALSE, NOW(), 1),
('dv', 'Divehi', TRUE, FALSE, NOW(), 1),
('dz', 'Dzongkha', TRUE, FALSE, NOW(), 1),
('el', 'Greek', TRUE, FALSE, NOW(), 1),
('en', 'English', TRUE, FALSE, NOW(), 1),
('eo', 'Esperanto', TRUE, FALSE, NOW(), 1),
('es', 'Spanish', TRUE, FALSE, NOW(), 1),
('et', 'Estonian', TRUE, FALSE, NOW(), 1),
('eu', 'Basque', TRUE, FALSE, NOW(), 1),
('fa', 'Persian', TRUE, FALSE, NOW(), 1),
('ff', 'Fulah', TRUE, FALSE, NOW(), 1),
('fi', 'Finnish', TRUE, FALSE, NOW(), 1),
('fj', 'Fijian', TRUE, FALSE, NOW(), 1),
('fo', 'Faroese', TRUE, FALSE, NOW(), 1),
('fr', 'French', TRUE, FALSE, NOW(), 1),
('fy', 'Western Frisian', TRUE, FALSE, NOW(), 1),
('ga', 'Irish', TRUE, FALSE, NOW(), 1),
('gd', 'Scottish Gaelic', TRUE, FALSE, NOW(), 1),
('gl', 'Galician', TRUE, FALSE, NOW(), 1),
('gn', 'Guarani', TRUE, FALSE, NOW(), 1),
('gu', 'Gujarati', TRUE, FALSE, NOW(), 1),
('gv', 'Manx', TRUE, FALSE, NOW(), 1),
('ha', 'Hausa', TRUE, FALSE, NOW(), 1),
('he', 'Hebrew', TRUE, FALSE, NOW(), 1),
('hi', 'Hindi', TRUE, FALSE, NOW(), 1),
('ho', 'Hiri Motu', TRUE, FALSE, NOW(), 1),
('hr', 'Croatian', TRUE, FALSE, NOW(), 1),
('ht', 'Haitian Creole', TRUE, FALSE, NOW(), 1),
('hu', 'Hungarian', TRUE, FALSE, NOW(), 1),
('hy', 'Armenian', TRUE, FALSE, NOW(), 1),
('ia', 'Interlingua', TRUE, FALSE, NOW(), 1),
('id', 'Indonesian', TRUE, FALSE, NOW(), 1),
('ie', 'Interlingue', TRUE, FALSE, NOW(), 1),
('ig', 'Igbo', TRUE, FALSE, NOW(), 1),
('ii', 'Nuosu', TRUE, FALSE, NOW(), 1),
('ik', 'Inupiaq', TRUE, FALSE, NOW(), 1),
('io', 'Ido', TRUE, FALSE, NOW(), 1),
('is', 'Icelandic', TRUE, FALSE, NOW(), 1),
('it', 'Italian', TRUE, FALSE, NOW(), 1),
('iu', 'Inuktitut', TRUE, FALSE, NOW(), 1),
('ja', 'Japanese', TRUE, FALSE, NOW(), 1),
('jv', 'Javanese', TRUE, FALSE, NOW(), 1),
('ka', 'Georgian', TRUE, FALSE, NOW(), 1),
('kg', 'Kongo', TRUE, FALSE, NOW(), 1),
('ki', 'Kikuyu', TRUE, FALSE, NOW(), 1),
('kk', 'Kazakh', TRUE, FALSE, NOW(), 1),
('kl', 'Greenlandic', TRUE, FALSE, NOW(), 1),
('km', 'Central Khmer', TRUE, FALSE, NOW(), 1),
('kn', 'Kannada', TRUE, FALSE, NOW(), 1),
('ko', 'Korean', TRUE, FALSE, NOW(), 1),
('kr', 'Kanuri', TRUE, FALSE, NOW(), 1),
('ks', 'Kashmiri', TRUE, FALSE, NOW(), 1),
('ku', 'Kurdish', TRUE, FALSE, NOW(), 1),
('kv', 'Komi', TRUE, FALSE, NOW(), 1),
('kw', 'Cornish', TRUE, FALSE, NOW(), 1),
('ky', 'Kyrgyz', TRUE, FALSE, NOW(), 1),
('la', 'Latin', TRUE, FALSE, NOW(), 1),
('lb', 'Luxembourgish', TRUE, FALSE, NOW(), 1),
('ln', 'Lingala', TRUE, FALSE, NOW(), 1),
('lo', 'Lao', TRUE, FALSE, NOW(), 1),
('lt', 'Lithuanian', TRUE, FALSE, NOW(), 1),
('lv', 'Latvian', TRUE, FALSE, NOW(), 1),
('mg', 'Malagasy', TRUE, FALSE, NOW(), 1),
('mh', 'Marshallese', TRUE, FALSE, NOW(), 1),
('mi', 'Māori', TRUE, FALSE, NOW(), 1),
('mk', 'Macedonian', TRUE, FALSE, NOW(), 1),
('ml', 'Malayalam', TRUE, FALSE, NOW(), 1),
('mn', 'Mongolian', TRUE, FALSE, NOW(), 1),
('mr', 'Marathi', TRUE, FALSE, NOW(), 1),
('ms', 'Malay', TRUE, FALSE, NOW(), 1),
('mt', 'Maltese', TRUE, FALSE, NOW(), 1),
('my', 'Burmese', TRUE, FALSE, NOW(), 1),
('na', 'Nauru', TRUE, FALSE, NOW(), 1),
('nb', 'Norwegian Bokmål', TRUE, FALSE, NOW(), 1),
('nd', 'North Ndebele', TRUE, FALSE, NOW(), 1),
('ne', 'Nepali', TRUE, FALSE, NOW(), 1),
('ng', 'Ndonga', TRUE, FALSE, NOW(), 1),
('nl', 'Dutch', TRUE, FALSE, NOW(), 1),
('nn', 'Norwegian Nynorsk', TRUE, FALSE, NOW(), 1),
('no', 'Norwegian', TRUE, FALSE, NOW(), 1),
('nr', 'South Ndebele', TRUE, FALSE, NOW(), 1),
('nv', 'Navajo', TRUE, FALSE, NOW(), 1),
('ny', 'Chichewa', TRUE, FALSE, NOW(), 1),
('oc', 'Occitan', TRUE, FALSE, NOW(), 1),
('oj', 'Ojibwa', TRUE, FALSE, NOW(), 1),
('om', 'Oromo', TRUE, FALSE, NOW(), 1),
('or', 'Oriya', TRUE, FALSE, NOW(), 1),
('os', 'Ossetian', TRUE, FALSE, NOW(), 1),
('pa', 'Punjabi', TRUE, FALSE, NOW(), 1),
('pi', 'Pāli', TRUE, FALSE, NOW(), 1),
('pl', 'Polish', TRUE, FALSE, NOW(), 1),
('ps', 'Pashto', TRUE, FALSE, NOW(), 1),
('pt', 'Portuguese', TRUE, FALSE, NOW(), 1),
('qu', 'Quechua', TRUE, FALSE, NOW(), 1),
('rm', 'Romansh', TRUE, FALSE, NOW(), 1),
('rn', 'Kirundi', TRUE, FALSE, NOW(), 1),
('ro', 'Romanian', TRUE, FALSE, NOW(), 1),
('ru', 'Russian', TRUE, FALSE, NOW(), 1),
('rw', 'Kinyarwanda', TRUE, FALSE, NOW(), 1),
('sa', 'Sanskrit', TRUE, FALSE, NOW(), 1),
('sc', 'Sardinian', TRUE, FALSE, NOW(), 1),
('sd', 'Sindhi', TRUE, FALSE, NOW(), 1),
('se', 'Northern Sami', TRUE, FALSE, NOW(), 1),
('sg', 'Sango', TRUE, FALSE, NOW(), 1),
('si', 'Sinhala', TRUE, FALSE, NOW(), 1),
('sk', 'Slovak', TRUE, FALSE, NOW(), 1),
('sl', 'Slovenian', TRUE, FALSE, NOW(), 1),
('sm', 'Samoan', TRUE, FALSE, NOW(), 1),
('sn', 'Shona', TRUE, FALSE, NOW(), 1),
('so', 'Somali', TRUE, FALSE, NOW(), 1),
('sq', 'Albanian', TRUE, FALSE, NOW(), 1),
('sr', 'Serbian', TRUE, FALSE, NOW(), 1),
('ss', 'Swati', TRUE, FALSE, NOW(), 1),
('st', 'Southern Sotho', TRUE, FALSE, NOW(), 1),
('su', 'Sundanese', TRUE, FALSE, NOW(), 1),
('sv', 'Swedish', TRUE, FALSE, NOW(), 1),
('sw', 'Swahili', TRUE, FALSE, NOW(), 1),
('ta', 'Tamil', TRUE, FALSE, NOW(), 1),
('te', 'Telugu', TRUE, FALSE, NOW(), 1),
('tg', 'Tajik', TRUE, FALSE, NOW(), 1),
('th', 'Thai', TRUE, FALSE, NOW(), 1),
('ti', 'Tigrinya', TRUE, FALSE, NOW(), 1),
('tk', 'Turkmen', TRUE, FALSE, NOW(), 1),
('tl', 'Tagalog', TRUE, FALSE, NOW(), 1),
('tn', 'Tswana', TRUE, FALSE, NOW(), 1),
('to', 'Tongan', TRUE, FALSE, NOW(), 1),
('tr', 'Turkish', TRUE, FALSE, NOW(), 1),
('ts', 'Tsonga', TRUE, FALSE, NOW(), 1),
('tt', 'Tatar', TRUE, FALSE, NOW(), 1),
('tw', 'Twi', TRUE, FALSE, NOW(), 1),
('ty', 'Tahitian', TRUE, FALSE, NOW(), 1),
('ug', 'Uighur', TRUE, FALSE, NOW(), 1),
('uk', 'Ukrainian', TRUE, FALSE, NOW(), 1),
('ur', 'Urdu', TRUE, FALSE, NOW(), 1),
('uz', 'Uzbek', TRUE, FALSE, NOW(), 1),
('ve', 'Venda', TRUE, FALSE, NOW(), 1),
('vi', 'Vietnamese', TRUE, FALSE, NOW(), 1),
('vo', 'Volapük', TRUE, FALSE, NOW(), 1),
('wa', 'Walloon', TRUE, FALSE, NOW(), 1),
('wo', 'Wolof', TRUE, FALSE, NOW(), 1),
('xh', 'Xhosa', TRUE, FALSE, NOW(), 1),
('yi', 'Yiddish', TRUE, FALSE, NOW(), 1),
('yo', 'Yoruba', TRUE, FALSE, NOW(), 1),
('za', 'Zhuang', TRUE, FALSE, NOW(), 1),
('zh', 'Chinese', TRUE, FALSE, NOW(), 1),
('zu', 'Zulu', TRUE, FALSE, NOW(), 1);


INSERT INTO actions(code, name, description, is_active, created_by, deleted)
VALUES
-- Core CRUD
('VIEW', 'View', 'Read access to the resource', TRUE, 1, FALSE),
('CREATE', 'Create', 'Ability to create new records', TRUE, 1, FALSE),
('UPDATE', 'Update', 'Ability to modify existing records', TRUE, 1, FALSE),
('DELETE', 'Delete', 'Ability to remove records', TRUE, 1, FALSE),

-- Workflow & Utility
('APPROVE', 'Approve', 'Ability to approve workflows', TRUE, 1, FALSE),
('EXPORT', 'Export', 'Ability to export data to Excel or PDF', TRUE, 1, FALSE),
('IMPORT', 'Import', 'Ability to import data from files', TRUE, 1, FALSE),

-- Management
('ASSIGN', 'Assign', 'Assign roles or resources', TRUE, 1, FALSE),
('UNASSIGN', 'Unassign', 'Remove assigned roles or resources', TRUE, 1, FALSE),

-- System Control
('ACTIVATE', 'Activate', 'Activate a disabled record', TRUE, 1, FALSE),
('DEACTIVATE', 'Deactivate', 'Deactivate an active record', TRUE, 1, FALSE);


-- ==========================================
-- MODULES
-- ==========================================
INSERT INTO modules(code,name,description,icon,route,display_order,system_module,active,created_at,created_by)
VALUES
-- Identity & Access Management
('DASHBOARD', 'Dashboard', 'System overview and analytics', 'dashboard', '/dashboard', 1, TRUE, TRUE, NOW(), 1),
('IAM', 'Identity & Access', 'Users, roles, permissions & security', 'security', '/iam', 2, TRUE, TRUE, NOW(), 1),

-- Student Management
('STUDENT', 'Student Management', 'Student profiles, admission & attendance', 'groups', '/students', 3, FALSE, TRUE, NOW(), 1),

-- Student Fees & Payments
('FEE', 'Fee Management', 'Fee structure, payments & summaries', 'payments', '/fees', 4, FALSE, TRUE, NOW(), 1),

-- Academic Structure
('ACADEMIC', 'Academic Management', 'Classes, sections, subjects & curriculum', 'school', '/academics', 5, FALSE, TRUE, NOW(), 1),

-- Assessment & Examination
('EXAM', 'Examinations', 'Assessments, grading & results', 'assignment', '/exams', 6, FALSE, TRUE, NOW(), 1),

-- Institute Management
('INSTITUTE', 'Institute Management', 'Institute profile, campuses & offerings', 'apartment', '/institute', 7, TRUE, TRUE, NOW(), 1),

-- Administration & Governance
('ADMINISTRATION', 'Administration & Governance', 'Departments, designations & boards', 'account_balance', '/administration', 8, TRUE, TRUE, NOW(), 1),

-- Employee & Payroll
('EMPLOYEE', 'Employee Management', 'Employees, salaries & payroll periods', 'badge', '/employees', 9, FALSE, TRUE, NOW(), 1),

-- Finance & Operations
('FINANCE', 'Finance & Operations', 'Expenses, banks & inventory', 'account_balance_wallet', '/finance', 10, FALSE, TRUE, NOW(), 1),

-- Discounts & Tax
('PRICING', 'Discounts & Tax', 'Discounts, tax rules & pricing models', 'percent', '/pricing', 11, TRUE, TRUE, NOW(), 1),

-- Reference / Master Data
('MASTERDATA', 'Master Data', 'Countries, currencies, boards & lookups', 'storage', '/master-data', 12, TRUE, TRUE, NOW(), 1),

-- System Configuration
('SETTINGS', 'System Settings', 'Rules, themes & configuration', 'settings', '/settings', 13, TRUE, TRUE, NOW(), 1),

-- Reporting & Analytics
('REPORTS', 'Reports & Analytics', 'Academic, financial & system reports', 'bar_chart', '/reports', 14, TRUE, TRUE, NOW(), 1),

-- Future Modules
('COMMUNICATION', 'Communication', 'SMS, Email, Notifications & Announcements', 'campaign', '/communication', 15, TRUE, TRUE, NOW(), 1),
('TRANSPORT', 'Transport Management', 'Routes, vehicles & student transport', 'directions_bus', '/transport', 16, FALSE, TRUE, NOW(), 1),
('HOSTEL', 'Hostel Management', 'Rooms, allocations & hostel fees', 'home', '/hostel', 17, FALSE, TRUE, NOW(), 1),
('LIBRARY', 'Library Management', 'Books, members & issue tracking', 'library_books', '/library', 18, FALSE, TRUE, NOW(), 1),
('ALUMNI', 'Alumni Management', 'Alumni records & engagement', 'diversity_3', '/alumni', 19, FALSE, TRUE, NOW(), 1);

-- ==========================================
-- RESOURCES
-- ==========================================

-- IAM / Security
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='IAM'), 'IAM_AUTH_LOGIN', 'Login', '/sms/auth', 'POST', 'User login'),

-- Users
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_SEARCH', 'Search Users', '/api/v1/users/search', 'GET', 'Search system users'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_USER_ASSIGN_ROLE', 'Assign Roles', '/api/v1/users/{userId}/roles', 'PUT', 'Assign roles to user'),

-- Roles
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_CREATE', 'Create Role', '/api/v1/roles', 'POST', 'Create role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_VIEW', 'View Roles', '/api/v1/roles/organization/{organizationId}', 'GET', 'List roles'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_UPDATE', 'Update Role', '/api/v1/roles/{id}/organization/{organizationId}', 'PUT', 'Update role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_DELETE', 'Delete Role', '/api/v1/roles/{id}/organization/{organizationId}', 'DELETE', 'Delete role'),

-- Permissions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_CREATE', 'Create Permission', '/api/v1/permissions', 'POST', 'Create permission'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_VIEW', 'View Permissions', '/api/v1/permissions/organization/{organizationId}', 'GET', 'List permissions'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_UPDATE', 'Update Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'PUT', 'Update permission'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_PERMISSION_DELETE', 'Delete Permission', '/api/v1/permissions/{id}/organization/{organizationId}', 'DELETE', 'Delete permission'),

-- Role Permission
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_ASSIGN', 'Assign Permission', '/api/role-permissions/assign', 'POST', 'Assign permission to role'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_VIEW', 'View Role Permissions', '/api/role-permissions/role/{roleId}', 'GET', 'View role permissions'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ROLE_PERMISSION_REMOVE', 'Remove Permission', '/api/role-permissions/role/{roleId}/permission/{permissionId}', 'DELETE', 'Remove permission'),

-- Modules / Resources / Actions
((SELECT id FROM modules WHERE code='IAM'), 'IAM_MODULE_MANAGE', 'Manage Modules', '/api/v1/modules', 'POST', 'Create module'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_RESOURCE_MANAGE', 'Manage Resources', '/api/v1/resources', 'POST', 'Create resource'),
((SELECT id FROM modules WHERE code='IAM'), 'IAM_ACTION_MANAGE', 'Manage Actions', '/api/v1/actions', 'POST', 'Create action');

-- STUDENT Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_CREATE', 'Create Student', '/api/institute/students', 'POST', 'Create student'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW', 'View Students', '/api/institute/students', 'GET', 'List students'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_VIEW_DETAIL', 'View Student Detail', '/api/institute/students/{id}', 'GET', 'Student details'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_UPDATE', 'Update Student', '/api/institute/students/{id}', 'PUT', 'Update student'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_SEARCH', 'Search Students', '/api/institute/students/search', 'GET', 'Search students'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DASHBOARD_VIEW', 'Student Dashboard', '/api/institute/students/dashboard', 'GET', 'Student dashboard'),

-- Student Documents
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_UPLOAD', 'Upload Document', '/api/institute/students/upload-document', 'POST', 'Upload document'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_VIEW', 'View Documents', '/api/institute/students/{studentId}/documents', 'GET', 'View documents'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_DOCUMENT_DOWNLOAD', 'Download Document', '/api/institute/students/download-document/{documentId}', 'GET', 'Download document'),

-- Attendance
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_MARK', 'Mark Attendance', '/api/student/attendance/create', 'POST', 'Mark attendance'),
((SELECT id FROM modules WHERE code='STUDENT'), 'STUDENT_ATTENDANCE_VIEW', 'View Attendance', '/api/student/attendance/getbystudent/{id}', 'GET', 'View attendance');

-- FEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='FEE'), 'FEE_ASSIGN', 'Assign Fee', '/api/students/{studentId}/fees/assign', 'POST', 'Assign fee'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_UPDATE', 'Update Fee', '/api/students/{studentId}/fees/update', 'PUT', 'Update assigned fee'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_PAYMENT_CREATE', 'Pay Fee', '/api/students/fee/payments', 'POST', 'Fee payment'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_SUMMARY_VIEW', 'Fee Summary', '/api/students/fee/summary', 'GET', 'Fee summary'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ASSIGN', 'Assign Discount', '/api/school/discounts/student', 'POST', 'Assign student discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_UPDATE', 'Update Discount', '/api/school/discounts/student/{assignmentId}', 'PUT', 'Update discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_ACTIVATE', 'Activate Discount', '/api/school/discounts/student/{assignmentId}/activate', 'PATCH', 'Activate discount'),
((SELECT id FROM modules WHERE code='FEE'), 'FEE_DISCOUNT_DEACTIVATE', 'Deactivate Discount', '/api/school/discounts/student/{assignmentId}/deactivate', 'PATCH', 'Deactivate discount');

-- ACADEMIC Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_CLASS_MANAGE', 'Manage Classes', '/api/classes', 'POST', 'Manage classes'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_STANDARD_MANAGE', 'Manage Standards', '/api/standards', 'POST', 'Manage standards'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SECTION_MANAGE', 'Manage Sections', '/api/sections', 'POST', 'Manage sections'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_ASSIGN', 'Assign Subject', '/api/standard-subjects', 'POST', 'Assign subject'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_TIMETABLE_MANAGE', 'Manage Timetable', '/api/timetable', 'POST', 'Manage timetable'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_YEAR_MANAGE', 'Academic Year', '/api/academic-years', 'POST', 'Manage academic years'),
((SELECT id FROM modules WHERE code='ACADEMIC'), 'ACADEMIC_SUBJECT_MANAGE', 'Academic Subjects', '/api/academic-subjects', 'POST', 'Manage subjects');

-- EXAM Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_ASSESSMENT_CREATE', 'Create Assessment', '/api/assessments', 'POST', 'Create assessment'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_MCQ_MANAGE', 'Manage MCQs', '/api/mcqs', 'POST', 'Manage MCQs'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_PUBLISH', 'Publish Result', '/api/results', 'POST', 'Publish result'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_RESULT_VIEW', 'View Results', '/api/results', 'GET', 'View results'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_GRADING_MANAGE', 'Grading System', '/api/marks-grading', 'POST', 'Manage grading system'),
((SELECT id FROM modules WHERE code='EXAM'), 'EXAM_FAIL_CRITERIA_MANAGE', 'Fail Criteria', '/api/fail-criteria', 'POST', 'Manage fail criteria');

-- INSTITUTE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_PROFILE_UPDATE', 'Update Institute', '/api/institute', 'PUT', 'Update institute'),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_UPLOAD', 'Upload Institute Document', '/api/institute/documents', 'POST', 'Upload institute document'),
((SELECT id FROM modules WHERE code='INSTITUTE'), 'INSTITUTE_DOCUMENT_DOWNLOAD', 'Download Institute Document', '/api/institute/documents/{documentId}', 'GET', 'Download institute document');

-- ADMINISTRATION Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='ADMINISTRATION'), 'ADMIN_CONTACT_MANAGE', 'Institute Contacts', '/api/institute/contacts', 'POST', 'Manage institute contacts');

-- EMPLOYEE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_CREATE', 'Create Employee', '/api/employees', 'POST', 'Create employee'),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_SALARY_PAY', 'Salary Payment', '/api/salaries/pay', 'POST', 'Pay employee salary'),
((SELECT id FROM modules WHERE code='EMPLOYEE'), 'EMPLOYEE_HISTORY_VIEW', 'Employee History', '/api/employees/history', 'GET', 'View employee history');

-- FINANCE Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='FINANCE'), 'FINANCE_EXPENSE_CREATE', 'Create Expense', '/api/schools/expenses', 'POST', 'Create expense');

-- MASTERDATA Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='MASTERDATA'), 'MASTERDATA_COUNTRY_VIEW', 'View Countries', '/api/countries', 'GET', 'List countries');

-- REPORTS Module
INSERT INTO resources(module_id, resource_code, resource_name, resource_endpoint, methodType, description)
VALUES
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ATTENDANCE', 'Attendance Report', '/api/attendance/report', 'GET', 'Attendance reports'),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_FEE', 'Fee Report', '/api/students/fee/report', 'GET', 'Fee reports'),
((SELECT id FROM modules WHERE code='REPORTS'), 'REPORT_ACADEMIC', 'Academic Report', '/api/academics/report', 'GET', 'Academic reports');





INSERT INTO school_types (code, name, description, is_active, is_deleted) VALUES
('PUBLIC', 'Public School', 'Funded and operated by the government, free for students.', TRUE, FALSE),
('PRIVATE', 'Private School', 'Privately funded school, requires tuition fees.', TRUE, FALSE),
('CHARTER', 'Charter School', 'Publicly funded independent school with special curriculum.', TRUE, FALSE),
('TRUST', 'Trust School', 'Managed by charitable trusts or foundations.', TRUE, FALSE),
('INTERNATIONAL', 'International School', 'Follows international curriculum like IB or Cambridge.', TRUE, FALSE),
('GOVERNMENT', 'Government School', 'Directly run by local or federal government authorities.', TRUE, FALSE),
('MONTESSORI', 'Montessori School', 'Focuses on child-led learning and early education.', TRUE, FALSE),
('VOCATIONAL', 'Vocational School', 'Specializes in skill-based education for trades and professions.', TRUE, FALSE);




INSERT INTO roles(organization_id,code,name,description,is_system_role,active,deleted,created_by,created_at)
VALUES
(1, 'MASTER_ADMIN', 'Master Administrator', 'Alias of SUPER_ADMIN', TRUE, TRUE, FALSE, 1, NOW()),
(1, 'SUPER_ADMIN', 'Super Administrator', 'Full system access across all modules and organizations',TRUE, TRUE, FALSE, 1, NOW()),
(1, 'ORG_ADMIN', 'Organization Administrator', 'Manages institute-level configuration, campuses, and users',TRUE, TRUE, FALSE, 1, NOW()),
-- ===============================
-- ACADEMIC LEADERSHIP
-- ===============================
(1, 'PRINCIPAL', 'Principal', 'Overall academic and administrative head of the school',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'VICE_PRINCIPAL', 'Vice Principal', 'Assists principal in academic and disciplinary matters',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'HEAD_OF_DEPARTMENT', 'Head of Department', 'Manages academic department and teaching staff', FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- TEACHING STAFF
-- ===============================
(1, 'TEACHER', 'Teacher', 'Teaches assigned classes and manages student academics',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'CLASS_TEACHER', 'Class Teacher', 'Responsible for a specific class and student coordination',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'SUBSTITUTE_TEACHER', 'Substitute Teacher', 'Temporary teacher assigned to cover classes',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- STUDENT & PARENT PORTALS
-- ===============================
(1, 'STUDENT', 'Student', 'Student portal access for academics, attendance, and fees',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'PARENT', 'Parent / Guardian', 'Parent portal access to monitor student progress and fees',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- ADMISSIONS & EXAMINATION
-- ===============================
(1, 'ADMISSIONS_OFFICER', 'Admissions Officer', 'Handles student admissions and enrollment process',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'EXAM_CONTROLLER', 'Examination Controller', 'Manages exams, grading, and result publication',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'EXAMINER', 'Examiner', 'Creates exams and evaluates student performance',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- FINANCE & ACCOUNTS
-- ===============================
(1, 'ACCOUNTANT', 'Accountant', 'Manages fee collection, payments, and accounting reports',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'FINANCE_MANAGER', 'Finance Manager', 'Oversees financial operations and approvals',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'FEE_COLLECTION_OFFICER', 'Fee Collection Officer', 'Handles daily fee collection and receipts',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- HR & PAYROLL
-- ===============================
(1, 'HR_MANAGER', 'HR Manager', 'Manages employees, payroll, and HR policies',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'HR_OFFICER', 'HR Officer', 'Handles employee records, attendance, and documentation',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'PAYROLL_OFFICER', 'Payroll Officer', 'Processes salaries and payroll cycles',FALSE, TRUE, FALSE, 1, NOW()),

-- ===============================
-- IT & SUPPORT
-- ===============================
(1, 'IT_ADMIN', 'IT Administrator', 'Manages system configuration, users, and technical support',FALSE, TRUE, FALSE, 1, NOW()),
(1, 'SUPPORT_STAFF', 'Support Staff', 'Limited access for operational and support activities',FALSE, TRUE, FALSE, 1, NOW());





-- ====================================================
-- Tax Types for all countries (testing data)
-- ====================================================
INSERT INTO tax_types (code, name, tax_percentage, country_id)
VALUES
( 'GST_AF', 'Goods and Services Tax', 0.00, 1),
( 'VAT_AL', 'Value Added Tax', 20.00, 2),
( 'VAT_DZ', 'Value Added Tax', 19.00, 3),
( 'VAT_AD', 'Value Added Tax', 4.50, 4),
( 'VAT_AO', 'Value Added Tax', 14.00, 5),
( 'VAT_AR', 'Value Added Tax', 21.00, 6),
( 'GST_AM', 'Goods and Services Tax', 0.00, 7),
( 'GST_AU', 'Goods and Services Tax', 10.00, 8),
( 'VAT_AT', 'Value Added Tax', 20.00, 9),
( 'VAT_AZ1', 'Value Added Tax', 18.00, 10),
( 'VAT_BH', 'Value Added Tax', 5.00, 11),
( 'VAT_BD', 'Value Added Tax', 15.00, 12),
( 'VAT_BY1', 'Value Added Tax', 20.00, 13),
( 'VAT_BE', 'Value Added Tax', 21.00, 14),
( 'VAT_BZ', 'Value Added Tax', 12.50, 15),
( 'VAT_BJ', 'Value Added Tax', 18.00, 16),
( 'GST_BT', 'Goods and Services Tax', 0.00, 17),
( 'VAT_BO', 'Value Added Tax', 13.00, 18),
( 'VAT_BA', 'Value Added Tax', 17.00, 19),
( 'VAT_BW', 'Value Added Tax', 12.00, 20),
( 'VAT_BR', 'Value Added Tax', 17.00, 21),
( 'VAT_BN', 'Value Added Tax', 5.00, 22),
( 'VAT_BG', 'Value Added Tax', 20.00, 23),
( 'VAT_BF', 'Value Added Tax', 18.00, 24),
( 'VAT_BI', 'Value Added Tax', 0.00, 25),
( 'VAT_KH', 'Value Added Tax', 10.00, 26),
( 'VAT_CM', 'Value Added Tax', 19.25, 27),
( 'GST_CA', 'Goods and Services Tax', 5.00, 28),
( 'VAT_CV', 'Value Added Tax', 15.00, 29),
( 'VAT_CF', 'Value Added Tax', 19.00, 30),
( 'VAT_TD', 'Value Added Tax', 18.00, 31),
( 'VAT_CL', 'Value Added Tax', 19.00, 32),
( 'VAT_CN', 'Value Added Tax', 13.00, 33),
( 'VAT_CO', 'Value Added Tax', 19.00, 34),
( 'VAT_KM', 'Value Added Tax', 10.00, 35),
( 'VAT_CG', 'Value Added Tax', 18.00, 36),
( 'VAT_CR', 'Value Added Tax', 13.00, 37),
( 'VAT_HR', 'Value Added Tax', 25.00, 38),
( 'VAT_CU', 'Value Added Tax', 0.00, 39),
( 'VAT_CY', 'Value Added Tax', 19.00, 40),
( 'VAT_CZ', 'Value Added Tax', 21.00, 41),
( 'VAT_DK', 'Value Added Tax', 25.00, 42),
( 'VAT_DJ', 'Value Added Tax', 10.00, 43),
( 'VAT_DO', 'Value Added Tax', 18.00, 44),
( 'VAT_EC', 'Value Added Tax', 12.00, 45),
( 'VAT_EG', 'Value Added Tax', 14.00, 46),
( 'VAT_SV', 'Value Added Tax', 13.00, 47),
( 'VAT_EE', 'Value Added Tax', 20.00, 48),
( 'VAT_ET', 'Value Added Tax', 15.00, 49),
( 'VAT_FI', 'Value Added Tax', 24.00, 50),
( 'VAT_FR', 'Value Added Tax', 20.00, 51),
( 'VAT_GA', 'Value Added Tax', 18.00, 52),
( 'VAT_GE', 'Value Added Tax', 18.00, 53),
( 'VAT_DE', 'Value Added Tax', 19.00, 54),
( 'VAT_GH', 'Value Added Tax', 12.50, 55),
( 'VAT_GR', 'Value Added Tax', 24.00, 56),
( 'VAT_GT', 'Value Added Tax', 12.00, 57),
( 'VAT_GN', 'Value Added Tax', 18.00, 58),
( 'VAT_HT', 'Value Added Tax', 10.00, 59),
( 'VAT_HN', 'Value Added Tax', 15.00, 60),
( 'GST_HK', 'Goods and Services Tax', 0.00, 61),
( 'VAT_HU', 'Value Added Tax', 27.00, 62),
( 'VAT_IS', 'Value Added Tax', 24.00, 63),
( 'GST_IN', 'Goods and Services Tax', 18.00, 64),
( 'VAT_ID', 'Value Added Tax', 11.00, 65),
( 'VAT_IR', 'Value Added Tax', 9.00, 66),
( 'VAT_IQ', 'Value Added Tax', 5.00, 67),
( 'VAT_IE', 'Value Added Tax', 23.00, 68),
( 'VAT_IL', 'Value Added Tax', 17.00, 69),
( 'VAT_IT', 'Value Added Tax', 22.00, 70),
( 'VAT_JM', 'Value Added Tax', 16.50, 71),
( 'VAT_JP', 'Value Added Tax', 10.00, 72),
( 'VAT_JO', 'Value Added Tax', 16.00, 73),
( 'VAT_KZ', 'Value Added Tax', 12.00, 74),
( 'VAT_KE', 'Value Added Tax', 16.00, 75),
( 'VAT_KW', 'Value Added Tax', 5.00, 76),
( 'VAT_KG', 'Value Added Tax', 12.00, 77),
( 'VAT_LA', 'Value Added Tax', 10.00, 78),
( 'VAT_LV', 'Value Added Tax', 21.00, 79),
( 'VAT_LB', 'Value Added Tax', 11.00, 80),
( 'VAT_LY', 'Value Added Tax', 0.00, 81),
( 'VAT_LT', 'Value Added Tax', 21.00, 82),
( 'VAT_LU', 'Value Added Tax', 17.00, 83),
( 'GST_MY', 'Goods and Services Tax', 6.00, 84),
( 'GST_MV', 'Goods and Services Tax', 6.00, 85),
( 'VAT_ML', 'Value Added Tax', 18.00, 86),
( 'VAT_MT', 'Value Added Tax', 18.00, 87),
( 'VAT_MX', 'Value Added Tax', 16.00, 88),
( 'VAT_MN', 'Value Added Tax', 10.00, 89),
( 'VAT_MA', 'Value Added Tax', 20.00, 90),
( 'VAT_MM', 'Value Added Tax', 5.00, 91),
( 'VAT_NP', 'Value Added Tax', 13.00, 92),
( 'VAT_NL', 'Value Added Tax', 21.00, 93),
( 'GST_NZ', 'Goods and Services Tax', 15.00, 94),
( 'VAT_NG', 'Value Added Tax', 7.50, 95),
( 'VAT_NO', 'Value Added Tax', 25.00, 96),
( 'VAT_OM', 'Value Added Tax', 5.00, 97),
( 'GST_PK', 'General Sales Tax', 18.00, 98),
( 'VAT_PH', 'Value Added Tax', 12.00, 99),
( 'VAT_PL', 'Value Added Tax', 23.00, 100),
( 'VAT_PT', 'Value Added Tax', 23.00, 101),
( 'VAT_QA', 'Value Added Tax', 5.00, 102),
( 'VAT_RO', 'Value Added Tax', 19.00, 103),
( 'VAT_RU', 'Value Added Tax', 20.00, 104),
( 'VAT_SA', 'Value Added Tax', 15.00, 105),
( 'GST_SG', 'Goods and Services Tax', 8.00, 106),
( 'VAT_ZA', 'Value Added Tax', 15.00, 107),
( 'VAT_KR', 'Value Added Tax', 10.00, 108),
( 'VAT_ES', 'Value Added Tax', 21.00, 109),
( 'VAT_LK', 'Value Added Tax', 12.00, 110),
( 'VAT_SE', 'Value Added Tax', 25.00, 111),
( 'VAT_CH', 'Value Added Tax', 7.70, 112),
( 'VAT_TH', 'Value Added Tax', 7.00, 113),
( 'VAT_TR', 'Value Added Tax', 18.00, 114),
( 'VAT_AE', 'Value Added Tax', 5.00, 115),
( 'VAT_UA', 'Value Added Tax', 20.00, 116),
( 'VAT_GB', 'Value Added Tax', 20.00, 117),
( 'VAT_US', 'Sales Tax', 0.00, 118),
( 'VAT_UY', 'Value Added Tax', 22.00, 119),
( 'VAT_UZ', 'Value Added Tax', 15.00, 120),
( 'VAT_VN', 'Value Added Tax', 10.00, 121),
( 'VAT_YE', 'Value Added Tax', 0.00, 122),
( 'VAT_ZM', 'Value Added Tax', 16.00, 123),
( 'VAT_ZW', 'Value Added Tax', 15.00, 124),
( 'VAT_AM', 'Value Added Tax', 20.00, 125),
( 'VAT_AZ', 'Value Added Tax', 18.00, 126),
( 'VAT_BY', 'Value Added Tax', 20.00, 127),
( 'VAT_BA2', 'Value Added Tax', 17.00, 128),
( 'VAT_BG2', 'Value Added Tax', 20.00, 129),
( 'VAT_HR2', 'Value Added Tax', 25.00, 130),
( 'VAT_CY2', 'Value Added Tax', 19.00, 131),
( 'VAT_CZ2', 'Value Added Tax', 21.00, 132),
( 'VAT_EE2', 'Value Added Tax', 20.00, 133),
( 'VAT_GE2', 'Value Added Tax', 18.00, 134),
( 'VAT_HU2', 'Value Added Tax', 27.00, 135),
( 'VAT_IS2', 'Value Added Tax', 24.00, 136),
( 'VAT_KZ2', 'Value Added Tax', 12.00, 137),
( 'VAT_KG2', 'Value Added Tax', 12.00, 138),
( 'VAT_LV2', 'Value Added Tax', 21.00, 139),
( 'VAT_LI', 'Value Added Tax', 7.70, 140),
( 'VAT_LT2', 'Value Added Tax', 21.00, 141),
( 'VAT_LU2', 'Value Added Tax', 17.00, 142),
( 'VAT_MK', 'Value Added Tax', 18.00, 143),
( 'VAT_MT2', 'Value Added Tax', 18.00, 144),
( 'VAT_MD', 'Value Added Tax', 20.00, 145),
( 'VAT_MC', 'Value Added Tax', 20.00, 146),
( 'VAT_ME', 'Value Added Tax', 21.00, 147),
( 'VAT_NL2', 'Value Added Tax', 21.00, 148),
( 'VAT_NO2', 'Value Added Tax', 25.00, 149),
( 'VAT_PL2', 'Value Added Tax', 23.00, 150),
( 'VAT_PT2', 'Value Added Tax', 23.00, 151),
( 'VAT_RO2', 'Value Added Tax', 19.00, 152),
( 'VAT_RS', 'Value Added Tax', 20.00, 153),
( 'VAT_SK', 'Value Added Tax', 20.00, 154),
( 'VAT_SI', 'Value Added Tax', 22.00, 155),
( 'VAT_ZA2', 'Value Added Tax', 15.00, 156),
( 'VAT_ES2', 'Value Added Tax', 21.00, 157),
( 'VAT_SE2', 'Value Added Tax', 25.00, 158),
( 'VAT_CH2', 'Value Added Tax', 7.70, 159),
( 'VAT_UK2', 'Value Added Tax', 20.00, 160),
( 'VAT_TR2', 'Value Added Tax', 18.00, 161),
( 'VAT_UA2', 'Value Added Tax', 20.00, 162),
( 'VAT_RU2', 'Value Added Tax', 20.00, 163),
( 'VAT_BY3', 'Value Added Tax', 20.00, 164),
( 'VAT_KZ3', 'Value Added Tax', 12.00, 165),
( 'VAT_AM3', 'Value Added Tax', 20.00, 166),
( 'VAT_AZ3', 'Value Added Tax', 18.00, 167),
( 'VAT_GE3', 'Value Added Tax', 18.00, 168),
( 'VAT_MD3', 'Value Added Tax', 20.00, 169),
( 'VAT_UZ2', 'Value Added Tax', 15.00, 170),
( 'VAT_KG3', 'Value Added Tax', 12.00, 171),
( 'VAT_TJ', 'Value Added Tax', 18.00, 172),
( 'VAT_TM', 'Value Added Tax', 15.00, 173),
( 'VAT_AF2', 'Value Added Tax', 0.00, 174),
( 'VAT_PK2', 'General Sales Tax', 18.00, 175),
( 'VAT_IN2', 'Goods and Services Tax', 18.00, 176),
( 'VAT_BD2', 'Value Added Tax', 15.00, 177),
( 'VAT_LK2', 'Value Added Tax', 12.00, 178),
( 'VAT_NP2', 'Value Added Tax', 13.00, 179),
( 'VAT_BT2', 'Goods and Services Tax', 0.00, 180),
( 'VAT_MM2', 'Value Added Tax', 5.00, 181),
( 'VAT_CN2', 'Value Added Tax', 13.00, 182),
( 'VAT_JP2', 'Value Added Tax', 10.00, 183),
( 'VAT_KR2', 'Value Added Tax', 10.00, 184),
( 'VAT_AU2', 'Goods and Services Tax', 10.00, 185),
( 'VAT_NZ2', 'Goods and Services Tax', 15.00, 186),
( 'VAT_PH2', 'Value Added Tax', 12.00, 187),
( 'VAT_SG2', 'Goods and Services Tax', 8.00, 188),
( 'VAT_ID2', 'Value Added Tax', 11.00, 189),
( 'VAT_TH2', 'Value Added Tax', 7.00, 190),
( 'VAT_MY2', 'Goods and Services Tax', 6.00, 191),
( 'VAT_VN2', 'Value Added Tax', 10.00, 192),
( 'VAT_KH2', 'Value Added Tax', 10.00, 193),
( 'VAT_LA2', 'Value Added Tax', 10.00, 194),
( 'VAT_MN2', 'Value Added Tax', 10.00, 195),
( 'VAT_TW', 'Value Added Tax', 5.00, 196),
( 'VAT_HK2', 'Goods and Services Tax', 0.00, 197),
( 'VAT_MO', 'Value Added Tax', 5.00, 198),
( 'VAT_SA2', 'Value Added Tax', 15.00, 199),
( 'VAT_AE2', 'Value Added Tax', 5.00, 200),
( 'VAT_QA2', 'Value Added Tax', 5.00, 201),
( 'VAT_BH2', 'Value Added Tax', 5.00, 202),
( 'VAT_OM2', 'Value Added Tax', 5.00, 203),
( 'VAT_IL2', 'Value Added Tax', 17.00, 204),
( 'VAT_JO2', 'Value Added Tax', 16.00, 205),
( 'VAT_LB2', 'Value Added Tax', 11.00, 206),
( 'VAT_EG2', 'Value Added Tax', 14.00, 207),
( 'VAT_MA2', 'Value Added Tax', 20.00, 208),
( 'VAT_TN', 'Value Added Tax', 19.00, 209),
( 'VAT_DZ2', 'Value Added Tax', 19.00, 210),
( 'VAT_LY2', 'Value Added Tax', 0.00, 211),
( 'VAT_SD', 'Value Added Tax', 17.00, 212),
( 'VAT_SO', 'Value Added Tax', 0.00, 213),
( 'VAT_KE2', 'Value Added Tax', 16.00, 214),
( 'VAT_TZ', 'Value Added Tax', 18.00, 215),
( 'VAT_UG', 'Value Added Tax', 18.00, 216),
( 'VAT_NG2', 'Value Added Tax', 7.50, 217),
( 'VAT_GH2', 'Value Added Tax', 12.50, 218),
( 'VAT_SN', 'Value Added Tax', 18.00, 219),
( 'VAT_CI', 'Value Added Tax', 18.00, 220),
( 'VAT_BF2', 'Value Added Tax', 18.00, 221),
( 'VAT_ML2', 'Value Added Tax', 18.00, 222),
( 'VAT_NE', 'Value Added Tax', 19.00, 223),
( 'VAT_TG', 'Value Added Tax', 18.00, 224),
( 'VAT_CM2', 'Value Added Tax', 19.25, 225),
( 'VAT_CV2', 'Value Added Tax', 15.00, 226),
( 'VAT_GM', 'Value Added Tax', 15.00, 227),
( 'VAT_GN2', 'Value Added Tax', 18.00, 228),
( 'VAT_BJ2', 'Value Added Tax', 18.00, 229),
( 'VAT_NE2', 'Value Added Tax', 19.00, 230),
( 'VAT_TD2', 'Value Added Tax', 18.00, 231),
( 'VAT_CF2', 'Value Added Tax', 19.00, 232),
( 'VAT_CG2', 'Value Added Tax', 18.00, 233),
( 'VAT_GQ', 'Value Added Tax', 16.00, 234),
( 'VAT_GA2', 'Value Added Tax', 18.00, 235),
( 'VAT_MR', 'Value Added Tax', 20.00, 236),
( 'VAT_RW', 'Value Added Tax', 18.00, 237),
( 'VAT_BI2', 'Value Added Tax', 0.00, 238),
( 'VAT_SZ', 'Value Added Tax', 15.00, 239),
( 'VAT_LS', 'Value Added Tax', 15.00, 240),
( 'VAT_MW', 'Value Added Tax', 16.50, 241),
( 'VAT_ZM2', 'Value Added Tax', 16.00, 242),
( 'VAT_ZW2', 'Value Added Tax', 15.00, 243),
( 'VAT_SD2', 'Value Added Tax', 17.00, 244),
( 'VAT_SS', 'Value Added Tax', 0.00, 245),
( 'VAT_ER', 'Value Added Tax', 0.00, 246);







INSERT INTO employee_type
(organization_id, name, description, active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 'Teacher', 'General teaching staff', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Head of Department', 'Leads a specific academic department', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Principal', 'Overall in charge of school administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Vice Principal', 'Assists the principal in administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Lab Instructor', 'Handles lab sessions and practical classes', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Special Education Teacher', 'Works with students requiring special education', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Sports Coach', 'Manages sports and physical activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Music Teacher', 'Handles music and arts subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Art Teacher', 'Handles art-related subjects', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Librarian', 'Manages library operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Administrator', 'Handles general administration', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Accountant', 'Manages accounts, fees, and payroll', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Receptionist', 'First point of contact for visitors and parents', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'HR Officer', 'Handles recruitment, payroll, and employee welfare', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Clerk', 'General office work', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'IT Support', 'Maintains school IT infrastructure', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Counselor', 'Provides student counseling services', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Nurse', 'Handles student health needs', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Security Guard', 'Maintains school security', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Driver', 'For school transport vehicles', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Janitor', 'Handles cleaning and maintenance', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Cafeteria Staff', 'Manages school cafeteria operations', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Bus Attendant', 'Assists in student transport', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'School Board Member', 'Part of the school board or governing body', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'School Coordinator', 'Coordinates programs and school events', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Project Manager', 'Handles special projects and development activities', TRUE, FALSE, NULL, NULL, NULL, NULL, NULL, NULL);



-- 1. INSERT SUBJECT GROUPS
INSERT INTO subject_groups (organization_id, code, name)
VALUES
-- Core Academic Streams
(1, 'SCI',  'Science Group'),
(1, 'ART',  'Arts Group'),
(1, 'COM',  'Commerce Group'),

-- Technology
(1, 'CS',   'Computer Studies Group'),
(1, 'IT',   'Information Technology Group'),
(1, 'AI',   'Robotics & AI Group'),

-- Creative Arts
(1, 'FA',   'Fine Arts Group'),
(1, 'PA',   'Performing Arts Group'),
(1, 'DES',  'Design & Media Studies Group'),

-- Physical & Health
(1, 'PE',   'Physical Education Group'),
(1, 'SP',   'Sports Science Group'),
(1, 'HLT',  'Health & Wellness Group'),

-- Moral & Religious
(1, 'REL',  'Religious Studies Group'),
(1, 'ETH',  'Ethics & Moral Education Group'),

-- Foundational
(1, 'GEN',  'General Studies Group'),
(1, 'PRI',  'Primary Education Group'),
(1, 'ECE',  'Early Childhood Education Group'),

-- Humanities & Society
(1, 'SOC',  'Social Sciences Group'),
(1, 'HUM',  'Humanities Group'),
(1, 'CIV',  'Civics & Global Studies Group'),

-- Career & Practical
(1, 'BUS',  'Business & Economics Group'),
(1, 'VOC',  'Vocational Studies Group'),
(1, 'LIFE', 'Life Skills & Career Guidance Group'),

-- Languages
(1, 'LANG', 'Languages Group'),
(1, 'FL',   'Foreign Languages Group')
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    is_active = TRUE,
    is_deleted = FALSE;

-- 2. INSERT SUBJECTS
-- Note: subject_group_id is fetched dynamically to ensure correctness regardless of ID generation.
-- Defaulting is_core = TRUE as per user data.

INSERT INTO subjects (organization_id, code, name, subject_group_id, is_core)
VALUES
-- Science Group
(1, 'PHY',     'Physics',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'CHEM',    'Chemistry',             (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'BIO',     'Biology',               (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'GEN_SCI', 'General Science',       (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),
(1, 'ENV_SCI', 'Environmental Science', (SELECT id FROM subject_groups WHERE code='SCI' LIMIT 1), TRUE),

-- Arts Group
(1, 'HIST',    'History',               (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'GEO',     'Geography',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'PSY',     'Psychology',            (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),
(1, 'SOCIO',   'Sociology',             (SELECT id FROM subject_groups WHERE code='ART' LIMIT 1), TRUE),

-- Commerce Group
(1, 'ACC',     'Accounting',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'ECO',     'Economics',             (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'BST',     'Business Studies',      (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),
(1, 'STAT',    'Statistics',            (SELECT id FROM subject_groups WHERE code='COM' LIMIT 1), TRUE),

-- Computer Studies Group
(1, 'CS_FUND', 'Computer Fundamentals', (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),
(1, 'PROG',    'Programming',           (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),
(1, 'DS',      'Data Structures',       (SELECT id FROM subject_groups WHERE code='CS' LIMIT 1), TRUE),

-- Information Technology Group
(1, 'IT_BASIC', 'Information Technology', (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),
(1, 'NET',      'Networking Basics',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),
(1, 'DB',       'Database Concepts',      (SELECT id FROM subject_groups WHERE code='IT' LIMIT 1), TRUE),

-- Robotics & AI Group
(1, 'AI_INTRO', 'Introduction to AI',     (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE),
(1, 'ROBO',     'Robotics',               (SELECT id FROM subject_groups WHERE code='AI' LIMIT 1), TRUE),

-- Fine Arts Group
(1, 'DRAW',   'Drawing',               (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),
(1, 'PAINT',  'Painting',              (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),
(1, 'CRAFT',  'Craft & Design',        (SELECT id FROM subject_groups WHERE code='FA' LIMIT 1), TRUE),

-- Performing Arts Group
(1, 'MUSIC',  'Music',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),
(1, 'DRAMA',  'Drama',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),
(1, 'DANCE',  'Dance',                 (SELECT id FROM subject_groups WHERE code='PA' LIMIT 1), TRUE),

-- Design & Media Studies Group
(1, 'GD',     'Graphic Design',        (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),
(1, 'MEDIA',  'Media Studies',         (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),
(1, 'PHOTO',  'Photography',           (SELECT id FROM subject_groups WHERE code='DES' LIMIT 1), TRUE),

-- Physical Education Group
(1, 'PE',     'Physical Education',    (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE),
(1, 'YOGA',    'Yoga',                  (SELECT id FROM subject_groups WHERE code='PE' LIMIT 1), TRUE),

-- Sports Science Group
(1, 'SPORT_SCI', 'Sports Science',     (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE),
(1, 'FIT',       'Fitness Training',   (SELECT id FROM subject_groups WHERE code='SP' LIMIT 1), TRUE),

-- Health & Wellness Group
(1, 'HEALTH', 'Health Education',      (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE),
(1, 'NUT',    'Nutrition',             (SELECT id FROM subject_groups WHERE code='HLT' LIMIT 1), TRUE),

-- Religious Studies Group
(1, 'ISL',     'Islamic Studies',      (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE),
(1, 'REL_GEN', 'Comparative Religion', (SELECT id FROM subject_groups WHERE code='REL' LIMIT 1), TRUE),

-- Ethics & Moral Education Group
(1, 'ETHICS', 'Ethics',                (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE),
(1, 'MORAL',  'Moral Education',       (SELECT id FROM subject_groups WHERE code='ETH' LIMIT 1), TRUE),

-- General Studies Group
(1, 'GK',     'General Knowledge',     (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE),
(1, 'GS',     'General Studies',       (SELECT id FROM subject_groups WHERE code='GEN' LIMIT 1), TRUE),

-- Primary Education Group
(1, 'BASIC_MATH', 'Basic Mathematics', (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE),
(1, 'BASIC_LANG', 'Basic Language',    (SELECT id FROM subject_groups WHERE code='PRI' LIMIT 1), TRUE),

-- Early Childhood Education Group
(1, 'PLAY',       'Play & Learning',   (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE),
(1, 'DRAW_BASIC', 'Basic Drawing',     (SELECT id FROM subject_groups WHERE code='ECE' LIMIT 1), TRUE),

-- Social Sciences Group
(1, 'POL',    'Political Science',     (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE),
(1, 'ANTH',   'Anthropology',          (SELECT id FROM subject_groups WHERE code='SOC' LIMIT 1), TRUE),

-- Humanities Group
(1, 'PHIL',   'Philosophy',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE),
(1, 'LIT',    'Literature',            (SELECT id FROM subject_groups WHERE code='HUM' LIMIT 1), TRUE),

-- Civics & Global Studies Group
(1, 'CIVICS', 'Civics',                (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE),
(1, 'GLOBAL', 'Global Studies',        (SELECT id FROM subject_groups WHERE code='CIV' LIMIT 1), TRUE),

-- Business & Economics Group
(1, 'ENT',    'Entrepreneurship',      (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE),
(1, 'FIN',    'Finance Basics',        (SELECT id FROM subject_groups WHERE code='BUS' LIMIT 1), TRUE),

-- Vocational Studies Group
(1, 'ELEC',   'Basic Electronics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE),
(1, 'AUTO',   'Automobile Basics',     (SELECT id FROM subject_groups WHERE code='VOC' LIMIT 1), TRUE),

-- Life Skills & Career Guidance Group
(1, 'LS',     'Life Skills',           (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE),
(1, 'CAREER', 'Career Guidance',       (SELECT id FROM subject_groups WHERE code='LIFE' LIMIT 1), TRUE),

-- Languages Group
(1, 'ENG',    'English',               (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),
(1, 'URD',    'Urdu',                  (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),
(1, 'ARB',    'Arabic',                (SELECT id FROM subject_groups WHERE code='LANG' LIMIT 1), TRUE),

-- Foreign Languages Group
(1, 'FR',     'French',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE),
(1, 'GER',    'German',                (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE),
(1, 'CHI',    'Chinese',               (SELECT id FROM subject_groups WHERE code='FL' LIMIT 1), TRUE)
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    subject_group_id = VALUES(subject_group_id),
    is_core = VALUES(is_core),
    is_active = TRUE,
    is_deleted = FALSE;



INSERT INTO board_member_roles (organization_id, code, name) VALUES
(1, 'CHAIRMAN', 'Chairman'),
(1, 'CHAIRPERSON', 'Chairperson'),
(1, 'PRESIDENT', 'President'),
(1, 'VICE_CHAIRMAN', 'Vice Chairman'),
(1, 'VICE_CHAIRPERSON', 'Vice Chairperson'),
(1, 'VICE_PRESIDENT', 'Vice President'),
(1, 'DIRECTOR', 'Board Director'),
(1, 'EXECUTIVE_DIRECTOR', 'Executive Director'),
(1, 'NON_EXECUTIVE_DIRECTOR', 'Non-Executive Director'),
(1, 'INDEPENDENT_DIRECTOR', 'Independent Director'),
(1, 'ADVISOR', 'Advisor'),
(1, 'TRUSTEE', 'Trustee'),
(1, 'GOVERNOR', 'Governor'),
(1, 'BOARD_MEMBER', 'Board Member'),
(1, 'SECRETARY', 'Board Secretary'),
(1, 'ASSISTANT_SECRETARY', 'Assistant Secretary'),
(1, 'TREASURER', 'Treasurer'),
(1, 'ASSISTANT_TREASURER', 'Assistant Treasurer'),
(1, 'CHANCELLOR', 'Chancellor'),
(1, 'VICE_CHANCELLOR', 'Vice Chancellor'),
(1, 'PRO_CHANCELLOR', 'Pro Chancellor'),
(1, 'RECTOR', 'Rector'),
(1, 'PROVOST', 'Provost'),
(1, 'AUDIT_COMMITTEE_MEMBER', 'Audit Committee Member'),
(1, 'FINANCE_COMMITTEE_MEMBER', 'Finance Committee Member'),
(1, 'ACADEMIC_COMMITTEE_MEMBER', 'Academic Committee Member'),
(1, 'GOVERNANCE_COMMITTEE_MEMBER', 'Governance Committee Member'),
(1, 'LEGAL_ADVISOR', 'Legal Advisor'),
(1, 'FINANCIAL_ADVISOR', 'Financial Advisor'),
(1, 'STRATEGIC_ADVISOR', 'Strategic Advisor'),
(1, 'EXTERNAL_MEMBER', 'External Board Member'),
(1, 'INTERNAL_MEMBER', 'Internal Board Member'),
(1, 'PATRON', 'Patron'),
(1, 'FOUNDER', 'Founder'),
(1, 'CO_FOUNDER', 'Co-Founder'),
(1, 'HONORARY_MEMBER', 'Honorary Member');



INSERT INTO campuses (organization_id, institute_id, province_id, city_id,
                      campus_name, contact, email, website, address,
                      logo, deleted,
                      created_at, created_by, updated_at, updated_by,
                      deleted_at, deleted_by)
VALUES

-- Lahore
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Lahore' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com',
 'https://downtown.smarteschool.com', '123 Main Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Lahore
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Lahore' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com',
 'https://uptown.smarteschool.com', '456 Park Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com',
 'https://riverside.smarteschool.com', '789 River Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Peshawar
(1, 1,
 (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'),
 (SELECT id FROM cities WHERE name='Peshawar' AND province_id = (SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa')),
 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com',
 'https://hilltop.smarteschool.com', '101 Hill Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Faisalabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Faisalabad' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
 'https://greenfield.smarteschool.com', '202 Green Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Karachi
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Karachi' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com',
 'https://seaside.smarteschool.com', '303 Beach Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Multan
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Multan' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Central Campus', '+92-303-9990001', 'central@smarteschool.com',
 'https://central.smarteschool.com', '404 Central Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Hyderabad
(1, 1,
 (SELECT id FROM provinces WHERE name='Sindh'),
 (SELECT id FROM cities WHERE name='Hyderabad' AND province_id = (SELECT id FROM provinces WHERE name='Sindh')),
 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com',
 'https://lakeside.smarteschool.com', '505 Lake Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Rawalpindi
(1, 1,
 (SELECT id FROM provinces WHERE name='Punjab'),
 (SELECT id FROM cities WHERE name='Rawalpindi' AND province_id = (SELECT id FROM provinces WHERE name='Punjab')),
 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com',
 'https://sunrise.smarteschool.com', '606 Sunrise Blvd', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Quetta
(1, 1,
 (SELECT id FROM provinces WHERE name='Balochistan'),
 (SELECT id FROM cities WHERE name='Quetta' AND province_id = (SELECT id FROM provinces WHERE name='Balochistan')),
 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com',
 'https://maple.smarteschool.com', '707 Maple Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL);


-- ============================================================
-- Sample Data: Standards / Grades
-- Each campus has 1st Grade → 5th Grade. These standards
-- are used to assign students, teachers, timetables, exams,
-- and fees. The 'deleted' column is FALSE (0) for active records.
-- ============================================================

-- Sample standards for 10 campuses
INSERT INTO standards (organization_id, campus_id, standard_name, created_at, updated_at)
VALUES
-- Downtown Campus (campus_id = 1)
(1, 1, '1st Grade', NOW(), NOW()),
(1, 1, '2nd Grade', NOW(), NOW()),
(1, 1, '3rd Grade', NOW(), NOW()),
(1, 1, '4th Grade', NOW(), NOW()),
(1, 1, '5th Grade', NOW(), NOW()),

-- Uptown Campus (campus_id = 2)
(1, 2, '1st Grade', NOW(), NOW()),
(1, 2, '2nd Grade', NOW(), NOW()),
(1, 2, '3rd Grade', NOW(), NOW()),
(1, 2, '4th Grade', NOW(), NOW()),
(1, 2, '5th Grade', NOW(), NOW()),

-- Riverside Campus (campus_id = 3)
(1, 3, '1st Grade', NOW(), NOW()),
(1, 3, '2nd Grade', NOW(), NOW()),
(1, 3, '3rd Grade', NOW(), NOW()),
(1, 3, '4th Grade', NOW(), NOW()),
(1, 3, '5th Grade', NOW(), NOW()),

-- Hilltop Campus (campus_id = 4)
(1, 4, '1st Grade', NOW(), NOW()),
(1, 4, '2nd Grade', NOW(), NOW()),
(1, 4, '3rd Grade', NOW(), NOW()),
(1, 4, '4th Grade', NOW(), NOW()),
(1, 4, '5th Grade', NOW(), NOW()),

-- Greenfield Campus (campus_id = 5)
(1, 5, '1st Grade', NOW(), NOW()),
(1, 5, '2nd Grade', NOW(), NOW()),
(1, 5, '3rd Grade', NOW(), NOW()),
(1, 5, '4th Grade', NOW(), NOW()),
(1, 5, '5th Grade', NOW(), NOW()),

-- Seaside Campus (campus_id = 6)
(1, 6, '1st Grade', NOW(), NOW()),
(1, 6, '2nd Grade', NOW(), NOW()),
(1, 6, '3rd Grade', NOW(), NOW()),
(1, 6, '4th Grade', NOW(), NOW()),
(1, 6, '5th Grade', NOW(), NOW()),

-- Central Campus (campus_id = 7)
(1, 7, '1st Grade', NOW(), NOW()),
(1, 7, '2nd Grade', NOW(), NOW()),
(1, 7, '3rd Grade', NOW(), NOW()),
(1, 7, '4th Grade', NOW(), NOW()),
(1, 7, '5th Grade', NOW(), NOW()),

-- Lakeside Campus (campus_id = 8)
(1, 8, '1st Grade', NOW(), NOW()),
(1, 8, '2nd Grade', NOW(), NOW()),
(1, 8, '3rd Grade', NOW(), NOW()),
(1, 8, '4th Grade', NOW(), NOW()),
(1, 8, '5th Grade', NOW(), NOW()),

-- Sunrise Campus (campus_id = 9)
(1, 9, '1st Grade', NOW(), NOW()),
(1, 9, '2nd Grade', NOW(), NOW()),
(1, 9, '3rd Grade', NOW(), NOW()),
(1, 9, '4th Grade', NOW(), NOW()),
(1, 9, '5th Grade', NOW(), NOW()),

-- Maple Campus (campus_id = 10)
(1, 10, '1st Grade', NOW(), NOW()),
(1, 10, '2nd Grade', NOW(), NOW()),
(1, 10, '3rd Grade', NOW(), NOW()),
(1, 10, '4th Grade', NOW(), NOW()),
(1, 10, '5th Grade', NOW(), NOW());


-- ============================================================
-- Sample Data: Sections
-- Each standard (grade) is divided into sections (A/B/C).
-- Sections are used to manage class divisions, student
-- assignments, timetables, and teacher allocation.
-- 'deleted' = 0 indicates active section, 1 indicates soft-deleted.
-- ============================================================


INSERT INTO sections (organization_id, standard_id, section_name, created_at, updated_at, deleted, deleted_at)
VALUES
    -- Standard 1
    (1, 1, 'A', NOW(), NOW(), 1, NULL),
    (1, 1, 'B', NOW(), NOW(), 0, NULL),
    (1, 1, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 2
    (1, 2, 'A', NOW(), NOW(), 0, NULL),
    (1, 2, 'B', NOW(), NOW(), 0, NULL),
    (1, 2, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 3
    (1, 3, 'A', NOW(), NOW(), 0, NULL),
    (1, 3, 'B', NOW(), NOW(), 0, NULL),
    (1, 3, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 4
    (1, 4, 'A', NOW(), NOW(), 0, NULL),
    (1, 4, 'B', NOW(), NOW(), 0, NULL),
    (1, 4, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 5
    (1, 5, 'A', NOW(), NOW(), 0, NULL),
    (1, 5, 'B', NOW(), NOW(), 0, NULL),
    (1, 5, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 6
    (1, 6, 'A', NOW(), NOW(), 0, NULL),
    (1, 6, 'B', NOW(), NOW(), 0, NULL),
    (1, 6, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 7
    (1, 7, 'A', NOW(), NOW(), 0, NULL),
    (1, 7, 'B', NOW(), NOW(), 0, NULL),
    (1, 7, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 8
    (1, 8, 'A', NOW(), NOW(), 0, NULL),
    (1, 8, 'B', NOW(), NOW(), 0, NULL),
    (1, 8, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 9
    (1, 9, 'A', NOW(), NOW(), 0, NULL),
    (1, 9, 'B', NOW(), NOW(), 0, NULL),
    (1, 9, 'C', NOW(), NOW(), 0, NULL),
    -- Standard 10
    (1, 10, 'A', NOW(), NOW(), 0, NULL),
    (1, 10, 'B', NOW(), NOW(), 0, NULL),
    (1, 10, 'C', NOW(), NOW(), 0, NULL);


-- ============================================================
-- 🏢 DEPARTMENTS MASTER DATA (ALL-ENCOMPASSING PRODUCTION SET)
-- ============================================================

-- ------------------------------------------------------------
-- 🏥 CAMPUS 1: DOWNTOWN CAMPUS (Science, Tech & Medical University)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active) VALUES

-- 1. Faculty of Engineering & Tech (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ENG-FAC', 'Faculty of Engineering', 'Main engineering faculty', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CS', 'Dept of Computer Science', 'Core CS and algorithms', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-SE', 'Dept of Software Engineering', 'Software design and development', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-IT', 'Dept of Information Technology', 'IT systems and networks', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-AI', 'Dept of Artificial Intelligence', 'AI, Robotics and Machine Learning', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-DS', 'Dept of Data Science', 'Big data and analytics', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CYB', 'Dept of Cyber Security', 'Information security', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-EE', 'Dept of Electrical Engineering', 'Power and electronics', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ME', 'Dept of Mechanical Engineering', 'Thermodynamics and mechanics', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CE', 'Dept of Civil Engineering', 'Structures and transport', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-CHE', 'Dept of Chemical Engineering', 'Chemical processes and labs', TRUE),

-- 2. Faculty of Medical & Life Sciences (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-MED', 'Faculty of Medical Sciences', 'Medical and healthcare studies', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-PHARM', 'Dept of Pharmacy', 'Pharmaceutical studies', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-NURS', 'Dept of Nursing', 'Nursing and healthcare support', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BIO', 'Dept of Biology', 'Biological sciences', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BIOTECH', 'Dept of Biotechnology', 'Bio-engineering', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-MICRO', 'Dept of Microbiology', 'Microbial research', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ZOO', 'Dept of Zoology', 'Animal sciences', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-BOT', 'Dept of Botany', 'Plant sciences', TRUE),

-- 3. Administrative (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-REG', 'Registrar Office', 'Main campus registry', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-CONT', 'Controller Office', 'Main administrative control', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'HR' AND organization_id = 1), 'DT-HR-DEPT', 'Human Resources (HR)', 'Staff and faculty management', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'FINANCE' AND organization_id = 1), 'DT-FIN-ACC', 'Finance / Accounts', 'Payroll and accounting', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMISSIONS' AND organization_id = 1), 'DT-ADM-CELL', 'Admissions Office', 'Student intake', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'EXAM' AND organization_id = 1), 'DT-EXAM-DEPT', 'Examinations Department', 'Exams and results', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'IT' AND organization_id = 1), 'DT-IT-SUP', 'IT / System Support', 'Tech infrastructure', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'QUALITY' AND organization_id = 1), 'DT-QA-DEPT', 'Quality Assurance', 'Academic quality control', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ADMIN' AND organization_id = 1), 'DT-ADM-PROC', 'Procurement & Purchasing', 'Supply chain and vendor mgmt', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-FAC-AFF', 'Faculty Affairs', 'Faculty records and coordination', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-LMS-UNIT', 'E-Learning / LMS Center', 'Digital education support', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'RESEARCH' AND organization_id = 1), 'DT-IP-OFFICE', 'Intellectual Property (IP) Office', 'Patents and research IP', TRUE),

-- 4. Specialized Units (Downtown)
(1, 1, (SELECT id FROM department_types WHERE code = 'RESEARCH' AND organization_id = 1), 'DT-RES-LABS', 'Research Labs', 'Core research facilities', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'DT-INT-OFF', 'International Office', 'Foreign student support', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-RD-GRANT', 'Grants & Funding Office', 'Research grants management', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-ENV', 'Dept of Environmental Science', 'Ecology and environment', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'DT-ACAD-STAT', 'Dept of Statistics', 'Mathematical statistics', TRUE),
(1, 1, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'DT-TRAIN-DEV', 'Training & Development', 'Faculty training programs', TRUE);


-- ------------------------------------------------------------
-- 🎓 CAMPUS 2: UPTOWN CAMPUS (Business, Arts & Social Sciences)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active) VALUES

-- 1. Faculty of Business & Management (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-BUS-FAC', 'Faculty of Business', 'Main business faculty', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-BBA', 'Dept of BBA/MBA', 'Business administration', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-FIN', 'Dept of Finance', 'Financial studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ACC', 'Dept of Accounting', 'Accounting and audit', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-MKT', 'Dept of Marketing', 'Marketing and sales', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HRM', 'Dept of HRM', 'Human resources mgmt', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-SCM', 'Dept of Supply Chain', 'Logistics and operations', TRUE),

-- 2. Faculty of Humanities & Social Sciences (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HUM-FAC', 'Faculty of Humanities', 'Arts and social sciences', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-PSY', 'Dept of Psychology', 'Behavioral sciences', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-SOC', 'Dept of Sociology', 'Societal studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-POL', 'Dept of Political Science', 'Governance and politics', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-IR', 'Dept of Intl Relations', 'Global affairs', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-PHI', 'Dept of Philosophy', 'Logics and ethics', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-LAW', 'Dept of Legal Affairs', 'Legal and law studies', TRUE),

-- 3. Languages & Arts (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ENG', 'Dept of English', 'English linguistics', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-URD', 'Dept of Urdu', 'Urdu studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-ARA', 'Dept of Arabic', 'Arabic studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-FRN', 'Dept of French', 'French studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-CHI', 'Dept of Chinese', 'Chinese studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-HIS', 'Dept of History', 'Historical studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-GEO', 'Dept of Geography', 'Geographical and spatial studies', TRUE),

-- 4. Student Support (Uptown)
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-COUNSEL', 'Student Counseling', 'Guidance and support', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-CAREER', 'Career Services', 'Placement office', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'UP-SS-ALUMNI', 'Alumni Relations', 'Alumni network', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'HOSTEL' AND organization_id = 1), 'UP-SS-HOSTEL', 'Hostel Management', 'On-campus housing', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-GER', 'Dept of German', 'German studies', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC_SUPPORT' AND organization_id = 1), 'UP-AS-TRAIN', 'Training & Development', 'Staff and faculty training', TRUE),
(1, 2, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'UP-ACAD-DIST', 'Distance Learning', 'Online and remote education', TRUE);


-- ------------------------------------------------------------
-- 🌿 CAMPUS 3: RIVERSIDE CAMPUS (Comprehensive School & College)
-- ------------------------------------------------------------
INSERT INTO departments 
(organization_id, campus_id, department_type_id, department_code, department_name, description, active) VALUES

-- 1. General school Departments (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-MAT', 'Mathematics Dept', 'Core mathematics', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-SCI', 'General Science Dept', 'Physics, Chemistry, Biology', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ENG', 'English Dept', 'Grammar and literature', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-SOC', 'Social Studies Dept', 'History and Geography', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ISL', 'Islamic Studies Dept', 'Religious education', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-CIV', 'Civics & Pol Science', 'Citizenship education', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-ART', 'Fine Arts Dept', 'Creative arts', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-MUS', 'Music Dept', 'Musical education', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-SCH-PE', 'Physical Education', 'Sports and games', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'SUPPORT' AND organization_id = 1), 'RS-SS-DISC', 'Discipline Office', 'Student conduct and discipline', TRUE),

-- 2. College Level Departments (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-PREM', 'Pre-Medical Dept', 'College pre-med', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-PREE', 'Pre-Engineering Dept', 'College pre-eng', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-COL-COM', 'Commerce Dept', 'College commerce', TRUE),

-- 3. Operational & Facilities (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'OPERATIONS' AND organization_id = 1), 'RS-OP-MAINT', 'Facilities & Maintenance', 'Campus upkeep', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'SECURITY' AND organization_id = 1), 'RS-OP-SEC', 'Security Department', 'Campus safety', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'OPERATIONS' AND organization_id = 1), 'RS-OP-CLEAN', 'Housekeeping', 'Cleanliness and hygiene', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'FOOD' AND organization_id = 1), 'RS-OP-FOOD', 'Cafeteria Services', 'Student food services', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'TRANSPORT' AND organization_id = 1), 'RS-OP-TRANS', 'Transport Department', 'Fleet management', TRUE),

-- 4. Specialized Religious / Cultural (Riverside)
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-REL-SHARIAH', 'Shariah Department', 'Specialized religious studies', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-REL-ETHICS', 'Ethics & Moral Ed', 'Values education', TRUE),
(1, 3, (SELECT id FROM department_types WHERE code = 'ACADEMIC' AND organization_id = 1), 'RS-CUL-AFFAIRS', 'Cultural Affairs', 'Heritage and culture', TRUE);

-- Final Hierarchical Updates (Assigning Parents)
UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'DT-ACAD-ENG-FAC' AND d2.campus_id = 1
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('DT-ACAD-CS', 'DT-ACAD-SE', 'DT-ACAD-IT', 'DT-ACAD-AI', 'DT-ACAD-DS', 'DT-ACAD-CYB', 'DT-ACAD-EE', 'DT-ACAD-ME', 'DT-ACAD-CE', 'DT-ACAD-CHE') AND d1.campus_id = 1;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'DT-ACAD-MED' AND d2.campus_id = 1
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('DT-ACAD-PHARM', 'DT-ACAD-NURS', 'DT-ACAD-BIO', 'DT-ACAD-BIOTECH', 'DT-ACAD-MICRO', 'DT-ACAD-ZOO', 'DT-ACAD-BOT') AND d1.campus_id = 1;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'UP-ACAD-BUS-FAC' AND d2.campus_id = 2
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('UP-ACAD-BBA', 'UP-ACAD-FIN', 'UP-ACAD-ACC', 'UP-ACAD-MKT', 'UP-ACAD-HRM', 'UP-ACAD-SCM') AND d1.campus_id = 2;

UPDATE departments d1 
JOIN departments d2 ON d2.department_code = 'UP-ACAD-HUM-FAC' AND d2.campus_id = 2
SET d1.parent_id = d2.id 
WHERE d1.department_code IN ('UP-ACAD-PSY', 'UP-ACAD-SOC', 'UP-ACAD-POL', 'UP-ACAD-IR', 'UP-ACAD-PHI', 'UP-ACAD-LAW', 'UP-ACAD-HIS', 'UP-ACAD-GEO') AND d1.campus_id = 2;


INSERT INTO charge_types
(organization_id, code, name, description, is_active, deleted, created_at)
VALUES
(1, 'FIXED', 'Fixed Amount', 'Standard set amount (e.g., tuition, admission)', TRUE, FALSE, NOW()),
(1, 'PERCENTAGE', 'Percentage', 'Fee calculated as a % of another fee or total (e.g., late fine, discount)', TRUE, FALSE, NOW()),
(1, 'SLAB', 'Slab Based', 'Amount depends on slabs (e.g., transport fee depends on distance or zone)', TRUE, FALSE, NOW()),
(1, 'PER_UNIT', 'Per Unit', 'Fee per unit/item (e.g., lab consumables, books, meals)', TRUE, FALSE, NOW()),
(1, 'CONDITIONAL', 'Conditional', 'Fee applies only if certain condition is met (e.g., extra-curricular activity only for enrolled students)', TRUE, FALSE, NOW());


INSERT INTO fee_recurrence_rules(code, name, description, is_active, is_deleted, created_by)
VALUES
('ONE_TIME', 'One Time', 'Fee charged only once (e.g., admission or registration fee)', TRUE, FALSE, 1),
('MONTHLY', 'Monthly', 'Fee charged every month (common for tuition fees)', TRUE, FALSE, 1),
('QUARTERLY', 'Quarterly', 'Fee charged every three months', TRUE, FALSE, 1),
('HALF_YEARLY', 'Half Yearly', 'Fee charged twice in an academic year',TRUE, FALSE, 1),
('ANNUAL', 'Annual', 'Fee charged once per academic year',TRUE, FALSE, 1),
('PER_TERM', 'Per Term', 'Fee charged per academic term or semester', TRUE, FALSE, 1),
('ON_DEMAND', 'On Demand', 'Fee charged when a service is used (transport, lab, activity)', TRUE, FALSE, 1);


INSERT INTO fee_catalog
(organization_id, code, name, description, charge_type_id, recurrence_rule_id,
 active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)

VALUES

(1, 'ADMISSION', 'Admission Fee', 'Fee charged at the time of student admission',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ONE_TIME'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'TUITION', 'Tuition Fee', 'Core academic fee for teaching and instruction',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'ACADEMIC', 'Academic Services Fee', 'Charges related to academic support and services',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='PER_TERM'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'FACILITY', 'Facility Usage Fee', 'Charges for using school facilities and infrastructure',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ANNUAL'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'TRANSPORT', 'Transport Services Fee', 'Fee related to student transportation services',
 (SELECT id FROM charge_types WHERE code='SLAB'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'ACTIVITY', 'Student Activities Fee', 'Fee related to extracurricular and student activities',
 (SELECT id FROM charge_types WHERE code='CONDITIONAL'),
 (SELECT id FROM fee_recurrence_rules WHERE code='PER_TERM'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'RESOURCE', 'Learning Resource Fee', 'Fee related to learning materials and resources',
 (SELECT id FROM charge_types WHERE code='PER_UNIT'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ANNUAL'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'BOARDING', 'Boarding and Accommodation Fee', 'Charges for hostel or boarding facilities',
 (SELECT id FROM charge_types WHERE code='FIXED'),
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'PENALTY', 'Penalty and Fine', 'Charges applied for late payments or violations',
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ON_DEMAND'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(1, 'DISCOUNT', 'Discount or Concession', 'Fee reduction applied based on eligibility',
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'),
 (SELECT id FROM fee_recurrence_rules WHERE code='ON_DEMAND'),
 TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL);

-- ===================================
-- FEE COMPONENTS DATA
-- ===================================
-- ADMISSION FEE (Catalog ID = 1)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 1, 'ADM-FORM', 'Admission Form Fee', 'ACC-ADM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 1, 'ADM-PROC', 'Admission Processing Fee', 'ACC-ADM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 1, 'ADM-ORIENT', 'Orientation Session Fee', 'ACC-ADM-03', FALSE, FALSE, TRUE, FALSE, NOW(), 1);

-- TUITION FEE (Catalog ID = 2)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 2, 'TUI-BASIC', 'Basic Tuition Fee', 'ACC-TUI-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 2, 'TUI-LAB', 'Lab Tuition Fee', 'ACC-TUI-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 2, 'TUI-MISC', 'Miscellaneous Tuition Fee', 'ACC-TUI-03', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- ACADEMIC SERVICES FEE (Catalog ID = 3)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 3, 'EXAM-MID', 'Mid Term Exam Fee', 'ACC-EXM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 3, 'EXAM-FINAL', 'Final Exam Fee', 'ACC-EXM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 3, 'GRADING', 'Grading & Evaluation Fee', 'ACC-EXM-03', FALSE, FALSE, TRUE, FALSE, NOW(), 1);

-- FACILITY USAGE FEE (Catalog ID = 4)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 4, 'LAB-COMP', 'Computer Lab Charges', 'ACC-LAB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 4, 'LAB-SCI', 'Science Lab Charges', 'ACC-LAB-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 4, 'LIB-USE', 'Library Usage Fee', 'ACC-LIB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 4, 'SPORT-FAC', 'Sports Facility Charges', 'ACC-SPORT-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- TRANSPORT FEE (Catalog ID = 5)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 5, 'TRN-MON', 'Monthly Transport Charges', 'ACC-TRN-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 5, 'TRN-REG', 'Transport Registration Fee', 'ACC-TRN-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 5, 'TRN-ROUTE', 'Route & Pickup Fee', 'ACC-TRN-03', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- ACTIVITY FEE (Catalog ID = 6)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 6, 'ACT-SPORT', 'Sports & Activities Fee', 'ACC-ACT-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 6, 'ACT-MUSIC', 'Music & Arts Fee', 'ACC-ACT-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 6, 'ACT-CLUB', 'Clubs & Societies Fee', 'ACC-ACT-03', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- RESOURCE FEE (Catalog ID = 7)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 7, 'RES-LIB', 'Library Resources Fee', 'ACC-RES-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 7, 'RES-LAB', 'Lab Consumables Fee', 'ACC-RES-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 7, 'RES-MATERIAL', 'Learning Materials Fee', 'ACC-RES-03', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- BOARDING FEE (Catalog ID = 8)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 8, 'HOS-MON', 'Monthly Hostel Charges', 'ACC-HOS-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 8, 'HOS-FOOD', 'Hostel Food Charges', 'ACC-HOS-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 8, 'HOS-UTIL', 'Hostel Utility Charges', 'ACC-HOS-03', FALSE, TRUE, TRUE, FALSE, NOW(), 1);

-- PENALTY & FINE (Catalog ID = 9)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 9, 'FINE-LATE', 'Late Payment Fine', 'ACC-FINE-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 9, 'FINE-DISC', 'Disciplinary Fine', 'ACC-FINE-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 9, 'FINE-MISC', 'Miscellaneous Penalty', 'ACC-FINE-03', FALSE, FALSE, TRUE, FALSE, NOW(), 1);

-- DISCOUNT & CONCESSION (Catalog ID = 10)
INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code, taxable, discount_able, active, deleted, created_at, created_by)
VALUES
(1, 10, 'DISC-SCH', 'Scholarship Discount', 'ACC-DISC-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 10, 'DISC-FAM', 'Family Discount', 'ACC-DISC-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 10, 'DISC-PROMO', 'Promotional Discount', 'ACC-DISC-03', FALSE, FALSE, TRUE, FALSE, NOW(), 1);

-- ===================================
-- FEE RATES DATA
-- ===================================

-- 1. ADMISSION FEES (Fixed Amount)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='ADM-FORM'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 1000.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='ADM-PROC'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 2500.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='ADM-ORIENT'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 500.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 2. TUITION FEES (Fixed Amount)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='TUI-BASIC'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 8000.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='TUI-LAB'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 1500.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='TUI-MISC'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 500.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 3. ACADEMIC SERVICES (Fixed Amount)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='EXAM-MID'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 1200.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='EXAM-FINAL'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 2000.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 4. FACILITY USAGE (Fixed Amount)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, fixed_amount, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='LAB-COMP'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 1000.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='LIB-USE'), 1, (SELECT id FROM charge_types WHERE code='FIXED'), 400.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 5. TRANSPORT (Slab Based - Requires Slab Groups, setting fixed placeholder for now)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, slab_group_id, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='TRN-MON'), 1, (SELECT id FROM charge_types WHERE code='SLAB'), NULL, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 6. RESOURCE FEE (Per Unit Pricing)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, unit_price, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='RES-MATERIAL'), 1, (SELECT id FROM charge_types WHERE code='PER_UNIT'), 50.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 7. PENALTY & FINES (Percentage Based)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, percentage_value, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='FINE-LATE'), 1, (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 5.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());

-- 8. DISCOUNTS & CONCESSIONS (Percentage Based)
INSERT INTO fee_rates (organization_id, campus_id, standard_id, fee_component_id, academic_year_id, charge_type_id, percentage_value, currency, effective_from, active, deleted, created_at)
VALUES
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='DISC-SCH'), 1, (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 25.00, 'USD', '2024-01-01', TRUE, FALSE, NOW()),
(1, 1, 1, (SELECT id FROM fee_component WHERE component_code='DISC-FAM'), 1, (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 10.00, 'USD', '2024-01-01', TRUE, FALSE, NOW());



    -- Populate standard_subjects with real-time dataset
    INSERT INTO standard_subjects
    (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
    VALUES
    -- Primary (Std 1-5)
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 1, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_MATH' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 2, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 3, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 3, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 4, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 4, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),
    (1, 5, (SELECT id FROM subjects WHERE code='GEN_SCI' LIMIT 1), 1, FALSE, 4, 50, 10),
    (1, 5, (SELECT id FROM subjects WHERE code='BASIC_LANG' LIMIT 1), 1, FALSE, 5, 50, 0),

    -- Secondary (Std 6-10)
    (1, 6, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 6, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 7, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 7, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 8, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 8, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 9, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 9, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 10, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 5, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 4, 70, 30),
    (1, 10, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),

    -- Higher Secondary / Electives (Std 11-12)
    (1, 11, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50),
    (1, 11, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 11, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 11, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0),
    (1, 12, (SELECT id FROM subjects WHERE code='PHY' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='CHEM' LIMIT 1), 1, FALSE, 6, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='BIO' LIMIT 1), 1, TRUE, 5, 100, 50),
    (1, 12, (SELECT id FROM subjects WHERE code='ACC' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 12, (SELECT id FROM subjects WHERE code='ECO' LIMIT 1), 1, TRUE, 4, 80, 20),
    (1, 12, (SELECT id FROM subjects WHERE code='ENG' LIMIT 1), 1, FALSE, 5, 100, 0);


INSERT INTO exam_type
(
    organization_id,
    code,
    name,
    description,
    is_active,
    is_deleted,
    created_at,
    created_by
)
VALUES

-- Major Exams
(1,'MID','Mid Term Exam','Mid session evaluation',TRUE,FALSE,NOW(),1),
(1,'FINAL','Final Exam','End term final exam',TRUE,FALSE,NOW(),1),
(1,'ANNUAL','Annual Exam','Yearly evaluation',TRUE,FALSE,NOW(),1),
(1,'SUPP','Supplementary Exam','Reattempt failed subjects',TRUE,FALSE,NOW(),1),
(1,'RET','Retake Exam','Retake full exam',TRUE,FALSE,NOW(),1),

-- Periodic Exams
(1,'UT1','Unit Test 1','First unit test',TRUE,FALSE,NOW(),1),
(1,'UT2','Unit Test 2','Second unit test',TRUE,FALSE,NOW(),1),
(1,'UT3','Unit Test 3','Third unit test',TRUE,FALSE,NOW(),1),
(1,'MT1','Monthly Test','Monthly performance test',TRUE,FALSE,NOW(),1),
(1,'WKLY','Weekly Test','Weekly short test',TRUE,FALSE,NOW(),1),

-- Internal Evaluation
(1,'INT','Internal Exam','Internal assessment',TRUE,FALSE,NOW(),1),
(1,'CLASS','Class Test','Classroom evaluation',TRUE,FALSE,NOW(),1),
(1,'ORAL','Oral Exam','Spoken evaluation',TRUE,FALSE,NOW(),1),

-- Practical Based
(1,'PRAC','Practical Exam','Hands-on practical exam',TRUE,FALSE,NOW(),1),
(1,'LAB','Lab Exam','Laboratory evaluation',TRUE,FALSE,NOW(),1),
(1,'VIVA','Viva Voce','Oral viva assessment',TRUE,FALSE,NOW(),1),

-- Special Cases
(1,'ENT','Entrance Exam','Admission test',TRUE,FALSE,NOW(),1),
(1,'MOCK','Mock Exam','Practice exam',TRUE,FALSE,NOW(),1),
(1,'SCH','Scholarship Exam','Scholarship qualification test',TRUE,FALSE,NOW(),1);


INSERT INTO exam_terms
(organization_id, name, sequence_no, academic_year_id, created_by) VALUES
(1,'First Term',1,1,1),
(1,'Mid Term',2,1,1),
(1,'Second Term',3,1,1),
(1,'Pre Final',4,1,1),
(1,'Final Term',5,1,1);



INSERT INTO assessment_types
(organization_id, code, name, description, created_by)
VALUES

-- Written Evaluations
(1,'WR','Written Exam','Traditional written paper exam',1),
(1,'MCQ','MCQ Test','Multiple choice questions based test',1),
(1,'SUB','Subjective','Long answer descriptive paper',1),
(1,'OBJ','Objective','Short answer or objective type test',1),

-- Continuous Assessment
(1,'QUIZ','Quiz','Short quiz assessment',1),
(1,'ASSIGN','Assignment','Homework or take-home task',1),
(1,'CLASS','Class Test','In-class short test',1),
(1,'WKTEST','Weekly Test','Weekly performance test',1),
(1,'UNIT','Unit Test','Unit completion test',1),

-- Practical Based
(1,'PRAC','Practical','Hands-on practical exam',1),
(1,'LAB','Lab Work','Laboratory performance assessment',1),
(1,'DEMO','Demonstration','Practical demonstration assessment',1),

-- Oral / Interactive
(1,'VIVA','Viva Voce','Oral examination',1),
(1,'ORAL','Oral Test','Spoken or verbal test',1),
(1,'PRES','Presentation','Presentation based evaluation',1),

-- Project / Coursework
(1,'PROJ','Project','Project based evaluation',1),
(1,'COURSE','Course Work','Continuous coursework assessment',1),
(1,'PORT','Portfolio','Portfolio submission assessment',1),

-- Behavior / Participation
(1,'ATT','Attendance','Marks based on attendance',1),
(1,'PART','Participation','Class participation marks',1),
(1,'DISC','Discipline','Discipline evaluation marks',1),

-- Special Evaluations
(1,'MOCK','Mock Assessment','Practice exam for preparation',1),
(1,'DIAG','Diagnostic Test','Skill assessment test',1),
(1,'SKILL','Skill Test','Skill-based evaluation',1),
(1,'PHYS','Physical Test','Physical activity assessment',1);


INSERT INTO grade_scales
(organization_id, min_percentage, max_percentage, grade, remarks, created_by)
VALUES
(1, 90.00, 100.00, 'A+', 'Outstanding', 1),
(1, 85.00, 89.99, 'A',  'Excellent', 1),
(1, 80.00, 84.99, 'A-', 'Very Good', 1),
(1, 75.00, 79.99, 'B+', 'Good', 1),
(1, 70.00, 74.99, 'B',  'Above Average', 1),
(1, 65.00, 69.99, 'B-', 'Satisfactory', 1),
(1, 60.00, 64.99, 'C+', 'Acceptable', 1),
(1, 55.00, 59.99, 'C',  'Needs Improvement', 1),
(1, 50.00, 54.99, 'D',  'Pass', 1),
(1, 0.00, 49.99, 'F',  'Fail', 1);


-- Admission Types
INSERT INTO admission_type
(id, organization_id, code, name, description, is_active, deleted, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(1, 1, 'REG', 'Regular Admission', 'Standard admission for new academic session', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(2, 1, 'LAT', 'Lateral Entry', 'Admission granted to students transferring from another institution', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(3, 1, 'TRF', 'Transfer Admission', 'Student migrated from another branch or campus', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(4, 1, 'SCH', 'Scholarship Admission', 'Admission granted under scholarship program', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(5, 1, 'SPC', 'Sports Quota', 'Admission based on sports quota eligibility', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(6, 1, 'MGMT', 'Management Quota', 'Admission under management quota', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(7, 1, 'INT', 'International Student', 'Admission for foreign or overseas students', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(8, 1, 'RADM', 'Re-Admission', 'Student rejoining after leaving previously', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(9, 1, 'COND', 'Conditional Admission', 'Admission granted with pending documents or requirements', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

(10, 1, 'WAIT', 'Waiting List Admission', 'Admission offered from waiting list after seat availability', TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL);
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




INSERT INTO exams (organization_id, academic_year_id, exam_term_id, exam_type_id, campus_id, standard_id, section_id, name, description, start_date, end_date, status)
VALUES
(1, 1, 1, 6, 1, 1, 1, 'Unit Test 1 - Section 1', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 1, 'Unit Test 2 - Section 1', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 1, 'Mid Term Exam - Section 1', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 1, 'Unit Test 3 - Section 1', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 1, 'Final Exam - Section 1', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 1, 2, 'Unit Test 1 - Section 2', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 2, 'Unit Test 2 - Section 2', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 2, 'Mid Term Exam - Section 2', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 2, 'Unit Test 3 - Section 2', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 2, 'Final Exam - Section 2', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 1, 3, 'Unit Test 1 - Section 3', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 1, 3, 'Unit Test 2 - Section 3', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 1, 3, 'Mid Term Exam - Section 3', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 1, 3, 'Unit Test 3 - Section 3', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 1, 3, 'Final Exam - Section 3', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 4, 'Unit Test 1 - Section 4', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 4, 'Unit Test 2 - Section 4', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 4, 'Mid Term Exam - Section 4', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 4, 'Unit Test 3 - Section 4', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 4, 'Final Exam - Section 4', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 5, 'Unit Test 1 - Section 5', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 5, 'Unit Test 2 - Section 5', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 5, 'Mid Term Exam - Section 5', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 5, 'Unit Test 3 - Section 5', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 5, 'Final Exam - Section 5', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 2, 6, 'Unit Test 1 - Section 6', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 2, 6, 'Unit Test 2 - Section 6', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 2, 6, 'Mid Term Exam - Section 6', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 2, 6, 'Unit Test 3 - Section 6', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 2, 6, 'Final Exam - Section 6', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 7, 'Unit Test 1 - Section 7', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 7, 'Unit Test 2 - Section 7', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 7, 'Mid Term Exam - Section 7', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 7, 'Unit Test 3 - Section 7', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 7, 'Final Exam - Section 7', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 8, 'Unit Test 1 - Section 8', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 8, 'Unit Test 2 - Section 8', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 8, 'Mid Term Exam - Section 8', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 8, 'Unit Test 3 - Section 8', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 8, 'Final Exam - Section 8', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 3, 9, 'Unit Test 1 - Section 9', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 3, 9, 'Unit Test 2 - Section 9', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 3, 9, 'Mid Term Exam - Section 9', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 3, 9, 'Unit Test 3 - Section 9', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 3, 9, 'Final Exam - Section 9', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 10, 'Unit Test 1 - Section 10', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 10, 'Unit Test 2 - Section 10', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 10, 'Mid Term Exam - Section 10', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 10, 'Unit Test 3 - Section 10', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 10, 'Final Exam - Section 10', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 11, 'Unit Test 1 - Section 11', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 11, 'Unit Test 2 - Section 11', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 11, 'Mid Term Exam - Section 11', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 11, 'Unit Test 3 - Section 11', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 11, 'Final Exam - Section 11', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 4, 12, 'Unit Test 1 - Section 12', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 4, 12, 'Unit Test 2 - Section 12', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 4, 12, 'Mid Term Exam - Section 12', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 4, 12, 'Unit Test 3 - Section 12', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 4, 12, 'Final Exam - Section 12', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 13, 'Unit Test 1 - Section 13', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 13, 'Unit Test 2 - Section 13', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 13, 'Mid Term Exam - Section 13', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 13, 'Unit Test 3 - Section 13', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 13, 'Final Exam - Section 13', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 14, 'Unit Test 1 - Section 14', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 14, 'Unit Test 2 - Section 14', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 14, 'Mid Term Exam - Section 14', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 14, 'Unit Test 3 - Section 14', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 14, 'Final Exam - Section 14', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 1, 5, 15, 'Unit Test 1 - Section 15', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 1, 5, 15, 'Unit Test 2 - Section 15', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 1, 5, 15, 'Mid Term Exam - Section 15', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 1, 5, 15, 'Unit Test 3 - Section 15', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 1, 5, 15, 'Final Exam - Section 15', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 16, 'Unit Test 1 - Section 16', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 16, 'Unit Test 2 - Section 16', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 16, 'Mid Term Exam - Section 16', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 16, 'Unit Test 3 - Section 16', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 16, 'Final Exam - Section 16', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 17, 'Unit Test 1 - Section 17', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 17, 'Unit Test 2 - Section 17', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 17, 'Mid Term Exam - Section 17', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 17, 'Unit Test 3 - Section 17', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 17, 'Final Exam - Section 17', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 6, 18, 'Unit Test 1 - Section 18', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 6, 18, 'Unit Test 2 - Section 18', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 6, 18, 'Mid Term Exam - Section 18', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 6, 18, 'Unit Test 3 - Section 18', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 6, 18, 'Final Exam - Section 18', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 19, 'Unit Test 1 - Section 19', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 19, 'Unit Test 2 - Section 19', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 19, 'Mid Term Exam - Section 19', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 19, 'Unit Test 3 - Section 19', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 19, 'Final Exam - Section 19', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 20, 'Unit Test 1 - Section 20', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 20, 'Unit Test 2 - Section 20', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 20, 'Mid Term Exam - Section 20', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 20, 'Unit Test 3 - Section 20', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 20, 'Final Exam - Section 20', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 7, 21, 'Unit Test 1 - Section 21', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 7, 21, 'Unit Test 2 - Section 21', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 7, 21, 'Mid Term Exam - Section 21', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 7, 21, 'Unit Test 3 - Section 21', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 7, 21, 'Final Exam - Section 21', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 22, 'Unit Test 1 - Section 22', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 22, 'Unit Test 2 - Section 22', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 22, 'Mid Term Exam - Section 22', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 22, 'Unit Test 3 - Section 22', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 22, 'Final Exam - Section 22', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 23, 'Unit Test 1 - Section 23', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 23, 'Unit Test 2 - Section 23', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 23, 'Mid Term Exam - Section 23', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 23, 'Unit Test 3 - Section 23', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 23, 'Final Exam - Section 23', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 8, 24, 'Unit Test 1 - Section 24', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 8, 24, 'Unit Test 2 - Section 24', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 8, 24, 'Mid Term Exam - Section 24', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 8, 24, 'Unit Test 3 - Section 24', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 8, 24, 'Final Exam - Section 24', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 25, 'Unit Test 1 - Section 25', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 25, 'Unit Test 2 - Section 25', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 25, 'Mid Term Exam - Section 25', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 25, 'Unit Test 3 - Section 25', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 25, 'Final Exam - Section 25', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 26, 'Unit Test 1 - Section 26', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 26, 'Unit Test 2 - Section 26', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 26, 'Mid Term Exam - Section 26', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 26, 'Unit Test 3 - Section 26', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 26, 'Final Exam - Section 26', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 9, 27, 'Unit Test 1 - Section 27', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 9, 27, 'Unit Test 2 - Section 27', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 9, 27, 'Mid Term Exam - Section 27', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 9, 27, 'Unit Test 3 - Section 27', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 9, 27, 'Final Exam - Section 27', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 28, 'Unit Test 1 - Section 28', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 28, 'Unit Test 2 - Section 28', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 28, 'Mid Term Exam - Section 28', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 28, 'Unit Test 3 - Section 28', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 28, 'Final Exam - Section 28', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 29, 'Unit Test 1 - Section 29', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 29, 'Unit Test 2 - Section 29', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 29, 'Mid Term Exam - Section 29', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 29, 'Unit Test 3 - Section 29', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 29, 'Final Exam - Section 29', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT'),
(1, 1, 1, 6, 2, 10, 30, 'Unit Test 1 - Section 30', 'First unit test', '2025-05-15', '2025-05-20', 'PUBLISHED'),
(1, 1, 1, 7, 2, 10, 30, 'Unit Test 2 - Section 30', 'Second unit test', '2025-08-15', '2025-08-20', 'PUBLISHED'),
(1, 1, 2, 1, 2, 10, 30, 'Mid Term Exam - Section 30', 'Mid term evaluation', '2025-10-15', '2025-10-30', 'PUBLISHED'),
(1, 1, 3, 8, 2, 10, 30, 'Unit Test 3 - Section 30', 'Third unit test', '2026-01-15', '2026-01-20', 'SCHEDULED'),
(1, 1, 5, 2, 2, 10, 30, 'Final Exam - Section 30', 'Final term assessment', '2026-03-15', '2026-03-30', 'DRAFT');




SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE standard_subjects;
SET FOREIGN_KEY_CHECKS = 1;

-- ==========================================
-- Downtown Campus
-- ==========================================
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Downtown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Downtown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Uptown Campus
-- ==========================================
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Uptown Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Uptown Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Riverside Campus
-- ==========================================
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Riverside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Riverside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Hilltop Campus
-- ==========================================
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Hilltop Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Hilltop Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Greenfield Campus
-- ==========================================
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Greenfield Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Greenfield Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Seaside Campus
-- ==========================================
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Seaside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Seaside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Central Campus
-- ==========================================
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Central Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Central Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Lakeside Campus
-- ==========================================
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Lakeside Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Lakeside Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Sunrise Campus
-- ==========================================
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Sunrise Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Sunrise Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- ==========================================
-- Maple Campus
-- ==========================================
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 1st Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '1st Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 2nd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '2nd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 3rd Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '3rd Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 4th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '4th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');

-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ENG' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ENG');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'URD' LIMIT 1),
    1,
    FALSE, 4, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'URD');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'BASIC_MATH' LIMIT 1),
    1,
    FALSE, 5, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'BASIC_MATH');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GEN_SCI' LIMIT 1),
    1,
    FALSE, 4, 75, 25
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GEN_SCI');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'ISL' LIMIT 1),
    1,
    FALSE, 3, 100, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'ISL');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'GK' LIMIT 1),
    1,
    FALSE, 2, 50, 0
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'GK');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'PE' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'PE');
-- standard_subjects for Maple Campus - 5th Grade
INSERT INTO standard_subjects (organization_id, standard_id, subject_id, academic_year_id, is_optional, weekly_hours, theory_marks, practical_marks)
SELECT
    1,
    (SELECT id FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1) LIMIT 1),
    (SELECT id FROM subjects WHERE code = 'DRAW' LIMIT 1),
    1,
    FALSE, 2, 0, 50
WHERE EXISTS (SELECT 1 FROM standards WHERE standard_name = '5th Grade' AND campus_id = (SELECT id FROM campuses WHERE campus_name = 'Maple Campus' LIMIT 1))
  AND EXISTS (SELECT 1 FROM subjects WHERE code = 'DRAW');



-- =============================================
-- TEST DATA FOR EXAM SUBJECTS AND ATTENDANCE
-- Coverage: 30 Sections, 150 Students, All Subjects
-- =============================================

-- 1. Populate exam_subjects
-- We will assign 3 subjects to each Mid Term/Final and 1 subject to Unit Tests.
-- Targeting sections 1 to 30 as defined in Final_SMS_DATA.sql

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
-- Standard 1 (Sections 1-3)
SELECT 1, e.id, s.id, 50, 20, '2025-05-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'ENG'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id = 1;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 50, 20, '2025-08-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'URD'
WHERE e.name LIKE 'Unit Test 2 - Section %' AND e.standard_id = 1;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 100, 40, '2025-10-20', '09:00:00', '12:00:00', 1
FROM exams e
JOIN subjects s ON s.code IN ('ENG', 'URD', 'BASIC_MATH')
WHERE e.name LIKE 'Mid Term Exam - Section %' AND e.standard_id = 1;

-- Standard 2-5 (Primary)
INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 50, 20, '2025-05-18', '09:00:00', '10:30:00', 1
FROM exams e
JOIN subjects s ON s.code = 'BASIC_MATH'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id BETWEEN 2 AND 5;

-- Standard 6-10 (Secondary)
INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 70, 30, '2025-05-20', '11:00:00', '13:00:00', 1
FROM exams e
JOIN subjects s ON s.code = 'PHY'
WHERE e.name LIKE 'Unit Test 1 - Section %' AND e.standard_id BETWEEN 6 AND 10;

INSERT INTO exam_subjects (organization_id, exam_id, subject_id, total_marks, passing_marks, exam_date, start_time, end_time, created_by)
SELECT 1, e.id, s.id, 100, 40, '2025-10-25', '09:00:00', '12:00:00', 1
FROM exams e
JOIN subjects s ON s.code IN ('ENG', 'PHY', 'CHEM')
WHERE e.name LIKE 'Mid Term Exam - Section %' AND e.standard_id BETWEEN 6 AND 10;

-- 2. Populate student_exam_attendance
-- We will mark attendance for all students in the corresponding sections
-- Status randomization: mostly PRESENT, some ABSENT/UFM

INSERT INTO student_exam_attendance (organization_id, exam_subject_id, student_id, status, created_by)
SELECT 
    1, 
    es.id, 
    s.id,
    CASE 
        WHEN RAND() > 0.1 THEN 'PRESENT' 
        WHEN RAND() > 0.05 THEN 'ABSENT'
        ELSE 'UFM' 
    END,
    1
FROM exam_subjects es
JOIN exams e ON es.exam_id = e.id
JOIN students s ON s.campus_id = e.campus_id 
    AND s.standard_id = e.standard_id 
    AND s.section_id = e.section_id
WHERE e.status != 'DRAFT';

-- Verification counts
SELECT 'Exam Subjects Created' as Category, COUNT(*) as Count FROM exam_subjects;
SELECT 'Attendance Records Created' as Category, COUNT(*) as Count FROM student_exam_attendance;








-- =============================================
-- TEST DATA FOR EXAM WEIGHTAGE
-- Coverage: All Standard Subjects for Academic Year 1
-- Distribution: 10% (T1), 25% (Mid), 10% (T2), 15% (Pre), 40% (Final)
-- =============================================

-- Populate exam_weightage
-- Linking each subject to all 5 terms with specific weightages

INSERT INTO exam_weightage (
    organization_id, 
    academic_year_id, 
    standard_subject_id, 
    exam_term_id, 
    weight_percentage, 
    created_by
)
SELECT 
    ss.organization_id, 
    ss.academic_year_id, 
    ss.id as standard_subject_id, 
    et.id as exam_term_id,
    -- Weight Distribution Logic
    CASE 
        WHEN et.sequence_no = 1 THEN 10.00 -- First Term
        WHEN et.sequence_no = 2 THEN 25.00 -- Mid Term
        WHEN et.sequence_no = 3 THEN 10.00 -- Second Term
        WHEN et.sequence_no = 4 THEN 15.00 -- Pre Final
        WHEN et.sequence_no = 5 THEN 40.00 -- Final Term
        ELSE 0 
    END as weight_percentage,
    1
FROM standard_subjects ss
CROSS JOIN exam_terms et
WHERE ss.academic_year_id = 1 
  AND et.academic_year_id = 1
  AND ss.is_deleted = FALSE;

-- Verification counts
SELECT 'Weightage Records Created' as Category, COUNT(*) as Count FROM exam_weightage;
SELECT 'Total Weightage Per Subject (Check for 100%)' as Category, standard_subject_id, SUM(weight_percentage) as Total 
FROM exam_weightage 
GROUP BY standard_subject_id;
