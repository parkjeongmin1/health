package com.health.entity;

import com.health.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;
}