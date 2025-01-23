//Program to Demonstrate Database Transaction 
package com.tnsif.daytwentyfour.transaction;

public class TransactionDemo {
	public static void main(String[] args) {
		try {
			// Checking Balance
			BankTransaction trans1 = new BankTransaction();
			float balance;
			balance = trans1.getBal(1001);
			if (balance != -1)
				System.out.println(balance);
			balance = trans1.getBal(1002);
			if (balance != -1)
				System.out.println(balance);

			// Withdrawing Balance
			trans1.withdraw(1003, 10000);
			//Checking Balance
			System.out.println(trans1.getBal(1001));
			System.out.println(trans1.getBal(1002));

			trans1.withdraw(1003, 180000);
			//Checking Balance
			System.out.println(trans1.getBal(1001));
			System.out.println(trans1.getBal(1002));

			// Deposit
			trans1.deposite(1001, 40000);
			//Checking Balance
			System.out.println(trans1.getBal(1001));
			System.out.println(trans1.getBal(1002));


			// Transferring Fund
			trans1.transferAmount(1001, 1002, 25000);

			//Checking Balance
			System.out.println(trans1.getBal(1001));
			System.out.println(trans1.getBal(1002));

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}