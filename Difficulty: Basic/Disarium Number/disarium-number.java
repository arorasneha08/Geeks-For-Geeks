// User function Template for Java

class Solution {
    static int isDisarium(int N) {
        int n = N; 
        int res = 0 ; 
        int total = 0 ; 
        
        while(n != 0){
            int r = n % 10 ; 
            total ++; 
            n = n / 10 ; 
        }
        n = N;  
        int pos = total ; 
        
        while(n != 0 ){
            int r = n % 10 ; 
            res = res + (int) Math.pow(r , pos); 
            pos --; 
            n = n / 10 ;
        }
        if(res == N) return 1; 
        return 0 ; 
    }
};