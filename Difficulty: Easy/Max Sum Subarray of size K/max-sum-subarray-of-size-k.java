class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length ; 
        int max = 0 ; 
        for(int i = 0 ; i < k ; i++){
            max += arr[i]; 
        }
        int sum = max ; 
        for(int i = k ; i < n ; i++){
            sum += arr[i]; 
            sum -= arr[i-k]; 
            max = Math.max(max , sum); 
        }
        return max; 
    }
}