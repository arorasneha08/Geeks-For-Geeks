//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int func(int index , int arr[] , int dp[]){
        if(index >= arr.length) return 0; 
        if(dp[index] != -1) return dp[index]; 
        
        int one = func(index+1 , arr, dp) ;
        int two = func(index+2 , arr, dp); 
        return dp[index] = Math.min(one , two) + arr[index]; 
    }
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length; 
        int dp[] = new int[n] ; 
        Arrays.fill(dp , -1); 
        return Math.min(func(0 , cost , dp) , func(1 , cost , dp)) ; 
    }
};