package javaP;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		
		int num;
		System.out.println("Enter an integer to check if it's Odd or Even");
		
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		
		if (num % 2 == 0) {
			System.out.println("The given number is Even");
		}
		else {
			System.out.println("The given number is Odd");
		}
	}
}
