package com.health.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "pt_app")
@Getter
@Builder
public class PtApp {
    @Id
    @Column(name = "pt_app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary키 생성
    private Long id;

    @Column(name = "created_at")
    @CreatedDate // 저장했을 때 현재 시간에 맞춰서 저장해준다.
    private LocalDateTime createdAt;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "pt_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pt pt;
}
