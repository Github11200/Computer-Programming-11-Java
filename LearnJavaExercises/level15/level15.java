package level15;

class level15 {
    public static void main(String[] args) {
        int[] arr1 = {23, 32, 12, 45, 33, 25, 50, 16};
        System.out.println("ARRAY 1");
        System.out.println(arr1[0] + ", " + arr1[1] + ", " + arr1[2] + ", " + arr1[3] + ", " + arr1[4] + ", " + arr1[5] + ", " + arr1[6] + ", " + arr1[7]);
        System.out.println("Array length is " + arr1.length + "\n");

        String[] arr2 = new String[5];
        arr2[0] = "w th";
        arr2[1] = "No";
        arr2[2] = "kes se";
        arr2[3] = "is ma";
        arr2[4] = "nse!";
        System.out.println("ARRAY 2");
        System.out.println(arr2[1] + arr2[0] + arr2[3] + arr2[2] + arr2[4] + "\n");

        double[] arr3 = new double[7];
        arr3[0] = Double.parseDouble(args[0]);
        arr3[1] = Double.parseDouble(args[1]);
        arr3[2] = Double.parseDouble(args[2]);
        arr3[3] = Double.parseDouble(args[3]);
        arr3[4] = Double.parseDouble(args[4]);
        arr3[5] = Double.parseDouble(args[5]);
        arr3[6] = Double.parseDouble(args[6]);

        int i = 0;
        double sum = 0;
        while (i < arr3.length) {
            sum += arr3[i];
            ++i;
        }

        System.out.println("ARRAY 3");
        System.out.println("Average is " + (sum / arr3.length));
    }
}