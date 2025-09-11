class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length ; 
        if(n <= 1) return 0 ;
        if(arr[0] == 0) return -1 ; 
        int jumps = 0 ; 
        
        int left = 0 , right = 0 ;
        while(right < n-1){
            int farthest = right ; 
            
            for(int i = left ; i<= right ; i++){
                farthest = Math.max(farthest , i + arr[i]); 
            }
            if (farthest == right) return -1; 
            jumps ++ ; 
            left = right + 1; 
            right = farthest ; 
        }
        return jumps; 
    }
}