//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private int func(int index , String s , int[] dp){
        if(index == s.length()) return 1 ; 
        if(s.charAt(index) == '0') return 0 ; 
        if(dp[index] != -1) return dp[index]; 
        int res = func(index+1 , s , dp); 
        if(index + 1 < s.length()) {
            if((s.charAt(index) == '1') || (s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
                res += func(index + 2, s, dp); 
            }
        }
        return dp[index] = res; 
    }
    public int countWays(String s) {
        int n = s.length();
        int dp[] = new int[n+1]; 
        Arrays.fill(dp , -1) ;
        return func(0 , s, dp); 
    }
}