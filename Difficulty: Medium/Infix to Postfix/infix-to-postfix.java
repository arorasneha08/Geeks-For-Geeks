//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int checkPriority(char ch){
        if(ch == '+' || ch == '-') return 1; 
        else if(ch == '*' || ch == '/') return 2 ; 
        else if(ch == '^') return 3 ;
        return -1 ; 
    }
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>(); 
        int n = s.length() ; 
        String ans = "" ; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if((ch >= 'A' && ch <= 'Z')|| (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                ans += ch ; 
            }
            else if(ch == '('){
                st.push(ch); 
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek()!= '('){
                    ans += st.peek() ;
                    st.pop(); 
                }
                st.pop(); 
            }
            else {
                while(!st.isEmpty() && checkPriority(ch) <= checkPriority(st.peek())){
                    ans += st.peek();
                    st.pop(); 
                }
                st.push(ch); 
            }
        }
        while(!st.isEmpty()){
            ans += st.pop(); 
        }
        return ans ; 
    }
}