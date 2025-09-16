package traffic;


public class TrafficLight {
    int roadCount;
    int interval;
    volatile int seconds;
    Thread timerThread;
    volatile boolean stopped = false;
    public TrafficLight(int roads, int interval) {
        this.roadCount = roads;
        this.interval = interval;
        this.seconds = 0;
        timerThread = new Thread(() -> {
            try {
                while(!stopped) {
                    Thread.sleep(1000L);
                    seconds++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "QueueThread");

        timerThread.start();
    }

    public int getRoadCount() {
        return roadCount;
    }

    public int getInterval() {
        return interval;
    }

    public int getSeconds() {
        return seconds;
    }

    public void stop() {
        stopped = true;
    }
}
