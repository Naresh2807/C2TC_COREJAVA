package com.tns.ifet.daytwelve.exception.daytwelve;

import java.util.Arrays;

public class Student {
	private int rollNo;
	private String name;
	private int[] marks;
	private int noOfSubjects;
	private float per;
	
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getMarks() {
		return marks;
	}

	public int getNoOfSubjects() {
		return noOfSubjects;
	}

	public void setNoOfSubjects(int noOfSubjects) {
		this.noOfSubjects = noOfSubjects;
	}

	
	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public void setPer(float per) {
		this.per = per;
	}

	public float getPer()
	{
		return this.per;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + Arrays.toString(marks) + ", noOfSubjects="
				+ noOfSubjects + "Percentage : "+per+" ]";
	}

}