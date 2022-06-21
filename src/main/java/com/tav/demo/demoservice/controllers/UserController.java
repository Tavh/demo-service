package com.tav.demo.demoservice.controllers;

import com.tav.demo.demoservice.model.User;


import com.tav.demo.demoservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) throws Exception {
        return userService.create(user);
    }

    @GetMapping("{id}")
    public User get(@PathVariable final long id) {
        return userService.get(id);
    }

    @GetMapping("by-email")
    public User get(@RequestParam final String email) {
        return userService.get(email);
    }

    @PutMapping
    public User update(@RequestBody final User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final long id) throws Exception {
        userService.delete(id);
    }
}
