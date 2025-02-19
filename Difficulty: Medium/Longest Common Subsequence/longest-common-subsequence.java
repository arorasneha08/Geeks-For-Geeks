//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static int func(int index1 , int index2 , String s1 , String s2, int dp[][]){
        if(index1 == 0 || index2 == 0){
            return 0 ;
        }
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            return 1 + func(index1-1 , index2-1 , s1, s2, dp);
        }
        return dp[index1][index2] = Math.max(func(index1 -1 , index2 , s1, s2, dp) ,
        func(index1 , index2-1 , s1, s2, dp)); 
    }
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return func(n1 , n2 , s1, s2, dp); 
    }
}