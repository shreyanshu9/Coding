import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int totalInterval = intervals.length;
        Comparator<int[]> sortByFirst = Comparator.comparingInt(i -> i[0]);
        Arrays.sort(intervals, sortByFirst);
        LinkedList<int[]> list = new LinkedList<>();
        Collections.addAll(list, intervals);
        for (int i=1; i < list.size(); i++) {
            int[] first = list.get(i-1);
            int[] second = list.get(i);
            if (first[1] >= second[0]) {
                int[] result = new int[2];
                result[0] = first[0];
                result[1] = Math.max(first[1], second[1]);
                list.add(i, result);
                list.remove(i+1);
                list.remove(i-1);
                totalInterval--;
                i--;
            }

        }
        return list.toArray(new int[totalInterval][2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalInterval = Integer.parseInt(reader.readLine());
        int i = 0;
        int[][] intervals = new int[totalInterval][2];
        while (i < totalInterval) {
            String[] input = reader.readLine().split(" ");
            intervals[i][0] = Integer.parseInt(input[0]);
            intervals[i][1] = Integer.parseInt(input[1]);
            i++;
        }
        int[][] resultInterval = merge(intervals);
        i = 0;
        while (i < resultInterval.length) {
            System.out.println(resultInterval[i][0] + ", " + resultInterval[i][1]);
            i++;
        }
    }
}
