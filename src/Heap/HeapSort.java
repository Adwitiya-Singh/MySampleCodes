package Heap;

import Lecture11.RecursionStuff;
import Lecture6.ArrayStuff;

public class HeapSort {

	public static void heapsort(Integer[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);
		}
		for (int i = 0; i < arr.length; i++) {
			swap(arr, 0, arr.length - i - 1);
			downHeapify(arr, 0, arr.length - i - 1);
		}
	}

	private static void downHeapify(Integer[] arr, int pi, int lp) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < lp && arr[lci] > arr[mi]) {
			mi = lci;
		}

		if (rci < lp && arr[rci] > arr[mi]) {
			mi = rci;
		}

		if (mi != pi) {
			swap(arr, mi, pi);
			downHeapify(arr, mi, lp);
		}
	}

	public static void swap(Integer[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
