package Lecture11;

import java.util.Random;

import Lecture6.ArrayStuff;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 8,6, 4, 12, 3 };
		quickSort(arr, 0, arr.length - 1);
		ArrayStuff.display(arr);

	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		int left = lo, right = hi;
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				ArrayStuff.swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}

}
