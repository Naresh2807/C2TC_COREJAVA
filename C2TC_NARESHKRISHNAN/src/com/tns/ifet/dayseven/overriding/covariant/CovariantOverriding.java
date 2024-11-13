package com.tns.ifet.dayseven.overriding.covariant;

class Color {
	// method getcolor returns an object of type color
	protected Color getColor() {
		Color s = new Color();
		return s;
	}
}

//this class will inherit from the class color and will override the getcolor() method returning the object of the type red class
class Red extends Color {
	@Override
	public Red getColor() {
		Red s = new Red();
		return s;
	}
}

public class CovariantOverriding {
	public static void main(String[] args) {
		Color c1 = new Color();
		Color c2 = c1.getColor();
		System.out.println(c2);

		Red r1 = new Red();
		Red r2 = r1.getColor();
		System.out.println(r2);
	}
}
