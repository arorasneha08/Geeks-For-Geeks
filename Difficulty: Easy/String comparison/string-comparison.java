//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String st = br.readLine();
            String[] parts = st.split(" ");
            Solution obj = new Solution();
            int res = obj.stringComparsion(parts[0], parts[1]);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    private static int findPriority(String s , int i){
        int n = s.length(); 
        if(i+1 < n && s.charAt(i) == 'n' && s.charAt(i+1) == 'g'){
            return 14 ; 
        }
        char ch = s.charAt(i); 
        if(ch < 'n') return ch - 'a'; 
        if(ch == 'n') return 13; 
        if(ch == 'o') return 15 ; 
        return ch - 'a' + 1  ;
    }
    public static int stringComparsion(String s1, String s2) {
        int n = s1.length(); 
        int m = s2.length();
        int i = 0 , j = 0 ; 
        while(i< n && j < m){
            int p1 = findPriority(s1, i); 
            int p2 = findPriority(s2, j); 
            if(p1 != p2){
                if(p1 < p2) return -1; 
                else return 1 ;
            }
            i += (p1 == 14 ? 2 : 1); 
            j += (p2 == 14 ? 2 : 1); 
        }
        if(i == n && j == m) return 0 ; 
        if(i == n) return -1; 
        return 1 ; 
    }
}
