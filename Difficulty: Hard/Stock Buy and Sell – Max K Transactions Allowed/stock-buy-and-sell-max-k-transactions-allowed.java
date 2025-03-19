//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int func(int index , int buy , int trans, int prices[] , int dp[][][]){
        if(index >= prices.length) return 0; 
        if(trans == 0) return 0 ; 
        int profit = 0 ; 
        
        if (dp[index][buy][trans] != -1) return dp[index][buy][trans];
        
        if(buy == 1){
            int take = func(index+1 , 0 , trans , prices , dp) - prices[index]; 
            int nottake = func(index+1 , 1 , trans , prices , dp); 
            profit = Math.max(take , nottake) ; 
        }
        else{
            int sell = func(index+1 , 1, trans-1 , prices , dp) + prices[index] ;
            int notsell = func(index+1 , 0 , trans , prices , dp ); 
            profit = Math.max(sell , notsell);
        }
        return dp[index][buy][trans] = profit; 
    }
    static int maxProfit(int prices[], int k) {
        int n = prices.length; 
        int dp[][][] = new int[n][2][k+1] ;
        for(int layer[][] : dp){
            for(int row[] : layer){
                Arrays.fill(row , -1) ;
            }
        }
        return func(0 , 1 , k ,prices , dp) ; 
    }
}