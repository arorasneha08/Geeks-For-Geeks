class Solution {
    static int count(int m , int n , int x , int dp[][]){
        if(x < 0) return 0 ;
        if(n == 0){
            if(x == 0) return 1 ; 
            else return 0 ; 
        }
        if(dp[n][x] != -1){
            return dp[n][x]; 
        }
        int ways = 0 ;
        for(int i = 1 ; i<= m ; i++){
            ways += count(m , n-1 , x-i , dp); 
        }
        dp[n][x] = ways;  
        return ways; 
    }
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[n+1][x+1];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return count(m, n, x, dp); 
    }
};