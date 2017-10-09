package Lecture8;

public class FindSum {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 9, 7, 5, -1 };
		int target = 8;
		FindTwoSum(arr, target);
		FindThreeSum(arr, 9);
	}

	public static void FindThreeSum(int[] arr, int target) {
		int counter = 0;
		int size = arr.length;
		while (counter < size - 1){
			
			
			for (int i = counter; i < size - 1; i++) {
				for(int j=i;j<size-1;j++){
					if (arr[counter] + arr[i + 1]+arr[j+1] == target) {
						System.out.println(arr[counter] + ", " + arr[i + 1]+" and "+arr[j+1]);
					
				}
			}
			}
		counter++;
		}
		System.out.println("FIN");
		
	}

	public static void FindTwoSum(int[] arr, int target) {
		int counter = 0;
		int size = arr.length;
		while (counter < size - 1) {

			for (int i = counter; i < size - 1; i++) {
				if (arr[counter] + arr[i + 1] == target) {
					System.out.println(arr[counter] + " and " + arr[i + 1]);

				}
			}
			counter++;
		}
		System.out.println("FIN");
	}
}