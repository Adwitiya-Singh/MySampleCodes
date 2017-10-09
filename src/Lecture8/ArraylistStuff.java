package Lecture8;

import java.util.ArrayList;

public class ArraylistStuff {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 5, 1, 3, 2, 2 };
//		  System.out.println("Enter an array ");
//		  arr = Lecture6.ArrayStuff.takeinput();
		int[] arrtwo = { 1, 1, 2, 4, 2, 2 };
//		  System.out.println("Enter another array to get it's intersection with the first array ");
//		  arrtwo = Lecture6.ArrayStuff.takeinput();
		ArrayList<Integer> arrlst = Intersection(arr, arrtwo);
		System.out.println(arrlst);

	}
	public static ArrayList<Integer> Intersection(int[] one, int[] two) {
		ArraySorts.insertionSort(one);
		ArraySorts.insertionSort(two);
		ArrayList<Integer> arrlst = new ArrayList();

		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] == two[j]) {
				arrlst.add(one[i]);
				i++;
				j++;

			}

			if (one[i] < two[j]) {

				i++;
			}
			if (one[i] > two[j]) {
				j++;
			}
		}
		return arrlst;

	}
}
