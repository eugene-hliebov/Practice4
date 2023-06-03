package ua.nure.hliebov.practice4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String>{

    private String filePath;

    public Part4(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Iterator<String> iterator() {
        return new SentenceIterator();
    }

    private class SentenceIterator implements Iterator<String> {
        private BufferedReader reader;
        private String currentSentence;

        public SentenceIterator() {
            try {
                reader = new BufferedReader(new FileReader(filePath));
                currentSentence = findNextSentence();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            return currentSentence != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            String sentence = currentSentence;
            currentSentence = findNextSentence();
            return sentence;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private String findNextSentence() {
            try {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(" ");
                    if (line.matches(".*[.!?]")) {
                        break;
                    }
                }

                String text = content.toString();
                Pattern pattern = Pattern.compile("[^.!?]+[.!?]");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    return matcher.group();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            closeReader();
            return null;
        }

        private void closeReader() {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Part4 iterable = new Part4("part4.txt");
        for (String sentence : iterable) {
            System.out.println(sentence);
        }
    }

}
