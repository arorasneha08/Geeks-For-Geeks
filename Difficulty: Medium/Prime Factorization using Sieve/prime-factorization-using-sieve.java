//{ Driver Code Starts
// Initial Template for Java

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
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static void sieve() {
        
    }

    static List<Integer> findPrimeFactors(int n) {
        List<Integer> res = new ArrayList<>();
        int arr[] = new int[n+1]; 
        for(int i = 2 ; i <= n ; i++){
            arr[i] = i ; 
        }
        for(int i = 2 ; i*i <= n ; i++){
            if(arr[i] == i){
                for(int j = i*i ; j <= n ; j+=i){
                    if(arr[j] == j){
                        arr[j] = i ; 
                    }
                }
            }
        }
        while(n > 1){
            res.add(arr[n]);
            n = n / arr[n]; 
        }
        return res ; 
    } 
}
