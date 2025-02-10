//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


// import java.util.Arrays;

class Solution {
    public static int countSubsets(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (arr[0] == 0 && target == 0) return 2;  // Handling zero case
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }
        // if (target == 0) {
        //     return 1;
        // }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notpick = countSubsets(index - 1, target, arr, dp);
        int pick = 0;
        if (arr[index] <= target) {
            pick = countSubsets(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = pick + notpick;
    }

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countSubsets(n - 1, target, nums, dp);
    }
}
