class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length ; 
        int zeros = 0 ; 
        int left = 0 ; 
        int max = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                zeros ++; 
            }
            if(zeros > k){
              if(arr[left] == 0){
                  zeros --; 
              }  
              left ++; 
            }
            if(zeros <= k){
                int len = i - left + 1; 
                max = Math.max(max , len); 
            }
        }
        return max; 
    }
}