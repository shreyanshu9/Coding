package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FrequencyOrdering2 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		orderByFrequency(a);
	}

	private static void orderByFrequency(int[] a) {
		Arrays.sort(a);
		int unique = findUnique(a);
		int b[][] = create2D(a, unique);
		b = sort2d(b);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i][1]; j++) {
				System.out.print(b[i][0] + " ");
			}
		}
	}

	private static int[][] sort2d(int[][] b) {
		// TODO Auto-generated method stub
		int temp;
		for (int i = 0; i < b.length; i++) {
			for (int j = i+1; j < b.length; j++) {
				if (b[i][1] < b[j][1]) {
					temp = b[i][1];
					b[i][1] = b[j][1];
					b[j][1] = temp;
					temp = b[i][0];
					b[i][0] = b[j][0];
					b[j][0] = temp;
				}
			}
		}
		return b;
	}

	private static int findUnique(int[] a) {
		// TODO Auto-generated method stub
		int check = 1;
		for (int i = 0; i < a.length; i++) {
			if (i < a.length - 1) {
				if (a[i] != a[i+1]) {
					check++;
				}
			}
		}
		return check;
	}

	private static int[][] create2D(int[] a, int unique) {
		// TODO Auto-generated method stub
		int check= 1, x = 0, length = a.length;
		int b[][] = new int[unique][2];
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				if (a[i] == a[i+1]) {
					check++;
				} else {
					b[x][0] = a[i];
					b[x][1] = check;
					check = 1;
					x++;
				}
			} else {
				if (a[i] != a[i-1]) {
					b[x][0] = a[i];
					b[x][1] = 1;
				}
			}
		}
		return b;
	}

}
