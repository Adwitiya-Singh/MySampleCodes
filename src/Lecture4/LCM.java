package Lecture4;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
		Scanner scn = new Scanner(System.in);
		int a, b, lcm, min, test;
		System.out.println("Enter two numbers whose LCM you want");
		a = scn.nextInt();
		b = scn.nextInt();
		lcm=a*b;
		if (a > b)
			min = b;
		else
			min = a;
		for (int i = 1; i <= min; i++) {
			test = b * i;
			if (test % a == 0) {
				lcm = test;
				break;
			}
		}
		System.out.println("LCM of "+a+" and "+b+" is "+lcm);
		System.out.println("Do you wanna continue?(y/n)");
		cont = scn.next().charAt(0);
		if (cont == 'n')
			scn.close();
	}
	}

}
