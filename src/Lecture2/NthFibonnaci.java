package Lecture2;

import java.util.Scanner;

public class NthFibonnaci {

	public static void main(String[] args) {
		int a = 0, b = 1, c;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter which Fibonnaci nnumber do you want");
		int N = scn.nextInt();
		for (int i = 2;i <= N; i++) {
			c = b;
			b = b + a;
			a = c;
		}
		System.out.println("Nth Fibonnaci is " + a);
		scn.close();
	}

}
