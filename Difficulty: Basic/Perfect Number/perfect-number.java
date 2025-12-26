// User function Template for Java

class Solution {
    int fact(int n){
        int f = 1; 
        for(int i = 1 ; i <= n ; i++){
            f *= i ; 
        }
        return f; 
    }
    int isPerfect(int N) {
        int res = 0 ;  
        int n = N ; 
        while(n != 0){
            int r = n % 10 ; 
            res += fact(r); 
            n = n /10; 
        }
        if(res == N) return 1 ; 
        return 0 ; 
    }
}