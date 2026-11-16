class Solution {
    public int findKthSmall(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length; 
        int res = k ;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= res){
                res ++; 
            }    
            else{
                break ; 
            }
        }
        return res; 
    }
}