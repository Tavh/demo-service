package com.tav.demo.demoservice.services;

import com.tav.demo.demoservice.annotations.LogParameters;
import com.tav.demo.demoservice.errors.exceptions.AlreadyExistsException;
import com.tav.demo.demoservice.model.User;
import com.tav.demo.demoservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User get(final long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User get(final String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User create(final User user) throws Exception {
        if (userRepository.findById(user.getId()).orElse(null) != null) {
            throw new Exception("user already exists");
        }
        return userRepository.save(user);
    }

    public User update(final User user) throws Exception {
        if (!isExists(user.getId())) {
            throw new Exception("Couldn't find user with id: " + user.getId());
        }
        return userRepository.save(user);
    }

    private boolean isExists(final long id) {
        return userRepository.existsById(id);
    }

    @LogParameters
    public void delete(final long id) throws AlreadyExistsException {
        if (!isExists(id)) {
            throw new AlreadyExistsException(id);
        }
        userRepository.deleteById(id);
    }
}
