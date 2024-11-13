//Program to define service class
package com.tns.ifet.daytwelve.exception.daytwelve;

public class Service   {
	
	
	public static boolean validateMarks(int[] marks) throws InvalidMarksException {
		for(int ele:marks)
		{
			if (ele<0 || ele>100)
				throw new InvalidMarksException("Marks should be between 0 to 100");
		}
		return true;
		
	}
	public static float calculatePercentage(int[] marks)
	{
		int total=0;
		for(int value:marks)
			total+=value;
		float per=total/marks.length;
		return per;
		
	}

}
