package Lecture7;

import java.util.Scanner;

public class TwoDArrayStuff {

	public static void main(String[] args) {

		// int arr[][] = takeInput();
		int arr[][] = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 },
				{ 51, 52, 53, 54 }

		};
		display(arr);
		waveprint(arr);
		spiralprint(arr);
		RevWaveprint(arr);
		RevSpiralprint(arr);

	}

	public static int[][] takeInput() {
		int[][] retVal = null;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the Number of Rows ");
		int rows = scn.nextInt();
		retVal = new int[rows][];
		for (int row = 0; row < retVal.length; row++) {
			System.out.print("Enter the number of columns for " + row + "th row ");
			int cols = scn.nextInt();
			retVal[row] = new int[cols];
			for (int col = 0; col < retVal[row].length; col++) {
				System.out.print("Enter the value for cell (" + row + "," + col + ") ");
				retVal[row][col] = scn.nextInt();
			}
		}
		return retVal;
	}

	public static void display(int[][] arr) {
		if (arr == null) {
			System.out.println("No rows, no columns");
		} else {
			System.out.println("Rows = " + arr.length);
			System.out.println("Array:");
			for (int row = 0; row < arr.length; row++) {
				if (arr[row] == null) {
					System.out.println("Blank row.");
				} else {

					for (int col = 0; col < arr[row].length; col++) {
						System.out.print(arr[row][col] + "\t");
					}
				}
				System.out.println();
			}

		}

	}

	public static void waveprint(int[][] arr) {
		System.out.println("The array in wave form is : ");
		for (int col = 0; col < arr[0].length; col++) {
			for (int row = 0; row < arr.length; row++) {
				if (col % 2 == 0)
					System.out.print(arr[row][col] + ",");
				else
					System.out.print(arr[arr.length - row - 1][col] + ",");

			}

		}
		System.out.println("FIN\n");
	}

	public static void RevWaveprint(int[][] arr) {
		System.out.println("The array in  Reverse wave form is : ");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (row % 2 == 0)
					System.out.print(arr[row][col] + ",");
				else
					System.out.print(arr[row][arr[0].length - 1 - col] + ",");

			}
		}
		System.out.println("FIN\n");
	}

	public static void spiralprint(int[][] arr) {
		int times = arr.length * arr[0].length, ctr = 0;
		int mincol = 0;
		int minrow = 0;
		int maxcol = arr[0].length - 1;
		int maxrow = arr.length - 1;
		System.out.println("The array in  spiral form is : ");
		while (ctr < times) {
			for (int row = minrow; row <= maxrow; row++) {
				System.out.print(arr[row][mincol] + ",");
				ctr++;

			}
			mincol++;
			for (int col = mincol; col <= maxcol; col++) {
				System.out.print(arr[maxrow][col] + ",");
				ctr++;

			}
			maxrow--;
			for (int row = maxrow; row >= minrow; row--) {
				System.out.print(arr[row][maxcol] + ",");
				ctr++;

			}
			maxcol--;
			for (int col = maxcol; col >= mincol; col--) {
				System.out.print(arr[minrow][col] + ",");
				ctr++;

			}
			minrow++;
		}
		System.out.println("FIN\n");

	}

	public static void RevSpiralprint(int[][] arr) {
		int times = arr.length * arr[0].length, ctr = 0;
		int mincol = 0;
		int minrow = 0;
		int maxcol = arr[0].length - 1;
		int maxrow = arr.length - 1;
		System.out.println("The array in  Reverse spiral form is : ");
		while (ctr < times) {
			for (int col = mincol; col <= maxcol; col++) {
				System.out.print(arr[minrow][col] + ",");
				ctr++;

			}
			minrow++;
			for (int row = minrow; row <= maxrow; row++) {
				System.out.print(arr[row][maxcol] + ",");
				ctr++;

			}
			maxcol--;
			for (int col = maxcol; col >= mincol; col--) {
				System.out.print(arr[maxrow][col] + ",");
				ctr++;

			}
			maxrow--;
			for (int row = maxrow; row >= minrow; row--) {
				System.out.print(arr[row][mincol] + ",");
				ctr++;

			}
			mincol++;

		}
		System.out.println("FIN");

	}

}
