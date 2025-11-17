class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length ; 
        int dp[] = new int[n+1]; 
        for(int i = 0; i < n ; i++){
            dp[i] = arr[i]; 
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i] , dp[j] + arr[i]); 
                }
            }
        }
        
        int max = Integer.MIN_VALUE ; 
        for(int num : dp){
            max = Math.max(max , num);
        }
        return max ; 
    }
}