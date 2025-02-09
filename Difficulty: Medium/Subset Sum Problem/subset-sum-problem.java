//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
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
    static boolean func(int index ,  int target , int arr[] , Boolean dp[][]){
        if(target == 0) return true ;
        if(index == 0){
            if(arr[index] == target){
                return true; 
            }
            else return false; 
        }
        if(dp[index][target] != null) return dp[index][target]; 
        
        boolean notPick = func(index - 1 ,target , arr , dp);
        boolean pick = false; 
        if(target >= arr[index]){
            pick = func(index - 1 , target - arr[index] , arr , dp ); 
        }
        return dp[index][target] = (pick || notPick); 
    }
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length; 
        Boolean dp[][] = new Boolean[n][target+1] ; 

        return func(n-1 , target ,arr , dp); 
    }
}