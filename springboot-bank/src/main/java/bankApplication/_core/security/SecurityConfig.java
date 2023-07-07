package bankApplication._core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // 컴포넌트 스캔 시 @Bean이 붙은 메서드가 있다면 실행시켜서 리턴되는 값을 IoC에 등록한다.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginProcessingUrl("/login"); // POST /login x-www-form-urlencoded

        http.authorizeRequests(authorize ->  authorize.antMatchers("/").authenticated().anyRequest().permitAll());

        return http.build();

//        // 1. CSRF 해제
//        httpSecurity.csrf().disable();
//
//        // 2. iframe 거부
//        httpSecurity.headers().frameOptions().disable();
//
//        // 3. cors 설정
//
//        // x-www-from-urlencoded
//        httpSecurity.formLogin()
////                .usernameParameter("email") 이메일이 들어옴
//                .loginProcessingUrl("/login"); // POST /login x-www-form-
//
//        // UsernamePasswordAuthenticationFilter (Form POST x-www-form-urlencoded)
//        // 로그인 정보 세션에 저장하고 관리함.
//        httpSecurity.formLogin().disable();
//
//        // 위의 필터가 작동안하면 아래의 필터가 동작함.
//        // HttpBasicAuthenticationFilter (Header{username, password} 달고가는 형식)
//        // 매 요청마다 헤더에 로그인 정보 달고감(노출됨).
//        // 로그인 페이지를 통하지않고도 헤더의 정보를 통해 인증 가능함. 보안에 취약함.
//        httpSecurity.httpBasic().disable();
//
//        httpSecurity.authorizeRequests(expressionInterceptUrlRegistry ->
//                expressionInterceptUrlRegistry.antMatchers("/")
//                        .authenticated()
//                        .anyRequest()
//                        .permitAll());
//
//        return httpSecurity.build();
    }
}
