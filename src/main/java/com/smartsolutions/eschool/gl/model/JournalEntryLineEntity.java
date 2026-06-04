package com.smartsolutions.eschool.gl.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "gl_journal_entry_lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_entry_id", nullable = false)
    private JournalEntryEntity journalEntry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private GLAccountEntity account;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "debit", precision = 18, scale = 4)
    private BigDecimal debit = BigDecimal.ZERO;

    @Column(name = "credit", precision = 18, scale = 4)
    private BigDecimal credit = BigDecimal.ZERO;

    @Column(name = "campus_id")
    private Long campusId;

    @Column(name = "reference_id")
    private Long referenceId; // Generic ID for sub-ledger (student_id, employee_id, etc.)

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
