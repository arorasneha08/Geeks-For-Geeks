class Solution {
    static int closestNumber(int n, int m) {
        int rem =n % m; 
        if(n % m == 0) return n ; 
        int m1 = Math.abs(m) ; 
        int r = n % m1;
        int num1 = n - r ; 
        int num2 = num1 + (n > 0 ? m1 : -m1); 
        int d1 = Math.abs(n - num1); 
        int d2 = Math.abs(n - num2); 
        if(d1 < d2) return num1 ; 
        else if(d2 < d1) return num2 ; 
        else return Math.abs(num1) > Math.abs(num2) ? num1 : num2 ; 
    }
}
