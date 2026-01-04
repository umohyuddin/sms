INSERT INTO system_users (username, email, phone, password_hash, is_active, is_verified)
VALUES ('admin.user', 'admin@gmail.com', '03001234567',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, TRUE),

       ('teacher.user', 'teacher@example.com', '03007654321',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE),

       ('student.user', 'student@example.com', '03111223344',
        '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y', TRUE, FALSE);


-- ============================================
-- Countries Table Insertions
-- Purpose: Populate the 'country' table with country codes, ISO codes, phone codes.
-- Used for student profiles, employee profiles, institute addresses, and general lookups.
-- ============================================


INSERT INTO country (country_code, country_name, iso_code, phone_code) VALUES
('AF','Afghanistan','AFG','+93'),
('AL','Albania','ALB','+355'),
('DZ','Algeria','DZA','+213'),
('AD','Andorra','AND','+376'),
('AO','Angola','AGO','+244'),
('AR','Argentina','ARG','+54'),
('AM','Armenia','ARM','+374'),
('AU','Australia','AUS','+61'),
('AT','Austria','AUT','+43'),
('AZ','Azerbaijan','AZE','+994'),
('BH','Bahrain','BHR','+973'),
('BD','Bangladesh','BGD','+880'),
('BY','Belarus','BLR','+375'),
('BE','Belgium','BEL','+32'),
('BZ','Belize','BLZ','+501'),
('BJ','Benin','BEN','+229'),
('BT','Bhutan','BTN','+975'),
('BO','Bolivia','BOL','+591'),
('BA','Bosnia and Herzegovina','BIH','+387'),
('BW','Botswana','BWA','+267'),
('BR','Brazil','BRA','+55'),
('BN','Brunei','BRN','+673'),
('BG','Bulgaria','BGR','+359'),
('BF','Burkina Faso','BFA','+226'),
('BI','Burundi','BDI','+257'),
('KH','Cambodia','KHM','+855'),
('CM','Cameroon','CMR','+237'),
('CA','Canada','CAN','+1'),
('CV','Cape Verde','CPV','+238'),
('CF','Central African Republic','CAF','+236'),
('TD','Chad','TCD','+235'),
('CL','Chile','CHL','+56'),
('CN','China','CHN','+86'),
('CO','Colombia','COL','+57'),
('KM','Comoros','COM','+269'),
('CG','Congo','COG','+242'),
('CR','Costa Rica','CRI','+506'),
('HR','Croatia','HRV','+385'),
('CU','Cuba','CUB','+53'),
('CY','Cyprus','CYP','+357'),
('CZ','Czech Republic','CZE','+420'),
('DK','Denmark','DNK','+45'),
('DJ','Djibouti','DJI','+253'),
('DO','Dominican Republic','DOM','+1'),
('EC','Ecuador','ECU','+593'),
('EG','Egypt','EGY','+20'),
('SV','El Salvador','SLV','+503'),
('EE','Estonia','EST','+372'),
('ET','Ethiopia','ETH','+251'),
('FI','Finland','FIN','+358'),
('FR','France','FRA','+33'),
('GA','Gabon','GAB','+241'),
('GE','Georgia','GEO','+995'),
('DE','Germany','DEU','+49'),
('GH','Ghana','GHA','+233'),
('GR','Greece','GRC','+30'),
('GT','Guatemala','GTM','+502'),
('GN','Guinea','GIN','+224'),
('HT','Haiti','HTI','+509'),
('HN','Honduras','HND','+504'),
('HK','Hong Kong','HKG','+852'),
('HU','Hungary','HUN','+36'),
('IS','Iceland','ISL','+354'),
('IN','India','IND','+91'),
('ID','Indonesia','IDN','+62'),
('IR','Iran','IRN','+98'),
('IQ','Iraq','IRQ','+964'),
('IE','Ireland','IRL','+353'),
('IL','Israel','ISR','+972'),
('IT','Italy','ITA','+39'),
('JM','Jamaica','JAM','+1'),
('JP','Japan','JPN','+81'),
('JO','Jordan','JOR','+962'),
('KZ','Kazakhstan','KAZ','+7'),
('KE','Kenya','KEN','+254'),
('KW','Kuwait','KWT','+965'),
('KG','Kyrgyzstan','KGZ','+996'),
('LA','Laos','LAO','+856'),
('LV','Latvia','LVA','+371'),
('LB','Lebanon','LBN','+961'),
('LY','Libya','LBY','+218'),
('LT','Lithuania','LTU','+370'),
('LU','Luxembourg','LUX','+352'),
('MY','Malaysia','MYS','+60'),
('MV','Maldives','MDV','+960'),
('ML','Mali','MLI','+223'),
('MT','Malta','MLT','+356'),
('MX','Mexico','MEX','+52'),
('MN','Mongolia','MNG','+976'),
('MA','Morocco','MAR','+212'),
('MM','Myanmar','MMR','+95'),
('NP','Nepal','NPL','+977'),
('NL','Netherlands','NLD','+31'),
('NZ','New Zealand','NZL','+64'),
('NG','Nigeria','NGA','+234'),
('NO','Norway','NOR','+47'),
('OM','Oman','OMN','+968'),
('PK','Pakistan','PAK','+92'),
('PH','Philippines','PHL','+63'),
('PL','Poland','POL','+48'),
('PT','Portugal','PRT','+351'),
('QA','Qatar','QAT','+974'),
('RO','Romania','ROU','+40'),
('RU','Russia','RUS','+7'),
('SA','Saudi Arabia','SAU','+966'),
('SG','Singapore','SGP','+65'),
('ZA','South Africa','ZAF','+27'),
('KR','South Korea','KOR','+82'),
('ES','Spain','ESP','+34'),
('LK','Sri Lanka','LKA','+94'),
('SE','Sweden','SWE','+46'),
('CH','Switzerland','CHE','+41'),
('TH','Thailand','THA','+66'),
('TR','Turkey','TUR','+90'),
('AE','United Arab Emirates','ARE','+971'),
('UA','Ukraine','UKR','+380'),
('GB','United Kingdom','GBR','+44'),
('US','United States','USA','+1'),
('UY','Uruguay','URY','+598'),
('UZ','Uzbekistan','UZB','+998'),
('VN','Vietnam','VNM','+84'),
('YE','Yemen','YEM','+967'),
('ZM','Zambia','ZMB','+260'),
('ZW','Zimbabwe','ZWE','+263');

-- ============================================
-- Provinces Table Insertions
-- Purpose: Populate the 'provinces' table with administrative regions for each country.
-- Used for address selection in institute, student, and employee forms.
-- ============================================

-- Pakistan Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(98, 'Punjab', 'PB', TRUE, 1, 1),
(98, 'Sindh', 'SD', TRUE, 1, 1),
(98, 'Khyber Pakhtunkhwa', 'KP', TRUE, 1, 1),
(98, 'Balochistan', 'BL', TRUE, 1, 1),
(98, 'Islamabad Capital Territory', 'ICT', TRUE, 1, 1),
(98, 'Gilgit-Baltistan', 'GB', TRUE, 1, 1),
(98, 'Azad Jammu & Kashmir', 'AJK', TRUE, 1, 1);

-- Saudi Arabia Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(105, 'Riyadh', 'RD', TRUE, 1, 1),
(105, 'Makkah', 'MK', TRUE, 1, 1),
(105, 'Madinah', 'MD', TRUE, 1, 1),
(105, 'Eastern Province', 'EP', TRUE, 1, 1),
(105, 'Qassim', 'QA', TRUE, 1, 1),
(105, 'Ha’il', 'HL', TRUE, 1, 1),
(105, 'Tabuk', 'TB', TRUE, 1, 1),
(105, 'Northern Borders', 'NB', TRUE, 1, 1),
(105, 'Jazan', 'JZ', TRUE, 1, 1),
(105, 'Najran', 'NJ', TRUE, 1, 1),
(105, 'Al Bahah', 'BH', TRUE, 1, 1),
(105, 'Al Jawf', 'JW', TRUE, 1, 1),
(105, 'Asir', 'AS', TRUE, 1, 1);

-- UAE Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(115, 'Abu Dhabi', 'AD', TRUE, 1, 1),
(115, 'Dubai', 'DU', TRUE, 1, 1),
(115, 'Sharjah', 'SH', TRUE, 1, 1),
(115, 'Ajman', 'AJ', TRUE, 1, 1),
(115, 'Umm Al Quwain', 'UAQ', TRUE, 1, 1),
(115, 'Ras Al Khaimah', 'RAK', TRUE, 1, 1),
(115, 'Fujairah', 'FJ', TRUE, 1, 1);

-- India Provinces
INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by) VALUES
(64, 'Andhra Pradesh', 'AP', TRUE, 1, 1),
(64, 'Arunachal Pradesh', 'AR', TRUE, 1, 1),
(64, 'Assam', 'AS', TRUE, 1, 1),
(64, 'Bihar', 'BR', TRUE, 1, 1),
(64, 'Chhattisgarh', 'CG', TRUE, 1, 1),
(64, 'Goa', 'GA', TRUE, 1, 1),
(64, 'Gujarat', 'GJ', TRUE, 1, 1),
(64, 'Haryana', 'HR', TRUE, 1, 1),
(64, 'Himachal Pradesh', 'HP', TRUE, 1, 1),
(64, 'Jharkhand', 'JH', TRUE, 1, 1),
(64, 'Karnataka', 'KA', TRUE, 1, 1),
(64, 'Kerala', 'KL', TRUE, 1, 1),
(64, 'Madhya Pradesh', 'MP', TRUE, 1, 1),
(64, 'Maharashtra', 'MH', TRUE, 1, 1),
(64, 'Manipur', 'MN', TRUE, 1, 1),
(64, 'Meghalaya', 'ML', TRUE, 1, 1),
(64, 'Mizoram', 'MZ', TRUE, 1, 1),
(64, 'Nagaland', 'NL', TRUE, 1, 1),
(64, 'Odisha', 'OR', TRUE, 1, 1),
(64, 'Rajasthan', 'RJ', TRUE, 1, 1),
(64, 'Sikkim', 'SK', TRUE, 1, 1),
(64, 'Tamil Nadu', 'TN', TRUE, 1, 1),
(64, 'Telangana', 'TS', TRUE, 1, 1),
(64, 'Tripura', 'TR', TRUE, 1, 1),
(64, 'Uttar Pradesh', 'UP', TRUE, 1, 1),
(64, 'Uttarakhand', 'UT', TRUE, 1, 1),
(64, 'West Bengal', 'WB', TRUE, 1, 1),
(64, 'Delhi', 'DL', TRUE, 1, 1),
(64, 'Jammu and Kashmir', 'JK', TRUE, 1, 1),
(64, 'Ladakh', 'LA', TRUE, 1, 1),
(64, 'Puducherry', 'PY', TRUE, 1, 1),
(64, 'Chandigarh', 'CH', TRUE, 1, 1),
(64, 'Daman and Diu', 'DD', TRUE, 1, 1),
(64, 'Dadra and Nagar Haveli', 'DN', TRUE, 1, 1),
(64, 'Lakshadweep', 'LD', TRUE, 1, 1),
(64, 'Andaman and Nicobar Islands', 'AN', TRUE, 1, 1);

-- ============================================
-- Cities Table Insertions
-- Purpose: Populate the 'cities' table with cities for each province.
-- Used for address selection in forms for students, employees, and campuses.
-- ============================================

-- Pakistan Cities
-- Punjab
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(1, 'Lahore', 'LHE', TRUE, 1, 1, NOW()),
(1, 'Faisalabad', 'FSD', TRUE, 1, 1, NOW()),
(1, 'Rawalpindi', 'RWP', TRUE, 1, 1, NOW()),
(1, 'Multan', 'MLN', TRUE, 1, 1, NOW());

-- Sindh
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(2, 'Karachi', 'KHI', TRUE, 1, 1, NOW()),
(2, 'Hyderabad', 'HYD', TRUE, 1, 1, NOW()),
(2, 'Sukkur', 'SUK', TRUE, 1, 1, NOW()),
(2, 'Larkana', 'LRK', TRUE, 1, 1, NOW());

-- Khyber Pakhtunkhwa
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(3, 'Peshawar', 'PEW', TRUE, 1, 1, NOW()),
(3, 'Mardan', 'MRD', TRUE, 1, 1, NOW()),
(3, 'Abbottabad', 'ABT', TRUE, 1, 1, NOW()),
(3, 'Swat', 'SWT', TRUE, 1, 1, NOW());

-- Balochistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(4, 'Quetta', 'QTA', TRUE, 1, 1, NOW()),
(4, 'Gwadar', 'GWD', TRUE, 1, 1, NOW()),
(4, 'Sibi', 'SBI', TRUE, 1, 1, NOW()),
(4, 'Zhob', 'ZHB', TRUE, 1, 1, NOW());

-- Islamabad Capital Territory
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(5, 'Islamabad', 'ISB', TRUE, 1, 1, NOW());

-- Gilgit-Baltistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(6, 'Gilgit', 'GIL', TRUE, 1, 1, NOW()),
(6, 'Skardu', 'SKD', TRUE, 1, 1, NOW());

-- Azad Jammu & Kashmir
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at) VALUES
(7, 'Muzaffarabad', 'MZD', TRUE, 1, 1, NOW()),
(7, 'Mirpur', 'MIR', TRUE, 1, 1, NOW()),
(7, 'Kotli', 'KOT', TRUE, 1, 1, NOW());

