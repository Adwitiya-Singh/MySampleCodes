package TimeComplexity;

public class ArraySubsetsSumDifferenceSOMETHING {
	public static void main(String[] args) {
		int[] arr = { -5, -3, 1, 2, 6 };
		System.out.println(ArrraySomething(arr, 0, 0, 0));
	}

	public static int ArrraySomething(int[] arr, int si, int sum1, int sum2) {
		if (si == arr.length) {
			return Math.abs(sum1 - sum2);
		}
		int Finaldiff;
		if (Math.abs((sum1 + arr[si]) - sum2) <= Math.abs(sum1 - (sum2 + arr[si]))) {
			Finaldiff = ArrraySomething(arr, si + 1, sum1 + arr[si], sum2);
		} else {
			Finaldiff = ArrraySomething(arr, si + 1, sum1, sum2 + arr[si]);

		}
		return Finaldiff;

	}
}
