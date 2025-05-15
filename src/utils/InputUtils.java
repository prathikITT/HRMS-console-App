package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int getIntInput(String message) {
        int input = -1;
        while (true) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    public static void closeScanner() {
        scanner.close();
    }
}