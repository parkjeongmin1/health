package com.health.entity;

import com.health.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trainer")
@Getter
@Setter
public class Trainer {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "trainer_password")
    private String password;

    @Column(name = "trainer_email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "trainer_gender")
    private Gender gender;
}
