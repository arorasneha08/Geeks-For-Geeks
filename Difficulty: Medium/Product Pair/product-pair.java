class Solution {
    public boolean isProduct(int[] arr, long target) {
        int n = arr.length ;
        Arrays.sort(arr); 
        int left = 0 ;
        int right = n-1 ;
        while(left < right){
            long prod = (long) arr[left] * arr[right]; 
            if(prod == target) return true; 
            
            else if(prod < target) {
                left ++; 
            }
            else{
                right -- ; 
            }
        }
        return false; 
    }
}