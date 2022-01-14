package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZeroSumTriplet {
    static class Triplet {
        int i, j, k;
        Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public int hashCode() {
            return 31 * (i + j + k);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            boolean iCheck = i == triplet.i || i == triplet.j || i == triplet.k;
            boolean jCheck = j == triplet.i || j == triplet.j || j == triplet.k;
            boolean kCheck = k == triplet.i || k == triplet.j || k == triplet.k;
            return (iCheck && jCheck && kCheck);
        }
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Triplet> resultList = findZeroSumTriplet(input);
        for (Triplet result : resultList) {
            String resultantString = String.format("%d %d %d", result.i, result.j, result.k);
            System.out.println(resultantString);
        }
    }

    public static HashSet<Triplet> findZeroSumTriplet(int[] input) {
        Arrays.sort(input);
        HashSet<Triplet> result = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1, k = input.length-1; j < k;) {
                int pairSum = input[j] + input[k];
                if (pairSum == -input[i]) {
                    Triplet triplet = new Triplet(input[i], input[j], input[k]);
                    result.add(triplet);
                    k--;
                    j++;
                } else if (input[i] + pairSum > 0) {
                    k--;
                } else if (input[i] + pairSum < 0) {
                    j++;
                }
            }
        }
        return result;
    }
}
