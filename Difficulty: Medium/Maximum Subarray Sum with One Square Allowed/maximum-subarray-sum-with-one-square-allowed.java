class Solution {
    public int maximumSubarray(int[] arr) {
        // code here
        int n = arr.length ; 
        int ans = Integer.MIN_VALUE;
        int currSum = 0 ; 
        int sqSum = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            currSum = Math.max(currSum + arr[i] , sqSum + arr[i] * arr[i]);
            sqSum = Math.max(sqSum + arr[i] , 0);
            ans = Math.max(ans, Math.max(currSum , sqSum));
        }
        return ans; 
    }
}