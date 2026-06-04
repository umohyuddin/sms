-- Migration script to synchronize student_fee_invoices with StudentFeeInvoiceEntity
ALTER TABLE student_fee_invoices ADD COLUMN waived_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00 AFTER discount_amount;
ALTER TABLE student_fee_invoices ADD COLUMN waived_reason VARCHAR(255) AFTER status;
ALTER TABLE student_fee_invoices ADD COLUMN last_reminder_sent_at DATETIME AFTER waived_reason;

-- Standardize audit column types and timestamp formats for consistency
ALTER TABLE student_fee_invoices MODIFY created_by BIGINT;
ALTER TABLE student_fee_invoices MODIFY updated_by BIGINT;
ALTER TABLE student_fee_invoices MODIFY deleted_by BIGINT;
ALTER TABLE student_fee_invoices MODIFY created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE student_fee_invoices MODIFY updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
ALTER TABLE student_fee_invoices MODIFY deleted_at DATETIME;
