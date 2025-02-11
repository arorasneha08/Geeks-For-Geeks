//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int index, int weight, int val[], int wt[], int[][] dp) {
        if (index == 0) {
            return (weight / wt[0]) * val[0]; 
        }

        if (dp[index][weight] != -1) return dp[index][weight]; 

        int notpick = maxProfit(index - 1, weight, val, wt, dp);
        int pick = Integer.MIN_VALUE;
        if (wt[index] <= weight) {
            pick = val[index] + maxProfit(index, weight - wt[index], val, wt, dp);
        }

        return dp[index][weight] = Math.max(pick, notpick);
    }

    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int dp[][] = new int[n][capacity + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return maxProfit(n - 1, capacity, val, wt, dp);
    }
}