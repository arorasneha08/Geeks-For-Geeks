//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLen(S));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int maxLen(String s) {
        int open = 0 ; 
        int close = 0 ;
        int n = s.length(); 
        int maxLen = 0 ;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == '('){
                open ++ ; 
            }
            else{
                close ++ ; 
            }
            if(open == close){
                maxLen = Math.max(maxLen , 2 * close); 
            }
            else if(close > open){
                open = 0 ; 
                close = 0 ;
            }
        }
        
        open = 0 ;
        close = 0 ;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = s.charAt(i); 
            if(ch == '('){
                open ++ ; 
            }
            else{
                close ++ ; 
            }
            if(open == close){
                maxLen = Math.max(maxLen , 2 * close); 
            }
            else if(open > close){
                open = 0 ; 
                close = 0 ;
            }
        }
        return maxLen ; 
    }
};