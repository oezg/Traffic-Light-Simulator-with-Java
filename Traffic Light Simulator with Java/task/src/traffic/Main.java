package traffic;

import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    InputController.run(input);
    MenuController.run(input);
  }
}
