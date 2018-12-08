package com.serge.rough;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postalCode = "1234.0";
		String s = null;
		if (postalCode.endsWith(".0")) {
		s = postalCode.substring(0, postalCode.length()-2);}
		System.out.println(s);

	}

}
