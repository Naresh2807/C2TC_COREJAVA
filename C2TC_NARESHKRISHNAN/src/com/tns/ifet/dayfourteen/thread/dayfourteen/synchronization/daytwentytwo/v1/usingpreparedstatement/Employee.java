//Program to define Employee entity
package com.tnsif.daytwentytwo.v1.usingpreparedstatement;

public class Employee {
	private int empId;
	private String empName;
	private float salary;
	private String deptName;
	private String post;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, float salary, String deptName, String post) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptName = deptName;
		this.post = post;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "\nEmployee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptName=" + deptName
				+ ", post=" + post + "]";
	}
	
	
}
