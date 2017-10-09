package Lecture4;

import java.util.Scanner;

public class InverseNumber {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
			int inp, digit, ctr = 1, inpcp, inv = 0, pow;
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter a non repeating number ");
			inp = scn.nextInt();
			inpcp = inp;
			while (inp > 0) {
				digit = inp % 10;
				pow = digit - 1;
				int posn=1;
				for(int i=0;i<pow;i++)
				{
					
					posn*=10;
				}
				inv += ctr * posn;
				inp /= 10;
				ctr++;
			}
			System.out.println("Inverse of " + inpcp + " is " + inv);
			if (inv == inpcp)
				System.out.println("And it is a mirror inverse");
			else
				System.out.println("But it isn't a mirror inverse");
			System.out.println("Do you wanna continue?(y/n)");
			cont = scn.next().charAt(0);
			if (cont == 'n')
				scn.close();
		}

	}

}
