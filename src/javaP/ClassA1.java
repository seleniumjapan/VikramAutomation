package javaP;

import java.util.Scanner;

public class ClassA1 {

	int i = 10;
	String s = "Java";
	
	public void method1() {
		System.out.println("C#");
	}
	
	public void addNumber() {
		int t = i + 10;
		System.out.println("Sum is :" + t);
	}
	

	
	
	public void findPrimeNumber() {
		
	}
	
	public static void main(String[] args) {
		
	
		
		ClassA1 obj = new ClassA1();
		obj.method1();
		obj.addNumber();
		
	//	new ClassA1().method1();
	//	new ClassA1().addNumber();
	}
}
