class Solution {
    public boolean divby13(String s) {
        int n = s.length() ; 
        int res = 0 ; 
        for(int i = 0 ; i< n ; i++){
            char ch = s.charAt(i);
            res = (res * 10 + (ch - '0')) % 13; 
        }
        return res == 0; 
    }
}