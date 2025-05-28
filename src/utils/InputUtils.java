package utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
            }
        }
    }

    public static String retryOrExitPrompt() {
        System.out.print("Do you want to retry (Y) or exit (E)? ");
        return scanner.nextLine().trim();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}