package Lecture3;

import java.util.Scanner;

public class BinToDec {

	public static void main(String[] args) {

		int a, b = 0, c, ctr = 0;
		int j = 1;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a binary number");
		a = scn.nextInt();
		while (a > 0) {
			if (ctr == 0) {
				if (a % 10 == 1)
					b = 1;
			}
			c = a % 10;
			if (ctr > 0) {

				for (int i = 1; i <= ctr; i++) {
					j = j * 2;
				}
			}
			b = b + c * j;
			ctr++;
			a = a / 10;
			j = 1;
		}
		b=b-1;
      System.out.println("The Decimal number is"+ b);
      scn.close();
	}

}
