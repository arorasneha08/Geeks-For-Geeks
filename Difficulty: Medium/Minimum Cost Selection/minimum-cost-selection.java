class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length; 
        int dp[][] = new int[n+1][3]; 
        
        for(int i = 0 ; i < n ; i++){
            dp[i+1][0] = mat[i][0] + Math.min(dp[i][1] , dp[i][2]); 
            dp[i+1][1] = mat[i][1] + Math.min(dp[i][0] , dp[i][2]);
            dp[i+1][2] = mat[i][2] + Math.min(dp[i][0] , dp[i][1]); 
        }
        return Math.min(dp[n][0] , Math.min(dp[n][1] , dp[n][2]));
    }
}