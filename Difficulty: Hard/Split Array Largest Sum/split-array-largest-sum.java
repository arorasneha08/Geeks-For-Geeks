class Solution {
    private boolean isPossible(int mid  , int k , int arr[]){
        int split = 1 ; 
        int sum = 0 ; 
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] + sum <= mid){
                sum += arr[i]; 
            }
            else{
                split ++; 
                if(split > k) return false ; 
                sum = arr[i]; 
            }
        }
        return true; 
    }
    public int splitArray(int[] arr, int k) {
        int n = arr.length ; 
        int start = 0  ;
        int end = 0 ; 
        for(int i = 0 ; i < n ; i ++){
            end += arr[i]; 
            start = Math.max(start, arr[i]); 
        }
        int res = 0 ; 
        while(start <= end){
            int mid = (start + end)/2;
            if(isPossible(mid , k , arr)){
                res = mid ; 
                end = mid - 1;
            }
            else{
                start = mid + 1; 
            }
        }
        return res ; 
    }
};