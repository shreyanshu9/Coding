package geeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class PhoneDirectory {
	static Set <String> ts = new TreeSet <String>();
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, n, l, i, result, x;
		String contacts, query, search;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			String contactList[] = new String[n];
			contacts = br.readLine();
			query = br.readLine();
			contactList = contacts.split(" ");
			l = 0;
			result = 1;
			x = 0;
			while (l < query.length()) {
				if (result == 1) {
					search = "";
					i = 0;
					while (i <= l) {
						search = search + query.charAt(i);
						i++;
					}
					result = getResult(contactList, search);
				}
				if (result == 0) {
					x++;
				} 
				l++;
			}
			while (x-- > 0) {
				System.out.println("0");
			}
		}

	}

	private static int getResult(String[] contactList, String search) {
		// TODO Auto-generated method stub
		int i = 0, check = 0;
		while (i < contactList.length) {
			if (contactList[i].startsWith(search)) {
				ts.add(contactList[i]);
				check = 1;
			}
			i++;
		}
		if (check == 1) {
			java.util.Iterator<String> itr = ts.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}
		ts.clear();
		return check;
	}

}
