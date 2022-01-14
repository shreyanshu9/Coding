package Coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split(" ")).limit(n).mapToInt(Integer::parseInt).toArray();
        int jumps = minimumJumps(input);
        System.out.println(jumps);
    }

    public static int minimumJumps(int[] a) {
        int minimumJumps = -1;
        int finalStep = a.length;
        int jumps = 0;
        int currentPosition = 0;
        if (a[0] != 0) {
            while (currentPosition < finalStep - 1) {
                // Check the elements to select between current position and the maximum jump
                int nextJump = currentPosition + a[currentPosition];
                // If nextJump already reaches the last Step, then no need to select other steps.
                if (nextJump < finalStep - 1) {
                    int validJumps = 0;
                    int largestJump = 0;
                    int largestJumpSource = 0;
                    // For selecting the farthest position reachable from steps between current position and next jump
                    for (int i = currentPosition + 1; i <= nextJump; i++) {
                        int jumpDestination = i + a[i];
                        // If the jump reaches to 0 then it is not a valid jump
                        if (jumpDestination < finalStep - 1 && a[jumpDestination] != 0) {
                            validJumps++;
                            if (jumpDestination > largestJump) {
                                largestJump = jumpDestination;
                                largestJumpSource = i;
                            }
                        }
                        // if the next jump could result in reaching end of list, then no need to check other steps.
                        else if (jumpDestination >= finalStep - 1) {
                            validJumps++;
                            largestJumpSource = i;
                            break;
                        }
                    }
                    // If there are no valid steps, then selecting next step is not possible.
                    if (validJumps == 0) {
                        currentPosition = -1;
                        break;
                    }
                    currentPosition = largestJumpSource;
                    jumps++;
                } else {
                    jumps++;
                    currentPosition = nextJump;
                }
            }
        }
        if (a[0] != 0 && currentPosition != -1) {
            minimumJumps = jumps;
        } else if (a[0] == 0 && finalStep == 1) {
            minimumJumps = 0;
        }
        return minimumJumps;
    }
}
