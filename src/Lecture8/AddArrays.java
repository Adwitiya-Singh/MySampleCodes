package Lecture8;

public class AddArrays {

	public static void main(String[] args) {
		int[] arr = { 6,0,0};
		int[] arrtwo = { 4,0 };
		int a = arr.length;
		int b = arrtwo.length;
		int sum;
		int ar = 0;
		int artwo = 0;
		Lecture6.ArrayStuff.Reverse(arr);
		Lecture6.ArrayStuff.Reverse(arrtwo);
		for (int i = 0; i < a; i++) {
			ar += arr[i] * Math.pow(10, i);
		}
		for (int i = 0; i < b; i++) {
			artwo += arrtwo[i] * Math.pow(10, i);
		}
		sum = ar + artwo;
		
		sum = Lecture2.ReverseNumber.Reverse(sum);
		System.out.print("[");
		while (sum > 0) {
			System.out.print(sum % 10 + ",");
			sum /= 10;
		}
		System.out.print("FIN]");

	}
}
