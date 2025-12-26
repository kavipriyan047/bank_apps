package org.bank.bankManagement.dto;

public class TransactionRequest {
    private Long accountId;
    private Double amount;

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
