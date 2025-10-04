// User function Template for Java

class Solution {
    static boolean palindrome(int left , int right , String s){
        while(left < right ){
            if(s.charAt(left) != s.charAt(right)){
                return false; 
            }
            left ++; 
            right --; 
        }
        return true ; 
    }
    static int func(int i , String s , int dp[]){
        if(i == s.length()) return 0 ; 
        
        if(dp[i] != -1) return dp[i]; 
        String temp = ""; 
        int min = Integer.MAX_VALUE; 
        
        for(int j = i ; j < s.length() ; j++){
            temp += s.charAt(j); 
            if(palindrome(i , j , s)){
                int cost = 1 + func(j + 1 , s , dp); 
                min = Math.min(min , cost); 
            }
        }
        return dp[i] = min ; 
    }
    static int palPartition(String s) {
        int n = s.length(); 
        int dp[] = new int[n]; 
        Arrays.fill(dp , -1); 
        return func(0 , s, dp) - 1; 
    }
}