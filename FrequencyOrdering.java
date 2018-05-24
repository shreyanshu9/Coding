//Print a number based on its frequency
package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyOrdering {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		orderByFrequency(ar);
	}

	private static void orderByFrequency(int[] ar) {
		// TODO Auto-generated method stub
		boolean ASC = true;
		boolean DESC = false;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int value;
		for (int i = 0; i < ar.length; i++) {
			if (hm.containsKey(ar[i])) {
				value = hm.get(ar[i]) + 1;
				hm.put(ar[i], value);
			} else {
				hm.put(ar[i], 1);
			}
		}
		
		//Print the Values in Map
		printMap(sortByValue(hm, DESC));
	}

	private static void printMap(Map<Integer, Integer> hm) {
		// Function to Print Values
		int key, value;
		for (Entry<Integer, Integer> ent : hm.entrySet()) {
			key = ent.getKey();
			value = ent.getValue();
			while (value-- > 0) {
				System.out.print(key + " ");
			}
		}
	}

	private static Map<Integer, Integer> sortByValue(
			Map<Integer, Integer> hm, final boolean order) {
		// Because Collection.sort uses list
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {

			public int compare(Entry<Integer, Integer> obj1,
					Entry<Integer, Integer> obj2) {
				// For Ascending or Descending order
				if (order) {
					return obj1.getValue().compareTo(obj2.getValue());
				} else {
					return obj2.getValue().compareTo(obj1.getValue());
				}
			}
			
		});
		// For Maintaining insertion order
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Entry<Integer, Integer> ent : list) {
			sortedMap.put(ent.getKey(), ent.getValue());
		}
		return sortedMap;
	}

}
