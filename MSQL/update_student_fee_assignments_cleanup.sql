-- SQL Script to remove redundant billing fields from student_fee_assignments table
-- These fields are now tracked at the Invoice (Voucher) level for better financial accuracy.

ALTER TABLE student_fee_assignments 
DROP COLUMN due_date,
DROP COLUMN late_fee_amount,
DROP COLUMN waived_amount,
DROP COLUMN waived_reason,
DROP COLUMN last_reminder_sent_at;
