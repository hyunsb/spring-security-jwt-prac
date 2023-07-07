package bankApplication.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserRequest.JoinDTO joinDTO) {
        // validateJoinDTO(joinDTO);

        // 회원가입 요청 -> 시큐리티는 패스워드 인코딩이 무조건 되어야 한다.
        String encodedPassword = passwordEncoder.encode(joinDTO.getPassword());

        User user = joinDTO.toEntityWith(encodedPassword);
        userRepository.save(user);

        return ResponseEntity.ok("ok");
    }
}
