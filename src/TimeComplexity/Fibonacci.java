package TimeComplexity;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        System.out.println(Fibonacci(100));
        System.out.println(SumOfDigits(2134));
    }

    public static double Fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Negative numbers not Allowed");
        }
        if (n == 0) {
            return 1;

        }
        double[] storage = new double[2];
        return Fibonacci(n, storage);
    }

    private static double Fibonacci(int n, double[] storage) {
        if (n == 1) {
            storage[0] = 1;
            storage[1] = 0;
            return 1;
        }
        double fibnm1 = Fibonacci(n - 1, storage);
        double fibnm2 = storage[1];
        double fibn = fibnm1 + fibnm2;
        storage[1] = storage[0];
        storage[0] = fibn;
        return fibn;
    }
    public static int SumOfDigits(int n) {
        if (n <= 0)
            return 0;
        return SumOfDigits(n / 10) + n % 10;

    }
}
