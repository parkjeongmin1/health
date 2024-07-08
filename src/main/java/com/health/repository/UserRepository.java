package com.health.repository;

import com.health.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); //회원가입시 중복 이메일이 있는 확인
}
