

// User function Template for Java

class Solution {
    public String removeKdig(String str, int k) {
        int n = str.length();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i< str.length() ; i++){
            char ch = str.charAt(i) ; 
            while(!st.isEmpty() && st.peek() > ch && k > 0){
                st.pop();
                k-- ; 
            }
            st.push(ch); 
        }
        
        while(!st.isEmpty() && k > 0){
            st.pop();
            k-- ; 
        }
        
        if(st.isEmpty()){
            return "0"; 
        }
        StringBuilder s = new StringBuilder();
        
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        s.reverse();
        
        while(s.length() > 0 && s.charAt(0) == '0'){
            s.deleteCharAt(0) ; 
        }
        if(s.length() == 0) return "0"; 
        
        return s.toString(); 
    }
}