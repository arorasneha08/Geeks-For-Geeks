//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int mod = (int) 1e9 + 7 ; 
    public int func(int i , int j , int dp[][] , int grid[][]){
        if(i < 0 || j < 0 || grid[i][j] == 1) return 0 ; 
        if(i == 0 && j == 0){
            return 1 ; 
        }
        if(dp[i][j] != -1) return dp[i][j] ; 
        int up = func(i-1 , j , dp , grid);
        int left = func(i , j-1 , dp , grid);
        return dp[i][j] = (up + left ) % mod; 
    }
    public int totalWays(int n, int m, int grid[][]) {
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row, -1); 
        }
        return func(n-1 , m-1 , dp , grid); 
    }
}