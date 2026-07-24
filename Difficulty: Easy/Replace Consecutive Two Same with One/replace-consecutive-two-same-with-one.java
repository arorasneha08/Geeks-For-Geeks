class Solution {
    public String removeDuplicates(String s) {
        int n = s.length(); 
        StringBuilder res = new StringBuilder(); 
        for(int i = 0 ; i < n ; i++){
            res.append(s.charAt(i)); 
            while(i + 1 < n && s.charAt(i) == s.charAt(i + 1)){
                i++; 
            }
        }
        return res.toString(); 
    }
}