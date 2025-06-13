class Solution {
    private boolean isPossible(int mid , int arr[] , int k){
        int total = 0 ; 
        for(int i = 0 ;i < arr.length ; i ++){
            total += Math.ceil((double)arr[i]/mid); 
        }
        if(total > k) return false;
        return true; 
    }
    public int kokoEat(int[] arr, int k) {
        int n = arr.length ; 
        int low = 1 ; 
        int high = 0 ; 
        for(int i = 0 ; i < n ; i ++){
            high = Math.max(high , arr[i]); 
        }
        int res = 0 ; 
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(mid , arr, k)){
                res = mid;  
                high = mid - 1; 
            }
            else{
                low = mid + 1;
            }
        }
        return res; 
    }
}
