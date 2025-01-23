//Program to demonstrate CRUD operation 
package com.tnsif.daytwentytwo.v1.usingpreparedstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection cn;
		List<Employee> empList;
		try {
			EmployeeService service = new EmployeeService();
			empList = service.getAllEmployees();
			System.out.println(empList);

			/*
			 * Employee e=new Employee(4,"Avinash", 45000, "Sales", "Manager");
			 * service.addEmployee(e);
			 */

			if (service.deleteEmployee(2))
				System.out.println("Record deleted successfully....");
			else
				System.out.println("Record not found");
			System.out.println("----------------------");

			Employee emp = service.getEmployeeById(1);
			System.out.println(emp);
			if (emp != null) {
				emp.setSalary(emp.getSalary() + 5000);
				if (service.updateEmployee(1, emp))
					System.out.println("Record updated successfully....");
				else
					System.out.println("Record Not Found");
			} else
				System.out.println("Record Not Found");
			empList = service.getAllEmployees();
			System.out.println(empList);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
