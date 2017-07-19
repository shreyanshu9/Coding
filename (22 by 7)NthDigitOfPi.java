package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthDigitOfPi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        for (int x = 0; x < T; x++) {
        	int n = Integer.parseInt(br.readLine());
        	int digit = getPiDigit(1,n, 22);
        	System.out.println(digit);
        }
	}

	private static int getPiDigit(int i, int n, int j) {
		// TODO Auto-generated method stub
		int digit = 0;
		if(i == n) {
			digit = j/7;
		} else {
			j = ( j % 7 ) * 10;
			digit = getPiDigit(++i, n, j);
		}
		
		return digit;
	}

}
