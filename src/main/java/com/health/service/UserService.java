package com.health.service;

import com.health.entity.User;
import com.health.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    //회원가입
    public User saveUser(User user) {
        DuplicateUser(user);
        return userRepository.save(user);
    }

    //회원 중복체크
    private void DuplicateUser(User user){
        User findUser = userRepository.findByEmail(user.getEmail());

        if (findUser != null) {
            throw new IllegalStateException("이미 가입된 이메일 입니다."); // IllegalStateException: 조건이 충족되지 않는 경우
        }
    }
}
