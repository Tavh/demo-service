package com.tav.demo.demoservice.clr;

import com.tav.demo.demoservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
@RequiredArgsConstructor
public class CustomCLR implements CommandLineRunner {
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        final String url = "http://localhost:8080/users";
        final User user = User.builder()
                .email("tav@gmail.com")
                .password("1234")
                .build();
        final ResponseEntity<User> res = restTemplate.postForEntity(url, user,  User.class);
        final User responseUser = res.getBody();
        System.out.println(responseUser);
    }
}
