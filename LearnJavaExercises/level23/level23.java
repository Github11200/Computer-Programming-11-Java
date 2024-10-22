package level23;

public class level23 {
    static int max(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    static int min(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    static int range(int arr[]) {
        return max(arr) - min(arr);
    }

    static double average(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) sum += arr[i];
        return sum / arr.length;
    }

    static int count(int arr[], int target) {
        int occurences = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) ++occurences;
        }
        return occurences;
    }

    static void replace(char arr[], char target, char val) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) arr[i] = val;
        }
    }

    public static void main(String[] args) {

    }
}
