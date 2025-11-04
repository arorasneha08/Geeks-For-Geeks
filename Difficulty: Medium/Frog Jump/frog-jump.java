// User function Template for Java
class Solution {
    // using memoization :- 
    int func(int height[] , int index , int[] dp){
        if(index == 0) return 0; 
        if(index == 1) {
            return Math.abs(height[1] - height[0]); 
        }
        if(dp[index] != -1) return dp[index]; 
        int left = func(height, index-1 , dp) + Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = func(height , index-2 , dp) + Math.abs(height[index] - height[index-2]);
        } 
        dp[index] = Math.min(left , right); 
        return dp[index]; 
    }
    
    int minCost(int[] height) {
        
        // using memoization :- 
        
        // int n = height.length ; 
        // int dp[] = new int[n+1]; 
        // for(int i = 0 ; i < n ; i++){
        //     dp[i] = -1;  
        // }
        // return func(height , n-1 , dp); 
        
        // using tabulation :- 
        
        // int n = height.length ; 
        // int dp[] = new int[n+1]; 
        // for(int i = 1; i< n ; i++){
        //     int firstStep = dp[i-1] +  Math.abs(height[i-1] - height[i]) ; 
        //     int secondStep = Integer.MAX_VALUE;  
        //     if(i > 1){
        //         secondStep = dp[i-2] + Math.abs(height[i-2] - height[i]); 
        //     }
        //     dp[i] = Math.min(firstStep , secondStep) ;
        // }
        // return dp[n-1]; 
        
        // space optimizarion :- 
        int n = height.length ;
        int prev = 0 ;
        int prev2 = 0 ; 
        for(int i = 1; i< n ; i++){
            int firstStep = prev +  Math.abs(height[i-1] - height[i]) ; 
            int secondStep = Integer.MAX_VALUE;  
            if(i > 1){
                secondStep = prev2 + Math.abs(height[i-2] - height[i]); 
            }
            int curr = Math.min(firstStep , secondStep) ;
            prev2 = prev ;
            prev = curr; 
        }
        return prev; 
        
    }
}
