package com.smartsolutions.eschool.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "theme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id", nullable = false, length = 100)
    private Long userId;

    @Column(name = "inst_id")
    private Integer instituteId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "sidebar_bg", nullable = false, length = 100)
    private String sidebarBg;

    @Column(name = "sidebar_text", nullable = false, length = 100)
    private String sidebarText;

    @Column(name = "body_bg", nullable = false, length = 100)
    private String bodyBg;

    @Column(name = "body_text", nullable = false, length = 100)
    private String bodyText;

    @Column(name = "header_bg", nullable = false, length = 100)
    private String headerBg;

    @Column(name = "header_text", nullable = false, length = 100)
    private String headerText;

    @Column(name = "active_item_bg", nullable = false, length = 100)
    private String activeItemBg;

    @Column(name = "active_item_text", nullable = false, length = 100)
    private String activeItemText;
}
