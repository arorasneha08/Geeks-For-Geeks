// User function Template for Java
class Solution {
    static boolean armstrongNumber(int N) {
        // code here
        int n = N; 
        int count = 0  ; 
        while(n > 0){
            int r = n % 10 ; 
            count ++; 
            n = n / 10 ; 
        }
        n = N ; 
        int res = 0 ; 
        while(n > 0){
            int r = n % 10 ;
            res += (int)Math.pow(r , count); 
            n = n / 10 ; 
        }
        if(res == N)  return true; 
        return false; 
    }
}