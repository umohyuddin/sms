-- ====================================================
-- GL Accounting Modules Dataset
-- organization_id = 1 (Master Organization)
-- ====================================================

INSERT INTO gl_accounting_modules 
(organization_id, code, name, description, is_active, created_by, created_at)
VALUES
(1, 'FEE', 'Fee Management', 'Student fee invoicing and collections', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ADMISSION', 'Admission Management', 'Admission charges and registration accounting', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'DISCOUNT', 'Discount Management', 'Scholarships and fee discounts', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'REFUND', 'Refund Management', 'Student fee refunds', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'PAYROLL', 'Payroll Management', 'Employee salary and payroll processing', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'HR', 'Human Resource', 'HR related financial transactions', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ACCOUNTING', 'Accounting', 'Manual journal entries and adjustments', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BANKING', 'Banking', 'Cash and bank transactions', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'EXPENSE', 'Expense Management', 'Operational and administrative expenses', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'PURCHASE', 'Purchase Management', 'Vendor purchasing and procurement', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'INVENTORY', 'Inventory Management', 'Inventory and stock accounting', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'TRANSPORT', 'Transport Management', 'Transport fee and transport expenses', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'HOSTEL', 'Hostel Management', 'Hostel charges and hostel expenses', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'LIBRARY', 'Library Management', 'Library fines and charges', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'EXAMINATION', 'Examination Management', 'Exam fee and exam related accounting', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ASSET', 'Asset Management', 'Fixed assets and depreciation', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'UTILITY', 'Utility Billing', 'Electricity, gas and utility expenses', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'SCHOLARSHIP', 'Scholarship Management', 'Student scholarships and sponsorships', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'TAX', 'Tax Management', 'Tax deductions and liabilities', TRUE, 1, CURRENT_TIMESTAMP);
