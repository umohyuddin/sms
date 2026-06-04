-- ====================================================
-- GL Transaction Types Dataset (Production Ready)
-- organization_id = 1 (Master Organization)
-- ====================================================

INSERT INTO gl_transaction_types 
(organization_id, code, name, description, is_active, created_by, created_at)
VALUES
-- Student Fee Management
(1, 'FEE_INVOICE', 'Fee Invoice', 'Generated when student fees are invoiced for a period.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'FEE_PAYMENT', 'Fee Payment', 'Recorded when student fee payment is received.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'FEE_REFUND', 'Fee Refund', 'Recorded for refunding student fees or security deposits.', TRUE, 1, CURRENT_TIMESTAMP),

-- Payroll & HR
(1, 'SALARY_PROCESS', 'Salary Process', 'Monthly payroll accrual and processing.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'SALARY_PAYMENT', 'Salary Payment', 'Actual disbursement of salary to employee bank/cash.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'EMPLOYEE_ADVANCE', 'Employee Advance', 'Loans or salary advances given to employees.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BONUS_PAYMENT', 'Bonus Payment', 'Incentives, bonuses, or arrears paid to employees.', TRUE, 1, CURRENT_TIMESTAMP),

-- Expenses & Utilities
(1, 'EXPENSE_INVOICE', 'Expense Invoice', 'Recording of utility bills or operational bill entries.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'EXPENSE_PAYMENT', 'Expense Payment', 'Payment of operational expenses and utility bills.', TRUE, 1, CURRENT_TIMESTAMP),

-- Procurement & Inventory
(1, 'PURCHASE_INVOICE', 'Purchase Invoice', 'Recording of inventory or fixed asset purchases.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'PURCHASE_PAYMENT', 'Purchase Payment', 'Settlement of vendor payables.', TRUE, 1, CURRENT_TIMESTAMP),

-- Ancillary Services
(1, 'TRANSPORT_INVOICE', 'Transport Invoice', 'Generation of transport/van service charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'HOSTEL_INVOICE', 'Hostel Invoice', 'Generation of hostel/boarding charges.', TRUE, 1, CURRENT_TIMESTAMP),

-- General Accounting
(1, 'JOURNAL_ENTRY', 'Journal Entry', 'Manual journal adjustments and corrections (JV).', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BANK_DEPOSIT', 'Bank Deposit', 'Recording cash deposits into bank accounts.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BANK_WITHDRAW', 'Bank Withdraw', 'Recording cash withdrawals from bank accounts.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'OPENING_BALANCE', 'Opening Balance', 'Initial balance migration for accounts.', TRUE, 1, CURRENT_TIMESTAMP),

-- Adjustments & Fines
(1, 'SCHOLARSHIP_POSTING', 'Scholarship Posting', 'Recording financial aid and scholarship allocations.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'LATE_FEE_FINE', 'Late Fee Fine', 'Recording penalties for overdue payments.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BAD_DEBT_WRITE_OFF', 'Bad Debt Write-off', 'Writing off uncollectible receivables.', TRUE, 1, CURRENT_TIMESTAMP),

-- Taxes & Banking
(1, 'TAX_WITHHOLDING', 'Tax Withholding', 'Tax deducted at source (WHT) from payments.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'TAX_PAYMENT', 'Tax Payment', 'Payment of sales tax or corporate taxes.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BANK_CHARGES', 'Bank Charges', 'Recording bank service fees and commissions.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'INTEREST_INCOME', 'Interest Income', 'Interest earned on savings or fixed deposits.', TRUE, 1, CURRENT_TIMESTAMP),

-- Year-End & Adjustments
(1, 'DEPRECIATION', 'Depreciation Posting', 'Annual or monthly depreciation of fixed assets.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'CREDIT_NOTE', 'Credit Note', 'Adjustments to decrease student/customer receivables.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'DEBIT_NOTE', 'Debit Note', 'Adjustments to increase vendor payables.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ACCRUAL_ENTRY', 'Accrual Entry', 'Year-end or month-end expense/income accruals.', TRUE, 1, CURRENT_TIMESTAMP);

