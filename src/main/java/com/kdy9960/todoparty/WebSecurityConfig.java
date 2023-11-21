package com.kdy9960.todoparty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Bean을 주입해서 사용할것이기 때문에 @Configuration 주입
public class WebSecurityConfig {

    @Bean // UserService에서 사용되는 passwordEncoder는 기본설정으로 사용할수있지만 BCryptPasswordEncoder형식으로 사용하기위해서 Bean으로 작성
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
