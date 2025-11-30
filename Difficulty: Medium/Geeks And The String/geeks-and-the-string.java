class Solution {
    public static String removePair(String s) {
        int n = s.length() ;
        Stack<Character> st = new Stack<>(); 
        
        for(int i = 0 ; i < n ; i++){
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop(); 
            }
            else{
                st.push(s.charAt(i)); 
            }
                
        }
        StringBuilder str = new StringBuilder(); 
        while(!st.isEmpty()){
            str.append(st.pop()); 
        }
        if(str.isEmpty()) return "-1";
        str.reverse(); 
        return str.toString(); 
    }
}
