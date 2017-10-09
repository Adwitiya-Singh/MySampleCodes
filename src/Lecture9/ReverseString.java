package Lecture9;

import java.util.Scanner;

public class ReverseString {


		public static void main(String args[]) {
			char cont = 'y';

			while (cont == 'y') {
				Scanner scn = new Scanner(System.in);
				String original, reverse = "";
				System.out.println("Enter a string or number to reverse");
				original = scn.nextLine();
				int length = original.length();
				for (int i = length - 1; i >= 0; i--)
					reverse = reverse + original.charAt(i);
				System.out.println("Reverse of entered string/number is: " + reverse);
				System.out.println("Do you wanna continue?(y/n)");
				cont = scn.next().charAt(0);
				if (cont == 'n')
					scn.close();
		
			}
		}

	}


