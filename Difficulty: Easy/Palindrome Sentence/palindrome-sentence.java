class Solution {
    public boolean isPalinSent(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase(); 
        int n = s.length(); 
        for(int i = 0 ; i < n/2 ; i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false; 
            }
        }
        return true ; 
    }
}