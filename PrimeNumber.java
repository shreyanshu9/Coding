package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		findAllPrime(number);
	}

	private static void findAllPrime(int number) {
		// TODO Auto-generated method stub
		int al[] = new int [number+1];
		int check= 0, valid = 0, multiple = 1, removeNumber = 0;
		for (int i = 0; i <= number; i++) {
			al[i] = i;
		}
		al[1] = 0;
		for (int i = 0; i <= number; i++) {
			while (i <= number && al[i] == 0) {
				i++;
			}
			if (i > number) {
				break;
			}
			check = al[i];
			for (int j = 2; j < i/2; j++) {
				if (check % j == 0 && check != j) {
					valid = 1;
					break;
				}
			}
			if (valid == 1) {
				multiple = 1;
				while (removeNumber <= number) {
					removeNumber = check * multiple;
					if (removeNumber <= number) {
						al[removeNumber] = 0;
					}
					multiple++;
				}
				valid = 0;
			} else {
				System.out.print(check + " ");
			}
		}
	}

}