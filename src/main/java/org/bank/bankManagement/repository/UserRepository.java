package org.bank.bankManagement.repository;

import org.apache.catalina.User;
import org.bank.bankManagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
