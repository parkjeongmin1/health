package com.health.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@Table(name = "post")
@Getter
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary키 생성
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "longtext")
    private String content;

    @Column(name = "views")
    private int views = 0;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
