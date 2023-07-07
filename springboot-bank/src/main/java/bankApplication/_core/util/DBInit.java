package bankApplication._core.util;

import bankApplication.user.User;
import bankApplication.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DBInit {

    private final PasswordEncoder passwordEncoder;

    // 서버 시작 시에 데이터 초기화
    @Bean
    CommandLineRunner initDB(UserRepository userRepository) {
        return args -> {
            User user = User.builder()
                    .username("username")
                    .password(passwordEncoder.encode("1234"))
                    .email("email@naver.com")
                    .fullName("fullName")
                    .status(true)
                    .roles("ROLE_USER")
                    .build();
            userRepository.save(user);
        };
    }
}
