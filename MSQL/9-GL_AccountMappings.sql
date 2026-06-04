-- ====================================================
-- GL Account Mappings Dataset (Production Ready)
-- organization_id = 1 (Master Organization)
-- ====================================================

-- Procedure-like insertion using subqueries for ID discovery

-- 1. STUDENT FEE INVOICING (TUITION)
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'FEE' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'FEE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'TUITION' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'RECEIVABLE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '1121' AND organization_id = 1), -- Student Fee Receivable
1, TRUE, 1;

INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'FEE' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'FEE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'TUITION' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'REVENUE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '4110' AND organization_id = 1), -- Tuition Fee Revenue
1, TRUE, 1;

-- 2. ADMISSION FEE INVOICING
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'ADMISSION' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'FEE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'ADMISSION' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'RECEIVABLE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '1121' AND organization_id = 1),
1, TRUE, 1;

INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'ADMISSION' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'FEE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'ADMISSION' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'REVENUE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '4120' AND organization_id = 1), -- Admission Fee Revenue
1, TRUE, 1;

-- 3. TRANSPORT FEE INVOICING
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'TRANSPORT' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'TRANSPORT_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'TRANSPORT' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'RECEIVABLE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '1122' AND organization_id = 1), -- Transport Fee Receivable
1, TRUE, 1;

INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'TRANSPORT' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'TRANSPORT_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'TRANSPORT' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'REVENUE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '4210' AND organization_id = 1), -- Transport Fee Revenue
1, TRUE, 1;

-- 4. PAYROLL PROCESSING (SALARY)
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'PAYROLL' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'SALARY_PROCESS' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'SALARY' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'EXPENSE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '5110' AND organization_id = 1), -- Teacher Salaries Expense
1, TRUE, 1;

INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'PAYROLL' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'SALARY_PROCESS' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'SALARY' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'LIABILITY' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '2121' AND organization_id = 1), -- Salary Payable Liability
1, TRUE, 1;

-- 5. UTILITY BILLING (ELECTRICITY)
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'UTILITY' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'EXPENSE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'UTILITY' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'EXPENSE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '5210' AND organization_id = 1), -- Electricity Expense
1, TRUE, 1;

INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'UTILITY' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'EXPENSE_INVOICE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'UTILITY' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'PAYABLE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '2112' AND organization_id = 1), -- Utility Payable
1, TRUE, 1;

-- 6. FEE PAYMENT (CASH)
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'FEE' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'FEE_PAYMENT' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'TUITION' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'CASH' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '1111' AND organization_id = 1), -- Cash in Hand
1, TRUE, 1;

-- 7. LATE FEE FINE
INSERT INTO gl_account_mappings (organization_id, accounting_module_id, transaction_type_id, business_key_id, posting_key_id, gl_account_id, priority_order, is_active, created_by)
SELECT 1, 
(SELECT id FROM gl_accounting_modules WHERE code = 'FEE' AND organization_id = 1),
(SELECT id FROM gl_transaction_types WHERE code = 'LATE_FEE_FINE' AND organization_id = 1),
(SELECT id FROM gl_business_keys WHERE code = 'FINE' AND organization_id = 1),
(SELECT id FROM gl_posting_keys WHERE code = 'FINE_REVENUE' AND organization_id = 1),
(SELECT id FROM gl_accounts WHERE account_code = '4310' AND organization_id = 1), -- Late Fee Fine Revenue
1, TRUE, 1;
