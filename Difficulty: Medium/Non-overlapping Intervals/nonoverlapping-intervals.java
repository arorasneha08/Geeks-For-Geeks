//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        int n = intervals.length; 
        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0] , b[0])) ; 
        
        int count = 1 ; 
        int lastElem = intervals[0][1] ; 
        
        for(int i = 1 ; i < n ; i++){
            if(intervals[i][0] >= lastElem){
                count ++ ; 
                lastElem = intervals[i][1]; 
            }
            else{
                lastElem = Math.min(lastElem, intervals[i][1]);
            }
        }
        return n - count ; 
    }
}
