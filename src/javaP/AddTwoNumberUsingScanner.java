package javaP;

import java.util.Scanner;

public class AddTwoNumberUsingScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1,num2,sum;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number");
		num1 = scan.nextInt();
		
		System.out.println("Enter second number");
		num2 = scan.nextInt();
		
		scan.close();
		sum = num1 + num2;
		System.out.println("Sum of these numbers are : " + sum);
		
		
	}

}
