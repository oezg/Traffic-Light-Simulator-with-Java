package traffic;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputController {

    public static void run(Scanner input) {
        System.out.println("Welcome to the traffic management system!");
        positiveInteger("number of roads", input);
        positiveInteger("interval", input);
    }

    private static void positiveInteger(String prompt, Scanner input) {
        System.out.printf("Input the %s: ", prompt);
        feedback(input);
    }

    private static void feedback(Scanner input) {
        try {
            if (input.nextInt() > 0) {
                return;
            }
        } catch (InputMismatchException _) {
        }
        System.out.print("Error! Incorrect Input. Try again: ");
        feedback(input);
    }
}
