package traffic;

import java.util.Scanner;

public class MenuController {

    public static void run(Scanner input) {
        printMenu();
        String action = "";

        while(!action.equals("Bye!")) {
            action = toAction(input);
            System.out.println(action);
            input.nextLine();
            input.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println("""
            Menu:
            1. Add road
            2. Delete road
            3. Open system
            0. Quit""");
    }

    private static String toAction(Scanner input) {
        return switch (input.next()) {
            case "0" -> "Bye!";
            case "1" -> "Road added";
            case "2" -> "Road deleted";
            case "3" -> "System opened";
            default -> "Incorrect option";
        };
    }
}
