-- Update student_fee_payments to include late fee tracking
ALTER TABLE student_fee_payments ADD COLUMN late_fee_paid DECIMAL(12, 2) DEFAULT 0.00 AFTER amount_paid;
