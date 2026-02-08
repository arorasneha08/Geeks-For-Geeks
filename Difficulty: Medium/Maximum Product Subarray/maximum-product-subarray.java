class Solution {
    int maxProduct(int[] arr) {
        int pref = 1 ; 
        int suff = 1 ; 
        int ans = Integer.MIN_VALUE ; 
        int n = arr.length ; 
        
        for(int i = 0 ; i<n; i++){
            if(suff == 0) suff = 1 ;
            if(pref == 0) pref = 1 ;
            pref *= arr[i];
            suff *= arr[n-i-1]; 
            ans = Math.max(ans , Math.max(pref, suff)); 
        }
        return ans ; 
    }
}