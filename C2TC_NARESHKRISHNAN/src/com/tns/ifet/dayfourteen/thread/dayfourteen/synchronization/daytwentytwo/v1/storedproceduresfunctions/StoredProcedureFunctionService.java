//Program to define student service class using stored procedure and functions
package com.tnsif.daytwentytwo.v1.storedproceduresfunctions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.tnsif.daytwentytwo.v1.usingpreparedstatement.DBUtil;

public class StoredProcedureFunctionService {
	static Connection con;
	static Statement st;
	static PreparedStatement pst;
	static CallableStatement cst;
	static {
		try {
			con = DBUtil.getCn();

			st = con.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudents() throws SQLException {
		boolean result = st.execute("call deleteStudent()");
		if (!result) // result==false
		{
			System.out.println(st.getUpdateCount() + " record(s) Deleted");
		}
	}

	public static void deleteStudentsByCity(String city) throws SQLException {
		// boolean result=st.execute("call deleteStudentBycity('"+city+"')"); //static
		// query
		pst = con.prepareStatement("call deleteStudentBycity(?)"); // dynamic query
		pst.setString(1, city);
		boolean result = pst.execute();
		if (!result) // result==false
		{
			System.out.println(pst.getUpdateCount() + " record(s) Deleted");
		}
	}

	public static String getstudentName(int id) throws SQLException {
		cst = con.prepareCall("{? = call getStudentNameById(?)}");
		cst.setInt(2, id);
		cst.registerOutParameter(1, Types.VARCHAR);
		cst.execute();
		String name = cst.getString(1);
		return name;
	}

}
