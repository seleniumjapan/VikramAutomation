package javaP;

public class SumOfNaturalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	/*	int num =10,count=1,total = 0;
		
		while(count <= num) {
			
		
		total = total + count;
		count++;		
	}
		
	System.out.println("Sum of first 10 natural numbers is: "+total); */
		
		int num = 10,count,total = 0;
		for(count = 1;count<=num;count++) {
			total = total + count;
		}
		System.out.println("Sum of first 10 total numbers is :" + total);
	}

} 