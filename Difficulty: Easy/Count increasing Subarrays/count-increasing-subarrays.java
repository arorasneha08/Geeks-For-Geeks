class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length ; 
        long res = 0 ; 
        int count = 0 ; 
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > arr[i-1]){
                count ++ ; 
                res += count; 
            }
            else{
                count = 0 ; 
            }
        }
        return (int) res ; 
    }
}
