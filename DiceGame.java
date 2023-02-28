
import java.util.Random;
import java.util.Scanner;

/**
* A guessing game for numbers in between 1 and 6.
*
* @author  Keiden B
* @version 1.0
* @since   2023-02-24
*/

public final class DiceGame {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    */
    public static void main(String[] args) {
        // Initiating the scanner and random number generator.
        final Scanner get = new Scanner(System.in);
        final Random randGen = new Random();
        // The highest number you want to be generated
        final int highNum = 6;
        // Generating random number
        // Add one to the result because the generator
        // starts at 0 to the number below the input
        // ex. Input 6, generates from 0 - 5
        final int randInt = randGen.nextInt(highNum) + 1;

        // Initializing counter for loop and userInt for input
        int counter = 0;
        int userInt = 0;

        // Only outputs once at the beginning of the program
        System.out.println("Welcome to the MOST intense guessing"
            + " game you'll ever play.");
        do {
            // Output that will repeat after every loop
            System.out.println("Pick a number, any number.");
            final String userGet = get.nextLine();

            // Trying to convert user input to an integer
            try {
                userInt = Integer.parseInt(userGet);

                // Checks if the input is outside the valid range
                if (userInt < 1 || userInt > highNum) {
                    System.out.printf("Invalid Input. Must be a"
                            + " number from 1 to %d.\n", highNum);

                // Checks if the input is lower than the random number
                } else if (userInt < randInt) {
                    System.out.println("You guessed too low!");
                    counter += 1;

                // Checks if the input is higher than the random number
                } else if (userInt > randInt) {
                    System.out.println("You guessed too high!");
                    counter += 1;

                // Activates when the user input is equal to the random number
                } else {
                    counter += 1;
                }

            // Catches if the user didn't input a number
            } catch (NumberFormatException error) {
                System.out.println("Invalid Input. Must be a number"
                    + " from 1 to 6. " + error.getMessage());
            }
        // Repeats until the user has guessed the right number
        } while (userInt != randInt);

        // Tells the user they have guessed the right number
        // Includes the amount of tries they took
        System.out.printf("%d is the right number!"
            + " It took you %d valid tries.\n", userInt, counter);

        // Closes the scanner
        get.close();
    }
}
