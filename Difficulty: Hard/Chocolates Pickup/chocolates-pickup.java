//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

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
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int func(int i , int j1 , int j2 , int n , int m , int[][] grid , int[][][] dp){
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return Integer.MIN_VALUE ;
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1]; 
            }
            else return grid[i][j1] + grid[i][j2]; 
        }
        
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int maxi = Integer.MIN_VALUE ; 
        for(int dj1 = -1 ; dj1 <= 1 ; dj1 ++){
            for(int dj2 = -1 ; dj2 <= 1 ;dj2 ++){
                int value = 0 ; 
                if(j1 == j2) {
                    value = grid[i][j1]; 
                }
                else{
                    value = grid[i][j1] + grid[i][j2] ; 
                }
                value += func(i+1 , dj1 + j1 , j2 + dj2 , n , m , grid , dp); 
                maxi  = Math.max(maxi , value); 
            }
        }
        return dp[i][j1][j2] = maxi ; 
    }
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return func(0 , 0 , m-1 , n, m, grid , dp); 
    }
}