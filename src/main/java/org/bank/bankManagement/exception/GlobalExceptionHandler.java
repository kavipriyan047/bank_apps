package org.bank.bankManagement.exception;
import java.util.UUID;

class Utils{
    public static String generateAccountNumber() {
        return "ACC" + UUID.randomUUID().toString().substring(0, 8);
    }
}
