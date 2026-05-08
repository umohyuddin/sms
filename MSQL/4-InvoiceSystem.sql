-- Invoice/Voucher System Updates

DROP TABLE IF EXISTS student_fee_invoice_details;
DROP TABLE IF EXISTS student_fee_invoices;

CREATE TABLE student_fee_invoices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    invoice_number VARCHAR(50) UNIQUE NOT NULL,
    student_id BIGINT NOT NULL,
    academic_year_id BIGINT NOT NULL,
    month VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    total_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    late_fee_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    discount_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    paid_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    balance DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    due_date DATE,
    invoice_date DATE NOT NULL,
    status ENUM('UNPAID', 'PARTIAL', 'PAID', 'CANCELLED') DEFAULT 'UNPAID',
    organization_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at TIMESTAMP,
    deleted_by VARCHAR(50),
    CONSTRAINT fk_invoice_student FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_invoice_academic_year FOREIGN KEY (academic_year_id) REFERENCES academic_years(id)
);

CREATE TABLE student_fee_invoice_details (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    invoice_id BIGINT NOT NULL,
    fee_assignment_id BIGINT NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_detail_invoice FOREIGN KEY (invoice_id) REFERENCES student_fee_invoices(id),
    CONSTRAINT fk_detail_assignment FOREIGN KEY (fee_assignment_id) REFERENCES student_fee_assignments(id)
);

CREATE INDEX idx_invoice_student_year ON student_fee_invoices(student_id, academic_year_id);
CREATE INDEX idx_invoice_org ON student_fee_invoices(organization_id);
