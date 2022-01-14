package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KadaneAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = findLargestSumInContiguousArray(array);
        System.out.println("Largest Sum: " + sum);
    }

    public static int findLargestSumInContiguousArray(int[] array) {
        int largestSum = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > sum + array[i]) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > largestSum) {
                largestSum = sum;
            }
        }
        return largestSum;
    }
}
