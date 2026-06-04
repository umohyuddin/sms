-- Update campus_financial_settings table to add fee_recurrence_rule_id
ALTER TABLE campus_financial_settings 
ADD COLUMN fee_recurrence_rule_id BIGINT DEFAULT NULL AFTER is_active;

-- Optional: Add foreign key constraint if you want to ensure data integrity
-- ALTER TABLE campus_financial_settings 
-- ADD CONSTRAINT fk_campus_financial_settings_recurrence 
-- FOREIGN KEY (fee_recurrence_rule_id) REFERENCES fee_recurrence_rules(id);
