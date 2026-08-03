class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length ; 
        int maxSum[] = new int[n]; 
        maxSum[0] = arr[0]; 
        int sum = arr[0]; 
        
        for(int i = 1 ; i < n ; i++){
            sum = Math.max(sum + arr[i] , arr[i]); 
            maxSum[i] = sum ; 
        }
        sum = 0 ; 
        for(int i = 0 ; i < k ; i++){
            sum += arr[i]; 
        }
        int res = sum ; 
        for(int i = k ; i < n ; i++){
            sum = sum + arr[i] - arr[i-k]; 
            res = Math.max(res , sum); 
            res = Math.max(res , sum + maxSum[i-k]); 
        }
        return res; 
    }
}