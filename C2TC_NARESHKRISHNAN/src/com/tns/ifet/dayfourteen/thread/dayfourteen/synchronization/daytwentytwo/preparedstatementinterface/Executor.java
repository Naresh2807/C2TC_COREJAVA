//Program to demonstrate PreparedStatement Interface
package com.tnsif.daytwentytwo.preparedstatementinterface;



public class Executor {

	public static void main(String[] args) {
		System.out.println("Employee Details Retrieve Operation");	
		PreparedStatementDemo.showEmp();
		PreparedStatementDemo.updateEmpName(3, "Pratima");
		PreparedStatementDemo.updateEmpSalary(3, 87000);
		System.out.println("Employee Details After Update Operation");
		PreparedStatementDemo.showEmp();
		PreparedStatementDemo.addEmployee(11, "Amit", 45000);
		System.out.println("Employee Details After Create Operation");
		PreparedStatementDemo.showEmp();
		if(PreparedStatementDemo.deleteEmp(2)==false)
			System.err.println("No such employee...");
			else
				System.out.println("Employee removed....");
		System.out.println("Employee Details After Delete Operation");
		PreparedStatementDemo.showEmp();

	}

}
