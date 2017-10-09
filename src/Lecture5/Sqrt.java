package Lecture5;

import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
		int inp;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		inp = scn.nextInt();
		for (int i = 0; i < inp; i++) {
			int nxt = i + 1;
			if (i * i <= inp && nxt * nxt > inp) {
				System.out.println("Square Root of " + inp + " is " + i);
				break;
			}
		}
		System.out.println("Do you wanna continue?(y/n)");
		cont = scn.next().charAt(0);
		if (cont == 'n')
			scn.close();
	}
		
	}

}
