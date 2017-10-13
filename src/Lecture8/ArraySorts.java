package Lecture8;

import java.util.ArrayList;
import java.util.Scanner;

import Lecture6.ArrayStuff;

public class ArraySorts {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = { 1, 1, 5, 1, 3, 2, 2 };
		// // System.out.println("Enter an array to sort ");
		// // arr = Lecture6.ArrayStuff.takeinput();
		selectionSort(arr);
		Lecture6.ArrayStuff.display(arr);
		System.out.print("Enter a number to be searched in the array ");
		int search = scn.nextInt();
		int indextwo = ArrayStuff.BinarySearch(arr, search) + 1;
		if (indextwo == -1)
			System.out.println(search + "is not present in the array");
		else
			System.out.println(search + " is at " + indextwo + "th position in the array");

	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1])
					Lecture6.ArrayStuff.swap(arr, i, i + 1);

			}
			counter++;
		}
	}

	public static void selectionSort(int[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = counter; i < arr.length; i++) {
				if (arr[i] < arr[counter - 1]) {
					Lecture6.ArrayStuff.swap(arr, i, counter - 1);
				}
			}
			counter++;
		}
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = counter; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					ArrayStuff.swap(arr, i, i - 1);
				} else {
					break;
				}
			}
			counter++;

		}
	}

}
