package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSumRectangle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, len, bre, sum;
		String sizeInput, input;
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			sizeInput = br.readLine();
			st = new StringTokenizer(sizeInput, " ");
			len = Integer.parseInt(st.nextToken());
			bre = Integer.parseInt(st.nextToken());
			int a[][] = new int[len][bre];
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < bre; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sum = findMaximum(a, len, bre);
			System.out.println(sum);
		}

	}

	private static int findMaximum(int[][] a, int len, int bre) {
		int limit, curr = 1, sum = 0;
		int topx, topy, downx, downy, vert, hor;
		limit = len < bre ? len : bre;
		topx = topy = downx = downy = 0;
		for (curr = 1; curr <= limit+1; curr++) {
			topx = topy = 0;
			downx = topx + curr - 1;
			downy = topy + curr - 1;
			vert = topx;
			hor = downx;
			while (downy < bre) {
				while (downx < len) {
					sum = getSum(a, topx, topy, downx, downy, sum);
					topx++;
					downx++;
				}
				topx = vert;
				downx = hor;
				topy++;
				downy++;
			}
		}
		return sum;
	}

	private static int getSum(int[][] a, int topx, int topy, int downx,
			int downy, int max) {
		int sum = 0;
		for (int i = topx; i <= downx; i++) {
			for (int j = topy; j <= downy; j++) {
				sum += a[i][j];
			}
		}
		//if absolute value of sum is considered
//		if (sum < 0) {
//			sum *= -1;
//		}
		if (max < sum) {
			return sum;
		} else {
			return max;
		}
	}

}
