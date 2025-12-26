package org.bank.bankManagement.service;

import org.bank.bankManagement.entity.Users;
import org.bank.bankManagement.entity.Users;
import org.bank.bankManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
