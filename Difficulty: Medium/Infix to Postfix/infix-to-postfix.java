class Solution {
    private static int precedence(char ch){
        if(ch == '+' || ch == '-') return 1 ; 
        else if(ch == '*' || ch == '/') return 2 ; 
        else if(ch == '^') return 3 ; 
        return 0 ; 
    }
    public static String infixToPostfix(String s) {
        int n = s.length(); 
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') 
            || (ch >= '0' && ch <= '9')){
                str.append(ch); 
            }
            else if(ch == '('){
                st.push(ch) ; 
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    str.append(st.pop()); 
                }
                st.pop(); 
            }
            else {
                while (!st.isEmpty() && 
                       (precedence(st.peek()) > precedence(ch) || 
                       precedence(st.peek()) == precedence(ch) && ch != '^')) {
                    str.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            str.append(st.pop()); 
        }
        return str.toString(); 
    }
}