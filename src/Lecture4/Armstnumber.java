package Lecture4;

import java.util.Scanner;

public class Armstnumber {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
			Scanner scn = new Scanner(System.in);
			int inp, cinp, digit, check = 0;
			System.out.println("Enter a number ");
			inp = scn.nextInt();
			cinp = inp;
			while (inp > 0) {
				digit = inp % 10;
				check = check + (digit * digit * digit);
				inp /= 10;
			}
			if (check == cinp)
				System.out.println(cinp + " is an Armstrong Number");
			else
				System.out.println(cinp + " is not an Armstrong Number");
			System.out.println("Do you wanna continue?(y/n)");
			cont = scn.next().charAt(0);
			if (cont == 'n')
				scn.close();

		}
	}

}
