package ua.nure.hliebov.practice4;

public class Part1 {
    public static void main(String[] args) {
        System.out.println("Input Text part1.txt");
        System.out.println("--------------------------------------");
        String inputText = Util.readFile("part1.txt").trim();
        System.out.println(inputText);
        System.out.println("======================================");
        System.out.println("Output Result - invertCase");
        System.out.println("--------------------------------------");
        String outputResult = invertCase(inputText);
        System.out.println(outputResult);
        System.out.println("======================================");
        System.out.println();
    }

    public static String invertCase(String inputText) {
        StringBuilder result = new StringBuilder();

        String[] words = inputText.split("\\b");
        for (String word : words) {
            if (word.length() > 3) {
                StringBuilder invertedWord = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (Character.isUpperCase(c)) {
                        invertedWord.append(Character.toLowerCase(c));
                    } else if (Character.isLowerCase(c)) {
                        invertedWord.append(Character.toUpperCase(c));
                    } else {
                        invertedWord.append(c);
                    }
                }
                result.append(invertedWord);
            } else {
                result.append(word);
            }
        }

        return result.toString();
    }
}
