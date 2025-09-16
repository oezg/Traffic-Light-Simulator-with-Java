package traffic;

public class TrafficLightSimulator extends Thread {
    UserInterface ui;
    TrafficLight light;
    public TrafficLightSimulator() {
        ui = new CommandLineInterface();
        light = ui.trafficLight();
    }
    @Override
    public void run() {
        int choice = -1;
        while (choice != 0) {
            choice = ui.choice();
            switch (choice) {
                case 0:
                    System.out.println("Bye!"); break;
                    case 1:
                        System.out.println("Added"); break;
                        case 2:
                            System.out.println("Removed"); break;
                            case 3:
                                ui.showState(light); break;
            }

        }
    }


}
