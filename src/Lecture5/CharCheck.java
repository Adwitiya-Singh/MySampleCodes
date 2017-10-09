package Lecture5;

import java.util.Scanner;

public class CharCheck {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		char inp, opt;
		System.out.println("Enter a character");
		inp = scn.next().charAt(0);
		opt = InpType(inp);
		System.out.println(opt);

	}

	public static char InpType(char inp) {
		int ASC = inp;

		if (ASC <= 90 && ASC >= 65)
			return 'U';
		else if (ASC >= 97 && ASC <= 122)
			return 'L';
		else
			return 'I';

	}

}
