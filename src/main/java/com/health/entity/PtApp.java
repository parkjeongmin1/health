package com.health.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Entity
@Table(name = "pt_app")
@Getter
public class PtApp {
    @Id
    @Column(name = "pt_app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary키 생성
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "pt_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pt pt;
}
