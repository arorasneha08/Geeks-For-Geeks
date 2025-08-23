class Solution {
    private boolean isPossible(int mid , int arr[] , int k){
        int n = arr.length ;
        int sum = 0 ; 
        int students = 1 ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] + sum <= mid){
                sum += arr[i]; 
            }
            else{
                sum = arr[i]; 
                students ++; 
            }
        }
        if(students > k) return false ;
        return true; 
    }
    public int findPages(int[] arr, int k) {
        int n = arr.length ; 
        if (k > arr.length) return -1 ; 
        int start = 1 ; 
        int end = 0;
        for(int i = 0 ; i< n ;i++){
            start = Math.max(start , arr[i]); 
            end += arr[i]; 
        }
        int res = -1 ; 
        while(start <= end){
            int mid = start + (end - start)/2 ; 
            if(isPossible(mid , arr , k)){
                res = mid ; 
                end = mid - 1; 
            }
            else{
                start = mid + 1;
            }
        }
        return res; 
    }
}