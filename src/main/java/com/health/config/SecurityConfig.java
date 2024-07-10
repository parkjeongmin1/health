package com.health.config;

import com.health.config.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // Spring Security filterChain이 자동으로 포함되는 클래스를 만들어준다.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //1. 페이지 접근에 관한 설정(인가)
        httpSecurity.authorizeHttpRequests( authorize -> authorize
                        //모든 사용자가 로그인(인증) 없이 접근할 수 있도록 설정
                        .requestMatchers("/css/**", "/js/**", "/img/**", "/images/**", "/fonts/**").permitAll()
                        .requestMatchers("/", "/user/**", "/register/**","/login/**", "/public/**").permitAll()
                        .requestMatchers("/favicon.ico", "/error").permitAll()
                        .anyRequest().authenticated()
                )
                //2. 로그인에 관한 설정
                .formLogin(formLogin -> formLogin
                        .loginPage("/login/user") // 로그인 페이지 URL
                        .defaultSuccessUrl("/") // 로그인 성공시 이동할 페이지 URL
                        .usernameParameter("email") // ★로그인시 id로 사용할 파라미터 이름(내 사이트에 맞는걸로)
                        .failureUrl("/login/error") // 로그인 실패시 이동할 페이지
                )
                //3. 로그아웃에 관한 설정
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃시 이동할 URL
                        .logoutSuccessUrl("/") // 로그아웃 성공시 이동할 URL
                )
                //4. 인증되지 않은 사용자의 접근에 관한 설정
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                )
//                .rememberMe(Customizer.withDefaults()); // 로그인 이후 세션을 통해 로그인을 유지

                // 로그인 이후 세션을 통해 로그인을 유지
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(3600) // 1시간 (3600초)
                );


        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}