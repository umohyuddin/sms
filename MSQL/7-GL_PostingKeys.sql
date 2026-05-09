-- ====================================================
-- GL Posting Keys Dataset
-- organization_id = 1 (Master Organization)
-- ====================================================

INSERT INTO gl_posting_keys 
(organization_id, code, name, account_side, description, is_active, created_by, created_at)
VALUES
-- Revenue
(1, 'REVENUE', 'Revenue Account', 'CREDIT', 'Standard income or revenue account posting.', TRUE, 1, CURRENT_TIMESTAMP),

-- Receivable
(1, 'RECEIVABLE', 'Receivable Account', 'DEBIT', 'Student or customer receivable balance account.', TRUE, 1, CURRENT_TIMESTAMP),

-- Cash / Bank
(1, 'CASH', 'Cash Account', 'DEBIT', 'General cash in hand account.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BANK', 'Bank Account', 'DEBIT', 'General bank or digital wallet account.', TRUE, 1, CURRENT_TIMESTAMP),

-- Expense
(1, 'EXPENSE', 'Expense Account', 'DEBIT', 'Operational or capital expense posting.', TRUE, 1, CURRENT_TIMESTAMP),

-- Liability
(1, 'LIABILITY', 'Liability Account', 'CREDIT', 'General liability or debt account.', TRUE, 1, CURRENT_TIMESTAMP),

-- Payable
(1, 'PAYABLE', 'Payable Account', 'CREDIT', 'Vendor or supplier payable account.', TRUE, 1, CURRENT_TIMESTAMP),

-- Equity
(1, 'EQUITY', 'Equity Account', 'CREDIT', 'Shareholder capital or owner equity account.', TRUE, 1, CURRENT_TIMESTAMP),

-- Discount
(1, 'DISCOUNT', 'Discount Account', 'DEBIT', 'Financial concessions or discounts given.', TRUE, 1, CURRENT_TIMESTAMP),

-- Fine
(1, 'FINE_REVENUE', 'Fine Revenue', 'CREDIT', 'Income from late fees or disciplinary fines.', TRUE, 1, CURRENT_TIMESTAMP),

-- Tax
(1, 'TAX', 'Tax Account', 'CREDIT', 'Sales tax or withholding tax payable account.', TRUE, 1, CURRENT_TIMESTAMP);
