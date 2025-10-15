package com.example.boarding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll() // 모든 요청 허용
                )
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (REST API 테스트용)
                .formLogin(AbstractHttpConfigurer::disable); // 기본 로그인폼 비활성화
        return http.build();
    }
}
