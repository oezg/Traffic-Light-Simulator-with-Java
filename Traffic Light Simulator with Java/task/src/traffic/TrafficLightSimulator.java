package traffic;

public class TrafficLightSimulator extends Thread {
    UserInterface ui;
    TrafficLight light;
    CircularQueue queue;
    public TrafficLightSimulator() {
        ui = new CommandLineInterface();
        light = ui.trafficLight();
        queue = new CircularQueue(light.getRoadCount());
    }
    @Override
    public void run() {
        switch (ui.choose()) {
            case MenuOption.QUIT -> {
                light.stop(); ui.close(); return;
            }
            case MenuOption.ADD_ROAD ->
                ui.addRoad(queue.enqueue(ui.roadName()));
            case MenuOption.DELETE_ROAD ->
                ui.deleteRoad(queue.dequeue());
            case MenuOption.OPEN_SYSTEM ->
                ui.showState(light, queue);
        }
        run();
    }
}
