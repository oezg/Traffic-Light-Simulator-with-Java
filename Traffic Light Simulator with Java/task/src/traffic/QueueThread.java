package traffic;

public class QueueThread implements Runnable {
    InitialSetting initial;
    int seconds;

    public QueueThread(InitialSetting initial) {
        this.initial = initial;
        seconds = 0;
    }

    @Override
    public void run() {
        while (true) {
            printInformation();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
        }
    }

    private void printInformation() {
        System.out.printf("! %ds. have passed since system startup !\n",  seconds);
        System.out.printf("! Number of roads: %d !\n", initial.numberRoads());
        System.out.printf("! Interval: %d !\n", initial.interval());
        System.out.println("! Press \"Enter\" to open menu !");
    }
}
