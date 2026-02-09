
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


INSERT INTO education_boards
(code, name, country_id, description, is_active, is_deleted)
VALUES
-- Federal
('FBISE', 'Federal Board of Intermediate and Secondary Education', 98,
 'Federal education board responsible for SSC and HSSC examinations across Pakistan and overseas.', TRUE, FALSE),

-- Punjab Boards
('BISE_LAHORE', 'Board of Intermediate and Secondary Education Lahore', 98,
 'Provincial examination board for Lahore region.', TRUE, FALSE),

('BISE_FAISALABAD', 'Board of Intermediate and Secondary Education Faisalabad', 98,
 'Provincial examination board for Faisalabad region.', TRUE, FALSE),

('BISE_GUJRANWALA', 'Board of Intermediate and Secondary Education Gujranwala', 98,
 'Provincial examination board for Gujranwala region.', TRUE, FALSE),

('BISE_MULTAN', 'Board of Intermediate and Secondary Education Multan', 98,
 'Provincial examination board for Multan region.', TRUE, FALSE),

('BISE_RAWALPINDI', 'Board of Intermediate and Secondary Education Rawalpindi', 98,
 'Provincial examination board for Rawalpindi region.', TRUE, FALSE),

('BISE_SARGODHA', 'Board of Intermediate and Secondary Education Sargodha', 98,
 'Provincial examination board for Sargodha region.', TRUE, FALSE),

('BISE_BAHWALPUR', 'Board of Intermediate and Secondary Education Bahawalpur', 98,
 'Provincial examination board for Bahawalpur region.', TRUE, FALSE),

('BISE_DG_KHAN', 'Board of Intermediate and Secondary Education Dera Ghazi Khan', 98,
 'Provincial examination board for Dera Ghazi Khan region.', TRUE, FALSE),

('BISE_SAHIWAL', 'Board of Intermediate and Secondary Education Sahiwal', 98,
 'Provincial examination board for Sahiwal region.', TRUE, FALSE),

-- Sindh Boards
('BSEK', 'Board of Secondary Education Karachi', 98,
 'Secondary education examination board for Karachi.', TRUE, FALSE),

('BIEK', 'Board of Intermediate Education Karachi', 98,
 'Intermediate education examination board for Karachi.', TRUE, FALSE),

('BISE_HYDERABAD', 'Board of Intermediate and Secondary Education Hyderabad', 98,
 'Provincial examination board for Hyderabad region.', TRUE, FALSE),

('BISE_SUKKUR', 'Board of Intermediate and Secondary Education Sukkur', 98,
 'Provincial examination board for Sukkur region.', TRUE, FALSE),

('BISE_LARKANA', 'Board of Intermediate and Secondary Education Larkana', 98,
 'Provincial examination board for Larkana region.', TRUE, FALSE),

('BISE_MIRPURKHAS', 'Board of Intermediate and Secondary Education Mirpurkhas', 98,
 'Provincial examination board for Mirpurkhas region.', TRUE, FALSE),

('AKU_EB', 'Aga Khan University Examination Board', 98,
 'Private national examination board recognized across Pakistan.', TRUE, FALSE),

-- Khyber Pakhtunkhwa Boards
('BISE_PESHAWAR', 'Board of Intermediate and Secondary Education Peshawar', 98,
 'Provincial examination board for Peshawar region.', TRUE, FALSE),

('BISE_ABBOTABAD', 'Board of Intermediate and Secondary Education Abbottabad', 98,
 'Provincial examination board for Abbottabad region.', TRUE, FALSE),

('BISE_MARDAN', 'Board of Intermediate and Secondary Education Mardan', 98,
 'Provincial examination board for Mardan region.', TRUE, FALSE),

('BISE_BANNU', 'Board of Intermediate and Secondary Education Bannu', 98,
 'Provincial examination board for Bannu region.', TRUE, FALSE),

('BISE_SWAT', 'Board of Intermediate and Secondary Education Swat', 98,
 'Provincial examination board for Swat region.', TRUE, FALSE),

('BISE_MALAKAND', 'Board of Intermediate and Secondary Education Malakand', 98,
 'Provincial examination board for Malakand region.', TRUE, FALSE),

('BISE_KOHAT', 'Board of Intermediate and Secondary Education Kohat', 98,
 'Provincial examination board for Kohat region.', TRUE, FALSE),

('BISE_DI_KHAN', 'Board of Intermediate and Secondary Education Dera Ismail Khan', 98,
 'Provincial examination board for Dera Ismail Khan region.', TRUE, FALSE),

-- Balochistan Boards
('BISE_QUETTA', 'Board of Intermediate and Secondary Education Quetta', 98,
 'Provincial examination board for Quetta region.', TRUE, FALSE),

('BISE_TURBAT', 'Board of Intermediate and Secondary Education Turbat', 98,
 'Regional examination board for Turbat region.', TRUE, FALSE),

('BISE_ZHOB', 'Board of Intermediate and Secondary Education Zhob', 98,
 'Regional examination board for Zhob region.', TRUE, FALSE),

-- AJK & GB
('BISE_AJK', 'Board of Intermediate and Secondary Education Azad Jammu and Kashmir', 98,
 'Examination board for Azad Jammu and Kashmir.', TRUE, FALSE),

('BISE_GB', 'Board of Intermediate and Secondary Education Gilgit Baltistan', 98,
 'Examination board for Gilgit-Baltistan region.', TRUE, FALSE);

-- ============================================
-- Provinces Table Insertions
-- Purpose: Populate the 'provinces' table with administrative regions for each country.
-- Used for address selection in institute, student, and employee forms.
-- ============================================

-- Pakistan Provinces
-- ============================================
-- Update Pakistan Provinces
-- ============================================

INSERT INTO provinces (country_id, name, code, is_active, created_by, updated_by)
VALUES
(98, 'Punjab', 'PB', TRUE, 1, 1),
(98, 'Sindh', 'SD', TRUE, 1, 1),
(98, 'Khyber Pakhtunkhwa', 'KP', TRUE, 1, 1),
(98, 'Balochistan', 'BL', TRUE, 1, 1),
(98, 'Islamabad Capital Territory', 'ICT', TRUE, 1, 1),
(98, 'Gilgit-Baltistan', 'GB', TRUE, 1, 1),
(98, 'Azad Jammu & Kashmir', 'AJK', TRUE, 1, 1)
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by);

-- ============================================
-- Update Pakistan Cities
-- ============================================

-- Punjab
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(1, 'Lahore', 'LHE', TRUE, 1, 1, NOW()),
(1, 'Faisalabad', 'FSD', TRUE, 1, 1, NOW()),
(1, 'Rawalpindi', 'RWP', TRUE, 1, 1, NOW()),
(1, 'Multan', 'MLN', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Sindh
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(2, 'Karachi', 'KHI', TRUE, 1, 1, NOW()),
(2, 'Hyderabad', 'HYD', TRUE, 1, 1, NOW()),
(2, 'Sukkur', 'SUK', TRUE, 1, 1, NOW()),
(2, 'Larkana', 'LRK', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Khyber Pakhtunkhwa
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(3, 'Peshawar', 'PEW', TRUE, 1, 1, NOW()),
(3, 'Mardan', 'MRD', TRUE, 1, 1, NOW()),
(3, 'Abbottabad', 'ABT', TRUE, 1, 1, NOW()),
(3, 'Swat', 'SWT', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Balochistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(4, 'Quetta', 'QTA', TRUE, 1, 1, NOW()),
(4, 'Gwadar', 'GWD', TRUE, 1, 1, NOW()),
(4, 'Sibi', 'SBI', TRUE, 1, 1, NOW()),
(4, 'Zhob', 'ZHB', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Islamabad Capital Territory
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(5, 'Islamabad', 'ISB', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Gilgit-Baltistan
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(6, 'Gilgit', 'GIL', TRUE, 1, 1, NOW()),
(6, 'Skardu', 'SKD', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);

-- Azad Jammu & Kashmir
INSERT INTO cities (province_id, name, code, is_active, created_by, updated_by, created_at)
VALUES
(7, 'Muzaffarabad', 'MZD', TRUE, 1, 1, NOW()),
(7, 'Mirpur', 'MIR', TRUE, 1, 1, NOW()),
(7, 'Kotli', 'KOT', TRUE, 1, 1, NOW())
ON DUPLICATE KEY UPDATE
name = VALUES(name),
code = VALUES(code),
is_active = VALUES(is_active),
updated_by = VALUES(updated_by),
created_at = VALUES(created_at);




-- ============================================================
-- Sample Data: Institutes
-- This dataset seeds the 'institutes' table with example
-- educational organizations. These entries are used to attach
-- campuses, academic years, users, fee structures, and other
-- modules within the system.
-- ============================================================
INSERT INTO institutes
(id, name, address, contact_number, email, website, tagline, logo_url,
 established_date, country_id, province_id, city_id, created_at, updated_at)
VALUES
(1, 'Smart Solutions School',
 '123 Main Street, Lahore',
 '+92-300-1234567',
 'info@smartsolutions.edu',
 'https://www.smartsolutions.edu',
 'Excellence in Education',
 NULL,
 '2005-08-15',
 98, 1, 1,
 NOW(), NOW());
-- ============================================================
-- Sample Data: Admission Types
-- This section populates the 'admission_type' table with a
-- predefined list of admission categories typically used in
-- school management systems. These records are intended to
-- standardize the process of student enrollment, fee
-- management, and reporting across different modules such as
-- student registration, class assignment, scholarship
-- management, and special programs.
-- ============================================================
INSERT INTO institute_social_links(institute_id, platform, url, is_deleted, created_by)VALUES
(1, 'Facebook',  'https://www.facebook.com/institute1', FALSE, 1),
(1, 'Instagram', 'https://www.instagram.com/institute1', FALSE, 1),
(1, 'LinkedIn',  'https://www.linkedin.com/company/institute1', FALSE, 1),
(1, 'YouTube',   'https://www.youtube.com/@institute1', FALSE, 1),
(1, 'Twitter',   'https://twitter.com/institute1', FALSE, 1);


INSERT INTO admission_type (organization_id, code, name, description, is_active)
VALUES (1, 'NEW_ADMISSION', 'New Admission / Fresh Admission', 'Student joining the school for the first time.', TRUE),
       (1, 'TRANSFER', 'Transfer Admission', 'Student transferring from another school.', TRUE),
       (1, 'READMISSION', 'Re-admission / Returning Student', 'Student returning after leaving the school.', TRUE),
       (1, 'LATERAL_ENTRY', 'Lateral Entry / Direct Admission', 'Student joining a higher grade directly.', TRUE),
       (1, 'SCHOLARSHIP', 'Scholarship / Concession Admission', 'Admission with full or partial fee waiver.', TRUE),
       (1, 'MANAGEMENT', 'Management / Special Admission', 'Admission under management quota.', TRUE),
       (1, 'EARLY', 'Early Admission', 'Admission before the academic session starts.', TRUE),
       (1, 'LATE', 'Late Admission', 'Admission after the academic session has started.', TRUE),
       (1, 'INTERNATIONAL', 'International / Expat Admission', 'Students from foreign countries.', TRUE),
       (1, 'SPECIAL_NEEDS', 'Special Needs Admission', 'Students requiring special assistance.', TRUE),
       (1, 'ONLINE', 'Online / Distance Learning Admission', 'Admission for online programs.', TRUE),
       (1, 'SIBLING', 'Sibling Admission', 'Admission given when a sibling is already enrolled.', TRUE),
       (1, 'STAFF_WARD', 'Staff / Employee Ward Admission', 'Children of school staff may get special consideration.', TRUE),
       (1, 'MERIT', 'Merit-based Admission', 'Admission based purely on exam/test performance.', TRUE),
       (1, 'MID_YEAR', 'Late Entry Mid-Year', 'Students joining mid-session due to relocation or other reasons.', TRUE);

-- ============================================================
-- Lookup Data: Currencies
-- ============================================================
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

-- ============================================================
-- Lookup Data: Education Levels
-- ============================================================
INSERT INTO education_levels (code, name, is_active, is_deleted, created_at, created_by) VALUES
('PS', 'Early Childhood / Pre-Primary Education', TRUE, FALSE, NOW(), 1),
('P', 'Primary / Elementary Education', TRUE, FALSE, NOW(), 1),
('M', 'Lower Secondary / Middle Education', TRUE, FALSE, NOW(), 1),
('S', 'Upper Secondary / High School', TRUE, FALSE, NOW(), 1),
('HS', 'Post-Secondary Non-Tertiary', TRUE, FALSE, NOW(), 1),
('UG', 'Short-Cycle Tertiary / Undergraduate', TRUE, FALSE, NOW(), 1),
('PG', 'Bachelor / First Tertiary Degree', TRUE, FALSE, NOW(), 1),
('PG2', 'Master / Second Tertiary Degree', TRUE, FALSE, NOW(), 1),
('PH', 'Doctoral / Third Tertiary Degree', TRUE, FALSE, NOW(), 1),
('VT', 'Vocational / Technical Education', TRUE, FALSE, NOW(), 1),
('AE', 'Adult / Continuing Education', TRUE, FALSE, NOW(), 1);

-- ============================================================
-- Lookup Data: Facility Types
-- ============================================================
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


INSERT INTO academic_years (name, code, start_date, end_date, total_months, is_current, status, remarks, is_locked, locked_at, locked_by, organization_id, created_at, created_by, updated_at, updated_by)
VALUES
('2022-2023', 'AY-2022-23', '2022-08-01', '2023-07-31', TIMESTAMPDIFF(MONTH, '2022-08-01', '2023-07-31') + 1, FALSE, 'ARCHIVED', 'Completed academic year', TRUE, NOW(), 1, 1, NOW(), 1, NOW(), 1),
('2023-2024', 'AY-2023-24', '2023-08-01', '2024-07-31', TIMESTAMPDIFF(MONTH, '2023-08-01', '2024-07-31') + 1, FALSE, 'ARCHIVED', 'Completed academic year', TRUE, NOW(), 1, 1, NOW(), 1, NOW(), 1),
('2024-2025', 'AY-2024-25', '2024-08-01', '2025-07-31', TIMESTAMPDIFF(MONTH, '2024-08-01', '2025-07-31') + 1, TRUE, 'ACTIVE', 'Current academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1),
('2025-2026', 'AY-2025-26', '2025-08-01', '2026-07-31', TIMESTAMPDIFF(MONTH, '2025-08-01', '2026-07-31') + 1, FALSE, 'UPCOMING', 'Upcoming academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1),
('2026-2027', 'AY-2026-27', '2026-08-01', '2027-07-31', TIMESTAMPDIFF(MONTH, '2026-08-01', '2027-07-31') + 1, FALSE, 'UPCOMING', 'Upcoming academic year', FALSE, NULL, NULL, 1, NOW(), 1, NOW(), 1);




-- ============================================================
-- Sample Data: Campuses
-- This dataset seeds the 'campuses' table for Smart Solutions
-- School institutes. Each campus is associated with a province
-- and city. These records support student enrollment, fee
-- assignments, timetable, and staff allocation.
-- ============================================================


INSERT INTO campuses (organization_id, institute_id, province_id, city_id,
                      campus_name, contact, email, website, address,
                      logo, deleted,
                      created_at, created_by, updated_at, updated_by,
                      deleted_at, deleted_by)
VALUES
-- Punjab → Lahore (1)
(1, 1, 1, 1, 'Downtown Campus', '+92-300-1234567', 'downtown@smarteschool.com',
 'https://downtown.smarteschool.com', '123 Main Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Lahore (1)
(1, 1, 1, 1, 'Uptown Campus', '+92-300-7654321', 'uptown@smarteschool.com',
 'https://uptown.smarteschool.com', '456 Park Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Karachi (5)
(1, 1, 2, 5, 'Riverside Campus', '+92-301-1112223', 'riverside@smarteschool.com',
 'https://riverside.smarteschool.com', '789 River Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- KPK → Peshawar (9)
(1, 1, 3, 9, 'Hilltop Campus', '+92-301-3334445', 'hilltop@smarteschool.com',
 'https://hilltop.smarteschool.com', '101 Hill Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Faisalabad (2)
(1, 1, 1, 2, 'Greenfield Campus', '+92-302-5556667', 'greenfield@smarteschool.com',
 'https://greenfield.smarteschool.com', '202 Green Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Karachi (5)
(1, 1, 2, 5, 'Seaside Campus', '+92-302-7778889', 'seaside@smarteschool.com',
 'https://seaside.smarteschool.com', '303 Beach Avenue', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Multan (4)
(1, 1, 1, 4, 'Central Campus', '+92-303-9990001', 'central@smarteschool.com',
 'https://central.smarteschool.com', '404 Central Street', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Sindh → Hyderabad (6)
(1, 1, 2, 6, 'Lakeside Campus', '+92-303-2223334', 'lakeside@smarteschool.com',
 'https://lakeside.smarteschool.com', '505 Lake Road', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Punjab → Rawalpindi (3)
(1, 1, 1, 3, 'Sunrise Campus', '+92-304-4445556', 'sunrise@smarteschool.com',
 'https://sunrise.smarteschool.com', '606 Sunrise Blvd', NULL, FALSE,
 NOW(), 1, NOW(), 1, NULL, NULL),

-- Balochistan → Quetta (13)
(1, 1, 4, 13, 'Maple Campus', '+92-304-6667778', 'maple@smarteschool.com',
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
-- Sample Data: Students
-- Each student is linked to a campus, standard (grade), and
-- section. This data includes basic personal information,
-- contact info, enrollment details, and active status.
-- ============================================================


INSERT INTO students
(organization_id, first_name, full_name, last_name, student_code, date_of_birth, gender, email, phone, address, cnic, passport_number,
 religion, nationality, blood_group, is_active, status, enrollment_date, deleted, campus_id, standard_id, section_id,
 admission_type_id, academic_year_id)
VALUES (1, 'Ali', 'Ali Khan', 'Khan', 'STU001', '2008-05-15', 'MALE', 'ali.khan1@example.com', '03001234501',
        'Gulshan-e-Iqbal, Karachi', '42101-1234501-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-02', 0,
        1, 1, 1, 1, 3),
       (1, 'Ayesha', 'Ayesha Malik', 'Malik', 'STU002', '2009-03-21', 'FEMALE', 'ayesha.malik2@example.com', '03001234502',
        'Model Town, Lahore', '42201-2345602-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-04', 0, 1, 1,
        2, 2, 3),
       (1, 'Hassan', 'Hassan Ali', 'Ali', 'STU003', '2007-10-11', 'MALE', 'hassan.ali3@example.com', '03001234503',
        'Cantt Road, Rawalpindi', '42301-3456703-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-01-06', 0,
        1, 2, 3, 1, 3),
       (1, 'Fatima', 'Fatima Shah', 'Shah', 'STU004', '2008-12-01', 'FEMALE', 'fatima.shah4@example.com', '03001234504',
        'North Nazimabad, Karachi', '42401-4567804-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-01-08',
        0, 2, 2, 4, 3, 3),
       (1, 'Saad', 'Saad Ahmed', 'Ahmed', 'STU005', '2010-06-18', 'MALE', 'saad.ahmed5@example.com', '03001234505',
        'F-8 Sector, Islamabad', '42501-5678905-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-01-10', 0, 2,
        3, 5, 4, 3),
       (1, 'Zainab', 'Zainab Raza', 'Raza', 'STU006', '2011-01-09', 'FEMALE', 'zainab.raza6@example.com', '03001234506',
        'Johar Town, Lahore', '42601-6789016-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-01-12', 0, 1, 3,
        6, 1, 3),
       (1, 'Ahmed', 'Ahmed Farooq', 'Farooq', 'STU007', '2009-07-19', 'MALE', 'ahmed.farooq7@example.com', '03001234507',
        'Garden West, Karachi', '42701-7890127-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-01-14', 0, 1,
        4, 7, 2, 3),
       (1, 'Maryam', 'Maryam Iqbal', 'Iqbal', 'STU008', '2010-11-25', 'FEMALE', 'maryam.iqbal8@example.com', '03001234508',
        'Bahria Town, Lahore', '42801-8901238-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-01-16', 0, 2,
        4, 8, 3, 3),
       (1, 'Usman', 'Usman Tariq', 'Tariq', 'STU009', '2008-09-02', 'MALE', 'usman.tariq9@example.com', '03001234509',
        'Satellite Town, Rawalpindi', '42901-9012349-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-18',
        0, 1, 5, 9, 4, 3),
    (1, 'Hiba', 'Hiba Rehman', 'Rehman', 'STU010', '2011-02-14', 'FEMALE', 'hiba.rehman10@example.com', '03001234510',
        'Defence Phase 2, Karachi', '43001-0123420-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-20', 0,
        2, 5, 10, 1, 3),
    (1, 'Bilal', 'Bilal Ahmed', 'Ahmed', 'STU011', '2009-08-05', 'MALE', 'bilal.ahmed11@example.com', '03001234511',
        'Gulberg, Lahore', '43101-1234511-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-01-22', 0, 1, 1, 1,
        1, 3),
    (1, 'Sana', 'Sana Tariq', 'Tariq', 'STU012', '2010-03-12', 'FEMALE', 'sana.tariq12@example.com', '03001234512',
        'Model Town, Lahore', '43201-2345612-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-01-24', 0, 1, 1,
        2, 2, 3),
    (1, 'Omar', 'Omar Farooq', 'Farooq', 'STU013', '2008-07-19', 'MALE', 'omar.farooq13@example.com', '03001234513',
        'Cantt Road, Rawalpindi', '43301-3456713-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-01-26', 0,
        1, 2, 3, 1, 3),
    (1, 'Areeba', 'Areeba Shah', 'Shah', 'STU014', '2011-12-25', 'FEMALE', 'areeba.shah14@example.com', '03001234514',
        'North Nazimabad, Karachi', '43401-4567814-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-01-28',
        0, 2, 2, 4, 3, 3),
    (1, 'Hamza', 'Hamza Ali', 'Ali', 'STU015', '2009-05-21', 'MALE', 'hamza.ali15@example.com', '03001234515',
        'F-8 Sector, Islamabad', '43501-5678915-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-01-30', 0, 2,
        3, 5, 4, 3),
    (1, 'Sadia', 'Sadia Raza', 'Raza', 'STU016', '2010-09-14', 'FEMALE', 'sadia.raza16@example.com', '03001234516',
        'Johar Town, Lahore', '43601-6789016-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-02-01', 0, 1, 3,
        6, 1, 3),
    (1, 'Imran', 'Imran Farooq', 'Farooq', 'STU017', '2008-11-11', 'MALE', 'imran.farooq17@example.com', '03001234517',
        'Garden West, Karachi', '43701-7890117-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-02-03', 0, 1,
        4, 7, 2, 3),
    (1, 'Huma', 'Huma Iqbal', 'Iqbal', 'STU018', '2010-06-23', 'FEMALE', 'huma.iqbal18@example.com', '03001234518',
        'Bahria Town, Lahore', '43801-8901218-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-02-05', 0, 2,
        4, 8, 3, 3),
    (1, 'Naveed', 'Naveed Tariq', 'Tariq', 'STU019', '2009-09-17', 'MALE', 'naveed.tariq19@example.com', '03001234519',
        'Satellite Town, Rawalpindi', '43901-9012319-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-07',
        0, 1, 5, 9, 4, 3),
    (1, 'Iram', 'Iram Rehman', 'Rehman', 'STU020', '2011-02-10', 'FEMALE', 'iram.rehman20@example.com', '03001234520',
        'Defence Phase 2, Karachi', '44001-0123420-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-02-09', 0,
        2, 5, 10, 1, 3),
    (1, 'Ali', 'Ali Raza', 'Raza', 'STU021', '2008-04-12', 'MALE', 'ali.raza21@example.com', '03001234521',
        'Gulshan-e-Iqbal, Karachi', '44101-1234521-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-11', 0,
        1, 1, 1, 1, 3),
    (1, 'Sara', 'Sara Ahmed', 'Ahmed', 'STU022', '2009-05-09', 'FEMALE', 'sara.ahmed22@example.com', '03001234522',
        'Model Town, Lahore', '44201-2345622-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-02-13', 0, 1, 1,
        2, 2, 3),
    (1, 'Bilal', 'Bilal Khan', 'Khan', 'STU023', '2007-08-17', 'MALE', 'bilal.khan23@example.com', '03001234523',
        'Cantt Road, Rawalpindi', '44301-3456723-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-02-15', 0,
        1, 2, 3, 1, 3),
    (1, 'Fiza', 'Fiza Shah', 'Shah', 'STU024', '2010-11-20', 'FEMALE', 'fiza.shah24@example.com', '03001234524',
        'North Nazimabad, Karachi', '44401-4567824-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-02-17',
        0, 2, 2, 4, 3, 3),
    (1, 'Owais', 'Owais Farooq', 'Farooq', 'STU025', '2009-02-14', 'MALE', 'owais.farooq25@example.com', '03001234525',
        'F-8 Sector, Islamabad', '44501-5678925-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-02-19', 0, 2,
        3, 5, 4, 3),
    (1, 'Zoya', 'Zoya Iqbal', 'Iqbal', 'STU026', '2011-01-11', 'FEMALE', 'zoya.iqbal26@example.com', '03001234526',
        'Johar Town, Lahore', '44601-6789026-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-02-21', 0, 1, 3,
        6, 1, 3),
    (1, 'Hamza', 'Hamza Tariq', 'Tariq', 'STU027', '2008-03-25', 'MALE', 'hamza.tariq27@example.com', '03001234527',
        'Garden West, Karachi', '44701-7890127-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-02-23', 0, 1,
        4, 7, 2, 3),
    (1, 'Aimen', 'Aimen Rehman', 'Rehman', 'STU028', '2010-08-17', 'FEMALE', 'aimen.rehman28@example.com',
        '03001234528', 'Bahria Town, Lahore', '44801-8901228-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled',
        '2025-02-25', 0, 2, 4, 8, 3, 3),
    (1, 'Shahid', 'Shahid Ali', 'Ali', 'STU029', '2009-09-10', 'MALE', 'shahid.ali29@example.com', '03001234529',
        'Satellite Town, Rawalpindi', '44901-9012329-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-02-27',
        0, 1, 5, 9, 4, 3),
    (1, 'Saba', 'Saba Tariq', 'Tariq', 'STU032', '2009-07-12', 'FEMALE', 'saba.tariq32@example.com', '03001234532',
        'Model Town, Lahore', '45201-2345632-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-03-04', 0, 1, 1,
        2, 2, 3),
    (1, 'Rehan', 'Rehan Khan', 'Khan', 'STU033', '2007-08-25', 'MALE', 'rehan.khan33@example.com', '03001234533',
        'Cantt Road, Rawalpindi', '45301-3456733-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-03-06', 0,
        1, 2, 3, 1, 3),
    (1, 'Nida', 'Nida Shah', 'Shah', 'STU034', '2010-12-18', 'FEMALE', 'nida.shah34@example.com', '03001234534',
        'North Nazimabad, Karachi', '45401-4567834-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-03-08',
        0, 2, 2, 4, 3, 3),
    (1, 'Danish', 'Danish Ahmed', 'Ahmed', 'STU035', '2009-06-05', 'MALE', 'danish.ahmed35@example.com', '03001234535',
        'F-8 Sector, Islamabad', '45501-5678935-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-03-10', 0, 2,
        3, 5, 4, 3),
    (1, 'Maryam', 'Maryam Raza', 'Raza', 'STU036', '2011-04-12', 'FEMALE', 'maryam.raza36@example.com', '03001234536',
        'Johar Town, Lahore', '45601-6789036-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-03-12', 0, 1, 3,
        6, 1, 3),
    (1, 'Farhan', 'Farhan Farooq', 'Farooq', 'STU037', '2008-11-11', 'MALE', 'farhan.farooq37@example.com',
        '03001234537', 'Garden West, Karachi', '45701-7890137-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled',
        '2025-03-14', 0, 1, 4, 7, 2, 3),
    (1, 'Sofia', 'Sofia Iqbal', 'Iqbal', 'STU038', '2010-02-14', 'FEMALE', 'sofia.iqbal38@example.com', '03001234538',
        'Bahria Town, Lahore', '45801-8901238-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-03-16', 0, 2,
        4, 8, 3, 3),
    (1, 'Asad', 'Asad Tariq', 'Tariq', 'STU039', '2009-09-19', 'MALE', 'asad.tariq39@example.com', '03001234539',
        'Satellite Town, Rawalpindi', '45901-9012339-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-03-18',
        0, 1, 5, 9, 4, 3),
    (1, 'Hina', 'Hina Rehman', 'Rehman', 'STU040', '2011-06-22', 'FEMALE', 'hina.rehman40@example.com', '03001234540',
        'Defence Phase 2, Karachi', '46001-0123440-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-03-20', 0,
        2, 5, 10, 1, 3),
    (1, 'Omar', 'Omar Raza', 'Raza', 'STU041', '2008-04-05', 'MALE', 'omar.raza41@example.com', '03001234541',
        'Gulshan-e-Iqbal, Karachi', '46101-1234541-1', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-03-22', 0,
        1, 1, 1, 1, 3),
    (1, 'Ayesha', 'Ayesha Farooq', 'Farooq', 'STU042', '2009-08-14', 'FEMALE', 'ayesha.farooq42@example.com',
        '03001234542', 'Model Town, Lahore', '46201-2345642-2', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled',
        '2025-03-24', 0, 1, 1, 2, 2, 3),
    (1, 'Ali', 'Ali Shah', 'Shah', 'STU043', '2007-09-23', 'MALE', 'ali.shah43@example.com', '03001234543',
        'Cantt Road, Rawalpindi', '46301-3456743-3', NULL, 'Islam', 'Pakistani', 'O+', 1, 'Enrolled', '2025-03-26', 0,
        1, 2, 3, 1, 3),
    (1, 'Sadia', 'Sadia Ahmed', 'Ahmed', 'STU044', '2010-12-05', 'FEMALE', 'sadia.ahmed44@example.com', '03001234544',
        'North Nazimabad, Karachi', '46401-4567844-4', NULL, 'Islam', 'Pakistani', 'AB+', 1, 'Enrolled', '2025-03-28',
        0, 2, 2, 4, 3, 3),
    (1, 'Saad', 'Saad Farooq', 'Farooq', 'STU045', '2009-05-11', 'MALE', 'saad.farooq45@example.com', '03001234545',
        'F-8 Sector, Islamabad', '46501-5678945-5', NULL, 'Islam', 'Pakistani', 'A-', 1, 'Enrolled', '2025-03-30', 0, 2,
        3, 5, 4, 3),
    (1, 'Zoya', 'Zoya Khan', 'Khan', 'STU046', '2011-01-17', 'FEMALE', 'zoya.khan46@example.com', '03001234546',
        'Johar Town, Lahore', '46601-6789046-6', NULL, 'Islam', 'Pakistani', 'B-', 1, 'Enrolled', '2025-04-01', 0, 1, 3,
        6, 1, 3),
    (1, 'Bilal', 'Bilal Tariq', 'Tariq', 'STU047', '2008-03-20', 'MALE', 'bilal.tariq47@example.com', '03001234547',
        'Garden West, Karachi', '46701-7890147-7', NULL, 'Islam', 'Pakistani', 'O-', 1, 'Enrolled', '2025-04-03', 0, 1,
        4, 7, 2, 3),
    (1, 'Hina', 'Hina Iqbal', 'Iqbal', 'STU048', '2010-07-22', 'FEMALE', 'hina.iqbal48@example.com', '03001234548',
        'Bahria Town, Lahore', '46801-8901248-8', NULL, 'Islam', 'Pakistani', 'AB-', 1, 'Enrolled', '2025-04-05', 0, 2,
        4, 8, 3, 3),
    (1, 'Owais', 'Owais Rehman', 'Rehman', 'STU049', '2009-09-14', 'MALE', 'owais.rehman49@example.com', '03001234549',
        'Satellite Town, Rawalpindi', '46901-9012349-9', NULL, 'Islam', 'Pakistani', 'A+', 1, 'Enrolled', '2025-04-07',
        0, 1, 5, 9, 4, 3),
    (1, 'Iram', 'Iram Shah', 'Shah', 'STU050', '2011-02-18', 'FEMALE', 'iram.shah50@example.com', '03001234550',
        'Defence Phase 2, Karachi', '47001-0123450-0', NULL, 'Islam', 'Pakistani', 'B+', 1, 'Enrolled', '2025-04-09', 0,
        2, 5, 10, 1, 3);

-- ============================================================
-- Fee Catalog Sample Data
-- Each entry represents a charge that can be applied to students.
-- Fields:
--   code             : Unique code for fee
--   name             : Descriptive name of the fee
--   description      : Explanation / purpose of the fee
--   charge_type      : FIXED / VARIABLE / PER_SUBJECT / PER_CREDIT / PERCENTAGE
--   recurrence_rule  : ONE_TIME / MONTHLY / YEARLY / TERM_WISE
--   active           : TRUE if currently applicable
--   deleted          : Soft-delete flag
--   created_at/updated_at : Audit timestamps
-- ============================================================
/* =========================================================
   FEE CATALOG (GENERAL – STABLE)
   ========================================================= */

INSERT INTO fee_catalog
(organization_id, code, name, description, charge_type, recurrence_rule,
 active, deleted,
 created_at, created_by, updated_at, updated_by,
 deleted_at, deleted_by)
VALUES (1, 'ADMISSION', 'Admission Fee', 'One-time admission charges', 'FIXED', 'ONE_TIME',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'TUITION', 'Tuition Fee', 'Regular tuition charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'EXAM', 'Examination Fee', 'Examination related charges', 'FIXED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'LAB', 'Laboratory Fee', 'Laboratory usage and consumables charges', 'VARIABLE', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'LIBRARY', 'Library Fee', 'Library services and resources', 'FIXED', 'YEARLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'TRANSPORT', 'Transport Fee', 'Student transportation charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'HOSTEL', 'Hostel Fee', 'Boarding and lodging charges', 'FIXED', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'ANNUAL', 'Annual Charges', 'General annual school charges', 'FIXED', 'YEARLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'ACTIVITY', 'Activity Fee', 'Co-curricular and extra-curricular activities', 'FIXED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'DISCOUNT', 'Discount / Scholarship', 'Fee discounts and scholarships', 'DISCOUNTED', 'TERM_WISE',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL),

       (1, 'FINE', 'Late Fee / Penalty', 'Late payment fines or penalties', 'PERCENTAGE', 'MONTHLY',
        TRUE, FALSE, NOW(), 1, NOW(), 1, NULL, NULL);


/* =========================================================
   FEE COMPONENTS (WHAT IS CHARGED)
   ========================================================= */

INSERT INTO fee_component
(organization_id, fee_catalog_id, component_code, component_name, account_code,
 taxable, discount_able,
 active, deleted, created_at, created_by)
VALUES

-- Admission
(1, 1, 'ADM-FORM', 'Admission Form Fee', 'ACC-ADM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 1, 'ADM-PROC', 'Admission Processing Fee', 'ACC-ADM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Tuition
(1, 2, 'TUI-BASIC', 'Basic Tuition Fee', 'ACC-TUI-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Exam
(1, 3, 'EXAM-MID', 'Mid Term Exam Fee', 'ACC-EXM-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),
(1, 3, 'EXAM-FINAL', 'Final Exam Fee', 'ACC-EXM-02', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Lab
(1, 4, 'LAB-COMP', 'Computer Lab Charges', 'ACC-LAB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),
(1, 4, 'LAB-SCI', 'Science Lab Charges', 'ACC-LAB-02', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Library
(1, 5, 'LIB-USE', 'Library Usage Fee', 'ACC-LIB-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Transport
(1, 6, 'TRN-MON', 'Monthly Transport Charges', 'ACC-TRN-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Hostel
(1, 7, 'HOS-MON', 'Monthly Hostel Charges', 'ACC-HOS-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Annual
(1, 8, 'ANN-MAINT', 'Annual Maintenance Charges', 'ACC-ANN-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Activity
(1, 9, 'ACT-SPORT', 'Sports & Activities Fee', 'ACC-ACT-01', FALSE, TRUE, TRUE, FALSE, NOW(), 1),

-- Discount
(1, 10, 'DISC-SCH', 'Scholarship Discount', 'ACC-DISC-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1),

-- Fine
(1, 11, 'FINE-LATE', 'Late Payment Fine', 'ACC-FINE-01', FALSE, FALSE, TRUE, FALSE, NOW(), 1);


/* =========================================================
   FEE RATES (HOW MUCH / WHERE / WHEN)
   ========================================================= */

INSERT INTO fee_rates
(organization_id, campus_id, standard_id, fee_component_id, academic_year_id,
 description, amount, currency,
 effective_from, effective_to,
 active, deleted, created_at, created_by)
VALUES

-- Admission (One Time)
(1, 1, 1, 1, 3, 'Admission form charges', 3000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 1, 2, 3, 'Admission processing charges', 2000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Tuition (Monthly)
(1, 1, 1, 3, 3, 'Monthly tuition fee', 15000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Exam (Term Wise)
(1, 1, 1, 4, 3, 'Mid term exam fee', 2500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 1, 5, 3, 'Final term exam fee', 3000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Lab
(1, 1, 1, 6, 3, 'Computer lab charges', 1200.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),
(1, 1, 1, 7, 3, 'Science lab charges', 1500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Library
(1, 1, 1, 8, 3, 'Annual library charges', 2000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Transport
(1, 1, 1, 9, 3, 'Monthly transport charges', 5000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Hostel
(1, 1, 1, 10, 3, 'Monthly hostel charges', 12000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Annual
(1, 1, 1, 11, 3, 'Annual maintenance charges', 4000.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Activity
(1, 1, 1, 12, 3, 'Sports & activities charges', 1500.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1),

-- Fine (Percentage)
(1, 1, 1, 14, 3, 'Late payment fine (%)', 5.00, 'PKR', '2024-04-01', NULL, TRUE, FALSE, NOW(), 1);

-- ============================================================

-- Table: discount_type
-- Fields:
--   code          : Unique identifier for the discount type
--   name          : Descriptive name of the discount category
--   description   : Explains when/how the discount applies
--   is_active     : TRUE if currently applicable
--   priority      : Higher number → higher precedence when multiple discounts apply
--   display_order : Order in which discount types are shown in UI
--   created_by    : User ID who created the record
-- ============================================================

BEGIN;

-- ============================================================
-- 1️⃣ discount_type
-- ============================================================

INSERT INTO discount_type
(organization_id, code, name, description, charge_type, recurrence_rule, active, priority, display_order, created_by)
VALUES (1, 'MERIT', 'Merit Based Discount',
        'Academic excellence and result-based scholarships',
    'PERCENTAGE', 'TERM_WISE', TRUE, 100, 1, 1),

       (1, 'FAMILY', 'Family & Sibling Discount',
        'Sibling, staff child, alumni-based discounts',
    'PERCENTAGE', 'MONTHLY', TRUE, 90, 2, 1),

       (1, 'FINANCIAL', 'Financial Assistance',
        'Need-based and hardship financial support',
    'FIXED', 'MONTHLY', TRUE, 95, 3, 1),

       (1, 'PERFORMANCE', 'Sports & Co-Curricular',
        'Sports, leadership, and cultural achievements',
    'PERCENTAGE', 'TERM_WISE', TRUE, 80, 4, 1),

       (1, 'ATTENDANCE', 'Attendance & Discipline',
        'Attendance and behavior rewards',
    'PERCENTAGE', 'MONTHLY', TRUE, 70, 5, 1),

       (1, 'SPECIAL', 'Special Case / Waiver',
        'Medical, emergency and administrative cases',
        'FIXED', 'ONE_TIME', TRUE, 60, 6, 1);

-- ============================================================
-- 2️⃣ discount_sub_type
-- ============================================================

INSERT INTO discount_sub_type
(organization_id, code, name, description, discount_type_id, is_active, display_order, created_by)
VALUES
-- MERIT
(1, 'MERIT_TOPPER', 'Class Topper', 'Top position holder in class', 1, TRUE, 1, 1),
(1, 'MERIT_POSITION', 'Board Position', 'Board or grade position holder', 1, TRUE, 2, 1),
(1, 'MERIT_SUBJECT', 'Subject Excellence', 'Outstanding subject performance', 1, TRUE, 3, 1),

-- FAMILY
(1, 'FAMILY_SIBLING', 'Sibling Discount', 'More than one sibling enrolled', 2, TRUE, 1, 1),
(1, 'FAMILY_STAFF', 'Staff Child', 'Child of school employee', 2, TRUE, 2, 1),

-- FINANCIAL
(1, 'FINANCIAL_NEED', 'Need Based Support', 'Low income household support', 3, TRUE, 1, 1),
(1, 'FINANCIAL_ORPHAN', 'Orphan Support', 'Orphan or single guardian case', 3, TRUE, 2, 1),

-- PERFORMANCE
(1, 'SPORTS', 'Sports Achievement', 'District or national sports player', 4, TRUE, 1, 1),
(1, 'LEADERSHIP', 'Leadership Role', 'Head boy / Head girl / prefect', 4, TRUE, 2, 1),

-- ATTENDANCE
(1, 'ATTEND_100', '100% Attendance', 'Perfect attendance', 5, TRUE, 1, 1),
(1, 'GOOD_BEHAVIOR', 'Good Behavior', 'Excellent discipline record', 5, TRUE, 2, 1),

-- SPECIAL
(1, 'MEDICAL', 'Medical Emergency', 'Serious medical case', 6, TRUE, 1, 1),
(1, 'FULL_WAIVER', 'Full Fee Waiver', 'Approved full fee waiver', 6, TRUE, 2, 1);

-- ============================================================
-- 3️⃣ discount_rate (REALISTIC % & FIXED VALUES)
-- Academic Year: 2024–2025 (id = 1)
-- Campuses: NULL = global, 1 = Main, 2 = City
-- ============================================================
INSERT INTO discount_rate
(organization_id, value, is_percentage, effective_from, effective_to,
 is_active, deleted,
 discount_sub_type_id,
 campus_id, academic_year_id,
 created_by)
VALUES

-- ====================================================
-- MERIT (Term-wise %)
-- ====================================================
(1, 30, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 1, 1, 3, 1),
(1, 40, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 2, 1, 3, 1),
(1, 20, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 1, 1, 3, 1),
(1, 60, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 2, 1, 3, 1),
(1, 80, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 3, 1, 3, 1),

-- ====================================================
-- FAMILY (Monthly %)
-- ====================================================
(1, 10, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 4, 1, 3, 1),
(1, 15, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 4, 1, 3, 1),
(1, 20, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 5, 1, 3, 1),

-- ====================================================
-- FINANCIAL (Monthly FIXED)
-- ====================================================
(1, 2000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 6, 1, 3, 1),
(1, 3000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 6, 1, 3, 1),
(1, 5000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 7, 1, 3, 1),

-- ====================================================
-- PERFORMANCE (Term-wise %)
-- ====================================================
(1, 25, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 8, 1, 3, 1),
(1, 30, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 9, 1, 3, 1),

-- ====================================================
-- ATTENDANCE (Monthly %)
-- ====================================================
(1, 5, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 10, 1, 3, 1),
(1, 10, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 10, 1, 3, 1),
(1, 15, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 11, 1, 3, 1),

-- ====================================================
-- SPECIAL (One-time + Full Waiver)
-- ====================================================
(1, 4000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 12, 1, 3, 1),
(1, 8000, FALSE, '2024-08-01', '2025-05-31', TRUE, FALSE, 12, 1, 3, 1),
(1, 100, TRUE, '2024-08-01', '2025-05-31', TRUE, FALSE, 13, 1, 3, 1);

COMMIT;



INSERT INTO student_fee_assignments
    (organization_id, student_id, fee_rate_id, total_amount, due_date, assigned_date)
VALUES
-- Ali (STU001)
(1, 1, 1, 5000.00, '2025-01-10', '2025-01-02'),
(1, 1, 4, 20000.00, '2025-01-15', '2025-01-02'),
(1, 1, 7, 8000.00, '2025-01-20', '2025-01-02'),

-- Ayesha (STU002)
(1, 2, 1, 5000.00, '2025-01-10', '2025-01-04'),
(1, 2, 4, 20000.00, '2025-01-15', '2025-01-04'),

-- Hassan (STU003)
(1, 3, 1, 5000.00, '2025-01-10', '2025-01-06'),
(1, 3, 4, 20000.00, '2025-01-15', '2025-01-06'),

-- Fatima (STU004)
(1, 4, 1, 5000.00, '2025-01-10', '2025-01-08'),
(1, 4, 4, 20000.00, '2025-01-15', '2025-01-08'),

-- Saad (STU005)
(1, 5, 1, 5000.00, '2025-01-10', '2025-01-10'),
(1, 5, 4, 20000.00, '2025-01-15', '2025-01-10');



INSERT INTO student_fee_payments
(organization_id, academic_year_id, student_id, payment_date, amount_paid, payment_month, payment_year, payment_mode)
VALUES
-- Ali
(1, 3, 1, '2025-01-12', 5000.00, 'January', 2025, 'Cash'),
(1, 3, 1, '2025-01-18', 20000.00, 'January', 2025, 'Bank Transfer'),

-- Ayesha
(1, 3, 2, '2025-01-12', 5000.00, 'January', 2025, 'Cash'),

-- Hassan
(1, 3, 3, '2025-01-14', 5000.00, 'January', 2025, 'Cheque'),

-- Fatima
(1, 3, 4, '2025-01-15', 5000.00, 'January', 2025, 'Cash'),

-- Saad
(1, 3, 5, '2025-01-16', 2500.00, 'January', 2025, 'Bank Transfer');



INSERT INTO student_fee_summary
    (organization_id, student_id, academic_year_id, total_assigned_fee, total_paid, balance)
VALUES
-- Ali: Assigned 5000+20000+8000 = 33000, Paid 25000, Balance 8000
(1, 1, 3, 33000.00, 25000.00, 8000.00),

-- Ayesha: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(1, 2, 3, 25000.00, 5000.00, 20000.00),

-- Hassan: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(1, 3, 3, 25000.00, 5000.00, 20000.00),

-- Fatima: Assigned 5000+20000 = 25000, Paid 5000, Balance 20000
(1, 4, 3, 25000.00, 5000.00, 20000.00),

-- Saad: Assigned 5000+20000 = 25000, Paid 2500, Balance 22500
(1, 5, 3, 25000.00, 2500.00, 22500.00);




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


INSERT INTO employee_master
(organization_id, employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date,
 probation_end_date, primary_phone, secondary_phone, work_phone, profile_picture, bio, email, active, created_by,
 created_at, updated_by, updated_at, employee_type_id)
VALUES
(1, 'EMP001', 'Uzair', 'Anwar', 'Uzair Anwar', 'MALE', '1990-05-12', 'SINGLE', '2022-01-10', '2022-07-10',
 '03001234567', '03007654321', '0421234567', 'uzair.jpg', 'Software Engineer', 'uzair.anwar@example.com', TRUE,
 1, NOW(), 1, NOW(), 11),

(1, 'EMP002', 'Ayesha', 'Khan', 'Ayesha Khan', 'FEMALE', '1988-11-25', 'MARRIED', '2021-06-15', '2021-12-15',
 '03009876543', '03001239876', '0429876543', 'ayesha.jpg', 'HR Manager', 'ayesha.khan@example.com', TRUE, 1,
 NOW(), 1, NOW(), 14),

(1, 'EMP003', 'Ali', 'Raza', 'Ali Raza', 'MALE', '1992-03-30', 'SINGLE', '2023-03-01', '2023-09-01',
 '03004567890', NULL, '0424567890', 'ali.jpg', 'Accountant', 'ali.raza@example.com', TRUE, 1, NOW(), 1, NOW(), 12),

(1, 'EMP004', 'Sana', 'Javed', 'Sana Javed', 'FEMALE', '1995-08-18', 'SINGLE', '2022-09-20', '2023-03-20',
 '03006789012', '03009871234', '0425678901', 'sana.jpg', 'Marketing Executive', 'sana.javed@example.com', TRUE,
 1, NOW(), 1, NOW(), 11),

(1, 'EMP005', 'Hamza', 'Shah', 'Hamza Shah', 'MALE', '1985-12-10', 'MARRIED', '2020-05-05', '2020-11-05',
 '03003456789', '03007654321', '0426789012', 'hamza.jpg', 'Finance Manager', 'hamza.shah@example.com', TRUE, 1,
 NOW(), 1, NOW(), 12),

(1, 'EMP006', 'Sara', 'Malik', 'Sara Malik', 'FEMALE', '1991-07-22', 'SINGLE', '2021-02-15', '2021-08-15',
 '03001112233', '03004445566', '0421122334', 'sara.jpg', 'Software Tester', 'sara.malik@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

(1, 'EMP007', 'Bilal', 'Ahmed', 'Bilal Ahmed', 'MALE', '1989-09-09', 'MARRIED', '2020-03-10', '2020-09-10',
 '03002223344', '03005556677', '0422233445', 'bilal.jpg', 'Project Manager', 'bilal.ahmed@example.com', TRUE, 1,
 NOW(), 1, NOW(), 26),

(1, 'EMP008', 'Hina', 'Saeed', 'Hina Saeed', 'FEMALE', '1993-04-14', 'SINGLE', '2022-05-05', '2022-11-05',
 '03003334455', '03006667788', '0423344556', 'hina.jpg', 'Business Analyst', 'hina.saeed@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP009', 'Omar', 'Farooq', 'Omar Farooq', 'MALE', '1990-12-01', 'MARRIED', '2021-01-20', '2021-07-20',
 '03004445566', '03007778899', '0424455667', 'omar.jpg', 'UI/UX Designer', 'omar.farooq@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP010', 'Maria', 'Bashir', 'Maria Bashir', 'FEMALE', '1994-06-30', 'SINGLE', '2022-03-15', '2022-09-15',
 '03005556677', '03008889900', '0425566778', 'maria.jpg', 'Content Writer', 'maria.bashir@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP011', 'Zain', 'Iqbal', 'Zain Iqbal', 'MALE', '1987-11-11', 'MARRIED', '2020-08-01', '2021-02-01',
 '03006667788', '03009990011', '0426677889', 'zain.jpg', 'Operations Manager', 'zain.iqbal@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP012', 'Amina', 'Khalid', 'Amina Khalid', 'FEMALE', '1992-01-25', 'SINGLE', '2021-12-05', '2022-06-05',
 '03007778899', '03001110022', '0427788990', 'amina.jpg', 'Graphic Designer', 'amina.khalid@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP013', 'Naveed', 'Hussain', 'Naveed Hussain', 'MALE', '1986-05-18', 'MARRIED', '2019-09-15', '2020-03-15',
 '03008889900', '03002220033', '0428899001', 'naveed.jpg', 'Database Admin', 'naveed.hussain@example.com', TRUE, 1,
 NOW(), 1, NOW(), 12),

(1, 'EMP014', 'Fatima', 'Rashid', 'Fatima Rashid', 'FEMALE', '1995-10-12', 'SINGLE', '2022-11-10', '2023-05-10',
 '03009990011', '03003331122', '0429900112', 'fatima.jpg', 'Digital Marketer', 'fatima.rashid@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP015', 'Adnan', 'Qureshi', 'Adnan Qureshi', 'MALE', '1988-02-28', 'MARRIED', '2020-06-20', '2020-12-20',
 '03001112234', '03004445567', '0421011123', 'adnan.jpg', 'DevOps Engineer', 'adnan.qureshi@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

(1, 'EMP016', 'Iqra', 'Naz', 'Iqra Naz', 'FEMALE', '1993-09-19', 'SINGLE', '2021-07-25', '2022-01-25',
 '03002223345', '03005556678', '0422122234', 'iqra.jpg', 'SEO Specialist', 'iqra.naz@example.com', TRUE, 1,
 NOW(), 1, NOW(), 11),

(1, 'EMP017', 'Fahad', 'Jamil', 'Fahad Jamil', 'MALE', '1990-08-08', 'SINGLE', '2022-02-10', '2022-08-10',
 '03003334456', '03006667789', '0423233345', 'fahad.jpg', 'Network Engineer', 'fahad.jamil@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

(1, 'EMP018', 'Noor', 'Aziz', 'Noor Aziz', 'FEMALE', '1991-03-05', 'SINGLE', '2021-09-15', '2022-03-15',
 '03004445567', '03007778890', '0424344456', 'noor.jpg', 'Customer Support', 'noor.aziz@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

(1, 'EMP019', 'Tariq', 'Shafiq', 'Tariq Shafiq', 'MALE', '1989-12-22', 'MARRIED', '2020-11-01', '2021-05-01',
 '03005556678', '03008889901', '0425455567', 'tariq.jpg', 'IT Support', 'tariq.shafiq@example.com', TRUE, 1,
 NOW(), 1, NOW(), 16),

(1, 'EMP020', 'Zoya', 'Irfan', 'Zoya Irfan', 'FEMALE', '1994-07-17', 'SINGLE', '2022-04-01', '2022-10-01',
 '03006667789', '03009990012', '0426566678', 'zoya.jpg', 'Front-end Developer', 'zoya.irfan@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

(1, 'EMP021', 'Usman', 'Fahim', 'Usman Fahim', 'MALE', '1987-10-30', 'MARRIED', '2019-08-10', '2020-02-10',
 '03007778890', '03001110023', '0427677789', 'usman.jpg', 'Back-end Developer', 'usman.fahim@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

(1, 'EMP022', 'Mahnoor', 'Aslam', 'Mahnoor Aslam', 'FEMALE', '1992-05-27', 'SINGLE', '2021-05-20', '2021-11-20',
 '03008889901', '03002220034', '0428788990', 'mahnoor.jpg', 'QA Analyst', 'mahnoor.aslam@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1),

(1, 'EMP023', 'Rashid', 'Babar', 'Rashid Babar', 'MALE', '1985-09-14', 'MARRIED', '2019-12-15', '2020-06-15',
 '03009990012', '03003331123', '0429899001', 'rashid.jpg', 'Security Officer', 'rashid.babar@example.com', TRUE, 1,
 NOW(), 1, NOW(), 19),

(1, 'EMP024', 'Hira', 'Shamim', 'Hira Shamim', 'FEMALE', '1993-01-10', 'SINGLE', '2021-10-05', '2022-04-05',
 '03001110024', '03004445568', '0421011124', 'hira.jpg', 'Receptionist', 'hira.shamim@example.com', TRUE, 1,
 NOW(), 1, NOW(), 13),

(1, 'EMP025', 'Kamran', 'Latif', 'Kamran Latif', 'MALE', '1988-06-06', 'MARRIED', '2020-02-10', '2020-08-10',
 '03002220035', '03005556679', '0422122235', 'kamran.jpg', 'HR Executive', 'kamran.latif@example.com', TRUE, 1,
 NOW(), 1, NOW(), 14),

(1, 'EMP026', 'Sadia', 'Naeem', 'Sadia Naeem', 'FEMALE', '1995-11-20', 'SINGLE', '2022-06-10', '2022-12-10',
 '03003331125', '03006667790', '0423233346', 'sadia.jpg', 'Software Developer', 'sadia.naeem@example.com', TRUE, 1,
 NOW(), 1, NOW(), 1);

INSERT INTO departments (organization_id, department_code, department_name, description, parent_id, head_employee_id, active)
VALUES
-- Top-level school departments
(1, 'SCH01', 'School of Science', 'All science-related departments', NULL, 1, TRUE),
(1, 'SCH02', 'School of Arts', 'All arts-related departments', NULL, 2, TRUE),
(1, 'SCH03', 'School of Commerce', 'All commerce-related departments', NULL, 3, TRUE),

-- Science Faculty (use existing employee IDs as heads)
(1, 'SCI01', 'Department of Physics', 'Physics department', 1, 4, TRUE),
(1, 'SCI02', 'Department of Chemistry', 'Chemistry department', 1, 5, TRUE),
(1, 'SCI03', 'Department of Biology', 'Biology department', 1, 1, TRUE),  -- cycle back to employee 1
-- Arts Faculty
(1, 'ART01', 'Department of History', 'History department', 2, 2, TRUE),
(1, 'ART02', 'Department of Literature', 'Literature department', 2, 3, TRUE),
(1, 'ART03', 'Department of Fine Arts', 'Fine Arts department', 2, 4, TRUE),
-- Commerce Faculty
(1, 'COM01', 'Department of Accounting', 'Accounting department', 3, 5, TRUE),
(1, 'COM02', 'Department of Business Administration', 'Business Admin dept', 3, 1, TRUE),
(1, 'COM03', 'Department of Economics', 'Economics department', 3, 2, TRUE);






INSERT INTO designations
(organization_id, designation_code, designation_name, description, department_id, employee_type_id, active)
VALUES
-- School level roles (Management)
(1, 'DES001', 'Principal', 'Head of the school', NULL, 3, TRUE),
(1, 'DES002', 'Vice Principal', 'Assistant head of school', NULL, 3, TRUE),
(1, 'DES003', 'School Accountant', 'Handles school financials', 3, 2, TRUE),

-- Science Faculty roles (Teachers)
(1, 'DES004', 'Senior Physics Teacher', 'Experienced physics teacher', 4, 1, TRUE),
(1, 'DES005', 'Junior Physics Teacher', 'Junior-level physics teacher', 4, 1, TRUE),
(1, 'DES006', 'Senior Chemistry Teacher', 'Experienced chemistry teacher', 5, 1, TRUE),
(1, 'DES007', 'Junior Chemistry Teacher', 'Junior-level chemistry teacher', 5, 1, TRUE),
(1, 'DES008', 'Senior Biology Teacher', 'Experienced biology teacher', 6, 1, TRUE),
(1, 'DES009', 'Junior Biology Teacher', 'Junior-level biology teacher', 6, 1, TRUE),

-- Arts Faculty roles (Teachers)
(1, 'DES010', 'History Teacher', 'Teaches history', 2, 1, TRUE),
(1, 'DES011', 'Literature Teacher', 'Teaches literature', 2, 1, TRUE),
(1, 'DES012', 'Fine Arts Teacher', 'Teaches arts', 2, 1, TRUE),

-- Commerce Faculty roles (Teachers)
(1, 'DES013', 'Accounting Teacher', 'Teaches accounting', 3, 1, TRUE),
(1, 'DES014', 'Business Administration Teacher', 'Teaches business administration', 3, 1, TRUE),
(1, 'DES015', 'Economics Teacher', 'Teaches economics', 3, 1, TRUE);


-- =====================================
-- 1️⃣ Salary Structures
-- =====================================
INSERT INTO salary_structure
(organization_id, employee_type_id, base_salary, effective_from, effective_to, deleted, created_at, created_by)
VALUES
(1, 1, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Teacher
(1, 2, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Head of Department
(1, 3, 120000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Principal
(1, 4, 100000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Vice Principal
(1, 5, 40000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Lab Instructor
(1, 6, 55000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Special Education Teacher
(1, 7, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Sports Coach
(1, 8, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Music Teacher
(1, 9, 45000, '2025-01-01', NULL, FALSE, NOW(), 101),   -- Art Teacher
(1, 10, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Librarian
(1, 11, 60000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Administrator
(1, 12, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Accountant
(1, 13, 35000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Receptionist
(1, 14, 65000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- HR Officer
(1, 15, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Clerk
(1, 16, 60000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- IT Support
(1, 17, 50000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Counselor
(1, 18, 40000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Nurse
(1, 19, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Security Guard
(1, 20, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Driver
(1, 21, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Janitor
(1, 22, 30000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Cafeteria Staff
(1, 23, 25000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- Bus Attendant
(1, 24, 150000, '2025-01-01', NULL, FALSE, NOW(), 101), -- School Board Member
(1, 25, 70000, '2025-01-01', NULL, FALSE, NOW(), 101),  -- School Coordinator
(1, 26, 80000, '2025-01-01', NULL, FALSE, NOW(), 101);  -- Project Manager

-- =====================================
-- 2️⃣ Salary Components
-- =====================================
-- Earnings
INSERT INTO salary_component (organization_id, name, type, is_percentage) VALUES
(1, 'House Rent Allowance (HRA)', 'EARNING', TRUE),
(1, 'Dearness Allowance (DA)', 'EARNING', TRUE),
(1, 'Conveyance Allowance', 'EARNING', FALSE),
(1, 'Medical Allowance', 'EARNING', FALSE),
(1, 'Special Allowance', 'EARNING', TRUE),
(1, 'Performance Bonus', 'EARNING', FALSE),
(1, 'Travel Allowance', 'EARNING', FALSE),
(1, 'Education Allowance', 'EARNING', FALSE),
(1, 'Meal / Food Allowance', 'EARNING', FALSE),
(1, 'Overtime Pay', 'EARNING', FALSE),
(1, 'Telephone / Internet Allowance', 'EARNING', FALSE),
(1, 'Leave Encashment', 'EARNING', FALSE),
(1, 'Festival / Annual Bonus', 'EARNING', FALSE),
(1, 'Project / Incentive Bonus', 'EARNING', FALSE);

-- Deductions
INSERT INTO salary_component (organization_id, name, type, is_percentage) VALUES
(1, 'Provident Fund (PF)', 'DEDUCTION', TRUE),
(1, 'Employee State Insurance (ESI)', 'DEDUCTION', TRUE),
(1, 'Professional Tax (PT)', 'DEDUCTION', FALSE),
(1, 'Income Tax / TDS', 'DEDUCTION', TRUE),
(1, 'Loan Deduction', 'DEDUCTION', FALSE),
(1, 'Salary Advance Deduction', 'DEDUCTION', FALSE),
(1, 'Absence / Leave Deduction', 'DEDUCTION', FALSE),
(1, 'Insurance Premium Deduction', 'DEDUCTION', FALSE),
(1, 'Union Fees / Membership', 'DEDUCTION', FALSE),
(1, 'Other Voluntary Deductions', 'DEDUCTION', FALSE);


-- =====================================
-- Salary Structure Components
-- =====================================
-- For Teacher (salary_structure_id = 1)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 1, 1, 20, NOW(), 101),    -- HRA 20%
(1, 1, 2, 10, NOW(), 101),    -- DA 10%
(1, 1, 3, 5000, NOW(), 101),  -- Conveyance fixed
(1, 1, 4, 3000, NOW(), 101),  -- Medical fixed
(1, 1, 14, 5, NOW(), 101),    -- Project Bonus 5%
(1, 1, 15, 10, NOW(), 101),   -- PF deduction 10%
(1, 1, 16, 5, NOW(), 101);    -- Tax deduction 5%

-- For Head of Department (salary_structure_id = 2)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 2, 1, 25, NOW(), 101),    -- HRA 25%
(1, 2, 2, 12, NOW(), 101),    -- DA 12%
(1, 2, 3, 6000, NOW(), 101),  -- Conveyance fixed
(1, 2, 4, 4000, NOW(), 101),  -- Medical fixed
(1, 2, 5, 7, NOW(), 101),     -- Special Allowance 7%
(1, 2, 15, 10, NOW(), 101),   -- PF deduction 10%
(1, 2, 16, 5, NOW(), 101);    -- Tax deduction 5%

-- For Principal (salary_structure_id = 3)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 3, 1, 30, NOW(), 101),    -- HRA 30%
(1, 3, 2, 15, NOW(), 101),    -- DA 15%
(1, 3, 3, 7000, NOW(), 101),  -- Conveyance fixed
(1, 3, 4, 5000, NOW(), 101),  -- Medical fixed
(1, 3, 5, 10, NOW(), 101),    -- Special Allowance 10%
(1, 3, 15, 12, NOW(), 101),   -- PF deduction 12%
(1, 3, 16, 8, NOW(), 101);    -- Tax deduction 8%

-- For Vice Principal (salary_structure_id = 4)
INSERT INTO salary_structure_component
(organization_id, salary_structure_id, component_id, value, created_at, created_by)
VALUES
(1, 4, 1, 28, NOW(), 101),
(1, 4, 2, 13, NOW(), 101),
(1, 4, 3, 6500, NOW(), 101),
(1, 4, 4, 4500, NOW(), 101),
(1, 4, 5, 8, NOW(), 101),
(1, 4, 15, 11, NOW(), 101),
(1, 4, 16, 6, NOW(), 101);


-- =====================================
-- 4️⃣ Employee Salary (calculated realistically)
-- =====================================
INSERT INTO employee_salary (organization_id, employee_id, salary_structure_id, gross_salary, total_deductions, net_salary, effective_date, deleted, created_at, created_by) VALUES
(1, 1, 1, 71000, 13100, 57900, '2025-12-01', FALSE, NOW(), 101),
(1, 2, 2, 106500, 19050, 87450, '2025-12-01', FALSE, NOW(), 101),
(1, 3, 3, 194000, 33800, 160200, '2025-12-01', FALSE, NOW(), 101),
(1, 4, 4, 148500, 24000, 124500, '2025-12-01', FALSE, NOW(), 101),
(1, 5, 5, 48000, 9000, 39000, '2025-12-01', FALSE, NOW(), 101),
(1, 6, 6, 68000, 12000, 56000, '2025-12-01', FALSE, NOW(), 101),
(1, 7, 7, 51000, 8500, 42500, '2025-12-01', FALSE, NOW(), 101),
(1, 8, 8, 53000, 8800, 44200, '2025-12-01', FALSE, NOW(), 101),
(1, 9, 9, 52000, 8600, 43400, '2025-12-01', FALSE, NOW(), 101),
(1, 10, 10, 70500, 13000, 57500, '2025-12-01', FALSE, NOW(), 101),
(1, 11, 11, 90000, 17500, 72500, '2025-12-01', FALSE, NOW(), 101),
(1, 12, 12, 105000, 20000, 85000, '2025-12-01', FALSE, NOW(), 101),
(1, 13, 13, 42000, 7500, 34500, '2025-12-01', FALSE, NOW(), 101),
(1, 14, 14, 86000, 16000, 70000, '2025-12-01', FALSE, NOW(), 101),
(1, 15, 15, 35000, 6000, 29000, '2025-12-01', FALSE, NOW(), 101),
(1, 16, 16, 88000, 17000, 71000, '2025-12-01', FALSE, NOW(), 101),
(1, 17, 17, 71000, 13500, 57500, '2025-12-01', FALSE, NOW(), 101),
(1, 18, 18, 52000, 10000, 42000, '2025-12-01', FALSE, NOW(), 101),
(1, 19, 19, 36000, 6500, 29500, '2025-12-01', FALSE, NOW(), 101),
(1, 20, 20, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(1, 21, 21, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(1, 22, 22, 36000, 7000, 29000, '2025-12-01', FALSE, NOW(), 101),
(1, 23, 23, 30000, 5000, 25000, '2025-12-01', FALSE, NOW(), 101),
(1, 24, 24, 210000, 40000, 170000, '2025-12-01', FALSE, NOW(), 101),
(1, 25, 25, 105000, 20000, 85000, '2025-12-01', FALSE, NOW(), 101),
(1, 26, 26, 120000, 25000, 95000, '2025-12-01', FALSE, NOW(), 101);

-- =====================================
-- 5️⃣ Employee Deductions
-- =====================================
INSERT INTO employee_deduction (organization_id, employee_id, deduction_type, amount, month, deleted, created_at, created_by) VALUES
(1, 1, 'PF', 6000, '2025-12-01', FALSE, NOW(), 101),
(1, 1, 'Tax', 7100, '2025-12-01', FALSE, NOW(), 101),
(1, 2, 'PF', 8400, '2025-12-01', FALSE, NOW(), 101),
(1, 2, 'Tax', 10650, '2025-12-01', FALSE, NOW(), 101),
(1, 3, 'PF', 14400, '2025-12-01', FALSE, NOW(), 101),
(1, 3, 'Tax', 19400, '2025-12-01', FALSE, NOW(), 101),
(1, 4, 'PF', 12000, '2025-12-01', FALSE, NOW(), 101),
(1, 4, 'Tax', 12000, '2025-12-01', FALSE, NOW(), 101),
-- ...continue for all employees 5-26 similarly...
(1, 26, 'PF', 24000, '2025-12-01', FALSE, NOW(), 101),
(1, 26, 'Tax', 1000, '2025-12-01', FALSE, NOW(), 101);

-- =====================================
-- 6️⃣ Salary Payments
-- =====================================
INSERT INTO salary_payment (organization_id, employee_salary_id, payment_date, payment_mode, transaction_reference, amount_paid, remarks, deleted, created_at)
VALUES
(1, 1, '2025-12-31', 'BANK_TRANSFER', 'TXN1001', 57900, 'December salary', FALSE, NOW()),
(1, 2, '2025-12-31', 'CHEQUE', 'CHQ1002', 87450, 'December salary', FALSE, NOW()),
(1, 3, '2025-12-31', 'BANK_TRANSFER', 'TXN1003', 160200, 'December salary', FALSE, NOW()),
(1, 4, '2025-12-31', 'BANK_TRANSFER', 'TXN1004', 124500, 'December salary', FALSE, NOW()),
-- ... continue for all employees ...
(1, 26, '2025-12-31', 'BANK_TRANSFER', 'TXN1026', 95000, 'December salary', FALSE, NOW());


INSERT INTO employee_department_history
(organization_id, employee_id, department_id, start_date, end_date, is_current, deleted, created_at, created_by)
VALUES
-- Employee 1 history
(1, 1, 1, '2023-01-01 09:00:00', '2023-06-30 18:00:00', FALSE, FALSE, '2023-01-01 09:00:00', 1),
(1, 1, 1, '2023-07-01 09:00:00', NULL, TRUE, FALSE, '2023-07-01 09:00:00', 1),

-- Employee 2 history
(1, 2, 3, '2022-03-15 09:00:00', '2023-03-14 18:00:00', FALSE, FALSE, '2022-03-15 09:00:00', 1),
(1, 2, 4, '2023-03-15 09:00:00', NULL, TRUE, FALSE, '2023-03-15 09:00:00', 1),

-- Employee 3 history
(1, 3, 1, '2021-06-01 09:00:00', '2022-06-30 18:00:00', FALSE, FALSE, '2021-06-01 09:00:00', 1),
(1, 3, 2, '2022-07-01 09:00:00', '2023-01-31 18:00:00', FALSE, FALSE, '2022-07-01 09:00:00', 1),
(1, 3, 5, '2023-02-01 09:00:00', NULL, TRUE, FALSE, '2023-02-01 09:00:00', 1),

-- Employee 4 history (single current assignment)
(1, 4, 3, '2024-01-01 09:00:00', NULL, TRUE, FALSE, '2024-01-01 09:00:00', 2),

-- Employee 5 history (no current department)
(1, 5, 4, '2022-01-01 09:00:00', '2022-12-31 18:00:00', FALSE, FALSE, '2022-01-01 09:00:00', 1);




INSERT INTO employee_designation_history
(organization_id, employee_id, designation_id, department_id, start_date, end_date, is_current, created_at, created_by)
VALUES
-- Employee 1 – Teacher → Senior Biology Teacher
(1, 1, 9, 6, '2022-01-10 09:00:00', '2023-06-30 18:00:00', FALSE, NOW(), 1),
(1, 1, 8, 6, '2023-07-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 2 – Vice Principal
(1, 2, 2, NULL, '2021-06-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 3 – Accountant
(1, 3, 3, 3, '2023-03-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 4 – Junior → Senior Physics Teacher
(1, 4, 5, 4, '2022-09-20 09:00:00', '2024-01-31 18:00:00', FALSE, NOW(), 1),
(1, 4, 4, 4, '2024-02-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 5 – Senior Chemistry Teacher
(1, 5, 6, 5, '2020-05-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 6 – Junior Biology Teacher
(1, 6, 9, 6, '2021-02-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 7 – Project Manager (School Level)
(1, 7, 1, NULL, '2020-03-10 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 8 – Business Administration Teacher
(1, 8, 14, 3, '2022-05-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 9 – Economics Teacher
(1, 9, 15, 3, '2021-01-20 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 10 – Literature Teacher
(1, 10, 11, 2, '2022-03-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 11 – Principal
(1, 11, 1, NULL, '2020-08-01 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 12 – Fine Arts Teacher
(1, 12, 12, 2, '2021-12-05 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 13 – Accounting Teacher
(1, 13, 13, 3, '2019-09-15 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 14 – History Teacher
(1, 14, 10, 2, '2022-11-10 09:00:00', NULL, TRUE, NOW(), 1),

-- Employee 15 – Junior → Senior Chemistry Teacher
(1, 15, 7, 5, '2020-06-20 09:00:00', '2022-12-31 18:00:00', FALSE, NOW(), 1),
(1, 15, 6, 5, '2023-01-01 09:00:00', NULL, TRUE, NOW(), 1);
