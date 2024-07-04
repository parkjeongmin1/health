package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/{id}}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        // TODO : 비지니스 로직 구현
        return null;
    }

}
