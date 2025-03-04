//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int func(int index , int prevIdx , int arr[] , int dp[][]){
        if(index == arr.length) return 0; 
        
        if(dp[index][prevIdx+1] != -1) return dp[index][prevIdx+1]; 
        int notpick = func(index+1 , prevIdx , arr , dp);  
        int pick = 0 ;
        if(prevIdx == -1 || arr[index] > arr[prevIdx]){
            pick = 1 + func(index+1 , index , arr, dp) ; 
        }
        int len = Math.max(pick , notpick);
        return dp[index][prevIdx+1] =  len; 
    }
    static int lis(int arr[]) {
        int n = arr.length; 
        int dp[][] = new int[n][n+1];
        for(int i = 0 ;  i< n ; i++){
            Arrays.fill(dp[i] , -1); 
        }
        return func(0 , -1 , arr, dp) ; 
    }
}