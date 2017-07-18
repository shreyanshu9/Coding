//http://practice.geeksforgeeks.org/problems/consecutive-array-elements/0
import java.util.*;
import java.lang.*;
import java.io.*;
class ConsecutiveArrayElements {
public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int x = 0; x < T; x++) {
    	int n = Integer.parseInt(br.readLine());
    	int k = 0;
    	int a[] = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		a[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(a);
    	for(int i = 1; i < n; i++) {
    		if (a[i] != a[i-1] + 1) {
    			System.out.println("No");
    			k = 1;
    			break;
    		}
    	}
    	if (k == 0) {
    		System.out.println("Yes");
    	}
    }
	}
}