package level7;

class Level7 {
    public static void main(String[] args) {
        int p = 11;
        int q = 3;
        int n = p * q;
        int m = (p - 1) * (q - 1);
        int e = 3;
        int d = 7;

        long e1 = 26, e2 = 25, e3 = 30, e4 = 3, e5 = 26, e6 = 14, e7 = 28, e8 = 30;

        System.out.println("RIDDLE ME THIS!\n");
        System.out.println("What begins with a T, ends with a T, and has T in it?\n");
        System.out.println("The encrypted answer is\n");
        System.out.println(e1 + " " + e2 + " " + e3 + " " + e4 + " " + e5 + " " + e6 + " " + e7 + " " + e8 + "\n");
        System.out.println("The decrypted answer to this riddle is:\n");

        long d1, d2, d3, d4, d5, d6, d7, d8;

        d1 = (long)Math.pow(e1, d) % n;
        d2 = (long)Math.pow(e2, d) % n;
        d3 = (long)Math.pow(e3, d) % n;
        d4 = (long)Math.pow(e4, d) % n;
        d5 = (long)Math.pow(e5, d) % n;
        d6 = (long)Math.pow(e6, d) % n;
        d7 = (long)Math.pow(e7, d) % n;
        d8 = (long)Math.pow(e8, d) % n;

        System.out.println(d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5 + " " + d6 + " " + d7 + " " + d8 + "\n");
        System.out.println("The answer to this riddle is:\n");
        System.out.println("A TEAPOT");
    }
}