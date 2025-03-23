//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int func(int i ,int j ,  int arr[] ,  int dp[][]){
        if(i == j) return 0 ; 
        int mini = (int) 1e9  ; 
        if(dp[i][j] != -1) return dp[i][j] ; 
        for(int k = i ; k < j ;k++){
            int steps = arr[i-1] * arr[k] * arr[j] + func(i , k , arr, dp) + 
            func(k+1 , j, arr, dp); 
            mini = Math.min(mini , steps) ; 
        }
        return dp[i][j] = mini ; 
    }
    static int matrixMultiplication(int arr[]) {
        // int n = arr.length ; 
        // int dp[][] = new int[n][n];
        // for(int row[] : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // return func(1,n-1 , arr, dp); 
        
        // tabulation :- 
        int n = arr.length ; 
        int dp[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = 0 ; 
        }
        for(int i = n-1 ; i >= 1 ; i--){
            for(int j = i+1 ; j< n ; j++){
                int mini = (int) 1e9 ; 
                for(int k = i ; k< j ; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + 
                    dp[k+1][j]; 
                    mini = Math.min(mini , steps) ; 
                    dp[i][j] = mini ; 
                }
            }
        }
        return dp[1][n-1]; 
    }
}