package Lecture4;

import java.util.Scanner;

public class count5 {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {

			int ctr = 0, digit,fdigit;
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter the number in which you want a digit counted ");
			int n = scn.nextInt();
			System.out.println("Enter the digit whose occurence you want counted");
			fdigit=scn.nextInt();
			int cpy=n;
			while (n > 0) {
				digit = n % 10;
				if (digit == fdigit)
					ctr++;
				n /= 10;
			}
			System.out.println("Number of "+fdigit+"s in "+cpy+" are " + ctr);
			System.out.println("Do you wanna continue?(y/n)");
			cont = scn.next().charAt(0);
			if (cont == 'n')
				scn.close();
		}

	}

}
