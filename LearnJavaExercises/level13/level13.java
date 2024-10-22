package level13;

class Level13 {
    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        int i = 0;
        int n = 0;

        System.out.println("LOOP 1");
        while (i <= 31) {
            System.out.print(i + " ");
            ++i;
        }

        System.out.println("\n\nLOOP 2");
        i = 1;
        n = 1;
        while (i <= 20) {
            System.out.print(n + " ");
            ++i;
            n += 2;
        }

        System.out.println("\n\nLOOP 3");
        n = 14;
        while (n < 200) {
            System.out.print(n + " ");
            n += 7;
        }

        System.out.println("\n\nLOOP 4");
        n = val;
        while (n > 6) {
            System.out.print(n + " ");
            n -= 4;
        }
    }
}
