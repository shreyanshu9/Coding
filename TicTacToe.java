//http://practice.geeksforgeeks.org/problems/tic-tac-toe/0
package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TicTacToe {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int x = 0; x < T; x++) {
			String ar[] = new String[9];
			int noX = 0;
			int noO = 0;
			String result = null;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				ar[i] = st.nextToken();
				if (ar[i].equalsIgnoreCase("X")) {
					noX++;
				} else {
					noO++;
				}
			}
			if ((noO == 4 && noX == 5 )) {
				boolean checkO = checkWin(ar, "O");
				boolean checkX = checkWin(ar, "X");
				if (checkO && checkX) {
					result = "Invalid";
				} else if ((checkO && noX == 5 )|| (checkX && noO == 5)) {
					result = "Invalid";
				} else {
					result = "Valid";
				}
			} else {
				result = "Invalid";
			}
			System.out.println(result);
		}
	}

	private static boolean checkWin(String[] ar, String symbol) {
		// TODO Auto-generated method stub
		String completeDivision = symbol + symbol + symbol;
		String pattern;
		for (int i = 0; i < 9; i = i+3) {
			pattern = ar[i] + ar[i+1] + ar[i+2];
			if (pattern.equals(completeDivision)) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			pattern = ar[i] + ar[i+3] + ar[i+6];
			if(pattern.equals(completeDivision)) {
				return true;
			}
		}
		pattern = ar[0] + ar[4] + ar[8];
		if (pattern.equals(completeDivision)) {
			return true;
		}
		pattern = ar[2] + ar[4] + ar[6];
		if (pattern.equals(completeDivision)) {
			return true;
		}
		return false;
	}
}