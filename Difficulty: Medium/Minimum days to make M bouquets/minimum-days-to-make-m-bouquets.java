class Solution {
    private boolean isPossible(int mid , int arr[] , int k , int m){
        int n = arr.length ; 
        int flower = 0 ;
        int boquet = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= mid){
                flower ++; 
                if(flower == k){
                    boquet ++ ; 
                    flower = 0 ; 
                    if(boquet >= m){
                        return true; 
                    }
                }
            }
            else {
                flower = 0 ; 
            }
        }
        return false; 
    }
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length ; 
        if(m * k > n) return -1 ;  
        int start = 1 ;  
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            end = Math.max(end , arr[i]);  
        }
        int res = -1 ; 
        while(start <= end){
            int mid = (start + end)/2 ; 
            if(isPossible(mid , arr , k, m)){
                res = mid  ; 
                end = mid - 1;  
            }
            else{
                start = mid + 1; 
            }
        }
        return res; 
    }
}