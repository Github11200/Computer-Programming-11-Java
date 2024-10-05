package level24;

public class level24 {
    static void printStarLine(int numStars) {
        if (numStars <= 0) {
            System.out.println("");
            return;
        }
        System.out.print("* ");
        printStarLine(numStars - 1);
    }

    static void printStarsDescending(int numStars) {
        if (numStars <= 0) return;
        printStarLine(numStars);
        printStarsDescending(numStars - 1);
    }

    static void printStarsAscending(int numStars) {
        if (numStars <= 0) return;
        printStarsAscending(numStars - 1);
        printStarLine(numStars);
    }

    static public void main(String[] args) {

    }
}
