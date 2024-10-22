package level20;

public class level20 {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);

        if (max < 0 || max > 25) {
            System.out.println("ERROR: Input value out of range.");
            return;
        }

        for (int i = 0; i <= max; ++i) {
            for (int j = 0; j <= i; ++j) System.out.print(j + " ");
            System.out.println("");
        }

        for (int i = max; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) System.out.print(j + " ");
            System.out.println("");
        }
    }
}
