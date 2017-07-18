//http://practice.geeksforgeeks.org/problems/stickler-theif/0
import java.util.*;
import java.lang.*;
import java.io.*;

class SticklerThief {
public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int amount = getMax(a,n);
            System.out.println(amount);
        }
    }

    private static int getMax(int[] a, int n) {
        int max=a[0];
        int max1=0;
        int amount = 0;
        for(int i = 1; i < n; i++) {
            amount = max;
            if(max1 > max) {
                amount = max1;
            }
            max = max1 + a[i];
            max1 = amount;
        }
        if(max1 > max) {
            amount = max1;
        } else {
            amount = max;
        }
        return amount;
    }
}
