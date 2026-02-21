class Solution {
    private boolean isValid(int arr[] , int mid){
        int count = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= mid){
                count ++; 
            }
        }
        if(count >= mid) return true; 
        return false; 
    }
    public int hIndex(int[] arr) {
        int n = arr.length ; 
        int max = Integer.MIN_VALUE ; 
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , arr[i]) ;
        }
        int left = 0; 
        int right = max ;
        int res = 0 ; 
        while(left <= right){
            int mid = left + (right - left)/2 ;
            if(isValid(arr, mid)){
                res = mid ; 
                left = mid + 1 ; 
            }
            else{
                right = mid - 1; 
            }
        }
        return res ;
    }
}