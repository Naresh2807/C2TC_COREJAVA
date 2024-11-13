package com.tns.ifet.dayseven.overriding.covariant;

public class CovariantOverridingDemo {
	public static void main(String arg[])
			throws CloneNotSupportedException
		{
			// new student object created
			Student student1 = new Student(1, "MCA", "Kapil");
			student1.printData();

			// Student object created using clone method
			// assuming type casting is required
			Student student2 = (Student) student1.clone();
			student2.printData();
		
		 //using covariant return type no need to type cast 
		 /* Student student2 =student1.clone(); 
		 * student2.setName("Sachin"); 
		 * student2.setRollNo(2);
		 * student2.printData();
		 */		
		}
}
