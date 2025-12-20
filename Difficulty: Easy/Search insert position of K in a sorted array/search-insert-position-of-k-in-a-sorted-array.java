class Solution {
    public int searchInsertK(int arr[], int k) {
        int n = arr.length; 
        int start = 0 ; 
        int end = n-1; 
        while(start <= end){
            int mid = (start + end)/2; 
            if(arr[mid] == k){
                return mid ; 
            }
            else if(arr[mid] < k){
                start = mid + 1; 
            }
            else{
                end = mid - 1 ; 
            }
        }
        return start ; 
    }
};