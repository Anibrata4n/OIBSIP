import java.util.Random;
import java.util.Scanner;

/** Controls the game loop, difficulty, guesses, and round summaries. */
public class NumberGuessingGame {
    private final Scanner scanner;
    private final Random random = new Random();
    private int roundNumber = 0;

    public NumberGuessingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("======================================");
        System.out.println("       OIBSIP NUMBER GUESSING GAME");
        System.out.println("======================================");

        boolean playAgain = true;
        while (playAgain) {
            roundNumber++;
            playRound();
            playAgain = askToPlayAgain();
        }
        System.out.println("\\nThanks for playing! You completed " + (roundNumber) + " round(s).");
    }

    private void playRound() {
        Difficulty difficulty = chooseDifficulty();
        int target = random.nextInt(difficulty.maxNumber) + 1;
        int attemptsUsed = 0;
        boolean guessedCorrectly = false;

        System.out.println("\\nRound " + roundNumber + " — guess a number from 1 to "
                + difficulty.maxNumber + ".");
        System.out.println("You have " + difficulty.maxAttempts + " attempts.");

        while (attemptsUsed < difficulty.maxAttempts && !guessedCorrectly) {
            int guess = readGuess(difficulty.maxNumber);
            attemptsUsed++;

            if (guess == target) {
                guessedCorrectly = true;
                System.out.println("Correct! You guessed the number in " + attemptsUsed + " attempt(s).");
            } else if (guess < target) {
                System.out.println("Too Low! Try a higher number.");
            } else {
                System.out.println("Too High! Try a lower number.");
            }

            int remaining = difficulty.maxAttempts - attemptsUsed;
            if (!guessedCorrectly && remaining > 0) {
                System.out.println("Attempts remaining: " + remaining);
            }
        }

        if (!guessedCorrectly) {
            System.out.println("You Lost! The number was " + target + ".");
        }
        System.out.println("Round " + roundNumber + " summary: "
                + (guessedCorrectly ? "guessed in " + attemptsUsed + " attempt(s)" : "not guessed")
                + " | Difficulty: " + difficulty.label);
    }

    private Difficulty chooseDifficulty() {
        while (true) {
            System.out.println("\\nChoose difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");
            System.out.print("Enter 1, 2, or 3: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": return new Difficulty("Easy", 50, 10);
                case "2": return new Difficulty("Medium", 100, 7);
                case "3": return new Difficulty("Hard", 200, 5);
                default: System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private int readGuess(int maxNumber) {
        while (true) {
            System.out.print("Your guess (1-" + maxNumber + "): ");
            String input = scanner.nextLine().trim();
            try {
                int guess = Integer.parseInt(input);
                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Please enter a whole number between 1 and " + maxNumber + ".");
                } else {
                    return guess;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }

    private boolean askToPlayAgain() {
        while (true) {
            System.out.print("\\nWould you like to play again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) return true;
            if (answer.equals("n") || answer.equals("no")) return false;
            System.out.println("Please enter y or n.");
        }
    }

    private static class Difficulty {
        private final String label;
        private final int maxNumber;
        private final int maxAttempts;

        private Difficulty(String label, int maxNumber, int maxAttempts) {
            this.label = label;
            this.maxNumber = maxNumber;
            this.maxAttempts = maxAttempts;
        }
    }
}
