package geeks;
import java.io.*;
import java.util.*;

public class flipDigit {

	public static int nochange_bits(String input1,int input2,int input3)
    {
	   int total;
	   int length = input1.length();
	   if (input2 <= 0 || input3 <= 0) {
	       return -1;
	   } else if (input2 == input3){
		   return length;
	   } else {
		   if (input2 % input3 == 0) {
			   total = length - (length/input3 - length/input2);
		   } else if (input3 % input2 == 0) {
			   total = length -  (length/input2 - length/input3);
		   } else {
			   int common = lcm(input2, input3);
			   total = length - (length/input2 + length/input3 - length/common);
		   }
	       return total;
	   }
    }
	
	private static int lcm(int input2, int input3) {
		int n = input2;
		if(input2 > input3) {
			n = input3;
		}
		while (n > 0) {
			if (input2 % n == 0 && input3 % n == 0) {
				break;
			}
			n--;
		}
		n = (input2 * input3)/n;
		return n;
	}

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        String ip1 = in.nextLine().trim();
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3 = Integer.parseInt(in.nextLine().trim());
        output = nochange_bits(ip1,ip2,ip3);
        System.out.println(String.valueOf(output));
    }
}
