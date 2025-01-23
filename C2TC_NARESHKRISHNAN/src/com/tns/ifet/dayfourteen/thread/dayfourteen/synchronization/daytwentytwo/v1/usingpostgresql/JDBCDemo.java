package com.tnsif.daytwentytwo.v1.usingpostgresql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded Successfully...");
		Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Admin@123");
		System.out.println("Connection Established Successfully..");
		Statement st=cn.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT * FROM cars");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}

	}

}
