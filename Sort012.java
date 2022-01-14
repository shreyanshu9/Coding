package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sort012(input, size);
        Arrays.stream(input).forEach(System.out::println);
    }

    public static void sort012(int[] a, int n) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i : a) {
            switch (i) {
                case 0: zero++; break;
                case 1: one++; break;
                case 2: two++; break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (zero > 0) {
                a[i] = 0;
                zero--;
            }
            else if (one > 0) {
                a[i] = 1;
                one--;
            } else if (two > 0) {
                a[i] = 2;
                two--;
            }
        }
    }
}
