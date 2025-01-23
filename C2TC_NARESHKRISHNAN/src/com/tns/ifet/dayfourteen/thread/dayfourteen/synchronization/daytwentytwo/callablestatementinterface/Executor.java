//Program to demonstrate Callable Statement Interface
package com.tnsif.daytwentytwo.callablestatementinterface;

public class Executor {

	public static void main(String[] args) {
		int res = 0;

		/*
		 * res = UsingCallableStmt.createProcedure1(); if (res == 1)
		 * System.out.println("Procedure Created.....");
		 */

		res = UsingCallableStmt.callProcedure1(1, "Amit", 60000);
		if (res != 0)
			System.out.println("Procedure Executed.....");
		res = UsingCallableStmt.callProcedure1(2, "Pooja", 78000);
		if (res != 0)
			System.out.println("Procedure Executed.....");
		res = UsingCallableStmt.callProcedure1(3, "Nidhi", 71000);
		if (res != 0)
			System.out.println("Procedure Executed.....");
	}

}
