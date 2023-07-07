package bankApplication.user;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Setter @Getter
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Getter @Setter
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private String fullName;

        public User toEntityWith(String encodedPassword) {
            return User.builder()
                    .username(username)
                    .password(encodedPassword)
                    .email(email)
                    .fullName(fullName)
                    .status(true)
                    .roles("ROLE_USER")
                    .build();
        }
    }
}
