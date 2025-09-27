class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length ; 
        int pref[] = new int[n+2]; 
        int res = 0 ;
        
        for(int i = 0 ; i <= (n-k) ; i++){
            if(i > 0){
                pref[i] += pref[i-1]; 
            }
            
            if(arr[i] == 0 && pref[i] % 2 == 0){
                pref[i] ++; 
                pref[i+k]-- ; 
                res ++ ; 
            }
            
            if(arr[i] == 1 && pref[i] % 2 == 1){
                pref[i] ++; 
                pref[i+k] -- ; 
                res ++; 
            }
            
        }
        for(int i = n-k+1 ; i< n ; i++){
            pref[i] += pref[i-1] ;
            if(arr[i] == 0 && pref[i] % 2 == 0 ){
                return -1; 
            }
            if(arr[i] == 1 && pref[i] % 2 == 1){
                return -1; 
            }
        }
        return res; 
    }
}
