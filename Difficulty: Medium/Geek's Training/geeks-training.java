//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int func(int day , int last , int[][] arr , int dp[][]){
        if(day == 0){
            int max = 0 ;
            for(int task = 0 ; task < 3; task ++){
                if(task != last){
                    max = Math.max(max , arr[0][task]); 
                }
            }
            return max ; 
        }
        int max = 0 ; 
        if(dp[day][last] != -1) return dp[day][last]; 
        for(int task = 0 ; task < 3 ; task ++){
            if(task != last){
                int points = arr[day][task] + func(day - 1 , task , arr, dp) ; 
                max = Math.max(max , points); 
            }
        }
        return dp[day][last] = max ; 
    }
    public int maximumPoints(int arr[][]) {
        int n = arr.length ; 
        int dp[][] = new int[n][4] ; 
        for(int [] row : dp){
            Arrays.fill(row , -1) ; 
        }
       return func(n-1 , 3 , arr , dp); 
    }
}