//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long num = Long.parseLong(read.readLine()); 
            Solution ob = new Solution();
            System.out.println(ob.modify(num));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long modify(long N) {
        long res = 0 ;
        long prev = -1 ; 
        int power = 0 ;  
        while(N > 0){
            long digit = N % 10; 
            N = N / 10 ; 
            if(prev != digit){
                res += (digit * Math.pow(10 , power)); 
                power++ ; 
            }
            prev = digit; 
        }
        return res; 
    }
}