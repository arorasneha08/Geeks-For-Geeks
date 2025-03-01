//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        int n = s.length(); 
        Stack<StringBuilder> stringStack = new Stack<>() ;
        Stack<Integer> countStack = new Stack<>(); 
        StringBuilder currStr = new StringBuilder(); 
        int num = 0 ; 
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0') ; 
            }
            else if(ch == '['){
                countStack.push(num); 
                stringStack.push(currStr); 
                num = 0 ; 
                currStr = new StringBuilder() ; 
            }
            else if(ch == ']'){
                StringBuilder decodedString = stringStack.pop();
                int repeat = countStack.pop();

                for(int i = 0 ; i < repeat ; i++){
                    decodedString.append(currStr); 
                }
                currStr = decodedString ; 
            }
            else{
                currStr.append(ch); 
            }
        }
        return currStr.toString(); 
    }
}