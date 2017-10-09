package TimeComplexity;

import Lecture11.QuickSort;
import Lecture6.ArrayStuff;
import Lecture8.ArraySorts;

public class TimeComplexityChecker {
	public static long startTime = 0;
	public static long endTime = 0;

	public static void main(String[] args) {
		int N = 100000000;

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = N - i;
		}
//		int n = 100000, x = 2;
//		init();
//		power(x,n);
//		System.out.println("Power for " + n + " took " + duration() + " ms");	
//		init();
//		powerinlogn.betterpower(x,n);
//		System.out.println("BetterPower for " + n + " took " + duration() + " ms");
//		init();
//		quickSort(arr,0,arr.length-1);
//		System.out.println("Quicksort for " + N  + " elements took " + duration() + " ms");	
//		init();
//		ArraySorts.bubbleSort(arr);
//		System.out.println("Bubblesort for " + N  + " elements took " + duration() + " ms");	
		
		init();
		quickSort(arr,0,arr.length-1);
		System.out.println(ArrayStuff.BinarySearch(arr, 1));
		System.out.println(duration());
		init();
		System.out.println(ArrayStuff.LinearSearch(arr, 1));
		System.out.println(duration());
		
	}
	

	public static void init() {
		startTime = System.currentTimeMillis();
	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static int power(int n,int x){
		if(x == 0) {
			return 1;
		}
	    else return n * power(n, x-1);
				
		
	}
	
	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;

		// real work - partitioning the array (smaller than pivot and larger
		// than pivot)
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}


		
	}
	

