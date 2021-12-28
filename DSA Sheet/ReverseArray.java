import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        String outputString = reverseWord(inputString);
        System.out.println(outputString);
    }

    public static String reverseWord(String input) {
        char[] inputArray = input.toCharArray();
        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            char temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
        }
        String output = String.copyValueOf(inputArray);
        return output;
    }
}
