import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMinWithLeastComparison {
    class Pair {
        int max;
        int min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Pair resultPair = findMaxMin(input);
        System.out.println("Max: " + resultPair.max);
        System.out.println("Min: " + resultPair.min);
    }

    public static Pair findMaxMin(int[] inputs) {
        Pair resultPair = new MaxMinWithLeastComparison().new Pair();
        resultPair.min = Integer.MAX_VALUE;
        resultPair.max = Integer.MIN_VALUE;
        if (inputs.length == 1) {
            resultPair.max = inputs[0];
            resultPair.min = inputs[0];
        } else {
            for (Integer input : inputs) {
                if (resultPair.max < input) {
                    resultPair.max = input;
                }
                if (resultPair.min > input) {
                    resultPair.min = input;
                }
            }
        }
        return resultPair;
    }
}
