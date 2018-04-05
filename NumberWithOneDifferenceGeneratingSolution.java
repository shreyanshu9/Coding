package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NumberWithOneDifference {

	static BigInteger previousNumber;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int digit, numberLength;
		BigInteger n;
		String numberString;
		while (T-- > 0) {
			numberString = br.readLine();
			n = new BigInteger(numberString);
			numberLength = numberString.length();
			digit = 2;
			if (numberLength == 1) {
				System.out.println("-1");
			} else {
				while (digit <= numberLength) {
					createNumber(digit, n);
					digit++;
				}
				System.out.println();
			}
		}
	}

	private static void createNumber(int digit, BigInteger limit) {
		int initial = 1;
		int number[] = new int[digit];
		while (initial <= 9) {
			number[0] = initial;
			createDownNumber(1, digit, limit, number);
			createUpNumber(1, digit, limit, number);
			initial++;
		}
	}

	private static void createUpNumber(int start, int end, BigInteger limit, int number[]) {
		int temp;
		if (start < end) {
			temp = number[start - 1] + 1;
			if (temp >= 0 && temp <= 9) {
				number[start] = temp;
				createDownNumber(start+1, end, limit, number);
				createUpNumber(start+1, end, limit, number);
				if (start == end - 1) {
					printThis(number, limit);
				}
			}
		}
		
	} 
		

	private static void printThis(int[] number, BigInteger limit) {
		// TODO Auto-generated method stub
		BigInteger newNumber = BigInteger.ZERO;
		int x,compare;
		for (int i = 0; i < number.length; i++) {
			x = number[i];
			newNumber = newNumber.multiply(BigInteger.TEN);
			newNumber = newNumber.add(new BigInteger(Integer.toString(x)));
		}
		compare = newNumber.compareTo(limit);
		if (compare != 1) {
			System.out.print(newNumber + " ");
		}
	}

	private static void createDownNumber(int start, int end, BigInteger limit, int number[]) {
		int temp = 0;
		if (start < end) {
			temp = number[start - 1] - 1;
			if (temp >= 0 && temp <= 9) {
				number[start] = temp;
				createDownNumber(start+1, end, limit, number);
				createUpNumber(start+1, end, limit, number);
				if (start == end - 1) {
					printThis(number, limit);
				}
			}
		}
		
	}
}
