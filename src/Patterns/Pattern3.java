package Patterns;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		int Rows;
		int midRow;
		int row;
		try (Scanner sc = new Scanner(System.in)) {

			Rows = sc.nextInt();
		}

		midRow = (Rows) / 2;

		row = 1;

		for (int i = midRow; i > 0; i--) {

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= row; j++) {
				System.out.print("* ");
			}
			System.out.println();

			row++;
		}

		for (int i = 0; i <= midRow; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			for (int j = row; j > 0; j--) {
				System.out.print("* ");
			}

			System.out.println();

			row--;
		}
	}
}
