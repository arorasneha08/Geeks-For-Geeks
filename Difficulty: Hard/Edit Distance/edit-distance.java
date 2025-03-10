//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int func(int i , int j , String s1 , String s2 , int dp[][]){
        if(i == 0) return j ; 
        if(j == 0) return i ; 
        if(dp[i][j] != -1) return dp[i][j] ; 
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = func(i-1 , j-1 , s1, s2, dp);
        }
        return dp[i][j] = 1 +  Math.min(func(i-1 , j , s1, s2, dp) , Math.min(func(i, j-1, s1, s2, dp) , func(i-1, j-1,s1, s2, dp)));
    }
    public int editDistance(String s1, String s2) {
       int n1 = s1.length();
       int n2 = s2.length();
       int dp[][] = new int[n1+1][n2+1]; 
       for(int row[] : dp){
           Arrays.fill(row , -1); 
       }
       return func(n1 , n2 , s1 , s2, dp) ; 
    }
}