package traffic;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputController {

    public static InitialSetting run(Scanner input) {
        System.out.println("Welcome to the traffic management system!");
        int number = positiveInteger("number of roads", input);
        int interval = positiveInteger("interval", input);
        return new InitialSetting(number, interval);
    }

    private static int positiveInteger(String prompt, Scanner input) {
        System.out.printf("Input the %s: ", prompt);
        return feedback(input);
    }

    private static int feedback(Scanner input) {
        try {
            int number = input.nextInt();
            if (number > 0) {
                return number;
            }
        } catch (InputMismatchException _) {
        }
        System.out.print("Error! Incorrect Input. Try again: ");
        return feedback(input);
    }
}
