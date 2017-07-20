//http://practice.geeksforgeeks.org/problems/camelcase-pattern-matching/0
package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class CamelCasePatternMatching {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int x = 0; x < T; x++) {
			int n = Integer.parseInt(br.readLine());
			String pattern = null;
			Vector<String> vector = new Vector<String>(n);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				vector.addElement(st.nextToken());
			}
			 pattern = br.readLine();
			 findPattern(vector, pattern, n);
		}
		
	}

	private static void findPattern(Vector<String> vector, String pattern, int n) {
		// TODO Auto-generated method stub
		boolean check = true;
		int patternLength = pattern.length();
		ArrayList<String> ar = new ArrayList<String>();
		int i = 0;
		String array[] = new String[n];
		Enumeration<String> loop = vector.elements();
		while (loop.hasMoreElements()) {
			String currentElement = (String)loop.nextElement();
			String elementPattern = currentElement.replaceAll("[a-z]", "");
			String elementRealPattern = elementPattern;
			if (elementPattern.length() >= patternLength) {
				elementPattern = elementPattern.substring(0, patternLength);
			}
			if (elementPattern.equals(pattern)) {
				ar.add(elementRealPattern + " " + i);
				array[i] = currentElement;
				i++;
				check = false;
			}
		}
		if(check) {
			System.out.println("No match found");
		} else {
			Collections.sort(ar);
			Iterator<String> itr = ar.iterator();
			while (itr.hasNext()) {
				String elementData = (String)itr.next();
				int elementSpace = elementData.indexOf(" ") + 1;
				String elementValue = elementData.substring(elementSpace, elementData.length());
				String value = array[Integer.parseInt(elementValue)];
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
