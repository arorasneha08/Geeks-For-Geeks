//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

class gfg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(mat));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int func(int i , int j , int dp[][] , int mat[][]){
        if(i < 0 || j < 0 || j >= mat[0].length) return Integer.MIN_VALUE ; 
        
        if(i == 0) return mat[i][j]; 
        if(dp[i][j] != -1) return dp[i][j]; 
        
        int up = func(i-1 , j , dp , mat);
        int left = func(i-1, j-1, dp, mat);
        int right = func(i-1, j+1 , dp , mat); 
        
        int max = mat[i][j] + Math.max(up , Math.max(left , right)); 
        return dp[i][j] = max; 
    }
    public int maximumPath(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        int maxPathSum = Integer.MIN_VALUE ; 
        for(int j = 0; j < m ; j++){
            maxPathSum = Math.max(func(n-1 , j , dp , mat) , maxPathSum);  
        }
        return maxPathSum ; 
    }
}