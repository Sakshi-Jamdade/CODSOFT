import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1, max = 100, maxAttempts = 5, score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) 
		{
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) 
			{
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) 
				{
                    guessedCorrectly = true;
                    score++;
                    System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
                } 
				else if (userGuess < numberToGuess) 
				{
                    System.out.println("Too low! Try again.");
                } 
				else 
				{
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) 
			{
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Final score: " + score);
        scanner.close();
    }
}
