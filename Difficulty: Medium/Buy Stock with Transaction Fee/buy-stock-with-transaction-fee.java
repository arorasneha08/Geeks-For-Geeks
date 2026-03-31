
class Solution {
    private int func(int i , int buy , int arr[] , int k , int dp[][]){
        if(i >= arr.length) return 0 ; 
        
        if(dp[i][buy] != -1) return dp[i][buy]; 
        int profit = 0 ; 
        if(buy == 1){
            int take = func(i + 1 ,  0 , arr , k , dp) - arr[i]; 
            int nottake = func(i + 1 , 1 , arr , k , dp); 
            profit = Math.max(take , nottake); 
        }
        else{
            int sell = func(i+ 1 , 1 , arr , k , dp) + arr[i] - k;
            int notsell = func(i + 1 , 0 , arr, k , dp) ; 
            profit = Math.max(sell , notsell); 
        }
        return dp[i][buy] = profit ;
        
    }
    public int maxProfit(int arr[], int k) {
        int n = arr.length ; 
        int dp[][] = new int[n][2];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        return func(0 , 1 , arr , k, dp) ;
    }
}