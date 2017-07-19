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
	
	private static int getPiDigit(int n) {
		// TODO Auto-generated method stub
		double pi = Math.PI;
		System.out.println(pi);
		int digit = 3;
		for (int i = 1; i < n; i++) {
			pi = (pi - digit) * 10;
			digit = (int)pi;
		}
		return digit;
	}

}
