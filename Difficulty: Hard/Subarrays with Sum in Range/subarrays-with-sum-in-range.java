class Solution {
    private int func(int arr[] , int k){
        int sum = 0 ; 
        int i = 0 , j = 0 ;
        int n = arr.length ; 
        int count = 0 ; 
        
        while(j < n){
            sum += arr[j]; 
            while(sum > k){
                count += (n - j); 
                sum -= arr[i]; 
                i++; 
            }
            j++; 
        }
        return count; 
    }
    public int countSubarray(int[] arr, int l, int r) {
        int n = arr.length ; 
        int x = func(arr , r);
        int y = func(arr , l - 1); 
        return y - x ; 
    }
}