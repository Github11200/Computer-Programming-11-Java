package level13;

public class level13 {
    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        int i = 0;
        int n = 0;

        while (i <= 31) {
            System.out.println(i);
            ++i;
        }

        i = 1;
        n = 1;
        while (i <= 20) {
            System.out.println(n);
            ++i;
            n += 2;
        }

        n = 14;
        while (n < 200) {
            System.out.println(n);
            n += 7;
        }

        n = val;
        while (n > 6) {
            System.out.println(n);
            n -= 4;
        }
    }
}
