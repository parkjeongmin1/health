package com.health.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pt_app")
@Getter
@Setter
public class PtApp {
    @Id
    @Column(name = "pt_app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary키 생성
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "pt_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pt pt;
}
