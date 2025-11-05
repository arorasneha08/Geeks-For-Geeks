class Solution {
    private int func(int n , int dp[]){
        if(n == 0) return 0 ; 
        int res = n ; 
        if(dp[n] != -1) return dp[n];
        
        for(int i = 1 ; i * i <= n ; i++){
            int temp = i * i ; 
            res = Math.min(res, 1 + func(n - temp , dp)); 
        }
        return dp[n] = res ; 
    }
    public int minSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1); 
        return func(n , dp);
    }
}