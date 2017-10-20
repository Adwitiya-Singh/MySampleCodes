package TimeComplexity;

public class getPV {

	public static void main(String[] args) {

		System.out.println(getPV(2, 4));
	}

	public static int getPV(int x, int n) {
		int Final = 0;
		int powX = x;
		while (n > 0) {
			Final += powX * n;
			powX = powX * x;
			n--;
		}

		return Final;
	}

}
