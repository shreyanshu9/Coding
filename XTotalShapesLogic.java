package XTotalShapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XTotalShapesLogic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		int N, M, x;
		int a[][];
		String input;
		char[] arrayInput;
		while (T-- > 0) {
			input = reader.readLine();
			N = Integer.parseInt(input.split(" ")[0]);
			M = Integer.parseInt(input.split(" ")[1]);
			arrayInput = reader.readLine().replaceAll(" ", "").toCharArray();
			System.out.println(arrayInput.length + " " + N*M);
			a = new int[N][M];
			x = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					a[i][j] = arrayInput[x] == 'O' ? 0 : 1;
					x++;
				}
			}
			x = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (a[i][j] == 1) {
						if ((i-1 >= 0 && (a[i-1][j] == 1)) || j-1 >= 0 && (a[i][j-1] == 1)) {
						} else {
							x++;
						}
					}
				}
			}
			System.out.println(x);
		}
	}
}
