import java.util.Scanner;

/**
 * OIBSIP Java Development — Task 2: Number Guessing Game
 * Console game with difficulty selection, limited attempts, replay, and score summaries.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            NumberGuessingGame game = new NumberGuessingGame(scanner);
            game.run();
        }
    }
}
