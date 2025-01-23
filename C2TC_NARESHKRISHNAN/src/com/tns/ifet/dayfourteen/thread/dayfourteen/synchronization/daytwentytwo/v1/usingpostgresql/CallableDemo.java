package com.tnsif.daytwentytwo.v1.usingpostgresql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded Successfully...");
		Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin@123");
		System.out.println("Connection Established Successfully..");
		CallableStatement cst=cn.prepareCall("{?= call getBalance(?)}");
		cst.setInt(2, 2);
		cst.registerOutParameter(1, Types.NUMERIC);
		cst.execute();
		System.out.println(cst.getBigDecimal(1));
		
		

	}

}
