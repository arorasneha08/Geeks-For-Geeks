class Solution {
    private int func(int i , int j , int mat[][] , int target , int n , int m , int dp[][][]){
        if(i < 0 || j < 0 || j >= m || i >= n) return 0 ; 
        if(target < 0) return 0 ; 
        if(i == n - 1 && j == m-1 ){
            if(target == mat[i][j]){
                return 1 ; 
            }
            return 0; 
        }
        if(dp[i][j][target] != -1) return dp[i][j][target];
        
        int right = func(i , j + 1 , mat , target - mat[i][j] , n , m, dp); 
        int down = func(i + 1 , j , mat , target - mat[i][j] , n , m , dp); 
        return dp[i][j][target] = right + down ; 
    }
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length ;
        int m = mat[0].length ; 
        int dp[][][] = new int[n][m][k+1] ;
        for(int layer[][] : dp){
            for(int row[] : layer){
                Arrays.fill(row , -1); 
            }
        }
        return func(0 , 0 , mat , k , n, m, dp); 
    }
}