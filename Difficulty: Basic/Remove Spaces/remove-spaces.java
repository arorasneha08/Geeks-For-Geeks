class Solution {
    String removeSpaces(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == ' '){
                continue;
            }
            else{
                str.append(ch); 
            }
        }
        return str.toString(); 
    }
}