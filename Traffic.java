import java.util.Scanner;

public class Traffic {

  static Scanner scanner = new Scanner(System.in);

  public static String getInput(String textToDisplay) {
    System.out.println(textToDisplay);
    System.out.print("> ");
    return scanner.nextLine();
  }

  public static int getIntegerInput(String textToDisplay) {
    while (true) {
      String input = getInput(textToDisplay).trim();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException ex) {
        System.out.println("Invalid input. Input must be an integer!");
        System.out.println();
      }
    }
  }

  public static int getFine() {
    int aViolations = getIntegerInput(
      "How many type A violations do you have?"
    );
    int bViolations = getIntegerInput(
      "How many type B violations do you have?"
    );
    int cViolations = getIntegerInput(
      "How many type C violations do you have?"
    );
    int fine = 10 * aViolations + 25 * bViolations + 50 * cViolations;
    if (aViolations > 5) {
      fine += 50;
    }
    if (bViolations > 5) {
      fine += 50;
    }
    if (cViolations > 3) {
      fine += (20 * (cViolations - 3));
    }
    if (aViolations + bViolations + cViolations > 10) {
      fine += 100;
    }
    return fine;
  }

  public static void main(String[] args) {
    while (true) {
      String input = getInput(
        "Would you like to continue processing violations? (y/n)"
      );
      if (input.equalsIgnoreCase("y")) {
        int fine = getFine();
        System.out.println(String.format("Your fine is %d", fine));
        System.out.println();
      } else if (input.equalsIgnoreCase("n")) {
        return;
      } else {
        System.out.println("Invalid input. Please output y or n");
        System.out.println();
      }
    }
  }
}
