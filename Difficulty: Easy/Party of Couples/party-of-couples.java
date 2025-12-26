// User function Template for Java

class Solution {
    static int findSingle(int[] arr) {
        // code here
        int res = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            res ^= arr[i]; 
        }
        return res; 
    }
}