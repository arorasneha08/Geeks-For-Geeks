// User function Template for Java

class Solution {
    public static int findMean(int[] arr) {
        // code here
        int n = arr.length ; 
        int sum = 0 ;
        for(int num : arr){
            sum += num ; 
        }
        return sum / n; 
    }
};