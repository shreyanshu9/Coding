package TwoPrimeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoPrimeNumberLogic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		int num, temp;
		while (T-- > 0) {
			num = Integer.parseInt(reader.readLine());
			if (num % 2 == 0) {
				HashSet<Integer> primeNumbers = getPrime(num);
				for (int element : primeNumbers) {
					temp = num - element;
					if (primeNumbers.contains(temp)) {
						System.out.println(element + " " + temp);
						break;
					}
				}
			}
		}
	}

	private static HashSet<Integer> getPrime(int num) {
		HashSet<Integer> primeNumber = new HashSet<Integer>();
		boolean status;
		for (int i = 2; i <= num; i++) {
			primeNumber.add(i);
		}
		for (int i = 2; i <= num; i++) {
			if (primeNumber.contains(i)) {
				status = checkPrime(i);
				if (status) {
					removeMultiples(primeNumber, i, num);
				} else {
					primeNumber.remove(i);
				}
			}
		}
		return primeNumber;
	}

	private static void removeMultiples(HashSet<Integer> primeNumber, int element, int max) {
		int i = 2;
		int temp;
		while (true) {
			temp = element * i;
			if (temp > max) {
				return;
			} else {
				if (primeNumber.contains(temp)) {
					primeNumber.remove(temp);
				}
			}
			i++;
		}
	}

	private static boolean checkPrime(int element) {
		for (int i = 2; i < element/2; i++) {
			if (element % i == 0) {
				return false;
			}
		}
		return true;
	}
}
