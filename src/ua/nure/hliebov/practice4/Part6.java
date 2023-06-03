package ua.nure.hliebov.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final String FILE_PATH = "part6.txt";

    private static final String LATIN_REGEX = "\\b[A-Za-z]+\\b";
    private static final String CYRILLIC_REGEX = "[А-Яа-яЁёҐґІіЇїЄє]+";

    public static void main(String[] args) {
        String inputData = Util.readFile(FILE_PATH);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("stop")) {
            if (input.equalsIgnoreCase("latn")) {
                printMatches(inputData, LATIN_REGEX, "Latn");
            } else if (input.equalsIgnoreCase("cyrl")) {
                printMatches(inputData, CYRILLIC_REGEX, "Cyrl");
            } else {
                System.out.println("Incorrect input");
            }
        }
    }
    private static void printMatches(String content, String regex, String label) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        StringBuilder matches = new StringBuilder();
        while (matcher.find()) {
            matches.append(matcher.group()).append(" ");
        }
        System.out.printf("%s: %s%n", label, matches.toString().trim());
    }
}
