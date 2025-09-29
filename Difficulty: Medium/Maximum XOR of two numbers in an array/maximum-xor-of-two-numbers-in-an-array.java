// User function Template for Java

class Solution {
    public int maxXor(int[] arr) {
        int n = arr.length ; 
        int max = 0 ; 
        for(int i = 0 ; i < n - 1; i++){
            for(int j = i + 1 ; j< n ; j++){
                int num = arr[i] ^ arr[j]; 
                max = Math.max(max , num); 
            }
        }
        return max;
    }
}