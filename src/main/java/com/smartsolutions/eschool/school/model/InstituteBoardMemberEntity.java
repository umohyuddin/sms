package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import com.smartsolutions.eschool.user.model.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Table(name = "institute_board_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_board_members SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class InstituteBoardMemberEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "term_start")
    private LocalDate termStart;

    @Column(name = "term_end")
    private LocalDate termEnd;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
