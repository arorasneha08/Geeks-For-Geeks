class Solution {
    int maxSum(int[] arr) {
        int n = arr.length ; 
        int window = 0 ; 
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            sum += arr[i]; 
            window += arr[i] * i ; 
        }
        int max = window; 
        for(int i = 0 ; i < n ;i++){
            int diff = sum - arr[i]; 
            int add = arr[i] * (n - 1); 
            window = window - diff + add;
            max = Math.max(max , window); 
        }
        return max; 
    }
}