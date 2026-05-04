package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Entity
@SQLDelete(sql = "UPDATE rules SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "rules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RulesEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "rules", columnDefinition = "LONGTEXT")
    private String rules;

}
