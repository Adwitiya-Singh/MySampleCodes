package Lecture4;

import java.util.Scanner;

public class AmstNumber2 {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
			int strt, end, digit, ione, itwo, check,ctr=0;
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the number from where you want to check for armstrong numbers ");
			strt = scn.nextInt();
			System.out.println("Enter the number until which you want to check for armstrong numbers");
			end = scn.nextInt();
			for (int i = strt; i <= end; i++) {
				ione = i;
				itwo = i;
				check = 0;
				while (ione > 0) {

					digit = ione % 10;
					check = check + (digit * digit * digit);
					ione /= 10;
				}
				if (check == itwo){
					if(ctr==0)System.out.println("Armstrong numbers between "+strt+" and "+end+" are :");
					System.out.println(itwo);
					ctr++;
				}
					

			}
			if(ctr==0)System.out.println("There are no armstrong numbers between "+strt+" and "+end);
			System.out.println("Do you wanna continue?(y/n)");
			cont = scn.next().charAt(0);
			if (cont == 'n')
				scn.close();
		}

	}

}
