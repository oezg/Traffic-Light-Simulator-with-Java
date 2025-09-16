package traffic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficLightSimulator tls = new TrafficLightSimulator();
        tls.start();
        tls.join();
    }
}
