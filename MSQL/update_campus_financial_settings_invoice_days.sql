-- Migration script to add invoice generation and due day settings to campus_financial_settings
ALTER TABLE campus_financial_settings ADD COLUMN invoice_generation_day INT DEFAULT 1;
ALTER TABLE campus_financial_settings ADD COLUMN invoice_due_day INT DEFAULT 10;
