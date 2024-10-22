package level11;

import java.util.Random;

class Level11 {
    public static void main(String[] args) {
        String name = args[0];
        String userChoice = args[1];

        final String ROCK = "Rock";
        final String PAPER = "Paper";
        final String SCISSORS = "Scissors";

        Random randomGen = new Random();

        int rValue = randomGen.nextInt(9);
        String computerChoice;

        if (rValue <= 2) computerChoice = "Rock";
        else if (rValue <= 5) computerChoice = "Paper";
        else if (rValue >= 6 && rValue <= 8) computerChoice = "Scissors";
        else {
            System.out.println("ERROR: CPU made an invalid choice!");
            return;
        }

        System.out.println(name + " selected: " + userChoice);
        System.out.println("CPU selected: " + computerChoice);


        if (userChoice.equals(computerChoice)) System.out.println("Tie!");
        else if (userChoice.equals(ROCK)) {
            if (computerChoice.equals(PAPER)) System.out.println("CPU wins!");
            else if (computerChoice.equals(SCISSORS)) System.out.println(name + " wins!");
        } else if (userChoice.equals(SCISSORS)) {
            if (computerChoice.equals(ROCK)) System.out.println("CPU wins!");
            else if (computerChoice.equals(PAPER)) System.out.println(name + " wins!");
        } else if (userChoice.equals(PAPER)) {
            if (computerChoice.equals(SCISSORS)) System.out.println("CPU wins!");
            else if (computerChoice.equals(ROCK)) System.out.println(name + " wins!");
        }
    }
}