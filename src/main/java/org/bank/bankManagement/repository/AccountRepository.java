package org.bank.bankManagement.repository;


import org.bank.bankManagement.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

}
