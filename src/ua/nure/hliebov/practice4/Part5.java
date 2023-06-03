package ua.nure.hliebov.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Part5 {
    private static final String BASE_NAME = "resources";
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while ((input = reader.readLine()) != null) {
                if (input.equals(STOP_COMMAND)) {
                    break;
                }
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("Invalid input format. Please enter the key and locale separated by a space.");
                    continue;
                }
                String key = parts[0];
                String locale = parts[1];
                printLocalizedValue(key, locale);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printLocalizedValue(String key, String localeCode) {
        Locale locale = new Locale(localeCode);
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        if (bundle.containsKey(key)) {
            String value = bundle.getString(key);
            System.out.println(value);
        } else {
            System.out.println("No such value");
        }
    }
}