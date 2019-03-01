package KadaneAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadaneLogic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNo = Integer.parseInt(reader.readLine());
		int N, max, sum;
		int[] arr;
		String[] arrayElement;
		while (testCaseNo-- > 0) {
			N = Integer.parseInt(reader.readLine());
			arr = new int[N];
			max = Integer.MIN_VALUE;
			sum = 0;
			arrayElement = reader.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(arrayElement[i]);
				sum += arr[i];
				if (arr[i] > sum) {
					sum = arr[i];
				}
				if (sum > max) {
					max = sum;
				}
				if (sum < 0) {
					sum = arr[i];
				}
			}
			System.out.println(max);
		}
	}
}
