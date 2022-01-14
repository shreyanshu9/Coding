package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DuplicateInARange {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int missingNumber = findDuplicate(input);
        System.out.println("Missing Number: " + missingNumber);
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int totalSum = n*(n+1)/2;
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
        }
        int missingNumber = Math.abs(totalSum - currentSum);
        return missingNumber;
    }
}
