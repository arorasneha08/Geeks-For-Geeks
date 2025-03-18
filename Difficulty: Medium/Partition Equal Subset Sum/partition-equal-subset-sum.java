//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static boolean func(int index , int target ,int[] arr , boolean[][] dp){
        if(target == 0) return true ;
        if(index == 0) return arr[index] == target ; 
        if(dp[index][target] != false) return dp[index][target]; 
        
        boolean notpick = func(index -1 , target , arr, dp);
        boolean pick = false;
        if(arr[index] <= target){
            pick = func(index-1 , target - arr[index] , arr, dp); 
        }
        return dp[index][target] = pick || notpick ; 
    }
    static boolean equalPartition(int arr[]) {
        // int n = arr.length ;
        // int totalSum = 0 ;
        // for(int i = 0 ; i < n ; i++){
        //     totalSum += arr[i]; 
        // }
        // int target = totalSum / 2; 
        // boolean dp[][] = new boolean[n][target+1]; 
        
        // if(totalSum % 2 == 1) return false; 
        // // return func(n-1 , target , arr, dp) ; 
        
        // for(int i = 0 ; i< n ;i++){
        //     dp[i][0] = true ; 
        // }
        // if (arr[0] <= target) dp[0][arr[0]] = true;
        
        // for(int idx = 1 ; idx < n ;idx ++){
        //     for(int tar = 1 ; tar <= target ; tar++){
        //         boolean nottake = dp[idx-1][tar]; 
        //         boolean take = false; 
        //         if(arr[idx] <= tar){
        //             take = dp[idx-1][tar - arr[idx]];  
        //         }
        //         dp[idx][tar] = (take || nottake) ; 
        //     }
        // }
        // return dp[n-1][target]; 
        
        
        int n = arr.length ;
        int totalSum = 0 ;
        for(int i = 0 ; i < n ; i++){
            totalSum += arr[i]; 
        }
        int target = totalSum / 2; 
        boolean prev[] = new boolean[target+1]; 
        
        if(totalSum % 2 == 1) return false; 
        
        for(int i = 0 ; i< n ;i++){
            prev[0] = true ; 
        }
        if (arr[0] <= target) prev[arr[0]] = true;
        
        for(int idx = 1 ; idx < n ;idx ++){
            boolean curr[] = new boolean[target+1]; 
            for(int tar = 1 ; tar <= target ; tar++){
                boolean nottake = prev[tar]; 
                boolean take = false; 
                if(arr[idx] <= tar){
                    take = prev[tar - arr[idx]];  
                }
                curr[tar] = (take || nottake) ; 
            }
            prev = curr ; 
        }
        return prev[target]; 
    }
}