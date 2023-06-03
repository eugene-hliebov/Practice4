package ua.nure.hliebov.practice4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Util {
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }
}
