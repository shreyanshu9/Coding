package geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SecondMostRepeatedStringInAsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int x = 0; x < T; x++) {
			String pattern = null;
			int repetition;
			int maxRepetition = 0;
			int secondMaxRepetition = 0;
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				pattern = st.nextToken();
				repetition = 1;
				if (hm.containsKey(pattern)) {
					repetition = hm.get(pattern) + 1;
					if (maxRepetition < repetition) {
						maxRepetition = repetition;
					}
				}
				hm.put(pattern, repetition);
			}
			Iterator itr = hm.entrySet().iterator();
			while (itr.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry)itr.next();
				int value = (Integer)pair.getValue();
				if (value > secondMaxRepetition && value != maxRepetition) {
					secondMaxRepetition = value;
					pattern = (String)pair.getKey();
				}
			}
			System.out.println(pattern);
		}
			
	}
}