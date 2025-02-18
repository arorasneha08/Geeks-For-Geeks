//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    static int mod = (int) 1e9 + 7 ; 
    
    public static int func(int i , int j , int dp[][] , int grid[][]){
        if(i < 0 || j < 0 || grid[i][j] == 0) return 0 ; 
        if(i == 0 && j == 0){
            return 1 ; 
        }
        if(dp[i][j] != -1) return dp[i][j] ; 
        int up = func(i-1 , j , dp , grid);
        int left = func(i , j-1 , dp , grid);
        return dp[i][j] = (up + left ) % mod; 
    }
    static int uniquePaths(int n, int m, int[][] grid) {
        if(grid[0][0] == 0|| grid[n-1][m-1] == 0) return 0 ; 
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row, -1); 
        }
        return func(n-1 , m-1 , dp , grid); 
    }
};