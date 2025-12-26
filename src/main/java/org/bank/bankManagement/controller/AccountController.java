package org.bank.bankManagement.controller;

import org.bank.bankManagement.entity.Accounts;
import org.bank.bankManagement.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Accounts createAccount(@RequestBody Accounts account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/all")
    public List<Accounts> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Accounts getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
