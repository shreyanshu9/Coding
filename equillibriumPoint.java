package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class equillibriumPoint {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, size, equillibrium;
		String input;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			equillibrium = -1
			size = Integer.parseInt(br.readLine());
			input = br.readLine();
			int a[][] = new int[size][3];
			if (size == 1) {
				equillibrium = 1; 
			} else {
				StringTokenizer st = new StringTokenizer(input, " ");
				for (int i = 0; i < size; i++) {
					a[i][0] = Integer.parseInt(st.nextToken());
					if (i == 0) {
						a[i][1] = 0;
					} else {
						a[i][1] = a[i-1][1] + a[i-1][0];
					}
				}
				for (int i = size - 1; i >= 0; i--) {
					if (i == size - 1) {
						a[i][2] = 0;
					} else {
						a[i][2] = a[i+1][2] + a[i+1][0];
					}
				}
				for (int i = 0; i < size; i++) {
					if (a[i][1] == a[i][2]) {
						equillibrium = i + 1;
					}
				}
			}
			System.out.println(equillibrium);
		}
	}
}
