package org.bank.bankManagement.controller;

import org.bank.bankManagement.entity.Users;
import org.bank.bankManagement.entity.Users;
import org.bank.bankManagement.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        userService.saveUser(user);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return "JWT Token Generated (mock)";
    }
}
