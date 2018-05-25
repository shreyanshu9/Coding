package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPalindrome {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		String input, output;
		StringBuilder reverse;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			input = br.readLine();
			input = input.replaceAll("[^a-zA-Z0-9]", "");
			input = input.toLowerCase();
			reverse = new StringBuilder(input);
			reverse.reverse();
			output = reverse.toString();
			if (input.compareTo(output) == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
