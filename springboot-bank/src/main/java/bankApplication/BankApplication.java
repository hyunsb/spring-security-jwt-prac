package bankApplication;

import bankApplication.user.User;
import bankApplication.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BankApplication {

    @GetMapping("/bank")
    public String bank(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails.getUsername();
    }

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
