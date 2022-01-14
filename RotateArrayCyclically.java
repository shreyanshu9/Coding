package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateArrayCyclically {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        rotate(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void rotate(int[] array) {
        int replacement = array[0];
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            array[i] = replacement;
            replacement = temp;
        }
        array[0] = replacement;
    }
}
