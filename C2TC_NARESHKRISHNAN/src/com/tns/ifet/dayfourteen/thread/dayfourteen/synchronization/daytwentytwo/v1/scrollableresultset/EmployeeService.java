//Program to define service class for Employee table
package com.tnsif.daytwentytwo.v1.scrollableresultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeService {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	static {
		try {
		con=com.tnsif.daytwentytwo.v1.usingpreparedstatement.DBUtil.getCn();
		
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("SELECT * FROM employee");
			rs.next();
			//display();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void display() throws SQLException
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
		System.out.println("---------------------");
	}
	
	public static void showFirst() throws SQLException
	{
		rs.first();
		display();
	}
	public static void showLast() throws SQLException
	{
		rs.last();
		display();
	}
	
	public static void showNext() throws SQLException
	{
		rs.next();
		display();
	}
	public static void showPrevious() throws SQLException
	{
		rs.previous();
		display();
	}
	
	public static void updateSalary(float salary) throws SQLException
	{
		rs.updateFloat(3, salary);
		rs.updateRow();
		display();
		
	}
}
