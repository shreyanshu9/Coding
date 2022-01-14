package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnionIntersectionOfSortedList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int union = getUnionCount(n, m);
        int intersection = getIntersectionCount(n, m);
        System.out.println("Union Count: " + union);
        System.out.println("Intersection Count: " + intersection);
    }

    public static int getUnionCount(int[] n, int[] m) {
        int unionCount = 0;
        int i = 0, j = 0;
        while (i < n.length && j < m.length) {
            unionCount++;
            if (n[i] == m[j]) {
                i++;
                j++;
            } else if (n[i] > m[j]) {
                j++;
            } else if (n[i] < m[j]) {
                i++;
            }
        }
        unionCount += (n.length - i) + (m.length - j);
        return unionCount;
    }

    public static int getIntersectionCount(int[] n, int[] m) {
        int intersectionCount = 0;
        int i = 0, j = 0;
        while (i < n.length && j < m.length) {
            if (n[i] == m[j]) {
                intersectionCount++;
                i++;
                j++;
            } else if (n[i] > m[j]) {
                j++;
            } else if (n[i] < m[j]) {
                i++;
            }
        }
        return intersectionCount;
    }
}
