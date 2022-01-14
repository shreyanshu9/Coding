package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class MinimizeTheHeight {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minDiff = getMinDiff(array, n, k);
        System.out.println("Minimum Height Difference: " + minDiff);
    }

    public static int getMinDiff(int[] a, int n, int k) {
        Arrays.sort(a);
        a[0] += k;
        int max = a[0];
        int min = a[0];
        int diff;
        for (int i = 1; i < a.length; i++) {
            int low = a[i] - k;
            int high = a[i] + k;
            if (low < 0) {
                a[i] = high;
                max = Math.max(high, max);
            } else {
                int maxDiff = Math.max(max, high) - min;
                int minDiff = max - Math.min(min, low);
                if (maxDiff < minDiff) {
                    a[i] = high;
                    max = Math.max(high, max);
                } else {
                    a[i] = low;
                    min = Math.min(min, low);
                }
            }
        }
        diff = max - min;
        return diff;
    }
}
//        5
//        10
//        2 6 3 4 7 2 10 3 2 1

//        5
//        10
//        5 5 8 6 4 10 3 8 9 10