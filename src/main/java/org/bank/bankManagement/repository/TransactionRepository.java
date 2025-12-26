package org.bank.bankManagement.repository;

import org.bank.bankManagement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
