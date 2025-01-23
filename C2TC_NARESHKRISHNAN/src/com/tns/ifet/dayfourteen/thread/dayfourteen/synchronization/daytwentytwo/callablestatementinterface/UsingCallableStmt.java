//Program to demonstrate Callable Statement Interface
package com.tnsif.daytwentytwo.callablestatementinterface;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class UsingCallableStmt {

	private static CallableStatement cs = null;
	private static Statement st = null;
	private static Connection connection;
	static {
		connection = DBUtil.getConnection();
		if (connection != null)
			System.out.println("JDBC:connection is taken..");

	}

	static int createProcedure() {
		int n = 0;
		try {
			String sql = "CREATE or replace DEFINER=`root`@`localhost` PROCEDURE `addEmp`()\r\n" + "BEGIN\r\n"
					+ "INSERT INTO `test`.`emp`(`id`,`name`,`salary`)\r\n" + "VALUES(8,'Sharath',34000);\r\n"
					+ "INSERT INTO `test`.`emp`(`id`,`name`,`salary`)\r\n" + "VALUES(9,'Shirish',76000);\r\n"
					+ "INSERT INTO `test`.`emp`(`id`,`name`,`salary`)\r\n" + "VALUES(10,'Shraddha',37000);\r\n" + "END";

			st = connection.createStatement();
			n = st.executeUpdate(sql);

		} catch (SQLException e) {
			System.err.println("Error : " + e.getMessage());
		}
		return n;
	}

	static int callProcedure() {
		int n = 0;
		try {

			cs = (CallableStatement) connection.prepareCall("{call addEmp()}");
			n = cs.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error : " + e.getMessage());
		}
		return n;
	}

	static int createProcedure1() {
		int n = 0;
		try {
			String sql = "CREATE DEFINER=`root`@`localhost` PROCEDURE `addEmployee`(id int, name varchar(50), salary double )\r\n"
					+ "BEGIN\r\n" + "insert into emp values(id,name,salary);\r\n" + "END";
			st = connection.createStatement();
			n = st.executeUpdate(sql);

		} catch (SQLException e) {
			System.err.println("Error : " + e.getMessage());
		}
		return n;
	}

	static int callProcedure1(int id, String name, double salary) {
		int n = 0;
		try {

			cs = (CallableStatement) connection.prepareCall("{call addEmployee(?,?,?)}");
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setDouble(3, salary);
			n = cs.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error : " + e.getMessage());
		}
		return n;
	}

	static void closeConnection() {

		try {
			connection.close();
			cs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
