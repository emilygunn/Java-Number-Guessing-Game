import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class NumberGuessGame extends Game {
    
    private int secretNumber;
    private ArrayList<Integer> guesses;

    public NumberGuessGame()
    {
        Random rand = new Random();
        secretNumber = rand.nextInt(100) + 1;
        guesses = new ArrayList<>();
    }

    @Override 
    public void startGame()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");

        boolean correct = false;

        while (!correct) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            guesses.add(guess);

            correct = checkGuess(guess);
        }

        System.out.println("You guessed it in " + guesses.size() + " tries!");
        System.out.println("Your guesses were: " + guesses);

        scanner.close();
    }

    private boolean checkGuess(int guess)
    {

        if (guess < secretNumber)
        {
            System.out.println("Too low!");
            return false;
        }
        else if (guess > secretNumber)
        {
            System.out.println("Too high!");
            return false;
        }
        else
        {
            System.out.println("Correct!");
            return true;
        }
    }
}
