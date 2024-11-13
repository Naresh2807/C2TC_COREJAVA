//Program to implement student module
package com.tns.ifet.daytwelve.exception.daytwelve;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Executor {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			//Accept student details
			Student sOne = new Student();
			System.out.println("Enter the roll no: ");
			int rollNo = sc.nextInt();
			sOne.setRollNo(rollNo);
			System.out.println("Enter your name: ");
			String name = sc.nextLine();
			sc.nextLine();
			sOne.setName(name);
			System.out.println("Enter the no.of subjects ");
			int sub = sc.nextInt();
			sOne.setNoOfSubjects(sub);
			System.out.println("enter the marks for " + sub);
			int[] intArr = new int[sub];
			for (int i = 0; i < sub; i++) {

				intArr[i] = sc.nextInt();
			}
			//validate marks
			if (Service.validateMarks(intArr)) {

				sOne.setMarks(intArr);
				sOne.setPer(Service.calculatePercentage(intArr));

			}
			//display student details
			System.out.println("Student details: " + sOne);

		} catch (InvalidMarksException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}

		catch (NullPointerException | ArithmeticException |InputMismatchException e) {

			// e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

}