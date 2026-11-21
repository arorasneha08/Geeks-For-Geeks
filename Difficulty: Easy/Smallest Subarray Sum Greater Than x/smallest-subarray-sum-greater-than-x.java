class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        // code here
        int n = arr.length; 
        int left = 0 ;
        int sum = 0 ; 
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            
            while(sum > x){
                min = Math.min(min , i - left + 1); 
                sum -= arr[left];
                left++; 
            }
        }
        if(min == Integer.MAX_VALUE) return 0 ;
        return min; 
    }
}