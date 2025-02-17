//{ Driver Code Starts
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

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int func(int index , int arr[] , int dp[]){
        if(index == 0) return dp[index] = arr[index] ; 
        int max = Integer.MIN_VALUE; 
        if(dp[index] != -1) return dp[index] ; 
        
        int pick = arr[index] ; 
        if(index >= 2){
            pick += func(index - 2, arr, dp);
        }
        int notpick = func(index -1 , arr, dp);
        max = Math.max(pick , notpick); 
        return dp[index] = max ; 
    }
    public int findMaxSum(int arr[]) {
        int n = arr.length ; 
        int dp[] = new int[n]; 
        // Arrays.fill(dp , -1) ;
        // return func(n-1 , arr, dp) ; 
        
        dp[0] = arr[0];
        
        for(int i = 1 ; i< n ; i++){
            int pick = arr[i] ;
            if(i >= 2){
                pick += dp[i-2] ; 
            }
            int notpick = dp[i-1]; 
            int max = Math.max(pick , notpick) ; 
            dp[i] = max ;
        }
        return dp[n-1]; 
    }
}