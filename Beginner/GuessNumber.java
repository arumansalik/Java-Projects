import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int low = 1;
        int high = 100;
        int generatedNum = random.nextInt((high - low + 1) + low);
        int attempts = 0;
        boolean guessCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + low + " and " + high + ".");

        while(!guessCorrectly) {
            System.out.println("Please Enter a User Guess..");
            int userGuess;

            if(sc.hasNextInt()) {
                userGuess = sc.nextInt();
                attempts++;

                if(userGuess < low || userGuess > high) {
                    System.out.println("Please guess a number between " + low + " and " + high + ".");
                    continue;
                }

                if (userGuess == generatedNum) {
                    guessCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (userGuess < generatedNum) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }  else {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            }
        }
        sc.close();
    }
}
