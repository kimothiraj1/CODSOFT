import java.util.Random;
import java.util.Scanner;

class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int highScore = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 7;  // Limit attempts
            boolean guessedCorrectly = false;
            int roundScore = 0;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("👉 Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    guessedCorrectly = true;

                    // Score based on attempts left (more attempts left = higher score)
                    roundScore = (attemptsLeft + 1) * 10;
                    totalScore += roundScore;

                    if (roundScore > highScore) {
                        highScore = roundScore;
                    }
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("📉 Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("📈 Too low! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You ran out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("\n⭐ Round Score: " + roundScore);
            System.out.println("🏆 High Score (best round): " + highScore);
            System.out.println("💯 Total Score (all rounds): " + totalScore);

            // Ask if the player wants another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("Final High Score: " + highScore);
        System.out.println("Final Total Score: " + totalScore);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
