package level19;

public class level19 {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);

        if (value > 20) {
            System.out.println("VALUE TOO LARGE TO COMPUTE");
            return;
        }
        else if (value < 0) {
            System.out.println("ERROR: CANNOT COMPUTE FACTORIAL OF A NEGATIVE NUMBER");
            return;
        }
        else {
            long result = 1;
            for (int i = 2; i <= value; ++i) result *= i;

            System.out.println(value + "! = " + result);
        }
    }
}
