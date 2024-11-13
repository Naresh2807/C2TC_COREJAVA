package com.tns.ifet.assignment.statics;

public class Bank {
    private static int totalAccounts = 0;

    public Bank() {
        // Increment totalAccounts each time a new Bank instance is created.
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}