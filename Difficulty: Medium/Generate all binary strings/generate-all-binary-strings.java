//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static void func(int i , char ch[], List<String> res, StringBuilder str , int n){
        if(i == n) {
            res.add(str.toString());
            return ; 
        }
        for(char c : ch){
            if(i > 0 && str.charAt(i-1) == '1' && c == '1') continue ;
            str.append(c);
            func(i + 1 , ch, res, str , n); 
            str.deleteCharAt(str.length()-1); 
        }
    }
    public static List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>(); 
        StringBuilder str = new StringBuilder();
        char ch[]= {'0', '1'};
        func(0, ch , res , str , n); 
        return res; 
    }
}
     
     