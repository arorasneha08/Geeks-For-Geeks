// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        // code here
        int count = 0 ; 
        int m = n ; 
        while(n != 0 ){
            int r = n % 10 ; 
            if(r != 0 && m % r == 0){
                count ++; 
            }
            n = n / 10; 
        }
        return count ; 
    }
}