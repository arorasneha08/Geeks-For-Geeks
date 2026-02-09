class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length ; 
        int start = 0 ;
        int end = n-1;  
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2 ;
            if(arr[mid] <= arr[n-1]){
                ans = mid ; 
                end = mid -1 ; 
            }
            else{
                start = mid + 1 ; 
            }
        }
        return ans ; 
    }
}