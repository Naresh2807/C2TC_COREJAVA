package com.tns.ifet.assignment.statics;

public class Transaction {
    private final double transactionFee = 5.0;

    public final void performTransaction(Account account, double amount, boolean isDeposit) {
        if (isDeposit) {
            account.deposit(amount - transactionFee); // Deduct fee for deposit
            System.out.println("Transaction fee of " + transactionFee + " applied.");
        } else {
            if (amount + transactionFee <= account.getBalance()) {
                account.withdraw(amount + transactionFee); // Deduct fee for withdrawal
                System.out.println("Transaction fee of " + transactionFee + " applied.");
            } else {
                System.out.println("Insufficient balance to cover transaction and fee.");
            }
        }
    }
}

