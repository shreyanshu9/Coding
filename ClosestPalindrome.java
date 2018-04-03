package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosestPalindrome {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int number = Integer.parseInt(br.readLine());
			int length = checkLength(number);
			int newNumber = number;
			int digit = 0;
			if (number == 0 || length == 1) {
				if (length == 1) {
					newNumber = (number - 1);
				}
				if (number == 0) {
					newNumber = -1;
				}
			} else if (checkPalindrome(number, length)) {
				digit = getNumberForPalindrome(number, length);
				newNumber = checkForPalindrome(number, length, digit);
			} else {
				newNumber = getNumber(number, length);
				newNumber = check(number, newNumber, length);
			}
			System.out.println(newNumber);
		}

	}

	private static int check(int number, int newNumber, int length) {
		// TODO Auto-generated method stub
		int upNumber1, downNumber1, first, last;
		int upDiff, downDiff, firstDiff, lastDiff, newDiff;
		int sendThis, sendDiff;
		int mod;
		sendThis = newNumber;
		sendDiff = 0;
		
		mod = (int) Math.pow(10, length/2);
		if (length % 2 == 0) {
			mod += (int) Math.pow(10, (length/2 -1));
		}
		
		upNumber1 = newNumber + mod;
		downNumber1 = newNumber - mod;
		first = getFirst(length + 1);
		last = getLast(length - 1);
		
		if (!checkPalindrome(upNumber1, length)) {
			upNumber1 = number;
		}
		if (!checkPalindrome(downNumber1, length)) {
			downNumber1 = number;
		}
		
		upDiff = Math.abs(number - upNumber1);
		downDiff = Math.abs(number - downNumber1);
		firstDiff = Math.abs(number - first);
		lastDiff = Math.abs(number - last);
		newDiff = Math.abs(number - newNumber);
		
		if (upDiff == 0) {
			upDiff = Integer.MAX_VALUE;
		} 
		if (downDiff == 0) {
			downDiff = Integer.MAX_VALUE;
		} 
		if (firstDiff == 0) {
			firstDiff = Integer.MAX_VALUE;
		}
		if (lastDiff == 0) {
			lastDiff = Integer.MAX_VALUE;
		}
		if (newDiff == 0) {
			newDiff = Integer.MAX_VALUE;
		}
		
		if (upDiff < downDiff && upDiff < firstDiff) {
			sendThis = upNumber1;
			sendDiff = upDiff;
		} else if (downDiff < firstDiff) {
			sendThis = downNumber1;
			sendDiff = downDiff;
		} else { 
			sendThis = first;
			sendDiff = firstDiff;
		}
		if (lastDiff < sendDiff && lastDiff < newDiff) {
			sendThis = last;
			sendDiff = lastDiff;
		} else if (newDiff < sendDiff) {
			sendThis = newNumber;
			sendDiff = newDiff;
		}
		
		newNumber = sendThis;
		return newNumber;
	}

	private static int checkForPalindrome(int number, int length, int digit) {
		// TODO Auto-generated method stub
		int upNumber1, downNumber1, first, last, newNumber;
		int upDiff, downDiff, firstDiff, lastDiff;
		int sendThis, sendDiff;
		sendThis = newNumber = number;
		sendDiff = 0;
		upNumber1 = number + digit;
		downNumber1 = number - digit;
		first = getFirst(length + 1);
		last = getLast(length - 1);
		
		if (!checkPalindrome(upNumber1, length)) {
			upNumber1 = number;
		}
		if (!checkPalindrome(downNumber1, length)) {
			downNumber1 = number;
		}
		
		upDiff = Math.abs(number - upNumber1);
		downDiff = Math.abs(number - downNumber1);
		firstDiff = Math.abs(number - first);
		lastDiff = Math.abs(number - last);
		
		if (upDiff == 0) {
			upDiff = Integer.MAX_VALUE;
		} 
		if (downDiff == 0) {
			downDiff = Integer.MAX_VALUE;
		} 
		if (firstDiff == 0) {
			firstDiff = Integer.MAX_VALUE;
		}
		if (lastDiff == 0) {
			lastDiff = Integer.MAX_VALUE;
		}
		
		if (upDiff < downDiff && upDiff < firstDiff) {
			sendThis = upNumber1;
			sendDiff = upDiff;
		} else if (downDiff < firstDiff) {
			sendThis = downNumber1;
			sendDiff = downDiff;
		} else { 
			sendThis = first;
			sendDiff = firstDiff;
		}
		if (sendDiff > lastDiff) {
			sendThis = last;
			sendDiff = lastDiff;
		}
		
		newNumber = sendThis;
		return newNumber;
	}

	private static int getNumberForPalindrome(int number, int length) {
		// TODO Auto-generated method stub
		int length1, digit;
		if ( length % 2 == 1) {
			length1 = (length / 2);
			digit = (int) Math.pow(10, length1);
		} else {
			length1 = length / 2 ;
			digit = (int) Math.pow(10, length1);
			digit += (int) Math.pow(10, (length1-1));
		}
		return digit;
	}

	private static int getNumber(int number, int length)  {
		// TODO Auto-generated method stub
		int temp, newNumber, number1, i; 
		int bigMod,  mod, first, last, length1;
		number1 = number;
		bigMod = (int) Math.pow(10, length-1);
		length1 = length / 2;
		newNumber = 0;
		mod = 1;
		while (length1-- > 0) {
			temp = number1 / bigMod;
			first = temp * bigMod;
			last = temp * mod;
			newNumber += first + last;
			number1 -= first;
			bigMod /= 10;
			mod *= 10;
		}
		if(length % 2 == 1) {
			number1 = number;
			length1 = (length / 2);
			bigMod = (int) Math.pow(10, length-1);
			i = 0;
			while (length1-- > 0) {
				first = (number1 / bigMod) * bigMod;
				last = number1 % 10;
				number1 = number1 - last - first;
				number1 /= 10;
				bigMod /= 100;
				i++;
			}
			number1 = (int) (number1 * (Math.pow(10, i)));
			newNumber += number1;
		}
		return newNumber;
	}

	private static boolean checkPalindrome(int number, int length) {
		// TODO Auto-generated method stub
		int newNum, first, last;
		newNum = 0;
		last = number;
		while(length-- > 0) {
			first = last % 10;
			newNum = (newNum * 10) + first;
			last /= 10;
		}
		if (number == newNum) {
			return true;
		}
		return false;
	}

	private static int getFirst(int i) {
		// TODO Auto-generated method stub
		int number = (int) Math.pow(10, i - 1);
		number += 1;
		return number;
	}

	private static int getLast(int i) {
		// TODO Auto-generated method stub
		int number = 0;
		int mod = 1;
		while (i > 0) {
			number += (9 * mod);
			mod *= 10;
			i--;
		}
		return number;
	}

	private static int checkLength(int number) {
		// TODO Auto-generated method stub
		int length, temp;
		temp = number;
		length = 0;
		while (temp > 0) {
			length++;
			temp /= 10;
		}
		return length;
	}

}
