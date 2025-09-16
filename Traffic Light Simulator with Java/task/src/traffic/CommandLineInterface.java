package traffic;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface{
    static Scanner scan = new Scanner(System.in);

    @Override
    public TrafficLight trafficLight() {
        System.out.println("Welcome to the traffic management system!");
        System.out.print("Input the number of roads: ");
        int roads = feedback();
        System.out.print("Input the interval: ");
        int interval = feedback();
        clearConsole();
        return new TrafficLight(roads, interval);
    }

    @Override
    public void showState(TrafficLight light) {
        String system = String.format(Constants.SYSTEM, light.getSeconds(), light.getRoadCount(), light.getInterval(), "TODO");
        System.out.println(system);
        scan.nextLine();
    }

    @Override
    public int choice() {
        return 0;
    }

    private static int feedback() {
        try {
            int number = scan.nextInt();
            if (number > 0) {
                return number;
            }
        } catch (InputMismatchException e) {
        }
        System.out.print("Error! Incorrect Input. Try again: ");
        return feedback();
    }

    private static void printMenu() {
        System.out.println(Constants.MENU);
    }

    private static void clearConsole() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {
        }
    }
}
