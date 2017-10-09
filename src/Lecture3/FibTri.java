package Lecture3;

import java.util.Scanner;

public class FibTri {

	public static void main(String[] args) {
		int a = 0, b = 1, c, d;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number");
		d = scn.nextInt();
		for (int i = 0; i < d; i++) {
			
			for(int j=0;j<=i;j++)
			{
				
				System.out.print(a+"\t");
				c = b;
				b = b + a;
				a = c;
			}
			System.out.print("\n");
			scn.close();
		}
		
	}

	
}
