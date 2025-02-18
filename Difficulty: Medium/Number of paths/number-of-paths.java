//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(read.readLine());
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int func(int i , int j , int m , int n , int dp[][]){
        if(i < 0 || j < 0) return 0 ; 
        if(i == 0 && j == 0){
            return 1 ; 
        }
        if(dp[i][j] != -1) return dp[i][j] ; 
        int up = func(i-1 , j , m, n, dp);
        int left = func(i , j-1 , m , n , dp);
        return dp[i][j] = up + left ; 
    }
    public int numberOfPaths(int m, int n) {
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row, -1); 
        }
        return func(n-1 , m-1 , m , n , dp); 
    }
}