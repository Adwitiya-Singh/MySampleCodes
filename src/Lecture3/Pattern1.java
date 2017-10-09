package Lecture3;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		int a, ctr = 1;
		Scanner scn = new Scanner(System.in);
		System.out.println("Pease enter a number");
		a = scn.nextInt();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(ctr + " ");
				ctr++;
			}
			System.out.print("\n");
			scn.close();
		}

	}

}
