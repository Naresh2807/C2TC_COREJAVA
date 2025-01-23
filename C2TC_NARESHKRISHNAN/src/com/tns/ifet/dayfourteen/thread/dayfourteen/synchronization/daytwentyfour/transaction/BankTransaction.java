//Program to demonstrate JDBC Transaction Functions
package com.tnsif.daytwentyfour.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tnsif.daytwentyfour.dao.DBUtil;

public class BankTransaction {

	private PreparedStatement ps = null;
	private Connection con = null;
	private ResultSet rs = null;

	public BankTransaction() {
		con = DBUtil.getConnetion();
	}
    
	//function to Validate the Account No
	boolean validateAccount(int accNo)
	{
		boolean status;
		try {
			ps = con.prepareStatement("SELECT accBal From account WHERE accNo=?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			if (rs.next()) {
			//	bal = rs.getInt(1);
				status=true;
			} else {
				System.err.println("No such account");
				status=false;
			}
		} catch (Exception e) {
			System.err.println("Unable to fetch the data");
			status=false;
		}
		return status;
	}
	int getBal(int accNo) {
		int bal = 0;
		try {
			ps = con.prepareStatement("SELECT accBal From account WHERE accNo=?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			if (rs.next()) {
				bal = rs.getInt(1);
			} else {
				System.err.println("No such account");
				bal = -1;
			}
		} catch (Exception e) {
			System.err.println("Unable to fetch the data");
		}
		return bal;
	}

	void withdraw(int accNo, int amt) {
		int accBal = getBal(accNo);
		if (accBal != -1) {
			try {
				if ((accBal - amt) < 1000) {
					throw new Exception("Not sufficient  balance to withdraw");
				} else
					accBal = accBal - amt;
				ps = con.prepareStatement("UPDATE account SET accBal=? WHERE accNo=?");
				ps.setInt(1, accBal);
				ps.setInt(2, accNo);
				int i = ps.executeUpdate();
				System.out.println(i + " row is updated");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
	}

	void deposite(int accNo, int amt) throws Exception {
		int accBal = getBal(accNo);
		try {
			if (amt > 25000) {
				throw new Exception(amt+"Amount exceeds daily limit");
			}
			accBal = accBal + amt;
			ps = con.prepareStatement("UPDATE account SET accBal=? where accNo=?");
			ps.setInt(1, accBal);
			ps.setInt(2, accNo);
			int i = ps.executeUpdate();
			System.out.println(i + " row is updated");
		} catch (Exception e) {
			throw new Exception(amt +" Amount exceeds daily limit 25000");			
		}
	}

	void transferAmount(int wAcct, int dAcct, int amt) {
		try {
			con.setAutoCommit(false);
			withdraw(wAcct, amt);
			deposite(dAcct, amt);
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			System.out.println("Unable to complete transaction at this moment");
		}
	}

}
