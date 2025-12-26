// User function Template for Java

class Solution {
    static boolean isLeap(int n){
        if(n % 400 == 0) return true; 
        else if(n % 4 == 0 && n % 100 != 0) return true ; 
        return false; 
    }
    static int countDays(int d , int m , int y){
        int month[] = {31 , 28 , 31 , 30, 31 , 30 , 31 , 31, 30 , 31 , 30 , 31} ; 
        int days = d ; 
        for(int i = 1 ; i < m ; i++){
            days += month[i-1];
        }
        if(m > 2 && isLeap(y)){
            days ++; 
        }
        for(int i = 1 ; i < y ; i++){
            if(isLeap(i)) days += 366 ; 
            else days += 365 ; 
        }
        return days ; 
    }
    static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {
        int days = 0 ; 
        int t1 = countDays(d1 , m1 , y1); 
        int t2 = countDays(d2 , m2 , y2); 
        
        int res = Math.abs(t1 - t2); 
        return res;
    }
};