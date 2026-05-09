-- ====================================================
-- GL Business Keys Dataset
-- organization_id = 1 (Master Organization)
-- ====================================================

INSERT INTO gl_business_keys 
(organization_id, code, name, module, description, is_active, created_by, created_at)
VALUES
-- Fee Module
(1, 'TUITION', 'Tuition Fee', 'FEE', 'Monthly tuition fee charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ADMISSION', 'Admission Fee', 'FEE', 'One time admission fee charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ANNUAL', 'Annual Charges', 'FEE', 'Annual school charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'EXAM', 'Examination Fee', 'FEE', 'Exam related fee charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'TRANSPORT', 'Transport Fee', 'FEE', 'Student transport/van charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'HOSTEL', 'Hostel Fee', 'FEE', 'Hostel/boarding charges.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'LIBRARY', 'Library Fee', 'FEE', 'Library usage and membership fee.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'LAB', 'Lab Fee', 'FEE', 'Science/computer lab usage fee.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'SPORTS', 'Sports Fee', 'FEE', 'Sports and extracurricular activities fee.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'FINE', 'Late Fine', 'FEE', 'Late payment and disciplinary fines.', TRUE, 1, CURRENT_TIMESTAMP),

-- HR / Payroll
(1, 'SALARY', 'Employee Salary', 'HR', 'Monthly employee salary disbursement.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'BONUS', 'Employee Bonus', 'HR', 'Employee bonus and incentive payments.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'ADVANCE_SALARY', 'Advance Salary', 'HR', 'Employee salary advance payments.', TRUE, 1, CURRENT_TIMESTAMP),

-- Expense Module
(1, 'UTILITY', 'Utility Expense', 'EXPENSE', 'Electricity, gas, and water utility bills.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'RENT', 'Building Rent', 'EXPENSE', 'Office or school building rent.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'MAINTENANCE', 'Maintenance Expense', 'EXPENSE', 'Facility repair and maintenance costs.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'STATIONARY', 'Stationary Expense', 'EXPENSE', 'Office and classroom stationary supplies.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'MARKETING', 'Marketing Expense', 'EXPENSE', 'Advertisement and school promotion costs.', TRUE, 1, CURRENT_TIMESTAMP),

-- Purchase / Inventory
(1, 'BOOKS', 'Books Purchase', 'INVENTORY', 'Purchase of library or syllabus books.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'UNIFORM', 'Uniform Purchase', 'INVENTORY', 'Purchase of school uniforms for stock.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'FURNITURE', 'Furniture Purchase', 'INVENTORY', 'Purchase of classroom and office furniture.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'COMPUTERS', 'Computer Equipment', 'INVENTORY', 'Purchase of IT and computer equipment.', TRUE, 1, CURRENT_TIMESTAMP),

-- Banking
(1, 'BANK_TRANSFER', 'Bank Transfer', 'FINANCE', 'Internal or external bank transfers.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'CASH_DEPOSIT', 'Cash Deposit', 'FINANCE', 'Cash deposited into bank accounts.', TRUE, 1, CURRENT_TIMESTAMP),
(1, 'CASH_WITHDRAW', 'Cash Withdraw', 'FINANCE', 'Cash withdrawn from bank accounts.', TRUE, 1, CURRENT_TIMESTAMP);
