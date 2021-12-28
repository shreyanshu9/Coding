import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(reader.readLine());
        int result = kthSmallest(input, 0, input.length - 1, k);
        System.out.printf("Kth Smallest is %d", result);
    }

    public static int kthSmallest(int[] input, int l, int r, int k) {
        for (int i = r/2; i >= 0; i--) {
            heapify(input, i, r);
        }
        int small = input[0];
        while (k-- > 0) {
            small = input[0];
            input[0] = input[r];
            r--;
            heapify(input, 0, r);
        }
        return small;
    }

    public static void heapify(int[] input, int i, int length) {
        if (i < length) {
            int smallest = input[i];
            int indexSmall = i;
            int leftChild = i*2;
            int rightChild = leftChild + 1;
            if (leftChild <= length && smallest > input[leftChild]) {
                smallest = input[leftChild];
                indexSmall = leftChild;
            }
            if (rightChild <= length && smallest > input[rightChild]) {
                indexSmall = rightChild;
            }
            if (i != indexSmall) {
                swap(input, i, indexSmall);
                heapify(input, indexSmall, length);
            }

        }
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
