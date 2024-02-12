import java.util.Random;
import java.util.Scanner;
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int roundScore = playRound(scanner, random);
            totalScore += roundScore;
            System.out.println("Your score for this round: " + roundScore);
            System.out.println("Total score: " + totalScore);
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over. Thank you for playing!");
        scanner.close();
    }

    public static int playRound(Scanner scanner, Random random) {
        int rno = random.nextInt(101);
        System.out.println("Guess a Number : 1-100");
        int c = 1;
        while (c <= 3) {
            int n = scanner.nextInt();
            if (rno == n) {
                System.out.println("Guessed Right!");
                return 3 - c + 1; // Return score based on number of attempts left
            } else if (rno > n) {
                System.out.println("Guessed Low");
            } else {
                System.out.println("Guessed High");
            }
            c++;
        }
        System.out.println("Round over");
        return 0; // Return 0 score if the user couldn't guess the number
    }
}
