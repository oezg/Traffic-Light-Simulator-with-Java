package traffic;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficLight {
    int roadCount;
    int interval;
    int seconds;
    Timer timer = new Timer();
    public TrafficLight(int roads, int interval) {
        this.roadCount = roads;
        this.interval = interval;
        this.seconds = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        }, 1000L);
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
}
