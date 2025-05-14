//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        String res = "1"; 
        if(n <= 0) return ""; 
        
        for(int i = 1 ; i < n ; i++){
            StringBuilder curr = new StringBuilder();
            int count = 1;  
            char digit = res.charAt(0);
            
            for(int j = 1 ; j < res.length() ; j++){
                if(res.charAt(j) == digit){
                    count ++ ; 
                }
                else{
                    curr.append(count).append(digit);
                    digit = res.charAt(j); 
                    count = 1 ;
                }
            }
            curr.append(count).append(digit); 
            res = curr.toString(); 
        }
        return res ; 
    }
}
