package com.health.entity;

import com.health.dto.UserFormDto;
import com.health.enums.Gender;
import com.health.service.UserService;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "user_birth")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;



    //JPA에서는 영속성 컨텍스트에 엔티티 객체를 통해 CRUD를 진행하므로 반드시 엔티티 객체로 변경시켜줘야 한다.
    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        //패스워드 암호화
        String password = passwordEncoder.encode(userFormDto.getUserPassword());

        User user = new User();

        user.setPassword(password);
        user.setEmail(userFormDto.getUserEmail());
        user.setName(userFormDto.getUserName());
        user.setBirth(userFormDto.getBirth());
        user.setGender(userFormDto.getUserGender());

        return user;
    }
}
