package com.health.dto;

import com.health.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class UserFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String userName;

    @NotNull(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상 16자 이하로 입력해주세요.")
    private String userPassword;

    @NotNull(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String userEmail;

    @NotNull(message = "생일은 필수 입력 값입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @NotNull(message = "성별은 필수 입력 값입니다.")
    private Gender userGender;
}
