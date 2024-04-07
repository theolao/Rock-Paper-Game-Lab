import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    enum Choice {
        ROCK, PAPER, SCISSORS;

        // determine winner
        public int compare(Choice other) {
            if (this == other) {
                return 0; // if tie
            }
            return switch (this) {
                case ROCK -> (other == SCISSORS) ? 1 : -1;
                case PAPER -> (other == ROCK) ? 1 : -1;
                case SCISSORS -> (other == PAPER) ? 1 : -1;
            };
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock Paper Scissors!");
        System.out.println("Enter your choice (ROCK, PAPER, or SCISSORS):");
        String input = scanner.nextLine().toUpperCase();

        Choice playerChoice;
        try {
            playerChoice = Choice.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice! Please enter ROCK, PAPER, or SCISSORS.");
            return;
        }

        Choice computerChoice = Choice.values()[random.nextInt(3)];

        System.out.println("Computer chose: " + computerChoice);

        int result = playerChoice.compare(computerChoice);
        if (result == 0) {
            System.out.println("It's a tie!");
        } else if (result > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}