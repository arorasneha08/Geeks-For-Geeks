//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int freq[] = new int[26];
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            freq[ch - 'a'] ++ ; 
        }
        int res = 0 ; 
        for(int i = 0 ; i < 26;i++){
            res += freq[i];
            res += freq[i] * (freq[i] - 1) / 2 ; 
        }
        return res; 
    } 
}