package com.smartsolutions.eschool.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "feeparticular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeParticularsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inst_id")
    private Integer instituteId;

    @Column(name = "name")
    private String name;

    @Column(name = "tuition_fee", precision = 10, scale = 2)
    private BigDecimal tuitionFee;

    @Column(name = "stationery", precision = 10, scale = 2)
    private BigDecimal stationery;

    @Column(name = "sports", precision = 10, scale = 2)
    private BigDecimal sports;

    @Column(name = "annual_fee", precision = 10, scale = 2)
    private BigDecimal annualFee;

    @Column(name = "electricity", precision = 10, scale = 2)
    private BigDecimal electricity;

    @Column(name = "maintenance", precision = 10, scale = 2)
    private BigDecimal maintenance;

    @Column(name = "miscellaneous", precision = 10, scale = 2)
    private BigDecimal miscellaneous;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


}
