//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int func(int n, int dp[]){
        if(n == 0 || n == 1) return n ;
        if(dp[n] != -1) return dp[n];
        
        dp[n] = func(n-1 , dp) + func(n-2 , dp); 
        return dp[n] ; 
    }
    public int nthFibonacci(int n) {
        // memoisation :- 
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1) ;
        return func(n , dp); 
    }
}