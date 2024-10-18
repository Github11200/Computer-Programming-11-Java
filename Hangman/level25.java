package Hangman;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JFrame;

public class level25 implements Runnable {
    static int numberOfRoundsPlayed = 0;
    static int numberOfRoundsWon = 0;
    static int numberOfRoundsLost = 0;
    static int numberOfRightGuesses = 0;
    static int numberOfWrongGuesses = 0;
    static int numberOfGuesses = 0;

    static void displayHangMan(int numWrong)
    {
        System.out.println();

        switch (numWrong)
        {
            case 0:
                break;
            case 1:
                System.out.print("    _______\n");
                break;
            case 2:
                System.out.print("    _______\n");
                for (int i = 0; i < 6; i++)
                    System.out.println("|        ||");
                break;
            case 3:
                System.out.println("    _______");
                for (int i = 0; i < 6; i++)
                    System.out.println("|        ||");
                System.out.println("|________||");
                break;
            case 4:
                System.out.println("    _______");
                System.out.println("|   |    ||");
                System.out.println("|  \\O/   ||");

                for (int i = 0; i < 4; i++)
                    System.out.println("|        ||");
                System.out.println("|________||");
                break;
            case 5:
                System.out.print("    _______\n");
                System.out.println("|   |    ||");
                System.out.println("|  \\O/   ||");
                System.out.println("|   |    ||");

                for (int i = 0; i < 3; i++)
                    System.out.println("|        ||");
                System.out.println("|________||");
                break;
            case 6:
                System.out.print("    _______\n");
                System.out.println("|   |    ||");
                System.out.println("|  \\O/   ||");
                System.out.println("|   |    ||");
                System.out.println("|  / \\   ||");

                for (int i = 0; i < 2; i++)
                    System.out.println("|        ||");
                System.out.println("|________||");
                break;
            default:
                System.out.println("ERROR: EXCEEDED WRONG NUMBER OF GUESSES!");
        }

        System.out.println("\n");
    }

    // Works :)
    static boolean checkChar(char c, String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == c) return true;
        }
        return false;
    }

    // Works :)
    static String getRandomWord(String[] array) {
        Random randomGenerator = new Random();
        return array[randomGenerator.nextInt(array.length)];
    }

    // Works :)
    static String getRandomWord(String[] array, int len) {
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(array.length);
        for (int i = 0; i < 500; ++i) {
            if (array[randomIndex].length() >= len) return array[randomIndex];
        }
        return "";
    }

    // Works :)
    static String getRevealedChars(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        String newString = "";
        for (int i = 0; i < s1.length(); ++i) {
            if (!checkChar(s1Chars[i], s2) || s2 == "") newString += "_" + " ";
            else newString += s1Chars[i] + " ";
        };
        return newString;
    }

    static void clearScreen() {
        for (int i = 0; i < 40; ++i) { System.out.println(); }
    }

    static void waitForEnterKey(Scanner fromKey) {
        System.out.println("Please press the enter key to return to the main menu.");
        while (true) {
            String input = fromKey.nextLine();

            if (input.isEmpty()) {
                System.out.println("Enter key was pressed!");
                break;
            }
        }
    }

    static void viewStats(Scanner fromKey) {
        clearScreen();
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Number of Rounds Played: " + numberOfRoundsPlayed);
        System.out.println("Number of Rounds Won: " + numberOfRoundsWon);
        System.out.println("Number of Rounds Lost: " + numberOfRoundsLost);
        System.out.println("Winning Percentage: " + df.format((numberOfRoundsPlayed > 0 ? ((float)numberOfRoundsWon / numberOfRoundsPlayed) * 100 : 0.00)) + "%");
        System.out.println("Losing Percentage: " + df.format((numberOfRoundsPlayed > 0 ? ((float)numberOfRoundsLost / numberOfRoundsPlayed) * 100 : 0.00)) + "%");
        System.out.println("Number of correct guesses: " + numberOfRightGuesses);
        System.out.println("Number of incorrect guesses: " + numberOfWrongGuesses);
        System.out.println("Number of guesses: " + numberOfGuesses);
        System.out.println("Guessing accuracy: " + (numberOfGuesses > 0 ? df.format((((float)numberOfRightGuesses / numberOfGuesses) * 100)) : 0.00) + "%");

        System.out.print("\n\nPlease press the enter key to return to the main menu.");
        fromKey.nextLine();
        fromKey.nextLine();
    }

    static void playRound(Scanner fromKey) {
        clearScreen();
        String[] words = {"remote", "javascript", "python", "html"};
        String randomWord = getRandomWord(words);
        String currentString = getRevealedChars(randomWord, "");
        String correctGuesses = "";
        int numberOfCharactersWrong = 0;

        while (numberOfCharactersWrong != 6) {
            System.out.println("GUESS A CHARACTER:");
            char guess = fromKey.next().charAt(0);
            ++numberOfGuesses;
            if (checkChar(guess, randomWord)) {
                correctGuesses += guess;
                currentString = getRevealedChars(randomWord, correctGuesses);
                System.out.println("\nYOUR GUESS WAS CORRECT!\n");
                ++numberOfRightGuesses;
                System.out.println("CHARACTERS REVEALED: " + currentString + (!currentString.equals(randomWord) ? "\n\n\n" : ""));
                if (currentString.replaceAll("\\s+", "").equals(randomWord)) {
                    System.out.println("\nCONGRATULATIONS! YOU WIN!");
                    ++numberOfRoundsWon;
                    break;
                }
            } else {
                ++numberOfCharactersWrong;
                ++numberOfWrongGuesses;
                System.out.println("\nYOUR GUESS WAS INCORRECT.\n");
                System.out.println("CHARACTERS REVEALED: " + currentString);
                displayHangMan(numberOfCharactersWrong);
                if (numberOfCharactersWrong == 6) {
                    System.out.println("GAME OVER!\n");
                    System.out.println("SORRY YOU LOSE!");
                    ++numberOfRoundsLost;
                }
            }
        }

        ++numberOfRoundsPlayed;

        System.out.print("\n\nPlease press the enter key to return to the main menu.");
        fromKey.nextLine();
        fromKey.nextLine();
    }

    public static void main(String[] args) {
        Scanner fromKey = new Scanner(System.in);
        Thread thread = new Thread(new level25());
        thread.start();

        int userChoice = -1;

        while (true) {
            System.out.println("========================================================");
            System.out.println("		   WELCOME TO HANGMAN!");
            System.out.println("========================================================\n");

            System.out.println("In order to play this game, simply enter a letter as your guess,\n"
                    + "and it will either be correct or wrong. The program will then show\n"
                    + "the characters you have found so far, and after 6 tries you will have\n"
                    + "lost the game. Select one of the options below to start:\n");

            System.out.println("1 -> Play a round");
            System.out.println("2 -> View stats");
            System.out.println("3 -> Exit\n");

            System.out.println("Enter the number of the action you'd like to take:");

            while (true) {
                try {
                    userChoice = fromKey.nextInt();
                    if (userChoice != 1 && userChoice != 2 && userChoice != 3) {
                        System.out.println("Please enter one of the options, 1, 2, or 3.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Not a valid input, please try again. If you would like to exit then please press 3.");
                    if (fromKey.next().isEmpty()) {
                        break;
                    }
                }
            }
            if (userChoice == 1) {
                playRound(fromKey);
                clearScreen();
            } else if (userChoice == 2) {
                viewStats(fromKey);
                clearScreen();
            } else {
                System.out.println("\nThanks for playing!");
                break;
            }
        }

        fromKey.close();
    }

    @Override
    public void run() {
        JFrame f = new JFrame();

        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 27) {
                    System.out.println("\nThanks for playing!");
                    System.exit(0);
                }
            }
        });

        f.setVisible(true);
    }
}