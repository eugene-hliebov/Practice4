package ua.nure.hliebov.practice4;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {

    public static void main(String[] args) {
        WriteNums2Txt("part2.txt", 10, 0, 50);
        System.out.println(ReadTxtAndSortAndWrite2Txt("part2.txt", "part2_sorted.txt"));
    }

    public static int[] GenerateNums(int count, int min, int max) {
        Random random = new Random();
        int[] arrayNums = new int[count];
        for (int i = 0; i < count; i++) {
            int randomNum = random.nextInt(max - min + 1) + min;
            arrayNums[i] = randomNum;
        }
        return arrayNums;
    }

    public static void WriteNums2Txt(String filename, int count, int min, int max) {
        int[] arrayNums = GenerateNums(count, min, max);
        String strNums = "";
        for (int i = 0; i < arrayNums.length; i++) {
            if (i == 0) {
                strNums += arrayNums[i];
            } else {
                strNums += " " + arrayNums[i];
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(strNums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ReadTxtAndSortAndWrite2Txt(String filename, String filenameWrite) {
        String inputData = Util.readFile(filename).trim();
        String[] strNums = inputData.split(" ");
        int[] arrayNums = new int[strNums.length];

        StringBuffer result = new StringBuffer();
        result.append("input  ==>");
        for (int i = 0; i < strNums.length; i++) {
            arrayNums[i] = Integer.parseInt(strNums[i]);
            result.append(" ").append(arrayNums[i]);
        }
        result.append("\n");

        int[] arraySorted = quickSort(arrayNums);

        String strNumsSorted = "";
        result.append("output ==>");
        for (int i = 0; i < arraySorted.length; i++) {
            result.append(" ").append(arraySorted[i]);
            if (i == 0) {
                strNumsSorted += arrayNums[i];
            } else {
                strNumsSorted += " " + arrayNums[i];
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenameWrite))) {
            writer.write(strNumsSorted);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static int[] quickSort(int[] array) {
        int[] arraySorted = array;
        quickSort(arraySorted, 0, array.length - 1);
        return arraySorted;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);

            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
