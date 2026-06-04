package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Entity
@SQLDelete(sql = "UPDATE expenses SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "expenses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cmp_id", nullable = false)
    private Long campusId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "details")
    private String details;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    @PrePersist
    public  void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
