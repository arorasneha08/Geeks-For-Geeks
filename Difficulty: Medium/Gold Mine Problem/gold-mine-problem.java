class Solution {
    private int func(int i , int j ,int mat[][] , int dp[][] , int n , int m){
        if(i < 0 || j < 0 || i>= n || j >= m) return 0; 
        if(dp[i][j] != -1) return dp[i][j]; 
        int left = func(i-1 , j+1 , mat , dp , n, m);
        int right = func(i+1 , j+1, mat , dp , n, m); 
        int top = func(i , j+1 , mat , dp , n, m); 
        return dp[i][j] = Math.max(left, Math.max(right, top)) + mat[i][j]; 
    }
    public int maxGold(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length; 
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        int best = 0;
        for (int row = 0; row < n; row++){
            best = Math.max(best, func(row, 0, mat, dp, n, m));
        }
        return best;
    }
}