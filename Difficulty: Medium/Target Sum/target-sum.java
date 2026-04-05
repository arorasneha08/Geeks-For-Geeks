

//User function Template for Java

class Solution {
    static int mod = (int) 1e9+7 ; 
    
    static int func(int index , int target , int arr[] , int dp[][]){
        if(target == 0) return 1 ; 
        if(index == 0){
            if(arr[0] == target) return 1 ;
            else return 0 ; 
        }
        
        if(dp[index][target] != -1) return dp[index][target];
        int notpick = func(index-1 , target, arr, dp);
        int pick = 0 ;
        if(arr[index] <= target){
            pick = func(index -1 , target-arr[index] , arr, dp); 
        }
        return dp[index][target] = (pick + notpick)% mod ;
    }
    static int totalWays(int[] arr ,int k) {
        int n = arr.length ; 
        int sum =  0; 
        for(int num : arr){
            sum += num ; 
        }
        if((sum - k )< 0 || (sum - k) % 2 != 0) return 0; 
        int target = (sum - k )/2 ; 
        int dp[][] = new int[n][target+1]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // return func(n-1 , target , arr , dp) ;
        
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 1 ;
        // }
        // if(arr[0] <= target) dp[0][arr[0]] = 1; 
        // for(int idx = 1 ; idx <n ;idx++){
        //     for(int tar = 0 ; tar <= target ; tar++){
        //         int notpick = dp[idx-1][tar] ;
        //         int pick = 0; 
        //         if(arr[idx] <= tar){
        //             pick = dp[idx-1][tar-arr[idx]]; 
        //         }
        //         dp[idx][tar] = (pick + notpick) % mod; 
        //     }
        // }
        // return dp[n-1][target] ; 
        
        int prev[] = new int[target+1]; 
        for(int i = 0 ; i < n ; i++){
            prev[0] = 1 ;
        }
        if(arr[0] <= target) prev[arr[0]] = 1; 
        for(int idx = 1 ; idx <n ;idx++){
            int curr[] = new int[target+1]; 
            for(int tar = 0 ; tar <= target ; tar++){
                int notpick = prev[tar] ;
                int pick = 0; 
                if(arr[idx] <= tar){
                    pick = prev[tar-arr[idx]]; 
                }
                curr[tar] = (pick + notpick) % mod; 
            }
            prev = curr; 
        }
        return prev[target] ; 
    }
};