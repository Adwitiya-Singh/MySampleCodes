package Lecture4;

import java.util.Scanner;

public class FtoC {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
			Scanner scn = new Scanner(System.in);
			int minf, maxf, step, b,fvalue;
			double a = 5.0 / 9.0, cvalue;

			System.out.print("Enter Minimum farheneit value ");
			minf = scn.nextInt();
			System.out.print("Enter Maximum farheneit value ");
			maxf = scn.nextInt();
			System.out.print("Enter step value ");
			step = scn.nextInt();
			System.out.println("\tConversion Table");
			System.out.println("Farheneit\t\tCelcius");
			for (; minf <= maxf; minf += step) {
				b = minf - 32;
				cvalue = a * b;
				 fvalue=(int)cvalue;
				System.out.println(minf + "\t\t\t" + fvalue);
			}
			System.out.print("Do you wanna continue?(y/n) ");
			cont = scn.next().charAt(0);
			if (cont == 'n')
				scn.close();
		}

	}

}
