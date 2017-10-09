package TimeComplexity;

public class powerinlogn {

	public static void main(String[] args) {
		System.out.println(betterpower(9, 3));
	}

	public static int betterpower(int N, int x) {
		if (x == 0) {
			return 1;
		}
		int lesser = betterpower(N, x / 2);
		if (x % 2 == 0) {
			return lesser * lesser;
		} else
			return lesser * lesser * N;
	}
	

}
