//Program to demonstrate Statement Interface
package com.tnsif.daytwentytwo.v1.statementinterface;

public class Executor {

	public static void main(String[] args) {
		UsingStatementInterface.showEmp();
		System.out.println("----------------------------------------------");
		System.out.println(UsingStatementInterface.updateEmpName(5, "Neha"));
		UsingStatementInterface.updateEmpSalary(5, 65000);
		System.out.println("-------------After Updating Name and Salary------------");
		UsingStatementInterface.showEmp();
		UsingStatementInterface.deleteEmp(5);
		UsingStatementInterface.deleteEmp(101);
		UsingStatementInterface.deleteEmp(102);
		System.out.println("-----------After Deleting --------------------");
		UsingStatementInterface.showEmp();

	}

}
