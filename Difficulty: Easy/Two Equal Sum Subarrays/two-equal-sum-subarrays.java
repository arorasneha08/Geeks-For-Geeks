class Solution {
    public boolean canSplit(int arr[]) {
        int n = arr.length; 
        int total= 0 ; 
        for(int i = 0; i < n ; i++){
            total += arr[i]; 
        }
        int runningSum = 0 ;
        for(int i = 0 ; i < n - 1; i++){
            runningSum += arr[i];
            if(runningSum == total - runningSum){
                return true;
            }
        }
        return false ;
    }
}