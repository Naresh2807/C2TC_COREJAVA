//Program to demonstrate Student entity 
//overriding of equals and hashCode methods 
package com.tnsif.dayseventeen.userdefinedobjects;

import java.util.Objects;

public class Student {
	int marks;
	String name;

	// Constructor
	public Student(String name, int marks) {
		this.marks = marks;
		this.name = name;
	}

	// Getters and Setters
	public int getMarks() {
		return marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	// Override equals() and hashCode() methods
	@Override
	public int hashCode() {
		return Objects.hash(marks, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return marks == other.marks && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]\n";
	}
}