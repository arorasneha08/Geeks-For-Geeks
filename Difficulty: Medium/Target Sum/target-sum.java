//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = (int) 1e9+7 ; 
    
    static int func(int index , int target , int arr[] , int dp[][]){
        if(target == 0) return 1 ; 
        if(index == 0){
            if(arr[0] == target) return 1 ;
            else return 0 ; 
        }
        
        if(dp[index][target] != -1) return dp[index][target];
        int notpick = func(index-1 , target, arr, dp);
        int pick = 0 ;
        if(arr[index] <= target){
            pick = func(index -1 , target-arr[index] , arr, dp); 
        }
        return dp[index][target] = (pick + notpick)% mod ;
    }
    static int findTargetSumWays(int n, int[] arr ,int k) {
        int sum =  0; 
        for(int num : arr){
            sum += num ; 
        }
        if(sum - k < 0 || (sum - k) % 2 == 1) return 0; 
        int target = (sum - k )/2 ; 
        int dp[][] = new int[n][target+1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return func(n-1 , target , arr , dp) ;
    }
};