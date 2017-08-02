package dataStructure;
import java.io.*;
import java.util.*;

public class EnglishAlphabet {
	static int count = 0;
	public static int word_count(String[][] input1,String input2) {
		horizontalCheck(input1, input2);
		verticalCheck(input1, input2);
		diagonalCheck(input1, input2);
		return count;
	}

	 private static void diagonalCheck(String[][] input1, String input2) {
		 	String word = "";
		 	StringBuffer wordBuffer;
			int length = input1.length - 1;
			for(int i = 0; i <= length; i++) {
				word = word + input1[i][i];
			}
			checkContent(word, input2);
			wordBuffer = new StringBuffer(word);
			word = wordBuffer.reverse().toString();
			checkContent(word, input2);
			word = "";
			for (int i = length; i >= 0; i--) {
				word = word + input1[i][length -i];
			}
			checkContent(word, input2);
			wordBuffer = new StringBuffer(word);
			word = wordBuffer.reverse().toString();
			checkContent(word, input2);
	}

	private static void verticalCheck(String[][] input1, String input2) {
			String word = "";
			int length = input1.length;
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					word = word + input1[j][i];
				}
				checkContent(word, input2);
				word = "";
			}
	}

	private static void horizontalCheck(String[][] input1, String input2) {
		 	String word = "";
			int length = input1.length;
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					word = word + input1[i][j];
				}
				checkContent(word, input2);
				word = "";
			}
	}

	private static void checkContent(String word, String input2) {
			if (word.contains(input2)) {
				count++;
			}
	}

	public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        int output = 0;
	        int ip1_rows = 0;
	        int ip1_cols = 0;
	        ip1_rows = Integer.parseInt(in.nextLine().trim());
	        ip1_cols = Integer.parseInt(in.nextLine().trim());
	        
	        String[][] ip1 = new String[ip1_rows][ip1_cols];
	        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
	            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
	                ip1[ip1_i][ip1_j] = in.next();
	                
	            }
	        }
	        in.nextLine();
	        String ip2 = in.nextLine().trim();
	        output = word_count(ip1,ip2);
	        System.out.println(String.valueOf(output));
	    }
	}