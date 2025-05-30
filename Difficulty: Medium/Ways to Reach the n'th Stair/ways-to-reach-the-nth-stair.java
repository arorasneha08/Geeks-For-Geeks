//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    int func(int n , int dp[]){
        if(n == 0 || n == 1) return 1 ;
        if(dp[n] != -1) return dp[n];
        return dp[n] = func(n-1 , dp) + func(n-2 , dp); 
    }
    int countWays(int n) {
        int dp[] = new int[n+1];
        // Arrays.fill(dp , -1); 
        // return func(n, dp); 
        
        // dp[0] = dp[1] = 1; 
        // for(int i = 2 ; i<= n ; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n]; 
        
        int prev1 = 1 ;
        int prev2 = 1 ;
        int curr = 0 ;
        for(int i = 2 ; i<= n ; i++){
            curr = prev1 + prev2 ;
            prev2 = prev1 ;
            prev1 = curr; 
        }
        return curr ; 
    }
}
