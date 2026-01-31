class Solution {
    static int func(int faces , int dice , int target , int dp[][]){
        if(dice == 0 && target == 0) return 1; 
        if(dice == 0 || target < 0) return 0 ;
        if(dp[dice][target] != -1) return dp[dice][target]; 
        int res = 0 ; 
        for(int i = 1 ; i <= faces ; i++){
            res += func(faces , dice - 1 , target - i , dp); 
        }
        return dp[dice][target] = res ; 
    }
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[51][51]; 
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        return func(m , n , x , dp); 
    }
};