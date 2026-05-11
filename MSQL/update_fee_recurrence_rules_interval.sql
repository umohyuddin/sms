-- Migration script to add occurrence_interval to fee_recurrence_rules table
ALTER TABLE fee_recurrence_rules ADD COLUMN occurrence_interval INT;

-- Update existing data with standard intervals
UPDATE fee_recurrence_rules SET occurrence_interval = 0 WHERE code = 'ONE_TIME';
UPDATE fee_recurrence_rules SET occurrence_interval = 1 WHERE code = 'MONTHLY';
UPDATE fee_recurrence_rules SET occurrence_interval = 3 WHERE code = 'QUARTERLY';
UPDATE fee_recurrence_rules SET occurrence_interval = 6 WHERE code = 'HALF_YEARLY';
UPDATE fee_recurrence_rules SET occurrence_interval = 12 WHERE code = 'ANNUAL';
UPDATE fee_recurrence_rules SET occurrence_interval = 4 WHERE code = 'PER_TERM';
UPDATE fee_recurrence_rules SET occurrence_interval = 0 WHERE code = 'ON_DEMAND';
