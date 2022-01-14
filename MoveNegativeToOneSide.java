package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoveNegativeToOneSide {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sortByConnotation(input);
        Arrays.stream(input).forEach(System.out::println);
    }

    private static void sortByConnotation(int[] a) {
        int start = 0;
        int end = a.length-1;
        while (start < end) {
            while (a[start] < 0) start++;
            while (a[end] > 0) end--;
            if (start < end) {
                swap(a, start, end);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
