package Lecture11;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 15, 2, 6, 1, 18 };
		arr = mergeSort(arr, 0, arr.length - 1);
		Lecture6.ArrayStuff.display(arr);
	}

	public static int[] merge(int[] one, int[] two) {
		int i = 0, j = 0, k = 0;
		int[] merged = new int[one.length + two.length];
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
		
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}
		}
		while (i < one.length) {
			merged[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			merged[k] = two[j];
			j++;
			k++;
		}
		return merged;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] base = new int[1];
			base[0] = arr[lo];
			return base;
		}
		int mid = (lo + hi) / 2;
		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);
		int[] Final = merge(fhalf, shalf);
		return Final;
	}

}
