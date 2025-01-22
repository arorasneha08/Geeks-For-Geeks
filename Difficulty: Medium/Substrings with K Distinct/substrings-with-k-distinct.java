//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int helper(String str , int k , int n){
        HashMap<Character , Integer> mpp = new HashMap<>();
        int count = 0 ;
        int left = 0 ;
        for(int right = 0 ; right < n ; right ++){
            char ch = str.charAt(right);
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
            while(mpp.size() > k){
                char leftchar = str.charAt(left); 
                mpp.put(leftchar , mpp.get(leftchar) -1); 
                if(mpp.get(leftchar) == 0){
                    mpp.remove(leftchar) ; 
                } 
                left ++ ; 
            }
            count += (right - left + 1); 
        }
        return count ; 
    }
    int countSubstr(String s, int k) {
        int n = s.length(); 
        return helper(s, k, n)- helper(s,k-1,n); 
    }
}