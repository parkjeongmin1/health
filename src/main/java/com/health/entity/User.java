package com.health.entity;

import com.health.dto.UserFormDto;
import com.health.enums.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "user")
@Getter
@Builder
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

    //JPA에서는 영속성 컨텍스트에 엔티티 객체를 통해 CRUD를 진행하므로 반드시 엔티티 객체로 변경시켜줘야 한다.
    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        //패스워드 암호화
        String password = passwordEncoder.encode(userFormDto.getUserPassword());

        User user = User.builder()
                .name(userFormDto.getUserName())
                .email(userFormDto.getUserEmail())
                .gender(Gender.valueOf(String.valueOf(userFormDto.getUserGender())))
                .password(password)
                .build();

        return user;
    }
}
