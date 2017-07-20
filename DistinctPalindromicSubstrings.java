//http://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings/0
package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class DistinctPalindromicSubstrings{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int x = 0; x < T; x++) {
			String word = br.readLine();
			HashMap<String, String> hm = new HashMap<String, String>();
			String newResult;
			int wordLength = word.length() - 1;
			for (int i = 0; i <= wordLength; i++) {
				for (int j = wordLength; j >= 0; j--) {
					if ( i <= j) {
						newResult = checkPalindrome(word, i, j);
						if (newResult != null) {
							hm.put(newResult, newResult);
						}
					}
				}
			}
			java.util.Iterator<Entry<String, String>> itr = hm.entrySet().iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next().getKey());
			}
			int result = hm.size();
			System.out.println(result);
		}
	}

	private static String checkPalindrome(String word, int start, int end) {
		// TODO Auto-generated method stub
		int i = start;
		int j = end;
		while (start <= end) {
			if(word.charAt(start) == word.charAt(end)) {
				start ++;
				end --;
			} else {
				return null;
			}
		}
		return word.substring(i, j+1);
	}
}