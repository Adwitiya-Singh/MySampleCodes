package TimeComplexity;

public class BestPrime {

	public static void main(String[] args)
	{
		printPrimesSOE(50);
	}

	public static void printPrimesSOE(int N) {
		boolean[] primes = new boolean[N + 1];
		for (int i = 2; i < N + 1; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div <= N; div++) {
			if (primes[div]) {
				for (int multiple = 2; multiple * div <= N; multiple++) {
					primes[div * multiple] = false;
				}

			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}

	}

}
