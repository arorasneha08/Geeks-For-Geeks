//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findSubString(String str) {
        int n = str.length();
        HashSet<Character> set = new HashSet(); 
        for(int i = 0 ; i < n ; i++){
            set.add(str.charAt(i)); 
        }
        int left = 0 ; 
        int k = set.size() ; 
        HashMap<Character , Integer> mpp = new HashMap<>();
        int len = Integer.MAX_VALUE ; 
        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i); 
            mpp.put(ch , mpp.getOrDefault(ch , 0) +1); 
            while(mpp.size() == k){
                len = Math.min(len , i - left + 1); 
                mpp.put(str.charAt(left) , mpp.get(str.charAt(left))-1); 
                if(mpp.get(str.charAt(left)) == 0){
                    mpp.remove(str.charAt(left)); 
                }
                left ++ ; 
            }
        }
        return len ; 
    }
}