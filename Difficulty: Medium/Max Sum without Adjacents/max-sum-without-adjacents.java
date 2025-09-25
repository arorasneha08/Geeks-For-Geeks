// User function Template for Java

class Solution {
    private int func(int idx , int arr[] , int dp[]){
        if(idx == 0) return arr[idx];
        if(idx < 0) return 0 ; 
        if(dp[idx] != -1) return dp[idx]; 
        
        int notpick = func(idx - 1 , arr , dp); 
        int pick = func(idx - 2 , arr, dp) + arr[idx]; 
        
        return dp[idx] = Math.max(pick , notpick) ; 
        
    }
    int findMaxSum(int arr[]) {
        int n  = arr.length ; 
        int dp[] = new int[n]; 
        // Arrays.fill(dp , -1); 
        // return func(n-1 , arr, dp); 
        
        // dp[0] = arr[0] ;
        // dp[1] = Math.max(arr[0] , arr[1]); 
        // for(int i = 2 ; i < n ; i++){
        //     int notpick = dp[i-1] ; 
        //     int pick = arr[i] + dp[i-2]; 
        //     dp[i] = Math.max(pick , notpick) ; 
        // }
        // return dp[n-1]; 
        
        
        int prev1 = arr[0] ; 
        int prev2 =  Math.max(arr[0] , arr[1]);
        int res = prev2 ; 
        
        for(int i = 2 ; i < n ; i++){
            int notpick = prev2 ; 
            int pick = arr[i] + prev1 ; 
            res = Math.max(pick , notpick); 
            prev1 = prev2 ;
            prev2 = res ; 
        }
        return res; 
    }
}