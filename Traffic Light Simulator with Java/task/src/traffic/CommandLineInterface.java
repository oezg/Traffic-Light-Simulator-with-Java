package traffic;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class CommandLineInterface implements UserInterface{
    static Scanner scan = new Scanner(System.in);

    @Override
    public TrafficLight trafficLight() {
        System.out.println("Welcome to the traffic management system!");
        System.out.print("Input the number of roads: ");
        int roads = feedback(n -> n > 0);
        System.out.print("Input the interval: ");
        int interval = feedback(n -> n > 0);
        clearConsole();
        return new TrafficLight(roads, interval);
    }

    @Override
    public void showState(TrafficLight light,  CircularQueue queue) {
        String roads = String.join("\n", queue.getRoads());
        String system = String.format(Constants.SYSTEM, light.getSeconds(), light.getRoadCount(), light.getInterval(), roads);
        System.out.println(system);
        scan.nextLine();
    }

    @Override
    public MenuOption choose() {
        printMenu();
        return MenuOption.values()[feedback(n -> n >= 0 && n <= 3)];
    }

    @Override
    public void close() {
        scan.close();
        System.out.println("Bye!");
    }

    @Override
    public void deleteRoad(Optional<String> road) {
        if(road.isPresent()) {
            System.out.printf("%s deleted!\n", road.get());
        } else {
            System.out.println("Queue is empty");
        }
    }

    @Override
    public void addRoad(Optional<String> road) {
        if(road.isPresent()) {
            System.out.printf("%s added!\n", road.get());
        } else {
            System.out.println("Queue is full");
        }
    }

    @Override
    public String roadName() {
        System.out.print("Input the road name: ");
        return scan.nextLine();
    }

    private static int feedback(IntPredicate predicate) {
        try {
            int number = Integer.parseInt(scan.nextLine());
            if (predicate.test(number)) {
                return number;
            }
        } catch (NumberFormatException ignored) {

        }
        System.out.print("Error! Incorrect Input. Try again: ");
        return feedback(predicate);
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
