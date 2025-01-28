//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            int ans = obj.minCandy(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minCandy(int arr[]) {
        int n = arr.length  ;
        int candy = n ;
        int i = 1 ; 
        
        while(i < n){
            if(arr[i] == arr[i-1]) {
                i++ ; 
                continue ; 
            }
            int peak = 0 ; 
            while(i < n && arr[i] > arr[i-1]){
                peak ++ ;
                candy += peak ; 
                i++ ; 
                if(i == n) return candy ; 
            }
            int dip = 0 ;
            while(i < n && arr[i] < arr[i-1]){
                dip ++ ;
                candy += dip ;
                i++ ; 
            }
            candy -= Math.min(peak , dip);
        }
        return candy ; 
    }
}
