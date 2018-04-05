package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NumberWithDifferenceOne {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String number = br.readLine();
			BigInteger n = new BigInteger(number);
			BigInteger i = BigInteger.TEN;
			for (; !i.equals(n); i = i.add(BigInteger.ONE)) {
				if (check(i)) {
					System.out.print(i + " ");
				}
			}
			if (check(n)) {
				System.out.println(n);
			}
		}
	}

	private static boolean check(BigInteger i) {
		// TODO Auto-generated method stub
		BigInteger[] x = i.divideAndRemainder(BigInteger.TEN);
		BigInteger[] y;
		int z = 1;
		int a,b, sub;
		i = i.divide(BigInteger.TEN);
		a = x[1].intValue();
		while(!i.equals(BigInteger.ZERO) && z == 1) {
			y = i.divideAndRemainder(BigInteger.TEN);
			i = i.divide(BigInteger.TEN);
			b = y[1].intValue();
			sub = Math.abs(a - b);
			if (sub == 1) {
				a = b;
			} else {
				z = 0;
			}
		}
		if (z == 1) {
			return true;
		}
		return false;
	}

}
