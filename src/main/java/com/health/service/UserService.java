package com.health.service;

import com.health.entity.User;
import com.health.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
