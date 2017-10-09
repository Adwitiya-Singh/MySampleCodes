package Lecture5;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
			int First, Second;
			char Operation;
			Scanner scn = new Scanner(System.in);
			
			System.out.print("Enter First Number ");
			First = scn.nextInt();
			System.out.print("Enter Second Number ");
			Second = scn.nextInt();
			System.out.print("Enter Operation ");
			Operation = scn.next().charAt(0);
			switch (Operation) {
			case '+':
				System.out.println(First + Second);
				break;
			case '-':
				System.out.println(First - Second);
				break;
			case '*':
				System.out.println(First * Second);
				break;
			case '/':
				System.out.println(First / Second);
				break;
			case '%':
				System.out.println(First % Second);
				break;

			}
			System.out.println("Do you wanna continue?(y/x)");
			cont = scn.next().charAt(0);
			if (cont == 'x' || cont == 'X')
				scn.close();
		}

	}

}
