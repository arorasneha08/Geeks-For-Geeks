//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int func(int index , int target , int arr[] , int dp[][]){
        if(target == 0) return 1; 
        if(index < 0 || target < 0) return 0 ; 
        
        // if(index == 0){
        //     if(target % arr[0] == 0) {
        //         return 1; 
        //     }
        //     else return 0 ;
        // }
        if(dp[index][target] != -1) return dp[index][target] ; 
        int notpick = func(index - 1 , target , arr, dp);
        int pick =  func(index , target - arr[index] , arr, dp); 
        return dp[index][target] = pick + notpick ; 
    }
    public int count(int coins[], int sum) {
        int n = coins.length ; 
        int dp[][] = new int[n][sum+1]; 
        for(int row[] : dp){
            Arrays.fill(row, -1) ; 
        }
        return func(n-1 , sum , coins, dp) ; 
    }
}