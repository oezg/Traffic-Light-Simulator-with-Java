package traffic;

import java.util.Scanner;

public class ProgramController {
    public static final Scanner input = new Scanner(System.in);
    public static void run(Program program) {
        InitialSetting initial = InputController.run(input);
        program.state = ProgramState.Menu;
        Thread worker = new Thread(new QueueThread(initial), "QueueThread");
        MenuController.run(input);
    }
}
