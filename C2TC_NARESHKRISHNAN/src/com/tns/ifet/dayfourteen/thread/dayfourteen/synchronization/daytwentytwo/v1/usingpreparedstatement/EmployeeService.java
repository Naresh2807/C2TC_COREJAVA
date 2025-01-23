//Program to implement CRUD operation
package com.tnsif.daytwentytwo.v1.usingpreparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
	PreparedStatement pst;
	ResultSet rs;
	Connection cn;

	public EmployeeService() throws ClassNotFoundException, SQLException {
		cn = DBUtil.getCn();
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> empList = new ArrayList<Employee>();
		pst = cn.prepareStatement("SELECT * FROM employee");
		rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setEmpId(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			e.setDeptName(rs.getString(4));
			e.setPost(rs.getString(5));
			empList.add(e);
		}
		return empList;
	}

	@Override
	public Employee getEmployeeById(int empId) throws SQLException {
		Employee e=new Employee();
		pst = cn.prepareStatement("SELECT * FROM employee WHERE empid=?");
		pst.setInt(1, empId);
		rs = pst.executeQuery();
		while(rs.next())
		{
			e.setEmpId(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			e.setDeptName(rs.getString(4));
			e.setPost(rs.getString(5));
		}
			
		return e;
	}

	@Override
	public void addEmployee(Employee e) throws SQLException {
		pst = cn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");
		pst.setInt(1, e.getEmpId());
		pst.setString(2, e.getEmpName());
		pst.setFloat(3, e.getSalary());
		pst.setString(4, e.getDeptName());
		pst.setString(5, e.getPost());
		int n = pst.executeUpdate();
		if (n > 0)
			System.out.println(n + "record inserted successfully....");
	}

	@Override
	public boolean deleteEmployee(int empId) throws SQLException {
		pst = cn.prepareStatement("DELETE FROM employee WHERE empid=?");
		pst.setInt(1, empId);
		int n = pst.executeUpdate();
		return n > 0;

	}

	@Override
	public boolean updateEmployee(int empId, Employee e) throws SQLException {
		pst = cn.prepareStatement("UPDATE employee set empname=?, salary=?, deptname=?, post=? WHERE empid=?");
		pst.setInt(5, empId);
		pst.setString(1, e.getEmpName());
		pst.setFloat(2, e.getSalary());
		pst.setString(3, e.getDeptName());
		pst.setString(4, e.getPost());
		int n = pst.executeUpdate();
		return n > 0;
	}

}
