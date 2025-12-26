package org.bank.bankManagement.service;

import org.bank.bankManagement.entity.Accounts;
import org.bank.bankManagement.entity.Users;
import org.bank.bankManagement.repository.AccountRepository;
import org.bank.bankManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Accounts saveAccount(Accounts account) {
        if (account.getUser() != null && account.getUser().getId() != null) {
            Users user = userRepository.findById(account.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            account.setUser(user); // full user attach
        }
        return accountRepository.save(account);
    }

    public List<Accounts> getAllAccounts() {
        List<Accounts> accounts = accountRepository.findAll();
        accounts.forEach(a -> a.getUser().setPassword(null)); // hide password
        return accounts;
    }

    public Optional<Accounts> getAccountById(Long id) {
        Optional<Accounts> account = accountRepository.findById(id);
        account.ifPresent(a -> {
            if (a.getUser() != null) a.getUser().setPassword(null); // hide password
        });
        return account;
    }
}
