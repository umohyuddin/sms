-- ==========================================================
-- REAL-TIME PROD ERP LEVEL DATA FOR DISCOUNTS
-- Includes Discount Type, Sub Type, and Rate mappings
-- ==========================================================

-- ==========================================================
-- 1. DISCOUNT TYPES
-- References: charge_types (PERCENTAGE, FIXED) & fee_recurrence_rules (MONTHLY, ANNUAL, ONE_TIME)
-- ==========================================================

INSERT INTO discount_type (organization_id, code, name, description, charge_type_id, recurrence_rule_id, priority, display_order, active, deleted, created_at, created_by)
VALUES 
-- Sibling Discount (Percentage - Monthly) 
(1, 'SIB_DISC', 'Sibling Discount', 'Discount applied to the 2nd, 3rd, and subsequent siblings of an enrolled student.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'), 
 1, 1, TRUE, FALSE, NOW(), 1),

-- Scholarship (Percentage - Annual)
(1, 'SCHOLARSHIP', 'Merit & Need Based Scholarship', 'Scholarship awarded to students based on merit or financial need.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='ANNUAL'), 
 2, 2, TRUE, FALSE, NOW(), 1),

-- Staff/Employee Child Discount (Percentage - Monthly)
(1, 'STAFF_DISC', 'Staff Child Discount', 'Special discount for children of teaching and non-teaching staff members.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'), 
 3, 3, TRUE, FALSE, NOW(), 1),

-- Early Bird Admissions (Fixed - One Time)
(1, 'EARLY_BIRD', 'Early Bird Discount', 'Special fixed discount for early admission enrollments.', 
 (SELECT id FROM charge_types WHERE code='FIXED'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='ONE_TIME'), 
 4, 4, TRUE, FALSE, NOW(), 1),

-- Alumni Discount (Percentage - Monthly)
(1, 'ALUMNI_DISC', 'Alumni Discount', 'Special appreciation discount for children of our institution alumni.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'), 
 5, 5, TRUE, FALSE, NOW(), 1),

-- Corporate / Armed Forces Discount (Percentage - Monthly)
(1, 'CORP_GOVT', 'Corporate & Armed Forces', 'Special concession for children of military personnel and government officials.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'), 
 6, 6, TRUE, FALSE, NOW(), 1),

-- Upfront Annual Payment / Lump Sum (Percentage - One Time)
(1, 'LUMP_SUM', 'Upfront Annual Payment Discount', 'Discount awarded to parents who pay the entire academic year fee upfront.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='ONE_TIME'), 
 7, 7, TRUE, FALSE, NOW(), 1),

-- Special Needs / Differently Abled (Percentage - Monthly)
(1, 'SPECIAL_NEEDS', 'Special Needs Support', 'Educational grant for differently-abled or special needs students.', 
 (SELECT id FROM charge_types WHERE code='PERCENTAGE'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='MONTHLY'), 
 8, 8, TRUE, FALSE, NOW(), 1),

-- Referral Discount (Fixed - One Time)
(1, 'REFERRAL', 'Referral Reward', 'Fixed reduction on the next bill for successfully referring a new student.', 
 (SELECT id FROM charge_types WHERE code='FIXED'), 
 (SELECT id FROM fee_recurrence_rules WHERE code='ONE_TIME'), 
 9, 9, TRUE, FALSE, NOW(), 1);


-- ==========================================================
-- 2. DISCOUNT SUB TYPES
-- Mapping directly to the newly created Discount Types
-- ==========================================================

INSERT INTO discount_sub_type (organization_id, discount_type_id, code, name, description, is_active, priority, display_order, created_by, created_at)
VALUES
-- Sibling Discount Sub Types
(1, (SELECT id FROM discount_type WHERE code='SIB_DISC'), 'SIB_2ND', '2nd Child', 'Discount for the second enrolled child.', TRUE, 1, 1, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='SIB_DISC'), 'SIB_3RD', '3rd Child', 'Discount for the third enrolled child.', TRUE, 2, 2, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='SIB_DISC'), 'SIB_4TH_PLUS', '4th Child & Above', 'Discount for the fourth and subsequent enrolled children.', TRUE, 3, 3, 1, NOW()),

-- Scholarship Sub Types
(1, (SELECT id FROM discount_type WHERE code='SCHOLARSHIP'), 'SCH_MERIT_100', '100% Merit Scholarship', 'Full scholarship for top position holders.', TRUE, 1, 4, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='SCHOLARSHIP'), 'SCH_MERIT_50', '50% Merit Scholarship', 'Half scholarship for outstanding students.', TRUE, 2, 5, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='SCHOLARSHIP'), 'SCH_NEED', 'Need-Based Financial Aid', 'Financial assistance for underprivileged students.', TRUE, 3, 6, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='SCHOLARSHIP'), 'SCH_ORPHAN', 'Orphan Support Grant', 'Full support covering 100% education costs for orphans.', TRUE, 4, 7, 1, NOW()),

-- Staff Discount Sub Types
(1, (SELECT id FROM discount_type WHERE code='STAFF_DISC'), 'STAFF_TEACHING', 'Teaching Staff Child', 'Discount for children of teaching staff.', TRUE, 1, 8, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='STAFF_DISC'), 'STAFF_NON_TEACHING', 'Non-Teaching Staff Child', 'Discount for children of administrative and support staff.', TRUE, 2, 9, 1, NOW()),

-- Early Bird Sub Types
(1, (SELECT id FROM discount_type WHERE code='EARLY_BIRD'), 'EB_REG', 'Early Registration', 'Fixed reduction on admission forms or tuition fee for registering early.', TRUE, 1, 10, 1, NOW()),

-- Alumni Sub Types
(1, (SELECT id FROM discount_type WHERE code='ALUMNI_DISC'), 'ALUMNI_REGULAR', 'Regular Alumni Child', 'General discount for the children of alumni.', TRUE, 1, 11, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='ALUMNI_DISC'), 'ALUMNI_ASSOC', 'Alumni Association Member', 'Premium discount for active Alumni Association members.', TRUE, 2, 12, 1, NOW()),

-- Corporate / Gov Sub Types
(1, (SELECT id FROM discount_type WHERE code='CORP_GOVT'), 'ARMED_FORCES', 'Armed Forces / Military', 'Discount for children of active or retired military personnel.', TRUE, 1, 13, 1, NOW()),
(1, (SELECT id FROM discount_type WHERE code='CORP_GOVT'), 'GOVT_EMPLOYEE', 'Govt Employee Equivalent', 'Discount for children of government and civil servants.', TRUE, 2, 14, 1, NOW()),

-- Upfront Annual Sub Types
(1, (SELECT id FROM discount_type WHERE code='LUMP_SUM'), 'ANNUAL_UPFRONT', 'Annual Upfront Payment', 'Percentage discount off the total year fees if paid in advance.', TRUE, 1, 15, 1, NOW()),

-- Special Needs Sub Types
(1, (SELECT id FROM discount_type WHERE code='SPECIAL_NEEDS'), 'SPECIAL_ED_GRANT', 'Special Education Grant', 'Financial reduction off monthly fees for differently-abled students.', TRUE, 1, 16, 1, NOW()),

-- Referral Sub Types
(1, (SELECT id FROM discount_type WHERE code='REFERRAL'), 'SUCC_REFERRAL', 'Successful Student Referral', 'Fixed credit awarded when a referred student successfully enrolls.', TRUE, 1, 17, 1, NOW());


-- ==========================================================
-- 3. DISCOUNT RATES
-- Configuring the exact values (percentage and fixed amounts)
-- Mapping to academic_years (AY2025) and specific campuses
-- ==========================================================

INSERT INTO discount_rate (organization_id, value, is_percentage, effective_from, effective_to, is_active, deleted, discount_sub_type_id, campus_id, academic_year_id, created_at, created_by)
VALUES
-- ----------------------------------------------------------
-- GLOBALLY APPLIED DISCOUNTS (Campus NULL)
-- ----------------------------------------------------------
-- Sibling Discounts
(1, 10.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SIB_2ND'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),
(1, 20.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SIB_3RD'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),
(1, 50.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SIB_4TH_PLUS'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Staff Discounts
(1, 50.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='STAFF_TEACHING'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),
(1, 30.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='STAFF_NON_TEACHING'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Early Bird Registration (Fixed 5,000 Off)
(1, 5000.00, FALSE, '2024-12-01', '2025-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='EB_REG'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Alumni Discounts
(1, 10.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='ALUMNI_REGULAR'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),
(1, 15.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='ALUMNI_ASSOC'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Corporate / Armed Forces
(1, 25.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='ARMED_FORCES'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),
(1, 15.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='GOVT_EMPLOYEE'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Annual Upfront (5% on total)
(1, 5.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='ANNUAL_UPFRONT'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Special Needs / Differently Abled
(1, 30.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SPECIAL_ED_GRANT'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Referral Reward (Fixed 2,000 Off next bill)
(1, 2000.00, FALSE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SUCC_REFERRAL'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Orphan / Extreme Need (100% Off globally)
(1, 100.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, (SELECT id FROM discount_sub_type WHERE code='SCH_ORPHAN'), NULL, (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),


-- ----------------------------------------------------------
-- CAMPUS SPECIFIC DISCOUNTS
-- ----------------------------------------------------------
-- Downtown Campus Scholarships
(1, 100.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, 
 (SELECT id FROM discount_sub_type WHERE code='SCH_MERIT_100'), 
 (SELECT id FROM campuses WHERE campus_name='Downtown Campus' LIMIT 1), (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

(1, 50.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, 
 (SELECT id FROM discount_sub_type WHERE code='SCH_MERIT_50'), 
 (SELECT id FROM campuses WHERE campus_name='Downtown Campus' LIMIT 1), (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

(1, 30.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, 
 (SELECT id FROM discount_sub_type WHERE code='SCH_NEED'), 
 (SELECT id FROM campuses WHERE campus_name='Downtown Campus' LIMIT 1), (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

-- Uptown Campus Scholarships
(1, 100.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, 
 (SELECT id FROM discount_sub_type WHERE code='SCH_MERIT_100'), 
 (SELECT id FROM campuses WHERE campus_name='Uptown Campus' LIMIT 1), (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1),

(1, 50.00, TRUE, '2025-04-01', '2026-03-31', TRUE, FALSE, 
 (SELECT id FROM discount_sub_type WHERE code='SCH_MERIT_50'), 
 (SELECT id FROM campuses WHERE campus_name='Uptown Campus' LIMIT 1), (SELECT id FROM academic_years WHERE code='AY2025'), NOW(), 1);
