package com.health.controller;

import com.health.dto.UserFormDto;
import com.health.entity.Post;
import com.health.entity.PtApp;
import com.health.entity.User;
import com.health.enums.Gender;
import com.health.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    //메인페이지
    @GetMapping(value = "/")
    public String indexPage() {

        return "index";
    }

    //user 로그인 페이지
    @GetMapping(value = "/login/user")
    public String userLoginForm() {
        return "user/userLogin";
    }

    //user 회원가입 페이지
    @GetMapping(value = "/register/user/new")
    public String userRegisterForm(Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "user/userRegister";
    }

    //user 회원가입 처리
    @PostMapping(value = "/register/user/newsign")
    public String userRegisterNew(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model) {
        //@Valid: 유효성을 검증하려는 객체 앞에 붙인다.
        //BindingResult: 유효성 검증 후 결과가 들어있다.

        //유효성 검증 에러 발생시 회원가입 페이지로 이동시킴
        if (bindingResult.hasErrors()) return "user/userRegister";

        try {

            User user = User.createUser(userFormDto, passwordEncoder);
            // UserService를 사용하여 회원 등록
            userService.saveUser(user);

        } catch (IllegalStateException e) {
            // 회원가입이 되어있다면
            model.addAttribute("errorMessage", e.getMessage());
            return "user/userRegister";
        }
        return "redirect:/";
    }

    //로그인 실패
    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "user/userLogin"; //로그인 페이지로 그대로 이동
    }
}
