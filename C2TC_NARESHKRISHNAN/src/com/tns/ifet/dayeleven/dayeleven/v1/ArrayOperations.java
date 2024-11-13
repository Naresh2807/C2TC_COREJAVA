//Program to define Array Operations
package com.tns.ifet.dayeleven.dayeleven.v1;

public class ArrayOperations {

	int intArray[] ;
	
	public ArrayOperations() {
		super();
		
	}

	public ArrayOperations(int[] intArray) {
		super();
		this.intArray = intArray;
		
	}
	
	public void displayArray() {
		for(int no:intArray) {
			System.out.println("The array elements are: "+no);
		}
	}
	
	public int getElement(int position) {
		return intArray[position];
	}
	
	
}
