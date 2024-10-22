package level22;

public class level22 {
    public static void main(String[] args) {
        System.out.println(nChooseK(52, 5));
    }

    static long factorial(int a) {
        if (a < 0) return -1;
        else if (a > 20) return -2;
        else {
            long result = 1;
            for (int i = 2; i <= a; ++i) result *= i;
            return result;
        }
    }

    static long partialFactorial(int a, int b) {
        long result = 1;
        for (int i = a; i >= a - b + 1; --i) result *= i;
        return result;
    }

    static long nChooseK(int n, int k) {
        return partialFactorial(n, k) / factorial(k);
    }
}
