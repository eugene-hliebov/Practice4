package ua.nure.hliebov.practice4;

import java.io.IOException;
import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        String inputData = Util.readFile("part3.txt").trim();
        System.out.println(inputData);
        System.out.println("--------------------------------------");
        if (inputData.isEmpty()) {
            System.out.println("No data in the file.");
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter data type (char, String, int, double): ");
                String inputConsole = scanner.nextLine();

                if (inputConsole.equalsIgnoreCase("stop")) {
                    break;
                }

                if (!inputConsole.equalsIgnoreCase("char") &&
                        !inputConsole.equalsIgnoreCase("String") &&
                        !inputConsole.equalsIgnoreCase("int") &&
                        !inputConsole.equalsIgnoreCase("double")) {
                    System.out.println("Incorrect input");
                    continue;
                }

                printValuesByType(inputData, inputConsole);
            }
        }
    }
    private static void printValuesByType(String data, String type) {
        String[] lines = data.split("\n");

        String regex;
        if (type.equalsIgnoreCase("char")) {
            regex = "[А-яA-Za-zі]{1}";
        } else if (type.equalsIgnoreCase("String")) {
            regex = "[А-яA-Za-zі]{2,}";
        } else if (type.equalsIgnoreCase("int")) {
            regex = "\\b\\d+\\b";
        } else {
            regex = "\\d+[.,]\\d+";
        }

        for (String line : lines) {
            String[] words = line.split("\\s");
            for (String word : words) {
                if (word.matches(regex)) {
                    System.out.print(word + " ");
                }
            }
        }

        System.out.println();
    }
}
