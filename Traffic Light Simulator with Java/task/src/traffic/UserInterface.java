package traffic;

public interface UserInterface {
    TrafficLight trafficLight();
    void showState(TrafficLight light);
    int choice();
}
