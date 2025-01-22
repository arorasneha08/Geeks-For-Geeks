//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int helper(String str , int k , int n){
        
        HashMap<Character , Integer> mpp = new HashMap<>() ;
        int count = 0 ; 
        int left = 0 ;
        int maxLen = 0 ; 
        
        for(int right = 0 ; right < n ; right ++){
            mpp.put(str.charAt(right) , mpp.getOrDefault(str.charAt(right) , 0) + 1); 
            
            while(mpp.size() >k){
                mpp.put(str.charAt(left) , mpp.get(str.charAt(left)) -1); 
                if(mpp.get(str.charAt(left)) == 0){
                    mpp.remove(str.charAt(left)); 
                }
                left ++ ; 
            }
            
            count += (right - left + 1) ;  
        }
        return count ; 
    }
    public static int countSubstring(String s) {
        int k = 3 ; 
        int n = s.length();
        return helper(s, k, n) - helper(s,k-1,n); 
    }
}
        
