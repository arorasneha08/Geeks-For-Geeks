class Solution {
    boolean isPossible(int mid , int arr[] , int k){
        int sum = 0 ; 
        for(int i = 0 ; i < arr.length ; i ++){
            sum += Math.ceil((double) arr[i] / mid); 
        }
        if(sum <= k) return true; 
        return false; 
    }
    int smallestDivisor(int[] arr, int k) {
        int n = arr.length ;
        int start = 0 ;
        int end = 0 ;
        for(int i = 0 ; i < n ; i ++){
            end = Math.max(end , arr[i]); 
        }
        int res = -1 ; 
        while(start <= end){
            int mid = (start + end)/2; 
            if(isPossible(mid , arr, k)){
                res = mid; 
                end = mid - 1; 
            }
            else{
                start = mid + 1; 
            }
        }
        return res; 
    }
}