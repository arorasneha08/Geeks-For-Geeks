//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int func(int index, int n, int price[], int dp[][]) {
        if (index == 0) {
            return n * price[0]; 
        }
        if (dp[index][n] != -1) return dp[index][n]; 
        
        int pick = Integer.MIN_VALUE;
        int rodLength = index + 1; // Correct rod length calculation
        
        int notpick = func(index - 1, n, price, dp); 
        if (rodLength <= n) { 
            pick = price[index] + func(index, n - rodLength, price, dp);
        }
        
        return dp[index][n] = Math.max(pick, notpick); 
    }

    public int cutRod(int[] price) {
        int n = price.length; 
        int dp[][] = new int[n][n+1]; 
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return func(n-1, n , price, dp); 
    }
}